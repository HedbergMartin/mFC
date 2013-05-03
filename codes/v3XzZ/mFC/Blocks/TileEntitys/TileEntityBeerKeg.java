package v3XzZ.mFC.Blocks.TileEntitys;

import v3XzZ.mFC.lib.Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

/**
 * Project: mFC
 * 
 * Class: TileEntityBeerKeg
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class TileEntityBeerKeg extends TileEntity implements IInventory, ISidedInventory
{
    /**
     * The ItemStacks that hold the items currently being used in the furnace
     */
    private ItemStack[] kegItemStack = new ItemStack[3];
    
    /** The number of ticks that the current item has been cooking for */
    public int timeWorked = 0;

    /** How many cups of beer inside the keg */
    public int Loads = 0;
    
    public int ID = 0;
    
	public int brewTime = 20000;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.kegItemStack.length;
    }
    
    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return this.kegItemStack[par1];
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.kegItemStack[par1] != null)
        {
            ItemStack var3;

            if (this.kegItemStack[par1].stackSize <= par2)
            {
                var3 = this.kegItemStack[par1];
                this.kegItemStack[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.kegItemStack[par1].splitStack(par2);

                if (this.kegItemStack[par1].stackSize == 0)
                {
                    this.kegItemStack[par1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.kegItemStack[par1] != null)
        {
            ItemStack var2 = this.kegItemStack[par1];
            this.kegItemStack[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.kegItemStack[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "BeerKeg";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.kegItemStack = new ItemStack[this.getSizeInventory()];
        Loads = par1NBTTagCompound.getInteger("Load");
        ID = par1NBTTagCompound.getInteger("ID");
        
        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.kegItemStack.length)
            {
                this.kegItemStack[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.timeWorked = par1NBTTagCompound.getShort("CookTime");
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("CookTime", (short)this.timeWorked);
        NBTTagList var2 = new NBTTagList();
        par1NBTTagCompound.setInteger("Load", this.Loads);
        par1NBTTagCompound.setInteger("ID", this.ID);

        for (int var3 = 0; var3 < this.kegItemStack.length; ++var3)
        {
            if (this.kegItemStack[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.kegItemStack[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", var2);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 1;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    public int getCookProgressScaled(int par1)
    {
        return this.timeWorked * par1 / brewTime;
    }
    
    public boolean isLoaded()
    {
        return this.Loads > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        boolean var2 = false;

        if (!this.worldObj.isRemote)
        {
            if (this.canSmelt() && !this.isLoaded())
            {
                ++this.timeWorked;
                if (this.timeWorked == brewTime)
                {
                	Loads = 24;
                    this.timeWorked = 0;
                    if(this.kegItemStack[0] != null && this.kegItemStack[0].getItem().itemID == Items.redWineBase.itemID){
                    	this.kegItemStack[0] = null;
                    	this.ID = 1;
                    }else if(this.kegItemStack[0] != null && this.kegItemStack[0].getItem().itemID == Items.whiteWineBase.itemID){
                    	this.kegItemStack[0] = null;
                    	this.ID = 2;
                    } else if(this.kegItemStack[0] != null && this.kegItemStack[0].getItem().itemID == Items.beerBase.itemID){
                    	this.kegItemStack[0] = null;
                    	this.ID = 3;
                    } else if(this.kegItemStack[0] != null && this.kegItemStack[0].getItem().itemID == Items.christmasMustBase.itemID){
                    	this.kegItemStack[0] = null;
                    	this.ID = 4;
                    }
                    var2 = true;
                }
            }
            else
            {
                this.timeWorked = 0;
            }
        }

        if (var2)
        {
            this.onInventoryChanged();
        }
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (this.kegItemStack[0] == null)
        {
            return false;
        }
        else
        {
            if(this.kegItemStack[0].getItem().itemID == Items.redWineBase.itemID){
            	return true;
            }else if(this.kegItemStack[0].getItem().itemID == Items.whiteWineBase.itemID){
            	return true;
            }else if(this.kegItemStack[0].getItem().itemID == Items.beerBase.itemID){
            	return true;
            }else if(this.kegItemStack[0].getItem().itemID == Items.christmasMustBase.itemID){
            	return true;
            }else{
            	return false;
            }
        }
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openChest() {}

    public void closeChest() {}

	public int getMeterScaled(int i) {
		return this.Loads;
	}
	public int getID() {
		return this.ID;
	}

	@Override
    public int getStartInventorySide(ForgeDirection side)
    {
        return 0;
    }

    @Override
    public int getSizeInventorySide(ForgeDirection side)
    {
        return 1;
    }

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}
}
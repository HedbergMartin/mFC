package v3XzZ.mFC.blocks.tileentity;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import v3XzZ.mFC.mFC;
import v3XzZ.mFC.lib.CommonIds;
import v3XzZ.util.DataWriter;

/**
 * Project: mFC
 * 
 * Class: TileEntityBeerKeg
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class TileEntityBarrel extends TileEntity implements IInventory, ISidedInventory
{
    /**
     * The ItemStacks that hold the items currently being used in the furnace
     */
    public ItemStack[] content = new ItemStack[1];
    
    public boolean isOpen = false;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.content.length;
    }
    
    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return this.content[par1];
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.content[par1] != null)
        {
            ItemStack var3;

            if (this.content[par1].stackSize <= par2)
            {
                var3 = this.content[par1];
                this.content[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.content[par1].splitStack(par2);

                if (this.content[par1].stackSize == 0)
                {
                    this.content[par1] = null;
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
        if (this.content[par1] != null)
        {
            ItemStack var2 = this.content[par1];
            this.content[par1] = null;
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
        this.content[par1] = par2ItemStack;

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
        this.content = new ItemStack[this.getSizeInventory()];
        this.isOpen = par1NBTTagCompound.getBoolean("state");
        
        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.content.length)
            {
                this.content[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        NBTTagList var2 = new NBTTagList();
        par1NBTTagCompound.setBoolean("state", this.isOpen);

        for (int var3 = 0; var3 < this.content.length; ++var3)
        {
            if (this.content[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.content[var3].writeToNBT(var4);
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
    
    public void sendBarrelData(){
    	DataWriter data = new DataWriter();
    	data.addByte(CommonIds.PACKET_BARREL);
    	data.addInt(xCoord);
    	data.addInt(yCoord);
    	data.addInt(zCoord);
    	data.addBoolean(isOpen);
    	if(content[0] == null){
    		data.addBoolean(false);
    	}else{
        	data.addBoolean(true);
        	data.addInt(content[0].itemID);
        	data.addInt(content[0].stackSize);
        	data.addInt(content[0].getItemDamage());
    	}
    	mFC.proxy.packetcrafter.sendPacketToAllPlayers(mFC.proxy.packetcrafter.createToClientPacket(data.finalizeData()), Side.SERVER);
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
			sendBarrelData();
        }

        if (var2)
        {
            this.onInventoryChanged();
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

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return null;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
}
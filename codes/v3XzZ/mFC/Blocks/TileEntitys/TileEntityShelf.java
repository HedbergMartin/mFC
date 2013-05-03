package v3XzZ.mFC.Blocks.TileEntitys;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import v3XzZ.mFC.mFC;
import v3XzZ.util.DataWriter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;

/**
 * Project: mFC
 * 
 * Class: TileEntityShelf
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class TileEntityShelf extends TileEntity implements IInventory, ISidedInventory {

	public ItemStack[] items = new ItemStack[8];
	int[] prevItem = new int[8];
	
	@Override
	public void updateEntity() {
		this.closeChest();
		super.updateEntity();
	}
	
	/**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.items.length;
    }
    
    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return this.items[par1];
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.items[par1] = par2ItemStack;

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
        return "Shelf";
    }
	
	/**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.items = new ItemStack[this.getSizeInventory()];
        
        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.items.length)
            {
                this.items[var5] = ItemStack.loadItemStackFromNBT(var4);
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

        for (int var3 = 0; var3 < this.items.length; ++var3)
        {
            if (this.items[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.items[var3].writeToNBT(var4);
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
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.items[par1] != null)
        {
            ItemStack var3;

            if (this.items[par1].stackSize <= par2)
            {
                var3 = this.items[par1];
                this.items[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.items[par1].splitStack(par2);

                if (this.items[par1].stackSize == 0)
                {
                    this.items[par1] = null;
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
        if (this.items[par1] != null)
        {
            ItemStack var2 = this.items[par1];
            this.items[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

	/**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		DataWriter data = new DataWriter();
		data.addByte((byte)1);
		for(int t = 0; t < this.getSizeInventory(); t++){
			if(items[t] != null){
				data.addInt(items[t].itemID);
				data.addInt(items[t].getItemDamage());
			}else{
				data.addInt(0);
				data.addInt(0);
			}
		}
		data.addInt(this.xCoord);
		data.addInt(this.yCoord);
		data.addInt(this.zCoord);
		
		mFC.proxy.packetcrafter.sendPacketToAllPlayers(mFC.proxy.packetcrafter.createToClientPacket(data.finalizeData()), Side.SERVER);
		
		
	}

	@Override
	public int getStartInventorySide(ForgeDirection side) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getSizeInventorySide(ForgeDirection side) {
		// TODO Auto-generated method stub
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

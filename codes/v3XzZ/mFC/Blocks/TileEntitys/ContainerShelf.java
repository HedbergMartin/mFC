package v3XzZ.mFC.Blocks.TileEntitys;

import v3XzZ.mFC.mFC;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Project: mFC
 * 
 * Class: ContainerShelf
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ContainerShelf extends Container
{
    private TileEntityShelf tileShelf;

    public ContainerShelf(InventoryPlayer par1InventoryPlayer, TileEntityShelf shelf)
    {
        this.tileShelf = shelf;
        for(int s1 = 0; s1 < 4; s1++){
            this.addSlotToContainer(new SlotShelf(shelf, 0+s1, 43+(s1*21), 16));
        }
        for(int s2 = 0; s2 < 4; s2++){
            this.addSlotToContainer(new SlotShelf(shelf, 4+s2, 52+(s2*21), 36));
        }
        for (int var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 79 + var3 * 18));
            }
        }

        for (int var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 137));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
    	return this.tileShelf.isUseableByPlayer(par1EntityPlayer);
    }
    
    @Override
    public void onCraftGuiClosed(EntityPlayer par1EntityPlayer) {
    	super.onCraftGuiClosed(par1EntityPlayer);
    	this.tileShelf.closeChest();
    }

    @Override
    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
    public ItemStack transferStackInSlot(EntityPlayer entityplayer, int par1)
    {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.inventorySlots.get(par1);

        if (var3 != null && var3.getHasStack())
        {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();
            if(mFC.shelfItems.contains(Item.itemsList[var4.itemID])) {
	            if (par1 == 2)
	            {
	                if (!this.mergeItemStack(var4, 0, 39, true))
	                {
	                    return null;
	                }
	
	                var3.onSlotChange(var4, var2);
	            }
	            else if (par1 >= 0 && par1 < 30)
	            {
	                if (!this.mergeItemStack(var4, 30, 39, false))
	                {
	                    return null;
	                }
	            }
	            else if (par1 >= 30 && par1 < 39)
	            {
	                if (!this.mergeItemStack(var4, 0, 30, false))
	                {
	                    return null;
	                }
	            }
	            else if (!this.mergeItemStack(var4, 0, 39, false))
	            {
	                return null;
	            }
            }
            if (var4.stackSize == 0)
            {
                var3.putStack((ItemStack)null);
            }
            else
            {
                var3.onSlotChanged();
            }

            if (var4.stackSize == var2.stackSize)
            {
                return null;
            }
            var3.onPickupFromSlot(entityplayer, var4);
        }
        return var2;
    }
}
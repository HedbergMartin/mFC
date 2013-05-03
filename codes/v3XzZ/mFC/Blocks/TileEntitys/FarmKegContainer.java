package v3XzZ.mFC.Blocks.TileEntitys;

import v3XzZ.mFC.lib.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FarmKegContainer extends Container
{
    private TileEntityBeerKeg keg;
    private int lastCookTime = 0;
    private int lastBrewTime = 0;
    private int lastID = 6;

    public FarmKegContainer(InventoryPlayer par1InventoryPlayer, TileEntityBeerKeg BeerKeg)
    {
        this.keg = BeerKeg;
        this.addSlotToContainer(new Slot(BeerKeg, 0, 56, 35));
        int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
        }
    }
    
    @Override
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.keg.timeWorked);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.keg.Loads);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.keg.ID);
    }
    
    

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int var1 = 0; var1 < this.crafters.size(); ++var1)
        {
            ICrafting var2 = (ICrafting)this.crafters.get(var1);

            if (this.lastCookTime != this.keg.timeWorked)
            {
                var2.sendProgressBarUpdate(this, 0, this.keg.timeWorked);
            }
            if (this.lastBrewTime != this.keg.Loads)
            {
                var2.sendProgressBarUpdate(this, 1, this.keg.Loads);
            }
            if (this.lastID != this.keg.ID)
            {
            	var2.sendProgressBarUpdate(this, 2, this.keg.ID);
            }
        }

        this.lastCookTime = this.keg.timeWorked;
        this.lastBrewTime = this.keg.Loads;
        this.lastID = this.keg.ID;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.keg.timeWorked = par2;
        }

        if (par1 == 1)
        {
            this.keg.Loads = par2;
        }
        
        if (par1 == 2)
        {
            this.keg.ID = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
    	ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.itemID == Items.beerCup.itemID && this.keg.isLoaded() && this.keg.ID == 3)
        {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(Items.beer));
            this.keg.Loads--;
            return false;
        }else if (var2 != null && var2.itemID == Items.tallBottle.itemID && this.keg.isLoaded() && this.keg.ID == 1)
        {
        	if(var2.stackSize > 1){
        		var2.stackSize--;
            	par1EntityPlayer.dropItem(Items.redWine.itemID, 1);
        	}else{
        		par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(Items.redWine));
        	}
            this.keg.Loads-=2;
            return false;
        }else if (var2 != null && var2.itemID == Items.tallBottle.itemID && this.keg.isLoaded() && this.keg.ID == 2)
        {
        	if(var2.stackSize > 1){
        		var2.stackSize--;
            	par1EntityPlayer.dropItem(Items.whiteWine.itemID, 1);
        	}else{
                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(Items.whiteWine));
        	}
            this.keg.Loads-=2;
            return false;
        }
        else if (var2 != null && var2.itemID == Items.tallBottle.itemID && this.keg.isLoaded() && this.keg.ID == 4)
        {
        	if(var2.stackSize > 1){
        		var2.stackSize--;
            	par1EntityPlayer.dropItem(Items.christmasMust.itemID, 1);
        	}else{
                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(Items.christmasMust));
        	}
            this.keg.Loads-=2;
            return false;
        }else
        {
            return this.keg.isUseableByPlayer(par1EntityPlayer);
        }
    }

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

            if (par1 == 2)
            {
                if (!this.mergeItemStack(var4, 3, 39, true))
                {
                    return null;
                }

                var3.onSlotChange(var4, var2);
            }
            else if (par1 >= 3 && par1 < 30)
            {
                if (!this.mergeItemStack(var4, 30, 39, false))
                {
                    return null;
                }
            }
            else if (par1 >= 30 && par1 < 39)
            {
                if (!this.mergeItemStack(var4, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var4, 3, 39, false))
            {
                return null;
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
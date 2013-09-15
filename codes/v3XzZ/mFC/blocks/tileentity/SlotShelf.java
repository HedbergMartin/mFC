package v3XzZ.mFC.blocks.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import v3XzZ.mFC.api.ApiCommon;

/**
 * Project: mFC
 * 
 * Class: SlotShelf
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SlotShelf extends Slot {

	public SlotShelf(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		if(ApiCommon.shelfItems.contains(Item.itemsList[par1ItemStack.itemID])){
			return true;
		}
		return false;
	}

}

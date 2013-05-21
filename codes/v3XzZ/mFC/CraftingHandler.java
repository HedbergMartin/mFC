package v3XzZ.mFC;
import v3XzZ.mFC.lib.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler implements ICraftingHandler {
	
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
		for(int i=0; i < craftMatrix.getSizeInventory(); i++) {               
			if(craftMatrix.getStackInSlot(i) != null) {
			ItemStack j = craftMatrix.getStackInSlot(i);
				if(j.getItem() != null && j.getItem() == Items.Knife) {
			         ItemStack k = new ItemStack(Items.Knife, 2, (j.getItemDamage() + 1));
			         if(k.getItemDamage() >= k.getMaxDamage()) { 
			        	 k.stackSize--;
			         }
			         craftMatrix.setInventorySlotContents(i, k);
				}
			}
		}
	}
	
	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		
	}
}
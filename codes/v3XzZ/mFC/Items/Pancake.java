package v3XzZ.mFC.Items;

import java.util.List;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Pancake extends FarmFood {

	public Pancake(int i, int j, int k) {
		super(i, j, k);
        this.setHasSubtypes(true);
	}
	
	public String getItemDisplayName(ItemStack par1ItemStack)
    {
        if(par1ItemStack.getItemDamage() == 0){
        	return "Strawberry Pancakes";
        }else if(par1ItemStack.getItemDamage() == 1){
        	return "Raspberry Pancakes";
        }
        return "";
    }

	@SideOnly(Side.CLIENT)

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
    }
}
package v3XzZ.mFC.Items;

import v3XzZ.mFC.lib.Items;
import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: FarmCup
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FarmCup extends ItemFood {

	public FarmCup(int i, int j) {
		super(i, j, false);
		if (this.getItemStackLimit()<3) maxStackSize=3;
	}
	
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
    	if (itemstack.stackSize>1) return itemstack;
        	
        super.onFoodEaten(itemstack, world, entityplayer);
        return new ItemStack(Items.cup);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister) {
    	this.iconIndex = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}
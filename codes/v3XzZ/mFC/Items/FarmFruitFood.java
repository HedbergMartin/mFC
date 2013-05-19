package v3XzZ.mFC.Items;

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
 * Class: FarmFruitFood
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FarmFruitFood extends ItemFood {

	private int drop;
	public FarmFruitFood(int i, int j, float saturation, int drop) {
		super(i, j, saturation, false);
		maxStackSize=16;
		this.drop = drop;
	}
	
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {	
        super.onEaten(itemstack, world, entityplayer);
        if(world.rand.nextInt(3) == 2){
            entityplayer.dropPlayerItem(new ItemStack(drop, 1, 0));
        }
        return itemstack;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.itemIcon = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}
package v3XzZ.mFC.items;

import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: FarmPum
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FarmPum extends ItemFood {

	public FarmPum(int i, int j) {
		super(i, j, false);
		maxStackSize=64;
	}
	
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {	
        super.onEaten(itemstack, world, entityplayer);
        entityplayer.dropPlayerItem(new ItemStack(Item.pumpkinSeeds.itemID, 1, 0));
        return itemstack;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.itemIcon = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}
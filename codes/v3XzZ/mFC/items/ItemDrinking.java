package v3XzZ.mFC.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import v3XzZ.mFC.api.ItemThirst;
import v3XzZ.mFC.lib.Items;
import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: ItemDrinking
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ItemDrinking extends ItemThirst {
	
	public ItemDrinking(int i, int j) {
		super(i, j);
	}

	public ItemDrinking(int i, int j, float k) {
		super(i, j, k);
		maxStackSize=1;
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {	
        super.onEaten(itemstack, world, entityplayer);
        return new ItemStack(Items.drinkingGlass);
    }
    
    @Override
    public Item setContainerItem(Item par1Item) {
    	return super.setContainerItem(Items.drinkingGlass);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.itemIcon = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}
package v3XzZ.mFC.Items;

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
 * Class: BowlFood
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BowlFood extends ItemFood
{

    public BowlFood(int i, int j)
    {
        super(i, j, false);
        setMaxStackSize(1);
    }

    public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        super.onFoodEaten(itemstack, world, entityplayer);
        return new ItemStack(Item.bowlEmpty);
    }
    
    @Override
    public Item setContainerItem(Item par1Item) {
    	return Item.bowlEmpty;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister) {
    	this.iconIndex = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}

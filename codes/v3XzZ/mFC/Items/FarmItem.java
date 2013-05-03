package v3XzZ.mFC.Items;

import v3XzZ.mFC.lib.Items;
import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: FarmItem
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FarmItem extends Item {

	public FarmItem(int i) {
		super(i);
        this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        MovingObjectPosition var4 = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);

        if (var4 == null)
        {
            return par1ItemStack;
        }
        else if(par3EntityPlayer.inventory.getCurrentItem().itemID == Items.drinkingGlass.itemID)
        {
            if (var4.typeOfHit == EnumMovingObjectType.TILE)
            {
                int var5 = var4.blockX;
                int var6 = var4.blockY;
                int var7 = var4.blockZ;

                if (!par2World.canMineBlock(par3EntityPlayer, var5, var6, var7))
                {
                    return par1ItemStack;
                }

                if (!par3EntityPlayer.canPlayerEdit(var5, var6, var7, var4.sideHit, par1ItemStack))
                {
                    return par1ItemStack;
                }

                if (par2World.getBlockMaterial(var5, var6, var7) == Material.water)
                {
                	if(par1ItemStack.stackSize != 1){
                        --par1ItemStack.stackSize;
                		par3EntityPlayer.dropItem(Items.glassWater.itemID, 1);
                	}else {
                        return new ItemStack(Items.glassWater);
                	}
                }
            }

            return par1ItemStack;
        }else{
        	return par1ItemStack;
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister) {
    	if(this.getUnlocalizedName().endsWith("Base")){
    		this.iconIndex = par1IconRegister.registerIcon("mFC:breawingBase");
    	}else {
        	this.iconIndex = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    	}
    }
}

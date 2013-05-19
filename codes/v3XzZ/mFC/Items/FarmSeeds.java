package v3XzZ.mFC.Items;

import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: FarmSeeds
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FarmSeeds extends Item
{
	private int ID;

    public FarmSeeds(int i, int j)
    {
        super(i);
        blockType = j;
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    public FarmSeeds(int i, int j, int k)
    {
        super(i);
        blockType = j;
        ID = k;
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
    
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int par7, float par8, float par9, float par10)
    {
    	boolean waterlol = false;
    	if (world.getBlockId(i + 1, j, k) == Block.waterMoving.blockID && world.getBlockId(i - 1, j, k) == Block.waterMoving.blockID){
    		waterlol = true;
    	}
    	if (world.getBlockId(i + 1, j, k) == Block.waterStill.blockID && world.getBlockId(i - 1, j, k) == Block.waterStill.blockID){
    		waterlol = true;
    	}
    	if (world.getBlockId(i, j, k + 1) == Block.waterMoving.blockID && world.getBlockId(i, j, k - 1) == Block.waterMoving.blockID){
    		waterlol = true;
    	}
    	if (world.getBlockId(i, j, k + 1) == Block.waterStill.blockID && world.getBlockId(i, j, k - 1) == Block.waterStill.blockID){
    		waterlol = true;
    	}
        if(par7 != 1)
        {
            return false;
        }
        if(entityplayer!=null && (!entityplayer.canPlayerEdit(i, j, k, par7, itemstack) || !entityplayer.canPlayerEdit(i, j + 1, k, par7, itemstack)))
        {
            return false;
        }
        int i1 = world.getBlockId(i, j, k);
        if(ID == 1){
        	if(i1 == Block.blockClay.blockID && world.isAirBlock(i, j + 1, k) && waterlol == true)
            {
                world.setBlock(i, j + 1, k, blockType);
                itemstack.stackSize--;
                return true;
            }
        }else if(i1 == Block.tilledField.blockID && world.isAirBlock(i, j + 1, k)) {
            world.setBlock(i, j + 1, k, blockType);
            itemstack.stackSize--;
            return true;
        }
		return false;
    }

    private int blockType;
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.itemIcon = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}

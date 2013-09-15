package v3XzZ.mFC.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import v3XzZ.mFC.mFC;
import v3XzZ.mFC.lib.Items;
import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: FarmCheese
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FarmCheese extends Block
{
	protected World world;

	public FarmCheese(int i, int j)
    {
        super(i, Material.cake);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return super.getCollisionBoundingBoxFromPool(world, i, j, k);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
    public int getRenderType()
    {
    return mFC.RenderID;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
    }

    @SuppressWarnings("rawtypes")
	public void addCollisionBoxesToList(World par1World, int i, int j, int k, AxisAlignedBB par5AxisAlignedBB, List arraylist, Entity par7Entity)
    {
        int l = par1World.getBlockMetadata(i, j, k);
        if (l == 0)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arraylist, par7Entity);
        }
        else if (l == 1)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arraylist, par7Entity);
            setBlockBounds(0.5F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arraylist, par7Entity);
        }
        else if (l == 2)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arraylist, par7Entity);
        }
        else if (l == 3)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F);
            super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arraylist, par7Entity);
        }
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    }
    public int idDropped(int i, Random random, int j)
    {
    	if(i == 0){
            return Items.cheeseWheel.itemID;
    	}else
        return -1;
    }
    
    @Override
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
    {
	        int l = world.getBlockMetadata(i, j, k);
	        int i1 = 0;
	        int j1 = 0;
	        double d = (double)i + (double)i1 * 0.59999999999999998D + 0.5D;
	        double d1 = (double)j + 0.5D;
	        double d2 = (double)k + (double)j1 * 0.59999999999999998D + 0.5D;
			EntityItem item = new EntityItem(world, d, d1, d2, new ItemStack(Items.cheesePiece));
	    	ItemStack itemstack = entityplayer.inventory.getCurrentItem();
	        if(itemstack != null && itemstack.itemID == Items.Knife.itemID)
	        {
	        	if(l == 3){
	        		world.setBlock(i, j, k, 0);
	            	if(!world.isRemote){
	            		world.spawnEntityInWorld(item);
	            	}
	                world.markBlockForRenderUpdate(i, j, k);
	        	}
	        	else{
	        		world.setBlockMetadataWithNotify(i, j, k, world.getBlockMetadata(i, j, k) + 1, 2);
	            	if(!world.isRemote){
	            		world.spawnEntityInWorld(item);
	            	}
	                world.markBlockForRenderUpdate(i, j, k);
	        	}
	        	
	            return true;
	        }
        return false;
    }
    
    @Override
    public int idPicked(World par1World, int par2, int par3, int par4) {
    	return Items.cheeseWheel.itemID;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.blockIcon = par1IconRegister.registerIcon("mFC:" + Common.getItemName(this.getUnlocalizedName()));
    }
}
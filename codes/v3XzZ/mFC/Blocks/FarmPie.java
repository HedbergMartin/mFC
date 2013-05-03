package v3XzZ.mFC.Blocks;

import java.util.Random;

import v3XzZ.util.Common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, World, 
//            AxisAlignedBB, EntityPlayer, FoodStats

public class FarmPie extends Block
{
	private Icon[] iconArray;
	
	public FarmPie(int i)
    {
        super(i, Material.cake);
        setTickRandomly(true);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.getBlockMetadata(i, j, k);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16F;
        float f2 = 0.5F;
        setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
    }

    public void setBlockBoundsForItemRender()
    {
        float f = 0.0625F;
        float f1 = 0.5F;
        setBlockBounds(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16F;
        float f2 = 0.5F;
        return AxisAlignedBB.getBoundingBox((float)i + f1, j, (float)k + f, (float)(i + 1) - f, ((float)j + f2) - f, (float)(k + 1) - f);
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16F;
        float f2 = 0.5F;
        return AxisAlignedBB.getBoundingBox((float)i + f1, j, (float)k + f, (float)(i + 1) - f, (float)j + f2, (float)(k + 1) - f);
    }

    public Icon getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 1)
        {
            return this.iconArray[0];
        }
        if(i == 0)
        {
        	return this.iconArray[3];
        }
        if(j > 0 && i == 4)
        {
        	return this.iconArray[2];
        } else
        {
        	return this.iconArray[1];
        }
    }

    public Icon getBlockTexture(int i)
    {
        if(i == 1)
        {
        	return this.iconArray[0];
        }
        if(i == 0)
        {
        	return this.iconArray[3];
        } else
        {
        	return this.iconArray[1];
        }
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        eatCakeSlice(world, i, j, k, entityplayer);
        return true;
    }

    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        eatCakeSlice(world, i, j, k, entityplayer);
    }

    private void eatCakeSlice(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(entityplayer.canEat(false))
        {
            entityplayer.getFoodStats().addStats(5, 0.1F);
            int l = world.getBlockMetadata(i, j, k) + 1;
            if(l >= 6)
            {
                world.setBlock(i, j, k, 0);
            } else
            {
                world.setBlockMetadataWithNotify(i, j, k, l, 2);
                world.markBlockForRenderUpdate(i, j, k);
            }
        }
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        if(!super.canPlaceBlockAt(world, i, j, k))
        {
            return false;
        } else
        {
            return canBlockStay(world, i, j, k);
        }
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        if(!canBlockStay(world, i, j, k))
        {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), l);
            world.setBlock(i, j, k, 0);
        }
    }

    public boolean canBlockStay(World world, int i, int j, int k)
    {
        return world.getBlockMaterial(i, j - 1, k).isSolid();
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public int idDropped(int i, Random random, int j)
    {
        return 0;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister) {
    	this.iconArray = new Icon[4];
    	
		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("mFC:" + Common.getItemName(this.getUnlocalizedName()) + "_" + i);
		}
	}
}

package v3XzZ.mFC.Blocks;

import java.util.Random;

import v3XzZ.mFC.lib.Items;
import v3XzZ.util.Common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: FarmSalt
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FarmSalt extends Block
{
	public FarmSalt(int i)
    {
        super(i, Material.plants);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.02F, 1.0F);
    }
    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        super.onNeighborBlockChange(world, i, j, k, l);
        checkSand(world, i, j, k);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
    	checkSand(world, i, j, k);
    }

    protected final void checkSand(World world, int i, int j, int k)
    {
        if(!canBlockStay(world, i, j, k))
        {
            world.setBlock(i, j, k, 0);
        }
    }

    public boolean canBlockStay(World world, int i, int j, int k)
    {
    	int l = world.getBlockId(i, j - 1, k);
    	if(l == Block.sand.blockID){
        return true;
    	}
    	else{
    		return false;
    	}
    }

    public int idDropped(int i, Random random, int j)
    {
    	return Items.saltPile.itemID;
    }
    public int quantityDropped(Random random)
    {
        return 1+random.nextInt(3);
    }
    

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.blockIcon = par1IconRegister.registerIcon("mFC:" + Common.getItemName(this.getUnlocalizedName()));
    }
}
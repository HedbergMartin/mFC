package v3XzZ.mFC.Blocks;

import java.util.Random;

import v3XzZ.mFC.lib.Blocks;
import v3XzZ.mFC.lib.Items;
import v3XzZ.mFC.worldgen.FarmFruitTree;
import v3XzZ.util.Common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: FruitSaplings
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FruitSaplings extends BlockFlower
{
	@SideOnly(Side.CLIENT)
	public Icon[]	iconArray;
	
	public FruitSaplings(int i)
    {
        super(i, Material.plants);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab((CreativeTabs)null);
    }
    
    public void updateTick(World world, int i, int j, int k, Random random)
    {
    	if(!world.isRemote){
        super.updateTick(world, i, j, k, random);
	        if(world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(7) == 0)
	        {
	            if(random.nextInt(7) == 0)
	            {
	            	growTree(world, i, j, k, random);
	            }
	        }
    	}
    }
    
    public Icon getIcon(int i, int j)
    {
    	if (j == 2)
        {
    		return this.iconArray[2];
        }
        if (j == 3)
        {
    		return this.iconArray[0];
        }
        if (j == 4)
        {
    		return this.iconArray[3];
        }
        return this.iconArray[1];
    }

    public boolean growTree(World world, int i, int j, int k, Random random)
    {
    	int mete = world.getBlockMetadata(i, j, k);
		FarmFruitTree farmfruittree = new FarmFruitTree();
    	if (mete == 1){
    		world.setBlock(i, j, k, 0, 0, 2);
    		if(!(farmfruittree).generate(world, random, i, j, k, Blocks.appleBlock.blockID, 0))
    		{
    			world.setBlock(i, j, k, this.blockID, 1, 2);
    		}else{
                return true;
    		}
    	}
    	else if (mete == 2){
    		world.setBlock(i, j, k, 0, 0, 2);
    		if(!(farmfruittree).generate(world, random, i, j, k, Blocks.orangeBlock.blockID, 1))
    		{
    			world.setBlock(i, j, k, this.blockID, 2, 2);
    		}else{
                return true;
    		}
    	}
    	else if (mete == 3){
    		world.setBlock(i, j, k, 0, 0, 2);
    		if(!(farmfruittree).generate(world, random, i, j, k, Blocks.avacadoBlock.blockID, 2))
    		{
    			world.setBlock(i, j, k, this.blockID, 3, 2);
    		}else{
                return true;
    		}
    	}
    	else if (mete == 4){
    		world.setBlockMetadataWithNotify(i, j, k, 0, 0);
    		if(!(farmfruittree).generate(world, random, i, j, k, Blocks.cocoaBlock.blockID, 3))
    		{
    			world.setBlock(i, j, k, this.blockID, 4, 2);
    		}else{
                return true;
    		}
    	}
        return false;
    }
    
    public int idDropped(int i, Random random, int j)
    {
    	switch(i){
    	case 1: return Items.AppleSeeds.itemID;
    	case 2: return Items.OrangeSeeds.itemID;
    	case 3: return Items.AvacadoSeeds.itemID;
    	case 4: return Items.CocoaFruit.itemID;
    	}
		return -1;
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
package v3XzZ.mFC.Blocks;

import java.util.Random;

import v3XzZ.mFC.lib.Blocks;
import v3XzZ.mFC.lib.Items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: CropCorn
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class CropCorn extends CropTemplate {
	
	public CropCorn(int i)
    {
        super(i, Material.plants);
        this.iconArray = this.registerArray(8);
        setTickRandomly(true);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        this.enableStats = false;
        this.setCreativeTab((CreativeTabs)null);
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == Block.tilledField.blockID || i == Blocks.cornPlant.blockID;
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);
            int var8 = par1World.getBlockMetadata(par2, par3+1, par4);
            float var7 = this.getGrowthRate(par1World, par2, par3, par4);
            if (var6 < 4)
            {
            	if (par5Random.nextInt((int)(25.0F / var7) + 1) == 0)
                {
                    ++var6;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6, 2);
                }
            }
            if (var6 > 3){
            	if(var6 == 4 && par1World.getBlockId(par2, par3+1, par4) == 0 && par5Random.nextInt((int)(25.0F / var7) + 1) == 0){
            		par1World.setBlockMetadataWithNotify(par2, par3+1, par4, 5, 2);
            	} else if(var8 < 7 && par5Random.nextInt((int)(25.0F / var7) + 1) == 0) {
            		++var8;
                    par1World.setBlockMetadataWithNotify(par2, par3+1, par4, var8, 2);
            	}
            }
        }
    }
    
    public boolean fertilize(World par1World, int par2, int par3, int par4) {
    	if(!par1World.isRemote){
    		if(par1World.getBlockId(par2, par3+1, par4) == 0){
        		int randomGrowth = 1+par1World.rand.nextInt(3);
            	if(par1World.getBlockMetadata(par2, par3, par4)+randomGrowth >= 7){
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
                    par1World.setBlock(par2, par3+1, par4, Blocks.cornPlant.blockID, 7, 2);
            	}else if (par1World.getBlockMetadata(par2, par3, par4)+randomGrowth > 4){
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
                    par1World.setBlock(par2, par3+1, par4, Blocks.cornPlant.blockID, par1World.getBlockMetadata(par2, par3, par4)+randomGrowth, 2);
            	}else {
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4)+randomGrowth, 2);
            	}
            	return true;
    		}else if(par1World.getBlockMetadata(par2, par3+1, par4) != 7) {
    			par1World.setBlock(par2, par3+1, par4, Blocks.cornPlant.blockID, 7, 2);
            	return true;
    		}
    	}
		return false;
    }

    private float getGrowthRate(World par1World, int par2, int par3, int par4)
    {
        float var5 = 1.0F;
        int var6 = par1World.getBlockId(par2, par3, par4 - 1);
        int var7 = par1World.getBlockId(par2, par3, par4 + 1);
        int var8 = par1World.getBlockId(par2 - 1, par3, par4);
        int var9 = par1World.getBlockId(par2 + 1, par3, par4);
        int var10 = par1World.getBlockId(par2 - 1, par3, par4 - 1);
        int var11 = par1World.getBlockId(par2 + 1, par3, par4 - 1);
        int var12 = par1World.getBlockId(par2 + 1, par3, par4 + 1);
        int var13 = par1World.getBlockId(par2 - 1, par3, par4 + 1);
        boolean var14 = var8 == this.blockID || var9 == this.blockID;
        boolean var15 = var6 == this.blockID || var7 == this.blockID;
        boolean var16 = var10 == this.blockID || var11 == this.blockID || var12 == this.blockID || var13 == this.blockID;

        for (int var17 = par2 - 1; var17 <= par2 + 1; ++var17)
        {
            for (int var18 = par4 - 1; var18 <= par4 + 1; ++var18)
            {
                int var19 = par1World.getBlockId(var17, par3 - 1, var18);
                float var20 = 0.0F;

                if (var19 == Block.tilledField.blockID || var19 == Blocks.cornPlant.blockID)
                {
                    var20 = 1.0F;

                    if (par1World.getBlockMetadata(var17, par3 - 1, var18) > 0)
                    {
                        var20 = 3.0F;
                    }
                }

                if (var17 != par2 || var18 != par4)
                {
                    var20 /= 4.0F;
                }

                var5 += var20;
            }
        }

        if (var16 || var14 && var15)
        {
            var5 /= 2.0F;
        }

        return var5;
    }

    public int getRenderType()
    {
        return 6;
    }
    
    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1)
    {
        super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
        if(world.isRemote)
        {
            return;
        }
        if(l <= 4){
            for(int i2 = 0; i2 < 3; i2++)
            {
                if(world.rand.nextInt(10) <= l)
                {
                    float f1 = 0.7F;
                    float f2 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                    float f3 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                    float f4 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                    EntityItem entityitem = new EntityItem(world, (float)i + f2, (float)j + f3, (float)k + f4, new ItemStack(Items.cornSeeds));
                    entityitem.delayBeforeCanPickup = 10;
                    world.spawnEntityInWorld(entityitem);
                }
            }
        }
    }

    public int idDropped(int i, Random random, int j)
    {
        if(i == 7)
        {
            return Items.cornCob.itemID;
        } else
        {
            return -1;
        }
    }
    

    public int quantityDropped(Random random)
    {
        return 1+random.nextInt(2);
    }
    
	@Override
	public int idPicked(World par1World, int par2, int par3, int par4) {
		return Items.cornSeeds.itemID;
	}
}
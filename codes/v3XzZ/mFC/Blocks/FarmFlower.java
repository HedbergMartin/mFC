package v3XzZ.mFC.Blocks;

import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: FarmFlower
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FarmFlower extends CropTemplate 
{
	private int target;
	private int seed;
	
	public FarmFlower(int i, int target, int seed)
    {
        super(i);
        this.iconArray = registerArray(3);
        setTickRandomly(true);
        this.setHardness(0.0F);
        this.setStepSound(Block.soundGrassFootstep);
        this.target = target;
        this.seed = seed;
        this.enableStats = false;
        this.setCreativeTab((CreativeTabs)null);
    }
	
    public void updateTick(World world, int i, int j, int k, Random random)
    {
        super.updateTick(world, i, j, k, random);
        if(world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(7) == 0)
        {
            int metadata = world.getBlockMetadata(i, j, k);
            if(metadata < 3) 
            {
            	world.setBlockMetadataWithNotify(i, j, k, metadata + 1, 2);
            } else
            {
            	growToOther(world, i, j, k);
            }
        }
    }
    
    public void growToOther(World world, int i, int j, int k)
    {
    	world.setBlock(i, j, k, target);
    }

    public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
    {
        super.onBlockDestroyedByPlayer(world, i, j, k, l);
       
        if(!world.isRemote)
        {
            for(int i1 = 0; i1 < 3; i1++)
            {
            	if(world.rand.nextInt(10) <= l)
                {
                    float f = 0.7F;
                    float f1 = world.rand.nextFloat() * f + (1.0F - f) * 0.5F;
                    float f2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5F;
                    float f3 = world.rand.nextFloat() * f + (1.0F - f) * 0.5F;
                    EntityItem entityitem = new EntityItem(world, (float)i + f1, (float)j + f2, (float)k + f3, new ItemStack(seed,1,0));
                    entityitem.delayBeforeCanPickup = 10;
                    world.spawnEntityInWorld(entityitem);
                }
            }

        }
    }

    public int idDropped(int i, Random random, int j)
    {
    	return -1;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }
}

package v3XzZ.mFC.worldgen;

import java.util.Random;

import v3XzZ.mFC.lib.Blocks;
import v3XzZ.util.Common;

import net.minecraft.world.World;

public class FarmSaltGen {
	public FarmSaltGen(){
		
	}
	
	public boolean generate(World world, Random random, int i, int j, int k)
    {
        for (int l = 0; l < 20; l++)
        {
            int i1 = (i + random.nextInt(4)) - random.nextInt(4);
            int j1 = j;
            int k1 = (k + random.nextInt(4)) - random.nextInt(4);
            if (world.isAirBlock(i1, j1, k1) && Common.isNearWater(world, i1, j1, k1)){
	            if (Blocks.saltBlock.canBlockStay(world, i1, j1, k1))
	            {
	            	world.setBlock(i1, j1, k1, Blocks.saltBlock.blockID);
	            }
            }
            
        }

        return true;
    }
}

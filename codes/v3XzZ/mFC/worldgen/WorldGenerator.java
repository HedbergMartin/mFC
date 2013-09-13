package v3XzZ.mFC.worldgen;

import java.util.Random;

import v3XzZ.mFC.lib.Blocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * Project: mFC
 * 
 * Class: WorldGenerator
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class WorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (chunkGenerator instanceof ChunkProviderGenerate)
		{
			generateSurface(world, random, chunkX << 4, chunkZ << 4);
		}
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		if(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.forest) {
			for(int k = 0; k < 14; k++)
	        {
	            int l = random.nextInt(66) + 63;
	            int i1 = chunkX + random.nextInt(16);
	            int j1 = chunkZ + random.nextInt(16);
	            if((world.getBlockId(i1, l - 1, j1) == 2 || world.getBlockId(i1, l - 1, j1) == 3) && random.nextInt(5) < 1)
	            {
	                (new FarmFruitTree()).generate(world, random, i1, l, j1, Blocks.appleBlock.blockID, 0);
	            }
	        }
		}
		
		if(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.plains) {
	        for(int k = 0; k < 4; k++)
	        {
	            int l = random.nextInt(66) + 63;
	            int i1 = chunkX + random.nextInt(16);
	            int j1 = chunkZ + random.nextInt(16);
	            if((world.getBlockId(i1, l - 1, j1) == 2 || world.getBlockId(i1, l - 1, j1) == 3) && random.nextInt(5) < 1)
	            {
	                (new FarmFruitTree()).generate(world, random, i1, l, j1, Blocks.orangeBlock.blockID, 1);
	            }
	        }
	        for(int k = 0; k < 4; k++)
	        {
	            int l = random.nextInt(66) + 63;
	            int i1 = chunkX + random.nextInt(16);
	            int j1 = chunkZ + random.nextInt(16);
	            if((world.getBlockId(i1, l - 1, j1) == 2 || world.getBlockId(i1, l - 1, j1) == 3) && random.nextInt(5) < 1)
	            {
	                (new FarmFruitTree()).generate(world, random, i1, l, j1, Blocks.appleBlock.blockID, 0);
	            }
	        }
		}
        if(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.jungle || world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.jungleHills) {
	        for(int k = 0; k < 40; k++)
	        {
	            int l = random.nextInt(66) + 63;
	            int i1 = chunkX + random.nextInt(16);
	            int j1 = chunkZ + random.nextInt(16);
	            if((world.getBlockId(i1, l - 1, j1) == 2 || world.getBlockId(i1, l - 1, j1) == 3) && random.nextInt(5) < 1)
	            {
	                (new FarmFruitTree()).generate(world, random, i1, l, j1, Blocks.avacadoBlock.blockID, 2);
	            }
	        }
        }
        /*for(int k = 0; k < 10; k++)
        {
            int l = random.nextInt(66) + 63;
            int i1 = chunkX + random.nextInt(16);
            int j1 = chunkZ + random.nextInt(16);
            if((world.getBlockId(i1, l - 1, j1) == 2 || world.getBlockId(i1, l - 1, j1) == 3) && random.nextInt(5) < 1)
            {
                (new FarmFruitTree()).generate(world, random, i1, l, j1, mFC.cocoaBlock.blockID, 3);
            }
        }*/
        for(int k = 0; k < 400; k++)
        {
            int l = chunkX + random.nextInt(16) + 8;
            int i1 = random.nextInt(world.getHeight());
            int j1 = chunkZ + random.nextInt(16) + 8;
            (new FarmSaltGen()).generate(world, random, l, i1, j1);
        }
        /*for(int k = 0; k < 5; k++){
        	int l = random.nextInt(66) + 50;
            int i1 = chunkX + random.nextInt(16);
            int j1 = chunkZ + random.nextInt(16);
            if(!world.isAirBlock(i1, l - 1, j1) && (world.isAirBlock(i1, l, j1) || world.getBlockId(i1, l, j1) == Block.snow.blockID || world.getBlockId(i1, l, j1) == Block.tallGrass.blockID) && world.isBlockSolidOnSide(i1, l-1, j1, ForgeDirection.UP) && random.nextInt(5) < 1)
            {
                world.setBlockWithNotify(i1, l, j1, mFC.present.blockID);
            }
        }*/
        
        
        if(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.forest) {
        	for(int k = 0; k < 15; k++){
            	int l = random.nextInt(66) + 50;
                int i1 = chunkX + random.nextInt(16);
                int j1 = chunkZ + random.nextInt(16);
                if(!world.isAirBlock(i1, l - 1, j1) && (world.isAirBlock(i1, l, j1) || world.getBlockId(i1, l, j1) == Block.snow.blockID || world.getBlockId(i1, l, j1) == Block.tallGrass.blockID) && world.getBlockId(i1, l-1, j1) == Block.grass.blockID && random.nextInt(5) < 1)
                {
                    world.setBlock(i1, l, j1, Blocks.lettucePlant.blockID, 2, 2);
                }
            }
        	for(int k = 0; k < 13; k++){
            	int l = random.nextInt(66) + 50;
                int i1 = chunkX + random.nextInt(16);
                int j1 = chunkZ + random.nextInt(16);
                if(!world.isAirBlock(i1, l - 1, j1) && (world.isAirBlock(i1, l, j1) || world.getBlockId(i1, l, j1) == Block.snow.blockID || world.getBlockId(i1, l, j1) == Block.tallGrass.blockID) && world.getBlockId(i1, l-1, j1) == Block.grass.blockID && random.nextInt(5) < 1)
                {
                    world.setBlock(i1, l, j1, Blocks.onionPlant.blockID, 4, 2);
                }
            }
        	for(int k = 0; k < 15; k++){
            	int l = random.nextInt(66) + 50;
                int i1 = chunkX + random.nextInt(16);
                int j1 = chunkZ + random.nextInt(16);
                if(!world.isAirBlock(i1, l - 1, j1) && (world.isAirBlock(i1, l, j1) || world.getBlockId(i1, l, j1) == Block.snow.blockID || world.getBlockId(i1, l, j1) == Block.tallGrass.blockID) && world.getBlockId(i1, l-1, j1) == Block.grass.blockID && random.nextInt(5) < 1)
                {
                    world.setBlock(i1, l, j1, Blocks.tomatoPlant.blockID, 5, 2);
                }
            }
        	for(int k = 0; k < 15; k++){
            	int l = random.nextInt(66) + 50;
                int i1 = chunkX + random.nextInt(16);
                int j1 = chunkZ + random.nextInt(16);
                if(!world.isAirBlock(i1, l - 1, j1) && (world.isAirBlock(i1, l, j1) || world.getBlockId(i1, l, j1) == Block.snow.blockID || world.getBlockId(i1, l, j1) == Block.tallGrass.blockID) && world.getBlockId(i1, l-1, j1) == Block.grass.blockID && random.nextInt(5) < 1)
                {
                    world.setBlock(i1, l, j1, Blocks.raspBerryPlant.blockID, 4, 2);
                }
            }
        	for(int k = 0; k < 15; k++){
            	int l = random.nextInt(66) + 70;
                int i1 = chunkX + random.nextInt(16);
                int j1 = chunkZ + random.nextInt(16);
                if(!world.isAirBlock(i1, l - 1, j1) && (world.isAirBlock(i1, l, j1) || world.getBlockId(i1, l, j1) == Block.snow.blockID || world.getBlockId(i1, l, j1) == Block.tallGrass.blockID) && world.getBlockId(i1, l-1, j1) == Block.grass.blockID && random.nextInt(5) < 1)
                {
                    world.setBlock(i1, l, j1, Blocks.strawBerryPlant.blockID, 4, 2);
                }
            }
        }
        if(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.plains) {
        	for(int k = 0; k < 6; k++){
            	int l = random.nextInt(66) + 50;
                int i1 = chunkX + random.nextInt(16);
                int j1 = chunkZ + random.nextInt(16);
                if(!world.isAirBlock(i1, l - 1, j1) && (world.isAirBlock(i1, l, j1) || world.getBlockId(i1, l, j1) == Block.snow.blockID || world.getBlockId(i1, l, j1) == Block.tallGrass.blockID) && world.getBlockId(i1, l-1, j1) == Block.grass.blockID && random.nextInt(5) < 1)
                {
                    world.setBlock(i1, l, j1, Blocks.cornPlant.blockID, 4, 2);
                    world.setBlock(i1, l+1, j1, Blocks.cornPlant.blockID, 7, 2);
                }
            }
        	for(int k = 0; k < 6; k++){
            	int l = random.nextInt(66) + 50;
                int i1 = chunkX + random.nextInt(16);
                int j1 = chunkZ + random.nextInt(16);
                if(!world.isAirBlock(i1, l - 1, j1) && (world.isAirBlock(i1, l, j1) || world.getBlockId(i1, l, j1) == Block.snow.blockID || world.getBlockId(i1, l, j1) == Block.tallGrass.blockID) && world.getBlockId(i1, l-1, j1) == Block.grass.blockID && random.nextInt(5) < 1)
                {
                    world.setBlock(i1, l, j1, Blocks.onionPlant.blockID, 4, 2);
                }
            }
        }
        if(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.extremeHills) {
        	for(int k = 0; k < 8; k++){
            	int l = random.nextInt(66) + 70;
                int i1 = chunkX + random.nextInt(16);
                int j1 = chunkZ + random.nextInt(16);
                if(!world.isAirBlock(i1, l - 1, j1) && (world.isAirBlock(i1, l, j1) || world.getBlockId(i1, l, j1) == Block.snow.blockID || world.getBlockId(i1, l, j1) == Block.tallGrass.blockID) && world.getBlockId(i1, l-1, j1) == Block.grass.blockID && random.nextInt(5) < 1)
                {
                    world.setBlock(i1, l, j1, Blocks.ricePlant.blockID, 4, 2);
                }
            }
        }
        if(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.swampland) {
        	for(int k = 0; k < 8; k++){
            	int l = random.nextInt(66) + 50;
                int i1 = chunkX + random.nextInt(16);
                int j1 = chunkZ + random.nextInt(16);
                if(!world.isAirBlock(i1, l - 1, j1) && (world.isAirBlock(i1, l, j1) || world.getBlockId(i1, l, j1) == Block.snow.blockID || world.getBlockId(i1, l, j1) == Block.tallGrass.blockID) && world.getBlockId(i1, l-1, j1) == Block.grass.blockID && random.nextInt(5) < 1)
                {
                    world.setBlock(i1, l, j1, Blocks.wasabiPlant.blockID, 2, 2);
                }
            }
        	for(int k = 0; k < 8; k++){
            	int l = random.nextInt(66) + 50;
                int i1 = chunkX + random.nextInt(16);
                int j1 = chunkZ + random.nextInt(16);
                if(!world.isAirBlock(i1, l - 1, j1) && (world.isAirBlock(i1, l, j1) || world.getBlockId(i1, l, j1) == Block.snow.blockID || world.getBlockId(i1, l, j1) == Block.tallGrass.blockID) && world.getBlockId(i1, l-1, j1) == Block.grass.blockID && random.nextInt(5) < 1)
                {
                    world.setBlock(i1, l, j1, Blocks.ricePlant.blockID, 4, 2);
                }
            }
        }
        if(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.forestHills) {
        	for(int k = 0; k < 15; k++){
            	int l = random.nextInt(66) + 70;
                int i1 = chunkX + random.nextInt(16);
                int j1 = chunkZ + random.nextInt(16);
                if(!world.isAirBlock(i1, l - 1, j1) && (world.isAirBlock(i1, l, j1) || world.getBlockId(i1, l, j1) == Block.snow.blockID || world.getBlockId(i1, l, j1) == Block.tallGrass.blockID) && world.getBlockId(i1, l-1, j1) == Block.grass.blockID && random.nextInt(5) < 1)
                {
                    world.setBlock(i1, l, j1, Blocks.strawBerryPlant.blockID, 4, 2);
                }
            }
        }
	}

}

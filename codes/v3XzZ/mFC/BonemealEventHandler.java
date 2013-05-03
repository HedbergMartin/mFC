package v3XzZ.mFC;

import v3XzZ.mFC.Blocks.CropBush;
import v3XzZ.mFC.Blocks.CropCorn;
import v3XzZ.mFC.Blocks.CropGrape;
import v3XzZ.mFC.Blocks.CropLettuce;
import v3XzZ.mFC.Blocks.CropOnion;
import v3XzZ.mFC.Blocks.CropRice;
import v3XzZ.mFC.Blocks.CropWasabi;
import v3XzZ.mFC.Blocks.FarmFlower;
import v3XzZ.mFC.Blocks.FruitSaplings;
import v3XzZ.mFC.lib.Blocks;
import net.minecraft.block.Block;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class BonemealEventHandler {

	@ForgeSubscribe
    public void onUseBonemeal(BonemealEvent event)
    {
		int i = event.X;
		int j = event.Y;
		int k = event.Z;
		Block block = Block.blocksList[event.ID];
		if(block instanceof FarmFlower)
        {
            ((FarmFlower)block).growToOther(event.world, i, j, k);
        }
    	if(block instanceof CropBush)
        {
            ((CropBush)block).fertilize(event.world, i, j, k);
        }
    	if(block instanceof FruitSaplings)
        {
			((FruitSaplings)block).growTree(event.world, i, j, k, event.world.rand);
        }
        if(block instanceof CropCorn)
        {
        	if(event.world.getBlockId(i, j-1, k) != Blocks.cornPlant.blockID){
        		((CropCorn)block).fertilize(event.world, i, j, k);
        	}
        }
        if(block instanceof CropRice)
        {
            ((CropRice)block).fertilize(event.world, i, j, k);
        }
        if(block instanceof CropLettuce)
        {
            ((CropLettuce)block).fertilize(event.world, i, j, k);
        }
        if(block instanceof CropOnion)
        {
            ((CropOnion)block).fertilize(event.world, i, j, k);
        }
        if(block instanceof CropGrape)
        {
            ((CropGrape)block).fertilize(event.world, i, j, k);
        }
        if(block instanceof CropWasabi)
        {
            ((CropWasabi)block).fertilize(event.world, i, j, k);
        }
    }
}

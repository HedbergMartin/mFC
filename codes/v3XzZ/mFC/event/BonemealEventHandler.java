package v3XzZ.mFC.event;

import v3XzZ.mFC.blocks.CropBush;
import v3XzZ.mFC.blocks.CropCorn;
import v3XzZ.mFC.blocks.CropGrape;
import v3XzZ.mFC.blocks.CropLettuce;
import v3XzZ.mFC.blocks.CropOnion;
import v3XzZ.mFC.blocks.CropRice;
import v3XzZ.mFC.blocks.CropWasabi;
import v3XzZ.mFC.blocks.FarmFlower;
import v3XzZ.mFC.blocks.FruitSaplings;
import v3XzZ.mFC.lib.Blocks;
import net.minecraft.block.Block;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

/**
 * Project: mFC
 * 
 * Class: BonemealEventHandler
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

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
            event.setResult(Result.ALLOW);
        }
    	if(block instanceof CropBush)
        {
    		if(((CropBush)block).fertilize(event.world, i, j, k)){
                event.setResult(Result.ALLOW);
            }
        }
    	if(block instanceof FruitSaplings)
        {
    		if(((FruitSaplings)block).growTree(event.world, i, j, k, event.world.rand)){
                event.setResult(Result.ALLOW);
            }
        }
        if(block instanceof CropCorn)
        {
        	if(event.world.getBlockId(i, j-1, k) != Blocks.cornPlant.blockID){
        		if(((CropCorn)block).fertilize(event.world, i, j, k)){
                    event.setResult(Result.ALLOW);
        		}
        	}
        }
        if(block instanceof CropRice)
        {
            if(((CropRice)block).fertilize(event.world, i, j, k)){
                event.setResult(Result.ALLOW);
            }
        }
        if(block instanceof CropLettuce)
        {
        	if(((CropLettuce)block).fertilize(event.world, i, j, k)){
                event.setResult(Result.ALLOW);
            }
        }
        if(block instanceof CropOnion)
        {
        	if(((CropOnion)block).fertilize(event.world, i, j, k)){
                event.setResult(Result.ALLOW);
            }
        }
        if(block instanceof CropGrape)
        {
        	if(((CropGrape)block).fertilize(event.world, i, j, k)){
                event.setResult(Result.ALLOW);
            }
        }
        if(block instanceof CropWasabi)
        {
        	if(((CropWasabi)block).fertilize(event.world, i, j, k)){
                event.setResult(Result.ALLOW);
            }
        }
    }
}

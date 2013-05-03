package v3XzZ.mFC.Items;

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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FarmBoneMeal extends ItemDye {

	public FarmBoneMeal(int i) {
		super(i);
	}
	
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l, float par8, float par9, float par10)
    {
        if (itemstack.getItemDamage() == 15) {
        	int bid = world.getBlockId(i, j, k);
        	Block block = Block.blocksList[bid];
        	int mete = world.getBlockMetadata(i, j, k);
        	
        	// check for custom crops
        	
        	if(block instanceof FarmFlower)
            {
                ((FarmFlower)block).growToOther(world, i, j, k);
                itemstack.stackSize--;
                return true;
            }
        	if(block instanceof CropBush)
            {
                ((CropBush)block).fertilize(world, i, j, k);
                itemstack.stackSize--;
                return true;
            }
        	if(block instanceof FruitSaplings)
            {
				((FruitSaplings)block).growTree(world, i, j, k, world.rand);
                itemstack.stackSize--;
                return true;
            }
            if(block instanceof CropCorn)
            {
            	if(world.getBlockId(i, j-1, k) != Blocks.cornPlant.blockID){
            		((CropCorn)block).fertilize(world, i, j, k);
                    itemstack.stackSize--;
                    return true;
            	}
            }
            if(block instanceof CropRice)
            {
                ((CropRice)block).fertilize(world, i, j, k);
                itemstack.stackSize--;
                return true;
            }
            if(block instanceof CropLettuce)
            {
                ((CropLettuce)block).fertilize(world, i, j, k);
                itemstack.stackSize--;
                return true;
            }
            if(block instanceof CropOnion)
            {
                ((CropOnion)block).fertilize(world, i, j, k);
                itemstack.stackSize--;
                return true;
            }
            if(block instanceof CropGrape)
            {
                ((CropGrape)block).fertilize(world, i, j, k);
                itemstack.stackSize--;
                return true;
            }
            if(block instanceof CropWasabi)
            {
                ((CropWasabi)block).fertilize(world, i, j, k);
                itemstack.stackSize--;
                return true;
            }
        }
    	
        return super.onItemUse(itemstack, entityplayer, world, i, j, k, l, par8, par9, par10);
    }
}
package v3XzZ.mFC.Blocks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import v3XzZ.mFC.lib.Items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockPresent extends Block {
	
	Map randomloot = new HashMap();

	public BlockPresent(int par1, Material par3Material) {
		super(par1, par3Material);
		randomloot.put(0, Item.diamond.itemID);
		randomloot.put(1, Item.appleGold.itemID);
		randomloot.put(2, Item.helmetChain.itemID);
		randomloot.put(3, Item.blazeRod.itemID);
		randomloot.put(4, Item.goldNugget.itemID);
		for(int gin = 5; gin < 20; gin++)
		randomloot.put(gin, Items.gingerBread.itemID);
	}
	
	/*@Override
	public int getBlockTextureFromSide(int par1) {
		switch(par1){
		case 0 : return 91; 
		case 1 : return 92; 
		default : return 90;
		}
	}*/
	

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return (Integer) randomloot.get(par2Random.nextInt(20));
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		// TODO Auto-generated method stub
		return 2+par1Random.nextInt(4);
	}

}

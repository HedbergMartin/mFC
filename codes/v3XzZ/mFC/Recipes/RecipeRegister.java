package v3XzZ.mFC.Recipes;

import v3XzZ.mFC.mFC;
import v3XzZ.mFC.lib.Blocks;
import v3XzZ.mFC.lib.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Project: mFC
 * 
 * Class: RecipeRegister
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class RecipeRegister {

	public static void addRecipe(){
		GameRegistry.addRecipe(new ItemStack(Items.obsidianPick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick
        });
		GameRegistry.addRecipe(new ItemStack(Items.obsidianShovel, 1), new Object[] {
            " X ", " | ", " | ", Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick
        });
		GameRegistry.addRecipe(new ItemStack(Items.obsidianAxe, 1), new Object[] {
            "XX ", "X| ", " | ", Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick
        });
		GameRegistry.addRecipe(new ItemStack(Items.obsidianHoe, 1), new Object[] {
            "XX ", " | ", " | ", Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick
        });
		GameRegistry.addRecipe(new ItemStack(Items.obsidianSword, 1), new Object[] {
            " X ", " X ", " | ", Character.valueOf('X'), Block.obsidian, Character.valueOf('|'), Item.stick
        });
        GameRegistry.addRecipe( new ItemStack( Items.money, 40 ), new Object[] {
			"XXX", "CGC", "XXX", Character.valueOf('X'), Item.paper, Character.valueOf('C'), new ItemStack (Item.dyePowder, 1, 2), Character.valueOf('G'), Item.ingotGold
		});
		GameRegistry.addRecipe( new ItemStack( Items.moldEmpty, 1 ), new Object[] {
			"X X", "XXX", Character.valueOf('X'), Block.stone
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Items.moldMilk, 1 ), new Object[] {
			new ItemStack(Items.moldEmpty), new ItemStack(Item.bucketMilk)
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Items.moldMilk, 1 ), new Object[] {
			new ItemStack(Items.moldEmpty), new ItemStack(Items.woodenBucketMilk)
		});
		GameRegistry.addRecipe( new ItemStack( Items.cheeseWheel, 1 ), new Object[] {
			"U", Character.valueOf('U'), Items.moldCheese
		});
		GameRegistry.addRecipe( new ItemStack( Items.drinkingGlass, 1 ), new Object[] {
			"X X", " X ", Character.valueOf('X'), Block.thinGlass
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Items.glassWater, 1 ), new Object[] {
			new ItemStack(Items.drinkingGlass), new ItemStack(Item.bucketWater)
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Items.glassWater, 1 ), new Object[] {
			new ItemStack(Items.drinkingGlass), new ItemStack(Items.woodenBucketWater)
		});
		GameRegistry.addRecipe( new ItemStack( Items.Knife, 1 ), new Object[] {
			"  U", " U ", "X  ", Character.valueOf('X'), Item.stick, Character.valueOf('U'), Item.ingotIron
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Items.baconRaw, 1 ), new Object[] {
			new ItemStack(Items.Knife, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Item.porkRaw)
		});
		GameRegistry.addRecipe( new ItemStack( Items.clayCup, 1 ), new Object[] {
			"P P", "XPX", Character.valueOf('X'), Block.sand, Character.valueOf('P'), Item.clay
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Items.cupChocolate, 1 ), new Object[] {
			new ItemStack(Item.dyePowder, 1, 3), new ItemStack(Items.cup, 1), new ItemStack(Item.bucketMilk, 1),
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Items.cupChocolate, 1 ), new Object[] {
			new ItemStack(Item.dyePowder, 1, 3), new ItemStack(Items.cup, 1), new ItemStack(Items.woodenBucketMilk, 1),
		});
		GameRegistry.addRecipe( new ItemStack( Items.clayTeapot, 1 ), new Object[] {
			" H ", "PXP", " PX", Character.valueOf('X'), Block.sand, Character.valueOf('P'), Item.clay, Character.valueOf('H'), Item.stick
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Block.blockClay, 1 ), new Object[] {
			new ItemStack(Item.bucketWater, 1), new ItemStack(Block.dirt, 1), new ItemStack(Block.sand, 1),
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Block.blockClay, 1 ), new Object[] {
			new ItemStack(Items.woodenBucketWater, 1), new ItemStack(Block.dirt, 1), new ItemStack(Block.sand, 1),
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Items.breadSlice, 4 ), new Object[] {
			new ItemStack(Items.Knife, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Item.bread)
		});
		GameRegistry.addRecipe( new ItemStack( Items.sandwichEgg, 1 ), new Object[] {
			" X ", " CP", " X ", Character.valueOf('X'), Items.breadSlice, Character.valueOf('P'), Items.friedEgg, Character.valueOf('C'), Items.cheesePiece
		});
		GameRegistry.addRecipe( new ItemStack( Items.sandwichBacon, 1 ), new Object[] {
			" X ", "BCP", " X ", Character.valueOf('X'), Items.breadSlice, Character.valueOf('P'), Items.friedEgg, Character.valueOf('C'), Items.cheesePiece, Character.valueOf('B'), Items.bacon
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Items.teapotCold, 1 ), new Object[] {
			new ItemStack(Item.seeds, 1), new ItemStack(Item.bucketWater), new ItemStack(Items.teapot)
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Items.teapotCold, 1 ), new Object[] {
			new ItemStack(Item.seeds, 1), new ItemStack(Items.woodenBucketWater), new ItemStack(Items.teapot)
		});
		GameRegistry.addRecipe( new ItemStack( Items.cupTea, 3 ), new Object[] {
			" # ", "XXX", Character.valueOf('#'), Items.teapotHot, Character.valueOf('X'), Items.cup
		});
		GameRegistry.addRecipe( new ItemStack( Items.woodenBucket, 1), new Object[] {
			"# #", "# #", " # ", Character.valueOf('#'), Block.planks
		});
		GameRegistry.addRecipe( new ItemStack( Items.sausageRaw, 2), new Object[] {
			"##", Character.valueOf('#'), Item.beefRaw
		});
		GameRegistry.addRecipe(new ItemStack(Item.cake, 1), new Object[] {
            "AAA", "BEB", "CCC", Character.valueOf('A'), Items.woodenBucketMilk, Character.valueOf('B'), Item.sugar, Character.valueOf('C'), Item.wheat, Character.valueOf('E'), 
            Item.egg
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Item.seeds, 3 ), new Object[] {
			new ItemStack(Item.wheat, 1)
		});
		GameRegistry.addRecipe(new ItemStack(Item.saddle, 1), new Object[] {
            "AAA", "BAB", "C C", Character.valueOf('A'), Item.leather, Character.valueOf('B'), Item.silk, Character.valueOf('C'), Item.ingotIron,
		});
		GameRegistry.addShapelessRecipe( new ItemStack(Items.pumpkinPiece, 4), new Object[] {
			new ItemStack(Block.pumpkin, 1), new ItemStack(Items.Knife, 1, OreDictionary.WILDCARD_VALUE)
		});
		GameRegistry.addRecipe( new ItemStack( Items.guacamole, 1), new Object[] {
			"X", "#", Character.valueOf('#'), Item.bowlEmpty, Character.valueOf('X'), Items.avacado
		});
		GameRegistry.addShapelessRecipe( new ItemStack(Item.dyePowder, 1, 3), new Object[] {
			new ItemStack(Items.CocoaFruit, 1)
		});
		GameRegistry.addRecipe(new ItemStack(Items.itemApplePie, 1), new Object[] {
            "ABA", "BEB", "CCC", Character.valueOf('A'), Items.woodenBucketMilk, Character.valueOf('B'), Item.appleRed, Character.valueOf('C'), Item.wheat, Character.valueOf('E'), 
            Item.egg
		});
		GameRegistry.addRecipe(new ItemStack(Items.itemApplePie, 1), new Object[] {
            "ABA", "BEB", "CCC", Character.valueOf('A'), Item.bucketMilk, Character.valueOf('B'), Item.appleRed, Character.valueOf('C'), Item.wheat, Character.valueOf('E'), 
            Item.egg
		});
		GameRegistry.addRecipe(new ItemStack(Items.itemTacoPie, 1), new Object[] {
            "HGF", "AEA", "CCC", Character.valueOf('A'), Items.woodenBucketMilk, Character.valueOf('C'), Item.wheat, Character.valueOf('E'), Item.egg, Character.valueOf('F'), Item.porkCooked, Character.valueOf('G'), Items.cheesePiece, Character.valueOf('H'), Items.tomato
		});
		GameRegistry.addRecipe(new ItemStack(Items.itemTacoPie, 1), new Object[] {
            "HGF", "AEA", "CCC", Character.valueOf('A'), Item.bucketMilk, Character.valueOf('C'), Item.wheat, Character.valueOf('E'), Item.egg, Character.valueOf('F'), Item.porkCooked, Character.valueOf('G'), Items.cheesePiece, Character.valueOf('H'), Items.tomato
		});
		GameRegistry.addRecipe(new ItemStack(Items.itemChocolateCake, 1), new Object[] {
            "BAB", "DED", "CCC", Character.valueOf('A'), Item.bucketMilk, Character.valueOf('B'), new ItemStack(Item.dyePowder, 1, 3), Character.valueOf('C'), Item.wheat, Character.valueOf('E'), 
            Item.egg, Character.valueOf('D'), Item.sugar
		});
		GameRegistry.addRecipe(new ItemStack(Items.itemChocolateCake, 1), new Object[] {
            "BAB", "DED", "CCC", Character.valueOf('A'), Items.woodenBucketMilk, Character.valueOf('B'), new ItemStack(Item.dyePowder, 1, 3), Character.valueOf('C'), Item.wheat, Character.valueOf('E'), 
            Item.egg, Character.valueOf('D'), Item.sugar
		});
		GameRegistry.addRecipe(new ItemStack(Items.itemMeatPie, 1), new Object[] {
            "BBB", "AEA", "CCC", Character.valueOf('A'), Items.woodenBucketMilk, Character.valueOf('C'), Item.wheat, Character.valueOf('E'), Item.egg, Character.valueOf('B'), Item.beefCooked
		});
		GameRegistry.addRecipe(new ItemStack(Items.itemMeatPie, 1), new Object[] {
            "BBB", "AEA", "CCC", Character.valueOf('A'), Item.bucketMilk, Character.valueOf('C'), Item.wheat, Character.valueOf('E'), Item.egg, Character.valueOf('B'), Item.beefCooked
		});
		GameRegistry.addRecipe(new ItemStack(Items.bottleOfOil, 1), new Object[] {
            "B", "E", Character.valueOf('B'), Items.avacado, Character.valueOf('E'), Item.glassBottle
		});
		GameRegistry.addRecipe(new ItemStack(Items.bottleOfOil, 1), new Object[] {
            "BBB", " E ", Character.valueOf('B'), Item.seeds, Character.valueOf('E'), Item.glassBottle
		});
		GameRegistry.addShapelessRecipe( new ItemStack(Items.meatScrap, 1), new Object[] {
			new ItemStack(Item.beefCooked, 1), new ItemStack(Items.Knife, 1, OreDictionary.WILDCARD_VALUE)
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.beefJerky, 1), new Object[] {
			new ItemStack(Item.beefRaw, 1), new ItemStack(Items.Knife, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.saltPile, 1)
		});
		GameRegistry.addShapelessRecipe( new ItemStack(Items.pasta, 2), new Object[] {
			new ItemStack(Item.bucketWater, 1), new ItemStack(Item.egg, 1), new ItemStack(Item.wheat, 1)
		});
		GameRegistry.addShapelessRecipe( new ItemStack(Items.pasta, 2), new Object[] {
			new ItemStack(Items.woodenBucketWater, 1), new ItemStack(Item.egg, 1), new ItemStack(Item.wheat, 1)
		});
		GameRegistry.addRecipe(new ItemStack(Items.glassAppleJuice, 1), new Object[] {
            "B", "E", Character.valueOf('B'), Item.appleRed, Character.valueOf('E'), Items.drinkingGlass
		});
		GameRegistry.addRecipe(new ItemStack(Items.glassMelonJuice, 1), new Object[] {
            "B", "E", Character.valueOf('B'), Item.melon, Character.valueOf('E'), Items.drinkingGlass
		});
		GameRegistry.addRecipe(new ItemStack(Items.sandwichChicken, 1 ), new Object[] {
			" X ", "BCP", " X ", Character.valueOf('X'), Items.breadSlice, Character.valueOf('P'), Items.tomato, Character.valueOf('C'), Item.chickenCooked, Character.valueOf('B'), Items.lettuce
		});
		GameRegistry.addRecipe(new ItemStack(Items.mayonnaise, 1), new Object[] {
			"K", "X", "#", Character.valueOf('#'), Item.bowlEmpty, Character.valueOf('X'), Items.bottleOfOil, Character.valueOf('K'), Item.egg
		});
		GameRegistry.addRecipe(new ItemStack(Items.pastaMeat, 1), new Object[] {
			"P", "M", "#", Character.valueOf('#'), Item.bowlEmpty, Character.valueOf('P'), Items.pasta, Character.valueOf('M'), Items.meatScrap
		});
		GameRegistry.addRecipe(new ItemStack(Items.pastaMeat, 1), new Object[] {
			"M", "P", "#", Character.valueOf('#'), Item.bowlEmpty, Character.valueOf('P'), Items.pasta, Character.valueOf('M'), Items.meatScrap
		});
		GameRegistry.addRecipe(new ItemStack(Items.saladChicken, 1), new Object[] {
			"PKM", " # ", Character.valueOf('#'), Item.bowlEmpty, Character.valueOf('P'), Items.lettuce, Character.valueOf('K'), Item.chickenCooked, Character.valueOf('M'), Items.tomato
		});
		GameRegistry.addRecipe(new ItemStack(Items.saladCeasar, 1), new Object[] {
			" Y ", "PKM", " # ", Character.valueOf('#'), Item.bowlEmpty, Character.valueOf('P'), Items.lettuce, Character.valueOf('K'), Item.chickenCooked, Character.valueOf('M'), Item.bread, Character.valueOf('Y'), Items.mayonnaise
		});
		GameRegistry.addRecipe(new ItemStack(Items.saladPasta, 1), new Object[] {
			"PKM", " # ", Character.valueOf('#'), Item.bowlEmpty, Character.valueOf('P'), Items.lettuce, Character.valueOf('K'), Items.pasta, Character.valueOf('M'), Items.tomato
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.woodenTrellis, 2), new Object[] {
			"P P", "P P", "P P", Character.valueOf('P'), Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.beerKeg, 1), new Object[] {
			"IPI", "PBP", "S S", Character.valueOf('P'), Block.planks, Character.valueOf('S'), Item.stick, Character.valueOf('B'), Item.bucketEmpty, Character.valueOf('I'), Item.ingotIron
		});
		GameRegistry.addRecipe(new ItemStack(Items.beerBase, 1), new Object[] {
			"MMM", "MMM", "BHB", Character.valueOf('M'), Items.malt, Character.valueOf('H'), Block.vine , Character.valueOf('B'), Item.bucketWater
		});
		GameRegistry.addRecipe(new ItemStack(Items.christmasMustBase, 1), new Object[] {
			"SMS", "MMM", "BHB", Character.valueOf('M'), Items.malt, Character.valueOf('H'), Block.vine , Character.valueOf('B'), Item.bucketWater, Character.valueOf('S'), Item.sugar
		});
		GameRegistry.addRecipe(new ItemStack(Items.whiteWineBase, 1), new Object[] {
			"MMM", "MMM", "BHB", Character.valueOf('M'), Items.grapes, Character.valueOf('H'), new ItemStack(Item.dyePowder, 1, 15) , Character.valueOf('B'), Item.bucketWater
		});
		GameRegistry.addRecipe(new ItemStack(Items.redWineBase, 1), new Object[] {
			"MMM", "MMM", "BHB", Character.valueOf('M'), Items.grapes, Character.valueOf('H'), new ItemStack(Item.dyePowder, 1, 1) , Character.valueOf('B'), Item.bucketWater
		});
		GameRegistry.addRecipe(new ItemStack(Items.beerCup, 1), new Object[] {
			"MMS", "MM ", Character.valueOf('M'), Block.planks, Character.valueOf('S'), Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Items.dogFood, 3), new Object[] {
			" S ", "PBP", " P ", Character.valueOf('S'), Item.beefRaw, Character.valueOf('B'), Item.porkRaw, Character.valueOf('P'), Item.paper
		});
		GameRegistry.addRecipe(new ItemStack(Items.jamJar, 1), new Object[] {
			" P ", "X X", " X ", Character.valueOf('X'), Block.thinGlass, Character.valueOf('P'), Block.planks
		});
		GameRegistry.addRecipe(new ItemStack(Items.StrawBerryjam, 1), new Object[] {
			"SSS", "UJU", Character.valueOf('S'), Items.strawBerry, Character.valueOf('J'), Items.jamJar, Character.valueOf('U'), Item.sugar
		});
		GameRegistry.addRecipe(new ItemStack(Items.RaspBerryjam, 1), new Object[] {
			"SSS", "UJU", Character.valueOf('S'), Items.raspBerry, Character.valueOf('J'), Items.jamJar, Character.valueOf('U'), Item.sugar
		});
		GameRegistry.addRecipe(new ItemStack(Items.palt, 3), new Object[] {
			"VPV", "PBP", "VPS", Character.valueOf('S'), Items.saltPile, Character.valueOf('B'), Item.porkCooked, Character.valueOf('V'), Item.wheat, Character.valueOf('P'), Item.potato
		});
		GameRegistry.addRecipe(new ItemStack(Items.pancake, 3, 1), new Object[] {
			" J ", "WWE", "SME", Character.valueOf('S'), Items.saltPile, Character.valueOf('E'), Item.egg, Character.valueOf('W'), Item.wheat, Character.valueOf('M'), Item.bucketMilk, Character.valueOf('J'), Items.RaspBerryjam
		});
		GameRegistry.addRecipe(new ItemStack(Items.pancake, 3, 1), new Object[] {
			" J ", "WWE", "SME", Character.valueOf('S'), Items.saltPile, Character.valueOf('E'), Item.egg, Character.valueOf('W'), Item.wheat, Character.valueOf('M'), Items.woodenBucketMilk, Character.valueOf('J'), Items.RaspBerryjam
		});
		GameRegistry.addRecipe(new ItemStack(Items.pancake, 3, 0), new Object[] {
			" J ", "WWE", "SME", Character.valueOf('S'), Items.saltPile, Character.valueOf('E'), Item.egg, Character.valueOf('W'), Item.wheat, Character.valueOf('M'), Item.bucketMilk, Character.valueOf('J'), Items.StrawBerryjam
		});
		GameRegistry.addRecipe(new ItemStack(Items.pancake, 3, 0), new Object[] {
			" J ", "WWE", "SME", Character.valueOf('S'), Items.saltPile, Character.valueOf('E'), Item.egg, Character.valueOf('W'), Item.wheat, Character.valueOf('M'), Items.woodenBucketMilk, Character.valueOf('J'), Items.StrawBerryjam
		});
		GameRegistry.addRecipe(new ItemStack(Items.glassRaspBerryJuice, 1), new Object[] {
            "B", "B", "E", Character.valueOf('B'), Items.raspBerry, Character.valueOf('E'), Items.drinkingGlass
		});
		GameRegistry.addRecipe(new ItemStack(Items.glassStrawBerryJuice, 1), new Object[] {
            "B", "B", "E", Character.valueOf('B'), Items.strawBerry, Character.valueOf('E'), Items.drinkingGlass
		});
		GameRegistry.addRecipe(new ItemStack(Items.macaroniAndCheese, 1), new Object[] {
            "C M", " B ", Character.valueOf('B'), Item.bowlEmpty, Character.valueOf('C'), Items.cheesePiece, Character.valueOf('M'), Items.pasta
		});
		GameRegistry.addRecipe(new ItemStack(Items.tomatoStew, 1), new Object[] {
            "T O", " B ", Character.valueOf('B'), Item.bowlEmpty, Character.valueOf('T'), Items.tomato, Character.valueOf('O'), Items.onion
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.wasabi, 2), new Object[]{
			new ItemStack(Items.wasabiRoot, 1)
		});
		GameRegistry.addRecipe(new ItemStack(Items.MakiLong, 1), new Object[]{
			"LRL", "LWL", "LRL", Character.valueOf('L'), Block.waterlily, Character.valueOf('R'), Items.bowlOfRice, Character.valueOf('W'), Items.wasabi
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.MakiShort, 4), new Object[]{
			new ItemStack(Items.MakiLong, 1), new ItemStack(Items.Knife, 1, OreDictionary.WILDCARD_VALUE)
		});
		GameRegistry.addRecipe(new ItemStack(Items.LaxSuchi, 6), new Object[]{
			"FFF", "W W", "RRR", Character.valueOf('F'), Item.fishRaw, Character.valueOf('R'), Items.bowlOfRice, Character.valueOf('W'), Items.wasabi
		});
		GameRegistry.addRecipe(new ItemStack(Items.chocolateBar, 1), new Object[] {
			"S", "C", "M", Character.valueOf('S'), Item.sugar, Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 3), Character.valueOf('M'), Items.woodenBucketMilk
		});
		GameRegistry.addRecipe(new ItemStack(Items.chocolateBar, 1), new Object[] {
			"S", "C", "M", Character.valueOf('S'), Item.sugar, Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 3), Character.valueOf('M'), Item.bucketMilk
		});
		GameRegistry.addRecipe(new ItemStack(Items.cornSeeds, 1), new Object[] {
			"#", Character.valueOf('#'), Items.cornCob
		});
		GameRegistry.addRecipe(new ItemStack(Items.orangeJuice), new Object[] {
			"X","Z", Character.valueOf('X'), Items.orange, Character.valueOf('Z'), Items.drinkingGlass
		});
		GameRegistry.addRecipe(new ItemStack(Items.tallBottle, 4), new Object[] {
			" X ","X X","XXX", Character.valueOf('X'), Block.glass
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.plate, 2), new Object[] {
			" X ","XXX"," X ", Character.valueOf('X'), Block.planks
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.shelf, 2), new Object[] {
			" X ","S S", Character.valueOf('X'), Block.planks, Character.valueOf('S'), Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(Items.candyCane, 1), new Object[] {
			" X ","SXS"," X ", Character.valueOf('X'), Item.sugar, Character.valueOf('S'), new ItemStack(Item.dyePowder, 0, 1)
		});
		
		//Smelting
		GameRegistry.addSmelting(Items.moldMilk.itemID, new ItemStack(Items.moldCheese, 1), 0);
		GameRegistry.addSmelting(Items.baconRaw.itemID, new ItemStack(Items.bacon, 1), 0);
		GameRegistry.addSmelting(Items.clayCup.itemID, new ItemStack(Items.cup, 1), 0);
		GameRegistry.addSmelting(Items.clayTeapot.itemID, new ItemStack(Items.teapot, 1), 0);
		GameRegistry.addSmelting(Items.teapotCold.itemID, new ItemStack(Items.teapotHot, 1), 0);
		GameRegistry.addSmelting(Item.egg.itemID, new ItemStack(Items.friedEgg, 1), 0);
		GameRegistry.addSmelting(Items.sausageRaw.itemID, new ItemStack(Items.sausage, 1), 0);
		GameRegistry.addSmelting(Items.woodenBucketWater.itemID, new ItemStack(Items.saltPile, 1), 0);
		GameRegistry.addSmelting(Item.bucketWater.itemID, new ItemStack(Items.saltPile, 1), 0);
		GameRegistry.addSmelting(Items.pumpkinPiece.itemID, new ItemStack(Items.roastPumpkin, 1), 0);
		GameRegistry.addSmelting(Item.seeds.itemID, new ItemStack(Items.malt, 1), 0);
		GameRegistry.addSmelting(Items.cornCob.itemID, new ItemStack(Items.cornCobCooked), 0);
		
		MinecraftForge.addGrassSeed(new ItemStack(Items.redSeeds), 10);
		MinecraftForge.addGrassSeed(new ItemStack(Items.yellowSeeds), 10);
		if(mFC.GrassDropMelon)
			MinecraftForge.addGrassSeed(new ItemStack(Item.melonSeeds), 10);
		if(mFC.GrassDropPumpkin)
			MinecraftForge.addGrassSeed(new ItemStack(Item.pumpkinSeeds), 10);
	}
	
	public static void loadModern(){
		GameRegistry.addRecipe( new ItemStack( Items.hamburgerBread, 2 ), new Object[] {
			"XX", "  ", "XX", Character.valueOf('X'), Item.wheat
		});
		GameRegistry.addRecipe(new ItemStack(Items.hamburgerOrginal, 1), new Object[] {
			" X ", "QP ", " X ", Character.valueOf('X'), Items.hamburgerBread, Character.valueOf('P'), Items.hamburger, Character.valueOf('Q'), Items.lettuce
		});
		GameRegistry.addRecipe( new ItemStack( Items.hamburgerCheese, 1 ), new Object[] {
			" X ", "QPT", " X ", Character.valueOf('X'), Items.hamburgerBread, Character.valueOf('P'), Items.hamburger, Character.valueOf('T'), Items.cheesePiece, Character.valueOf('Q'), Items.lettuce
		});
		GameRegistry.addShapelessRecipe( new ItemStack( Items.hamburgerRaw, 1 ), new Object[] {
			new ItemStack(Items.Knife, 1), new ItemStack(Item.beefRaw)
		});
		GameRegistry.addRecipe( new ItemStack( Items.frenchFries, 3 ), new Object[] {
			"U", "X", Character.valueOf('X'), Item.potato, Character.valueOf('U'), Items.Knife
		});
		GameRegistry.addRecipe( new ItemStack( Items.hamburgerBacon, 1 ), new Object[] {
			" X ", "QPT", " X ", Character.valueOf('X'), Items.hamburgerBread, Character.valueOf('P'), Items.hamburger, Character.valueOf('T'), Items.cheesePiece, Character.valueOf('Q'), Items.bacon
		});
		GameRegistry.addRecipe(new ItemStack(Items.bottleOfKetchup, 1), new Object[] {
            "S", "B", "E", Character.valueOf('B'), Items.tomato, Character.valueOf('E'), Item.glassBottle, Character.valueOf('S'), Item.sugar
		});
		GameRegistry.addRecipe( new ItemStack( Items.hotDogKetchup, 1), new Object[] {
			"K", "X", "#", Character.valueOf('#'), Item.bread, Character.valueOf('X'), Items.sausage, Character.valueOf('K'), Items.bottleOfKetchup
		});
		GameRegistry.addRecipe(new ItemStack(Items.hotDogKetchup, 1), new Object[] {
            "B", "E", Character.valueOf('B'), Items.bottleOfKetchup, Character.valueOf('E'), Items.hotDog
		});
		GameRegistry.addSmelting(Items.hamburgerRaw.itemID, new ItemStack(Items.hamburger, 1), 0);
		GameRegistry.addRecipe( new ItemStack( Items.hotDog, 1), new Object[] {
			"X", "#", Character.valueOf('#'), Item.bread, Character.valueOf('X'), Items.sausage
		});
	}
}

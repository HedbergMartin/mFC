package v3XzZ.mFC.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import v3XzZ.mFC.EntityCauldronItem;
import v3XzZ.mFC.mFC;
import v3XzZ.mFC.api.ApiCommon;
import v3XzZ.mFC.blocks.BlockBeerKeg;
import v3XzZ.mFC.blocks.BlockPlate;
import v3XzZ.mFC.blocks.BlockShelf;
import v3XzZ.mFC.blocks.CropBush;
import v3XzZ.mFC.blocks.CropCorn;
import v3XzZ.mFC.blocks.CropGrape;
import v3XzZ.mFC.blocks.CropLettuce;
import v3XzZ.mFC.blocks.CropOnion;
import v3XzZ.mFC.blocks.CropRice;
import v3XzZ.mFC.blocks.CropWasabi;
import v3XzZ.mFC.blocks.FarmCheese;
import v3XzZ.mFC.blocks.FarmCocoa;
import v3XzZ.mFC.blocks.FarmFlower;
import v3XzZ.mFC.blocks.FarmFruit;
import v3XzZ.mFC.blocks.FarmPie;
import v3XzZ.mFC.blocks.FarmSalt;
import v3XzZ.mFC.blocks.FruitLeaves;
import v3XzZ.mFC.blocks.FruitSaplings;
import v3XzZ.mFC.blocks.WoodenTrellis;
import v3XzZ.mFC.blocks.tileentity.TileEntityBeerKeg;
import v3XzZ.mFC.blocks.tileentity.TileEntityCauldron;
import v3XzZ.mFC.blocks.tileentity.TileEntityPlate;
import v3XzZ.mFC.blocks.tileentity.TileEntityShelf;
import v3XzZ.mFC.core.handlers.IdentificationHandler;
import v3XzZ.mFC.items.BowlFood;
import v3XzZ.mFC.items.BowlPorridge;
import v3XzZ.mFC.items.FarmCup;
import v3XzZ.mFC.items.FarmFruitFood;
import v3XzZ.mFC.items.FarmJam;
import v3XzZ.mFC.items.FarmMilk;
import v3XzZ.mFC.items.FarmPum;
import v3XzZ.mFC.items.FarmSeeds;
import v3XzZ.mFC.items.FarmTreeSeed;
import v3XzZ.mFC.items.ItemBlockmFC;
import v3XzZ.mFC.items.ItemDrinking;
import v3XzZ.mFC.items.ItemSeedFood_mFC;
import v3XzZ.mFC.items.ItemTallBottleDrink;
import v3XzZ.mFC.items.Pancake;
import v3XzZ.mFC.items.WoodenBucket;
import v3XzZ.mFC.items.mFCAxe;
import v3XzZ.mFC.items.mFCFood;
import v3XzZ.mFC.items.mFCHoe;
import v3XzZ.mFC.items.mFCItem;
import v3XzZ.mFC.items.mFCPickaxe;
import v3XzZ.mFC.items.mFCSpade;
import v3XzZ.mFC.items.mFCSword;
import v3XzZ.mFC.lib.Blocks;
import v3XzZ.mFC.lib.CommonIds;
import v3XzZ.mFC.lib.Items;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Project: mFC
 * 
 * Class: Config
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class Config {
	
	public static void load(){
		
	}
	
	public static void loadTools(){
		Items.obsidianPick = new mFCPickaxe(IdentificationHandler.obsidianPickID, CommonIds.TOOL_OBSIDIAN).setUnlocalizedName("pickaxeObsidian");
		Items.obsidianShovel = new mFCSpade(IdentificationHandler.obsidianShovelID, CommonIds.TOOL_OBSIDIAN).setUnlocalizedName("shovelObsidian");
		Items.obsidianAxe = new mFCAxe(IdentificationHandler.obsidianAxeID, CommonIds.TOOL_OBSIDIAN).setUnlocalizedName("axeObsidian");
		Items.obsidianHoe = new mFCHoe(IdentificationHandler.obsidianHoeID, CommonIds.TOOL_OBSIDIAN).setUnlocalizedName("hoeObsidian");
		Items.obsidianSword = new mFCSword(IdentificationHandler.obsidianSwordID, CommonIds.TOOL_OBSIDIAN).setUnlocalizedName("swordObsidian");
		Items.Knife = new mFCSword(IdentificationHandler.KnifeID, CommonIds.TOOL_KNIFE).setUnlocalizedName("knife").setFull3D();
	}
	
	public static void loadModern(){
		Items.hamburgerBread = (new mFCFood(IdentificationHandler.HamburgerBreadID, IdentificationHandler.HamburgerBreadFood, 16, 0.1F)).setUnlocalizedName("modern/hamburgerBread");
		Items.hamburgerOrginal = (new mFCFood(IdentificationHandler.HamBurgerID, IdentificationHandler.HamBurgerFood, 16, 0.8F)).setUnlocalizedName("modern/hamburgerOriginal");
		Items.hamburgerCheese = (new mFCFood(IdentificationHandler.CheeseBurgerID, IdentificationHandler.CheeseBurgerFood, 16, 0.9F)).setUnlocalizedName("modern/hamburgerCheese");
		Items.hamburgerRaw = (new mFCFood(IdentificationHandler.RawHamburgerMeatID, IdentificationHandler.RawHamburgerMeatFood, 16, 0.1F)).setUnlocalizedName("modern/hamburgerRaw");
		Items.hamburger = (new mFCFood(IdentificationHandler.HamburgerMeatID, IdentificationHandler.HamburgerMeatFood, 16, 0.5F)).setUnlocalizedName("modern/hamburger");
		Items.frenchFries = (new mFCFood(IdentificationHandler.StripsID, IdentificationHandler.StripsFood, 16, 0.6F)).setUnlocalizedName("modern/frenchFries");
		Items.hamburgerBacon = (new mFCFood(IdentificationHandler.CheeseBaconBurgerID, IdentificationHandler.CheeseBaconBurgerFood, 16, 0.9F)).setUnlocalizedName("modern/hamburgerBacon");
		Items.hotDog = (new mFCFood(IdentificationHandler.HotDogID, IdentificationHandler.HotDogFood, 16, 0.6F)).setUnlocalizedName("modern/hotdog");
		Items.hotDogKetchup = (new mFCFood(IdentificationHandler.HotDogKetchupID, IdentificationHandler.HotDogKetchupFood, 16, 0.6F)).setUnlocalizedName("modern/hotdogKetchup");
		Items.bottleOfKetchup = (new mFCItem(IdentificationHandler.KetchupID)).setUnlocalizedName("modern/ketchup").setMaxStackSize(1).setContainerItem(Item.glassBottle);
	}
	
	public static void loadDairy(){
		Items.moldEmpty = (new mFCItem(IdentificationHandler.CheeseMoldID)).setUnlocalizedName("moldEmpty");
		Items.moldMilk = (new mFCItem(IdentificationHandler.CheeseMoldMilkID)).setUnlocalizedName("moldMilk");
		Items.moldCheese = (new mFCItem(IdentificationHandler.CheeseMoldCheeseID)).setUnlocalizedName("moldCheese").setMaxStackSize(1).setContainerItem(Items.moldEmpty);
		Items.cheesePiece = (new mFCFood(IdentificationHandler.CheesePieceID, IdentificationHandler.CheesePieceFood, 16, 0.1F)).setUnlocalizedName("cheesePiece");
	}
	
	public static void loadDrinkingRelated(){
		Items.drinkingGlass = (new mFCItem(IdentificationHandler.DrinkingGlassID)).setUnlocalizedName("glass").setMaxStackSize(2);
		Items.glassWater = (new ItemDrinking(IdentificationHandler.BottleWaterID, IdentificationHandler.BottleWaterFood)).setUnlocalizedName("glassWater");
		Items.clayCup = (new mFCItem(IdentificationHandler.CupUnburnedID)).setUnlocalizedName("cupClay").setMaxStackSize(1);
		Items.cup = (new mFCItem(IdentificationHandler.CupID)).setUnlocalizedName("cup").setMaxStackSize(2);
		Items.cupChocolate = (new FarmCup(IdentificationHandler.CupChoklateID, IdentificationHandler.CupChoklateFood)).setMaxStackSize(3).setUnlocalizedName("cupChocolate");
		Items.cupTea = (new FarmCup(IdentificationHandler.CupTeaID, IdentificationHandler.CupTeaFood)).setUnlocalizedName("CupTea");
		Items.clayTeapot = (new mFCItem(IdentificationHandler.TeaCanUnburnedID)).setUnlocalizedName("potClay").setMaxStackSize(1);
		Items.teapot = (new mFCItem(IdentificationHandler.TeaCanID)).setUnlocalizedName("pot").setMaxStackSize(1);
		Items.teapotCold = (new mFCItem(IdentificationHandler.ColdTeaCanID)).setUnlocalizedName("potCold").setMaxStackSize(1);
		Items.teapotHot = (new mFCItem(IdentificationHandler.HotTeaCanID)).setUnlocalizedName("potHot").setMaxStackSize(1).setContainerItem(Items.teapot);
		Items.glassMelonJuice = (new ItemDrinking(IdentificationHandler.MelonJuiceID, IdentificationHandler.MelonJuiceFood, 2.2F)).setUnlocalizedName("glassMelonJuice");
		Items.glassAppleJuice = (new ItemDrinking(IdentificationHandler.AppleJuiceID, IdentificationHandler.AppleJuiceFood, 1.8F)).setUnlocalizedName("glassAppleJuice");
		Items.glassStrawBerryJuice = (new ItemDrinking(IdentificationHandler.StrawBerryJuiceID, IdentificationHandler.StrawBerryJuiceFood, 1.7F)).setUnlocalizedName("glassStrawBerryJuice");
		Items.glassRaspBerryJuice = (new ItemDrinking(IdentificationHandler.RaspBerryJuiceID, IdentificationHandler.RaspBerryJuiceFood, 1.7F)).setUnlocalizedName("glassRaspBerryJuice");
		Items.orangeJuice = (ItemDrinking) (new ItemDrinking(IdentificationHandler.orangeJuiceID, IdentificationHandler.orangeJuiceFood, 1.5F)).setUnlocalizedName("glassJuice");
	}
	
	public static void loadSandwichAndRelated(){
		Items.baconRaw = (new mFCFood(IdentificationHandler.RawBaconID, IdentificationHandler.RawBaconFood, 8, 0.1F)).setUnlocalizedName("baconRaw");
		Items.bacon = (new mFCFood(IdentificationHandler.BaconID, IdentificationHandler.BaconFood, 8, 0.4F)).setUnlocalizedName("bacon");
		Items.friedEgg = (new mFCFood(IdentificationHandler.friedEggID, IdentificationHandler.friedEggFood, 4, 0.4F)).setUnlocalizedName("friedEgg");
		Items.breadSlice = (new mFCFood(IdentificationHandler.BreadSliceID, IdentificationHandler.BreadSliceFood, 8, 0.1F)).setUnlocalizedName("breadSlice");
		Items.sandwichEgg = (new mFCFood(IdentificationHandler.EggSandwichID, IdentificationHandler.EggSandwichFood, 4, 0.9F)).setUnlocalizedName("sandwichEgg");
		Items.sandwichBacon = (new mFCFood(IdentificationHandler.EggBaconSandwichID, IdentificationHandler.EggBaconSandwichFood, 4, 0.9F)).setUnlocalizedName("sandwichBacon");
		Items.sausageRaw = (new mFCFood(IdentificationHandler.HotDogRawID, IdentificationHandler.HotDogRawFood, 8, 0.1F)).setUnlocalizedName("sausageRaw");
		Items.sausage = (new mFCFood(IdentificationHandler.HotDogGrilledID, IdentificationHandler.HotDogGrilledFood, 8, 0.4F)).setUnlocalizedName("sausage");
		Items.sandwichChicken = (new mFCFood(IdentificationHandler.ChickenSandwichID, IdentificationHandler.ChickenSandwichFood, 4, 0.9F)).setUnlocalizedName("sandwichChicken");
	}
	
	public static void loadBrewingAndRelated(){
		Items.beerCup = new mFCItem(IdentificationHandler.beerCupID).setUnlocalizedName("beerCup").setMaxStackSize(2);
		Items.beer = new ItemTallBottleDrink(IdentificationHandler.beerID, IdentificationHandler.beerFood, 2.5F, CommonIds.DRINK_BEER).setPotionEffect(Potion.confusion.id, 30, 0, 0.4F)/*.setPotionEffect(Potion.resistance.id, 60, 0, 0.7F)*/.setUnlocalizedName("beer");
		Items.whiteWine = new ItemTallBottleDrink(IdentificationHandler.whiteWineID, IdentificationHandler.whiteWineFood, 2.8F, CommonIds.DRINK_WHITEWINE).setPotionEffect(Potion.confusion.id, 40, 0, 0.6F)/*.setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F)*/.setUnlocalizedName("bottleWhitewine");
		Items.redWine = new ItemTallBottleDrink(IdentificationHandler.redWineID, IdentificationHandler.redWineFood, 2.8F, CommonIds.DRINK_REDWINE).setPotionEffect(Potion.confusion.id, 40, 0, 0.6F)/*.setPotionEffect(Potion.jump.id, 60, 0, 0.8F)*/.setUnlocalizedName("bottleRedwine");
		Items.christmasMust = new ItemTallBottleDrink(IdentificationHandler.ChristmasMustID, IdentificationHandler.ChristmasMustFood, 2.9F, CommonIds.DRINK_WHITEWINE).setPotionEffect(Potion.digSpeed.id, 60, 0, 0.8F).setUnlocalizedName("bottleChristmasmust");
		Items.tallBottle = new mFCItem(IdentificationHandler.tallBottleID).setUnlocalizedName("bottle").setMaxStackSize(16).setCreativeTab(CreativeTabs.tabMaterials);
		Items.beerBase = new mFCItem(IdentificationHandler.beerBaseID).setUnlocalizedName("beerBase");
		Items.redWineBase = new mFCItem(IdentificationHandler.redWineBaseID).setUnlocalizedName("redwineBase");
		Items.whiteWineBase = new mFCItem(IdentificationHandler.whiteWineBaseID).setUnlocalizedName("whitewineBase");
		Items.christmasMustBase = new mFCItem(IdentificationHandler.ChristmasMustBaseID).setUnlocalizedName("christamsmustBase");
		Items.malt = new mFCItem(IdentificationHandler.MaltID).setUnlocalizedName("malt");
		Blocks.beerKeg = new BlockBeerKeg(IdentificationHandler.beerKegBlockID).setUnlocalizedName("beerKeg").setHardness(0.8F).setStepSound(Block.soundWoodFootstep);
	}
	
	public static void loadMisc(){
		Items.woodenBucket = (new WoodenBucket(IdentificationHandler.BucketID, 0)).setUnlocalizedName("woodenBucket");
		Items.woodenBucketWater = (new WoodenBucket(IdentificationHandler.bucketWaterID, Block.waterMoving.blockID)).setUnlocalizedName("woodenBucketWater").setContainerItem(Items.woodenBucket);
		Items.woodenBucketMilk = (new FarmMilk(IdentificationHandler.bucketMilkID)).setUnlocalizedName("woodenBucketMilk").setContainerItem(Items.woodenBucket);
		Items.money = (new mFCItem(IdentificationHandler.DollarID)).setUnlocalizedName("money");
		Items.fork = new mFCItem(IdentificationHandler.forkID).setUnlocalizedName("fork");
	}
	
	public static void loadBowlFoodAndRelated(){
		Items.meatScrap = (new mFCFood(IdentificationHandler.MeatSauceID, IdentificationHandler.MeatSauceFood, 16, 0.3F)).setUnlocalizedName("meatScrap");
		Items.pasta = (new mFCItem(IdentificationHandler.PastaID)).setUnlocalizedName("pasta");
		Items.mayonnaise = (new BowlFood(IdentificationHandler.MayonnaiseID, IdentificationHandler.MayonnaiseFood, 0.4F)).setUnlocalizedName("mayonnaise");
		Items.saladPasta = (new BowlFood(IdentificationHandler.PastaSalladID, IdentificationHandler.PastaSalladFood, 0.8F)).setUnlocalizedName("saladPasta");
		Items.pastaMeat = (new BowlFood(IdentificationHandler.PastaMeatsauceID, IdentificationHandler.PastaMeatsauceFood, 0.9F)).setUnlocalizedName("pastaMeat");
		Items.saladCeasar = (new BowlFood(IdentificationHandler.CeasarSalladID, IdentificationHandler.CeasarSalladFood, 0.9F)).setUnlocalizedName("saladCeasar");
		Items.saladChicken = (new BowlFood(IdentificationHandler.ChickenSalladID, IdentificationHandler.ChickenSalladFood, 0.9F)).setUnlocalizedName("saladChicken");
		Items.bowlOfRice = new BowlFood(IdentificationHandler.BowlOfRiceID, IdentificationHandler.BowlOfRiceFood, 0.7F).setContainerItem(Item.bowlEmpty).setUnlocalizedName("riceBowl");
		Items.tomatoStew = new BowlFood(IdentificationHandler.tomatoAndOnionSalladID, IdentificationHandler.tomatoAndOnionSalladFood, 0.8F).setUnlocalizedName("stewTomato");
		Items.carrotStew = new BowlFood(IdentificationHandler.carrotStewID, IdentificationHandler.carrotStewFood, 0.8F).setUnlocalizedName("stewCarrot");
		Items.beefStew = new BowlFood(IdentificationHandler.beefStewID, IdentificationHandler.beefStewFood, 1F).setUnlocalizedName("stewBeef");
		Items.onionStew = new BowlFood(IdentificationHandler.onionStewID, IdentificationHandler.onionStewFood, 0.8F).setUnlocalizedName("stewOnion");
		Items.beefSoup = new BowlFood(IdentificationHandler.beefSoupID, IdentificationHandler.beefSoupFood, 1F).setUnlocalizedName("soupBeef");
		Items.macaroniAndCheese = new BowlFood(IdentificationHandler.macaroniAndCheeseID, IdentificationHandler.macaroniAndCheeseFood, 0.8F).setUnlocalizedName("macaroneAndCheese");
		Items.porridge = new BowlPorridge(IdentificationHandler.porridgeID, IdentificationHandler.porridgeFood, 0.8F).setUnlocalizedName("porridge");
		Items.guacamole = (BowlFood) new BowlFood(IdentificationHandler.guacamoleID, IdentificationHandler.guacamoleFood, 0.5F).setUnlocalizedName("guacamole");
	}
	
	public static void loadSuchiAndSea(){
		Items.MakiLong = new mFCItem(IdentificationHandler.MakiLongID).setUnlocalizedName("suchiMakiLong");
		Items.MakiShort = new mFCFood(IdentificationHandler.MakiShortID, IdentificationHandler.MakiFood, 16, 0.5F).setUnlocalizedName("suchiMaki");
		Items.LaxSuchi = new mFCFood(IdentificationHandler.SalmonSuchiID, IdentificationHandler.LaxSuchiFood, 16, 0.5F).setUnlocalizedName("suchiLax");
		Items.wasabi = new mFCItem(IdentificationHandler.WasabiID).setUnlocalizedName("wasabiPaste");
	}
	
	public static void loadOtherFood(){
		Items.beefJerky = (new mFCFood(IdentificationHandler.BeefJerkyID, IdentificationHandler.BeefJerkyFood, 16, 0.6F)).setUnlocalizedName("beefJerky");
		Items.saltPile = (new mFCItem(IdentificationHandler.SaltID)).setUnlocalizedName("salt");
		Items.bottleOfOil = (new mFCItem(IdentificationHandler.OilID)).setUnlocalizedName("oil").setMaxStackSize(1).setContainerItem(Item.glassBottle);
		Items.palt = (new mFCFood(IdentificationHandler.paltID, IdentificationHandler.paltFood, 16, 0.9F)).setUnlocalizedName("palt");
		Items.pancake = (new Pancake(IdentificationHandler.pancakesID, IdentificationHandler.pancakesFood, 16, 0.9F)).setUnlocalizedName("pancake");
		Items.gingerBread = new mFCFood(IdentificationHandler.gingerBreadID, IdentificationHandler.gingerBreadFood, 16, 0.4F).setUnlocalizedName("christmasBread");
		Items.candyCane = new mFCFood(IdentificationHandler.candyCaneID, IdentificationHandler.candyCaneFood, 16, 0.4F).setPotionEffect(Potion.regeneration.id, 4, 0, 1F).setUnlocalizedName("christmasCane");
		Items.dogFood = new mFCFood(IdentificationHandler.dogFoodID, IdentificationHandler.dogFoodFood, 16, 0.05F, true).setPotionEffect(Potion.hunger.id, 60, 0, 1.0F).setUnlocalizedName("dogFood");
		Items.jamJar = new mFCItem(IdentificationHandler.jamJarID).setUnlocalizedName("jamJar");
		Items.StrawBerryjam = new FarmJam(IdentificationHandler.StrawBerryjamID, IdentificationHandler.StrawBerryjamFood).setUnlocalizedName("jamStrawBerry");
		Items.RaspBerryjam = new FarmJam(IdentificationHandler.RaspBerryjamID, IdentificationHandler.RaspBerryjamFood).setUnlocalizedName("jamRaspBerry");
		Items.chocolateBar = new mFCFood(IdentificationHandler.chocolateBarID, IdentificationHandler.chocolateBarFood, 4, 0.4F).setUnlocalizedName("chocolateBar");
		Items.pumpkinPiece = new mFCItem(IdentificationHandler.pumpkinPieceID).setUnlocalizedName("pumpkinPiece");
		Items.roastPumpkin = new FarmPum(IdentificationHandler.roastPumpkinID,IdentificationHandler.roastPumpkinFood).setUnlocalizedName("pumpkinRoast");
		Items.cornCobCooked = new mFCFood(IdentificationHandler.cornCobCookedID,IdentificationHandler.cornCobCookedFood, 8, 0.5F).setUnlocalizedName("cornCob");
	}
	
	public static void loadVegetables(){
		Items.onion = new ItemSeedFood_mFC(IdentificationHandler.onionID, IdentificationHandler.onionFood, 0.05F, Blocks.onionPlant.blockID, Block.tilledField.blockID).setUnlocalizedName("vegOnion").setMaxStackSize(8);
		Items.strawBerry = new mFCFood(IdentificationHandler.strawBerryID, IdentificationHandler.strawBerryFood, 8, 0.05F).setUnlocalizedName("vegStrawBerry");
		Items.raspBerry = new mFCFood(IdentificationHandler.raspBerryID, IdentificationHandler.raspBerryFood, 8, 0.05F).setUnlocalizedName("vegRaspBerry");
		Items.grapes = new mFCFood(IdentificationHandler.grapesID, IdentificationHandler.grapesFood, 16, 0.05F).setUnlocalizedName("fruitGrape");
		Items.avacado = new FarmFruitFood(IdentificationHandler.avacadoID, IdentificationHandler.avacadoFood, 0.05F, Items.AvacadoSeeds.itemID).setUnlocalizedName("fruitAvocado");
		Items.orange = new FarmFruitFood(IdentificationHandler.orangeID, IdentificationHandler.orangeFood, 0.05F, Items.OrangeSeeds.itemID).setUnlocalizedName("fruitOrange");
		Items.cornCob = new mFCFood(IdentificationHandler.cornCobID,IdentificationHandler.cornCobFood, 8, 0.05F).setUnlocalizedName("vegCorn");
		Items.tomato = new mFCFood(IdentificationHandler.tomatoID,IdentificationHandler.tomatoFood, 8, 0.05F).setUnlocalizedName("vegTomato");
		Items.lettuce = new mFCFood(IdentificationHandler.lettuceID, IdentificationHandler.lettuceFood, 8, 0.05F).setUnlocalizedName("vegLettuce");
		Items.Rice = new mFCItem(IdentificationHandler.RiceID).setUnlocalizedName("rice");
	}
	
	public static void loadSeeds(){
		Items.AvacadoSeeds = (FarmTreeSeed) (new FarmTreeSeed(IdentificationHandler.avacadonutID, 3)).setUnlocalizedName("seedAvocado");
		Items.OrangeSeeds = (FarmTreeSeed) (new FarmTreeSeed(IdentificationHandler.orangecoresID, 2)).setUnlocalizedName("seedOrange");
		Items.CocoaFruit = (FarmTreeSeed) (new FarmTreeSeed(IdentificationHandler.cocoaID, 4)).setUnlocalizedName("fruitCocoa");
		Items.AppleSeeds = (FarmTreeSeed) (new FarmTreeSeed(IdentificationHandler.applesnufkinID, 1)).setUnlocalizedName("seedApple");
		Items.yellowSeeds = new FarmSeeds(IdentificationHandler.yellowSeedsID, Blocks.yellowSeedling.blockID).setUnlocalizedName("seedYellow");
		Items.redSeeds = new FarmSeeds(IdentificationHandler.redSeedsID, Blocks.redSeedling.blockID).setUnlocalizedName("seedRed");
		Items.cornSeeds = new FarmSeeds(IdentificationHandler.cornSeedsID, Blocks.cornPlant.blockID).setUnlocalizedName("seedCorn");
		Items.lettuceSeeds = new FarmSeeds(IdentificationHandler.lettuceSeedsID, Blocks.lettucePlant.blockID).setUnlocalizedName("seedLettuce");
		Items.riceSeeds = new FarmSeeds(IdentificationHandler.riceSeedsID, Blocks.ricePlant.blockID, 1).setUnlocalizedName("seedRice");
		Items.grapeSeeds = new mFCItem(IdentificationHandler.grapeSeedsID).setUnlocalizedName("seedGrape");
		Items.tomatoSeeds = new FarmSeeds(IdentificationHandler.tomatoSeedsID, Blocks.tomatoPlant.blockID).setUnlocalizedName("seedTomato");
		Items.raspBerrySeeds = new FarmSeeds(IdentificationHandler.raspBerrySeedsID, Blocks.raspBerryPlant.blockID).setUnlocalizedName("seedRaspBerry");
		Items.strawBerrySeeds = new FarmSeeds(IdentificationHandler.strawBerrySeedsID, Blocks.strawBerryPlant.blockID).setUnlocalizedName("seedStrawBerry");
		Items.wasabiRoot = new FarmSeeds(IdentificationHandler.WasabiRootID, Blocks.wasabiPlant.blockID).setUnlocalizedName("wasabiRoot").setMaxStackSize(8);
	}
	
	public static void loadCrops(){
        Blocks.grapePlant = (CropGrape) (new CropGrape(IdentificationHandler.grapesPlantBlock)).setUnlocalizedName("grapeTrellis").setStepSound(Block.soundGrassFootstep);
        Blocks.onionPlant = (CropOnion) (new CropOnion(IdentificationHandler.onionPlantBlock)).setUnlocalizedName("onion").setStepSound(Block.soundGrassFootstep);
        Blocks.ricePlant = (CropRice) (new CropRice(IdentificationHandler.ricePlantBlock)).setUnlocalizedName("rice").setStepSound(Block.soundGrassFootstep);
        Blocks.yellowSeedling = (FarmFlower) (new FarmFlower(IdentificationHandler.yellowSeedlingBlock, Block.plantYellow.blockID, IdentificationHandler.yellowSeedsID)).setUnlocalizedName("yellowFlower");
		Blocks.redSeedling = (FarmFlower) (new FarmFlower(IdentificationHandler.redSeedlingBlock, Block.plantRed.blockID, IdentificationHandler.redSeedsID)).setUnlocalizedName("redFlower");
		Blocks.cornPlant = (CropCorn) (new CropCorn(IdentificationHandler.cornPlantBlock)).setUnlocalizedName("corn").setStepSound(Block.soundGrassFootstep);
		Blocks.lettucePlant = (CropLettuce) (new CropLettuce(IdentificationHandler.lettucePlantBlock)).setUnlocalizedName("lettuce").setStepSound(Block.soundGrassFootstep);
		Blocks.wasabiPlant = (CropWasabi) (new CropWasabi(IdentificationHandler.wasabiPlantBlock)).setUnlocalizedName("wasabi").setStepSound(Block.soundGrassFootstep);
		Blocks.tomatoPlant = (CropBush) (new CropBush(IdentificationHandler.tomatoPlantBlock, 6, IdentificationHandler.tomatoID+256, IdentificationHandler.tomatoSeedsID, false)).setUnlocalizedName("tomato").setStepSound(Block.soundGrassFootstep);
		Blocks.raspBerryPlant = (CropBush) (new CropBush(IdentificationHandler.raspBerryPlantBlock, 5, IdentificationHandler.raspBerryID+256, IdentificationHandler.raspBerrySeedsID, true)).setUnlocalizedName("raspBerry").setStepSound(Block.soundGrassFootstep);
		Blocks.strawBerryPlant = (CropBush) (new CropBush(IdentificationHandler.strawBerryPlantBlock, 5, IdentificationHandler.strawBerryID+256, IdentificationHandler.strawBerrySeedsID, true)).setUnlocalizedName("strawBerry").setStepSound(Block.soundGrassFootstep);
	}
	
	public static void loadFoodBlocks(){
		Blocks.ApplePie = (new FarmPie(IdentificationHandler.ApplePieBlock)).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("applePie");
	    Blocks.TacoPie = (new FarmPie(IdentificationHandler.TacoPieBlock)).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("tacoPie");
	    Blocks.ChocolateCake = (new FarmPie(IdentificationHandler.ChocolateCakeBlock)).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("chocolateCake");
	    Blocks.MeatPie = (new FarmPie(IdentificationHandler.MeatPieBlock)).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("meatPie");
	    Items.itemApplePie = (new ItemBlockmFC(IdentificationHandler.ApplePieID, Blocks.ApplePie)).setMaxStackSize(64).setUnlocalizedName("pieApple");
	    Items.itemTacoPie = (new ItemBlockmFC(IdentificationHandler.TacoPieID, Blocks.TacoPie)).setMaxStackSize(64).setUnlocalizedName("pieTaco");
	    Items.itemChocolateCake = (new ItemBlockmFC(IdentificationHandler.ChocolateCakeID, Blocks.ChocolateCake)).setMaxStackSize(64).setUnlocalizedName("cakeChocolate");
	    Items.itemMeatPie = (new ItemBlockmFC(IdentificationHandler.MeatPieID, Blocks.MeatPie)).setMaxStackSize(64).setUnlocalizedName("pieMeat");
        Items.cheeseWheel = (new ItemBlockmFC(IdentificationHandler.CheeseBlockID, Blocks.cheeseWheelBlock)).setUnlocalizedName("cheeseWheel").setMaxStackSize(4).setCreativeTab(CreativeTabs.tabFood);
	}
	
	public static void loadMiscBlocks(){
		Blocks.woodenTrellis = new WoodenTrellis(IdentificationHandler.GrapeHolderBlock, 64).setUnlocalizedName("woodenTrellis");
		Blocks.fruitSaplings = (new FruitSaplings(IdentificationHandler.Saplings)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("sapling");
		Blocks.avacadoBlock = (new FarmFruit(IdentificationHandler.avacadoBlock, Items.avacado.itemID)).setUnlocalizedName("fruitAvocado").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		Blocks.orangeBlock = (new FarmFruit(IdentificationHandler.orangeBlock, Items.orange.itemID)).setUnlocalizedName("fruitOrange").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		Blocks.cocoaBlock = (new FarmCocoa(IdentificationHandler.cocoaBlock)).setUnlocalizedName("fruitCocoa").setHardness(0.5F).setStepSound(Block.soundWoodFootstep);
		Blocks.saltBlock = (new FarmSalt(IdentificationHandler.saltBlock)).setUnlocalizedName("blockSalt").setHardness(0.0F).setStepSound(Block.soundSandFootstep);
		Blocks.cheeseWheelBlock = (new FarmCheese(IdentificationHandler.cheeseBlock, 68)).setUnlocalizedName("blockCheese").setHardness(0.2F).setStepSound(Block.soundPowderFootstep);
		if(mFC.oldApple){
			Blocks.appleBlock = (new FarmFruit(IdentificationHandler.appleBlock, Item.appleRed.itemID)).setUnlocalizedName("fruitApple").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		}else{
			Blocks.appleBlock = (new FarmFruit(IdentificationHandler.appleBlock, Item.appleRed.itemID)).setUnlocalizedName("fruitAppleNew").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		}
		Blocks.leaves = (FruitLeaves) new FruitLeaves(IdentificationHandler.leavesBlock).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep);
		Blocks.plate = new BlockPlate(IdentificationHandler.PlateBlock, Material.wood).setUnlocalizedName("plate").setStepSound(Block.soundWoodFootstep);
		Blocks.shelf = new BlockShelf(IdentificationHandler.shelfBlock, Material.wood).setUnlocalizedName("shelf").setStepSound(Block.soundWoodFootstep);
		//Christmas special, maybe next year again.
		//present = new BlockPresent(FarmBase.presentBlock, 91, Material.cloth).setUnlocalizedName("present").setCreativeTab(CreativeTabs.tabDecorations).setTextureFile(mFC.BlockTex).setStepSound(Block.soundClothFootstep);
	}
	
	public static void loadTileEntitys(){
		GameRegistry.registerTileEntity(TileEntityBeerKeg.class, "BeerKeg");
		GameRegistry.registerTileEntity(TileEntityPlate.class, "Plate");
		GameRegistry.registerTileEntity(TileEntityShelf.class, "Shelf");
		GameRegistry.registerTileEntity(TileEntityCauldron.class, "BoilCauldron");
	}
	
	public static void loadEntitys(mFC mfc){
		EntityRegistry.registerModEntity(EntityCauldronItem.class, "cauldronID", 150, mfc, 86, 1, true);
	}
	
	public static void setShelfItems(){
		ApiCommon.shelfItems.add(Item.potion);
		ApiCommon.shelfItems.add(Item.glassBottle);
		ApiCommon.shelfItems.add(Items.tallBottle);
		ApiCommon.shelfItems.add(Items.whiteWine);
		ApiCommon.shelfItems.add(Items.redWine);
		ApiCommon.shelfItems.add(Items.christmasMust);
		ApiCommon.shelfItems.add(Items.jamJar);
		ApiCommon.shelfItems.add(Items.StrawBerryjam);
		ApiCommon.shelfItems.add(Items.RaspBerryjam);
	}
	
	public static void registerBlocks(){
		GameRegistry.registerBlock(Blocks.yellowSeedling, "Yellow Seedling");
		GameRegistry.registerBlock(Blocks.redSeedling, "Red Seedling");
		GameRegistry.registerBlock(Blocks.tomatoPlant, "Tomato plant");
		GameRegistry.registerBlock(Blocks.raspBerryPlant, "Raspberry plant");
		GameRegistry.registerBlock(Blocks.strawBerryPlant, "Strawberry plant");
		GameRegistry.registerBlock(Blocks.cornPlant, "Corn plant");
		GameRegistry.registerBlock(Blocks.lettucePlant, "Lettuce plant");
		GameRegistry.registerBlock(Blocks.wasabiPlant, "Wasabi root");
		GameRegistry.registerBlock(Blocks.ricePlant, "Rice plant");
		GameRegistry.registerBlock(Blocks.onionPlant, "Onion plant");
		GameRegistry.registerBlock(Blocks.grapePlant, "Grape plant");
		GameRegistry.registerBlock(Blocks.beerKeg, "Beer keg");
		GameRegistry.registerBlock(Blocks.saltBlock, "Salt block");
		GameRegistry.registerBlock(Blocks.cheeseWheelBlock, "Cheese wheel");
		GameRegistry.registerBlock(Blocks.fruitSaplings, "Fruit tree sapling");
		GameRegistry.registerBlock(Blocks.appleBlock, "Apple block");
		GameRegistry.registerBlock(Blocks.avacadoBlock, "Avocado block");
		GameRegistry.registerBlock(Blocks.orangeBlock, "Orange block");
		GameRegistry.registerBlock(Blocks.cocoaBlock, "Cocoa block");
		GameRegistry.registerBlock(Blocks.woodenTrellis, "Wooden trellis");
		GameRegistry.registerBlock(Blocks.plate, "Plate");
		GameRegistry.registerBlock(Blocks.shelf, "Shelf");
//		GameRegistry.registerBlock(mFC.present);
	}
}

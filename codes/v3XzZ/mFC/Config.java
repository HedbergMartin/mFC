package v3XzZ.mFC;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import v3XzZ.mFC.Blocks.BlockBeerKeg;
import v3XzZ.mFC.Blocks.BlockPlate;
import v3XzZ.mFC.Blocks.BlockShelf;
import v3XzZ.mFC.Blocks.CropBush;
import v3XzZ.mFC.Blocks.CropCorn;
import v3XzZ.mFC.Blocks.CropGrape;
import v3XzZ.mFC.Blocks.CropLettuce;
import v3XzZ.mFC.Blocks.CropOnion;
import v3XzZ.mFC.Blocks.CropRice;
import v3XzZ.mFC.Blocks.CropWasabi;
import v3XzZ.mFC.Blocks.FarmCheese;
import v3XzZ.mFC.Blocks.FarmCocoa;
import v3XzZ.mFC.Blocks.FarmFlower;
import v3XzZ.mFC.Blocks.FarmFruit;
import v3XzZ.mFC.Blocks.FarmPie;
import v3XzZ.mFC.Blocks.FarmSalt;
import v3XzZ.mFC.Blocks.FruitLeaves;
import v3XzZ.mFC.Blocks.FruitSaplings;
import v3XzZ.mFC.Blocks.WoodenTrellis;
import v3XzZ.mFC.Items.BowlPorridge;
import v3XzZ.mFC.Items.ItemBlockmFC;
import v3XzZ.mFC.Items.BowlFood;
import v3XzZ.mFC.Items.FarmAxe;
import v3XzZ.mFC.Items.FarmBucket;
import v3XzZ.mFC.Items.FarmCup;
import v3XzZ.mFC.Items.FarmDrink;
import v3XzZ.mFC.Items.FarmFood;
import v3XzZ.mFC.Items.FarmFruitFood;
import v3XzZ.mFC.Items.FarmHoe;
import v3XzZ.mFC.Items.FarmItem;
import v3XzZ.mFC.Items.FarmJam;
import v3XzZ.mFC.Items.FarmMilk;
import v3XzZ.mFC.Items.FarmPickaxe;
import v3XzZ.mFC.Items.FarmPum;
import v3XzZ.mFC.Items.FarmSeeds;
import v3XzZ.mFC.Items.FarmSpade;
import v3XzZ.mFC.Items.FarmSword;
import v3XzZ.mFC.Items.FarmTreeSeed;
import v3XzZ.mFC.Items.ItemSeedFood_mFC;
import v3XzZ.mFC.Items.ItemTallBottleDrink;
import v3XzZ.mFC.Items.Pancake;
import v3XzZ.mFC.lib.Blocks;
import v3XzZ.mFC.lib.Items;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;

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
		Items.obsidianPick = new FarmPickaxe(Identifications.obsidianPickID, FarmToolMat.OBSIDIAN).setUnlocalizedName("pickaxeObsidian");
		Items.obsidianShovel = new FarmSpade(Identifications.obsidianShovelID, FarmToolMat.OBSIDIAN).setUnlocalizedName("shovelObsidian");
		Items.obsidianAxe = new FarmAxe(Identifications.obsidianAxeID, FarmToolMat.OBSIDIAN).setUnlocalizedName("axeObsidian");
		Items.obsidianHoe = new FarmHoe(Identifications.obsidianHoeID, FarmToolMat.OBSIDIAN).setUnlocalizedName("hoeObsidian");
		Items.obsidianSword = new FarmSword(Identifications.obsidianSwordID, FarmToolMat.OBSIDIAN).setUnlocalizedName("swordObsidian");
		Items.Knife = (new FarmSword(Identifications.KnifeID, FarmToolMat.IRON)).setMaxStackSize(1).setUnlocalizedName("knife").setFull3D().setMaxStackSize(1).setContainerItem(Items.Knife);
	}
	
	public static void loadModern(){
		Items.hamburgerBread = (new FarmFood(Identifications.HamburgerBreadID, Identifications.HamburgerBreadFood, 16, 0.1F)).setUnlocalizedName("modern/hamburgerBread");
		Items.hamburgerOrginal = (new FarmFood(Identifications.HamBurgerID, Identifications.HamBurgerFood, 16, 0.8F)).setUnlocalizedName("modern/hamburgerOriginal");
		Items.hamburgerCheese = (new FarmFood(Identifications.CheeseBurgerID, Identifications.CheeseBurgerFood, 16, 0.9F)).setUnlocalizedName("modern/hamburgerCheese");
		Items.hamburgerRaw = (new FarmFood(Identifications.RawHamburgerMeatID, Identifications.RawHamburgerMeatFood, 16, 0.1F)).setUnlocalizedName("modern/hamburgerRaw");
		Items.hamburger = (new FarmFood(Identifications.HamburgerMeatID, Identifications.HamburgerMeatFood, 16, 0.5F)).setUnlocalizedName("modern/hamburger");
		Items.frenchFries = (new FarmFood(Identifications.StripsID, Identifications.StripsFood, 16, 0.6F)).setUnlocalizedName("modern/frenchFries");
		Items.hamburgerBacon = (new FarmFood(Identifications.CheeseBaconBurgerID, Identifications.CheeseBaconBurgerFood, 16, 0.9F)).setUnlocalizedName("modern/hamburgerBacon");
		Items.hotDog = (new FarmFood(Identifications.HotDogID, Identifications.HotDogFood, 16, 0.6F)).setUnlocalizedName("modern/hotdog");
		Items.hotDogKetchup = (new FarmFood(Identifications.HotDogKetchupID, Identifications.HotDogKetchupFood, 16, 0.6F)).setUnlocalizedName("modern/hotdogKetchup");
		Items.bottleOfKetchup = (new FarmItem(Identifications.KetchupID)).setUnlocalizedName("modern/ketchup").setMaxStackSize(1).setContainerItem(Item.glassBottle);
	}
	
	public static void loadDairy(){
		Items.moldEmpty = (new FarmItem(Identifications.CheeseMoldID)).setUnlocalizedName("moldEmpty");
		Items.moldMilk = (new FarmItem(Identifications.CheeseMoldMilkID)).setUnlocalizedName("moldMilk");
		Items.moldCheese = (new FarmItem(Identifications.CheeseMoldCheeseID)).setUnlocalizedName("moldCheese").setMaxStackSize(1).setContainerItem(Items.moldEmpty);
		Items.cheesePiece = (new FarmFood(Identifications.CheesePieceID, Identifications.CheesePieceFood, 16, 0.1F)).setUnlocalizedName("cheesePiece");
	}
	
	public static void loadDrinkingRelated(){
		Items.drinkingGlass = (new FarmItem(Identifications.DrinkingGlassID)).setUnlocalizedName("glass").setMaxStackSize(2);
		Items.glassWater = (new FarmDrink(Identifications.BottleWaterID, Identifications.BottleWaterFood)).setUnlocalizedName("glassWater");
		Items.clayCup = (new FarmItem(Identifications.CupUnburnedID)).setUnlocalizedName("cupClay").setMaxStackSize(1);
		Items.cup = (new FarmItem(Identifications.CupID)).setUnlocalizedName("cup").setMaxStackSize(2);
		Items.cupChocolate = (new FarmCup(Identifications.CupChoklateID, Identifications.CupChoklateFood)).setMaxStackSize(3).setUnlocalizedName("cupChocolate");
		Items.cupTea = (new FarmCup(Identifications.CupTeaID, Identifications.CupTeaFood)).setUnlocalizedName("CupTea");
		Items.clayTeapot = (new FarmItem(Identifications.TeaCanUnburnedID)).setUnlocalizedName("potClay").setMaxStackSize(1);
		Items.teapot = (new FarmItem(Identifications.TeaCanID)).setUnlocalizedName("pot").setMaxStackSize(1);
		Items.teapotCold = (new FarmItem(Identifications.ColdTeaCanID)).setUnlocalizedName("potCold").setMaxStackSize(1);
		Items.teapotHot = (new FarmItem(Identifications.HotTeaCanID)).setUnlocalizedName("potHot").setMaxStackSize(1).setContainerItem(Items.teapot);
		Items.glassMelonJuice = (new FarmDrink(Identifications.MelonJuiceID, Identifications.MelonJuiceFood)).setUnlocalizedName("glassMelonJuice");
		Items.glassAppleJuice = (new FarmDrink(Identifications.AppleJuiceID, Identifications.AppleJuiceFood)).setUnlocalizedName("glassAppleJuice");
		Items.glassStrawBerryJuice = (new FarmDrink(Identifications.StrawBerryJuiceID, Identifications.StrawBerryJuiceFood)).setUnlocalizedName("glassStrawBerryJuice");
		Items.glassRaspBerryJuice = (new FarmDrink(Identifications.RaspBerryJuiceID, Identifications.RaspBerryJuiceFood)).setUnlocalizedName("glassRaspBerryJuice");
		Items.orangeJuice = (FarmDrink) (new FarmDrink(Identifications.orangeJuiceID, Identifications.orangeJuiceFood)).setUnlocalizedName("glassJuice");
	}
	
	public static void loadSandwichAndRelated(){
		Items.baconRaw = (new FarmFood(Identifications.RawBaconID, Identifications.RawBaconFood, 8, 0.1F)).setUnlocalizedName("baconRaw");
		Items.bacon = (new FarmFood(Identifications.BaconID, Identifications.BaconFood, 8, 0.4F)).setUnlocalizedName("bacon");
		Items.friedEgg = (new FarmFood(Identifications.friedEggID, Identifications.friedEggFood, 4, 0.4F)).setUnlocalizedName("friedEgg");
		Items.breadSlice = (new FarmFood(Identifications.BreadSliceID, Identifications.BreadSliceFood, 8, 0.1F)).setUnlocalizedName("breadSlice");
		Items.sandwichEgg = (new FarmFood(Identifications.EggSandwichID, Identifications.EggSandwichFood, 4, 0.9F)).setUnlocalizedName("sandwichEgg");
		Items.sandwichBacon = (new FarmFood(Identifications.EggBaconSandwichID, Identifications.EggBaconSandwichFood, 4, 0.9F)).setUnlocalizedName("sandwichBacon");
		Items.sausageRaw = (new FarmFood(Identifications.HotDogRawID, Identifications.HotDogRawFood, 8, 0.1F)).setUnlocalizedName("sausageRaw");
		Items.sausage = (new FarmFood(Identifications.HotDogGrilledID, Identifications.HotDogGrilledFood, 8, 0.4F)).setUnlocalizedName("sausage");
		Items.sandwichChicken = (new FarmFood(Identifications.ChickenSandwichID, Identifications.ChickenSandwichFood, 4, 0.9F)).setUnlocalizedName("sandwichChicken");
	}
	
	public static void loadBrewingAndRelated(){
		Items.beerCup = new FarmItem(Identifications.beerCupID).setUnlocalizedName("beerCup").setMaxStackSize(2);
		Items.beer = new ItemTallBottleDrink(Identifications.beerID, Identifications.beerFood, false, true).setPotionEffect(Potion.confusion.id, 30, 0, 0.4F)/*.setPotionEffect(Potion.resistance.id, 60, 0, 0.7F)*/.setUnlocalizedName("beer");
		Items.whiteWine = new ItemTallBottleDrink(Identifications.whiteWineID, Identifications.whiteWineFood, true, false).setPotionEffect(Potion.confusion.id, 40, 0, 0.6F)/*.setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F)*/.setUnlocalizedName("bottleWhitewine");
		Items.redWine = new ItemTallBottleDrink(Identifications.redWineID, Identifications.redWineFood,true, false).setPotionEffect(Potion.confusion.id, 40, 0, 0.6F)/*.setPotionEffect(Potion.jump.id, 60, 0, 0.8F)*/.setUnlocalizedName("bottleRedwine");
		Items.christmasMust = new ItemTallBottleDrink(Identifications.ChristmasMustID, Identifications.ChristmasMustFood,true, false).setPotionEffect(Potion.digSpeed.id, 60, 0, 0.8F).setUnlocalizedName("bottleChristmasmust");
		Items.tallBottle = new FarmItem(Identifications.tallBottleID).setUnlocalizedName("bottle").setMaxStackSize(16).setCreativeTab(CreativeTabs.tabMaterials);
		Items.beerBase = new FarmItem(Identifications.beerBaseID).setUnlocalizedName("beerBase");
		Items.redWineBase = new FarmItem(Identifications.redWineBaseID).setUnlocalizedName("redwineBase");
		Items.whiteWineBase = new FarmItem(Identifications.whiteWineBaseID).setUnlocalizedName("whitewineBase");
		Items.christmasMustBase = new FarmItem(Identifications.ChristmasMustBaseID).setUnlocalizedName("christamsmustBase");
		Items.malt = new FarmItem(Identifications.MaltID).setUnlocalizedName("malt");
		Blocks.beerKeg = new BlockBeerKeg(Identifications.beerKegBlockID).setUnlocalizedName("beerKeg").setHardness(0.8F).setStepSound(Block.soundWoodFootstep);
	}
	
	public static void loadMisc(){
		Items.woodenBucket = (new FarmBucket(Identifications.BucketID, 0)).setUnlocalizedName("woodenBucket");
		Items.woodenBucketWater = (new FarmBucket(Identifications.bucketWaterID, Block.waterMoving.blockID)).setUnlocalizedName("woodenBucketWater").setContainerItem(Items.woodenBucket);
		Items.woodenBucketMilk = (new FarmMilk(Identifications.bucketMilkID)).setUnlocalizedName("woodenBucketMilk").setContainerItem(Items.woodenBucket);
		Items.money = (new FarmItem(Identifications.DollarID)).setUnlocalizedName("money");
		Items.fork = new FarmItem(Identifications.forkID).setUnlocalizedName("fork");
	}
	
	public static void loadBowlFoodAndRelated(){
		Items.meatScrap = (new FarmFood(Identifications.MeatSauceID, Identifications.MeatSauceFood, 16, 0.3F)).setUnlocalizedName("meatScrap");
		Items.pasta = (new FarmItem(Identifications.PastaID)).setUnlocalizedName("pasta");
		Items.mayonnaise = (new BowlFood(Identifications.MayonnaiseID, Identifications.MayonnaiseFood, 0.4F)).setUnlocalizedName("mayonnaise");
		Items.saladPasta = (new BowlFood(Identifications.PastaSalladID, Identifications.PastaSalladFood, 0.8F)).setUnlocalizedName("saladPasta");
		Items.pastaMeat = (new BowlFood(Identifications.PastaMeatsauceID, Identifications.PastaMeatsauceFood, 0.9F)).setUnlocalizedName("pastaMeat");
		Items.saladCeasar = (new BowlFood(Identifications.CeasarSalladID, Identifications.CeasarSalladFood, 0.9F)).setUnlocalizedName("saladCeasar");
		Items.saladChicken = (new BowlFood(Identifications.ChickenSalladID, Identifications.ChickenSalladFood, 0.9F)).setUnlocalizedName("saladChicken");
		Items.bowlOfRice = new BowlFood(Identifications.BowlOfRiceID, Identifications.BowlOfRiceFood, 0.7F).setContainerItem(Item.bowlEmpty).setUnlocalizedName("riceBowl");
		Items.tomatoStew = new BowlFood(Identifications.tomatoAndOnionSalladID, Identifications.tomatoAndOnionSalladFood, 0.8F).setUnlocalizedName("stewTomato");
		Items.carrotStew = new BowlFood(Identifications.carrotStewID, Identifications.carrotStewFood, 0.8F).setUnlocalizedName("stewCarrot");
		Items.beefStew = new BowlFood(Identifications.beefStewID, Identifications.beefStewFood, 1F).setUnlocalizedName("stewBeef");
		Items.onionStew = new BowlFood(Identifications.onionStewID, Identifications.onionStewFood, 0.8F).setUnlocalizedName("stewOnion");
		Items.beefSoup = new BowlFood(Identifications.beefSoupID, Identifications.beefSoupFood, 1F).setUnlocalizedName("soupBeef");
		Items.macaroniAndCheese = new BowlFood(Identifications.macaroniAndCheeseID, Identifications.macaroniAndCheeseFood, 0.8F).setUnlocalizedName("macaroneAndCheese");
		Items.porridge = new BowlPorridge(Identifications.porridgeID, Identifications.porridgeFood, 0.8F).setUnlocalizedName("porridge");
		Items.guacamole = (BowlFood) new BowlFood(Identifications.guacamoleID, Identifications.guacamoleFood, 0.5F).setUnlocalizedName("guacamole");
	}
	
	public static void loadSuchiAndSea(){
		Items.MakiLong = new FarmItem(Identifications.MakiLongID).setUnlocalizedName("suchiMakiLong");
		Items.MakiShort = new FarmFood(Identifications.MakiShortID, Identifications.MakiFood, 16, 0.5F).setUnlocalizedName("suchiMaki");
		Items.LaxSuchi = new FarmFood(Identifications.SalmonSuchiID, Identifications.LaxSuchiFood, 16, 0.5F).setUnlocalizedName("suchiLax");
		Items.wasabi = new FarmItem(Identifications.WasabiID).setUnlocalizedName("wasabiPaste");
	}
	
	public static void loadOtherFood(){
		Items.beefJerky = (new FarmFood(Identifications.BeefJerkyID, Identifications.BeefJerkyFood, 16, 0.6F)).setUnlocalizedName("beefJerky");
		Items.saltPile = (new FarmItem(Identifications.SaltID)).setUnlocalizedName("salt");
		Items.bottleOfOil = (new FarmItem(Identifications.OilID)).setUnlocalizedName("oil").setMaxStackSize(1).setContainerItem(Item.glassBottle);
		Items.palt = (new FarmFood(Identifications.paltID, Identifications.paltFood, 16, 0.9F)).setUnlocalizedName("palt");
		Items.pancake = (new Pancake(Identifications.pancakesID, Identifications.pancakesFood, 16, 0.9F)).setUnlocalizedName("pancake");
		Items.gingerBread = new FarmFood(Identifications.gingerBreadID, Identifications.gingerBreadFood, 16, 0.4F).setUnlocalizedName("christmasBread");
		Items.candyCane = new FarmFood(Identifications.candyCaneID, Identifications.candyCaneFood, 16, 0.4F).setPotionEffect(Potion.regeneration.id, 4, 0, 1F).setUnlocalizedName("christmasCane");
		Items.dogFood = new FarmFood(Identifications.dogFoodID, Identifications.dogFoodFood, 16, 0.05F, true).setPotionEffect(Potion.hunger.id, 60, 0, 1.0F).setUnlocalizedName("dogFood");
		Items.jamJar = new FarmItem(Identifications.jamJarID).setUnlocalizedName("jamJar");
		Items.StrawBerryjam = new FarmJam(Identifications.StrawBerryjamID, Identifications.StrawBerryjamFood).setUnlocalizedName("jamStrawBerry");
		Items.RaspBerryjam = new FarmJam(Identifications.RaspBerryjamID, Identifications.RaspBerryjamFood).setUnlocalizedName("jamRaspBerry");
		Items.chocolateBar = new FarmFood(Identifications.chocolateBarID, Identifications.chocolateBarFood, 4, 0.4F).setUnlocalizedName("chocolateBar");
		Items.pumpkinPiece = new FarmItem(Identifications.pumpkinPieceID).setUnlocalizedName("pumpkinPiece");
		Items.roastPumpkin = new FarmPum(Identifications.roastPumpkinID,Identifications.roastPumpkinFood).setUnlocalizedName("pumpkinRoast");
		Items.cornCobCooked = new FarmFood(Identifications.cornCobCookedID,Identifications.cornCobCookedFood, 8, 0.5F).setUnlocalizedName("cornCob");
	}
	
	public static void loadVegetables(){
		Items.onion = new ItemSeedFood_mFC(Identifications.onionID, Identifications.onionFood, 0.05F, Blocks.onionPlant.blockID, Block.tilledField.blockID).setUnlocalizedName("vegOnion").setMaxStackSize(8);
		Items.strawBerry = new FarmFood(Identifications.strawBerryID, Identifications.strawBerryFood, 8, 0.05F).setUnlocalizedName("vegStrawBerry");
		Items.raspBerry = new FarmFood(Identifications.raspBerryID, Identifications.raspBerryFood, 8, 0.05F).setUnlocalizedName("vegRaspBerry");
		Items.grapes = new FarmFood(Identifications.grapesID, Identifications.grapesFood, 16, 0.05F).setUnlocalizedName("fruitGrape");
		Items.avacado = new FarmFruitFood(Identifications.avacadoID, Identifications.avacadoFood, 0.05F, Items.AvacadoSeeds.itemID).setUnlocalizedName("fruitAvocado");
		Items.orange = new FarmFruitFood(Identifications.orangeID, Identifications.orangeFood, 0.05F, Items.OrangeSeeds.itemID).setUnlocalizedName("fruitOrange");
		Items.cornCob = new FarmFood(Identifications.cornCobID,Identifications.cornCobFood, 8, 0.05F).setUnlocalizedName("vegCorn");
		Items.tomato = new FarmFood(Identifications.tomatoID,Identifications.tomatoFood, 8, 0.05F).setUnlocalizedName("vegTomato");
		Items.lettuce = new FarmFood(Identifications.lettuceID, Identifications.lettuceFood, 8, 0.05F).setUnlocalizedName("vegLettuce");
		Items.Rice = new FarmItem(Identifications.RiceID).setUnlocalizedName("rice");
	}
	
	public static void loadSeeds(){
		Items.AvacadoSeeds = (FarmTreeSeed) (new FarmTreeSeed(Identifications.avacadonutID, 3)).setUnlocalizedName("seedAvocado");
		Items.OrangeSeeds = (FarmTreeSeed) (new FarmTreeSeed(Identifications.orangecoresID, 2)).setUnlocalizedName("seedOrange");
		Items.CocoaFruit = (FarmTreeSeed) (new FarmTreeSeed(Identifications.cocoaID, 4)).setUnlocalizedName("fruitCocoa");
		Items.AppleSeeds = (FarmTreeSeed) (new FarmTreeSeed(Identifications.applesnufkinID, 1)).setUnlocalizedName("seedApple");
		Items.yellowSeeds = new FarmSeeds(Identifications.yellowSeedsID, Blocks.yellowSeedling.blockID).setUnlocalizedName("seedYellow");
		Items.redSeeds = new FarmSeeds(Identifications.redSeedsID, Blocks.redSeedling.blockID).setUnlocalizedName("seedRed");
		Items.cornSeeds = new FarmSeeds(Identifications.cornSeedsID, Blocks.cornPlant.blockID).setUnlocalizedName("seedCorn");
		Items.lettuceSeeds = new FarmSeeds(Identifications.lettuceSeedsID, Blocks.lettucePlant.blockID).setUnlocalizedName("seedLettuce");
		Items.riceSeeds = new FarmSeeds(Identifications.riceSeedsID, Blocks.ricePlant.blockID, 1).setUnlocalizedName("seedRice");
		Items.grapeSeeds = new FarmItem(Identifications.grapeSeedsID).setUnlocalizedName("seedGrape");
		Items.tomatoSeeds = new FarmSeeds(Identifications.tomatoSeedsID, Blocks.tomatoPlant.blockID).setUnlocalizedName("seedTomato");
		Items.raspBerrySeeds = new FarmSeeds(Identifications.raspBerrySeedsID, Blocks.raspBerryPlant.blockID).setUnlocalizedName("seedRaspBerry");
		Items.strawBerrySeeds = new FarmSeeds(Identifications.strawBerrySeedsID, Blocks.strawBerryPlant.blockID).setUnlocalizedName("seedStrawBerry");
		Items.wasabiRoot = new FarmSeeds(Identifications.WasabiRootID, Blocks.wasabiPlant.blockID).setUnlocalizedName("wasabiRoot").setMaxStackSize(8);
	}
	
	public static void loadCrops(){
        Blocks.grapePlant = (CropGrape) (new CropGrape(Identifications.grapesPlantBlock)).setUnlocalizedName("grapeTrellis").setStepSound(Block.soundGrassFootstep);
        Blocks.onionPlant = (CropOnion) (new CropOnion(Identifications.onionPlantBlock)).setUnlocalizedName("onion").setStepSound(Block.soundGrassFootstep);
        Blocks.ricePlant = (CropRice) (new CropRice(Identifications.ricePlantBlock)).setUnlocalizedName("rice").setStepSound(Block.soundGrassFootstep);
        Blocks.yellowSeedling = (FarmFlower) (new FarmFlower(Identifications.yellowSeedlingBlock, Block.plantYellow.blockID, Identifications.yellowSeedsID)).setUnlocalizedName("yellowFlower");
		Blocks.redSeedling = (FarmFlower) (new FarmFlower(Identifications.redSeedlingBlock, Block.plantRed.blockID, Identifications.redSeedsID)).setUnlocalizedName("redFlower");
		Blocks.cornPlant = (CropCorn) (new CropCorn(Identifications.cornPlantBlock)).setUnlocalizedName("corn").setStepSound(Block.soundGrassFootstep);
		Blocks.lettucePlant = (CropLettuce) (new CropLettuce(Identifications.lettucePlantBlock)).setUnlocalizedName("lettuce").setStepSound(Block.soundGrassFootstep);
		Blocks.wasabiPlant = (CropWasabi) (new CropWasabi(Identifications.wasabiPlantBlock)).setUnlocalizedName("wasabi").setStepSound(Block.soundGrassFootstep);
		Blocks.tomatoPlant = (CropBush) (new CropBush(Identifications.tomatoPlantBlock, 6, Identifications.tomatoID+256, Identifications.tomatoSeedsID, false)).setUnlocalizedName("tomato").setStepSound(Block.soundGrassFootstep);
		Blocks.raspBerryPlant = (CropBush) (new CropBush(Identifications.raspBerryPlantBlock, 5, Identifications.raspBerryID+256, Identifications.raspBerrySeedsID, true)).setUnlocalizedName("raspBerry").setStepSound(Block.soundGrassFootstep);
		Blocks.strawBerryPlant = (CropBush) (new CropBush(Identifications.strawBerryPlantBlock, 5, Identifications.strawBerryID+256, Identifications.strawBerrySeedsID, true)).setUnlocalizedName("strawBerry").setStepSound(Block.soundGrassFootstep);
	}
	
	public static void loadFoodBlocks(){
		Blocks.ApplePie = (new FarmPie(Identifications.ApplePieBlock)).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("applePie");
	    Blocks.TacoPie = (new FarmPie(Identifications.TacoPieBlock)).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("tacoPie");
	    Blocks.ChocolateCake = (new FarmPie(Identifications.ChocolateCakeBlock)).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("chocolateCake");
	    Blocks.MeatPie = (new FarmPie(Identifications.MeatPieBlock)).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("meatPie");
	    Items.itemApplePie = (new ItemBlockmFC(Identifications.ApplePieID, Blocks.ApplePie)).setMaxStackSize(64).setUnlocalizedName("pieApple");
	    Items.itemTacoPie = (new ItemBlockmFC(Identifications.TacoPieID, Blocks.TacoPie)).setMaxStackSize(64).setUnlocalizedName("pieTaco");
	    Items.itemChocolateCake = (new ItemBlockmFC(Identifications.ChocolateCakeID, Blocks.ChocolateCake)).setMaxStackSize(64).setUnlocalizedName("cakeChocolate");
	    Items.itemMeatPie = (new ItemBlockmFC(Identifications.MeatPieID, Blocks.MeatPie)).setMaxStackSize(64).setUnlocalizedName("pieMeat");
        Items.cheeseWheel = (new ItemBlockmFC(Identifications.CheeseBlockID, Blocks.cheeseWheelBlock)).setUnlocalizedName("cheeseWheel").setMaxStackSize(4).setCreativeTab(CreativeTabs.tabFood);
	}
	
	public static void loadMiscBlocks(){
		Blocks.woodenTrellis = new WoodenTrellis(Identifications.GrapeHolderBlock, 64).setUnlocalizedName("woodenTrellis");
		Blocks.fruitSaplings = (new FruitSaplings(Identifications.Saplings)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("sapling");
		Blocks.avacadoBlock = (new FarmFruit(Identifications.avacadoBlock, Items.avacado.itemID)).setUnlocalizedName("fruitAvocado").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		Blocks.orangeBlock = (new FarmFruit(Identifications.orangeBlock, Items.orange.itemID)).setUnlocalizedName("fruitOrange").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		Blocks.cocoaBlock = (new FarmCocoa(Identifications.cocoaBlock)).setUnlocalizedName("fruitCocoa").setHardness(0.5F).setStepSound(Block.soundWoodFootstep);
		Blocks.saltBlock = (new FarmSalt(Identifications.saltBlock)).setUnlocalizedName("blockSalt").setHardness(0.0F).setStepSound(Block.soundSandFootstep);
		Blocks.cheeseWheelBlock = (new FarmCheese(Identifications.cheeseBlock, 68)).setUnlocalizedName("blockCheese").setHardness(0.2F).setStepSound(Block.soundPowderFootstep);
		if(mFC.oldApple){
			Blocks.appleBlock = (new FarmFruit(Identifications.appleBlock, Item.appleRed.itemID)).setUnlocalizedName("fruitApple").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		}else{
			Blocks.appleBlock = (new FarmFruit(Identifications.appleBlock, Item.appleRed.itemID)).setUnlocalizedName("fruitAppleNew").setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		}
		Blocks.leaves = (FruitLeaves) new FruitLeaves(Identifications.leavesBlock).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep);
		Blocks.plate = new BlockPlate(Identifications.PlateBlock, Material.wood).setUnlocalizedName("plate").setStepSound(Block.soundWoodFootstep);
		Blocks.shelf = new BlockShelf(Identifications.shelfBlock, Material.wood).setUnlocalizedName("shelf").setStepSound(Block.soundWoodFootstep);
		//Christmas special, maybe next year again.
		//present = new BlockPresent(FarmBase.presentBlock, 91, Material.cloth).setUnlocalizedName("present").setCreativeTab(CreativeTabs.tabDecorations).setTextureFile(mFC.BlockTex).setStepSound(Block.soundClothFootstep);
	}
	
	public static void loadTileEntitys(){
		GameRegistry.registerTileEntity(v3XzZ.mFC.Blocks.TileEntitys.TileEntityBeerKeg.class, "BeerKeg");
		GameRegistry.registerTileEntity(v3XzZ.mFC.Blocks.TileEntitys.TileEntityPlate.class, "Plate");
		GameRegistry.registerTileEntity(v3XzZ.mFC.Blocks.TileEntitys.TileEntityShelf.class, "Shelf");
		GameRegistry.registerTileEntity(v3XzZ.mFC.Blocks.TileEntitys.TileEntityCauldron.class, "BoilCauldron");
	}
	
	public static void loadEntitys(mFC mfc){
		EntityRegistry.registerModEntity(EntityCauldronItem.class, "cauldronID", 150, mfc, 86, 1, true);
	}
	
	public static void setShelfItems(){
		mFC.shelfItems.add(Item.potion);
		mFC.shelfItems.add(Item.glassBottle);
		mFC.shelfItems.add(Items.tallBottle);
		mFC.shelfItems.add(Items.whiteWine);
		mFC.shelfItems.add(Items.redWine);
		mFC.shelfItems.add(Items.christmasMust);
		mFC.shelfItems.add(Items.jamJar);
		mFC.shelfItems.add(Items.StrawBerryjam);
		mFC.shelfItems.add(Items.RaspBerryjam);
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

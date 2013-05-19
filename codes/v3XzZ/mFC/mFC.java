package v3XzZ.mFC;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import v3XzZ.mFC.Blocks.BlockNewCauldron;
import v3XzZ.mFC.Items.FarmFruitFood;
import v3XzZ.mFC.Recipes.BoilingRecipes;
import v3XzZ.mFC.Recipes.PlateRecipes;
import v3XzZ.mFC.Recipes.RecipeRegister;
import v3XzZ.mFC.client.ClientPacketHandler;
import v3XzZ.mFC.lib.Items;
import v3XzZ.mFC.lib.References;
import v3XzZ.mFC.worldgen.WorldGenerator;
import v3XzZ.mFC.worldgen.village.VillageHandler;
import v3XzZ.util.Common;
import v3XzZ.util.PacketCrafter;

/**
 * Project: mFC
 * 
 * Class: mFC
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@Mod( modid = References.MOD_ID, name = References.MOD_NAME, version = References.VERSION)
@NetworkMod(
	    clientSideRequired = true,
	    serverSideRequired = false, 
		clientPacketHandlerSpec =       @SidedPacketHandler(
	            channels = {PacketCrafter.clientChannel},
	            packetHandler = ClientPacketHandler.class
	            ),
	    serverPacketHandlerSpec =       @SidedPacketHandler(
	            channels = {PacketCrafter.serverChannel},
	            packetHandler = ServerPacketHandler.class
	            )
	     )
public class mFC
{	
	@SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.COMMON_PROXY)
	public static CommonProxy proxy;
	@Instance(References.MOD_ID)
	public static mFC instance;
	WorldGenerator worldGen = new WorldGenerator();
	public static ArrayList<Item> shelfItems = new ArrayList<Item>();
	public static boolean oldApple;
	public static boolean GrassDropMelon;
	public static boolean GrassDropPumpkin;
	public static boolean modernFood;
	
	@Init
    public void Load(FMLInitializationEvent event)
    {
		proxy.init();
		NetworkRegistry.instance().registerGuiHandler(this, proxy);
		Config.loadCrops();
		Config.loadSeeds();
		Config.loadVegetables();
		Config.loadBowlFoodAndRelated();
		Config.loadBrewingAndRelated();
		Config.loadDairy();
		Config.loadDrinkingRelated();
		Config.loadMisc();
		Config.loadMiscBlocks();
		Config.loadFoodBlocks();
		Config.loadOtherFood();
		Config.loadSandwichAndRelated();
		Config.loadSuchiAndSea();
		Config.loadTools();
		Config.registerBlocks();
		Config.loadTileEntitys();
		if(modernFood){
			Config.loadModern();
			RecipeRegister.loadModern();
			NameRegister.nameModern();
		}
		Block.blocksList[Block.cauldron.blockID] = null;
		Item.itemsList[Block.cauldron.blockID] = null;
        Block newCauldron = new BlockNewCauldron(Block.cauldron.blockID).setUnlocalizedName("cauldron");
        GameRegistry.registerBlock(newCauldron, "NewCauldron");
        Common.OverrideBlock(Block.cauldron, newCauldron);
		Item.itemsList[Item.appleRed.itemID-256] = null;
		if(oldApple){
			Item.appleRed = (new FarmFruitFood(Item.appleRed.itemID-256, 4, 0.05F, Items.AppleSeeds.itemID)).setUnlocalizedName("fruitApple");
		}else{
			Item.appleRed = (new FarmFruitFood(Item.appleRed.itemID-256, 4, 0.05F, Items.AppleSeeds.itemID)).setUnlocalizedName("fruitAppleNew");
		}
		Config.setShelfItems();
		RecipeRegister.addRecipe();
		NameRegister.addName();
		new PlateRecipes();
		new BoilingRecipes();
		GameRegistry.registerWorldGenerator(worldGen);
		Config.loadEntitys(this);
		VillagerRegistry.instance().registerVillageCreationHandler(new VillageHandler());
		proxy.registerRenderInformation();
    }
	
	@PreInit
    public void PreInit(FMLPreInitializationEvent event)
    { 
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();
        generalConfig(config);
        Identifications.InitID(config);
        Identifications.initModernIDs(config);
        config.save();
        MinecraftForge.EVENT_BUS.register(new BonemealEventHandler());
    }

    @PostInit // Like the modsLoaded thing from ModLoader
    public void PostInit(FMLPostInitializationEvent event)
    { 
    	Common.removeRecipe(new ItemStack(Item.bowlSoup));
    }
    
    public static void generalConfig(Configuration config){
    	oldApple = config.get(Configuration.CATEGORY_GENERAL, "Old apple texture", false).getBoolean(false);
    	GrassDropMelon = config.get(Configuration.CATEGORY_GENERAL, "Should tallgrass drop melon seeds", false).getBoolean(false);
    	GrassDropPumpkin = config.get(Configuration.CATEGORY_GENERAL, "Should tallgrass drop pumpkin seeds", false).getBoolean(false);
    	modernFood = config.get(Configuration.CATEGORY_GENERAL, "Enable modern food", false).getBoolean(false);
    }
    
	public static int RenderID;
	
}
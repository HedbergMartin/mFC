package v3XzZ.mFC;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import v3XzZ.mFC.blocks.BlockNewCauldron;
import v3XzZ.mFC.client.render.RenderOnScreen;
import v3XzZ.mFC.core.Config;
import v3XzZ.mFC.core.handlers.CraftingHandler;
import v3XzZ.mFC.core.handlers.EntityHandler;
import v3XzZ.mFC.core.handlers.IdentificationHandler;
import v3XzZ.mFC.core.handlers.NameHandler;
import v3XzZ.mFC.core.proxy.CommonProxy;
import v3XzZ.mFC.event.BonemealEventHandler;
import v3XzZ.mFC.items.FarmFruitFood;
import v3XzZ.mFC.items.crafting.BoilingRecipes;
import v3XzZ.mFC.items.crafting.PlateRecipes;
import v3XzZ.mFC.items.crafting.RecipeRegister;
import v3XzZ.mFC.lib.CommonIds;
import v3XzZ.mFC.lib.Items;
import v3XzZ.mFC.lib.References;
import v3XzZ.mFC.network.ClientPacketHandler;
import v3XzZ.mFC.network.ServerPacketHandler;
import v3XzZ.mFC.worldgen.WorldGenerator;
import v3XzZ.mFC.worldgen.village.VillageHandler;
import v3XzZ.util.Common;
import v3XzZ.util.PacketCrafter;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * Project: mFC
 * 
 * Class: mFC
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.VERSION)
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
	public static boolean oldApple;
	public static boolean GrassDropMelon;
	public static boolean GrassDropPumpkin;
	public static boolean modernFood;
	
	@EventHandler
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
			NameHandler.nameModern();
		}
		Block.blocksList[Block.cauldron.blockID] = null;
		Item.itemsList[Block.cauldron.blockID] = null;
        Block newCauldron = new BlockNewCauldron(Block.cauldron.blockID).setUnlocalizedName("cauldron");
        GameRegistry.registerBlock(newCauldron, "NewCauldron");
        Common.OverrideBlock(Block.cauldron, newCauldron);
		Item.itemsList[Item.appleRed.itemID] = null;
		if(oldApple){
			Item.appleRed = (new FarmFruitFood(Item.appleRed.itemID-256, 4, 0.05F, Items.AppleSeeds.itemID)).setUnlocalizedName("fruitApple");
		}else{
			Item.appleRed = (new FarmFruitFood(Item.appleRed.itemID-256, 4, 0.05F, Items.AppleSeeds.itemID)).setUnlocalizedName("fruitAppleNew");
		}
		Config.setShelfItems();
		Config.setBarrelItems();
		RecipeRegister.addRecipe();
		NameHandler.addName();
		new PlateRecipes();
		new BoilingRecipes();
		GameRegistry.registerWorldGenerator(worldGen);
		Config.loadEntitys(this);
		GameRegistry.registerCraftingHandler(new CraftingHandler());
		VillagerRegistry.instance().registerVillageCreationHandler(new VillageHandler());
		TickRegistry.registerTickHandler(new RenderOnScreen(), Side.CLIENT);
		proxy.registerRenderInformation();
    }

	@EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    { 
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();
        generalConfig(config);
        IdentificationHandler.InitID(config);
        IdentificationHandler.initModernIDs(config);
        config.save();
        MinecraftForge.EVENT_BUS.register(new BonemealEventHandler());
        MinecraftForge.EVENT_BUS.register(new EntityHandler());
    }

	@EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    { 
    	Common.removeRecipe(new ItemStack(Item.bowlSoup));
    	Item.wheat.setMaxStackSize(CommonIds.MAX_GRAIN_STACK);
    }
    
    public static void generalConfig(Configuration config){
    	oldApple = config.get(Configuration.CATEGORY_GENERAL, "Old apple texture", false).getBoolean(false);
    	GrassDropMelon = config.get(Configuration.CATEGORY_GENERAL, "Should tallgrass drop melon seeds", false).getBoolean(false);
    	GrassDropPumpkin = config.get(Configuration.CATEGORY_GENERAL, "Should tallgrass drop pumpkin seeds", false).getBoolean(false);
    	modernFood = config.get(Configuration.CATEGORY_GENERAL, "Enable modern food", false).getBoolean(false);
    }
    
	public static int RenderID;
	
}
package v3XzZ.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

import v3XzZ.mFC.lib.References;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLLog;

/**
 * Project: mFC
 * 
 * Class: Common
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class Common {
	
	/**
	 * Gets an item form a selected mod.
	 * @param mod
	 * @param classname
	 * @return
	 */
	public static Item getFromMod(String mod, String classname) {
		try {
			Class<?> c = Class.forName(mod);
			if (c!=null) {
				Field f = c.getField(classname);
				if (f!=null) {
					Item i = (Item) f.get(null); 
					return i;
				}
			} 
		} catch (Exception e) {
            FMLLog.severe("[mFC] Couldn't get item " + classname + " from mod " + mod + "!", e);
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Overrides a final block, so it can be modified. Null the block in blockList and itemList first!
	 * @param oldBlock
	 * @param newBlock
	 */
	public static void OverrideBlock(Block oldBlock, Block newBlock){
		try {
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            Field[] fields = Block.class.getDeclaredFields();
            for (Field field : fields) {
                int fieldMod = field.getModifiers();
                field.setAccessible(true);
                if (Modifier.isStatic(fieldMod)) {
                    if (Modifier.isFinal(fieldMod)) {
                        modifiersField.setInt(field, fieldMod & ~Modifier.FINAL);
                    }
                    if (field.get(null) == oldBlock) {
                        field.set(null, newBlock);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            FMLLog.severe("[mFC] Couldn't override " + oldBlock + " block!", e);
        }
	}

	/**
	 * Return the unlocalized name of an item without the tile. infront of it. Uses when register an items icon.
	 * @param item
	 * @return
	 */
	public static String getItemName(String item){
		String[] name = item.split("\\.");
		return name[1];
	}
	
	public static boolean isNearWater(World world, int x, int y, int z) {
		int radius = 3;
		boolean foundWater = false;
		
		for (int i=-radius; i<radius; i++) {
			for (int j=-radius; j<radius; j++) {
				for (int k=-radius; k<radius; k++) {
					
					foundWater = (world.getBlockId(x+i, y+j, z+k) == Block.waterStill.blockID) || 
						(world.getBlockId(x+i, y+j, z+k) == Block.waterMoving.blockID);
	
					if (foundWater) return foundWater;
				}
			}
		}
		return foundWater;
	}
	
	/**
	 * Creates a resource path.
	 * @param path
	 * @return
	 */
	public static ResourceLocation getLocation(String path){
		return new ResourceLocation(References.MOD_ID.toLowerCase(), path);
	}
	
	/**
	 * Removes all recipies for a choosen item.
	 * @param resultItem
	 */
	public static void removeRecipe(ItemStack resultItem) {
    @SuppressWarnings("unchecked")
	List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
    for (int i = 0; i < recipes.size(); i++) {
         IRecipe tmpRecipe = recipes.get(i);
         if (tmpRecipe instanceof ShapelessRecipes) {
        	ShapelessRecipes recipe = (ShapelessRecipes)tmpRecipe;
            ItemStack recipeResult = recipe.getRecipeOutput();

            if (ItemStack.areItemStacksEqual(resultItem, recipeResult)) {
               recipes.remove(i--);
            }
         } else if (tmpRecipe instanceof ShapedRecipes) {
        	 ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
            ItemStack recipeResult = recipe.getRecipeOutput();

            if (ItemStack.areItemStacksEqual(resultItem, recipeResult)) {
               recipes.remove(i--);
            }
         }
      }
   }
}

package v3XzZ.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

import cpw.mods.fml.common.FMLLog;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

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
			System.err.println("FarmBase: couldn't get item "+classname+" from mod "+mod);
			e.printStackTrace();
		}
		
		return null;
	}
	
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
            FMLLog.severe("Couldn't override " + oldBlock + " block!", e);
        }
	}

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
	
	public static void removeRecipe(ItemStack resultItem) {
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

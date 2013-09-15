package v3XzZ.mFC.items.crafting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

/**
 * Project: mFC
 * 
 * Class: ShaplessBoilRecipe
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ShaplessBoilRecipe {
	
	/** Is the ItemStack that you get when craft the recipe. */
    public final ItemStack recipeOutput;

    /** Is a List of ItemStack that composes the recipe. */
    public final List<?> recipeItems;
    
    public int boilTime = -1;
    
    public int reqLiquid;
	
	public ShaplessBoilRecipe(ItemStack outputSpell, List<?> par2List, int boilTime, int liquid)
    {
        this.recipeOutput = outputSpell;
        this.recipeItems = par2List;
        this.boilTime = boilTime*20;
        this.reqLiquid = liquid;
	}

	public boolean matches(ItemStack[] inv) {
		ArrayList<?> array = new ArrayList<Object>(this.recipeItems);
		
		for(int i = 0; i < 4; i++){
			ItemStack var1 = inv[i];
			if(var1 != null){
				boolean var7 = false;
                Iterator<?> var8 = array.iterator();

                while (var8.hasNext())
                {
                    ItemStack var9 = (ItemStack)var8.next();

                    if (var1.itemID == var9.itemID && (var9.getItemDamage() == -1 || var1.getItemDamage() == var9.getItemDamage()))
                    {
                        var7 = true;
                        array.remove(var9);
                        break;
                    }
                }

                if (!var7)
                {
                    return false;
                }
			}
		}
		return array.isEmpty();
	}

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting)
    {
        return this.recipeOutput;
    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize()
    {
        return this.recipeItems.size();
    }
}

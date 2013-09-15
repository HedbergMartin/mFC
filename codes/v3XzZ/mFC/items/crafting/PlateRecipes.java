package v3XzZ.mFC.items.crafting;

import java.util.HashMap;
import java.util.Map;

import v3XzZ.mFC.lib.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Project: mFC
 * 
 * Class: PlateRecipe
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class PlateRecipes {
	
	public static PlateRecipes instance;

	private Map<Integer, Integer> foodList = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> healthList = new HashMap<Integer, Integer>();
	
	public PlateRecipes() {
		instance = this;
		/** 1 = BaseFood, 2 = Salad, 3 = Protine/Meat */
		this.RegisterFood(Item.bakedPotato.itemID, 1, 6);
		this.RegisterFood(Items.bowlOfRice.itemID, 1, 8);
		this.RegisterFood(Items.lettuce.itemID, 2, 3);
		this.RegisterFood(Item.beefCooked.itemID, 3, 8);
		this.RegisterFood(Item.porkCooked.itemID, 3, 8);
		this.RegisterFood(Item.fishCooked.itemID, 3, 5);
		this.RegisterFood(Item.chickenCooked.itemID, 3, 6);
	}

	public int isFoodRegistrated(ItemStack item) {
		if (item == null)
        {
            return 0;
        }
		if(foodList.get(Integer.valueOf(item.itemID)) == null){
			return 0;
		}
        return (Integer)foodList.get(Integer.valueOf(item.itemID));
	}
	
	public void RegisterFood(int item, int id, int hunger){
		foodList.put(Integer.valueOf(item), id);
		healthList.put(Integer.valueOf(item), hunger);
	}
	
	public int getHunger(int item) {
		if(healthList.get(item) == null){
			return 0;
		}
		return (Integer) healthList.get(item);
	}
}

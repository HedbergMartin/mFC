package v3XzZ.mFC.api;

import java.util.ArrayList;

import v3XzZ.util.ColorCode;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Project: mFC
 * 
 * Class: ApiCommon
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ApiCommon {
	public static ArrayList<Item> shelfItems = new ArrayList<Item>();
	public static ArrayList<Item> barrelItem = new ArrayList<Item>();
	public static ArrayList<ColorCode> barrelColor = new ArrayList<ColorCode>();
	
	/**
	 * Adds a new item to be accepted in the barrel storage system. 
	 * Add the color in hex, start with 0x and then the hex code. 
	 * Ex. FFFFFF is white so to set white set the color param to 0xFFFFFF
	 * @param item
	 * @param color
	 */
	public static void addBarrelItem(Item item, int color){
		barrelItem.add(item);
		barrelColor.add(new ColorCode(new ItemStack(item), color));
	}
}

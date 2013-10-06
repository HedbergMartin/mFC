package v3XzZ.util;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

/**
 * Project: mFC
 * 
 * Class: ColorCode
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ColorCode {
	
	public ItemStack item;
	public int color;
	
	public ColorCode(ItemStack i, int c) {
		this.item = i;
		this.color = c;
	}
	
	public static int getColor(ItemStack item, ArrayList<ColorCode> list){
		int var6;
		for (var6 = 0; var6 < list.size(); ++var6)
        {
			ColorCode var12 = (ColorCode) list.get(var6);

            if (var12.item.itemID == item.itemID && var12.item.getItemDamage() == item.getItemDamage())
            {
                return var12.color;
            }
        }
		return 0;
	}
}

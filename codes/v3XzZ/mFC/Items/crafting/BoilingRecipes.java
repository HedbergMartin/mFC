package v3XzZ.mFC.items.crafting;

import java.util.ArrayList;

import v3XzZ.mFC.blocks.tileentity.TileEntityCauldron;
import v3XzZ.mFC.lib.Items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Project: mFC
 * 
 * Class: BoilingRecipes, ColorCode
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BoilingRecipes {
	
	private ArrayList<ShaplessBoilRecipe> recipes = new ArrayList<ShaplessBoilRecipe>();
	//public ArrayList<Integer> validItem = new ArrayList<Integer>();

	public ArrayList<ColorCode> colors = new ArrayList<ColorCode>();
	public static BoilingRecipes instance;
	
	public BoilingRecipes() {
		instance = this;
		
		this.addBoilRecipe(new ItemStack(Items.carrotStew), 5, TileEntityCauldron.LIQ_MILK, 0xFF8060, new Object[] {new ItemStack(Item.carrot), new ItemStack(Item.egg), new ItemStack(Items.saltPile)});
		this.addBoilRecipe(new ItemStack(Items.bowlOfRice), 5, TileEntityCauldron.LIQ_WATER, 0xECFF82, new Object[] {new ItemStack(Items.Rice), new ItemStack(Items.saltPile)});
		this.addBoilRecipe(new ItemStack(Items.beefStew), 5, TileEntityCauldron.LIQ_WATER, 0x72480D, new Object[] {new ItemStack(Item.potato), new ItemStack(Block.mushroomBrown), new ItemStack(Item.beefCooked), new ItemStack(Items.saltPile)});
		this.addBoilRecipe(new ItemStack(Items.beefSoup), 5, TileEntityCauldron.LIQ_WATER, 0x82520F, new Object[] {new ItemStack(Item.potato), new ItemStack(Item.carrot), new ItemStack(Item.beefCooked), new ItemStack(Items.saltPile)});
		this.addBoilRecipe(new ItemStack(Items.onionStew), 5, TileEntityCauldron.LIQ_MILK, 0xF7FFA0, new Object[] {new ItemStack(Items.onion), new ItemStack(Item.egg), new ItemStack(Items.saltPile)});
		this.addBoilRecipe(new ItemStack(Items.tomatoStew), 5, TileEntityCauldron.LIQ_WATER, 0xFF2833, new Object[] {new ItemStack(Items.tomato), new ItemStack(Items.onion), new ItemStack(Items.saltPile)});
		this.addBoilRecipe(new ItemStack(Items.porridge, 1, 0), 5, TileEntityCauldron.LIQ_WATER, 0xFFAB51, new Object[] {new ItemStack(Item.wheat), new ItemStack(Items.saltPile)});
		this.addBoilRecipe(new ItemStack(Items.porridge, 1, 1), 5, TileEntityCauldron.LIQ_MILK, 0xD3F4FF, new Object[] {new ItemStack(Items.Rice), new ItemStack(Items.saltPile)});
	}
	
	public void addBoilRecipe(ItemStack output, int time, int reqLiquid, int color, Object ... par2ArrayOfObj)
    {
        ArrayList<ItemStack> var3 = new ArrayList<ItemStack>();
        Object[] var4 = par2ArrayOfObj;
        int var5 = par2ArrayOfObj.length;

        for (int var6 = 0; var6 < var5; ++var6)
        {
            Object var7 = var4[var6];

            var3.add(((ItemStack)var7).copy());
            //validItem.add(((ItemStack)var7).itemID);
        }

        this.colors.add(new ColorCode(output, color));
        this.recipes.add(new ShaplessBoilRecipe(output, var3, time, reqLiquid));
    }
	
	public ItemStack getOutputItem(ItemStack[] inv, int liquid){
		int var6;
		for (var6 = 0; var6 < this.recipes.size(); ++var6)
        {
			ShaplessBoilRecipe var12 = (ShaplessBoilRecipe)this.recipes.get(var6);

            if (var12.matches(inv) && var12.reqLiquid == liquid)
            {
                return var12.recipeOutput;
            }
        }
		return null;
	}
	
	public int getBoilTime(ItemStack[] inv, int liquid){
		int var6;
		for (var6 = 0; var6 < this.recipes.size(); ++var6)
        {
			ShaplessBoilRecipe var12 = (ShaplessBoilRecipe)this.recipes.get(var6);

            if (var12.matches(inv) && var12.reqLiquid == liquid)
            {
                return var12.boilTime;
            }
        }
		return -1;
	}
	
	public int getBoilColor(ItemStack inv){
		int var6;
		for (var6 = 0; var6 < this.colors.size(); ++var6)
        {
			ColorCode var12 = (ColorCode) this.colors.get(var6);

            if (var12.item.itemID == inv.itemID && var12.item.getItemDamage() == inv.getItemDamage())
            {
                return var12.color;
            }
        }
		return 0;
	}
}

class ColorCode {
	
	public ItemStack item;
	public int color;
	
	public ColorCode(ItemStack i, int c) {
		this.item = i;
		this.color = c;
	}
}

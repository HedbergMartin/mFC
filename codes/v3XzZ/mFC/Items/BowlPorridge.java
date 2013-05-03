package v3XzZ.mFC.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: BowlPorridge
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BowlPorridge extends BowlFood {
	
	public Icon[] iconArray;
	public String[] names = new String[]{"porridgeWheat", "porridgeRice"};

	public BowlPorridge(int i, int j) {
		super(i, j);
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getItemDisplayName(ItemStack par1ItemStack)
    {
        if(par1ItemStack.getItemDamage() == 0){
        	return "Oatmeal porrige";
        }else if(par1ItemStack.getItemDamage() == 1){
        	return "Rice porridge";
        }
        return "";
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		return iconArray[par1];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister) {
		iconArray = new Icon[2];
		for(int i = 0; i < iconArray.length; i++){
			iconArray[i] = par1IconRegister.registerIcon("mFC:" + names[i]);
		}
	}
}

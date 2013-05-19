package v3XzZ.mFC.Items;

import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemSeedFood;

/**
 * Project: mFC
 * 
 * Class: ItemSeedFood_mFC
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ItemSeedFood_mFC extends ItemSeedFood {

	public ItemSeedFood_mFC(int par1, int par2, float par3, int par4, int par5) {
		super(par1, par2, par3, par4, par5);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.itemIcon = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}

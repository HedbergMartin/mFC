package v3XzZ.mFC.Items;

import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemReed;

/**
 * Project: mFC
 * 
 * Class: ItemBlockmFC
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ItemBlockmFC extends ItemReed {

	public ItemBlockmFC(int par1, Block par2Block) {
		super(par1, par2Block);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister) {
		this.iconIndex = par1IconRegister.registerIcon("mFC:" + Common.getItemName(this.getUnlocalizedName()));
	}
}

package v3XzZ.mFC.Blocks;

import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

/**
 * Project: mFC
 * 
 * Class: CropTemplate
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class CropTemplate extends BlockFlower {

	public Icon[]	iconArray;

	protected CropTemplate(int par1) {
		super(par1);
	}

	protected CropTemplate(int par1, Material par2Material) {
		super(par1, par2Material);
	}

	public Icon[] registerArray(int size) {
		return new Icon[size];
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getIcon(int par1, int par2) {
		if(this.iconArray != null){
			if (par2 < 0 || par2 > this.iconArray.length) {
				par2 = this.iconArray.length;
			}
	
			return this.iconArray[par2];
		}
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister) {
		if(this.iconArray != null){
			for (int i = 0; i < this.iconArray.length; ++i) {
				this.iconArray[i] = par1IconRegister.registerIcon("mFC:" + Common.getItemName(this.getUnlocalizedName()) + "_" + i);
			}
		}
	}
}

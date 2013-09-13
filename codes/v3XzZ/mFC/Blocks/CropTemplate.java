package v3XzZ.mFC.blocks;

import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

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
	
    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        Block soil = blocksList[par1World.getBlockId(par2, par3 - 1, par4)];
        return (par1World.getFullBlockLightValue(par2, par3, par4) >= 8 || par1World.canBlockSeeTheSky(par2, par3, par4)) && 
                ((soil != null && soil.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this)) || soil == Block.grass || soil == Block.dirt);
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

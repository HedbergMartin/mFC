package v3XzZ.mFC.Blocks;

import java.util.Random;

import v3XzZ.mFC.lib.Blocks;
import v3XzZ.mFC.lib.Items;
import v3XzZ.util.Common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: WoodenTrellis
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class WoodenTrellis extends Block
{
	public WoodenTrellis(int i, int j)
    {
        super(i, Material.plants);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
    	if(par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.getCurrentEquippedItem().itemID == Items.grapeSeeds.itemID && par1World.getBlockId(par2, par3 - 1, par4) == Block.tilledField.blockID){
    		par1World.setBlock(par2, par3, par4, Blocks.grapePlant.blockID);
    		par1World.markBlockForRenderUpdate(par2, par3, par4);
    		par5EntityPlayer.getCurrentEquippedItem().stackSize--;
    	}
    	return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
    }
    
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        this.checkBlockCoordValid(par1World, par2, par3, par4);
    }

    /**
     * Checks if current block pos is valid, if not, breaks the block as dropable item. Used for reed and cactus.
     */
    protected final void checkBlockCoordValid(World par1World, int par2, int par3, int par4)
    {
        if (!this.canBlockStay(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlock(par2, par3, par4, 0);
        }
    }
    
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
    	if(par1World.getBlockId(par2, par3 - 1, par4) == 0){
        	return false;
    	}else {
    		return true;
    	}
    }
    
    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
    	if(par1World.getBlockId(par2, par3 - 1, par4) == Block.tilledField.blockID){
        	return super.canPlaceBlockAt(par1World, par2, par3, par4);
    	}else if(par1World.getBlockId(par2, par3 - 3, par4) != this.blockID && par1World.getBlockId(par2, par3 - 1, par4) == this.blockID || par1World.getBlockId(par2, par3 - 1, par4) == Blocks.grapePlant.blockID){
    		if(par1World.getBlockId(par2, par3 - 3, par4) != Blocks.grapePlant.blockID){
        		return super.canPlaceBlockAt(par1World, par2, par3, par4);
        	}else{
        		return false;
        	}
    	}else {
    		return false;
    	}
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == Block.tilledField.blockID;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public int getRenderType()
    {
        return 6;
    }
    
    public int quantityDropped(Random random)
    {
        return 1;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.blockIcon = par1IconRegister.registerIcon("mFC:" + Common.getItemName(this.getUnlocalizedName()));
    }
}
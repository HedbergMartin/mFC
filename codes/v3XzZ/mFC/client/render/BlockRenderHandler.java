package v3XzZ.mFC.client.render;

import org.lwjgl.opengl.GL11;

import v3XzZ.mFC.mFC;
import v3XzZ.mFC.blocks.BlockNewCauldron;
import v3XzZ.mFC.blocks.tileentity.TileEntityBeerKeg;
import v3XzZ.mFC.blocks.tileentity.TileEntityShelf;
import v3XzZ.mFC.lib.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

/**
 * Project: mFC
 * 
 * Class: BlockRenderHandler
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BlockRenderHandler implements ISimpleBlockRenderingHandler
{
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
    	if(block.blockID == Blocks.beerKeg.blockID){
            GL11.glTranslatef(-0.5F, -0.2F, -0.5F);
            GL11.glScalef(0.625F, 0.625F, 0.5F);
    		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityBeerKeg(), 0.0D, 0.0D, 0.0D, 0.0F);
    	}else if(block.blockID == Blocks.shelf.blockID){
            GL11.glTranslatef(-0.5F, -0.4F, -0.5F);
    		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityShelf(), 0.0D, 0.0D, 0.0D, 0.0F);
    	}
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess iblockAccess, int i, int j, int k, Block block, int modelId, RenderBlocks rend)
    {
    	if (block.blockID == Blocks.cheeseWheelBlock.blockID)
		{
			return renderBlockCheese(block, i, j, k, iblockAccess, rend);
		}
    	if(block.blockID == Block.cauldron.blockID){
    		return this.renderCustomCauldron((BlockNewCauldron) block, i, j, k, rend, iblockAccess);
    	}
    	/*if (modelId == mFC.beerKegID)
		{
			return renderBlockBeerKeg(block, i, j, k, iblockAccess, rend);
		}*/
		/*if (l == BakeID)
		{
			return renderBakingTable(block, i, j, k, iblockaccess, renderblocks);
		}*/
		return false;
    }

    public boolean shouldRender3DInInventory()
    {
         return true;
    }

    public int getRenderId()
    {
         return mFC.RenderID;
    }
    
    public boolean renderBlockCheese(Block block, int i, int j, int k, IBlockAccess blockAccess, RenderBlocks rend)
    {
        boolean flag = false;
        rend.renderAllFaces = true;
        int l = blockAccess.getBlockMetadata(i, j, k);
        if (l == 0)
        {
        	rend.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
            rend.renderStandardBlock(block, i, j, k);
            flag = true;
        }
        else if (l == 1)
        {
            rend.setRenderBounds(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 1.0D);
            rend.renderStandardBlock(block, i, j, k);
            rend.setRenderBounds(0.5D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);
            rend.renderStandardBlock(block, i, j, k);
            flag = true;
        }
        else if (l == 2)
        {
        	rend.setRenderBounds(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 1.0D);
            rend.renderStandardBlock(block, i, j, k);
            flag = true;
        }
        else if (l == 3)
        {
        	rend.setRenderBounds(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 0.5D);
            rend.renderStandardBlock(block, i, j, k);
            flag = true;
        }
        rend.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
        return flag;
    }
	
	public boolean renderBlockBeerKeg(Block block, int i, int j, int k, IBlockAccess blockAccess, RenderBlocks rend)
    {
        boolean flag = false;
        int l = blockAccess.getBlockMetadata(i, j, k);
        if (l == 0)
        {
        	float f = 0.08F;
        	float f2 = 0.08F*2;
        	float f3 = 0.08F*3;
        	float f4 = 0.08F*4;
        	float f7 = 0.08F*7;
        	float f8 = 0.08F*8;
        	block.setBlockBounds(0.0F, 0.2F, 0.5F-f2, 1.0F, 0.2F+f, 0.5F+f2);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.0F, 0.2F+f, 0.5F+f2, 1.0F, 0.2F+f2, 0.5F+f2+f2);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.0F, 0.2F+f, 0.5F-f2-f2, 1.0F, 0.2F+f2, 0.5F-f2);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.0F, 0.2F+f2, 0.5F+f3, 1.0F, 0.2F+f3, 0.5F+f4);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.0F, 0.2F+f2, 0.5F-f4, 1.0F, 0.2F+f3, 0.5F-f3);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.0F, 0.2F+f3, 0.5F+f4, 1.0F, 0.2F+f7, 0.5F+f4+f);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.0F, 0.2F+f3, 0.5F-f4-f, 1.0F, 0.2F+f7, 0.5F-f4);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.0F, 0.2F+f7, 0.5F+f3, 1.0F, 0.2F+f8, 0.5F+f4);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.0F, 0.2F+f7, 0.5F-f4, 1.0F, 0.2F+f8, 0.5F-f3);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.0F, 0.2F+f8, 0.5F+f2, 1.0F, 0.2F+f8+f, 0.5F+f2+f2);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.0F, 0.2F+f8, 0.5F-f2-f2, 1.0F, 0.2F+f8+f, 0.5F-f2);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.0F, 0.2F+f8+f, 0.5F-f2, 1.0F, 0.2F+f8+f2, 0.5F+f2);
            rend.renderStandardBlock(block, i, j, k);
            
            
            block.setBlockBounds(0.2F, 0.0F, 0.5F+f3, 0.2F+f, 0.2F+f, 0.5F+f4);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.8F-f, 0.0F, 0.5F+f3, 0.8F, 0.2F+f, 0.5F+f4);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.2F, 0.0F, 0.5F-f4, 0.2F+f, 0.2F+f, 0.5F-f3);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.8F-f, 0.0F, 0.5F-f4, 0.8F, 0.2F+f, 0.5F-f3);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.1F, 0.2F+f, 0.1F+f, 0.1F+f, 1.0F-f, 0.9F-f);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.9F-f, 0.2F+f, 0.1F+f, 0.9F, 1.0F-f, 0.9F-f);
            rend.renderStandardBlock(block, i, j, k);
            flag = true;
        }
        else if (l == 1)
        {
        	float f = 0.08F;
        	float f2 = 0.08F*2;
        	float f3 = 0.08F*3;
        	float f4 = 0.08F*4;
        	float f7 = 0.08F*7;
        	float f8 = 0.08F*8;
        	block.setBlockBounds(0.5F-f2, 0.2F, 0.0F, 0.5F+f2, 0.2F+f, 1.0F);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.5F+f2, 0.2F+f, 0.0F, 0.5F+f2+f2, 0.2F+f2, 1.0F);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.5F-f2-f2, 0.2F+f, 0.0F, 0.5F-f2, 0.2F+f2, 1.0F);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.5F+f3, 0.2F+f2, 0.0F, 0.5F+f4, 0.2F+f3, 1.0F);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.5F-f4, 0.2F+f2, 0.0F, 0.5F-f3, 0.2F+f3, 1.0F);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.5F+f4, 0.2F+f3, 0.0F, 0.5F+f4+f, 0.2F+f7, 1.0F);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.5F-f4-f, 0.2F+f3, 0.0F, 0.5F-f4, 0.2F+f7, 1.0F);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.5F+f3, 0.2F+f7, 0.0F, 0.5F+f4, 0.2F+f8, 1.0F);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.5F-f4, 0.2F+f7, 0.0F, 0.5F-f3, 0.2F+f8, 1.0F);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.5F+f2, 0.2F+f8, 0.0F, 0.5F+f2+f2, 0.2F+f8+f, 1.0F);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.5F-f2-f2, 0.2F+f8, 0.0F, 0.5F-f2, 0.2F+f8+f, 1.0F);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.5F-f2, 0.2F+f8+f, 0.0F, 0.5F+f2, 0.2F+f8+f2, 1.0F);
            rend.renderStandardBlock(block, i, j, k);
            
            
            block.setBlockBounds(0.5F+f3, 0.0F, 0.2F, 0.5F+f4, 0.2F+f, 0.2F+f);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.5F+f3, 0.0F, 0.8F-f, 0.5F+f4, 0.2F+f, 0.8F);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.5F-f4, 0.0F, 0.2F, 0.5F-f3, 0.2F+f, 0.2F+f);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.5F-f4, 0.0F, 0.8F-f, 0.5F-f3, 0.2F+f, 0.8F);
            rend.renderStandardBlock(block, i, j, k);
            
            block.setBlockBounds(0.1F+f, 0.2F+f, 0.1F, 0.9F-f, 1.0F-f, 0.1F+f);
            rend.renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.1F+f, 0.2F+f, 0.9F-f, 0.9F-f, 1.0F-f, 0.9F);
            rend.renderStandardBlock(block, i, j, k);
            flag = true;
        }
        //block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return flag;
    }

    /**
     * Render block cauldron
     */
    public boolean renderCustomCauldron(BlockNewCauldron par1BlockCauldron, int par2, int par3, int par4, RenderBlocks rend, IBlockAccess iblockAccess)
    {
    	rend.renderStandardBlock(par1BlockCauldron, par2, par3, par4);
        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(par1BlockCauldron.getMixedBrightnessForBlock(iblockAccess, par2, par3, par4));
        float f = 1.0F;
        int l = par1BlockCauldron.colorMultiplier(iblockAccess, par2, par3, par4);
        float f1 = (float)(l >> 16 & 255) / 255.0F;
        float f2 = (float)(l >> 8 & 255) / 255.0F;
        float f3 = (float)(l & 255) / 255.0F;
        float f4;

        if (EntityRenderer.anaglyphEnable)
        {
            float f5 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
            f4 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
            float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
            f1 = f5;
            f2 = f4;
            f3 = f6;
        }

        tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
        Icon icon = par1BlockCauldron.getBlockTextureFromSide(2);
        f4 = 0.125F;
        rend.renderFaceXPos(par1BlockCauldron, (double)((float)par2 - 1.0F + f4), (double)par3, (double)par4, icon);
        rend.renderFaceXNeg(par1BlockCauldron, (double)((float)par2 + 1.0F - f4), (double)par3, (double)par4, icon);
        rend.renderFaceZPos(par1BlockCauldron, (double)par2, (double)par3, (double)((float)par4 - 1.0F + f4), icon);
        rend.renderFaceZNeg(par1BlockCauldron, (double)par2, (double)par3, (double)((float)par4 + 1.0F - f4), icon);
        Icon icon1 = BlockCauldron.func_94375_b("inner");
        rend.renderFaceYPos(par1BlockCauldron, (double)par2, (double)((float)par3 - 1.0F + 0.25F), (double)par4, icon1);
        rend.renderFaceYNeg(par1BlockCauldron, (double)par2, (double)((float)par3 + 1.0F - 0.75F), (double)par4, icon1);
        return true;
    }
}


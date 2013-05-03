package v3XzZ.mFC.client;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import v3XzZ.mFC.Blocks.BlockNewCauldron;
import v3XzZ.mFC.Blocks.TileEntitys.TileEntityCauldron;
import v3XzZ.mFC.Recipes.BoilingRecipes;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

/**
 * Project: mFC
 * 
 * Class: TileEntityCauldronRender
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class TileEntityCauldronRender extends TileEntitySpecialRenderer {

	private void renderCauldronLiquid(TileEntityCauldron tile, float i, float j, float k, float var8) {
		Minecraft.getMinecraft().renderEngine.bindTexture("/terrain.png");
		GL11.glPushMatrix();
		int i1 = tile.worldObj.getBlockMetadata(tile.xCoord, tile.yCoord, tile.zCoord);
		Tessellator tessellator = Tessellator.instance;
		if(tile != null){
    		if (i1 > 0 && tile.Liquid != TileEntityCauldron.EMPTY)
		    {
		        tessellator.startDrawingQuads();
	    		if(tile.itemBoiling[5] != null){
	    			tessellator.setColorOpaque_I(BoilingRecipes.instance.getBoilColor(tile.itemBoiling[5]));
	    		}else if(tile.Liquid == TileEntityCauldron.LIQ_WATER){
	    			tessellator.setColorOpaque_I(0x3535FF);//004EFF
	    		}else if(tile.Liquid == TileEntityCauldron.LIQ_MILK){
	    			tessellator.setColorOpaque_I(0xFFFFFF);
	    		}
		    	
		        Icon icon2 = BlockNewCauldron.getLiquidIcon();
		
		        if (i1 > 3)
		        {
		            i1 = 3;
		        }
		        
		        float maxU = icon2.getMaxU();
		        float minU = icon2.getMinU();
		        float maxV = icon2.getMaxV();
		        float minV = icon2.getMinV();
		        GL11.glTranslatef(i, ((float)j - 1.0F + (6.0F + (float)i1 * 3.0F) / 16.0F)+1, k+1);
		        GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);
		        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		        GL11.glEnable(GL11.GL_BLEND);
		        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		        tessellator.setBrightness(Block.blocksList[Block.cauldron.blockID].getMixedBrightnessForBlock(tile.worldObj, tile.xCoord, tile.yCoord, tile.zCoord));
		        tessellator.setNormal(0.0F, 0.0F, 1.0F);
		        tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, (double)maxU, (double)maxV);
		        tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, (double)minU, (double)maxV);
		        tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, (double)minU, (double)minV);
		        tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, (double)maxU, (double)minV);
		        tessellator.draw();
		        GL11.glDisable(GL11.GL_BLEND);
		        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		    }else {
		    	tile.worldObj.setBlockMetadataWithNotify(tile.xCoord, tile.yCoord, tile.zCoord, 0, 2);
		    	tile.Liquid = TileEntityCauldron.EMPTY;
		    }
    	}
		GL11.glPopMatrix();
	}
	
	
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
		TileEntityCauldron beerKeg = (TileEntityCauldron)var1;
		this.renderCauldronLiquid(beerKeg, (float)var2, (float)var4, (float)var6, var8);
	}
}

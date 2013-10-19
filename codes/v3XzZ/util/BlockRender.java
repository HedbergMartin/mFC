package v3XzZ.util;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockRender {
	
	/** Draws inv faces with the same texture on all sides **/
	public void drawInvFaces(RenderBlocks render, Block block, Icon texture){
		drawInvFaces(render, block, texture, texture, texture, texture, texture, texture);
	}
	
	public void drawInvFaces(RenderBlocks render, Block block, Icon top, Icon bottom, Icon north, Icon west, Icon south, Icon east){
		Tessellator tess = Tessellator.instance;
		
		tess.startDrawingQuads();
		tess.setNormal(0.0F, 1.0F, 0.0F);
		render.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, top);
		tess.draw();

		tess.startDrawingQuads();
		tess.setNormal(0.0F, -1.0F, 0.0F);
		render.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, bottom);
		tess.draw();

		tess.startDrawingQuads();
		tess.setNormal(0.0F, 0.0F, 1.0F);
		render.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, north);
		tess.draw();

		tess.startDrawingQuads();
		tess.setNormal(-1.0F, 0.0F, 0.0F);
		render.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, west);
		tess.draw();

		tess.startDrawingQuads();
		tess.setNormal(0.0F, 0.0F, -1.0F);
		render.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, south);
		tess.draw();

		tess.startDrawingQuads();
		tess.setNormal(1.0F, 0.0F, 0.0F);
		render.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, east);
		tess.draw();
	}
	
	public void drawAllSides(IBlockAccess access, int x, int y, int z, Block block, Icon texture, RenderBlocks render){
		if(block.shouldSideBeRendered(access, x, y+1, z, -1)){
			render.renderFaceYPos(block, x, y, z, texture);
		}
		if(block.shouldSideBeRendered(access, x, y-1, z, -1)){
			render.renderFaceYNeg(block, x, y, z, texture);
		}
		if(block.shouldSideBeRendered(access, x-1, y, z, -1)){
			render.renderFaceXNeg(block, x, y, z, texture);
		}
		if(block.shouldSideBeRendered(access, x, y, z+1, -1)){
			render.renderFaceZPos(block, x, y, z, texture);
		}
		if(block.shouldSideBeRendered(access, x+1, y, z, -1)){
			render.renderFaceXPos(block, x, y, z, texture);
		}
		if(block.shouldSideBeRendered(access, x, y, z-1, -1)){
			render.renderFaceZNeg(block, x, y, z, texture);
		}
	}
}

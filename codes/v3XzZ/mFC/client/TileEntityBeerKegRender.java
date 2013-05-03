package v3XzZ.mFC.client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import v3XzZ.mFC.Blocks.TileEntitys.TileEntityBeerKeg;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityBeerKegRender extends TileEntitySpecialRenderer {
	
	ModelBeerKeg model = new ModelBeerKeg();

	private void renderBeerKeg(TileEntityBeerKeg beerKeg, float i, float j, float k, float var8) {
		int var9 = 0;

        if (beerKeg.func_70309_m())
        {
            var9 = beerKeg.getBlockMetadata();
        }
		/** =========================All_Main_Objects============================= */
		GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef(i + 0.5F, j + 0.95F, k + 0.5F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        short var10 = 0;

        if (var9 == 2)
        {
            var10 = 180;
            GL11.glScalef(0.625F, 0.625F, 0.5F);
        }

        if (var9 == 4)
        {
            var10 = 0;
            GL11.glScalef(0.625F, 0.625F, 0.5F);
        }

        if (var9 == 5)
        {
            var10 = 90;
            GL11.glScalef(0.5F, 0.625F, 0.625F);
        }

        if (var9 == 3)
        {
            var10 = -90;
            GL11.glScalef(0.5F, 0.625F, 0.625F);
        }

        GL11.glRotatef((float)var10, 0.0F, 1.0F, 0.0F);
		this.model.renderAll();
		GL11.glPopMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
		TileEntityBeerKeg beerKeg = (TileEntityBeerKeg)var1;
		this.bindTextureByName("/mods/mFC/models/BeerKeg.png");
		this.renderBeerKeg(beerKeg, (float)var2, (float)var4, (float)var6, var8);
	}
}
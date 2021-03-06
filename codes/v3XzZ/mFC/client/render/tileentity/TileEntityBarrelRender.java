package v3XzZ.mFC.client.render.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import v3XzZ.mFC.api.ApiCommon;
import v3XzZ.mFC.blocks.tileentity.TileEntityBarrel;
import v3XzZ.mFC.client.models.ModelBarrel;
import v3XzZ.mFC.lib.Textures;
import v3XzZ.util.ColorCode;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: TileEntityBeerKeg
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@SideOnly(Side.CLIENT)
public class TileEntityBarrelRender extends TileEntitySpecialRenderer {
	
	ModelBarrel model = new ModelBarrel();

	private void renderBeerKeg(TileEntityBarrel tileentity, float i, float j, float k, float var8) {
		int var9 = 0;

        if (tileentity.hasWorldObj())
        {
            var9 = tileentity.getBlockMetadata();
        }
		/** =========================All_Main_Objects============================= */
        this.func_110628_a(Textures.MODEL_BARREL);
		GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef(i + 0.5F, j + 1.5F, k + 0.5F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        short var10 = 0;

        if (var9 == 2)
        {
            var10 = 180;
        }

        if (var9 == 4)
        {
            var10 = 0;
        }

        if (var9 == 5)
        {
            var10 = 90;
        }

        if (var9 == 3)
        {
            var10 = -90;
        }

        GL11.glRotatef((float)var10, 0.0F, 1.0F, 0.0F);
		this.model.renderAll();
		
		if(tileentity.isOpen){
			if(tileentity.content[0] != null){
				GL11.glPushMatrix();
				this.setColorOpaque_I(ColorCode.getColor(tileentity.content[0], ApiCommon.barrelColor));
				GL11.glTranslatef(0F, (float)-(tileentity.content[0].stackSize/(float)(tileentity.getInventoryStackLimit()*2)), 0F);
				this.model.renderContent();
				GL11.glColor3f(1F, 1F, 1F);
				GL11.glPopMatrix();
			}
			GL11.glTranslatef(-0.17F, 1.5F, 0.0F);
			GL11.glRotatef(-110F, 0F, 0F, 1F);
		}
		this.model.renderTop();
		
		GL11.glPopMatrix();
	}
	
	/**
     * Sets the color to the given opaque value (stored as byte values packed in an integer).
     */
    private void setColorOpaque_I(int par1)
    {
        int j = par1 >> 16 & 255;
        int k = par1 >> 8 & 255;
        int l = par1 & 255;
        GL11.glColor3f((float) j/255, (float) k/255, (float) l/255);
    }
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
		this.renderBeerKeg((TileEntityBarrel) var1, (float)var2, (float)var4, (float)var6, var8);
	}
}
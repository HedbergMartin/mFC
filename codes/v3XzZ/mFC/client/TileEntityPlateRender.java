package v3XzZ.mFC.client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import v3XzZ.mFC.Blocks.TileEntitys.TileEntityPlate;
import v3XzZ.mFC.lib.Items;
import v3XzZ.util.ItemRender;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: TileEntityPlateRender
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@SideOnly(Side.CLIENT)
public class TileEntityPlateRender extends TileEntitySpecialRenderer {
	
	ModelPlate model = new ModelPlate();
	ItemRender rend = new ItemRender();
	public static Icon specialChickenIcon;
	
	private void renderPlate(TileEntityPlate plate, float i, float j, float k, float var8) {
		/** =========================Plate============================= */
		GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef(i + 0.5F, j + 1.04F, k + 0.5F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glScalef(0.7F, 0.7F, 0.7F);
		this.model.renderPlate();
		GL11.glPopMatrix();
		/** =========================Potato============================= */
		if(plate.baseFood != 0){
			if(plate.baseFood == Item.bakedPotato.itemID){
				GL11.glPushMatrix();
		        GL11.glTranslatef(i + 0.6F, j + 0.54F, k + 0.5F);
		        GL11.glScalef(1.0F, -1.0F, -1.0F);
		        GL11.glScalef(0.08F, 0.08F, 0.08F);
				this.model.renderPotato(0.5F);
				GL11.glPopMatrix();
			}
		}
		/** =========================Rice============================= */
		if(plate.baseFood != 0){
			if(plate.baseFood == Items.boiledRice.itemID){
				GL11.glPushMatrix();
		        GL11.glTranslatef(i + 0.5F, j + 0.08F, k + 0.6F);
		        GL11.glScalef(1.0F, -1.0F, -1.0F);
		        GL11.glScalef(0.08F, 0.08F, 0.1F);
				this.model.renderRice(0.5F);
				GL11.glPopMatrix();
			}
		}
		/** =========================Salad============================= */
		if(plate.salad != 0){
			if(plate.salad == Items.lettuce.itemID){
				GL11.glPushMatrix();
		        GL11.glTranslatef(i + 0.5F, j + 0.34F, k + 0.6F);
		        GL11.glScalef(1.0F, -1.0F, -1.0F);
		        GL11.glScalef(0.12F, 0.08F, 0.08F);
				this.model.renderSalad(0.5F);
		        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
				GL11.glPopMatrix();
			}
		}
		if(plate.protien != 0){
			GL11.glPushMatrix();
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glTranslatef(i + 0.23F, j + 0.04F, k + 0.26F);
	        GL11.glScalef(0.4F, 0.8F, 0.4F);
	        GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
	        if(plate.protien == Item.chickenCooked.itemID){
				ItemRender.renderItemFromTexture(specialChickenIcon, 0.75F, 0.06F, 1.0F, 1.0F, 1.0F, 771);
	        } else {
				ItemRender.renderItemFromTexture(Item.itemsList[plate.protien].getIconFromDamage(0), 0.75F, 0.06F, 1.0F, 1.0F, 1.0F, 771);
	        }
	        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			GL11.glPopMatrix();
		}
	}

	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
		TileEntityPlate plate = (TileEntityPlate)var1;
		this.bindTextureByName("/mods/mFC/models/Plate.png");
		this.renderPlate(plate, (float)var2, (float)var4, (float)var6, var8);
	}
}

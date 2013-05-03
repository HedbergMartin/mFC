package v3XzZ.mFC.client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import v3XzZ.mFC.Blocks.TileEntitys.TileEntityShelf;
import v3XzZ.util.ItemRender;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: TileEntityShelfRender
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@SideOnly(Side.CLIENT)
public class TileEntityShelfRender extends TileEntitySpecialRenderer {
	
	ModelShelf model = new ModelShelf();

	private void renderShelf(TileEntityShelf shelf, float i, float j, float k, float var8) {
		int var9 = 0;

        if (shelf.func_70309_m())
        {
            var9 = shelf.getBlockMetadata();
        }
		/** =========================All_Main_Objects============================= */
		GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslatef(i + 0.5F, j + 0.45F, k + 0.5F);
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
        //Random rand = new Random(shelf.xCoord+shelf.yCoord+shelf.zCoord);

        GL11.glRotatef((float)var10, 0.0F, 1.0F, 0.0F);
		this.model.renderAll();
		GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(0.48F,0.04F,0.46F);
		for(int ti = 0; ti < shelf.getSizeInventory(); ti++){
			GL11.glTranslatef(-0.26F,0.0F,0.0F);
			if(shelf.items[ti] != null){
				if(ti < 4){
		            ItemRender.renderWithPasses(0.35F, 0.1F, new ItemStack(Item.itemsList[shelf.items[ti].itemID], 0, shelf.items[ti].getItemDamage()));
				}
			}
		}
		GL11.glTranslatef(3.14F,0.00F,-0.1F);
		for(int ti = 0; ti < shelf.getSizeInventory(); ti++){
			GL11.glTranslatef(-0.26F,0.0F,0.0F);
			if(shelf.items[ti] != null){
				if(3 < ti){
		            ItemRender.renderWithPasses(0.35F, 0.1F, new ItemStack(Item.itemsList[shelf.items[ti].itemID], 0, shelf.items[ti].getItemDamage()));
				}
			}
		}
		GL11.glPopMatrix();
	}
	
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
		TileEntityShelf Shelf = (TileEntityShelf)var1;
		this.bindTextureByName("/mods/mFC/models/Shelf.png");
		this.renderShelf(Shelf, (float)var2, (float)var4, (float)var6, var8);
	}
}
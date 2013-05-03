package v3XzZ.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class ItemRender {

	public static void renderWithPasses(float scale, float thikness, ItemStack item){
    	if (item.getItem().requiresMultipleRenderPasses())
        {
	        for (int i = 0; i <= item.getItem().getRenderPasses(item.getItemDamage()); ++i)
	        {
		        Icon icon = item.getItem().getIcon(item, i);
		        float var17 = 1.0F;
				int var18 = Item.itemsList[item.itemID].getColorFromItemStack(item, i);
		        float var19 = (float)(var18 >> 16 & 255) / 255.0F;
		        float var20 = (float)(var18 >> 8 & 255) / 255.0F;
		        float var21 = (float)(var18 & 255) / 255.0F;
		        if(item.itemID == Item.potion.itemID && i == 1){
	                GL11.glColor4f(var19 * var17, var20 * var17, var21 * var17, 0.7F);
		        	renderItemFromTexture(icon, scale, thikness, var19 * var17, var20 * var17, var21 * var17, 0.7F);
		        }else{
		        	GL11.glColor4f(var19 * var17, var20 * var17, var21 * var17, 1.0F);
	                //ItemRenderer.renderItemIn2D(Tessellator.instance, var190, var200, var180, var210, icon.getSheetWidth(), icon.getSheetHeight(), thikness);
		        	renderItemFromTexture(icon, scale, thikness, var19 * var17, var20 * var17, var21 * var17, 1.0F);
		        }
	        }
        }else{
	        Icon icon = item.getItem().getIcon(item, 0);
        	renderItemFromTexture(icon, scale, thikness, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
    
    public static void renderItemFromTexture(Icon icon, float scale, float thikness, float colorR, float colorG, float colorB, float alpha)
    {
        GL11.glPushMatrix();
        Tessellator var16 = Tessellator.instance;
        Minecraft.getMinecraft().renderEngine.bindTexture("/gui/items.png");
        float par1 = icon.getMaxU();
        float par2 = icon.getMinV();
        float par3 = icon.getMinU();
        float par4 = icon.getMaxV();
        int par5 = icon.getSheetWidth();
        int par6 = icon.getSheetHeight();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(scale, scale, scale);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, 771);
        GL11.glColor4f(colorR, colorG, colorB, alpha);

        var16.startDrawingQuads();
        var16.setNormal(0.0F, 0.0F, 1.0F);
        var16.addVertexWithUV(0.0D, 0.0D, 0.0D, (double)par1, (double)par4);
        var16.addVertexWithUV(1.0D, 0.0D, 0.0D, (double)par3, (double)par4);
        var16.addVertexWithUV(1.0D, 1.0D, 0.0D, (double)par3, (double)par2);
        var16.addVertexWithUV(0.0D, 1.0D, 0.0D, (double)par1, (double)par2);
        var16.draw();
        var16.startDrawingQuads();
        var16.setNormal(0.0F, 0.0F, -1.0F);
        var16.addVertexWithUV(0.0D, 1.0D, (double)(0.0F - thikness), (double)par1, (double)par2);
        var16.addVertexWithUV(1.0D, 1.0D, (double)(0.0F - thikness), (double)par3, (double)par2);
        var16.addVertexWithUV(1.0D, 0.0D, (double)(0.0F - thikness), (double)par3, (double)par4);
        var16.addVertexWithUV(0.0D, 0.0D, (double)(0.0F - thikness), (double)par1, (double)par4);
        var16.draw();
        float f5 = (float)par5 * (par1 - par3);
        float f6 = (float)par6 * (par4 - par2);
        var16.startDrawingQuads();
        var16.setNormal(-1.0F, 0.0F, 0.0F);
        int k;
        float f7;
        float f8;

        for (k = 0; (float)k < f5; ++k)
        {
            f7 = (float)k / f5;
            f8 = par1 + (par3 - par1) * f7 - 0.5F / (float)par5;
            var16.addVertexWithUV((double)f7, 0.0D, (double)(0.0F - thikness), (double)f8, (double)par4);
            var16.addVertexWithUV((double)f7, 0.0D, 0.0D, (double)f8, (double)par4);
            var16.addVertexWithUV((double)f7, 1.0D, 0.0D, (double)f8, (double)par2);
            var16.addVertexWithUV((double)f7, 1.0D, (double)(0.0F - thikness), (double)f8, (double)par2);
        }

        var16.draw();
        var16.startDrawingQuads();
        var16.setNormal(1.0F, 0.0F, 0.0F);
        float f9;

        for (k = 0; (float)k < f5; ++k)
        {
            f7 = (float)k / f5;
            f8 = par1 + (par3 - par1) * f7 - 0.5F / (float)par5;
            f9 = f7 + 1.0F / f5;
            var16.addVertexWithUV((double)f9, 1.0D, (double)(0.0F - thikness), (double)f8, (double)par2);
            var16.addVertexWithUV((double)f9, 1.0D, 0.0D, (double)f8, (double)par2);
            var16.addVertexWithUV((double)f9, 0.0D, 0.0D, (double)f8, (double)par4);
            var16.addVertexWithUV((double)f9, 0.0D, (double)(0.0F - thikness), (double)f8, (double)par4);
        }

        var16.draw();
        var16.startDrawingQuads();
        var16.setNormal(0.0F, 1.0F, 0.0F);

        for (k = 0; (float)k < f6; ++k)
        {
            f7 = (float)k / f6;
            f8 = par4 + (par2 - par4) * f7 - 0.5F / (float)par6;
            f9 = f7 + 1.0F / f6;
            var16.addVertexWithUV(0.0D, (double)f9, 0.0D, (double)par1, (double)f8);
            var16.addVertexWithUV(1.0D, (double)f9, 0.0D, (double)par3, (double)f8);
            var16.addVertexWithUV(1.0D, (double)f9, (double)(0.0F - thikness), (double)par3, (double)f8);
            var16.addVertexWithUV(0.0D, (double)f9, (double)(0.0F - thikness), (double)par1, (double)f8);
        }

        var16.draw();
        var16.startDrawingQuads();
        var16.setNormal(0.0F, -1.0F, 0.0F);

        for (k = 0; (float)k < f6; ++k)
        {
            f7 = (float)k / f6;
            f8 = par4 + (par2 - par4) * f7 - 0.5F / (float)par6;
            var16.addVertexWithUV(1.0D, (double)f7, 0.0D, (double)par3, (double)f8);
            var16.addVertexWithUV(0.0D, (double)f7, 0.0D, (double)par1, (double)f8);
            var16.addVertexWithUV(0.0D, (double)f7, (double)(0.0F - thikness), (double)par1, (double)f8);
            var16.addVertexWithUV(1.0D, (double)f7, (double)(0.0F - thikness), (double)par3, (double)f8);
        }

        var16.draw();

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }
}

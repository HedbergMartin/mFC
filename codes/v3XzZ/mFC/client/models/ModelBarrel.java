package v3XzZ.mFC.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Project: mFC
 * 
 * Class: ModelBarrel
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ModelBarrel extends ModelBase {
    ModelRenderer Bottom;
    ModelRenderer Top;
    ModelRenderer Side1;
    ModelRenderer Side2;
    ModelRenderer Side3;
    ModelRenderer Side4;
    ModelRenderer Content;
  
    public ModelBarrel() {
	  	textureWidth = 64;
    	textureHeight = 32;
    
		Bottom.mirror = true;
		Bottom = new ModelRenderer(this, 22, 0);
		Bottom.addBox(-5F, 0F, -5F, 10, 1, 10);
		Bottom.setRotationPoint(0F, 22F, 0F);
		Bottom.setTextureSize(64, 32);
		Bottom.mirror = true;
		setRotation(Bottom, 0F, 0F, 0F);
		Bottom.mirror = false;
		Top = new ModelRenderer(this, 22, 0);
		Top.addBox(-5F, 0F, -5F, 10, 1, 10);
		Top.setRotationPoint(0F, 11F, 0F);
		Top.setTextureSize(64, 32);
		Top.mirror = true;
		setRotation(Top, 0F, 0F, 0F);
		Side1 = new ModelRenderer(this, 0, 0);
		Side1.addBox(0F, 0F, -5F, 1, 14, 10);
		Side1.setRotationPoint(-6F, 10F, 0F);
		Side1.setTextureSize(64, 32);
		Side1.mirror = true;
		setRotation(Side1, 0F, 0F, 0F);
		Side2 = new ModelRenderer(this, 0, 0);
		Side2.addBox(0F, 0F, -5F, 1, 14, 10);
		Side2.setRotationPoint(0F, 10F, -6F);
		Side2.setTextureSize(64, 32);
		Side2.mirror = true;
		setRotation(Side2, 0F, -1.570796F, 0F);
		Side3 = new ModelRenderer(this, 0, 0);
		Side3.addBox(0F, 0F, -5F, 1, 14, 10);
		Side3.setRotationPoint(6F, 10F, 0F);
		Side3.setTextureSize(64, 32);
		Side3.mirror = true;
		setRotation(Side3, 0F, -3.141593F, 0F);
		Side4 = new ModelRenderer(this, 0, 0);
		Side4.addBox(0F, 0F, -5F, 1, 14, 10);
		Side4.setRotationPoint(0F, 10F, 6F);
		Side4.setTextureSize(64, 32);
		Side4.mirror = true;
	  	setRotation(Side4, 0F, 1.570796F, 0F);
      	Content = new ModelRenderer(this, 22, 11);
      	Content.addBox(-5F, 0F, -5F, 10, 1, 10);
      	Content.setRotationPoint(0F, 13F, 0F);
      	Content.setTextureSize(64, 32);
      	Content.mirror = true;
      	setRotation(Content, 0F, 0F, 0F);
  	}
  
  	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Bottom.render(f5);
	    Top.render(f5);
	    Side1.render(f5);
	    Side2.render(f5);
	    Side3.render(f5);
	    Side4.render(f5);
	    Content.render(f5);
  	}
  
	private void setRotation(ModelRenderer model, float x, float y, float z) {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}

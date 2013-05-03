package v3XzZ.mFC.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Project: mFC
 * 
 * Class: ModelShelf
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ModelShelf extends ModelBase
{
  //fields
    ModelRenderer Plank;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
  
  public ModelShelf()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Plank = new ModelRenderer(this, 0, 0);
      Plank.addBox(-7F, 0F, 0F, 14, 1, 4);
      Plank.setRotationPoint(0F, -1F, 4F);
      Plank.setTextureSize(64, 64);
      Plank.mirror = true;
      setRotation(Plank, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 0, 5);
      Leg1.addBox(0F, 0F, 0F, 1, 5, 1);
      Leg1.setRotationPoint(-5F, 0F, 4F);
      Leg1.setTextureSize(64, 64);
      Leg1.mirror = true;
      setRotation(Leg1, 0.7853982F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 0, 5);
      Leg2.addBox(-1F, 0F, 0F, 1, 5, 1);
      Leg2.setRotationPoint(5F, 0F, 4F);
      Leg2.setTextureSize(64, 64);
      Leg2.mirror = true;
      setRotation(Leg2, 0.7853982F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Plank.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
  }
  
  public void renderAll() {
	  float f5 = 0.0625F;
	  Plank.render(f5);
	  Leg1.render(f5);
	  Leg2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
	}

}

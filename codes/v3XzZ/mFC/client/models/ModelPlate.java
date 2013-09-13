package v3XzZ.mFC.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Project: mFC
 * 
 * Class: ModelPlate
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ModelPlate extends ModelBase
{
  //fields
    ModelRenderer Bottom;
    ModelRenderer North1;
    ModelRenderer North2;
    ModelRenderer North3;
    ModelRenderer South1;
    ModelRenderer South2;
    ModelRenderer South3;
    ModelRenderer East2;
    ModelRenderer East3;
    ModelRenderer West2;
    ModelRenderer West3;
    ModelRenderer Corner1A;
    ModelRenderer Corner1B;
    ModelRenderer Corner1C;
    ModelRenderer Corner2A;
    ModelRenderer Corner2B;
    ModelRenderer Corner2C;
    ModelRenderer Corner3A;
    ModelRenderer Corner3B;
    ModelRenderer Corner3C;
    ModelRenderer Corner4A;
    ModelRenderer Corner4B;
    ModelRenderer Corner4C;
    ModelRenderer Potato;
    ModelRenderer Sallad;
    ModelRenderer Rice1;
    ModelRenderer Rice2;
  
  public ModelPlate()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Bottom = new ModelRenderer(this, 0, 0);
      Bottom.addBox(-6F, 0F, -5F, 12, 1, 10);
      Bottom.setRotationPoint(0F, 23F, 0F);
      Bottom.setTextureSize(64, 64);
      Bottom.mirror = true;
      setRotation(Bottom, 0F, 0F, 0F);
      North1 = new ModelRenderer(this, 0, 16);
      North1.addBox(-5F, 0F, 0F, 10, 1, 1);
      North1.setRotationPoint(0F, 23F, 5F);
      North1.setTextureSize(64, 64);
      North1.mirror = true;
      setRotation(North1, 0F, 0F, 0F);
      North2 = new ModelRenderer(this, 0, 14);
      North2.addBox(-3F, 0F, 0F, 6, 1, 1);
      North2.setRotationPoint(0F, 23F, 6F);
      North2.setTextureSize(64, 64);
      North2.mirror = true;
      setRotation(North2, 0F, 0F, 0F);
      North3 = new ModelRenderer(this, 0, 11);
      North3.addBox(-3F, 0F, 0F, 6, 1, 1);
      North3.setRotationPoint(0F, 22F, 7F);
      North3.setTextureSize(64, 64);
      North3.mirror = true;
      setRotation(North3, 0F, 0F, 0F);
      South1 = new ModelRenderer(this, 0, 16);
      South1.addBox(-5F, 0F, 0F, 10, 1, 1);
      South1.setRotationPoint(0F, 23F, -6F);
      South1.setTextureSize(64, 64);
      South1.mirror = true;
      setRotation(South1, 0F, 0F, 0F);
      South2 = new ModelRenderer(this, 0, 14);
      South2.addBox(-3F, 0F, 0F, 6, 1, 1);
      South2.setRotationPoint(0F, 23F, -7F);
      South2.setTextureSize(64, 64);
      South2.mirror = true;
      setRotation(South2, 0F, 0F, 0F);
      South3 = new ModelRenderer(this, 0, 11);
      South3.addBox(-3F, 0F, 0F, 6, 1, 1);
      South3.setRotationPoint(0F, 22F, -8F);
      South3.setTextureSize(64, 64);
      South3.mirror = true;
      setRotation(South3, 0F, 0F, 0F);
      East2 = new ModelRenderer(this, 0, 14);
      East2.addBox(-3F, 0F, 0F, 6, 1, 1);
      East2.setRotationPoint(6F, 23F, 0F);
      East2.setTextureSize(64, 64);
      East2.mirror = true;
      setRotation(East2, 0F, 1.570796F, 0F);
      East3 = new ModelRenderer(this, 0, 11);
      East3.addBox(-3F, 0F, 0F, 6, 1, 1);
      East3.setRotationPoint(7F, 22F, 0F);
      East3.setTextureSize(64, 64);
      East3.mirror = true;
      setRotation(East3, 0F, 1.570796F, 0F);
      West2 = new ModelRenderer(this, 0, 14);
      West2.addBox(-3F, 0F, 0F, 6, 1, 1);
      West2.setRotationPoint(-6F, 23F, 0F);
      West2.setTextureSize(64, 64);
      West2.mirror = true;
      setRotation(West2, 0F, -1.570796F, 0F);
      West3 = new ModelRenderer(this, 0, 11);
      West3.addBox(-3F, 0F, 0F, 6, 1, 1);
      West3.setRotationPoint(-7F, 22F, 0F);
      West3.setTextureSize(64, 64);
      West3.mirror = true;
      setRotation(West3, 0F, -1.570796F, 0F);
      Corner1A = new ModelRenderer(this, 0, 11);
      Corner1A.addBox(0F, 0F, -1F, 1, 1, 2);
      Corner1A.setRotationPoint(6F, 22F, -4F);
      Corner1A.setTextureSize(64, 64);
      Corner1A.mirror = true;
      setRotation(Corner1A, 0F, 0F, 0F);
      Corner1B = new ModelRenderer(this, 0, 11);
      Corner1B.addBox(0F, 0F, 0F, 1, 1, 1);
      Corner1B.setRotationPoint(5F, 22F, -6F);
      Corner1B.setTextureSize(64, 64);
      Corner1B.mirror = true;
      setRotation(Corner1B, 0F, 0F, 0F);
      Corner1C = new ModelRenderer(this, 0, 11);
      Corner1C.addBox(-1F, 0F, 0F, 2, 1, 1);
      Corner1C.setRotationPoint(4F, 22F, -7F);
      Corner1C.setTextureSize(64, 64);
      Corner1C.mirror = true;
      setRotation(Corner1C, 0F, 0F, 0F);
      Corner2A = new ModelRenderer(this, 0, 11);
      Corner2A.addBox(0F, 0F, -1F, 1, 1, 2);
      Corner2A.setRotationPoint(-7F, 22F, -4F);
      Corner2A.setTextureSize(64, 64);
      Corner2A.mirror = true;
      setRotation(Corner2A, 0F, 0F, 0F);
      Corner2B = new ModelRenderer(this, 0, 11);
      Corner2B.addBox(0F, 0F, 0F, 1, 1, 1);
      Corner2B.setRotationPoint(-6F, 22F, -6F);
      Corner2B.setTextureSize(64, 64);
      Corner2B.mirror = true;
      setRotation(Corner2B, 0F, 0F, 0F);
      Corner2C = new ModelRenderer(this, 0, 11);
      Corner2C.addBox(-1F, 0F, 0F, 2, 1, 1);
      Corner2C.setRotationPoint(-4F, 22F, -7F);
      Corner2C.setTextureSize(64, 64);
      Corner2C.mirror = true;
      setRotation(Corner2C, 0F, 0F, 0F);
      Corner3A = new ModelRenderer(this, 0, 11);
      Corner3A.addBox(0F, 0F, -1F, 1, 1, 2);
      Corner3A.setRotationPoint(-7F, 22F, 4F);
      Corner3A.setTextureSize(64, 64);
      Corner3A.mirror = true;
      setRotation(Corner3A, 0F, 0F, 0F);
      Corner3B = new ModelRenderer(this, 0, 11);
      Corner3B.addBox(0F, 0F, 0F, 1, 1, 1);
      Corner3B.setRotationPoint(-6F, 22F, 5F);
      Corner3B.setTextureSize(64, 64);
      Corner3B.mirror = true;
      setRotation(Corner3B, 0F, 0F, 0F);
      Corner3C = new ModelRenderer(this, 0, 11);
      Corner3C.addBox(-1F, 0F, 0F, 2, 1, 1);
      Corner3C.setRotationPoint(-4F, 22F, 6F);
      Corner3C.setTextureSize(64, 64);
      Corner3C.mirror = true;
      setRotation(Corner3C, 0F, 0F, 0F);
      Corner4A = new ModelRenderer(this, 0, 11);
      Corner4A.addBox(0F, 0F, -1F, 1, 1, 2);
      Corner4A.setRotationPoint(6F, 22F, 4F);
      Corner4A.setTextureSize(64, 64);
      Corner4A.mirror = true;
      setRotation(Corner4A, 0F, 0F, 0F);
      Corner4B = new ModelRenderer(this, 0, 11);
      Corner4B.addBox(0F, 0F, 0F, 1, 1, 1);
      Corner4B.setRotationPoint(5F, 22F, 5F);
      Corner4B.setTextureSize(64, 64);
      Corner4B.mirror = true;
      setRotation(Corner4B, 0F, 0F, 0F);
      Corner4C = new ModelRenderer(this, 0, 11);
      Corner4C.addBox(-1F, 0F, 0F, 2, 1, 1);
      Corner4C.setRotationPoint(4F, 22F, 6F);
      Corner4C.setTextureSize(64, 64);
      Corner4C.mirror = true;
      setRotation(Corner4C, 0F, 0F, 0F);
      Potato = new ModelRenderer(this, 0, 18);
      Potato.addBox(0F, 0F, 0F, 4, 4, 5);
      Potato.setRotationPoint(0F, 8F, 0F);
      Potato.setTextureSize(64, 64);
      Potato.mirror = true;
      setRotation(Potato, 0F, 0F, 0F);
      Sallad = new ModelRenderer(this, 0, 27);
      Sallad.addBox(0F, 0F, 0F, 3, 2, 3);
      Sallad.setRotationPoint(-3F, 6F, -4F);
      Sallad.setTextureSize(64, 64);
      Sallad.mirror = true;
      setRotation(Sallad, 0F, 0F, 0F);
      Rice1 = new ModelRenderer(this, 0, 32);
      Rice1.addBox(0F, 0F, 0F, 5, 1, 6);
      Rice1.setRotationPoint(0F, 0F, 0F);
      Rice1.setTextureSize(64, 64);
      Rice1.mirror = true;
      setRotation(Rice1, 0F, 0F, 0F);
      Rice2 = new ModelRenderer(this, 0, 39);
      Rice2.addBox(0F, 0F, 0F, 4, 1, 3);
      Rice2.setRotationPoint(1F, -1F, 1F);
      Rice2.setTextureSize(64, 64);
      Rice2.mirror = true;
      setRotation(Rice2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Bottom.render(f5);
    North1.render(f5);
    North2.render(f5);
    North3.render(f5);
    South1.render(f5);
    South2.render(f5);
    South3.render(f5);
    East2.render(f5);
    East3.render(f5);
    West2.render(f5);
    West3.render(f5);
    Corner1A.render(f5);
    Corner1B.render(f5);
    Corner1C.render(f5);
    Corner2A.render(f5);
    Corner2B.render(f5);
    Corner2C.render(f5);
    Corner3A.render(f5);
    Corner3B.render(f5);
    Corner3C.render(f5);
    Corner4A.render(f5);
    Corner4B.render(f5);
    Corner4C.render(f5);
    Potato.render(f5);
    Sallad.render(f5);
    Rice1.render(f5);
    Rice2.render(f5);
  }
  
  private float scale = 0.0625F;
  
  public void renderPlate(){
	  Bottom.render(scale);
	    North1.render(scale);
	    North2.render(scale);
	    North3.render(scale);
	    South1.render(scale);
	    South2.render(scale);
	    South3.render(scale);
	    East2.render(scale);
	    East3.render(scale);
	    West2.render(scale);
	    West3.render(scale);
	    Corner1A.render(scale);
	    Corner1B.render(scale);
	    Corner1C.render(scale);
	    Corner2A.render(scale);
	    Corner2B.render(scale);
	    Corner2C.render(scale);
	    Corner3A.render(scale);
	    Corner3B.render(scale);
	    Corner3C.render(scale);
	    Corner4A.render(scale);
	    Corner4B.render(scale);
	    Corner4C.render(scale);
  }
  
  public void renderPotato(float f5) {
	    Potato.render(f5);
  }
  
  public void renderSalad(float f5) {
	    Sallad.render(f5);
  }
  
  public void renderRice(float f5) {
	    Rice1.render(f5);
	    Rice2.render(f5);
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

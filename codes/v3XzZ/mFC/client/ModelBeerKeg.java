package v3XzZ.mFC.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Project: mFC
 * 
 * Class: ModelBeerKeg
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ModelBeerKeg extends ModelBase
{
  //fields
    ModelRenderer Bottom;
    ModelRenderer Top;
    ModelRenderer SideEast;
    ModelRenderer SideWest;
    ModelRenderer Corner1A;
    ModelRenderer Corner1B;
    ModelRenderer Corner2A;
    ModelRenderer Corner2B;
    ModelRenderer Corner3A;
    ModelRenderer Corner3B;
    ModelRenderer Corner4A;
    ModelRenderer Corner4B;
    ModelRenderer Front;
    ModelRenderer Back;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer TapPart1;
    ModelRenderer TapPart2;
    ModelRenderer TapPart3;
  
  public ModelBeerKeg()
  {
    textureWidth = 256;
    textureHeight = 256;
    
      Bottom = new ModelRenderer(this, 72, 0);
      Bottom.addBox(-4F, 0F, -16F, 8, 2, 32);
      Bottom.setRotationPoint(0F, 19F, 0F);
      Bottom.setTextureSize(256, 256);
      Bottom.mirror = true;
      setRotation(Bottom, 0F, 0F, 0F);
      Top = new ModelRenderer(this, 72, 0);
      Top.addBox(-4F, 0F, -16F, 8, 2, 32);
      Top.setRotationPoint(0F, 1F, 0F);
      Top.setTextureSize(256, 256);
      Top.mirror = true;
      setRotation(Top, 0F, 0F, 0F);
      SideEast = new ModelRenderer(this, 72, 35);
      SideEast.addBox(0F, -4F, -16F, 2, 8, 32);
      SideEast.setRotationPoint(8F, 11F, 0F);
      SideEast.setTextureSize(256, 256);
      SideEast.mirror = true;
      setRotation(SideEast, 0F, 0F, 0F);
      SideWest = new ModelRenderer(this, 72, 35);
      SideWest.addBox(0F, -4F, -16F, 2, 8, 32);
      SideWest.setRotationPoint(-10F, 11F, 0F);
      SideWest.setTextureSize(256, 256);
      SideWest.mirror = true;
      setRotation(SideWest, 0F, 0F, 0F);
      Corner1A = new ModelRenderer(this, 0, 34);
      Corner1A.addBox(-2F, 0F, -16F, 4, 2, 32);
      Corner1A.setRotationPoint(6F, 17F, 0F);
      Corner1A.setTextureSize(256, 256);
      Corner1A.mirror = true;
      setRotation(Corner1A, 0F, 0F, 0F);
      Corner1B = new ModelRenderer(this, 0, 0);
      Corner1B.addBox(-1F, 0F, -16F, 2, 2, 32);
      Corner1B.setRotationPoint(7F, 15F, 0F);
      Corner1B.setTextureSize(256, 256);
      Corner1B.mirror = true;
      setRotation(Corner1B, 0F, 0F, 0F);
      Corner2A = new ModelRenderer(this, 0, 34);
      Corner2A.addBox(-2F, 0F, -16F, 4, 2, 32);
      Corner2A.setRotationPoint(-6F, 17F, 0F);
      Corner2A.setTextureSize(256, 256);
      Corner2A.mirror = true;
      setRotation(Corner2A, 0F, 0F, 0F);
      Corner2B = new ModelRenderer(this, 0, 0);
      Corner2B.addBox(-1F, 0F, -16F, 2, 2, 32);
      Corner2B.setRotationPoint(-7F, 15F, 0F);
      Corner2B.setTextureSize(256, 256);
      Corner2B.mirror = true;
      setRotation(Corner2B, 0F, 0F, 0F);
      Corner3A = new ModelRenderer(this, 0, 34);
      Corner3A.addBox(-2F, 0F, -16F, 4, 2, 32);
      Corner3A.setRotationPoint(-6F, 3F, 0F);
      Corner3A.setTextureSize(256, 256);
      Corner3A.mirror = true;
      setRotation(Corner3A, 0F, 0F, 0F);
      Corner3B = new ModelRenderer(this, 0, 0);
      Corner3B.addBox(-1F, 0F, -16F, 2, 2, 32);
      Corner3B.setRotationPoint(-7F, 5F, 0F);
      Corner3B.setTextureSize(256, 256);
      Corner3B.mirror = true;
      setRotation(Corner3B, 0F, 0F, 0F);
      Corner4A = new ModelRenderer(this, 0, 34);
      Corner4A.addBox(-2F, 0F, -16F, 4, 2, 32);
      Corner4A.setRotationPoint(6F, 3F, 0F);
      Corner4A.setTextureSize(256, 256);
      Corner4A.mirror = true;
      setRotation(Corner4A, 0F, 0F, 0F);
      Corner4B = new ModelRenderer(this, 0, 0);
      Corner4B.addBox(-1F, 0F, -16F, 2, 2, 32);
      Corner4B.setRotationPoint(7F, 5F, 0F);
      Corner4B.setTextureSize(256, 256);
      Corner4B.mirror = true;
      setRotation(Corner4B, 0F, 0F, 0F);
      Front = new ModelRenderer(this, 152, 0);
      Front.addBox(-8F, 0F, -1F, 16, 16, 2);
      Front.setRotationPoint(0F, 3F, -13F);
      Front.setTextureSize(256, 256);
      Front.mirror = true;
      setRotation(Front, 0F, 0F, 0F);
      Back = new ModelRenderer(this, 152, 0);
      Back.addBox(-8F, 0F, -1F, 16, 16, 2);
      Back.setRotationPoint(0F, 3F, 13F);
      Back.setTextureSize(256, 256);
      Back.mirror = true;
      setRotation(Back, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 1, 69);
      Leg1.addBox(-1F, 0F, -1F, 2, 5, 2);
      Leg1.setRotationPoint(7F, 19F, -11F);
      Leg1.setTextureSize(256, 256);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 1, 69);
      Leg2.addBox(-1F, 0F, -1F, 2, 5, 2);
      Leg2.setRotationPoint(-7F, 19F, -11F);
      Leg2.setTextureSize(256, 256);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 1, 69);
      Leg3.addBox(-1F, 0F, -1F, 2, 5, 2);
      Leg3.setRotationPoint(-7F, 19F, 11F);
      Leg3.setTextureSize(256, 256);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 1, 69);
      Leg4.addBox(-1F, 0F, -1F, 2, 5, 2);
      Leg4.setRotationPoint(7F, 19F, 11F);
      Leg4.setTextureSize(256, 256);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      TapPart1 = new ModelRenderer(this, 0, 83);
      TapPart1.addBox(-1F, 0F, -1F, 2, 2, 3);
      TapPart1.setRotationPoint(0F, 13F, -15.26667F);
      TapPart1.setTextureSize(256, 256);
      TapPart1.mirror = true;
      setRotation(TapPart1, 0F, 0F, 0F);
      TapPart2 = new ModelRenderer(this, 0, 76);
      TapPart2.addBox(-1F, 0F, -1F, 2, 5, 2);
      TapPart2.setRotationPoint(0F, 13F, -17F);
      TapPart2.setTextureSize(256, 256);
      TapPart2.mirror = true;
      setRotation(TapPart2, -0.0698132F, 0F, 0F);
      TapPart3 = new ModelRenderer(this, 0, 89);
      TapPart3.addBox(-1F, 0F, -1F, 2, 4, 1);
      TapPart3.setRotationPoint(0F, 9F, -18F);
      TapPart3.setTextureSize(256, 256);
      TapPart3.mirror = true;
      setRotation(TapPart3, 0.3490659F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Bottom.render(f5);
    Top.render(f5);
    SideEast.render(f5);
    SideWest.render(f5);
    Corner1A.render(f5);
    Corner1B.render(f5);
    Corner2A.render(f5);
    Corner2B.render(f5);
    Corner3A.render(f5);
    Corner3B.render(f5);
    Corner4A.render(f5);
    Corner4B.render(f5);
    Front.render(f5);
    Back.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    TapPart1.render(f5);
    TapPart2.render(f5);
    TapPart3.render(f5);
  }
  
  public void renderAll()
  {
	  float f5 = 0.0625F;
	    Bottom.render(f5);
	    Top.render(f5);
	    SideEast.render(f5);
	    SideWest.render(f5);
	    Corner1A.render(f5);
	    Corner1B.render(f5);
	    Corner2A.render(f5);
	    Corner2B.render(f5);
	    Corner3A.render(f5);
	    Corner3B.render(f5);
	    Corner4A.render(f5);
	    Corner4B.render(f5);
	    Front.render(f5);
	    Back.render(f5);
	    Leg1.render(f5);
	    Leg2.render(f5);
	    Leg3.render(f5);
	    Leg4.render(f5);
	    TapPart1.render(f5);
	    TapPart2.render(f5);
	    TapPart3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
	}

}

package v3XzZ.mFC.client.render;

import java.util.EnumSet;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.util.MathHelper;
import v3XzZ.mFC.entity.PlayerData;
import v3XzZ.mFC.lib.References;
import v3XzZ.mFC.lib.Textures;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

/**
 * Project: mFC
 * 
 * Class: RenderOnScreen
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class RenderOnScreen implements ITickHandler {
	
	Random random = new Random();

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if(Minecraft.getMinecraft().theWorld != null){
			if(Minecraft.getMinecraft().playerController.shouldDrawHUD()){
				Minecraft mc = Minecraft.getMinecraft();
		        Entity entity = mc.thePlayer.ridingEntity;

		        if (entity == null){
					mc.mcProfiler.startSection("thirst");
					if(!mc.thePlayer.isInsideOfMaterial(Material.water)){
						int tLevel = ((PlayerData) mc.thePlayer.getExtendedProperties(References.ENTITY_IDENTIFYER)).getThirstStat().getThirstLevel();
						GuiIngame gui = mc.ingameGUI;
						mc.func_110434_K().func_110577_a(Textures.GUI_ICONS);
						ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
						int par1 = scaledresolution.getScaledWidth();
				        int par2 = scaledresolution.getScaledHeight();
				        AttributeInstance attributeinstance = mc.thePlayer.func_110148_a(SharedMonsterAttributes.field_111267_a);
				        int l1 = par1 / 2 + 91;
				        int i2 = par2 - 39;
				        float f = (float)attributeinstance.func_111126_e();
				        float f1 = mc.thePlayer.func_110139_bj();
				        int j2 = MathHelper.ceiling_float_int((f + f1) / 2.0F / 10.0F);
				        int k2 = Math.max(10 - (j2 - 2), 3);
				        int l2 = i2 - (j2 - 1) * k2 - 10;
	
						for(int i = 0; i < 10; i++){
					        if (mc.thePlayer.getFoodStats().getSaturationLevel() <= 0.0F && gui.getUpdateCounter() % (tLevel * 3 + 1) == 0)
			                {
			                    l2 += (random.nextInt(3) - 1);
			                }
					        
							gui.drawTexturedModalRect(l1 - i * 8 - 9, l2, 0, 0, 9, 9);
							if(i * 2 + 1 < tLevel){
								gui.drawTexturedModalRect(l1 - i * 8 - 9, l2, 18, 0, 9, 9);
							}
							if(i * 2 + 1 == tLevel){
								gui.drawTexturedModalRect(l1 - i * 8 - 9, l2, 27, 0, 9, 9);
							}
						}
					}
					mc.mcProfiler.endSection();
		        }
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.RENDER);
	}

	@Override
	public String getLabel() {
		return "ScreenRender";
	}

}

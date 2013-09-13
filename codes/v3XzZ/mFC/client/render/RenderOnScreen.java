package v3XzZ.mFC.client.render;

import java.util.EnumSet;
import java.util.Random;

import v3XzZ.mFC.entity.PlayerData;
import v3XzZ.mFC.lib.References;
import v3XzZ.mFC.lib.Textures;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

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
				mc.mcProfiler.startSection("thirst");
				int tLevel = ((PlayerData) mc.thePlayer.getExtendedProperties(References.ENTITY_IDENTIFYER)).getThirstStat().getThirstLevel();
				//float tSatur = ((PlayerData) mc.thePlayer.getExtendedProperties(References.ENTITY_IDENTIFYER)).getThirstStat().getSaturationLevel();
				Gui gui = new Gui();
				mc.func_110434_K().func_110577_a(Textures.GUI_ICONS);
				//System.out.println(tLevel + "  " + tSatur);
				for(int i = 0; i < 10; i++){
					gui.drawTexturedModalRect(0+i*9, 0, 0, 0, 9, 9);
					if(i < tLevel/2){
						gui.drawTexturedModalRect(0+i*9, 0, 18, 0, 9, 9);
					}
				}
				mc.mcProfiler.endSection();
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

package v3XzZ.mFC.core.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent;
import v3XzZ.mFC.entity.PlayerData;
import v3XzZ.mFC.lib.References;

public class EntityHandler {
	
	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event){
		if(event.entity instanceof EntityPlayer){
			event.entity.registerExtendedProperties(References.ENTITY_IDENTIFYER, new PlayerData());
		}
	}
	
	@ForgeSubscribe
	public void onEntityLiving(LivingEvent event){
		if(event.entity instanceof EntityPlayer){
			if(!event.entity.worldObj.isRemote){
				((PlayerData) event.entity.getExtendedProperties(References.ENTITY_IDENTIFYER)).onUpdate(event.entity);
			}
		}
	}
}
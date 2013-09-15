package v3XzZ.mFC.core.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import v3XzZ.mFC.entity.PlayerData;
import v3XzZ.mFC.lib.References;

/**
 * Project: mFC
 * 
 * Class: EntityHandler
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class EntityHandler {
	
	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event){
		if(event.entity instanceof EntityPlayer){
			event.entity.registerExtendedProperties(References.ENTITY_IDENTIFYER, new PlayerData());
		}
	}
	
	@ForgeSubscribe
	public void onLivingUpdate(LivingUpdateEvent event){
		if(event.entity instanceof EntityPlayer){
			if(!event.entity.worldObj.isRemote){
				((PlayerData) event.entity.getExtendedProperties(References.ENTITY_IDENTIFYER)).onUpdate(event.entity);
			}
		}
	}
}
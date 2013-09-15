package v3XzZ.mFC.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import v3XzZ.mFC.mFC;
import v3XzZ.mFC.lib.CommonIds;
import v3XzZ.util.DataWriter;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

/**
 * Project: mFC
 * 
 * Class: PlayerData
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class PlayerData implements IExtendedEntityProperties{
	
	ThirstStat thirst = new ThirstStat();
	
	public boolean canDrink(){
		return thirst.needThirst();
	}
	
	public ThirstStat getThirstStat(){
		return thirst;
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		getThirstStat().writeNBT(compound);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		System.out.println("Loads custom player NBT data");
		getThirstStat().readNBT(compound);
	}

	@Override
	public void init(Entity entity, World world) {
		
	}

	public void onUpdate(Entity entity){
		this.getThirstStat().onUpdate((EntityPlayer) entity);
		this.sendPlayerData(entity);
	}
	
	private void sendPlayerData(Entity entity){
		DataWriter data = new DataWriter();
		data.addByte(CommonIds.PACKET_PLAYERDATA);
		data.addInt(this.getThirstStat().getThirstLevel());
		data.addFloat(this.getThirstStat().getSaturationLevel());
		mFC.proxy.packetcrafter.sendPacketToPlayer(mFC.proxy.packetcrafter.createToClientPacket(data.finalizeData()), (Player) entity, Side.SERVER);
	}
}

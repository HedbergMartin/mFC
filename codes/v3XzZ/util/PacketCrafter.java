package v3XzZ.util;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

/**
 * Project: mFC
 * 
 * Class: PacketCrafter
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class PacketCrafter {
	public static final String clientChannel = "mFC_CLIENT";
	public static final String serverChannel = "mFC_SERVER";

	public Packet createToServerPacket(byte[] values) {
		Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = serverChannel;
        packet.data = values;
        packet.length = values.length;
        return packet;
	}
	
	public Packet createToClientPacket(byte[] values) {
		Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = clientChannel;
        packet.data = values;
        packet.length = values.length;
        return packet;
	}
	
	public void sendPacketToAllPlayers(Packet packet, Side side){
		Side currentSide = FMLCommonHandler.instance().getEffectiveSide();
		if(currentSide == side){
			PacketDispatcher.sendPacketToAllPlayers(packet);
		}
	}
	
	public void sendPacketToPlayer(Packet packet, Player player, Side side){
		Side currentSide = FMLCommonHandler.instance().getEffectiveSide();
		if(currentSide == side){
			PacketDispatcher.sendPacketToPlayer(packet, player);
		}
	}
}

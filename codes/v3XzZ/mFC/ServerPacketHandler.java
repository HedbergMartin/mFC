package v3XzZ.mFC;

import v3XzZ.util.PacketCrafter;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

/**
 * Project: mFC
 * 
 * Class: ServerPacketHandler
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ServerPacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		if(packet.channel.equals(PacketCrafter.serverChannel)){
			byte var1 = packet.data[0];
			switch(var1) {
				
			}
		}
	}
}

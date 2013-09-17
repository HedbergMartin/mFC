package v3XzZ.mFC.network;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.src.ModLoader;
import v3XzZ.mFC.blocks.tileentity.TileEntityBarrel;
import v3XzZ.mFC.blocks.tileentity.TileEntityCauldron;
import v3XzZ.mFC.blocks.tileentity.TileEntityPlate;
import v3XzZ.mFC.blocks.tileentity.TileEntityShelf;
import v3XzZ.mFC.entity.PlayerData;
import v3XzZ.mFC.lib.CommonIds;
import v3XzZ.mFC.lib.References;
import v3XzZ.util.DataReader;
import v3XzZ.util.PacketCrafter;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

/**
 * Project: mFC
 * 
 * Class: ClientPacketHandler
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ClientPacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		if(packet.channel.equals(PacketCrafter.clientChannel)){
			byte var1 = packet.data[0];
			switch(var1) {
				case CommonIds.PACKET_PLATE : this.handlePlateFood(packet); break;
				case CommonIds.PACKET_SHELF : this.handleShelf(packet); break;
				case CommonIds.PACKET_CAULDRON : this.handleCauldron(packet); break;
				case CommonIds.PACKET_RENDER : this.handleRenderUpdate(packet); break;
				case CommonIds.PACKET_PLAYERDATA : this.handlePlayerData(packet); break;
				case CommonIds.PACKET_BARREL : this.handleBarrelData(packet); break;
			}
		}
	}

	private void handleShelf(Packet250CustomPayload packet) {
		DataReader data = new DataReader(packet.data);
		
		int a1,a2,a3,a4,a5,a6,a7,a8,b1,b2,b3,b4,b5,b6,b7,b8;
		int x;
		int y;
		int z;
		
		a1 = data.getInt();
		b1 = data.getInt();
		a2 = data.getInt();
		b2 = data.getInt();
		a3 = data.getInt();
		b3 = data.getInt();
		a4 = data.getInt();
		b4 = data.getInt();
		a5 = data.getInt();
		b5 = data.getInt();
		a6 = data.getInt();
		b6 = data.getInt();
		a7 = data.getInt();
		b7 = data.getInt();
		a8 = data.getInt();
		b8 = data.getInt();
		x = data.getInt();
		y = data.getInt();
		z = data.getInt();
		
		
		TileEntityShelf shelf = (TileEntityShelf) ModLoader.getMinecraftInstance().theWorld.getBlockTileEntity(x, y, z);
		if(shelf != null){
			if(a1 != 0){
				shelf.items[0] = new ItemStack(Item.itemsList[a1], 0, b1);
			}if(a2 != 0){
				shelf.items[1] = new ItemStack(Item.itemsList[a2], 0, b2);
			}if(a3 != 0){
				shelf.items[2] = new ItemStack(Item.itemsList[a3], 0, b3);
			}if(a4 != 0){
				shelf.items[3] = new ItemStack(Item.itemsList[a4], 0, b4);
			}if(a5 != 0){
				shelf.items[4] = new ItemStack(Item.itemsList[a5], 0, b5);
			}if(a6 != 0){
				shelf.items[5] = new ItemStack(Item.itemsList[a6], 0, b6);
			}if(a7 != 0){
				shelf.items[6] = new ItemStack(Item.itemsList[a7], 0, b7);
			}if(a8 != 0){
				shelf.items[7] = new ItemStack(Item.itemsList[a8], 0, b8);
			}
		}
	}

	private void handlePlateFood(Packet250CustomPayload packet) {
		DataReader data = new DataReader(packet.data);
		
		int basefood;
		int salad;
		int protine;
		int x;
		int y;
		int z;
		
		basefood = data.getInt();
		salad = data.getInt();
		protine = data.getInt();
		x = data.getInt();
		y = data.getInt();
		z = data.getInt();
		
		
		TileEntityPlate plate = (TileEntityPlate) ModLoader.getMinecraftInstance().theWorld.getBlockTileEntity(x, y, z);
		if(plate != null){
			plate.baseFood = basefood;
			plate.salad = salad;
			plate.protien = protine;
		}
	}
	
	private void handleCauldron(Packet250CustomPayload packet) {
		DataReader data = new DataReader(packet.data);
		int item = data.getInt();
		int metadata = data.getInt();
		int liquid = data.getInt();
		int liqBoil = data.getInt();
		boolean burning = data.getBoolean();
		int x = data.getInt();
		int y = data.getInt();
		int z = data.getInt();
		TileEntityCauldron tile = (TileEntityCauldron) Minecraft.getMinecraft().theWorld.getBlockTileEntity(x, y, z);
		if(tile != null){
			if(item != -1){
				tile.itemBoiling[5] = new ItemStack(Item.itemsList[item], 1, metadata);
			}else {
				tile.itemBoiling[5] = null;
			}
			tile.Liquid = liquid;
			tile.liqiudBoilTime = liqBoil;
			tile.isLit = burning;
		}
	}
	
	private void handleRenderUpdate(Packet250CustomPayload packet) {
		DataReader data = new DataReader(packet.data);
		Minecraft.getMinecraft().theWorld.markBlockForRenderUpdate(data.getInt(), data.getInt(), data.getInt());
	}

	private void handlePlayerData(Packet250CustomPayload packet) {
		DataReader data = new DataReader(packet.data);
		int thirst = data.getInt();
		float satur = data.getFloat();
		((PlayerData) Minecraft.getMinecraft().thePlayer.getExtendedProperties(References.ENTITY_IDENTIFYER)).getThirstStat().setThirstLevel(thirst);
		((PlayerData) Minecraft.getMinecraft().thePlayer.getExtendedProperties(References.ENTITY_IDENTIFYER)).getThirstStat().setThirstSaturationLevel(satur);
	}

	private void handleBarrelData(Packet250CustomPayload packet) {
		DataReader data = new DataReader(packet.data);
		int x = data.getInt();
		int y = data.getInt();
		int z = data.getInt();
		boolean isOpen = data.getBoolean();
		boolean isItem = data.getBoolean();
		
		TileEntityBarrel barrel = (TileEntityBarrel) ModLoader.getMinecraftInstance().theWorld.getBlockTileEntity(x, y, z);
		if(barrel != null){
			barrel.isOpen = isOpen;
			if(isItem){
				int item = data.getInt();
				int size = data.getInt();
				int metadata = data.getInt();
				barrel.content[0] = new ItemStack(item, size, metadata);
			}
		}
	}
}

package v3XzZ.mFC.Blocks.TileEntitys;

import v3XzZ.mFC.mFC;
import v3XzZ.mFC.Recipes.PlateRecipes;
import v3XzZ.util.DataWriter;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;

public class TileEntityPlate extends TileEntity {
	
	public int baseFood = 0;
	public int salad = 0;
	public int protien = 0;
	
	@Override
	public void updateEntity() {
		DataWriter data = new DataWriter();
		data.addByte((byte)0);
		data.addInt(this.baseFood);
		data.addInt(this.salad);
		data.addInt(this.protien);
		data.addInt(this.xCoord);
		data.addInt(this.yCoord);
		data.addInt(this.zCoord);
		
		mFC.proxy.packetcrafter.sendPacketToAllPlayers(mFC.proxy.packetcrafter.createToClientPacket(data.finalizeData()), Side.SERVER);
		super.updateEntity();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		baseFood = nbt.getInteger("baseFood");
		salad = nbt.getInteger("salad");
		protien = nbt.getInteger("protine");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("baseFood", baseFood);
		nbt.setInteger("salad", salad);
		nbt.setInteger("protine", protien);
	}

	public int countFood() {
		return PlateRecipes.instance.getHunger(this.baseFood) + PlateRecipes.instance.getHunger(this.salad) + PlateRecipes.instance.getHunger(this.protien);
	}
}

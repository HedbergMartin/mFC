package v3XzZ.mFC.blocks.tileentity;

import java.util.List;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import v3XzZ.mFC.EntityCauldronItem;
import v3XzZ.mFC.mFC;
import v3XzZ.mFC.items.crafting.BoilingRecipes;
import v3XzZ.mFC.lib.CommonIds;
import v3XzZ.util.DataWriter;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;

/**
 * Project: mFC
 * 
 * Class: TileEntityCauldron
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class TileEntityCauldron extends TileEntity {

	public static final int EMPTY = 0;
	public static final int LIQ_WATER = 1;
	public static final int LIQ_MILK = 2;

	public ItemStack[] itemBoiling = new ItemStack[6];
	public int Liquid = 0;
	int ticksBoiled = 0;
	public int maxBurntime = 0;
	public int burningTime = 0;
	public int liqiudBoilTime = 0;
	public boolean isLit = false;
	
	@Override
	public void updateEntity() {
		if(!this.worldObj.isRemote){
			if(this.isLit && maxBurntime != 0){
				this.burningTime++;
				if(this.Liquid != EMPTY){
					this.liqiudBoilTime++;
				}else {
					this.liqiudBoilTime = 0;
				}
				if(this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 3){
					if(this.liqiudBoilTime > 100){
						if(getFoodInCauldron()){
							if((BoilingRecipes.instance.getBoilTime(itemBoiling, this.Liquid) < ticksBoiled && BoilingRecipes.instance.getBoilTime(itemBoiling, this.Liquid) != -1)){
								if(BoilingRecipes.instance.getOutputItem(this.itemBoiling, this.Liquid) != null){
									this.itemBoiling[5] = BoilingRecipes.instance.getOutputItem(this.itemBoiling, this.Liquid);
									int size = this.getSize();
									this.itemBoiling[5].stackSize = size;
									this.sendData();
									for(int i = 0; i < 5; i++){
										this.itemBoiling[i] = null;
									}
								}
							}
							this.ticksBoiled++;
						}else {
							this.ticksBoiled = 0;
						}
					}
				}
				if(burningTime >= maxBurntime){
					maxBurntime = 0;
					burningTime = 0;
					isLit = false;
				}
			}else if(isLit) {
				isLit = false;
			}
			this.sendData();
		}
	}
	
	public int getSize(){
		int size = 64;
		for(int i = 0; i < 5; i++){
			if(this.itemBoiling[i] != null){
				if(this.itemBoiling[i].stackSize <= size){
					size = this.itemBoiling[i].stackSize;
				}
			}
		}
		return size;
	}
	
	public boolean getFoodInCauldron(){
		@SuppressWarnings("rawtypes")
		List itemsInside = this.worldObj.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1.0F, yCoord + 1.0F, zCoord + 1.0F));
		if(!itemsInside.isEmpty() && (this.ticksBoiled == 0 || this.ticksBoiled > 2)){
			for(int l = 0; l < itemsInside.size(); l++){
				if(itemsInside.get(l) instanceof EntityItem && !(itemsInside.get(l) instanceof EntityCauldronItem)){
					ItemStack item = ((EntityItem) itemsInside.get(l)).getEntityItem();
					if(ticksBoiled < 100 && this.itemBoiling[5] == null){
						for(int i = 0; i < 5; i++){
							if(this.itemBoiling[i] == null){
								this.itemBoiling[i] = item.copy();
								((EntityItem) itemsInside.get(l)).setDead();
								this.ticksBoiled = 1;
								EntityCauldronItem entItem = new EntityCauldronItem(worldObj, xCoord+0.5, yCoord, zCoord+0.5, new ItemStack(item.getItem(), 1, item.getItemDamage()));
								this.worldObj.spawnEntityInWorld(entItem);
								break;
							}else if(this.itemBoiling[i].itemID == item.itemID){
								this.itemBoiling[i].stackSize += 1;
								((EntityItem) itemsInside.get(l)).setDead();
								this.ticksBoiled = 1;
								break;
							}
						}
					}
				}
				if(itemsInside.get(l) instanceof EntityCauldronItem){
					if(this.itemBoiling[l] == null){
						((EntityCauldronItem)itemsInside.get(l)).setDead();
					}
				}
			}
		}
		if(this.itemBoiling[5] != null){
			return false;
		}
		if(this.itemBoiling[0] != null){
			return true;
		}
		return false;
	}

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.itemBoiling = new ItemStack[this.itemBoiling.length];
        this.ticksBoiled = par1NBTTagCompound.getInteger("BoilTime");
        this.Liquid = par1NBTTagCompound.getShort("liquid");
        this.burningTime = par1NBTTagCompound.getInteger("burnTime");
        this.maxBurntime = par1NBTTagCompound.getInteger("maxBurn");
        this.isLit = par1NBTTagCompound.getBoolean("isLit");
        this.liqiudBoilTime = par1NBTTagCompound.getInteger("liqBoil");
        
        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.itemBoiling.length)
            {
                this.itemBoiling[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("BoilTime", this.ticksBoiled);
        par1NBTTagCompound.setShort("liquid", (short)this.Liquid);
        par1NBTTagCompound.setInteger("burnTime", this.burningTime);
        par1NBTTagCompound.setInteger("maxBurn", this.maxBurntime);
        par1NBTTagCompound.setBoolean("isLit", this.isLit);
        par1NBTTagCompound.setInteger("liqBoil", this.liqiudBoilTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.itemBoiling.length; ++var3)
        {
            if (this.itemBoiling[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.itemBoiling[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", var2);
    }
    
    public void sendRenderUpdate(){
		DataWriter data = new DataWriter();
		data.addByte(CommonIds.PACKET_RENDER);
		data.addInt(this.xCoord);
		data.addInt(this.yCoord);
		data.addInt(this.zCoord);
		PacketDispatcher.sendPacketToAllPlayers(mFC.proxy.packetcrafter.createToClientPacket(data.finalizeData()));
    }
    
	public void sendData() {
		DataWriter data = new DataWriter();
		data.addByte(CommonIds.PACKET_CAULDRON);
		if(this.itemBoiling[5] != null){
			data.addInt(this.itemBoiling[5].itemID);
			data.addInt(this.itemBoiling[5].getItemDamage());
		}else {
			data.addInt(-1);
			data.addInt(-1);
		}
		data.addInt(this.Liquid);
		data.addInt(this.liqiudBoilTime);
		data.addBoolean(isLit);
		data.addInt(this.xCoord);
		data.addInt(this.yCoord);
		data.addInt(this.zCoord);
		mFC.proxy.packetcrafter.sendPacketToAllPlayers(mFC.proxy.packetcrafter.createToClientPacket(data.finalizeData()), Side.SERVER);
	}
}

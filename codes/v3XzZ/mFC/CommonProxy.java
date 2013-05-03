package v3XzZ.mFC;

import v3XzZ.mFC.Blocks.TileEntitys.ContainerShelf;
import v3XzZ.mFC.Blocks.TileEntitys.FarmKegContainer;
import v3XzZ.mFC.Blocks.TileEntitys.TileEntityBeerKeg;
import v3XzZ.mFC.Blocks.TileEntitys.TileEntityShelf;
import v3XzZ.mFC.client.GuiBreawingKeg;
import v3XzZ.mFC.client.GuiShelf;
import v3XzZ.util.PacketCrafter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

/**
 * Project: mFC
 * 
 * Class: CommonProxy
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class CommonProxy implements IGuiHandler
{
	public PacketCrafter packetcrafter;
	
	/**
	 * Client side only register stuff...
	 */
	public void registerRenderInformation() {
		
	}
	
	public void init(){
		this.packetcrafter = new PacketCrafter();
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
		{
			if(ID == 87) {
				TileEntityBeerKeg var6 = (TileEntityBeerKeg)world.getBlockTileEntity(x, y, z);
				return new FarmKegContainer(player.inventory, var6);
			}
			else if(ID == 88) {
				TileEntityShelf var7 = (TileEntityShelf)world.getBlockTileEntity(x, y, z);
				return new ContainerShelf(player.inventory, var7);
			}
			else return null;
		}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == 87) {
			TileEntityBeerKeg var6 = (TileEntityBeerKeg)world.getBlockTileEntity(x, y, z);
			return new GuiBreawingKeg(player.inventory, var6);
		}
		else if(ID == 88) {
			TileEntityShelf var7 = (TileEntityShelf)world.getBlockTileEntity(x, y, z);
			return new GuiShelf(player.inventory, var7);
		}
		else return null;
	}

}
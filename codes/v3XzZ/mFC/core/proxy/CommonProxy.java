package v3XzZ.mFC.core.proxy;

import v3XzZ.mFC.blocks.tileentity.ContainerShelf;
import v3XzZ.mFC.blocks.tileentity.FarmKegContainer;
import v3XzZ.mFC.blocks.tileentity.TileEntityBeerKeg;
import v3XzZ.mFC.blocks.tileentity.TileEntityShelf;
import v3XzZ.mFC.client.gui.GuiBreawingKeg;
import v3XzZ.mFC.client.gui.GuiShelf;
import v3XzZ.mFC.lib.CommonIds;
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
			if(ID == CommonIds.GUI_KEG) {
				TileEntityBeerKeg var6 = (TileEntityBeerKeg)world.getBlockTileEntity(x, y, z);
				return new FarmKegContainer(player.inventory, var6);
			} else if(ID == CommonIds.GUI_SHELF) {
				TileEntityShelf var7 = (TileEntityShelf)world.getBlockTileEntity(x, y, z);
				return new ContainerShelf(player.inventory, var7);
			}
			return null;
		}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == CommonIds.GUI_KEG) {
			TileEntityBeerKeg var6 = (TileEntityBeerKeg)world.getBlockTileEntity(x, y, z);
			return new GuiBreawingKeg(player.inventory, var6);
		} else if(ID == CommonIds.GUI_SHELF) {
			TileEntityShelf var7 = (TileEntityShelf)world.getBlockTileEntity(x, y, z);
			return new GuiShelf(player.inventory, var7);
		}
		return null;
	}

}
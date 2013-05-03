package v3XzZ.mFC.client;

import v3XzZ.mFC.CommonProxy;
import v3XzZ.mFC.EntityCauldronItem;
import v3XzZ.mFC.mFC;
import v3XzZ.mFC.Blocks.TileEntitys.TileEntityBeerKeg;
import v3XzZ.mFC.Blocks.TileEntitys.TileEntityCauldron;
import v3XzZ.mFC.Blocks.TileEntitys.TileEntityPlate;
import v3XzZ.mFC.Blocks.TileEntitys.TileEntityShelf;
import net.minecraft.client.renderer.entity.RenderItem;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Project: mFC
 * 
 * Class: ClientProxy
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderInformation() {
		mFC.RenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(mFC.RenderID, new BlockRenderHandler());
		RenderingRegistry.registerEntityRenderingHandler(EntityCauldronItem.class, new RenderItem());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBeerKeg.class, new TileEntityBeerKegRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlate.class, new TileEntityPlateRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShelf.class, new TileEntityShelfRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCauldron.class, new TileEntityCauldronRender());
	}
}
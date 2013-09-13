package v3XzZ.mFC.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import v3XzZ.mFC.blocks.tileentity.ContainerShelf;
import v3XzZ.mFC.blocks.tileentity.TileEntityShelf;
import v3XzZ.mFC.lib.Textures;

/**
 * Project: mFC
 * 
 * Class: GuiShelf
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class GuiShelf extends GuiContainer
{
    public TileEntityShelf shelfInventory;

    public GuiShelf(InventoryPlayer par1InventoryPlayer, TileEntityShelf shelfTile)
    {
        super(new ContainerShelf(par1InventoryPlayer, shelfTile));
        this.shelfInventory = shelfTile;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everythin in front of the items)
     */
    protected void drawGuiContainerForegroundLayer()
    {
        this.fontRenderer.drawString(StatCollector.translateToLocal("Shelf"), 60, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.func_110434_K().func_110577_a(Textures.GUI_SHELF);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
    }
}
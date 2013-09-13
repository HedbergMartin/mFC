package v3XzZ.mFC.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import v3XzZ.mFC.blocks.tileentity.FarmKegContainer;
import v3XzZ.mFC.blocks.tileentity.TileEntityBeerKeg;
import v3XzZ.mFC.lib.Textures;

/**
 * Project: mFC
 * 
 * Class: GuiBrewingKeg
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class GuiBreawingKeg extends GuiContainer
{
    private TileEntityBeerKeg kegInventory;

    public GuiBreawingKeg(InventoryPlayer par1InventoryPlayer, TileEntityBeerKeg kegTile)
    {
        super(new FarmKegContainer(par1InventoryPlayer, kegTile));
        this.kegInventory = kegTile;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everythin in front of the items)
     */
    protected void drawGuiContainerForegroundLayer()
    {
        this.fontRenderer.drawString(StatCollector.translateToLocal("Brewing Keg"), 60, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.func_110434_K().func_110577_a(Textures.GUI_KEG);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7;

        /*if (this.furnaceInventory.isBurning())
        {	var5 + 112, var6 + 31, 176, 55 - var7, 7, var7 + 2
            var7 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(var5 + 56, var6 + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }*/
        
        if(this.kegInventory.isLoaded()){
        	var7 = this.kegInventory.getMeterScaled(1);
        	if(this.kegInventory.getID() == 1){
        		this.drawTexturedModalRect(var5 + 112, var6 + 31 + 24 - var7, 183, 55 - var7, 7, var7 + 2);
        	}else if(this.kegInventory.getID() == 2){
        		this.drawTexturedModalRect(var5 + 112, var6 + 31 + 24 - var7, 190, 55 - var7, 7, var7 + 2);
        	}else if(this.kegInventory.getID() == 3){
        		this.drawTexturedModalRect(var5 + 112, var6 + 31 + 24 - var7, 176, 55 - var7, 7, var7 + 2);
        	}else if(this.kegInventory.getID() == 4){
        		this.drawTexturedModalRect(var5 + 112, var6 + 31 + 24 - var7, 197, 55 - var7, 7, var7 + 2);
        	}
        }

        var7 = this.kegInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);
    }
}
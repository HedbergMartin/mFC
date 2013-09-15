package v3XzZ.mFC.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import v3XzZ.mFC.client.render.tileentity.TileEntityPlateRender;
import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: mFCSword
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class mFCSword extends ItemSword
{

    public mFCSword(int i, EnumToolMaterial enumtool)
    {
        super(i, enumtool);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	if(TileEntityPlateRender.specialChickenIcon == null){
    		TileEntityPlateRender.specialChickenIcon = par1IconRegister.registerIcon("mFC:chickenLeg");
    	}
    	this.itemIcon = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}

package v3XzZ.mFC.lib;

import v3XzZ.util.Common;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;

/**
 * Project: mFC
 * 
 * Class: Textures
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class Textures {

	public static final String MODEL_LOCATION = "textures/models/";
	public static final String GUI_LOCATION = "textures/guis/";

    public static final ResourceLocation VANILLA_BLOCK_TEXTURE = TextureMap.field_110575_b;
    public static final ResourceLocation VANILLA_ITEM_TEXTURE = TextureMap.field_110576_c;

    public static final ResourceLocation MODEL_KEG = Common.getLocation(MODEL_LOCATION + "Model_Keg.png");
    public static final ResourceLocation MODEL_BARREL = Common.getLocation(MODEL_LOCATION + "Model_Barrel.png");
    public static final ResourceLocation MODEL_SHELF = Common.getLocation(MODEL_LOCATION + "Model_Shelf.png");
    public static final ResourceLocation MODEL_PLATE = Common.getLocation(MODEL_LOCATION + "Model_Plate.png");

    public static final ResourceLocation GUI_KEG = Common.getLocation(GUI_LOCATION + "Gui_Keg.png");
    public static final ResourceLocation GUI_SHELF = Common.getLocation(GUI_LOCATION + "Gui_Shelf.png");
    public static final ResourceLocation GUI_ICONS = Common.getLocation(GUI_LOCATION + "icons.png");
}

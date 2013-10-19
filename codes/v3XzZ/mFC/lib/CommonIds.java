package v3XzZ.mFC.lib;

import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

/**
 * Project: mFC
 * 
 * Class: CommonIds
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class CommonIds {

	public static final int GUI_KEG = 87;
	public static final int GUI_SHELF = 88;
	
	public static EnumToolMaterial TOOL_OBSIDIAN = EnumHelper.addToolMaterial("OBSIDIAN", 2, 3000, 6F, 1F, 2);
	public static EnumToolMaterial TOOL_KNIFE = EnumHelper.addToolMaterial("KNIFE", 0, 200, 1.0F, 2.0F, 0);
	
	public static final byte PACKET_PLATE = 0;
	public static final byte PACKET_SHELF = 1;
	public static final byte PACKET_CAULDRON = 2;
	public static final byte PACKET_RENDER = 3;
	public static final byte PACKET_PLAYERDATA = 4;
	public static final byte PACKET_BARREL = 5;
	
	public static final String DRINK_BEER = "beer";
	public static final String DRINK_WHITEWINE = "whitewine";
	public static final String DRINK_REDWINE = "redwine";
	public static final String DRINK_JULMUST = "julmust";
	public static final String DRINK_WATER = "water";
	
	public static final int MAX_GRAIN_STACK = 4;
	
	public static final Integer[] appleColors = new Integer[]{0x75FF83, 0xFFE270, 0xFF0000};
	public static final Integer[] orangeColors = new Integer[]{0x008C00, 0x6BFF68, 0xFFD400};
	public static final Integer[] avocadoColors = new Integer[]{0x9DFF96, 0x74BC6F, 0x467043};
}

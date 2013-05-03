package v3XzZ.mFC.Items;

import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FarmFood extends ItemFood {
	
	public FarmFood(int i, int j, int k) {
		super(i, j, false);
		maxStackSize=k;
	}
	
	public FarmFood(int i, int j, int k, boolean dogFoodzZ) {
		super(i, j, dogFoodzZ);
		maxStackSize=k;
	}
	
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {	
        super.onFoodEaten(itemstack, world, entityplayer);
        return itemstack;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister) {
    	this.iconIndex = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}
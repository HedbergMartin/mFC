package v3XzZ.mFC.Items;

import v3XzZ.mFC.lib.Items;
import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: ItemTallBottleDrink
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ItemTallBottleDrink extends ItemFood {

	boolean isAlco = false;
	boolean beer = false;
	public ItemTallBottleDrink(int i, int j) {
		super(i, j, false);
		maxStackSize=1;
	}
	public ItemTallBottleDrink(int i, int j, boolean isAlco, boolean beer) {
		super(i, j, false);
		this.setMaxDamage(3);
		this.setNoRepair();
		this.isAlco = isAlco;
		this.beer = beer;
		maxStackSize=1;
	}
	
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {	
        if(isAlco){
        	itemstack.damageItem(1, entityplayer);
        	entityplayer.getFoodStats().addStats(this);
        	world.playSoundAtEntity(entityplayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
            this.onEaten(itemstack, world, entityplayer);
            if(itemstack.getItemDamage() < 3){
                return itemstack;
            }else{
            	itemstack.stackSize--;
            	return new ItemStack(Items.tallBottle);
            }
        }else if(beer){
            super.onFoodEaten(itemstack, world, entityplayer);
        	return new ItemStack(Items.beerCup);
        }else {
            super.onFoodEaten(itemstack, world, entityplayer);
            return new ItemStack(Items.drinkingGlass);
        }
    }
	
	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
    
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.itemIcon = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}
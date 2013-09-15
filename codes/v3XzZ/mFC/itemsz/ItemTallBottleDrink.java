package v3XzZ.mFC.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import v3XzZ.mFC.api.ItemThirst;
import v3XzZ.mFC.entity.PlayerData;
import v3XzZ.mFC.lib.CommonIds;
import v3XzZ.mFC.lib.Items;
import v3XzZ.mFC.lib.References;
import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: ItemTallBottleDrink
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ItemTallBottleDrink extends ItemThirst {

	String type;
	
	public ItemTallBottleDrink(int i, int j, String type) {
		super(i, j);
		this.setStats(type, 1);
	}
	
	public ItemTallBottleDrink(int i, int j, float k, String type) {
		super(i, j, k);
		this.setStats(type, 1);
	}
	
	private void setStats(String type, int stackSize){
		this.setMaxDamage(3);
		this.setNoRepair();
		this.type = type;
		maxStackSize = stackSize;
	}
	
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {	
        if(type.equals(CommonIds.DRINK_WHITEWINE) || type.equals(CommonIds.DRINK_REDWINE) || type.equals(CommonIds.DRINK_JULMUST)){
        	itemstack.damageItem(1, entityplayer);
            ((PlayerData) entityplayer.getExtendedProperties(References.ENTITY_IDENTIFYER)).getThirstStat().addStats(this);
        	world.playSoundAtEntity(entityplayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
            if(itemstack.getItemDamage() < 3){
                return itemstack;
            }else{
            	itemstack.stackSize--;
            	return new ItemStack(Items.tallBottle);
            }
        }else if(type.equals(CommonIds.DRINK_BEER)){
        	super.onEaten(itemstack, world, entityplayer);
        	return new ItemStack(Items.beerCup);
        }else {
        	super.onEaten(itemstack, world, entityplayer);
            return new ItemStack(Items.drinkingGlass);
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.itemIcon = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}
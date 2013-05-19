package v3XzZ.mFC.Items;

import v3XzZ.mFC.FarmToolMat;
import v3XzZ.mFC.client.TileEntityPlateRender;
import v3XzZ.mFC.lib.Items;
import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: FarmSword
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FarmSword extends Item
{

    public FarmSword(int i, FarmToolMat farmtoolmat)
    {
        super(i);
        maxStackSize = 1;
        setMaxDamage(farmtoolmat.getMaxUses());
        weaponDamage = 4 + farmtoolmat.getDamageVsEntity() * 2;
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return block.blockID != Block.web.blockID ? 1.5F : 15F;
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
    	if(itemstack.itemID != Items.Knife.itemID)
        itemstack.damageItem(1, entityliving1);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
    	if(itemstack.itemID != Items.Knife.itemID)
        itemstack.damageItem(2, entityliving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return weaponDamage;
    }

    public boolean isFull3D()
    {
        return true;
    }

    public EnumAction getItemUseAction(ItemStack itemstack)
    {
        return EnumAction.block;
    }

    public int func_35411_c(ItemStack itemstack)
    {
        return 0x11940;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        entityplayer.setItemInUse(itemstack, func_35411_c(itemstack));
        return itemstack;
    }

    public boolean canHarvestBlock(Block block)
    {
        return block.blockID == Block.web.blockID;
    }

    private int weaponDamage;
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	if(TileEntityPlateRender.specialChickenIcon == null){
    		TileEntityPlateRender.specialChickenIcon = par1IconRegister.registerIcon("mFC:chickenLeg");
    	}
    	this.itemIcon = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}

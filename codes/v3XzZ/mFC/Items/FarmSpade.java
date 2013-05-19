package v3XzZ.mFC.Items;

import v3XzZ.mFC.FarmTool;
import v3XzZ.mFC.FarmToolMat;
import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: FarmSpade
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FarmSpade extends FarmTool
{

    public FarmSpade(int i, FarmToolMat farmtoolmat)
    {
        super(i, 1, farmtoolmat, blocksEffectiveAgainst);
    }

    /** an array of the blocks this spade is effective against */
    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
    	//To debug only
    	//par3EntityPlayer.getFoodStats().setFoodLevel(0);
    	return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.itemIcon = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}

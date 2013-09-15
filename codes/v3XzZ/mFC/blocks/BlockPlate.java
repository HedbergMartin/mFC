package v3XzZ.mFC.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import v3XzZ.mFC.blocks.tileentity.TileEntityPlate;
import v3XzZ.mFC.items.crafting.PlateRecipes;
import v3XzZ.mFC.lib.Items;
import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: BlockPlate
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BlockPlate extends BlockContainer {

	public BlockPlate(int par1, Material par3Material) {
		super(par1, par3Material);
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.2F, 0.8F);
		this.setCreativeTab(CreativeTabs.tabDecorations);
    }
	
    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return !par1World.isAirBlock(par2, par3-1, par4);
    }

    /**
     * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
     * block.
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
    	if (par1World.isRemote)
        {
            return true;
        }
        else if(itemstack != null)
	    {
        	TileEntityPlate var6 = (TileEntityPlate)par1World.getBlockTileEntity(par2, par3, par4);
	
	        if (var6 != null)
	        {
	        	if(itemstack.getItem() == Items.fork){
	        		eat(par1World, par2, par3, par4, par5EntityPlayer, var6.countFood());
	    	    	var6.baseFood = 0;
	    	    	var6.salad = 0;
	    	    	var6.protien = 0;
	    	    	return true;
	        	}
	        	boolean worked = false;
	        	switch(PlateRecipes.instance.isFoodRegistrated(itemstack)){
		        	case(1): if(var6.baseFood == 0){
		        		var6.baseFood = itemstack.itemID;
		        		worked = true;
		        	} break;
		        	case(2): if(var6.salad == 0){
		        		var6.salad = itemstack.itemID;
		        		worked = true;
		        	} break;
		        	case(3): if(var6.protien == 0){
		        		var6.protien = itemstack.itemID;
		        		worked = true;
		        	} break;
	        	}
	        	if(worked){
	        		ItemStack containerItem = null;
	        		if(itemstack.getItem().getContainerItem() != null){
		        		containerItem = new ItemStack(itemstack.getItem().getContainerItem());
	        		}
	        		itemstack.stackSize--;
	        		if(containerItem != null){
	                    if (itemstack.stackSize <= 0)
	                    {
	                        par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, containerItem);
	                    }else if (!par5EntityPlayer.inventory.addItemStackToInventory(containerItem))
	                    {
	                        par1World.spawnEntityInWorld(new EntityItem(par1World, (double)par2 + 0.5D, (double)par3 + 1.5D, (double)par4 + 0.5D, containerItem));
	                    }
	                    else if (par5EntityPlayer instanceof EntityPlayerMP)
	                    {
	                        ((EntityPlayerMP)par5EntityPlayer).sendContainerToPlayer(par5EntityPlayer.inventoryContainer);
	                    }
	        		}
	        	}
	        }
	        return true;
	    }
    	return false;
    }
    
    private void eat(World world, int i, int j, int k, EntityPlayer entityplayer, int food)
    {
        if(entityplayer.canEat(false))
        {
            entityplayer.getFoodStats().addStats(food, 0.1F);
            //world.playSoundAtEntity(entityplayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        }
    }

    /**
     * Returns the TileEntity used by this block.
     */
    public TileEntity createNewTileEntity(World var1) {
    	return new TileEntityPlate();
	}
    
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public int getRenderType()
    {
    	return -1;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.blockIcon = par1IconRegister.registerIcon("mFC:" + Common.getItemName(this.getUnlocalizedName()));
    }
}

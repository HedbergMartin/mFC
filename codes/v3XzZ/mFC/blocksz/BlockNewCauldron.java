package v3XzZ.mFC.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import v3XzZ.mFC.EntityCauldronItem;
import v3XzZ.mFC.mFC;
import v3XzZ.mFC.blocks.tileentity.TileEntityCauldron;
import v3XzZ.mFC.lib.Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: BlockNewCauldron
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BlockNewCauldron extends BlockCauldron implements ITileEntityProvider {
	
	Random rand = new Random();
	public double maxX = 0.8D, minX = 0.2D, maxZ = 0.8D, minZ = 0.2D;
	
	public int pass;

	public BlockNewCauldron(int id) {
		super(id);
        this.isBlockContainer = true;
        this.func_111022_d("cauldron");
        //this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		if(par5Entity instanceof EntityCauldronItem){
			((EntityCauldronItem) par5Entity).shouldDespawn = false;
			TileEntityCauldron tile = (TileEntityCauldron) par1World.getBlockTileEntity(par2, par3, par4);
			if(tile.xCoord + this.minX > par5Entity.posX){
				par5Entity.motionX = 0.1D;
			}else if(tile.xCoord + this.maxX < par5Entity.posX){
				par5Entity.motionX = -0.1D;
			}else if(tile.zCoord + this.minZ > par5Entity.posZ){
				par5Entity.motionZ = 0.1D;
			}else if(tile.zCoord + this.maxZ < par5Entity.posZ){
				par5Entity.motionZ = -0.1D;
			}else {
				par5Entity.motionX += (rand.nextDouble() - rand.nextDouble()) * 0.002D;
				par5Entity.motionZ += (rand.nextDouble() - rand.nextDouble()) * 0.002D;
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		TileEntityCauldron tile = (TileEntityCauldron) par1World.getBlockTileEntity(par2, par3, par4);
		if(tile != null){
			if (tile.isLit)
	        {
	            float f = (float)par2 + 0.5F;
	            float f1 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
	            float f2 = (float)par4 + 0.5F;
	            float f3 = 0.52F;
	            float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

	            par1World.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
	            par1World.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
	            par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
	            par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                /*if(tile.liqiudBoilTime > 100){
                	System.out.println("bubble");
                	double x = 0.5+((par5Random.nextFloat()-0.5)*0.5);
                	double z = 0.5+((par5Random.nextFloat()-0.5)*0.5);
                	par1World.spawnParticle("bubble", par2+x, par3+0.3+1, par4+z, 0.0D, par5Random.nextFloat()*0.7, 0.0D);
                }*/
	        }
		}
	}
	
	/**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
            TileEntityCauldron tile = (TileEntityCauldron) par1World.getBlockTileEntity(par2, par3, par4);

            if (itemstack == null) {
                return true;
            }
            if(tile != null){
            	if(tile.itemBoiling[5] != null){
            		if(itemstack.itemID == Item.bowlEmpty.itemID){
            			--itemstack.stackSize;

                        if (itemstack.stackSize <= 0)
                        {
                            par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, tile.itemBoiling[5]);
                        }else if (!par5EntityPlayer.inventory.addItemStackToInventory(tile.itemBoiling[5]))
                        {
                            par1World.spawnEntityInWorld(new EntityItem(par1World, (double)par2 + 0.5D, (double)par3 + 1.5D, (double)par4 + 0.5D, tile.itemBoiling[5]));
                        }
                        else if (par5EntityPlayer instanceof EntityPlayerMP)
                        {
                            ((EntityPlayerMP)par5EntityPlayer).sendContainerToPlayer(par5EntityPlayer.inventoryContainer);
                        }
                    	tile.itemBoiling[5].stackSize--;
                    	if(tile.itemBoiling[5].stackSize <= 0){
                    		tile.itemBoiling[5] = null;
                    		tile.Liquid = TileEntityCauldron.EMPTY;
                    		par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
                    	}
            		}
            	} 
            	if(itemstack.itemID == Item.flintAndSteel.itemID){
            		tile.isLit = true;
                    par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "fire.ignite", 1.0F, par1World.rand.nextFloat() * 0.4F + 0.8F);
                    itemstack.damageItem(1, par5EntityPlayer);
            	} 
            	if(itemstack.itemID == Block.wood.blockID){
            		tile.maxBurntime += 1200;
            		itemstack.stackSize--;
            	} 
            	if(itemstack.getItemDamage() == 1 && itemstack.itemID == Item.coal.itemID){
            		tile.maxBurntime += 3600;
            		itemstack.stackSize--;
            	}
                int i1 = par1World.getBlockMetadata(par2, par3, par4);

                if (itemstack.itemID == Item.bucketWater.itemID || itemstack.itemID == Items.woodenBucketWater.itemID)
                {
                    if (i1 < 3 && (tile.Liquid == TileEntityCauldron.EMPTY || tile.Liquid == TileEntityCauldron.LIQ_WATER))
                    {
                        if (!par5EntityPlayer.capabilities.isCreativeMode)
                        {
                            par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.bucketEmpty));
                        }
                        tile.Liquid = TileEntityCauldron.LIQ_WATER;
                        tile.sendRenderUpdate();
                        par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
                    }

                    return true;
                } else if (itemstack.itemID == Item.bucketMilk.itemID || itemstack.itemID == Items.woodenBucketMilk.itemID) {
                	if (i1 == 0 && tile.Liquid == TileEntityCauldron.EMPTY)
                    {
                        if (!par5EntityPlayer.capabilities.isCreativeMode)
                        {
                            par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.bucketEmpty));
                        }
                        tile.Liquid = TileEntityCauldron.LIQ_MILK;
                        tile.sendRenderUpdate();
                        par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
                    }

                    return true;
                }
            }
            return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
        }
    }
    
    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
        par1World.removeBlockTileEntity(par2, par3, par4);
    }

    /**
     * Called when the block receives a BlockEvent - see World.addBlockEvent. By default, passes it on to the tile
     * entity at this location. Args: world, x, y, z, blockID, EventID, event parameter
     */
    public boolean onBlockEventReceived(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        super.onBlockEventReceived(par1World, par2, par3, par4, par5, par6);
        TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
        return tileentity != null ? tileentity.receiveClientEvent(par5, par6) : false;
    }

    @SideOnly(Side.CLIENT)
    static Icon liquidIcon;
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	super.registerIcons(par1IconRegister);
    	liquidIcon = par1IconRegister.registerIcon("mfc:cauldron");
    }

    @SideOnly(Side.CLIENT)
    public static Icon getLiquidIcon() {
        return liquidIcon;
    }
    
    @Override
    public int getRenderType() {
    	return mFC.RenderID;
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCauldron();
	}
}

package v3XzZ.mFC.Blocks;

import java.util.Random;

import v3XzZ.mFC.lib.Blocks;
import v3XzZ.mFC.lib.Items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: CropGrape
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class CropGrape extends CropTemplate
{
    public CropGrape(int i)
    {
        super(i);
        this.iconArray = this.registerArray(3);
        setTickRandomly(true);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        this.enableStats = false;
        this.setCreativeTab((CreativeTabs)null);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return AxisAlignedBB.getBoundingBox((double)par2 + this.minX, (double)par3 + this.minY, (double)par4 + this.minZ, (double)par2 + this.maxX, (double)par3 + this.maxY, (double)par4 + this.maxZ);
    }
    
    @Override
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
    {
	        int l = world.getBlockMetadata(i, j, k);
	        int i1 = 0;
	        int j1 = 0;
	        double d = (double)i + (double)i1 * 0.59999999999999998D + 0.5D;
	        double d1 = (double)j + 0.5D;
	        double d2 = (double)k + (double)j1 * 0.59999999999999998D + 0.5D;
			EntityItem item = new EntityItem(world, d, d1, d2, new ItemStack(Items.grapes));
	    	ItemStack itemstack = entityplayer.inventory.getCurrentItem();
	        if(itemstack != null && itemstack.itemID == Item.shears.itemID && l == 2)
	        {
	        	world.setBlock(i, j, k, this.blockID, 1, 2);
	        	if(!world.isRemote){
	        	world.spawnEntityInWorld(item);
	        	}
	            world.markBlockForRenderUpdate(i, j, k);
	            return true;
	        }
        return false;
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == Block.tilledField.blockID || i == Blocks.grapePlant.blockID;
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
	        super.updateTick(par1World, par2, par3, par4, par5Random);
	
	        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
	        {
	            int var6 = par1World.getBlockMetadata(par2, par3, par4);
	
	            if (var6 < 2)
	            {
	                float var7 = this.getGrowthRate(par1World, par2, par3, par4);
	                if (par5Random.nextInt((int)(35.0F / var7) + 1) == 0)
	                {
	                    ++var6;
	                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6, 2);
	                }
	            }
	            if(var6 < 3){
	            	float var7 = this.getGrowthRate(par1World, par2, par3, par4);
	            	if(0 < var6 && par1World.getBlockId(par2, par3+1, par4) == Blocks.woodenTrellis.blockID){
	                	if (par5Random.nextInt((int)(30.0F / 3.125) + 1) == 0){
	                		par1World.setBlock(par2, par3+1, par4, Blocks.grapePlant.blockID);
	                		par1World.markBlockForRenderUpdate(par2, par3+1, par4);
	                	}
	                }
	            }
    	}
    }

    /**
     * Apply bonemeal to the crops.
     */
    public void fertilize(World par1World, int par2, int par3, int par4)
    {
    	if(!par1World.isRemote){
    		int randomGrowth = 1+par1World.rand.nextInt(2);
        	if(par1World.getBlockMetadata(par2, par3, par4)+randomGrowth >= 2){
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        	}else{
                par1World.setBlockMetadataWithNotify(par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4)+randomGrowth, 2);
        	}
    	}
    }

    private float getGrowthRate(World par1World, int par2, int par3, int par4)
    {
        float var5 = 1.0F;
        int var6 = par1World.getBlockId(par2, par3, par4 - 1);
        int var7 = par1World.getBlockId(par2, par3, par4 + 1);
        int var8 = par1World.getBlockId(par2 - 1, par3, par4);
        int var9 = par1World.getBlockId(par2 + 1, par3, par4);
        int var10 = par1World.getBlockId(par2 - 1, par3, par4 - 1);
        int var11 = par1World.getBlockId(par2 + 1, par3, par4 - 1);
        int var12 = par1World.getBlockId(par2 + 1, par3, par4 + 1);
        int var13 = par1World.getBlockId(par2 - 1, par3, par4 + 1);
        boolean var14 = var8 == this.blockID || var9 == this.blockID;
        boolean var15 = var6 == this.blockID || var7 == this.blockID;
        boolean var16 = var10 == this.blockID || var11 == this.blockID || var12 == this.blockID || var13 == this.blockID;

        for (int var17 = par2 - 1; var17 <= par2 + 1; ++var17)
        {
            for (int var18 = par4 - 1; var18 <= par4 + 1; ++var18)
            {
                int var19 = par1World.getBlockId(var17, par3 - 1, var18);
                float var20 = 0.0F;

                if (var19 == Block.tilledField.blockID || var19 == Blocks.grapePlant.blockID)
                {
                    var20 = 1.0F;

                    if (par1World.getBlockMetadata(var17, par3 - 1, var18) > 0)
                    {
                        var20 = 3.0F;
                    }
                }

                if (var17 != par2 || var18 != par4)
                {
                    var20 /= 4.0F;
                }

                var5 += var20;
            }
        }

        if (var16 || var14 && var15)
        {
            var5 /= 2.0F;
        }

        return var5;
    }

    public int getRenderType()
    {
        return 6;
    }
    
    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1)
    {
        super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
        if(world.isRemote)
        {
            return;
        }
        float f1 = 0.7F;
        float f2 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
        float f3 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
        float f4 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
        EntityItem entityitem = new EntityItem(world, (float)i + f2, (float)j + f3, (float)k + f4, new ItemStack(Blocks.woodenTrellis));
        entityitem.delayBeforeCanPickup = 10;
        world.spawnEntityInWorld(entityitem);
        for(int kll = 0; kll < 3; kll++){
            if(world.rand.nextInt(3) == 1){
            	EntityItem ei2 = new EntityItem(world, (float)i + f2, (float)j + f3, (float)k + f4, new ItemStack(Items.grapeSeeds));
            	ei2.delayBeforeCanPickup = 10;
                world.spawnEntityInWorld(ei2);
            }
        }
    }
    
    @Override
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
    	if(par1World.getBlockMetadata(par2, par3, par4) == 2){
    		par1World.setBlock(par2, par3, par4, Blocks.grapePlant.blockID, 1, 2);
    		par1World.markBlockForRenderUpdate(par2, par3, par4);
    	}
    }

    public int idDropped(int i, Random random, int j)
    {
        if(i == 2)
        {
            return Items.grapes.itemID;
        } else
        {
            return -1;
        }
    }
    

    public int quantityDropped(Random random)
    {
        return 2;
    }
	
	@Override
	public int idPicked(World par1World, int par2, int par3, int par4) {
		return Blocks.woodenTrellis.blockID;
	}
}
package v3XzZ.mFC.Blocks;

import java.util.ArrayList;
import java.util.Random;

import v3XzZ.mFC.Identifications;
import v3XzZ.mFC.lib.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: CropBush
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class CropBush extends CropTemplate {
    
	private boolean isBush = false;
	private int drop, stage, seed, rendertype;
	
	public CropBush(int i, int stage, int drop, int seed, boolean bush)
    {
        super(i, Material.plants);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        setHardness(1.0F);
        isBush = bush;
        this.drop = drop;
        this.stage = stage;
        this.seed = seed;
        if(!bush) rendertype = 1;
        else rendertype = 6;
        this.enableStats = false;
        this.iconArray = this.registerArray(this.stage);
        //requiresSelfNotify[this.blockID] = true;
        this.setCreativeTab((CreativeTabs)null);
    }

	@Override
    public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
    {
    	if(!world.isRemote)
        {
    		/*EntityItem item = new EntityItem(world, d, d1, d2, new ItemStack(mFC.grapes));
	        world.spawnEntityInWorld(item);*/
	        if(isBush && l == stage) {
	        	world.setBlockMetadataWithNotify(i, j, k, stage-2, 2);
	        }else if(l == stage) {
	        	world.setBlockMetadataWithNotify(i, j, k, stage-3, 2);
	        }
        }
    }
	
	/**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);
            if (var6 < stage)
            {
                float var7 = this.getGrowthRate(par1World, par2, par3, par4);
                if (par5Random.nextInt((int)(35.0F / var7) + 1) == 2)
                {
                    ++var6;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6, 2);
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
    		int randomGrowth = 1+par1World.rand.nextInt(3);
        	if(par1World.getBlockMetadata(par2, par3, par4)+randomGrowth >= stage){
                par1World.setBlockMetadataWithNotify(par2, par3, par4, stage-1, 2);
        	}else{
                par1World.setBlockMetadataWithNotify(par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4)+randomGrowth, 2);
        	}
    	}
    }
    
    /**
     * Gets the growth rate for the crop. Setup to encourage rows by halving growth rate if there is diagonals, crops on
     * different sides that aren't opposing, and by adding growth for every crop next to this one (and for crop below
     * this one). Args: x, y, z
     */
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

                if (var19 == Block.tilledField.blockID)
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
    
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        return ret;
    }
    
    @Override
    public int idDropped(int i, Random random, int j)
    {
    	/*System.out.print(i);
    	if (i == (stage-1)){
    		return drop;
    	}
    	else */return -1;
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }
    
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return rendertype;
    }
    
    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1)
    {
        super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
        Random rand = new Random();
        if(world.isRemote)
        {
            return;
        }
        for(int i2 = 0; i2 < 3; i2++)
        {
            if(world.rand.nextInt(4) <= 1 && l != stage)
            {
                float f1 = 0.7F;
                float f2 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f3 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f4 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                EntityItem entityitem = new EntityItem(world, (float)i + f2, (float)j + f3, (float)k + f4, new ItemStack(getSeed()));
                entityitem.delayBeforeCanPickup = 10;
                world.spawnEntityInWorld(entityitem);
            }
        }
        if(l == stage){
        	for(int w = 0; w < 1+rand.nextInt(2); w++){
        		float f1 = 0.7F;
                float f2 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f3 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                float f4 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
                EntityItem entityitem = new EntityItem(world, (float)i + f2, (float)j + f3, (float)k + f4, new ItemStack(getDrop()));
                entityitem.delayBeforeCanPickup = 10;
                world.spawnEntityInWorld(entityitem);
        	}
        }
    }
    
    private Item getSeed() {
    	if(seed == Identifications.raspBerrySeedsID){
    		return Items.raspBerrySeeds;
    	}else if(seed == Identifications.strawBerrySeedsID){
    		return Items.strawBerrySeeds;
    	}else if(seed == Identifications.tomatoSeedsID){
    		return Items.tomatoSeeds;
    	}else{
    		return null;
    	}
      
    }
    
    private Item getDrop() {
    	if(drop == Items.raspBerry.itemID){
    		return Items.raspBerry;
    	}else if(drop == Items.strawBerry.itemID){
    		return Items.strawBerry;
    	}else if(drop == Items.tomato.itemID){
    		return Items.tomato;
    	}else{
    		return null;
    	}
      
    }
    
    @Override
    public int idPicked(World par1World, int par2, int par3, int par4) {
    	return getSeed().itemID;
    }
}

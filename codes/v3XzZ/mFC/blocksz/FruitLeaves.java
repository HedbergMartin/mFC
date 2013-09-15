package v3XzZ.mFC.blocks;

import java.util.List;
import java.util.Random;

import v3XzZ.mFC.lib.Items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: FruitLeaves
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FruitLeaves extends BlockLeavesBase {
    int[] adjacentTreeBlocks;
    public final String[] names = new String[] {"leaves", "leaves_jungle"};
    private Icon[] iconArray = new Icon[2];
    
    public FruitLeaves(int par1) {
		super(par1, Material.leaves, false);
		this.setTickRandomly(true);
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return true;
    }
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random random)
    {
		if (!par1World.isRemote)
	    {
			if(random.nextInt(180) == 4 && par1World.getBlockId(par2, par3-1, par4) == 0){
			    float f1 = 0.7F;
		        float f2 = par1World.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
		        float f3 = par1World.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
		        float f4 = par1World.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
		        EntityItem entityitem = null;
		        switch(par1World.getBlockMetadata(par2, par3, par4)){
			        case(0) : entityitem = new EntityItem(par1World, (float)par2 + f2, (float)par3 + f3, (float)par4 + f4, new ItemStack(Item.appleRed)); break;
			        case(1) : entityitem = new EntityItem(par1World, (float)par2 + f2, (float)par3 + f3, (float)par4 + f4, new ItemStack(Items.orange)); break;
			        case(2) : entityitem = new EntityItem(par1World, (float)par2 + f2, (float)par3 + f3, (float)par4 + f4, new ItemStack(Items.avacado)); break;
			        case(3) : entityitem = new EntityItem(par1World, (float)par2 + f2, (float)par3 + f3, (float)par4 + f4, new ItemStack(Items.CocoaFruit)); break;
			    }
		        if(entityitem != null){
			        entityitem.delayBeforeCanPickup = 10;
			        par1World.spawnEntityInWorld(entityitem);
		        }
			}
	   
	   
           int var6 = par1World.getBlockMetadata(par2, par3, par4);

           if ((var6 & 8) != 0 && (var6 & 4) == 0)
           {
               byte var7 = 4;
               int var8 = var7 + 1;
               byte var9 = 32;
               int var10 = var9 * var9;
               int var11 = var9 / 2;

               if (this.adjacentTreeBlocks == null)
               {
                   this.adjacentTreeBlocks = new int[var9 * var9 * var9];
               }

               int var12;

               if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
               {
                   int var13;
                   int var14;
                   int var15;

                   for (var12 = -var7; var12 <= var7; ++var12)
                   {
                       for (var13 = -var7; var13 <= var7; ++var13)
                       {
                           for (var14 = -var7; var14 <= var7; ++var14)
                           {
                               var15 = par1World.getBlockId(par2 + var12, par3 + var13, par4 + var14);

                               Block block = Block.blocksList[var15];

                               if (block != null && block.canSustainLeaves(par1World, par2 + var12, par3 + var13, par4 + var14))
                               {
                                   this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
                               }
                               else if (block != null && block.isLeaves(par1World, par2 + var12, par3 + var13, par4 + var14))
                               {
                                   this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
                               }
                               else
                               {
                                   this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
                               }
                           }
                       }
                   }

                   for (var12 = 1; var12 <= 4; ++var12)
                   {
                       for (var13 = -var7; var13 <= var7; ++var13)
                       {
                           for (var14 = -var7; var14 <= var7; ++var14)
                           {
                               for (var15 = -var7; var15 <= var7; ++var15)
                               {
                                   if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11] == var12 - 1)
                                   {
                                       if (this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2)
                                       {
                                           this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                       }

                                       if (this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2)
                                       {
                                           this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                       }

                                       if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] == -2)
                                       {
                                           this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] = var12;
                                       }

                                       if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] == -2)
                                       {
                                           this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] = var12;
                                       }

                                       if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] == -2)
                                       {
                                           this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] = var12;
                                       }

                                       if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] == -2)
                                       {
                                           this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] = var12;
                                       }
                                   }
                               }
                           }
                       }
                   }
               }

               var12 = this.adjacentTreeBlocks[var11 * var10 + var11 * var9 + var11];

               if (var12 >= 0)
               {
                   par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 & -9, 2);
               }
               else
               {
                   this.removeLeaves(par1World, par2, par3, par4);
               }
           }
       }
    }
	
	private void removeLeaves(World par1World, int par2, int par3, int par4)
    {
        this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
        par1World.setBlock(par2, par3, par4, 0);
    }
	
	@SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        double var1 = 0.5D;
        double var3 = 1.0D;
        return ColorizerFoliage.getFoliageColor(var1, var3);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    public int getRenderColor(int par1)
    {
        return ColorizerFoliage.getFoliageColorBasic();
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        return ((par2 & 3) == 3 ? this.iconArray[1] : this.iconArray[0]);
    }
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        for (int i = 0; i < 2; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(this.names[i]);
        }
    }
    
    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
    	return 0;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int var6 = 0;
        int var7 = 0;
        int var8 = 0;

        for (int var9 = -1; var9 <= 1; ++var9)
        {
            for (int var10 = -1; var10 <= 1; ++var10)
            {
                int var11 = par1IBlockAccess.getBiomeGenForCoords(par2 + var10, par4 + var9).getBiomeFoliageColor();
                var6 += (var11 & 16711680) >> 16;
                var7 += (var11 & 65280) >> 8;
                var8 += var11 & 255;
            }
        }

        return (var6 / 9 & 255) << 16 | (var7 / 9 & 255) << 8 | var8 / 9 & 255;
    }
    
    @Override
    public void beginLeavesDecay(World world, int x, int y, int z)
    {
        world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 2);
    }
    
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
    }
    
    @Override
    public boolean isLeaves(World world, int x, int y, int z)
    {
        return true;
    }
}

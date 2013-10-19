package v3XzZ.mFC.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import v3XzZ.mFC.mFC;
import v3XzZ.mFC.lib.Items;
import v3XzZ.mFC.lib.References;
import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: FruitTreeLeaves
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FruitTreeLeaves extends BlockLeaves {
	
    public static final String[][] field_94396_b = new String[][] {{"leaves_oak", "leaves_spruce", "leaves_birch", "leaves_jungle"}, {"leaves_oak_opaque", "leaves_spruce_opaque", "leaves_birch_opaque", "leaves_jungle_opaque"}};
    public String[] fruits = new String[]{"apple", "orange", "avocado"};
    public Icon[] iconArray = new Icon[3];
    private Icon[][] iconArrayLeaves = new Icon[2][];
    public Integer[] colors;
    int type;
    
	public FruitTreeLeaves(int par1, int t, Integer[] colors) {
		super(par1);
		this.type = t;
		this.colors = colors;
		this.setCreativeTab((CreativeTabs) null);
	}
	
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		if (!par1World.isRemote) {
			if(par5Random.nextInt(180) == 4) {
				int l = par1World.getBlockMetadata(par2, par3, par4);
				if(l >= 3) {
			        Item tempItem = null;
			        int dropPlace = 0;
			        switch(type) {
			        	case 0 : tempItem = Item.appleRed; break;
			        	case 1 : tempItem = Items.orange; break;
			        	case 2 : tempItem = Items.avacado; break;
			        }
			        for(int i = 0; i < 5; i++) {
			        	if(par1World.getBlockId(par2, par3-i, par4) == 0){
			        		dropPlace = i;
			        		break;
			        	}
			        }
			        this.dropBlockAsItem_do(par1World, par2, par3-dropPlace, par4, new ItemStack(tempItem));
			        par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
				}else if(l >= 0){
			        par1World.setBlockMetadataWithNotify(par2, par3, par4, l+1, 2);
				}
			}
	    }
		super.updateTick(par1World, par2, par3, par4, par5Random);
	}
	
	@Override
    public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l) {
		if(world.isRemote) {
			return;
		}
		if((l & 3)== 3) {
			Item tempItem = null;
	        switch(type) {
	        	case 0 : tempItem = Item.appleRed; break;
	        	case 1 : tempItem = Items.orange; break;
	        	case 2 : tempItem = Items.avacado; break;
	        }
	        this.dropBlockAsItem_do(world, i, j, k, new ItemStack(tempItem));
		}
		if((l & 3) != 0) {
			world.setBlock(i, j, k, this.blockID, 0, 2);
		}
		
	}

	@SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister) {
        for (int i = 0; i < field_94396_b.length; ++i) {
            this.iconArrayLeaves[i] = new Icon[field_94396_b[i].length];

            for (int j = 0; j < field_94396_b[i].length; ++j) {
                this.iconArrayLeaves[i][j] = par1IconRegister.registerIcon(field_94396_b[i][j]);
            }
        }
        for(int i = 0; i < iconArray.length; i++) {
        	this.iconArray[i] = par1IconRegister.registerIcon(References.MOD_ID.toLowerCase() + ":" + this.fruits[this.type] + "_" + i);
        }
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public int idPicked(World par1World, int par2, int par3, int par4) {
		return 0;
	}
	
	@SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2) {
		int cp = (Integer) Common.getField(Block.leaves, "field_94394_cP");
		return type == 2 ? this.iconArrayLeaves[cp][2] : this.iconArrayLeaves[cp][0];
    }
	
    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        int metadata = 0;
        switch(type) {
	    	case 0 : metadata = 0; break;
	    	case 1 : metadata = 0; break;
	    	case 2 : metadata = 2; break;
	    }
        ret.add(new ItemStack(Block.leaves, 1, metadata));
        return ret;
    }
    
    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
    	return -1;
    }
    
    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) { }
    
    @Override
    public int getRenderType() {
    	return mFC.RenderID;
    }
    
    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return !Block.leaves.graphicsLevel;
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    public int getRenderColor(int par1)
    {
        return ColorizerFoliage.getFoliageColorBasic();
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
    	int i1 = 0;
        int j1 = 0;
        int k1 = 0;

        for (int l1 = -1; l1 <= 1; ++l1)
        {
            for (int i2 = -1; i2 <= 1; ++i2)
            {
                int j2 = par1IBlockAccess.getBiomeGenForCoords(par2 + i2, par4 + l1).getBiomeFoliageColor();
                i1 += (j2 & 16711680) >> 16;
                j1 += (j2 & 65280) >> 8;
                k1 += j2 & 255;
            }
        }

        return (i1 / 9 & 255) << 16 | (j1 / 9 & 255) << 8 | k1 / 9 & 255;
    }
}

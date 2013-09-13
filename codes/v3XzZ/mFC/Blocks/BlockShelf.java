package v3XzZ.mFC.blocks;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import v3XzZ.mFC.mFC;
import v3XzZ.mFC.blocks.tileentity.TileEntityShelf;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: BlockShelf
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BlockShelf extends BlockContainer {

	public BlockShelf(int par1, Material par3Material) {
		super(par1, par3Material);
        this.setCreativeTab(CreativeTabs.tabDecorations);
	}

    /**
     * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
     * block.
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	if (par1World.isRemote)
        {
            return true;
        }
        else if(!par5EntityPlayer.isSneaking())
	    {
	    TileEntityShelf var6 = (TileEntityShelf)par1World.getBlockTileEntity(par2, par3, par4);
	
	        if (var6 != null)
	        {
	        	par5EntityPlayer.openGui(mFC.instance, 88, par1World, par2, par3, par4);
	        }
	
	        return true;
	    }
    	return false;
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
    	return mFC.RenderID;
    }
    
    public int func_85104_a(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        int var10 = par9;

        if (par5 == 2 && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true))
        {
            var10 = 4;
        }

        if (par5 == 3 && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true))
        {
            var10 = 3;
        }

        if (par5 == 4 && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true))
        {
            var10 = 2;
        }

        if (par5 == 5 && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true))
        {
            var10 = 1;
        }

        return var10;
    }
    
    /**
     * Ray traces through the blocks collision from start vector to end vector returning a ray trace hit. Args: world,
     * x, y, z, startVec, endVec
     */
    public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
    {
        int var7 = par1World.getBlockMetadata(par2, par3, par4);

        if (var7 == 3)
        {
        	this.setBlockBounds(0.0F, 0.3F, 0.1F, 0.2F, 0.6F, 0.9F);
        }
        else if (var7 == 5)
        {
        	this.setBlockBounds(0.8F, 0.3F, 0.1F, 1.0F, 0.6F, 0.9F);
        }
        else if (var7 == 4)
        {
        	this.setBlockBounds(0.1F, 0.3F, 0.0F, 0.9F, 0.6F, 0.2F);
        }
        else if (var7 == 2)
        {
        	this.setBlockBounds(0.1F, 0.3F, 0.8F, 0.9F, 0.6F, 1.0F);
        }

        return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
    }
    
    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack)
    {
        int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var6 == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (var6 == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (var6 == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }

        if (var6 == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }
    }

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityShelf();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("log_oak");
	}
}

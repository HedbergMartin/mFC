package v3XzZ.mFC.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import v3XzZ.mFC.lib.Blocks;
import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: FarmTreeSeed
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FarmTreeSeed extends Item {

	private int	metadata;

	public FarmTreeSeed(int i, int metadata) {
		super(i);
		this.metadata = metadata;
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if(world.isRemote) {
			return itemstack;
		}
		Vec3 var4 = entityplayer.getLook(2.0F);
		Vec3 vec3d = Vec3.createVectorHelper(entityplayer.posX, entityplayer.posY+1.62, entityplayer.posZ);
        double far = 6D;
        Vec3 vec3d1 = vec3d.addVector(var4.xCoord * far, var4.yCoord * far, var4.zCoord * far);
        MovingObjectPosition movingobjectposition = world.clip(vec3d, vec3d1, false);
        int i=0, j=0, k=0;
        int l;
        if(movingobjectposition != null){
        	if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
            {
                i = movingobjectposition.blockX;
                j = movingobjectposition.blockY;
                k = movingobjectposition.blockZ;
                l = movingobjectposition.sideHit;
                switch(l){
	                case 0 : j -= 2; break;
	                case 1 : j++; break;
	                case 2 : k--; break;
	                case 3 : k++; break;
	                case 4 : i--; break;
	                case 5 : i++; break;
                }
            }
        }
        
        if(movingobjectposition != null){
			if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
				if (!world.canMineBlock(entityplayer, i, j, k)) {
					return itemstack;
				}
				if ((world.getBlockId(i, j-1, k) == 2 || world.getBlockId(i, j-1, k) == 3) && world.isAirBlock(i, j, k)) {
					world.setBlock(i, j, k, Blocks.fruitSaplings.blockID, this.metadata, 2);
					itemstack.stackSize--;
					return itemstack;
				} else {
					return itemstack;
				}
			} else {
				return itemstack;
			}
        }
		return itemstack;
	}
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.itemIcon = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}
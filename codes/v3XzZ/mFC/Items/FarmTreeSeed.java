package v3XzZ.mFC.Items;

import v3XzZ.mFC.lib.Blocks;
import v3XzZ.util.Common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class FarmTreeSeed extends Item {

	private int	metadata;

	public FarmTreeSeed(int i, int metadata) {
		super(i);
		this.metadata = metadata;
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer entityplayer) {
		EntityPlayer entityplayer1 = entityplayer;
		float f = 1.0F;
		float f1 = entityplayer1.prevRotationPitch
				+ (entityplayer1.rotationPitch - entityplayer1.prevRotationPitch)
				* f;
		float f2 = entityplayer1.prevRotationYaw
				+ (entityplayer1.rotationYaw - entityplayer1.prevRotationYaw)
				* f;
		double d = entityplayer1.prevPosX
				+ (entityplayer1.posX - entityplayer1.prevPosX) * f;
		double d1 = (entityplayer1.prevPosY
				+ (entityplayer1.posY - entityplayer1.prevPosY) * f + 1.6200000000000001D)
				- entityplayer1.yOffset;
		double d2 = entityplayer1.prevPosZ
				+ (entityplayer1.posZ - entityplayer1.prevPosZ) * f;
		Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
		float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
		float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		float f7 = f4 * f5;
		float f8 = f6;
		float f9 = f3 * f5;
		double d3 = 5D;
		Vec3 vec3d1 = vec3d.addVector(f7 * d3, f8 * d3, f9 * d3);
		MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do(
				vec3d, vec3d1, this.a == 0);
		if (movingobjectposition == null) {
			return itemstack;
		}
		if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
			int i = movingobjectposition.blockX;
			int j = movingobjectposition.blockY;
			int k = movingobjectposition.blockZ;
			if (!world.canMineBlock(entityplayer, i, j, k)) {
				return itemstack;
			}
			if (world.getBlockId(i, j, k) == 2
					|| world.getBlockId(i, j, k) == 3
					&& world.isAirBlock(i, j + 1, k)) {
				world.setBlock(i, j + 1, k, Blocks.fruitSaplings.blockID,
						this.metadata, 2);
				itemstack.stackSize--;
				return itemstack;
			} else {
				return itemstack;
			}
		} else {
			return itemstack;
		}
	}

	private int	a;
    
    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister) {
    	this.iconIndex = par1IconRegister.registerIcon("mFC:"+Common.getItemName(this.getUnlocalizedName()));
    }
}
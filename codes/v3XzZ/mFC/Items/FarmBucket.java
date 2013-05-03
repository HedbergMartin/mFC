package v3XzZ.mFC.Items;

import v3XzZ.mFC.lib.Items;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * Project: mFC
 * 
 * Class: FarmBucket
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FarmBucket extends FarmItem
{

    public FarmBucket(int i, int j)
    {
        super(i);
        maxStackSize = 1;
        isFull = j;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        float f = 1.0F;
        float f1 = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
        float f2 = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
        double d = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * (double)f;
        double d1 = (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * (double)f + 1.6200000000000001D) - (double)entityplayer.yOffset;
        double d2 = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * (double)f;
        Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
        float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
        float f5 = -MathHelper.cos(-f1 * 0.01745329F);
        float f6 = MathHelper.sin(-f1 * 0.01745329F);
        float f7 = f4 * f5;
        float f8 = f6;
        float f9 = f3 * f5;
        double d3 = 5D;
        Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
        MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do(vec3d, vec3d1, isFull == 0);
        if(movingobjectposition == null)
        {
            return itemstack;
        }
        if(movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
        {
            int i = movingobjectposition.blockX;
            int j = movingobjectposition.blockY;
            int k = movingobjectposition.blockZ;
            if(!world.canMineBlock(entityplayer, i, j, k))
            {
                return itemstack;
            }
            if(isFull == 0)
            {
                if(!entityplayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemstack))
                {
                    return itemstack;
                }
                if(world.getBlockMaterial(i, j, k) == Material.water && world.getBlockMetadata(i, j, k) == 0)
                {
                    world.setBlock(i, j, k, 0);
                    return new ItemStack(Items.woodenBucketWater);
                }
            } else
            {
                if(isFull < 0)
                {
                    return new ItemStack(Items.woodenBucket);
                }
                if(movingobjectposition.sideHit == 0)
                {
                    j--;
                }
                if(movingobjectposition.sideHit == 1)
                {
                    j++;
                }
                if(movingobjectposition.sideHit == 2)
                {
                    k--;
                }
                if(movingobjectposition.sideHit == 3)
                {
                    k++;
                }
                if(movingobjectposition.sideHit == 4)
                {
                    i--;
                }
                if(movingobjectposition.sideHit == 5)
                {
                    i++;
                }
                if(!entityplayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemstack))
                {
                    return itemstack;
                }
                if(world.isAirBlock(i, j, k) || !world.getBlockMaterial(i, j, k).isSolid())
                {
                    if(world.provider.isHellWorld && isFull == Block.waterMoving.blockID)
                    {
                        world.playSoundEffect(d + 0.5D, d1 + 0.5D, d2 + 0.5D, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
                        for(int l = 0; l < 8; l++)
                        {
                            world.spawnParticle("largesmoke", (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D);
                        }

                    } else
                    {
                        world.setBlock(i, j, k, isFull, 0, 2);
                    }
                    if(entityplayer.capabilities.isCreativeMode)
                    {
                        return itemstack;
                    } else
                    {
                        return new ItemStack(Items.woodenBucket);
                    }
                }
            }
        } else
        if(isFull == 0 && (movingobjectposition.entityHit instanceof EntityCow))
        {
            return new ItemStack(Items.woodenBucketMilk);
        }
        return itemstack;
    }
    

    
    @Override
    public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving) {
    	if(par1ItemStack != null && par1ItemStack.itemID == Items.woodenBucket.itemID && par2EntityLiving instanceof EntityCow)
        {
    		par1ItemStack.itemID = Items.woodenBucketMilk.itemID;
    	}
		return true;
    }

    private int isFull;
    
    
}
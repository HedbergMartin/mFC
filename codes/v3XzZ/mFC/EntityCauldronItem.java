package v3XzZ.mFC;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemExpireEvent;

public class EntityCauldronItem extends EntityItem {
	
	public boolean shouldDespawn = false;
	
	public EntityCauldronItem(World par1World) {
		super(par1World);
	}

	public EntityCauldronItem(World par1World, double par2, double par4, double par6) {
    	super(par1World, par2, par4, par6);
    }
    
	public EntityCauldronItem(World par1World, double par2, double par4, double par6, ItemStack par8ItemStack) {
		super(par1World, par2, par4, par6, par8ItemStack);
		this.delayBeforeCanPickup = 10;
		this.motionX = 0;
		this.motionY = 0;
		this.motionZ = 0;
	}
	
	/**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.onEntityUpdate();

        if(shouldDespawn){
        	this.setDead();
        }
        this.shouldDespawn = true;
        
        this.delayBeforeCanPickup = 10;
        this.age = 0;

        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        if (this.onGround)
        {
            this.motionY *= -0.5D;
        }

        ItemStack item = getDataWatcher().getWatchableObjectItemStack(10);

        if (!this.worldObj.isRemote && this.age >= lifespan)
        {
            if (item != null)
            {   
                ItemExpireEvent event = new ItemExpireEvent(this, (item.getItem() == null ? 6000 : item.getItem().getEntityLifespan(item, worldObj)));
                if (MinecraftForge.EVENT_BUS.post(event))
                {
                    lifespan += event.extraLife;
                }
                else
                {
                    this.setDead();
                }
            }
            else
            {
                this.setDead();
            }
        }

        if (item != null && item.stackSize <= 0)
        {
            this.setDead();
        }
    }
}

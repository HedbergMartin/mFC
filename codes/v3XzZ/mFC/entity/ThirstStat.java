package v3XzZ.mFC.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import v3XzZ.mFC.api.ItemThirst;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Project: mFC
 * 
 * Class: ThirstStat
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ThirstStat
{
    /** The player's thirst level. */
    private int thirstLevel = 20;

    /** The player's thirst saturation. */
    private float thistSaturationLevel = 5.0F;

    /** The player's thirst exhaustion. */
    //private float thirstExhaustionLevel;

    /** The player's thirst timer value. */
    private int thirstTimer;
    private int prevThirstLevel = 20;

    /**
     * Args: int thirstLevel, float thirstSaturationModifier
     */
    public void addStats(int par1, float par2)
    {
        this.thirstLevel = Math.min(par1 + this.thirstLevel, 20);
        this.thistSaturationLevel = Math.min(this.thistSaturationLevel + (float)par1 * par2 * 2.0F, (float)this.thirstLevel);
    }

    /**
     * Eat some thirst.
     */
    public void addStats(ItemThirst par1ItemThirst)
    {
        this.addStats(par1ItemThirst.getThistLevel(), par1ItemThirst.getThistSaturation());
    }

    /**
     * Handles the thirst game logic.
     */
    public void onUpdate(EntityPlayer par1EntityPlayer)
    {
        int i = par1EntityPlayer.worldObj.difficultySetting;
        this.prevThirstLevel = this.thirstLevel;

        if (par1EntityPlayer.getFoodStats().getExhaustionLevel() > 4.0F)
        {
            if (this.thistSaturationLevel > 0.0F)
            {
                this.thistSaturationLevel = Math.max(this.thistSaturationLevel - 1.0F, 0.0F);
            }
            else if (i > 0)
            {
                this.thirstLevel = Math.max(this.thirstLevel - 1, 0);
            }
        }

        if (par1EntityPlayer.worldObj.getGameRules().getGameRuleBooleanValue("naturalRegeneration") && this.thirstLevel >= 18 && par1EntityPlayer.shouldHeal())
        {
            ++this.thirstTimer;

            /*if (this.thirstTimer >= 80)
            {
                par1EntityPlayer.heal(1.0F);
                this.addExhaustion(3.0F);
                this.thirstTimer = 0;
            }*/
        }
        if(this.thirstLevel <= 6){
        	par1EntityPlayer.setSprinting(false);
        } 
        if (this.thirstLevel <= 0) {
            ++this.thirstTimer;

            if (this.thirstTimer >= 80)
            {
                if (par1EntityPlayer.func_110143_aJ() > 10.0F || i >= 3 || par1EntityPlayer.func_110143_aJ() > 1.0F && i >= 2)
                {
                    par1EntityPlayer.attackEntityFrom(DamageSource.starve, 1.0F);
                }

                this.thirstTimer = 0;
            }
        }
        else
        {
            this.thirstTimer = 0;
        }
    }

    /**
     * Reads thirst stats from an NBT object.
     */
    public void readNBT(NBTTagCompound par1NBTTagCompound)
    {
        if (par1NBTTagCompound.hasKey("thirstLevel"))
        {
            this.thirstLevel = par1NBTTagCompound.getInteger("thirstLevel");
            this.thirstTimer = par1NBTTagCompound.getInteger("thirstTickTimer");
            this.thistSaturationLevel = par1NBTTagCompound.getFloat("thirstSaturationLevel");
            //this.thirstExhaustionLevel = par1NBTTagCompound.getFloat("thirstExhaustionLevel");
        }
    }

    /**
     * Writes thirst stats to an NBT object.
     */
    public void writeNBT(NBTTagCompound par1NBTTagCompound)
    {
        par1NBTTagCompound.setInteger("thirstLevel", this.thirstLevel);
        par1NBTTagCompound.setInteger("thirstTickTimer", this.thirstTimer);
        par1NBTTagCompound.setFloat("thirstSaturationLevel", this.thistSaturationLevel);
        //par1NBTTagCompound.setFloat("thirstExhaustionLevel", this.thirstExhaustionLevel);
    }

    /**
     * Get the player's thirst level.
     */
    public int getThirstLevel()
    {
        return this.thirstLevel;
    }

    @SideOnly(Side.CLIENT)
    public int getPrevThirstLevel()
    {
        return this.prevThirstLevel;
    }

    /**
     * If thirstLevel is not max.
     */
    public boolean needThirst()
    {
        return this.thirstLevel < 20;
    }

    /**
     * adds input to thirstExhaustionLevel to a max of 40
     */
    public void addExhaustion(float par1)
    {
        //this.thirstExhaustionLevel = Math.min(this.thirstExhaustionLevel + par1, 40.0F);
    }

    /**
     * Get the player's thirst saturation level.
     */
    public float getSaturationLevel()
    {
        return this.thistSaturationLevel;
    }

    @SideOnly(Side.CLIENT)
    public void setThirstLevel(int par1)
    {
        this.thirstLevel = par1;
    }

    @SideOnly(Side.CLIENT)
    public void setThirstSaturationLevel(float par1)
    {
        this.thistSaturationLevel = par1;
    }
}

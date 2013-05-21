package v3XzZ.mFC;

/**
 * Project: mFC
 * 
 * Class: FarmToolMat
 * 
 * @author v3XzZ
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public enum FarmToolMat
{
    WOOD("WOOD", 0, 0, 59, 2.0F, 0),
    STONE("STONE", 1, 1, 131, 4F, 1),
    IRON("IRON", 2, 0, 256, 6F, 2),
    EMERALD("EMERALD", 3, 3, 1561, 8F, 3),
    OBSIDIAN("OBSIDIAN", 2, 2, 3000, 6F, 2),
    GOLD("GOLD", 4, 0, 32, 12F, 0);
/*
    public static FarmToolMat[] values()
    {
        return (FarmToolMat[])allToolMaterials.clone();
    }

    public static FarmToolMat valueOf(String s)
    {
        return (FarmToolMat)Enum.valueOf(net.minecraft.src.FarmToolMat.class, s);
    }
*/
    private FarmToolMat(String s, int i, int j, int k, float f, int l)
    {
        harvestLevel = j;
        maxUses = k;
        efficiencyOnProperMaterial = f;
        damageVsEntity = l;
    }

    public int getMaxUses()
    {
        return maxUses;
    }

    public float getEfficiencyOnProperMaterial()
    {
        return efficiencyOnProperMaterial;
    }

    public int getDamageVsEntity()
    {
        return damageVsEntity;
    }

    public int getHarvestLevel()
    {
        return harvestLevel;
    }
/*
    public static final FarmToolMat WOOD;
    public static final FarmToolMat STONE;
    public static final FarmToolMat IRON;
    public static final FarmToolMat EMERALD;
    public static final FarmToolMat OBSIDIAN;
    public static final FarmToolMat GOLD;
*/
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyOnProperMaterial;
    private final int damageVsEntity;
//    private static final FarmToolMat allToolMaterials[]; /* synthetic field */
/*
    static 
    {
        WOOD = new FarmToolMat("WOOD", 0, 0, 59, 2.0F, 0);
        STONE = new FarmToolMat("STONE", 1, 1, 131, 4F, 1);
        IRON = new FarmToolMat("IRON", 2, 2, 250, 6F, 2);
        EMERALD = new FarmToolMat("EMERALD", 3, 3, 1561, 8F, 3);
        GOLD = new FarmToolMat("GOLD", 4, 0, 32, 12F, 0);
        allToolMaterials = (new FarmToolMat[] {
            WOOD, STONE, IRON, EMERALD, GOLD, OBSIDIAN
        });
    }
*/
}
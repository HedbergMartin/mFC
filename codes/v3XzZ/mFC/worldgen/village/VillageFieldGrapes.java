package v3XzZ.mFC.worldgen.village;

import java.util.List;
import java.util.Random;

import v3XzZ.mFC.lib.Blocks;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class VillageFieldGrapes extends ComponentVillage
{
    private int averageGroundLevel = -1;
    private int field_82675_b;
    private int field_82676_c;

    public VillageFieldGrapes(ComponentVillageStartPiece par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
    {
        super(par1ComponentVillageStartPiece, par2);
        this.coordBaseMode = par5;
        this.boundingBox = par4StructureBoundingBox;
        this.field_82675_b = this.pickRandomGrape(par3Random);
        this.field_82676_c = this.pickRandomCrop(par3Random);
    }

    /**
     * Returns a crop type to be planted on this field.
     */
    private int pickRandomCrop(Random par1Random)
    {
        switch (par1Random.nextInt(5))
        {
            case 0:
                return Block.carrot.blockID;
            case 1:
                return Block.potato.blockID;
            default:
                return Block.crops.blockID;
        }
    }
    
    private int pickRandomGrape(Random par1Random)
    {
        switch (par1Random.nextInt(3))
        {
            case 0:
                return Blocks.woodenTrellis.blockID;
            default:
                return Blocks.grapePlant.blockID;
        }
    }

    public static VillageFieldGrapes func_74902_a(ComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, 7, 4, 9, par6);
        return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(par1List, var8) == null ? new VillageFieldGrapes(par0ComponentVillageStartPiece, par7, par2Random, var8, par6) : null;
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at
     * the end, it adds Fences...
     */
    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
    {
        if (this.averageGroundLevel < 0)
        {
            this.averageGroundLevel = this.getAverageGroundLevel(par1World, par3StructureBoundingBox);

            if (this.averageGroundLevel < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 4 - 1, 0);
        }

        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 1, 0, 6, 4, 8, 0, 0, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 1, 2, 0, 7, Block.tilledField.blockID, Block.tilledField.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 4, 0, 1, 5, 0, 7, Block.tilledField.blockID, Block.tilledField.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 0, 0, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 0, 0, 6, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 0, 5, 0, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 8, 5, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 3, 0, 1, 3, 0, 7, Block.waterMoving.blockID, Block.waterMoving.blockID, false);
        int var4;

        for (var4 = 1; var4 <= 7; ++var4)
        {
        	int block1 = this.field_82675_b;
        	int block2 = this.getBlock(block1);
        	int block3 = this.field_82675_b;
        	int block4 = this.getBlock(block1);
            this.placeBlockAtCurrentPosition(par1World, Blocks.grapePlant.blockID, MathHelper.getRandomIntegerInRange(par2Random, 1, 2), 1, 1, var4, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, block1, this.getMetadata(block1, par2Random, 1), 1, 2, var4, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, block2, this.getMetadata(block2, par2Random, 0), 1, 3, var4, par3StructureBoundingBox);
            
            
            this.placeBlockAtCurrentPosition(par1World, Blocks.grapePlant.blockID, MathHelper.getRandomIntegerInRange(par2Random, 1, 2), 2, 1, var4, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, block3, this.getMetadata(block3, par2Random, 1), 2, 2, var4, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, block4, this.getMetadata(block4, par2Random, 0), 2, 3, var4, par3StructureBoundingBox);
            
            
            this.placeBlockAtCurrentPosition(par1World, this.field_82676_c, MathHelper.getRandomIntegerInRange(par2Random, 2, 7), 4, 1, var4, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, this.field_82676_c, MathHelper.getRandomIntegerInRange(par2Random, 2, 7), 5, 1, var4, par3StructureBoundingBox);
        }

        for (var4 = 0; var4 < 9; ++var4)
        {
            for (int var5 = 0; var5 < 7; ++var5)
            {
                this.clearCurrentPositionBlocksUpwards(par1World, var5, 4, var4, par3StructureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(par1World, Block.dirt.blockID, 0, var5, -1, var4, par3StructureBoundingBox);
            }
        }

        return true;
    }
    
    public int getMetadata(int block, Random par2Random, int range){
    	if(block == Blocks.woodenTrellis.blockID){
    		return 0;
    	}else {
    		return MathHelper.getRandomIntegerInRange(par2Random, range, 2);
    	}
    }
    
    public int getBlock(int block){
    	if(block == Blocks.woodenTrellis.blockID){
    		return Blocks.woodenTrellis.blockID;
    	}else {
    		return Blocks.grapePlant.blockID;
    	}
    }
}

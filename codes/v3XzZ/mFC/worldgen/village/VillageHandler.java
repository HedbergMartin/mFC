package v3XzZ.mFC.worldgen.village;

import java.util.List;
import java.util.Random;

import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureVillagePieceWeight;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

public class VillageHandler implements IVillageCreationHandler {

	@Override
	public StructureVillagePieceWeight getVillagePieceWeight(Random random, int i) {
		return (new StructureVillagePieceWeight(VillageFieldGrapes.class, 6, MathHelper.getRandomIntegerInRange(random, 0 + i, 1 + i)));
	}

	@Override
	public Class<?> getComponentClass() {
		return VillageFieldGrapes.class;
	}

	@Override
	public Object buildComponent(StructureVillagePieceWeight villagePiece, ComponentVillageStartPiece startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
		return VillageFieldGrapes.func_74902_a(startPiece, pieces, random, p1, p2, p3, p4, p5);
	}

}

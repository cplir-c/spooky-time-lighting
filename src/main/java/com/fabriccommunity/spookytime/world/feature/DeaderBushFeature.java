package com.fabriccommunity.spookytime.world.feature;

import com.fabriccommunity.spookytime.registry.SpookyBlocks;
import com.mojang.datafixers.Dynamic;
import java.util.Random;
import java.util.function.Function;
import net.minecraft.block.BlockState;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class DeaderBushFeature extends Feature<DefaultFeatureConfig> {
   public DeaderBushFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function_1) {
      super(function_1);
   }

	public boolean generate(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
		for(BlockState blockState_1 = world.getBlockState(pos); (blockState_1.isAir() || blockState_1.matches(BlockTags.LEAVES)) && pos.getY() > 0; blockState_1 = world.getBlockState(pos)) {
			pos = pos.down();
		}

		BlockState state2 = SpookyBlocks.DEADER_BUSH.getDefaultState();

		for(int int_1 = 0; int_1 < 4; ++int_1) {
			BlockPos pos2 = pos.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
			if (world.isAir(pos2) && state2.canPlaceAt(world, pos2)) {
				world.setBlockState(pos2, state2, 2);
			}
		}

		return true;
	}
}

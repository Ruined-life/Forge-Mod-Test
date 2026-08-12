package net.RuinedLife.modtest.helpers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BlockScanner {

    /**
     * Scans a cuboid area centered around a origin point for blocks matching a predicate.
     * * @param level   The world level instance.
     * @param center  The starting BlockPos.
     * @param radius  Distance to scan in X, Y, and Z directions.
     * @param filter  Condition to check each block state against (e.g. state -> state.is(Blocks.DIAMOND_ORE))
     * @return List of matching BlockPos coordinates.
     */
    public static List<BlockPos> scanArea(Level level, BlockPos center, int radius, Predicate<BlockState> filter) {
        List<BlockPos> foundPositions = new ArrayList<>();

        int minX = center.getX() - radius;
        int maxX = center.getX() + radius;
        int minY = center.getY() - radius;
        int maxY = center.getY() + radius;
        int minZ = center.getZ() - radius;
        int maxZ = center.getZ() + radius;

        // Mutable pos avoids allocating thousands of BlockPos objects during heavy loops
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    mutablePos.set(x, y, z);
                    BlockState state = level.getBlockState(mutablePos);

                    if (filter.test(state)) {
                        foundPositions.add(mutablePos.immutable());
                    }
                }
            }
        }

        return foundPositions;
    }

    /**
     * Scans straight down from a given X/Z position to find the highest non-air block.
     */
    public static BlockPos findHighestSolidBlock(Level level, int x, int startY, int z) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(x, startY, z);

        while (pos.getY() > level.getMinBuildHeight()) {
            if (!level.getBlockState(pos).isAir()) {
                return pos.immutable();
            }
            pos.move(0, -1, 0);
        }

        return pos.immutable();
    }
}
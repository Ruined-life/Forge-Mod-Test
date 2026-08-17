package net.RuinedLife.modtest.worldgen.portal;

import net.RuinedLife.modtest.block.custom.PortalBlock;
import net.RuinedLife.modtest.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class Teleporter implements ITeleporter {
    public final BlockPos thisPos;
    public final boolean insideDimension;

    public Teleporter(BlockPos pos, boolean insideDim) {
        this.thisPos = pos;
        this.insideDimension = insideDim;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destinationWorld,
                              float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        int y = 61;

        if (!insideDimension) {
            y = thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

        int tries = 0;
        while ((!destinationWorld.isEmptyBlock(destinationPos) || !destinationWorld.isEmptyBlock(destinationPos.above())) && tries < 25) {
            destinationPos = destinationPos.above(2);
            tries++;
        }

        entity.setPos(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());

        if (insideDimension) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(10).west(10),
                    destinationPos.above(10).east(10))) {
                if (destinationWorld.getBlockState(checkPos).getBlock() instanceof PortalBlock) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                destinationWorld.setBlock(destinationPos, BlockRegistry.PORTAL.get().defaultBlockState(), 3);
            }
        }

        return entity;
    }
}

package net.RuinedLife.modtest.item.custom;

import net.RuinedLife.modtest.registries.BlockRegistry;
import net.RuinedLife.modtest.registries.EntityRegistry;
import net.RuinedLife.modtest.helpers.BlockScanner;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;

import java.util.List;

public class ChestScanner extends Item {

    public ChestScanner(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        // Only run logic on the server side
        if (!pLevel.isClientSide()) {
            BlockPos playerPos = pPlayer.blockPosition();
            int radius = 5; // Scan 5 blocks around player

            // 1. Use BlockScanner helper to collect all chest positions in range
            List<BlockPos> chestPositions = BlockScanner.scanArea(
                    pLevel,
                    playerPos,
                    radius,
                    state -> state.getBlock() instanceof ChestBlock
            );

            // 2. Loop through only the positions where chests were actually found
            for (BlockPos chestPos : chestPositions) {
                Container container = ChestBlock.getContainer(
                        (ChestBlock) pLevel.getBlockState(chestPos).getBlock(),
                        pLevel.getBlockState(chestPos),
                        pLevel,
                        chestPos,
                        true
                );

                if (container != null) {
                    pPlayer.displayClientMessage(
                            Component.literal("Found Chest at: " + chestPos.toShortString()),
                            false
                    );

                    // 3. Inspect the contents of the container
                    for (int i = 0; i < container.getContainerSize(); i++) {
                        ItemStack stack = container.getItem(i);

                        if (stack.is(Items.AIR) || stack.isEmpty()) {
                            continue;
                        }

                        // Check for your special key item
                        if (stack.is(BlockRegistry.GREEN.get().asItem())) {
                            pPlayer.displayClientMessage(
                                    Component.literal("FOUND GREEN FLOWER! SPAWNING GREEN"),
                                    false
                            );

                            if (pLevel instanceof ServerLevel serverLevel) {
                                EntityRegistry.RHINO.get().spawn(
                                        serverLevel,
                                        playerPos,
                                        MobSpawnType.EVENT
                                );
                            }
                        }

                        // Print general item contents
                        pPlayer.displayClientMessage(
                                Component.literal("  - Slot " + i + ": " + stack.getHoverName().getString() + " x" + stack.getCount()),
                                false
                        );
                    }
                }
            }
        }

        return InteractionResultHolder.sidedSuccess(pPlayer.getItemInHand(pUsedHand), pLevel.isClientSide());
    }
}
package net.RuinedLife.modtest.item.custom;

import net.RuinedLife.modtest.block.ModBlocks;
import net.RuinedLife.modtest.entity.ModEntities;
import net.RuinedLife.modtest.entity.custom.RhinoEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// TODO:
//  1. Get the players position when right clicked
//  2. Loop through each block in a 16 block radius and print it out
//  3. Check if the current block is a chest.
//  4. If it IS a chest then loop through the contents of the chest and print each item
//  5. If a key item is in the chest then print a special message otherwise continue as normal.

public class ChestScanner extends Item {
    public ChestScanner(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide()){
            BlockPos playerPos = pPlayer.blockPosition();
            int radius = 5; // Scan 5 blocks around player

// Loop through nearby coordinates
            for (BlockPos checkPos : BlockPos.betweenClosed(
                    playerPos.offset(-radius, -radius, -radius),
                    playerPos.offset(radius, radius, radius))) {

                BlockState state = pLevel.getBlockState(checkPos);

                // Check if the current block in the loop is a chest
                if (state.getBlock() instanceof ChestBlock chestBlock) {

                    // HERE: checkPos IS your chestPos!
                    BlockPos chestPos = checkPos;

                    // Pass chestPos into the helper method
                    Container container = ChestBlock.getContainer(chestBlock, state, pLevel, chestPos, true);

                    if (container != null) {
                        for(int i = 0; i < container.getContainerSize(); i++){
                            ItemStack stack = container.getItem(i);

                            if(stack.is(Items.AIR)){
                                continue;
                            }

                            if (!stack.isEmpty() && stack.is(ModBlocks.GREEN.get().asItem())) {
                                // This item is a placeable block!
                                pPlayer.displayClientMessage(Component.literal("FOUND GREEN FLOWER! SPAWNING GREEN"), false);

                                if (pLevel instanceof ServerLevel serverLevel) {

                                    ModEntities.RHINO.get().spawn(
                                            serverLevel,
                                            playerPos,
                                            MobSpawnType.EVENT
                                    );

                                }
                            }


                            pPlayer.displayClientMessage(Component.literal("Chest contents: " + container.getItem(i)), false);
                        }
                    }
                }
            }
        }
        return InteractionResultHolder.consume(pPlayer.getMainHandItem());
    }
}

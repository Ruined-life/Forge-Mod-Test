package net.RuinedLife.modtest.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class AOEPickaxeItem extends PickaxeItem {

    // Prevent infinite recursion loops when breaking extra blocks
    private static boolean isMiningAOE = false;

    public AOEPickaxeItem(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, Player player) {
        Level level = player.level();

        // 1. Ensure we run ONLY on the server side and avoid infinite loops
        if (!level.isClientSide() && !isMiningAOE && player instanceof ServerPlayer serverPlayer) {
            isMiningAOE = true; // Lock extra triggers

            // 2. Loop through adjacent blocks (e.g., a 2x2 area around the center block)
            for (int x = 0; x <= 1; x++) {
                for (int y = 0; y <= 1; y++) {
                    // Skip the origin block because Minecraft handles breaking it naturally
                    if (x == 0 && y == 0) continue;

                    BlockPos targetPos = pos.offset(x, y, 0);
                    BlockState targetState = level.getBlockState(targetPos);

                    // 3. Check conditions: Can our pickaxe mine this block?
                    if (this.isCorrectToolForDrops(stack, targetState) && targetState.getDestroySpeed(level, targetPos) >= 0) {
                        // 4. Break the target block, drop items, and deal durability damage
                        serverPlayer.gameMode.destroyBlock(targetPos);
                    }
                }
            }

            isMiningAOE = false; // Unlock for the next player mining action
        }

        // Return false to let Minecraft break the target block as normal
        return false;
    }
}
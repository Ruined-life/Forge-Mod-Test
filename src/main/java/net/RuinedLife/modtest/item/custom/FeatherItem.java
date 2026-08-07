package net.RuinedLife.modtest.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FeatherItem extends Item{

    public FeatherItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        // Step 1: Server check
        if (!level.isClientSide()) {

            // Step 2: Check if player is sneaking
            if (player.isCrouching()) {

                // Step 3: Teleport 10 blocks up (using your method!)
                player.teleportRelative(0, 10, 0);

                // Step 4: Consume 1 feather
                player.getItemInHand(hand).shrink(1);

                // Step 5: Add 5-second cooldown (100 ticks = 5 seconds)
                player.getCooldowns().addCooldown(this, 100);

                // Success response for the server
                return InteractionResultHolder.consume(player.getItemInHand(hand));
            }
        }

        // Pass response if not sneaking or on client
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}

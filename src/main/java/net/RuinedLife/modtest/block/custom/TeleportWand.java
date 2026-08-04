package net.RuinedLife.modtest.block.custom;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class TeleportWand extends Item {
    public TeleportWand(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        // Step 1: Server check
        if (!level.isClientSide()) {
            Vec3 vector = player.getLookAngle();
            double distance = 5.0;

            double targetX = player.getX() + vector.x * distance;
            double targetY = player.getY() + vector.y * distance;
            double targetZ = player.getZ() + vector.z * distance;


            // Step 3: Teleport 10 blocks up (using your method!)
            player.teleportTo(targetX, targetY, targetZ);

            //player.displayClientMessage(Component.literal("Look X: " + x), false);
            player.displayClientMessage(Component.literal("Used Item!"), true);

            // Step 4: Consume 1 feather
            player.getItemInHand(hand).shrink(1);

            // Step 5: Add 5-second cooldown (100 ticks = 5 seconds)
            player.getCooldowns().addCooldown(this, 0);

            // Success response for the server
            return InteractionResultHolder.consume(player.getItemInHand(hand));

        }

        // Pass response if not sneaking or on client
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}
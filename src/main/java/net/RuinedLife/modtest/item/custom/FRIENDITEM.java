package net.RuinedLife.modtest.item.custom;

import net.RuinedLife.modtest.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FRIENDITEM extends Item {

    public FRIENDITEM(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.modtest.friend_item.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        // Only trigger on the server side to prevent showing double messages
        if (!level.isClientSide()) {
            // The 'true' at the end tells Minecraft to display this text above the hotbar (Action Bar)
            player.displayClientMessage(Component.literal("A friend, friend inside me!"), true);

            // Play the sound at the player's position
            level.playSound(
                    null,                           // Player to exclude (null = everyone nearby hears it)
                    player.getX(),                  // X position
                    player.getY(),                  // Y position
                    player.getZ(),                  // Z position
                    ModSounds.FRIEND_ACTIVATED.get(), // The sound event
                    SoundSource.PLAYERS,           // Sound category (Players, Blocks, Ambient, etc.)
                    1.0F,                           // Volume (1.0 = normal volume)
                    1.0F                            // Pitch (1.0 = normal pitch)
            );


        }

        // Return SUCCESS so the player plays the hand-swing animation
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }
}

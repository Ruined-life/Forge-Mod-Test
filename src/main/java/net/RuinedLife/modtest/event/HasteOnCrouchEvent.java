package net.RuinedLife.modtest.event;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "modtest", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HasteOnCrouchEvent {

    //Setup event listener
    @SubscribeEvent
    public static void onCrouch(TickEvent.PlayerTickEvent event){
        Level level = event.player.level();
        Player player = event.player;

        if(!level.isClientSide()){
            if(event.player.isCrouching()){
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1, 1, false, false));
            }
        }

    }

    //Check if we are on the server


    //Check if player is crouching
        //Apply haste effect
    //otherwise remove haste effect


}

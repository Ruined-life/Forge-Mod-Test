package net.RuinedLife.modtest.registries;

import net.RuinedLife.modtest.modtest;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundsRegistry {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, modtest.MOD_ID);
    /*---------------------------------------------------------------------------------------------------------------------------*/
    //ITEM SOUNDS
    public static final RegistryObject<SoundEvent> FRIEND_ACTIVATED = registerSoundEvents("sound_friend_activated");

    //PINK BLOCK SOUNDS
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_BREAK = registerSoundEvents("sound_block_break");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_STEP = registerSoundEvents("sound_block_step");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_FALL = registerSoundEvents("sound_block_fall");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_PLACE = registerSoundEvents("sound_block_place");
    public static final RegistryObject<SoundEvent> SOUND_BLOCK_HIT = registerSoundEvents("sound_block_hit");

    //MUSIC
    public static final RegistryObject<SoundEvent> TEMPORARY = registerSoundEvents("temporary");
    public static final RegistryObject<SoundEvent> BLACK_KNIFE = registerSoundEvents("black_knife");

    //MOB SOUNDS
    public static final RegistryObject<SoundEvent> AQUA_AMBIENT = SOUND_EVENTS.register("aqua_ambient", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(modtest.MOD_ID, "aqua_ambient")));
    public static final RegistryObject<SoundEvent> AQUA_DEATH = SOUND_EVENTS.register("aqua_death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(modtest.MOD_ID, "aqua_death")));
    public static final RegistryObject<SoundEvent> GOKU_ANGRY = registerSoundEvents("goku_angry");

    /*---------------------------------------------------------------------------------------------------------------------------*/
    /*METHODS*/
    public static final ForgeSoundType SOUND_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            SoundsRegistry.SOUND_BLOCK_BREAK, SoundsRegistry.SOUND_BLOCK_STEP, SoundsRegistry.SOUND_BLOCK_PLACE,
            SoundsRegistry.SOUND_BLOCK_HIT, SoundsRegistry.SOUND_BLOCK_FALL);

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(modtest.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}

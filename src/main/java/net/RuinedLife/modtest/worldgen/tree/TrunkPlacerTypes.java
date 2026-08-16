package net.RuinedLife.modtest.worldgen.tree;

import net.RuinedLife.modtest.modtest;
import net.RuinedLife.modtest.worldgen.tree.custom.ScarletTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, modtest.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<ScarletTrunkPlacer>> SCARLET_TRUNK_PLACER =
            TRUNK_PLACER.register("scarlet_trunk_placer", () -> new TrunkPlacerType<>(ScarletTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}

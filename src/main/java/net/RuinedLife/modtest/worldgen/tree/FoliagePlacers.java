package net.RuinedLife.modtest.worldgen.tree;

import net.RuinedLife.modtest.modtest;
import net.RuinedLife.modtest.worldgen.tree.custom.ScarletFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class FoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, modtest.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<ScarletFoliagePlacer>> SCARLET_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("scarlet_foliage_placer", () -> new FoliagePlacerType<>(ScarletFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}

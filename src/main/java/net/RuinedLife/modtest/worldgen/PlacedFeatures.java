package net.RuinedLife.modtest.worldgen;

import net.RuinedLife.modtest.modtest;
import net.RuinedLife.modtest.registries.BlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class PlacedFeatures {
    public static final ResourceKey<PlacedFeature> NEW_ZEAL_LAND_ORE_PLACED_KEY = registerKey("new_zeal_land_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_NEW_ZEAL_LAND_ORE_PLACED_KEY = registerKey("nether_new_zeal_land_ore_placed");
    public static final ResourceKey<PlacedFeature> END_NEW_ZEAL_LAND_ORE_PLACED_KEY = registerKey("end_new_zeal_land_ore_placed");

    public static final ResourceKey<PlacedFeature> SCARLET_TREE_PLACED_KEY = registerKey("scarlet_tree_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NEW_ZEAL_LAND_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_NEW_ZEAL_LAND_ORE_KEY),
                OrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_NEW_ZEAL_LAND_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.NETHER_NEW_ZEAL_LAND_ORE_KEY),
                OrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_NEW_ZEAL_LAND_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.END_NEW_ZEAL_LAND_ORE_KEY),
                OrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, SCARLET_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.SCARLET_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1),
                        BlockRegistry.SCARLET_SAPLING.get()));

    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(modtest.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

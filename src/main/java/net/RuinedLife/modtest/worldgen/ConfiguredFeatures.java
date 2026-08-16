package net.RuinedLife.modtest.worldgen;

import net.RuinedLife.modtest.modtest;
import net.RuinedLife.modtest.registries.BlockRegistry;
import net.RuinedLife.modtest.worldgen.tree.custom.ScarletTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_NEW_ZEAL_LAND_ORE_KEY = registerKey("new_zeal_land_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_NEW_ZEAL_LAND_ORE_KEY = registerKey("nether_new_zeal_land_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_NEW_ZEAL_LAND_ORE_KEY = registerKey("end_new_zeal_land_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SCARLET_KEY = registerKey("scarlet");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldNewZealandOres = List.of(OreConfiguration.target(stoneReplaceable,
                        BlockRegistry.NEW_ZEALAND_BLOCK.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockRegistry.NEW_ZEALAND_BLOCK.get().defaultBlockState()));

        register(context, OVERWORLD_NEW_ZEAL_LAND_ORE_KEY, Feature.ORE, new OreConfiguration(overworldNewZealandOres, 9));
        register(context, NETHER_NEW_ZEAL_LAND_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                BlockRegistry.NEW_ZEALAND_BLOCK.get().defaultBlockState(), 9));
        register(context, END_NEW_ZEAL_LAND_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                BlockRegistry.NEW_ZEALAND_BLOCK.get().defaultBlockState(), 9));

        register(context, SCARLET_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockRegistry.SCARLET_LOG.get()),
                new ScarletTrunkPlacer(5, 4, 3),

                BlockStateProvider.simple(BlockRegistry.SCARLET_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(modtest.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

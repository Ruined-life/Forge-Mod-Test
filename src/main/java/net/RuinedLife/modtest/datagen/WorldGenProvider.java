package net.RuinedLife.modtest.datagen;

import net.RuinedLife.modtest.modtest;
import net.RuinedLife.modtest.worldgen.BiomeModifiers;
import net.RuinedLife.modtest.worldgen.ConfiguredFeatures;
import net.RuinedLife.modtest.worldgen.PlacedFeatures;
import net.RuinedLife.modtest.worldgen.biome.CustomBiomes;
import net.RuinedLife.modtest.worldgen.dimension.Dimensions;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class WorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, Dimensions::bootstrapType)
            .add(Registries.CONFIGURED_FEATURE, ConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, PlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifiers::bootstrap)
            .add(Registries.BIOME, CustomBiomes::boostrap)
            .add(Registries.LEVEL_STEM, Dimensions::bootstrapStem);



    public WorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(modtest.MOD_ID));
    }
}
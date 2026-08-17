package net.RuinedLife.modtest.worldgen.biome;

import net.RuinedLife.modtest.modtest;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class TerraBlender {
    public static void registerBiomes() {
        Regions.register(new OverworldRegion(new ResourceLocation(modtest.MOD_ID, "overworld"), 5));
    }
}

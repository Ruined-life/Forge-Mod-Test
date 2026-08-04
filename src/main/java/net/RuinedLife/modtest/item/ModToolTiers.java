package net.RuinedLife.modtest.item;

import net.RuinedLife.modtest.modtest;
import net.RuinedLife.modtest.tags.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {

    public static final Tier PINK = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 10f, 4f, 25,
                    ModTags.Blocks.NEEDS_PINK_TOOL, () -> Ingredient.of(ModItems.pure_crystal.get())),
            new ResourceLocation(modtest.MOD_ID, "pink"), List.of(Tiers.NETHERITE), List.of());

}

package net.RuinedLife.modtest.datagen;

import net.RuinedLife.modtest.registries.ItemsRegistry;
import net.RuinedLife.modtest.loot.AddItemModifier;
import net.RuinedLife.modtest.modtest;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class GlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public GlobalLootModifiersProvider(PackOutput output) {
        super(output, modtest.MOD_ID);
    }

    @Override
    protected void start() {
        add("kiwi_fruit_from_grass", new AddItemModifier(new LootItemCondition[] {LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(), LootItemRandomChanceCondition.randomChance(0.35f).build()}, ItemsRegistry.kiwi_fruit.get()));
        add("temporary_from_creeper", new AddItemModifier(new LootItemCondition[] {new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build()}, ItemsRegistry.TEMPORARY_MUSIC_DISC.get()));
        add("temporary_from_village_chests", new AddItemModifier(new LootItemCondition[] {new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build()}, ItemsRegistry.TEMPORARY_MUSIC_DISC.get()));

    }
}

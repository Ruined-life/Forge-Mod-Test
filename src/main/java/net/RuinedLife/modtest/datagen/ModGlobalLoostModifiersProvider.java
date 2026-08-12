package net.RuinedLife.modtest.datagen;

import net.RuinedLife.modtest.registries.ModItems;
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

public class ModGlobalLoostModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLoostModifiersProvider(PackOutput output) {
        super(output, modtest.MOD_ID);
    }

    @Override
    protected void start() {
        add("kiwi_fruit_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.kiwi_fruit.get()));

        add("erika_from_creeper", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build()}, ModItems.ERIKA_MUSIC_DISC.get()));

        add("erika_from_village_chests", new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build()}, ModItems.ERIKA_MUSIC_DISC.get()));

    }
}

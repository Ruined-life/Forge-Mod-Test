package net.RuinedLife.modtest.datagen.loot;

import net.RuinedLife.modtest.registries.ModBlocks;
import net.RuinedLife.modtest.block.custom.KiwiFruitCropBlock;
import net.RuinedLife.modtest.registries.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collections;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(Set<Item> requiredItems, FeatureFlagSet enabledFeatures) {
        super(requiredItems, enabledFeatures);
    }

    // OR if you want a default fallback constructor:
    public ModBlockLootTables() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.DARKNESS_BLOCK.get());
        this.dropSelf(ModBlocks.PINK_BLOCK.get());
        this.dropSelf(ModBlocks.NAZI_BLOCK.get());
        this.dropSelf(ModBlocks.NEW_ZEALAND_BLOCK.get());
        this.dropSelf(ModBlocks.DUST_BLOCK.get());

        this.dropSelf(ModBlocks.SCARLET_LOG.get());
        //this.dropSelf(ModBlocks.SCARLET_WOOD.get());
        //this.dropSelf(ModBlocks.STRIPPED_SCARLET_LOG.get());
        //this.dropSelf(ModBlocks.STRIPPED_SCARLET_WOOD.get());
        this.dropSelf(ModBlocks.SCARLET_PLANKS.get());

        this.add(ModBlocks.SCARLET_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.NEW_ZEALAND_BLOCK.get(), NORMAL_LEAVES_SAPLING_CHANCES)); //TODO: Change to sapling


        //STAIRS, FENCES, FENCE GATES, SLABS, DOORS, TRAP DOORS
        this.dropSelf(ModBlocks.DARKNESS_STAIRS.get());
        this.dropSelf(ModBlocks.DARKNESS_BUTTON.get());
        this.dropSelf(ModBlocks.DARKNESS_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DARKNESS_TRAP_DOOR.get());
        this.dropSelf(ModBlocks.DARKNESS_FENCE.get());
        this.dropSelf(ModBlocks.DARKNESS_FENCE_GATE.get());
        this.dropSelf(ModBlocks.DARKNESS_WALL.get());

        //FLOWERS
        this.dropSelf(ModBlocks.AQUA.get());
        this.add(ModBlocks.POTTED_AQUA.get(), createPotFlowerItemTable(ModBlocks.AQUA.get()));

        this.dropSelf(ModBlocks.PURPLE.get());
        this.add(ModBlocks.POTTED_PURPLE.get(), createPotFlowerItemTable(ModBlocks.PURPLE.get()));

        this.dropSelf(ModBlocks.GREEN.get());
        this.add(ModBlocks.POTTED_GREEN.get(), createPotFlowerItemTable(ModBlocks.GREEN.get()));

        this.dropSelf(ModBlocks.GOLD.get());
        this.add(ModBlocks.POTTED_GOLD.get(), createPotFlowerItemTable(ModBlocks.GOLD.get()));

        this.dropSelf(ModBlocks.YELLOW.get());
        this.add(ModBlocks.POTTED_YELLOW.get(), createPotFlowerItemTable(ModBlocks.YELLOW.get()));

        this.dropSelf(ModBlocks.ORANGE.get());
        this.add(ModBlocks.POTTED_ORANGE.get(), createPotFlowerItemTable(ModBlocks.ORANGE.get()));

        this.dropSelf(ModBlocks.BLUE.get());
        this.add(ModBlocks.POTTED_BLUE.get(), createPotFlowerItemTable(ModBlocks.BLUE.get()));

        this.dropSelf(ModBlocks.PINK.get());
        this.add(ModBlocks.POTTED_PINK.get(), createPotFlowerItemTable(ModBlocks.PINK.get()));

        this.add(ModBlocks.DARKNESS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DARKNESS_SLAB.get()));
        this.add(ModBlocks.DARKNESS_DOOR.get(),
                block -> createDoorTable(ModBlocks.DARKNESS_DOOR.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.KIWI_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(KiwiFruitCropBlock.AGE, 3));
        this.add(ModBlocks.KIWI_CROP.get(), createCropDrops(ModBlocks.KIWI_CROP.get(), ModItems.kiwi_fruit.get(),
                ModItems.kiwi_seeds.get(), lootitemcondition$builder));

        //THIS PART IS FOR ORES
        //this.add(ModBlocks.SAPHHIRE_ORE.get(),
        // block -> createCopperLikeOreDrops(ModBlocks.SAPHHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item){
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 5.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

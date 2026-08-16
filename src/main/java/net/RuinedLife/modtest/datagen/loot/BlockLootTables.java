package net.RuinedLife.modtest.datagen.loot;

import net.RuinedLife.modtest.registries.BlockRegistry;
import net.RuinedLife.modtest.block.custom.KiwiFruitCropBlock;
import net.RuinedLife.modtest.registries.ItemsRegistry;
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

public class BlockLootTables extends BlockLootSubProvider {
    public BlockLootTables(Set<Item> requiredItems, FeatureFlagSet enabledFeatures) {
        super(requiredItems, enabledFeatures);
    }

    // OR if you want a default fallback constructor:
    public BlockLootTables() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }
    /*---------------------------------------------------------------------------------------------------------------------------*/
    @Override
    protected void generate() {
        this.dropSelf(BlockRegistry.DARKNESS_BLOCK.get());
        this.dropSelf(BlockRegistry.PINK_BLOCK.get());
        this.dropSelf(BlockRegistry.NEW_ZEALAND_BLOCK.get());
        this.dropSelf(BlockRegistry.DUST_BLOCK.get());
        this.dropSelf(BlockRegistry.GEM_POLISHING_STATION.get());

        this.dropSelf(BlockRegistry.SCARLET_LOG.get());
        //this.dropSelf(ModBlocks.SCARLET_WOOD.get());
        //this.dropSelf(ModBlocks.STRIPPED_SCARLET_LOG.get());
        //this.dropSelf(ModBlocks.STRIPPED_SCARLET_WOOD.get());
        this.dropSelf(BlockRegistry.SCARLET_PLANKS.get());
        this.dropSelf(BlockRegistry.SCARLET_SAPLING.get());

        this.add(BlockRegistry.SCARLET_LEAVES.get(), block ->
                createLeavesDrops(block, BlockRegistry.SCARLET_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        //STAIRS, FENCES, FENCE GATES, SLABS, DOORS, TRAP DOORS
        this.dropSelf(BlockRegistry.DARKNESS_STAIRS.get());
        this.dropSelf(BlockRegistry.DARKNESS_BUTTON.get());
        this.dropSelf(BlockRegistry.DARKNESS_PRESSURE_PLATE.get());
        this.dropSelf(BlockRegistry.DARKNESS_TRAP_DOOR.get());
        this.dropSelf(BlockRegistry.DARKNESS_FENCE.get());
        this.dropSelf(BlockRegistry.DARKNESS_FENCE_GATE.get());
        this.dropSelf(BlockRegistry.DARKNESS_WALL.get());

        //FLOWERS
        this.dropSelf(BlockRegistry.AQUA.get());
        this.add(BlockRegistry.POTTED_AQUA.get(), createPotFlowerItemTable(BlockRegistry.AQUA.get()));

        this.dropSelf(BlockRegistry.PURPLE.get());
        this.add(BlockRegistry.POTTED_PURPLE.get(), createPotFlowerItemTable(BlockRegistry.PURPLE.get()));

        this.dropSelf(BlockRegistry.GREEN.get());
        this.add(BlockRegistry.POTTED_GREEN.get(), createPotFlowerItemTable(BlockRegistry.GREEN.get()));

        this.dropSelf(BlockRegistry.GOLD.get());
        this.add(BlockRegistry.POTTED_GOLD.get(), createPotFlowerItemTable(BlockRegistry.GOLD.get()));

        this.dropSelf(BlockRegistry.YELLOW.get());
        this.add(BlockRegistry.POTTED_YELLOW.get(), createPotFlowerItemTable(BlockRegistry.YELLOW.get()));

        this.dropSelf(BlockRegistry.ORANGE.get());
        this.add(BlockRegistry.POTTED_ORANGE.get(), createPotFlowerItemTable(BlockRegistry.ORANGE.get()));

        this.dropSelf(BlockRegistry.BLUE.get());
        this.add(BlockRegistry.POTTED_BLUE.get(), createPotFlowerItemTable(BlockRegistry.BLUE.get()));

        this.dropSelf(BlockRegistry.PINK.get());
        this.add(BlockRegistry.POTTED_PINK.get(), createPotFlowerItemTable(BlockRegistry.PINK.get()));

        this.add(BlockRegistry.DARKNESS_SLAB.get(),
                block -> createSlabItemTable(BlockRegistry.DARKNESS_SLAB.get()));
        this.add(BlockRegistry.DARKNESS_DOOR.get(),
                block -> createDoorTable(BlockRegistry.DARKNESS_DOOR.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(BlockRegistry.KIWI_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(KiwiFruitCropBlock.AGE, 3));
        this.add(BlockRegistry.KIWI_CROP.get(), createCropDrops(BlockRegistry.KIWI_CROP.get(), ItemsRegistry.kiwi_fruit.get(),
                ItemsRegistry.kiwi_seeds.get(), lootitemcondition$builder));

        //THIS PART IS FOR ORES
        //this.add(ModBlocks.SAPHHIRE_ORE.get(),
        // block -> createCopperLikeOreDrops(ModBlocks.SAPHHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
    }
    /*---------------------------------------------------------------------------------------------------------------------------*/
    /*METHODS*/
    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item){
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 5.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

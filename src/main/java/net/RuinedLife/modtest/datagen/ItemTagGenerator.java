package net.RuinedLife.modtest.datagen;

import net.RuinedLife.modtest.registries.BlockRegistry;
import net.RuinedLife.modtest.registries.ItemsRegistry;
import net.RuinedLife.modtest.modtest;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends ItemTagsProvider {
    public ItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, modtest.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.MUSIC_DISCS)
                .add(ItemsRegistry.TEMPORARY_MUSIC_DISC.get())
                .add(ItemsRegistry.BLACK_KNIFE_MUSIC_DISC.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(BlockRegistry.SCARLET_LOG.get().asItem());
                //.add(ModBlocks.SCARLET_WOOD.get().asItem());
                //.add(ModBlocks.STRIPPED_SCARLET_LOG.get().asItem())
                //.add(ModBlocks.STRIPPED_SCARLET_WOOD.get().asItem());


        this.tag(ItemTags.PLANKS)
                .add(BlockRegistry.SCARLET_PLANKS.get().asItem());


    }
}

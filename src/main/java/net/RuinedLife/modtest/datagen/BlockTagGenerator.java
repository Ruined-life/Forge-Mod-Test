package net.RuinedLife.modtest.datagen;

import net.RuinedLife.modtest.registries.BlockRegistry;
import net.RuinedLife.modtest.modtest;
import net.RuinedLife.modtest.registries.TagsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends BlockTagsProvider {

    public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modtest.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //e.x as I dont have any tags atm
        //this.tag(ModTags.Blocks.METAL_DECETOR_VALUABLES)
                //.add(ModBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);

        //So were adding what blocks need an iron tool here instead of manually
        //writing it in a json file
        //WHAT TIER IT NEEDS TO BREAK
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(BlockRegistry.DARKNESS_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(BlockRegistry.DARKNESS_BLOCK.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(BlockRegistry.DARKNESS_BLOCK.get());
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(BlockRegistry.DARKNESS_BLOCK.get());
        this.tag(TagsRegistry.Blocks.NEEDS_PINK_TOOL).add(BlockRegistry.DARKNESS_BLOCK.get());

        //TOOLS
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(BlockRegistry.DARKNESS_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(BlockRegistry.DARKNESS_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BlockRegistry.DARKNESS_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(BlockRegistry.DARKNESS_BLOCK.get());

        //STAIRS, FENCES, DOORS, TRAP DOORS, FENCE GATES, SLABS
        //MAKE SURE TO ADD THE TAGS FOR FENCES, FENCE GATES AND WALLS OTHERWISE THEY WONT CONNECT
        this.tag(BlockTags.FENCES).add(BlockRegistry.DARKNESS_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(BlockRegistry.DARKNESS_FENCE_GATE.get());
        this.tag(BlockTags.WALLS).add(BlockRegistry.DARKNESS_WALL.get());
        this.tag(BlockTags.LOGS_THAT_BURN).add(BlockRegistry.SCARLET_LOG.get());
                //.add(ModBlocks.SCARLET_WOOD.get());
                //.add(ModBlocks.STRIPPED_SCARLET_LOG.get())
                //.add(ModBlocks.STRIPPED_SCARLET_WOOD.get());
        this.tag(BlockTags.PLANKS).add(BlockRegistry.SCARLET_PLANKS.get());

    }
}

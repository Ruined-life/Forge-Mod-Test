package net.RuinedLife.modtest.datagen;

import net.RuinedLife.modtest.registries.BlockRegistry;
import net.RuinedLife.modtest.block.custom.KiwiFruitCropBlock;
import net.RuinedLife.modtest.modtest;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class BlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {
    public BlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, modtest.MOD_ID, exFileHelper);
    }
    /*---------------------------------------------------------------------------------------------------------------------------*/
    @Override
    protected void registerStatesAndModels() {
        //PUT ALL YOUR BLOCKS HERE
        //e.x blockWithItem(ModBlocks.BLOCK);
        blockWithItem(BlockRegistry.DARKNESS_BLOCK);
        blockWithItem(BlockRegistry.PINK_BLOCK);
        blockWithItem(BlockRegistry.NEW_ZEALAND_BLOCK);
        blockWithItem(BlockRegistry.DUST_BLOCK);

        stairsBlock(((StairBlock) BlockRegistry.DARKNESS_STAIRS.get()), blockTexture(BlockRegistry.DARKNESS_BLOCK.get()));
        slabBlock(((SlabBlock) BlockRegistry.DARKNESS_SLAB.get()), blockTexture(BlockRegistry.DARKNESS_BLOCK.get()), blockTexture(BlockRegistry.DARKNESS_BLOCK.get()));

        buttonBlock(((ButtonBlock) BlockRegistry.DARKNESS_BUTTON.get()), blockTexture(BlockRegistry.DARKNESS_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) BlockRegistry.DARKNESS_PRESSURE_PLATE.get()), blockTexture(BlockRegistry.DARKNESS_BLOCK.get()));

        fenceBlock(((FenceBlock) BlockRegistry.DARKNESS_FENCE.get()), blockTexture(BlockRegistry.DARKNESS_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) BlockRegistry.DARKNESS_FENCE_GATE.get()), blockTexture(BlockRegistry.DARKNESS_BLOCK.get()));
        wallBlock(((WallBlock) BlockRegistry.DARKNESS_WALL.get()), blockTexture(BlockRegistry.DARKNESS_BLOCK.get()));

        simpleBlockWithItem(BlockRegistry.GEM_POLISHING_STATION.get(), new ModelFile.UncheckedModelFile(modLoc("block/gem_polishing_station")));

        doorBlockWithRenderType((DoorBlock) BlockRegistry.DARKNESS_DOOR.get(), modLoc("block/darkness_door_bottom"), modLoc("block/darkness_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) BlockRegistry.DARKNESS_TRAP_DOOR.get()), modLoc("block/darkness_trap_door"), true, "cutout");

        makeKiwiCrop((CropBlock) BlockRegistry.KIWI_CROP.get(), "kiwi_stage", "kiwi_stage_");

        //AQUA
        simpleBlockWithItem(BlockRegistry.AQUA.get(), models().cross(blockTexture(BlockRegistry.AQUA.get()).getPath(), blockTexture(BlockRegistry.AQUA.get())).renderType("cutout"));
        simpleBlockWithItem(BlockRegistry.POTTED_AQUA.get(), models().singleTexture("potted_aqua", new ResourceLocation("flower_pot_cross"), "plant", blockTexture(BlockRegistry.AQUA.get())).renderType("cutout"));

        //GREEN
        simpleBlockWithItem(BlockRegistry.GREEN.get(), models().cross(blockTexture(BlockRegistry.GREEN.get()).getPath(), blockTexture(BlockRegistry.GREEN.get())).renderType("cutout"));
        simpleBlockWithItem(BlockRegistry.POTTED_GREEN.get(), models().singleTexture("potted_green", new ResourceLocation("flower_pot_cross"), "plant", blockTexture(BlockRegistry.GREEN.get())).renderType("cutout"));

        //PURPLE
        simpleBlockWithItem(BlockRegistry.PURPLE.get(), models().cross(blockTexture(BlockRegistry.PURPLE.get()).getPath(), blockTexture(BlockRegistry.PURPLE.get())).renderType("cutout"));
        simpleBlockWithItem(BlockRegistry.POTTED_PURPLE.get(), models().singleTexture("potted_purple", new ResourceLocation("flower_pot_cross"), "plant", blockTexture(BlockRegistry.PURPLE.get())).renderType("cutout"));

        //GOLD
        simpleBlockWithItem(BlockRegistry.GOLD.get(), models().cross(blockTexture(BlockRegistry.GOLD.get()).getPath(), blockTexture(BlockRegistry.GOLD.get())).renderType("cutout"));
        simpleBlockWithItem(BlockRegistry.POTTED_GOLD.get(), models().singleTexture("potted_gold", new ResourceLocation("flower_pot_cross"), "plant", blockTexture(BlockRegistry.GOLD.get())).renderType("cutout"));

        //YELLOW
        simpleBlockWithItem(BlockRegistry.YELLOW.get(), models().cross(blockTexture(BlockRegistry.YELLOW.get()).getPath(), blockTexture(BlockRegistry.YELLOW.get())).renderType("cutout"));
        simpleBlockWithItem(BlockRegistry.POTTED_YELLOW.get(), models().singleTexture("potted_yellow", new ResourceLocation("flower_pot_cross"), "plant", blockTexture(BlockRegistry.YELLOW.get())).renderType("cutout"));

        //ORANGE
        simpleBlockWithItem(BlockRegistry.ORANGE.get(), models().cross(blockTexture(BlockRegistry.ORANGE.get()).getPath(), blockTexture(BlockRegistry.ORANGE.get())).renderType("cutout"));
        simpleBlockWithItem(BlockRegistry.POTTED_ORANGE.get(), models().singleTexture("potted_orange", new ResourceLocation("flower_pot_cross"), "plant", blockTexture(BlockRegistry.ORANGE.get())).renderType("cutout"));

        //BLUE
        simpleBlockWithItem(BlockRegistry.BLUE.get(), models().cross(blockTexture(BlockRegistry.BLUE.get()).getPath(), blockTexture(BlockRegistry.BLUE.get())).renderType("cutout"));
        simpleBlockWithItem(BlockRegistry.POTTED_BLUE.get(), models().singleTexture("potted_blue", new ResourceLocation("flower_pot_cross"), "plant", blockTexture(BlockRegistry.BLUE.get())).renderType("cutout"));

        //PINK
        simpleBlockWithItem(BlockRegistry.PINK.get(), models().cross(blockTexture(BlockRegistry.PINK.get()).getPath(), blockTexture(BlockRegistry.PINK.get())).renderType("cutout"));
        simpleBlockWithItem(BlockRegistry.POTTED_PINK.get(), models().singleTexture("potted_pink", new ResourceLocation("flower_pot_cross"), "plant", blockTexture(BlockRegistry.PINK.get())).renderType("cutout"));


        multiLayerLogBlock((RotatedPillarBlock) BlockRegistry.SCARLET_LOG.get(), modLoc("block/scarlet_log_inner"), modLoc("block/scarlet_log_inner_top"), modLoc("block/scarlet_log_outer"), modLoc("block/scarlet_log_outer_top"));
        blockWithItem(BlockRegistry.SCARLET_PLANKS);
        multiLayerLeavesBlock(BlockRegistry.SCARLET_LEAVES, modLoc("block/scarlet_leaves_inner"), modLoc("block/scarlet_leaves_outer"));
        saplingBlock(BlockRegistry.SCARLET_SAPLING);

        blockWithItem(BlockRegistry.PORTAL);

        //axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SCARLET_LOG.get()), blockTexture(ModBlocks.STRIPPED_SCARLET_LOG.get()),
                //new ResourceLocation(modtest.MOD_ID, "block/new_zealand_block"));
        //axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SCARLET_WOOD.get()),
                //blockTexture(ModBlocks.STRIPPED_SCARLET_LOG.get()));

        //blockItem(ModBlocks.SCARLET_LOG);
        //blockItem(ModBlocks.SCARLET_WOOD);
        //blockItem(ModBlocks.STRIPPED_SCARLET_LOG);
        //blockItem(ModBlocks.STRIPPED_SCARLET_WOOD);


    }
    /*---------------------------------------------------------------------------------------------------------------------------*/
    /*METHODS*/
    private void multiLayerLeavesBlock(RegistryObject<Block> block, ResourceLocation innerTexture, ResourceLocation outerTexture) {
        String blockName = ForgeRegistries.BLOCKS.getKey(block.get()).getPath();

        // Creates a custom model combining two texture layers
        ModelFile model = models().withExistingParent(blockName, "block/block")
                .texture("particle", outerTexture)
                .texture("inner", innerTexture)
                .texture("outer", outerTexture)
                .element()
                .from(0, 0, 0).to(16, 16, 16)
                .allFaces((dir, builder) -> builder.texture("#inner").cullface(dir))
                .end()
                .element()
                .from(0, 0, 0).to(16, 16, 16)
                .allFaces((dir, builder) -> builder.texture("#outer").cullface(dir))
                .end()
                .renderType("cutout");

        simpleBlockWithItem(block.get(), model);
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(
                        ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())
                ).renderType("cutout")
        );
    }

    private void multiLayerLogBlock(RotatedPillarBlock block,
                                    ResourceLocation innerSide, ResourceLocation innerTop,
                                    ResourceLocation outerSide, ResourceLocation outerTop) {
        String blockName = ForgeRegistries.BLOCKS.getKey(block).getPath();

        // 1. Build the multi-layered block model
        ModelFile model = models().withExistingParent(blockName, "block/block")
                .texture("particle", outerSide)
                .texture("inner_side", innerSide)
                .texture("inner_top", innerTop)
                .texture("outer_side", outerSide)
                .texture("outer_top", outerTop)
                // Layer 1: Inner Log
                .element()
                .from(0, 0, 0).to(16, 16, 16)
                .face(net.minecraft.core.Direction.DOWN).texture("#inner_top").cullface(net.minecraft.core.Direction.DOWN).end()
                .face(net.minecraft.core.Direction.UP).texture("#inner_top").cullface(net.minecraft.core.Direction.UP).end()
                .face(net.minecraft.core.Direction.NORTH).texture("#inner_side").cullface(net.minecraft.core.Direction.NORTH).end()
                .face(net.minecraft.core.Direction.SOUTH).texture("#inner_side").cullface(net.minecraft.core.Direction.SOUTH).end()
                .face(net.minecraft.core.Direction.WEST).texture("#inner_side").cullface(net.minecraft.core.Direction.WEST).end()
                .face(net.minecraft.core.Direction.EAST).texture("#inner_side").cullface(net.minecraft.core.Direction.EAST).end()
                .end()
                // Layer 2: Outer Bark (rendered on top)
                .element()
                .from(0, 0, 0).to(16, 16, 16)
                .face(net.minecraft.core.Direction.DOWN).texture("#outer_top").cullface(net.minecraft.core.Direction.DOWN).end()
                .face(net.minecraft.core.Direction.UP).texture("#outer_top").cullface(net.minecraft.core.Direction.UP).end()
                .face(net.minecraft.core.Direction.NORTH).texture("#outer_side").cullface(net.minecraft.core.Direction.NORTH).end()
                .face(net.minecraft.core.Direction.SOUTH).texture("#outer_side").cullface(net.minecraft.core.Direction.SOUTH).end()
                .face(net.minecraft.core.Direction.WEST).texture("#outer_side").cullface(net.minecraft.core.Direction.WEST).end()
                .face(net.minecraft.core.Direction.EAST).texture("#outer_side").cullface(net.minecraft.core.Direction.EAST).end()
                .end()
                .renderType("cutout");

        // 2. Register Axis Block States
        axisBlock(block, model, model);

        // 3. Make the Item Model inherit directly from the layered block model!
        simpleBlockItem(block, model);
    }

    public void makeKiwiCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> kiwiStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }


    private ConfiguredModel[] kiwiStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((KiwiFruitCropBlock) block).getAgeProperty()),
                new ResourceLocation(modtest.MOD_ID, "block/" + textureName + state.getValue(((KiwiFruitCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(modtest.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));

    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}

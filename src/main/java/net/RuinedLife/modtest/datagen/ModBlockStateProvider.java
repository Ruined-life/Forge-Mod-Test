package net.RuinedLife.modtest.datagen;

import net.RuinedLife.modtest.registries.ModBlocks;
import net.RuinedLife.modtest.block.custom.KiwiFruitCropBlock;
import net.RuinedLife.modtest.modtest;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, modtest.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //PUT ALL YOUR BLOCKS HERE
        //e.x blockWithItem(ModBlocks.BLOCK);
        blockWithItem(ModBlocks.DARKNESS_BLOCK);
        blockWithItem(ModBlocks.PINK_BLOCK);
        blockWithItem(ModBlocks.NAZI_BLOCK);
        blockWithItem(ModBlocks.NEW_ZEALAND_BLOCK);
        blockWithItem(ModBlocks.DUST_BLOCK);

        stairsBlock(((StairBlock)ModBlocks.DARKNESS_STAIRS.get()), blockTexture(ModBlocks.DARKNESS_BLOCK.get()));
        slabBlock(((SlabBlock)ModBlocks.DARKNESS_SLAB.get()), blockTexture(ModBlocks.DARKNESS_BLOCK.get()), blockTexture(ModBlocks.DARKNESS_BLOCK.get()));

        buttonBlock(((ButtonBlock)ModBlocks.DARKNESS_BUTTON.get()), blockTexture(ModBlocks.DARKNESS_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock)ModBlocks.DARKNESS_PRESSURE_PLATE.get()), blockTexture(ModBlocks.DARKNESS_BLOCK.get()));

        fenceBlock(((FenceBlock)ModBlocks.DARKNESS_FENCE.get()), blockTexture(ModBlocks.DARKNESS_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock)ModBlocks.DARKNESS_FENCE_GATE.get()), blockTexture(ModBlocks.DARKNESS_BLOCK.get()));
        wallBlock(((WallBlock)ModBlocks.DARKNESS_WALL.get()), blockTexture(ModBlocks.DARKNESS_BLOCK.get()));

        doorBlockWithRenderType(
                (DoorBlock) ModBlocks.DARKNESS_DOOR.get(),
                modLoc("block/darkness_door_bottom"),
                modLoc("block/darkness_door_top"),
                "cutout"
        );
        trapdoorBlockWithRenderType(((TrapDoorBlock)ModBlocks.DARKNESS_TRAP_DOOR.get()), modLoc("block/darkness_trap_door"), true, "cutout");


        makeKiwiCrop((CropBlock) ModBlocks.KIWI_CROP.get(), "kiwi_stage", "kiwi_stage_");


        //AQUA
        simpleBlockWithItem(ModBlocks.AQUA.get(), models().cross(blockTexture(ModBlocks.AQUA.get()).getPath(),
                blockTexture(ModBlocks.AQUA.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_AQUA.get(), models().singleTexture("potted_aqua", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.AQUA.get())).renderType("cutout"));

        //GREEN
        simpleBlockWithItem(ModBlocks.GREEN.get(), models().cross(blockTexture(ModBlocks.GREEN.get()).getPath(),
                blockTexture(ModBlocks.GREEN.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_GREEN.get(), models().singleTexture("potted_green", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.GREEN.get())).renderType("cutout"));

        //PURPLE
        simpleBlockWithItem(ModBlocks.PURPLE.get(), models().cross(blockTexture(ModBlocks.PURPLE.get()).getPath(),
                blockTexture(ModBlocks.PURPLE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_PURPLE.get(), models().singleTexture("potted_purple", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.PURPLE.get())).renderType("cutout"));

        //GOLD
        simpleBlockWithItem(ModBlocks.GOLD.get(), models().cross(blockTexture(ModBlocks.GOLD.get()).getPath(),
                blockTexture(ModBlocks.GOLD.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_GOLD.get(), models().singleTexture("potted_gold", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.GOLD.get())).renderType("cutout"));

        //YELLOW
        simpleBlockWithItem(ModBlocks.YELLOW.get(), models().cross(blockTexture(ModBlocks.YELLOW.get()).getPath(),
                blockTexture(ModBlocks.YELLOW.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_YELLOW.get(), models().singleTexture("potted_yellow", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.YELLOW.get())).renderType("cutout"));

        //ORANGE
        simpleBlockWithItem(ModBlocks.ORANGE.get(), models().cross(blockTexture(ModBlocks.ORANGE.get()).getPath(),
                blockTexture(ModBlocks.ORANGE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_ORANGE.get(), models().singleTexture("potted_orange", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.ORANGE.get())).renderType("cutout"));

        //BLUE
        simpleBlockWithItem(ModBlocks.BLUE.get(), models().cross(blockTexture(ModBlocks.BLUE.get()).getPath(),
                blockTexture(ModBlocks.BLUE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_BLUE.get(), models().singleTexture("potted_blue", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.BLUE.get())).renderType("cutout"));

        //PINK
        simpleBlockWithItem(ModBlocks.PINK.get(), models().cross(blockTexture(ModBlocks.PINK.get()).getPath(),
                blockTexture(ModBlocks.PINK.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_PINK.get(), models().singleTexture("potted_pink", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.PINK.get())).renderType("cutout"));


        // 1. Generate Blockstates & Block Models
        multiLayerLogBlock(
                (RotatedPillarBlock) ModBlocks.SCARLET_LOG.get(),
                modLoc("block/scarlet_log_inner"),
                modLoc("block/scarlet_log_inner_top"),
                modLoc("block/scarlet_log_outer"),
                modLoc("block/scarlet_log_outer_top")
        );
// 2. Generate ONLY Item Models (pointing to the block models)
        blockWithItem(ModBlocks.SCARLET_PLANKS);
        multiLayerLeavesBlock(
                ModBlocks.SCARLET_LEAVES,
                modLoc("block/scarlet_leaves_inner"),
                modLoc("block/scarlet_leaves_outer")
        );

        //axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SCARLET_LOG.get()), blockTexture(ModBlocks.STRIPPED_SCARLET_LOG.get()),
                //new ResourceLocation(modtest.MOD_ID, "block/new_zealand_block"));
        //axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SCARLET_WOOD.get()),
                //blockTexture(ModBlocks.STRIPPED_SCARLET_LOG.get()));

        //blockItem(ModBlocks.SCARLET_LOG);
        //blockItem(ModBlocks.SCARLET_WOOD);
        //blockItem(ModBlocks.STRIPPED_SCARLET_LOG);
        //blockItem(ModBlocks.STRIPPED_SCARLET_WOOD);



    }

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

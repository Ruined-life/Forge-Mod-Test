package net.RuinedLife.modtest.datagen;

import net.RuinedLife.modtest.block.ModBlocks;
import net.RuinedLife.modtest.block.custom.KiwiFruitCropBlock;
import net.RuinedLife.modtest.modtest;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
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


        simpleBlockWithItem(ModBlocks.AQUA.get(), models().cross(blockTexture(ModBlocks.AQUA.get()).getPath(),
                blockTexture(ModBlocks.AQUA.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_AQUA.get(), models().singleTexture("potted_catmint", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.AQUA.get())).renderType("cutout"));

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


    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}

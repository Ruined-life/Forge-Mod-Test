package net.RuinedLife.modtest.datagen;

import net.RuinedLife.modtest.registries.ModBlocks;
import net.RuinedLife.modtest.registries.ModItems;
import net.RuinedLife.modtest.modtest;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, modtest.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.TEMPORARY_MUSIC_DISC);
        simpleItem(ModItems.BLACK_KNIFE_MUSIC_DISC);
        simpleItem(ModItems.ERIKA_MUSIC_DISC);

        //CUSTOM TOOLS
        simpleItem(ModItems.AOE_PICKAXE);
        simpleItem(ModItems.CHEST_SCANNER);

        simpleItem(ModItems.crystal_a);
        simpleItem(ModItems.crystal_b);
        simpleItem(ModItems.crystal_c);
        simpleItem(ModItems.crystal_d);
        simpleItem(ModItems.crystal_e);
        simpleItem(ModItems.pure_crystal);
        simpleItem(ModItems.kiwi_fruit);
        simpleItem(ModItems.kiwi_seeds);
        simpleItem(ModItems.FRIEND);
        simpleItem(ModItems.FEATHER);
        simpleItem(ModItems.SUN);

        //FOOD
        simpleItem(ModItems.PIE_NORMAL);
        simpleItem(ModItems.PIE_AQUA);
        simpleItem(ModItems.PIE_PURPLE);
        simpleItem(ModItems.PIE_GOLD);
        simpleItem(ModItems.PIE_GREEN);
        simpleItem(ModItems.PIE_YELLOW);
        simpleItem(ModItems.PIE_ORANGE);
        simpleItem(ModItems.PIE_BLUE);
        simpleItem(ModItems.PIE_PINK);

        //FLOWER ITEMS
        simpleItem(ModItems.TOY_KNIFE);
        simpleItem(ModItems.RIBBON);

        simpleItem(ModItems.TOY_GUN);
        simpleItem(ModItems.COWBOY_HAT);

        simpleItem(ModItems.BURNT_PAN);
        simpleItem(ModItems.APRON);

        simpleItem(ModItems.TORN_NOTEBOOK);
        simpleItem(ModItems.CLOUDY_GLASSES);

        simpleItem(ModItems.BALLET_SHOES);
        simpleItem(ModItems.TUTU);

        simpleItem(ModItems.TOUGH_GLOVE);
        simpleItem(ModItems.BANDANA);

        simpleItem(ModItems.AQUA_SPAWN_EGG);


        fenceItem(ModBlocks.DARKNESS_FENCE, ModBlocks.DARKNESS_BLOCK);
        buttonItem(ModBlocks.DARKNESS_BUTTON, ModBlocks.DARKNESS_BLOCK);
        wallItem(ModBlocks.DARKNESS_WALL, ModBlocks.DARKNESS_BLOCK);
        trapdoorItem(ModBlocks.DARKNESS_TRAP_DOOR);

        //handheldItem(ModItems.PINK_SWORD);
        handheldItem(ModItems.PINK_PICKAXE);
        handheldItem(ModItems.PINK_AXE);
        handheldItem(ModItems.PINK_SHOVEL);
        handheldItem(ModItems.PINK_HOE);

        simpleBlockItemBlockTexture(ModBlocks.AQUA);
        simpleBlockItemBlockTexture(ModBlocks.PURPLE);
        simpleBlockItemBlockTexture(ModBlocks.GREEN);
        simpleBlockItemBlockTexture(ModBlocks.GOLD);
        simpleBlockItemBlockTexture(ModBlocks.YELLOW);
        simpleBlockItemBlockTexture(ModBlocks.ORANGE);
        simpleBlockItemBlockTexture(ModBlocks.BLUE);
        simpleBlockItemBlockTexture(ModBlocks.PINK);


        withExistingParent(ModItems.RHINO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));


    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        assert item.getId() != null;
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(modtest.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(modtest.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                mcLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    // Option A: Render 2D in hand using your darkness_trap_door.png block texture
    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), "item/generated")
                .texture("layer0", new ResourceLocation(modtest.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(modtest.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(modtest.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(modtest.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(modtest.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(modtest.MOD_ID, "item/" + item.getId().getPath()));
    }


    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(modtest.MOD_ID, "block/" + item.getId().getPath()));
    }



}

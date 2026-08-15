package net.RuinedLife.modtest.datagen;

import net.RuinedLife.modtest.registries.BlockRegistry;
import net.RuinedLife.modtest.registries.ItemsRegistry;
import net.RuinedLife.modtest.modtest;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, modtest.MOD_ID, existingFileHelper);
    }
    /*---------------------------------------------------------------------------------------------------------------------------*/
    @Override
    protected void registerModels() {
        simpleItem(ItemsRegistry.TEMPORARY_MUSIC_DISC);
        simpleItem(ItemsRegistry.BLACK_KNIFE_MUSIC_DISC);
        simpleItem(ItemsRegistry.ERIKA_MUSIC_DISC);

        //CUSTOM TOOLS
        simpleItem(ItemsRegistry.AOE_PICKAXE);
        simpleItem(ItemsRegistry.CHEST_SCANNER);

        simpleItem(ItemsRegistry.crystal_a);
        simpleItem(ItemsRegistry.crystal_b);
        simpleItem(ItemsRegistry.crystal_c);
        simpleItem(ItemsRegistry.crystal_d);
        simpleItem(ItemsRegistry.crystal_e);
        simpleItem(ItemsRegistry.pure_crystal);
        simpleItem(ItemsRegistry.DICE_ITEM);
        simpleItem(ItemsRegistry.kiwi_fruit);
        simpleItem(ItemsRegistry.kiwi_seeds);
        simpleItem(ItemsRegistry.FRIEND);
        simpleItem(ItemsRegistry.FEATHER);
        simpleItem(ItemsRegistry.SUN);

        //FOOD
        simpleItem(ItemsRegistry.PIE_NORMAL);
        simpleItem(ItemsRegistry.PIE_AQUA);
        simpleItem(ItemsRegistry.PIE_PURPLE);
        simpleItem(ItemsRegistry.PIE_GOLD);
        simpleItem(ItemsRegistry.PIE_GREEN);
        simpleItem(ItemsRegistry.PIE_YELLOW);
        simpleItem(ItemsRegistry.PIE_ORANGE);
        simpleItem(ItemsRegistry.PIE_BLUE);
        simpleItem(ItemsRegistry.PIE_PINK);

        //FLOWER ITEMS
        simpleItem(ItemsRegistry.TOY_KNIFE);
        simpleItem(ItemsRegistry.RIBBON);

        simpleItem(ItemsRegistry.TOY_GUN);
        simpleItem(ItemsRegistry.COWBOY_HAT);

        simpleItem(ItemsRegistry.BURNT_PAN);
        simpleItem(ItemsRegistry.APRON);

        simpleItem(ItemsRegistry.TORN_NOTEBOOK);
        simpleItem(ItemsRegistry.CLOUDY_GLASSES);

        simpleItem(ItemsRegistry.BALLET_SHOES);
        simpleItem(ItemsRegistry.TUTU);

        simpleItem(ItemsRegistry.TOUGH_GLOVE);
        simpleItem(ItemsRegistry.BANDANA);

        simpleItem(ItemsRegistry.AQUA_SPAWN_EGG);


        fenceItem(BlockRegistry.DARKNESS_FENCE, BlockRegistry.DARKNESS_BLOCK);
        buttonItem(BlockRegistry.DARKNESS_BUTTON, BlockRegistry.DARKNESS_BLOCK);
        wallItem(BlockRegistry.DARKNESS_WALL, BlockRegistry.DARKNESS_BLOCK);
        trapdoorItem(BlockRegistry.DARKNESS_TRAP_DOOR);

        //handheldItem(ModItems.PINK_SWORD);
        handheldItem(ItemsRegistry.PINK_PICKAXE);
        handheldItem(ItemsRegistry.PINK_AXE);
        handheldItem(ItemsRegistry.PINK_SHOVEL);
        handheldItem(ItemsRegistry.PINK_HOE);

        simpleBlockItemBlockTexture(BlockRegistry.AQUA);
        simpleBlockItemBlockTexture(BlockRegistry.PURPLE);
        simpleBlockItemBlockTexture(BlockRegistry.GREEN);
        simpleBlockItemBlockTexture(BlockRegistry.GOLD);
        simpleBlockItemBlockTexture(BlockRegistry.YELLOW);
        simpleBlockItemBlockTexture(BlockRegistry.ORANGE);
        simpleBlockItemBlockTexture(BlockRegistry.BLUE);
        simpleBlockItemBlockTexture(BlockRegistry.PINK);

        withExistingParent(ItemsRegistry.RHINO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

    }
    /*---------------------------------------------------------------------------------------------------------------------------*/
    /*METHODS*/
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

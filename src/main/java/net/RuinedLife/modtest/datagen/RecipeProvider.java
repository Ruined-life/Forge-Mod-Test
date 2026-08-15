package net.RuinedLife.modtest.datagen;

import net.RuinedLife.modtest.registries.BlockRegistry;
import net.RuinedLife.modtest.registries.ItemsRegistry;
import net.RuinedLife.modtest.modtest;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SMELTABLE_ITEMS = List.of(ItemsRegistry.kiwi_fruit.get());

    public RecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }
    /*---------------------------------------------------------------------------------------------------------------------------*/
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        //I have nothing to smelt at the moment but heres an example
        //oreSmelting(pWriter, SMELTABLE_ITEMS, RecipeCategory.MISC, ModItems.KIWI_FRUIT.get(), 0.25f, 100, "food");


        //PURE CRYSTAL
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemsRegistry.pure_crystal.get())
                .pattern(" A ")
                .pattern("BED")
                .pattern(" C ")
                .define('A', ItemsRegistry.crystal_a.get())
                .define('B', ItemsRegistry.crystal_b.get())
                .define('E', ItemsRegistry.crystal_e.get())
                .define('D', ItemsRegistry.crystal_d.get())
                .define('C', ItemsRegistry.crystal_c.get())
                .unlockedBy(getHasName(ItemsRegistry.crystal_a.get()), has(ItemsRegistry.crystal_a.get()))
                .save(pWriter);

        //PURE C
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.NEW_ZEALAND_BLOCK.get())
                .pattern("AAA")
                .pattern("BCB")
                .pattern("AAA")
                .define('A', Items.BLUE_WOOL)
                .define('B', Items.WHITE_DYE)
                .define('C', Items.RED_DYE)
                .unlockedBy(getHasName(Items.BLUE_WOOL), has(Items.BLUE_WOOL))
                .save(pWriter);

        //IDK
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemsRegistry.FRIEND.get(), 1)
                .requires(ItemsRegistry.FRIEND.get())
                .unlockedBy(getHasName(ItemsRegistry.FRIEND.get()), has(ItemsRegistry.FRIEND.get()))
                .save(pWriter);


        //ALL PIE RECIPES
        //NORMAL PIE

        //AQUA PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemsRegistry.PIE_AQUA.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', BlockRegistry.AQUA.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ItemsRegistry.TOY_KNIFE.get(),
                        ItemsRegistry.RIBBON.get()

                ))
                .unlockedBy(getHasName(ItemsRegistry.PIE_NORMAL.get()), has(ItemsRegistry.PIE_NORMAL.get()))
                .save(pWriter);


        //PURPLE PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemsRegistry.PIE_PURPLE.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', BlockRegistry.PURPLE.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ItemsRegistry.TORN_NOTEBOOK.get(),
                        ItemsRegistry.CLOUDY_GLASSES.get()

                ))
                .unlockedBy(getHasName(ItemsRegistry.PIE_NORMAL.get()), has(ItemsRegistry.PIE_NORMAL.get()))
                .save(pWriter);


        //GREEN PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemsRegistry.PIE_GREEN.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', BlockRegistry.GREEN.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ItemsRegistry.BURNT_PAN.get(),
                        ItemsRegistry.APRON.get()

                ))
                .unlockedBy(getHasName(ItemsRegistry.PIE_NORMAL.get()), has(ItemsRegistry.PIE_NORMAL.get()))
                .save(pWriter);


        //YELLOW PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemsRegistry.PIE_YELLOW.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', BlockRegistry.YELLOW.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ItemsRegistry.TOY_GUN.get(),
                        ItemsRegistry.COWBOY_HAT.get()

                ))
                .unlockedBy(getHasName(ItemsRegistry.PIE_NORMAL.get()), has(ItemsRegistry.PIE_NORMAL.get()))
                .save(pWriter);

        //ORANGE PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemsRegistry.PIE_ORANGE.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', BlockRegistry.ORANGE.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ItemsRegistry.TOUGH_GLOVE.get(),
                        ItemsRegistry.BANDANA.get()

                ))
                .unlockedBy(getHasName(ItemsRegistry.PIE_NORMAL.get()), has(ItemsRegistry.PIE_NORMAL.get()))
                .save(pWriter);


        //BLUE PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemsRegistry.PIE_BLUE.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', BlockRegistry.BLUE.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ItemsRegistry.BALLET_SHOES.get(),
                        ItemsRegistry.TUTU.get()

                ))
                .unlockedBy(getHasName(ItemsRegistry.PIE_NORMAL.get()), has(ItemsRegistry.PIE_NORMAL.get()))
                .save(pWriter);


        //PINK PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemsRegistry.PIE_PINK.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', BlockRegistry.PINK.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ItemsRegistry.PINK_SWORD.get(),
                        ItemsRegistry.PINK_BOOTS.get(),
                        ItemsRegistry.PINK_LEGGINGS.get(),
                        ItemsRegistry.PINK_CHESTPLATE.get(),
                        ItemsRegistry.PINK_HELMET.get(),
                        ItemsRegistry.PINK_PICKAXE.get(),
                        ItemsRegistry.PINK_AXE.get(),
                        ItemsRegistry.PINK_SHOVEL.get(),
                        ItemsRegistry.PINK_HOE.get()

                ))
                .unlockedBy(getHasName(ItemsRegistry.PIE_NORMAL.get()), has(ItemsRegistry.PIE_NORMAL.get()))
                .save(pWriter);

        //GOLD PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemsRegistry.PIE_GOLD.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', ItemsRegistry.PIE_NORMAL.get())
                .define('B', Ingredient.of(
                        BlockRegistry.AQUA.get(),
                        BlockRegistry.PURPLE.get(),
                        BlockRegistry.GREEN.get(),
                        BlockRegistry.GOLD.get(),
                        BlockRegistry.YELLOW.get(),
                        BlockRegistry.BLUE.get(),
                        BlockRegistry.ORANGE.get(),
                        BlockRegistry.PINK.get()
                ))
                .unlockedBy(getHasName(ItemsRegistry.PIE_NORMAL.get()), has(ItemsRegistry.PIE_NORMAL.get()))
                .save(pWriter);

    }
    /*---------------------------------------------------------------------------------------------------------------------------*/
    /*METHODS*/
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, modtest.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}

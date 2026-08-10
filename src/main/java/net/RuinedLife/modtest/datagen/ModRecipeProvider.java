package net.RuinedLife.modtest.datagen;

import net.RuinedLife.modtest.block.ModBlocks;
import net.RuinedLife.modtest.item.ModItems;
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

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SMELTABLE_ITEMS = List.of(ModItems.kiwi_fruit.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        //I have nothing to smelt at the moment but heres an example
        //oreSmelting(pWriter, SMELTABLE_ITEMS, RecipeCategory.MISC, ModItems.KIWI_FRUIT.get(), 0.25f, 100, "food");


        //PURE CRYSTAL
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.pure_crystal.get())
                .pattern(" A ")
                .pattern("BED")
                .pattern(" C ")
                .define('A', ModItems.crystal_a.get())
                .define('B', ModItems.crystal_b.get())
                .define('E', ModItems.crystal_e.get())
                .define('D', ModItems.crystal_d.get())
                .define('C', ModItems.crystal_c.get())
                .unlockedBy(getHasName(ModItems.crystal_a.get()), has(ModItems.crystal_a.get()))
                .save(pWriter);


        //PURE C
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NEW_ZEALAND_BLOCK.get())
                .pattern("AAA")
                .pattern("BCB")
                .pattern("AAA")
                .define('A', Items.BLUE_WOOL)
                .define('B', Items.WHITE_DYE)
                .define('C', Items.RED_DYE)
                .unlockedBy(getHasName(Items.BLUE_WOOL), has(Items.BLUE_WOOL))
                .save(pWriter);

        //IDK
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FRIEND.get(), 1)
                .requires(ModItems.FRIEND.get())
                .unlockedBy(getHasName(ModItems.FRIEND.get()), has(ModItems.FRIEND.get()))
                .save(pWriter);


        //ALL PIE RECIPES
        //NORMAL PIE

        //AQUA PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PIE_AQUA.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', ModBlocks.AQUA.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ModItems.TOY_KNIFE.get(),
                        ModItems.RIBBON.get()

                ))
                .unlockedBy(getHasName(ModItems.PIE_NORMAL.get()), has(ModItems.PIE_NORMAL.get()))
                .save(pWriter);


        //PURPLE PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PIE_PURPLE.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', ModBlocks.PURPLE.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ModItems.TORN_NOTEBOOK.get(),
                        ModItems.CLOUDY_GLASSES.get()

                ))
                .unlockedBy(getHasName(ModItems.PIE_NORMAL.get()), has(ModItems.PIE_NORMAL.get()))
                .save(pWriter);


        //GREEN PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PIE_GREEN.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', ModBlocks.GREEN.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ModItems.BURNT_PAN.get(),
                        ModItems.APRON.get()

                ))
                .unlockedBy(getHasName(ModItems.PIE_NORMAL.get()), has(ModItems.PIE_NORMAL.get()))
                .save(pWriter);


        //YELLOW PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PIE_YELLOW.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', ModBlocks.YELLOW.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ModItems.TOY_GUN.get(),
                        ModItems.COWBOY_HAT.get()

                ))
                .unlockedBy(getHasName(ModItems.PIE_NORMAL.get()), has(ModItems.PIE_NORMAL.get()))
                .save(pWriter);


        //ORANGE PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PIE_ORANGE.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', ModBlocks.ORANGE.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ModItems.TOUGH_GLOVE.get(),
                        ModItems.BANDANA.get()

                ))
                .unlockedBy(getHasName(ModItems.PIE_NORMAL.get()), has(ModItems.PIE_NORMAL.get()))
                .save(pWriter);


        //BLUE PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PIE_BLUE.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', ModBlocks.BLUE.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ModItems.BALLET_SHOES.get(),
                        ModItems.TUTU.get()

                ))
                .unlockedBy(getHasName(ModItems.PIE_NORMAL.get()), has(ModItems.PIE_NORMAL.get()))
                .save(pWriter);


        //PINK PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PIE_PINK.get())
                .pattern("BBB")
                .pattern("DAD")
                .pattern("CCC")
                .define('A', ModBlocks.PINK.get())
                .define('B', Items.EGG)
                .define('C', Items.WHEAT)
                .define('D', Ingredient.of(
                        ModItems.PINK_SWORD.get(),
                        ModItems.PINK_BOOTS.get(),
                        ModItems.PINK_LEGGINGS.get(),
                        ModItems.PINK_CHESTPLATE.get(),
                        ModItems.PINK_HELMET.get(),
                        ModItems.PINK_PICKAXE.get(),
                        ModItems.PINK_AXE.get(),
                        ModItems.PINK_SHOVEL.get(),
                        ModItems.PINK_HOE.get()

                ))
                .unlockedBy(getHasName(ModItems.PIE_NORMAL.get()), has(ModItems.PIE_NORMAL.get()))
                .save(pWriter);

        //GOLD PIE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PIE_GOLD.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', ModItems.PIE_NORMAL.get())
                .define('B', Ingredient.of(
                        ModBlocks.AQUA.get(),
                        ModBlocks.PURPLE.get(),
                        ModBlocks.GREEN.get(),
                        ModBlocks.GOLD.get(),
                        ModBlocks.YELLOW.get(),
                        ModBlocks.BLUE.get(),
                        ModBlocks.ORANGE.get(),
                        ModBlocks.PINK.get()
                ))
                .unlockedBy(getHasName(ModItems.PIE_NORMAL.get()), has(ModItems.PIE_NORMAL.get()))
                .save(pWriter);

    }

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

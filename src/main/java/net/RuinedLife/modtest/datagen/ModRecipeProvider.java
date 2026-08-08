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

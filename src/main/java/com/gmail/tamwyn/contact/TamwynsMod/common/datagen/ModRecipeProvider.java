package com.gmail.tamwyn.contact.TamwynsMod.common.datagen;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;
import com.gmail.tamwyn.contact.TamwynsMod.common.block.ModBlocks;
import com.gmail.tamwyn.contact.TamwynsMod.common.item.ModItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(
        ModItems.RAW_SAPPHIRE.get(),
        ModBlocks.RAW_SAPPHIRE_ORE.get()
        //we can add other blocs vaiants here to respect this scheme
    );


    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries){
        super(pOutput, pRegistries);   
    }


    @Override
    protected void buildRecipes(RecipeOutput pConsumer) {
        oreBlasting(pConsumer, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 2.7F, 100, "sapphire");
        oreSmelting(pConsumer, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 2.7F, 300, "sapphire");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', ModItems.SAPPHIRE.get())
            .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
            .save(pConsumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METAL_DETECTOR.get())
            .pattern(" GP")
            .pattern(" SG")
            .pattern("S  ")
            .define('P', ModItems.SAPPHIRE.get())
            .define('G', Items.GOLD_INGOT)
            .define('S', Items.STICK)
            .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
            .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
            .save(pConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUND_BLOCK.get())
            .pattern("QQQ")
            .pattern("QSQ")
            .pattern("QQQ")
            .define('S', ModItems.SAPPHIRE.get())
            .define('Q', Blocks.QUARTZ_BLOCK)
            .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
            .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
            .save(pConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
            .requires(ModBlocks.SAPPHIRE_BLOCK.get())
            .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
            .save(pConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.GOLDEN_SAPPHIRE_BLOCK.get(), 1)
            .requires(ModBlocks.SAPPHIRE_BLOCK.get())
            .requires(Items.GOLD_INGOT)
            .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
            .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
            .save(pConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.EMERALD_SAPPHIRE_BLOCK.get(), 1)
            .requires(ModBlocks.SAPPHIRE_BLOCK.get())
            .requires(Items.EMERALD)
            .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
            .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
            .save(pConsumer);
    }

    //oreCooking dosnt allow to use tamwynsmod:... as a namespace so we need to modify it.
    //because oreBlasting and oreSmelting are protected we need to copy the code and modify them 
    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        Iterator<ItemLike> var10 = pIngredients.iterator();

        while(var10.hasNext()) {
        ItemLike itemlike = (ItemLike)var10.next();
        SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}),
                pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                .save(pRecipeOutput, TamwynsMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

   }
}

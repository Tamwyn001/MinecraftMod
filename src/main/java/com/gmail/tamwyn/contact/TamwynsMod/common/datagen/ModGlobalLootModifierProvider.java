package com.gmail.tamwyn.contact.TamwynsMod.common.datagen;

import java.util.concurrent.CompletableFuture;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;
import com.gmail.tamwyn.contact.TamwynsMod.common.item.ModItems;
import com.gmail.tamwyn.contact.TamwynsMod.common.loot.AddItemModifier;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider{

    public ModGlobalLootModifierProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, TamwynsMod.MOD_ID, registries);
    }
    
    @Override
    protected void start() {
        add("fire_flower_from_grass", new AddItemModifier(new LootItemCondition[] {
            LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
            LootItemRandomChanceCondition.randomChance(0.05f).build()
        }, ModItems.FIRE_FLOWER.get()));    
        add("fire_flower_from_grass", new AddItemModifier(new LootItemCondition[] {
            LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
            LootItemRandomChanceCondition.randomChance(0.1f).build()
        }, ModItems.FIRE_FLOWER.get()));   
        add("fire_flower_from_creeper", new AddItemModifier(
            new LootItemCondition[] {new LootTableIdCondition.Builder(
                new ResourceLocation("entities/creeper")).build()
            }, ModItems.FIRE_FLOWER.get())); 
        add("metal_detector_from_jungle_temple", new AddItemModifier(
            new LootItemCondition[] {new LootTableIdCondition.Builder(
                new ResourceLocation("chests/jungle_temple")).build()
            }, ModItems.METAL_DETECTOR.get()));    
    }

}

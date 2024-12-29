package com.gmail.tamwyn.contact.TamwynsMod.common.datagen.loot;

import java.util.Set;

import com.gmail.tamwyn.contact.TamwynsMod.common.block.ModBlocks;
import com.gmail.tamwyn.contact.TamwynsMod.common.item.ModItems;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate(){
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.GOLDEN_SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.EMERALD_SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.RAW_SAPPHIRE_ORE.get(), 
            block -> createCopperLikeOreDrop(block, ModItems.RAW_SAPPHIRE.get().asItem()));

    }

    protected LootTable.Builder createCopperLikeOreDrop(Block pBlock, Item item){
        return createSilkTouchDispatchTable(pBlock, 
            this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
    
}

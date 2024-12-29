package com.gmail.tamwyn.contact.TamwynsMod.common.datagen;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;
import com.gmail.tamwyn.contact.TamwynsMod.common.block.ModBlocks;
import com.gmail.tamwyn.contact.TamwynsMod.common.util.ModTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
    @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TamwynsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider){
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
        .add(ModBlocks.RAW_SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);


        
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .add(
            ModBlocks.RAW_SAPPHIRE_ORE.get(),
            ModBlocks.SAPPHIRE_BLOCK.get(),
            ModBlocks.EMERALD_SAPPHIRE_BLOCK.get(),
            ModBlocks.GOLDEN_SAPPHIRE_BLOCK.get(),
            ModBlocks.SOUND_BLOCK.get()
        );


        this.tag(BlockTags.NEEDS_IRON_TOOL)
        .add(ModBlocks.RAW_SAPPHIRE_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
        .add(ModBlocks.SAPPHIRE_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
        .add(ModBlocks.EMERALD_SAPPHIRE_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
        .add(ModBlocks.GOLDEN_SAPPHIRE_BLOCK.get());


    }
}
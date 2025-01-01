package com.gmail.tamwyn.contact.TamwynsMod.common.datagen;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;
import com.gmail.tamwyn.contact.TamwynsMod.common.item.ModItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagGenerator extends ItemTagsProvider{

       public ModItemTagGenerator(PackOutput p_275343_,
        CompletableFuture<HolderLookup.Provider> p_275729_, 
        CompletableFuture<TagsProvider.TagLookup<Block>> p_275322_,
         @Nullable ExistingFileHelper existingFileHelper) {

            super(p_275343_, p_275729_, p_275322_, TamwynsMod.MOD_ID, existingFileHelper);
       }

       @Override
       protected void addTags(HolderLookup.Provider pProvider){
              this.tag(ItemTags.TRIMMABLE_ARMOR)
              .add(ModItems.SAPPHIRE_HELMET.get())
              .add(ModItems.SAPPHIRE_CHESTPLATE.get())
              .add(ModItems.SAPPHIRE_LEGGINGS.get())
              .add(ModItems.SAPPHIRE_BOOTS.get());
       }


}

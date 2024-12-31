package com.gmail.tamwyn.contact.TamwynsMod.common.util;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{

        //registers a new tag
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = tag("needs_sapphire_tool");


        private static TagKey<Block> tag(String pName) {
            return BlockTags.create(new ResourceLocation(TamwynsMod.MOD_ID, pName));
        }
    }

    public static class Items{


        private static TagKey<Item> tag(String pName) {
            return ItemTags.create(new ResourceLocation(TamwynsMod.MOD_ID, pName));
        }
    }

}

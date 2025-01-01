package com.gmail.tamwyn.contact.TamwynsMod.common.item.custom;

import com.gmail.tamwyn.contact.TamwynsMod.common.item.ModItems;
import com.gmail.tamwyn.contact.TamwynsMod.common.util.ModTags;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTier {
    public static final Tier SAPPHIRE = new ForgeTier(
            2000, // Durability
            9.0F, // Speed
            4.0F, // Damage
            25, // Enchantablitiy
            ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, // Tag for blocks that the tier can mine
            () -> Ingredient.of(ModItems.SAPPHIRE.get()), // Repair material
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL // Tag for incorrect blocks (i.e., blocks this tier can't mine)

    );




}

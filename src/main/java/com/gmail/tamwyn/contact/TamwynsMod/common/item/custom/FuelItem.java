package com.gmail.tamwyn.contact.TamwynsMod.common.item.custom;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;

public class FuelItem extends Item{
    private int burnTime = 0; // The burn time of the item in tics 20 tics = 1 second
    private String description = "";
    public FuelItem(Properties pProperties, int pBurnTime) {
        super(pProperties);
        this.burnTime = pBurnTime;
    }

    public FuelItem(Properties pProperties, int pBurnTime, String pDescription) {
        super(pProperties);
        this.burnTime = pBurnTime;
        this.description = pDescription;
    }

    @Override
    public int getBurnTime(ItemStack pStack, @Nullable RecipeType<?> pRecipeType) {
        return this.burnTime;
    }
    
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable(this.description));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}

package com.gmail.tamwyn.contact.TamwynsMod.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoods {
    public static final FoodProperties PASSION_FRUIT = new FoodProperties.Builder().alwaysEdible().nutrition(2).fast()
        .saturationModifier(0.2f).effect(new MobEffectInstance(MobEffects.LUCK, 200),  0.75f).build();
}


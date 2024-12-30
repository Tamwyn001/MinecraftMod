package com.gmail.tamwyn.contact.TamwynsMod.common.item;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;
import com.gmail.tamwyn.contact.TamwynsMod.common.item.custom.FuelItem;
import com.gmail.tamwyn.contact.TamwynsMod.common.item.custom.MetalDetectorItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, TamwynsMod.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE =ITEMS.register("sapphire",
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_SAPPHIRE =ITEMS.register("raw_sapphire",
    () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
    () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> PASSION_FRUIT = ITEMS.register("passion_fruit",
    () -> new Item(new Item.Properties().food(ModFoods.PASSION_FRUIT)));

    public static final RegistryObject<Item> SAPPHIRE_STAFF = ITEMS.register("sapphire_staff",
    () -> new Item(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> FIRE_FLOWER = ITEMS.register("fire_flower",
    () -> new FuelItem(new Item.Properties(), 1300, "item.tamwynsmod.fire_flower.tooltip")); // 65 seconds, charcoal is 80 seconds


    public static void register(IEventBus eventBus) {
         ITEMS.register(eventBus);
    }

}

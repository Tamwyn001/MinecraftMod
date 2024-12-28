package com.gmail.tamwyn.contact.TamwynsMod.common.item;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;
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

    public static final RegistryObject<MetalDetectorItem> METAL_DETECTOR = ITEMS.register("metal_detector",
    () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus) {
         ITEMS.register(eventBus);
    }

}

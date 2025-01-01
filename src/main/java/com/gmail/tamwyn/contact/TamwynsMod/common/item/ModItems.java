package com.gmail.tamwyn.contact.TamwynsMod.common.item;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;
import com.gmail.tamwyn.contact.TamwynsMod.common.item.custom.FuelItem;
import com.gmail.tamwyn.contact.TamwynsMod.common.item.custom.MetalDetectorItem;
import com.gmail.tamwyn.contact.TamwynsMod.common.item.custom.ModArmorItem;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
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

    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
    () -> new SwordItem(ModToolTier.SAPPHIRE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTier.SAPPHIRE, 15, -2.4F))));

    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
    () -> new PickaxeItem(ModToolTier.SAPPHIRE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTier.SAPPHIRE, 7, -2.4F))));

    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
    () -> new ShovelItem(ModToolTier.SAPPHIRE, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTier.SAPPHIRE, 6, -2.4F))));

    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
    () -> new HoeItem(ModToolTier.SAPPHIRE, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTier.SAPPHIRE, 10, 5.4F))));

    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
    () -> new AxeItem(ModToolTier.SAPPHIRE, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTier.SAPPHIRE, 20, -5.4F))));



    public static final RegistryObject<Item> FIRE_FLOWER = ITEMS.register("fire_flower",
    () -> new FuelItem(new Item.Properties(), 1300, "item.tamwynsmod.fire_flower.tooltip")); // 65 seconds, charcoal is 80 seconds


    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
    () -> new ModArmorItem(ModArmorsMaterials.getHolder(ModArmorsMaterials.SAPPHIRE_MATERIAL), ArmorItem.Type.HELMET, new Item.Properties()));
    //until now only checks if player has full amrmor to apply an effect, it is sufficient to use it once
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
    () -> new ArmorItem(ModArmorsMaterials.getHolder(ModArmorsMaterials.SAPPHIRE_MATERIAL), ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
    () -> new ArmorItem(ModArmorsMaterials.getHolder(ModArmorsMaterials.SAPPHIRE_MATERIAL), ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
    () -> new ArmorItem(ModArmorsMaterials.getHolder(ModArmorsMaterials.SAPPHIRE_MATERIAL), ArmorItem.Type.BOOTS, new Item.Properties()));




    public static void register(IEventBus eventBus) {
         ITEMS.register(eventBus);
    }

}

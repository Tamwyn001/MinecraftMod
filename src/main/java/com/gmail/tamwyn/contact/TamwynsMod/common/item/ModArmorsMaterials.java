package com.gmail.tamwyn.contact.TamwynsMod.common.item;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModArmorsMaterials{

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = 
        DeferredRegister.create(Registries.ARMOR_MATERIAL, TamwynsMod.MOD_ID);



    public static final RegistryObject<ArmorMaterial> SAPPHIRE_MATERIAL = ARMOR_MATERIALS.register("sapphire", 
        () -> newArmorMaterial("sapphire", new int[]{3, 6, 8, 3}, 15, 
                SoundEvents.ARMOR_EQUIP_DIAMOND, 
                () -> Ingredient.of(ModItems.SAPPHIRE.get()),
                2.0F, 0.0F));



    public static Holder<ArmorMaterial> getHolder(RegistryObject<ArmorMaterial> registryObject){
        return registryObject.getHolder().orElseThrow(()-> new RuntimeException("Armor material " + registryObject.getKey() + " not found!"));
    } 

    public static ArmorMaterial newArmorMaterial(
        final String name, final int[] armorValues, int enchantmentValue, Holder<SoundEvent> equipSound,
        Supplier<Ingredient> repairIngredient, float toughness, float knockbackResistance){
        return new ArmorMaterial(
            Map.of( ArmorItem.Type.HELMET, armorValues[0],
                    ArmorItem.Type.CHESTPLATE, armorValues[1],
                    ArmorItem.Type.LEGGINGS, armorValues[2],
                    ArmorItem.Type.BOOTS,  armorValues[3]), 
                enchantmentValue,
                equipSound,
                () -> Ingredient.of(ModItems.SAPPHIRE.get()),
                List.of(new ArmorMaterial.Layer(new ResourceLocation(TamwynsMod.MOD_ID + ":" + name),
                    "", false)),
                toughness, knockbackResistance);    
    }

    public static void register(IEventBus eventBus){
        ARMOR_MATERIALS.register(eventBus);
    }

}

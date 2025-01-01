package com.gmail.tamwyn.contact.TamwynsMod.common.item.custom;

import java.util.Map;

import com.gmail.tamwyn.contact.TamwynsMod.common.item.ModArmorsMaterials;
import com.google.common.collect.ImmutableMap;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

public class ModArmorItem extends ArmorItem{

    private static final Map<RegistryObject<ArmorMaterial>, MobEffectInstance> MATERIAL_TO_EFFECT =
        (new ImmutableMap.Builder<RegistryObject<ArmorMaterial>, MobEffectInstance>())
        .put(ModArmorsMaterials.SAPPHIRE_MATERIAL, new MobEffectInstance(
                MobEffects.DAMAGE_BOOST, 20*30, 3, false, false, true)
        ).build();

    public ModArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player){
        if(!world.isClientSide()){
            if(hasFullSuitOfOfArmorOn(player)){
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player){
        for(Map.Entry<RegistryObject<ArmorMaterial>, MobEffectInstance> entry : MATERIAL_TO_EFFECT.entrySet()){
            RegistryObject<ArmorMaterial> mapArmorMaterial = entry.getKey();
            MobEffectInstance mapEffect = entry.getValue();
            if(hasArmorOn(mapArmorMaterial, player)){
                addStatusEffectForMaterial(mapEffect, player);
            }

        }
    }

    private void addStatusEffectForMaterial(MobEffectInstance effect, Player player){
        boolean hasEffect = player.hasEffect(effect.getEffect());
        
        if(!hasEffect){
            player.addEffect(new MobEffectInstance(effect));   
        }
    }


    private boolean hasArmorOn(RegistryObject<ArmorMaterial> armorMaterial, Player player){
        for (ItemStack armorStack: player.getInventory().armor){
            if (!(armorStack.getItem() instanceof ArmorItem)){
                return false;
            } 
            
            if (!(((ArmorItem) armorStack.getItem()).getMaterial() == ModArmorsMaterials.getHolder(armorMaterial))){
                return false;
            }
        }
        return true;
    }

    private boolean hasFullSuitOfOfArmorOn(Player player){
        return !(player.getInventory().getArmor(0).isEmpty() ||
                player.getInventory().getArmor(1).isEmpty() ||
                player.getInventory().getArmor(2).isEmpty() ||
                player.getInventory().getArmor(3).isEmpty());
    }
}

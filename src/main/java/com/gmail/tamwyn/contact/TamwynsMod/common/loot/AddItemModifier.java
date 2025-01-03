package com.gmail.tamwyn.contact.TamwynsMod.common.loot;


import org.jetbrains.annotations.NotNull;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class AddItemModifier extends LootModifier{
    private final Item item;

    public static final MapCodec<AddItemModifier> CODEC =
       RecordCodecBuilder.mapCodec(
            inst -> codecStart(inst).and(ForgeRegistries.ITEMS.getCodec().fieldOf("item")
            .forGetter(m -> m.item)).apply(inst, AddItemModifier::new)); 

    public AddItemModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }


    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot,
            LootContext context) {
            for(LootItemCondition condition : this.conditions){
                if(!condition.test(context)){
                    return generatedLoot;
                }
            }
            generatedLoot.add(new ItemStack(item));
            return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }

}

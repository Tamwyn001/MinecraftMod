package com.gmail.tamwyn.contact.TamwynsMod.common.item;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;
import com.gmail.tamwyn.contact.TamwynsMod.common.block.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TamwynsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAMWYN_TAB =
        CREATIVE_MODE_TABS.register("tamwyn_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
            .title(Component.translatable("creative_tab.tamwyn_tab"))
            .displayItems((pParameter, pOutput) -> {
                pOutput.accept(ModItems.SAPPHIRE.get());
                pOutput.accept(ModItems.RAW_SAPPHIRE.get());
                pOutput.accept(ModItems.METAL_DETECTOR.get());
                pOutput.accept(ModItems.SAPPHIRE_STAFF.get());
                pOutput.accept(ModItems.PASSION_FRUIT.get());
                pOutput.accept(ModItems.FIRE_FLOWER.get());

                pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                pOutput.accept(ModBlocks.RAW_SAPPHIRE_ORE.get());
                pOutput.accept(ModBlocks.GOLDEN_SAPPHIRE_BLOCK.get());
                pOutput.accept(ModBlocks.EMERALD_SAPPHIRE_BLOCK.get());
                pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                
                pOutput.accept(ModBlocks.SAPPHIRE_BUTTON.get());
                pOutput.accept(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
                pOutput.accept(ModBlocks.SAPPHIRE_FENCE.get());
                pOutput.accept(ModBlocks.SAPPHIRE_FENCE_GATE.get());
                pOutput.accept(ModBlocks.SAPPHIRE_WALL.get());
                pOutput.accept(ModBlocks.SAPPHIRE_STAIRS.get());
                pOutput.accept(ModBlocks.SAPPHIRE_SLAB.get());
                pOutput.accept(ModBlocks.SAPPHIRE_DOOR.get());
                pOutput.accept(ModBlocks.SAPPHIRE_TRAPDOOR.get());




                //vanillia item dont requiere a get() method
                //pOutput.accept(Items.DIAMOND);
            })
            .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

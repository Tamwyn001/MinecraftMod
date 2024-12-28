package com.gmail.tamwyn.contact.TamwynsMod.common.block;

import java.util.function.Supplier;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;
import com.gmail.tamwyn.contact.TamwynsMod.common.block.custom.SoundBlock;
import com.gmail.tamwyn.contact.TamwynsMod.common.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = 
            DeferredRegister.create(ForgeRegistries.BLOCKS, TamwynsMod.MOD_ID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
       RegistryObject<T> toReturn = BLOCKS.register(name, block);
       registerBlockItem(name, toReturn);
       return toReturn;
    }

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", 
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                .sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_SAPPHIRE_ORE = registerBlock("raw_sapphire_ore", 
            () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .strength(2.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<SoundBlock> SOUND_BLOCK = registerBlock("sound_block", 
    () -> new SoundBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
        .sound(SoundType.AMETHYST)));
            

    public static final RegistryObject<Block> GOLDEN_SAPPHIRE_BLOCK = registerBlock("golden_sapphire_block", 
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));

    public static final RegistryObject<Block> EMERALD_SAPPHIRE_BLOCK = registerBlock("emerald_sapphire_block", 
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));
    

    //helper to associate a block with an item : register (and returns) the item associated with the block
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }


}

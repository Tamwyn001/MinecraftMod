package com.gmail.tamwyn.contact.TamwynsMod.common.block;

import java.util.function.Supplier;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;
import com.gmail.tamwyn.contact.TamwynsMod.common.block.custom.SoundBlock;
import com.gmail.tamwyn.contact.TamwynsMod.common.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
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

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block", 
            () -> new SoundBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                .sound(SoundType.BAMBOO)));
                    

    public static final RegistryObject<Block> GOLDEN_SAPPHIRE_BLOCK = registerBlock("golden_sapphire_block", 
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));

    public static final RegistryObject<Block> EMERALD_SAPPHIRE_BLOCK = registerBlock("emerald_sapphire_block", 
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));

    //* .noLootTable() is used to prevent the game from looking for a loot table for the block 
    


    public static final RegistryObject<Block> SAPPHIRE_STAIRS = registerBlock("sapphire_stairs", 
    () -> new StairBlock(ModBlocks.SAPPHIRE_BLOCK.get().defaultBlockState(),
             BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
             
    public static final RegistryObject<Block> SAPPHIRE_SLAB = registerBlock("sapphire_slab", 
    () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    
    //To add new block set type, ctrl clic on it, there you can for ex allow an activation by arrow
    public static final RegistryObject<Block> SAPPHIRE_BUTTON = registerBlock("sapphire_button", 
    () -> new ButtonBlock( BlockSetType.IRON, 20,
             BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> SAPPHIRE_PRESSURE_PLATE = registerBlock("sapphire_pressure_plate", 
    () -> new PressurePlateBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> SAPPHIRE_FENCE = registerBlock("sapphire_fence", 
    () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> SAPPHIRE_FENCE_GATE = registerBlock("sapphire_fence_gate", 
    () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST),
        SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));

    public static final RegistryObject<Block> SAPPHIRE_WALL = registerBlock("sapphire_wall", 
    () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    
    public static final RegistryObject<Block> SAPPHIRE_DOOR = registerBlock("sapphire_door", 
    () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
        .sound(SoundType.AMETHYST).noOcclusion()));

    public static final RegistryObject<Block> SAPPHIRE_TRAPDOOR = registerBlock("sapphire_trapdoor", 
    () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
        .sound(SoundType.AMETHYST).noOcclusion()));





    //helper to associate a block with an item : register (and returns) the item associated with the block
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }


}

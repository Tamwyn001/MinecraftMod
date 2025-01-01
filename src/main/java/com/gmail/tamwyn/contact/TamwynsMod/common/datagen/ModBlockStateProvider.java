package com.gmail.tamwyn.contact.TamwynsMod.common.datagen;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;
import com.gmail.tamwyn.contact.TamwynsMod.common.block.ModBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput gen, ExistingFileHelper exFileHelper) {
        super(gen, TamwynsMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.EMERALD_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.GOLDEN_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.RAW_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.SOUND_BLOCK);

        
        stairsBlock(((StairBlock)ModBlocks.SAPPHIRE_STAIRS.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        slabBlock(((SlabBlock)ModBlocks.SAPPHIRE_SLAB.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()),
            blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        buttonBlock(((ButtonBlock)ModBlocks.SAPPHIRE_BUTTON.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock)ModBlocks.SAPPHIRE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        fenceBlock(((FenceBlock)ModBlocks.SAPPHIRE_FENCE.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock)ModBlocks.SAPPHIRE_FENCE_GATE.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        wallBlock(((WallBlock)ModBlocks.SAPPHIRE_WALL.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock)ModBlocks.SAPPHIRE_DOOR.get()), modLoc("block/sapphire_door_bottom"),
            modLoc("block/sapphire_door_top"), "translucent");

        trapdoorBlockWithRenderType(((TrapDoorBlock)ModBlocks.SAPPHIRE_TRAPDOOR.get()), modLoc("block/sapphire_trapdoor"),
            true, "translucent");
 


    }

    //custom method to extend BlockStatePr ovider methods.
    // passes a block registry object and extends to the assicated item
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

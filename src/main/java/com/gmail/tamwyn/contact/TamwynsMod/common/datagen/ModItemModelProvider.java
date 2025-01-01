package com.gmail.tamwyn.contact.TamwynsMod.common.datagen;

import com.gmail.tamwyn.contact.TamwynsMod.common.TamwynsMod;
import com.gmail.tamwyn.contact.TamwynsMod.common.block.ModBlocks;
import com.gmail.tamwyn.contact.TamwynsMod.common.item.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput pOutput, ExistingFileHelper existingFileHelper) {
        super(pOutput, TamwynsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_SAPPHIRE);
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.PASSION_FRUIT);
        simpleItem(ModItems.FIRE_FLOWER);
        // simpleItem(ModItems.METAL_DETECTOR);
        simpleBlockItem(ModBlocks.SAPPHIRE_DOOR);

        handheldItem(ModItems.SAPPHIRE_AXE);
        handheldItem(ModItems.SAPPHIRE_HOE);
        handheldItem(ModItems.SAPPHIRE_PICKAXE);
        handheldItem(ModItems.SAPPHIRE_SHOVEL);
        handheldItem(ModItems.SAPPHIRE_SWORD);

        fenceInventory("sapphire_fence", modLoc("block/sapphire_block"));
        buttonInventory("sapphire_button", modLoc("block/sapphire_block"));
        wallInventory("sapphire_wall", modLoc("block/sapphire_block"));
        trapdoorBottom("sapphire_trapdoor", modLoc("block/sapphire_trapdoor"));
        pressurePlate("sapphire_pressure_plate", modLoc("block/sapphire_block"));
        stairs("sapphire_stairs", modLoc("block/sapphire_block"), modLoc("block/sapphire_block"), modLoc("block/sapphire_block"));
        fenceGate("sapphire_fence_gate", modLoc("block/sapphire_block"));
        slab("sapphire_slab", modLoc("block/sapphire_block"), modLoc("block/sapphire_block"), modLoc("block/sapphire_block"));
        
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(), 
                new ResourceLocation("item/generated"))
            .texture("layer0", new ResourceLocation( TamwynsMod.MOD_ID, "item/"
                 + item.getId().getPath()));
    }


    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TamwynsMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(TamwynsMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}

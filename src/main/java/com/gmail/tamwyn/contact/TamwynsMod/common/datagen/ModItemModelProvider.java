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

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TamwynsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_SAPPHIRE);
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.PASSION_FRUIT);
        simpleItem(ModItems.FIRE_FLOWER);

        simpleBlockItem(ModBlocks.SAPPHIRE_DOOR);

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

    // public void trapdoorItem(RegistryObject<Block> block) {
    //     this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
    //             modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    // }

    // public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
    //     this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
    //             .texture("texture",  new ResourceLocation(TamwynsMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    // }

    // public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
    //     this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
    //             .texture("texture",  new ResourceLocation(TamwynsMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    // }

    // public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
    //     this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
    //             .texture("wall",  new ResourceLocation(TamwynsMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    // }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TamwynsMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}

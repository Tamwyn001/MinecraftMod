package com.gmail.tamwyn.contact.TamwynsMod.common.item.custom;

import java.util.List;

import com.gmail.tamwyn.contact.TamwynsMod.common.util.ModTags;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item{

    RandomSource random = RandomSource.create();
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide){
            BlockPos positionClicked = pContext.getClickedPos();
            Player  player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++){
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if(isValuableBlock(state)){
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }


            }
            if (!foundBlock){
                player.sendSystemMessage(Component.literal("No valuables found."));
                spawnParticles(positionClicked,pContext.getLevel() ,ParticleTypes.SMOKE); // TODO needs to call the particles on client side
            }
            else{
                spawnParticles(positionClicked, pContext.getLevel() ,ParticleTypes.HAPPY_VILLAGER);
            }

        }
        //affect the durability of the item.. on both sides?
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), EquipmentSlot.MAINHAND);
        return InteractionResult.SUCCESS;

    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block){
        player.sendSystemMessage(Component.literal("Found "+ I18n.get(block.getDescriptionId()) + " at ("
                + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }


    private boolean isValuableBlock(BlockState pState){

        return pState.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }

    private void spawnParticles(BlockPos position, Level pLevel ,ParticleOptions particleType) {
        if (pLevel.isClientSide()) { // Ensure this runs only on the client side
            for (int i = 0; i < 5; i++) { // Example number of particles
                double offsetX = position.getX() + 0.5 + (Math.random() - 0.5);
                double offsetY = position.getY() + 0.5 + (Math.random() - 0.5);
                double offsetZ = position.getZ() + 0.5 + (Math.random() - 0.5);
    
                pLevel.addParticle(particleType, offsetX, offsetY, offsetZ, 0, 0.2, 0);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("item.tamwynsmod.metal_detector.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}


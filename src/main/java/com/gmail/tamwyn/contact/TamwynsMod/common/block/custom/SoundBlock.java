package com.gmail.tamwyn.contact.TamwynsMod.common.block.custom;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SoundBlock extends Block {
    public SoundBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override

    public ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        int n = UniformInt.of(0, 2).sample(pLevel.random);
        SoundEvent soundEvent;
        ParticleOptions type = ParticleTypes.NOTE;
        BlockPos blockPos = pHitResult.getBlockPos();
        float noteColor;
        if (n == 0) {
            soundEvent = SoundEvents.NOTE_BLOCK_DIDGERIDOO.get();
            noteColor = 0.5f;
        } else if (n == 1) {
            soundEvent = SoundEvents.NOTE_BLOCK_BANJO.get();
            noteColor = 0.75f;
        } else {
            soundEvent = SoundEvents.NOTE_BLOCK_SNARE.get();
            noteColor = 1f;
        }
        pLevel.playSound(pPlayer, pPos, soundEvent, SoundSource.BLOCKS,
                1f, 1f);

        //TODO inplement the particle color for the note
        
        Minecraft.getInstance().level.addParticle(
            type,  // The particle type
            blockPos.getX() + 0.5f ,           // X coordinate
            blockPos.getY() + 1.25f,                    // Y coordinate
            blockPos.getZ() + 0.5f ,           // Z coordinate
            0.0,                  // Velocity in X direction
            0.2,                  // Velocity in Y direction
            0.0                   // Velocity in Z direction
        );
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("block.tamwynsmod.sound_block.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}

package com.gmail.tamwyn.contact.TamwynsMod.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SoundBlock extends Block {
    public SoundBlock(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, net.minecraft.world.entity.Entity entity) {
        //this is properly fired
        System.out.println("Entity stepped on block!");
        super.stepOn(level, pos, state, entity);
    }
    // this is not found in the super..
    // @Override
    // public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
    //                              Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
    //     pLevel.playSound(pPlayer, pPos, SoundEvents.NOTE_BLOCK_DIDGERIDOO.get(), SoundSource.BLOCKS,
    //             1f, 1f);
    //     return InteractionResult.SUCCESS;
    // }
}

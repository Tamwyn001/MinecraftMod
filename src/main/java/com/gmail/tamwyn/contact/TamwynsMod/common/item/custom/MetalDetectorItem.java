package com.gmail.tamwyn.contact.TamwynsMod.common.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item{
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
                spawnParticles(positionClicked, ParticleTypes.SMOKE);
            }
            else{
                spawnParticles(positionClicked, ParticleTypes.HAPPY_VILLAGER);
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

        return pState.is(Blocks.IRON_ORE);
    }

    private void spawnParticles(BlockPos blockPos, ParticleOptions type){

            Minecraft.getInstance().level.addParticle(
            type,  // The particle type
            blockPos.getX() + 0.5f,           // X coordinate
            blockPos.getY() + 0.5f,           // Y coordinate
            blockPos.getZ() + 0.25f,           // Z coordinate
            0.0,                  // Velocity in X direction
            0.1,                  // Velocity in Y direction
            0.0                   // Velocity in Z direction
        );
    }

}


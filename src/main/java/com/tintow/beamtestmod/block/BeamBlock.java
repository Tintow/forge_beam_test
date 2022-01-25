package com.tintow.beamtestmod.block;

import com.tintow.beamtestmod.blockentities.BeamBlockEntity;
import com.tintow.beamtestmod.blockentities.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEventListener;
import org.jetbrains.annotations.Nullable;

public class BeamBlock extends BaseEntityBlock {

    public BeamBlock(Properties builder){
        super(builder);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return ModBlockEntities.BEAM_BLOCK_ENTITY.get().create(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModBlockEntities.BEAM_BLOCK_ENTITY.get(), BeamBlockEntity::tick);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> GameEventListener getListener(Level pLevel, T pBlockEntity) {
        return super.getListener(pLevel, pBlockEntity);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
}

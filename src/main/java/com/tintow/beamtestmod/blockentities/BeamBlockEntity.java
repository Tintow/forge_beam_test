package com.tintow.beamtestmod.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class BeamBlockEntity extends BlockEntity {

    private static final boolean SHOW_BEAM = true;
    private static final int MAX_RENDER_Y = 1024;

    public BeamBlockEntity(BlockPos pos, BlockState state){
        super(ModBlockEntities.BEAM_BLOCK_ENTITY.get(), pos, state);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, BeamBlockEntity pBlockEntity) {
    }

    @Override
    public AABB getRenderBoundingBox() {
        BlockPos pos = this.worldPosition;
        BlockPos toppos = this.worldPosition;
        toppos = toppos.above(MAX_RENDER_Y - pos.getY());
        AABB aabb = new AABB(pos, toppos);
        return aabb;
    }
}

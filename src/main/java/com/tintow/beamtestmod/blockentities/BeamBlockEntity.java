package com.tintow.beamtestmod.blockentities;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BeamBlockEntity extends BlockEntity {

    private static final boolean SHOW_BEAM = true;
    List<BeamBlockEntity.BeamSection> beamSections = Lists.newArrayList();


    public BeamBlockEntity(BlockPos pos, BlockState state){
        super(ModBlockEntities.BEAM_BLOCK_ENTITY.get(), pos, state);
        generateBeamSections(pos);
    }

    private void generateBeamSections(BlockPos pos) {
        //Multiple sections can be added and each section can be a different colour
        //The final section will continue to max build height.
        //A single section just means the beam remains the same colour it's full length
        float[] pColor = new float[]{(float) 255 / 255.0F, (float) 235 / 255.0F, (float) 255 / 255.0F};
        BeamBlockEntity.BeamSection section = new BeamSection(pColor);
        this.beamSections.add(section);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, BeamBlockEntity pBlockEntity) {
    }

    public List<BeamSection> getBeamSections() {
        return (List<BeamBlockEntity.BeamSection>) (SHOW_BEAM ? this.beamSections : ImmutableList.of());
    }


    public static class BeamSection {
        /** RGB (0 to 1.0) colors of this beam segment */
        final float[] color;
        private int height;

        public BeamSection(float[] pColor) {
            this.color = pColor;
            this.height = 1;
        }

        protected void increaseHeight() {
            ++this.height;
        }

        /**
         * @return RGB (0 to 1.0) colors of this beam segment
         */
        public float[] getColor() {
            return this.color;
        }

        public int getHeight() {
            return this.height;
        }
    }

}

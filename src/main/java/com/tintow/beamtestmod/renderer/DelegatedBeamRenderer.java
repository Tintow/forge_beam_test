package com.tintow.beamtestmod.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.tintow.beamtestmod.blockentities.BeamBlockEntity;
import com.tintow.beamtestmod.blockentities.ModBlockEntities;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BeaconRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.resources.ResourceLocation;

public class DelegatedBeamRenderer implements BlockEntityRenderer<BeamBlockEntity> {
    private static final ResourceLocation BEAM_LOCATION = new ResourceLocation("textures/entity/end_gateway_beam.png");

    public DelegatedBeamRenderer(BlockEntityRendererProvider.Context pContext) {}

    @Override
    public void render(BeamBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        long gameTime = pBlockEntity.getLevel().getGameTime();
        int maxBuildHeight = pBlockEntity.getLevel().getMaxBuildHeight();
        float[] pColor = new float[]{(float) 255 / 255.0F, (float) 135 / 255.0F, (float) 255 / 255.0F};

        BeaconRenderer.renderBeaconBeam(pPoseStack, pBufferSource, BEAM_LOCATION, pPartialTick, 1.0f, gameTime, 1, maxBuildHeight, pColor, 0.15F, 0.175F);
    }


    public int getViewDistance() {
        return 256;
    }

    public static void register(){
        BlockEntityRenderers.register(ModBlockEntities.BEAM_BLOCK_ENTITY.get(), DelegatedBeamRenderer::new);
    }


}
package com.tintow.beamtestmod.blockentities;

import com.tintow.beamtestmod.BeamTestMod;
import com.tintow.beamtestmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
          DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, BeamTestMod.MOD_ID);

    public static RegistryObject<BlockEntityType<BeamBlockEntity>> BEAM_BLOCK_ENTITY =
          BLOCK_ENTITIES.register("beam_block",
                ()-> BlockEntityType.Builder.of(BeamBlockEntity::new,
                      ModBlocks.BEAM_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus){ BLOCK_ENTITIES.register(eventBus);}
}

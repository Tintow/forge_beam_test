package com.tintow.beamtestmod.block;

import com.tintow.beamtestmod.BeamTestMod;
import com.tintow.beamtestmod.item.ModItemGroup;
import com.tintow.beamtestmod.item.ModItems;
import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BeamTestMod.MOD_ID);

    public static final RegistryObject<Block> BEAM_BLOCK = registerBlock("beam_block",
          () -> new BeamBlock(BlockBehaviour.Properties.of(Material.METAL)
                .sound(SoundType.METAL)
          ));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name,
              () -> new BlockItem(block.get(), new Item.Properties().tab(ModItemGroup.TINTOW_GROUP)));


}

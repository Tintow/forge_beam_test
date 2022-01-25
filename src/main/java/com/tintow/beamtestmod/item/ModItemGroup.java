package com.tintow.beamtestmod.item;


import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModItemGroup {
    //This is a group to create our own Tab on the Creative gui

    public static CreativeModeTab TINTOW_GROUP = new CreativeModeTab("beamtest") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.BEACON);
        }

    };
}
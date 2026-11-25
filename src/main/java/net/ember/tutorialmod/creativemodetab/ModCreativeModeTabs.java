package net.ember.tutorialmod.creativemodetab;

import net.ember.tutorialmod.TutorialMod;
import net.ember.tutorialmod.blocks.ModBlocks;
import net.ember.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {

    public static final CreativeModeTab AETHERITE_ITEM_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID , "aetherite_items"),
            FabricCreativeModeTab.builder()
                    .icon(()->new ItemStack(ModItems.AETHERITE_INGOT))
                    .title(Component.translatable("creativemodetab.tutorialmod.aetherite_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.RAW_AETHERITE);
                        output.accept(ModItems.AETHERITE_INGOT);
                        output.accept(ModItems.INFUSED_AETHERITE_CORE);
                        output.accept(ModBlocks.AETHERITE_BLOCK);
                        output.accept(ModBlocks.RAW_AETHERITE_BLOCK);
                    })
                    .build()
            );

    public static final CreativeModeTab RESONANCE_ITEM_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID , "resonance_items"),
            FabricCreativeModeTab.builder()
                    .icon(()->new ItemStack(ModItems.RESONANCE_SHARD))
                    .title(Component.translatable("creativemodetab.tutorialmod.resonance_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.RAW_RESONANCE_SHARD);
                        output.accept(ModItems.RESONANCE_SHARD);
                    })
                    .build()
    );


    public static void registerModCreativeTabs(){
        TutorialMod.LOGGER.info("Registering the creative mode tabs for " + TutorialMod.MOD_ID);
    }



}

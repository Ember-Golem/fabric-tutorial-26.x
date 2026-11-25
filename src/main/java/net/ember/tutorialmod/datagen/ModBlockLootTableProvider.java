package net.ember.tutorialmod.datagen;

import net.ember.tutorialmod.blocks.ModBlocks;
import net.ember.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.AETHERITE_BLOCK);
        dropSelf(ModBlocks.RAW_AETHERITE_BLOCK);
        add(ModBlocks.AETHERITE_ORE,createOreDrop(ModBlocks.AETHERITE_BLOCK, ModItems.RAW_AETHERITE));
        add(ModBlocks.DEEPSLATE_AETHERITE_ORE,createOreDrop(ModBlocks.DEEPSLATE_AETHERITE_ORE, ModItems.RAW_AETHERITE));
        add(ModBlocks.RESONANCE_ORE,createOreDrop(ModBlocks.RESONANCE_ORE, ModItems.RAW_RESONANCE_SHARD));
        add(ModBlocks.DEEPSLATE_RESONANCE_ORE,createOreDrop(ModBlocks.DEEPSLATE_RESONANCE_ORE, ModItems.RAW_RESONANCE_SHARD));
    }
}

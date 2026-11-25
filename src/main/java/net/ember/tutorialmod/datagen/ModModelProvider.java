package net.ember.tutorialmod.datagen;

import net.ember.tutorialmod.blocks.ModBlocks;
import net.ember.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {


    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.AETHERITE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.RAW_AETHERITE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.AETHERITE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_AETHERITE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.RESONANCE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_RESONANCE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.RESONANCE_SHARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_RESONANCE_SHARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_AETHERITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.AETHERITE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.INFUSED_AETHERITE_CORE, ModelTemplates.FLAT_ITEM);

    }
}

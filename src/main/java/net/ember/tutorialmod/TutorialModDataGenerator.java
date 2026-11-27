package net.ember.tutorialmod;

import net.ember.tutorialmod.datagen.ModBlockLootTableProvider;
import net.ember.tutorialmod.datagen.ModBlockTagsProvider;
import net.ember.tutorialmod.datagen.ModModelProvider;
import net.ember.tutorialmod.datagen.ModRecipieProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.client.data.models.ModelProvider;

public class TutorialModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipieProvider::new);

	}
}

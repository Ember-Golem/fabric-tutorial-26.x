package net.ember.tutorialmod.datagen;

import net.ember.tutorialmod.blocks.ModBlocks;
import net.ember.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipieProvider extends FabricRecipeProvider {
    public ModRecipieProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries,output) {
            @Override
            public void buildRecipes() {
                List<ItemLike>AETHERITE_SMELTABLES = List.of(ModItems.RAW_AETHERITE, ModBlocks.AETHERITE_ORE,ModBlocks.DEEPSLATE_AETHERITE_ORE);
                oreSmelting(AETHERITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS,ModItems.AETHERITE_INGOT,0.25f,200,"aetherite");
                oreBlasting(AETHERITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS,ModItems.AETHERITE_INGOT,0.25f,100,"aetherite");

                List<ItemLike>RESONANCE_SMELTABLES = List.of(ModItems.RAW_RESONANCE_SHARD,ModBlocks.RESONANCE_ORE,ModBlocks.DEEPSLATE_RESONANCE_ORE);
                oreSmelting(RESONANCE_SMELTABLES, RecipeCategory.MISC,CookingBookCategory.BLOCKS,ModItems.RESONANCE_SHARD,0.25f,200,"resonance");
                oreBlasting(RESONANCE_SMELTABLES, RecipeCategory.MISC,CookingBookCategory.BLOCKS,ModItems.RESONANCE_SHARD,0.25f,100,"resonance");

                nineBlockStorageRecipes(RecipeCategory.MISC,ModItems.AETHERITE_INGOT,RecipeCategory.BUILDING_BLOCKS,ModBlocks.AETHERITE_BLOCK);

                shaped(RecipeCategory.MISC,ModBlocks.RAW_AETHERITE_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R',ModItems.RAW_AETHERITE)
                        .unlockedBy(getHasName(ModItems.RAW_AETHERITE),has(ModItems.RAW_AETHERITE))
                        .group("aetherite")
                        .save(output);

                shaped(RecipeCategory.TOOLS,ModItems.CHISEL)
                        .pattern(" R")
                        .pattern("B ")
                        .define('R',ModItems.RESONANCE_SHARD)
                        .define('B',ModItems.AETHERITE_INGOT)
                        .unlockedBy(getHasName(ModItems.AETHERITE_INGOT),has(ModItems.AETHERITE_INGOT))
                        .group("aetherite")
                        .save(output);

                shapeless(RecipeCategory.MISC,ModItems.RAW_AETHERITE,9)
                        .requires(ModBlocks.RAW_AETHERITE_BLOCK)
                        .unlockedBy(getHasName(ModItems.RAW_AETHERITE),has(ModItems.RAW_AETHERITE))
                        .group("aetherite")
                        .save(output);



            }
        };
    }

    @Override
    public String getName() {
        return "TutoriaMod Recipies";
    }
}

package net.ember.tutorialmod.blocks;

import com.mojang.datafixers.types.Func;
import net.ember.tutorialmod.TutorialMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {

    public static final Block AETHERITE_BLOCK = registerBlock("aetherite_block",properties -> new Block(properties
            .strength(4f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.NETHERITE_BLOCK)));

    public static final Block RAW_AETHERITE_BLOCK = registerBlock("raw_aetherite_block",properties -> new Block(properties
            .strength(3f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.ANCIENT_DEBRIS)));

    private static Block registerBlock(String name , Function<BlockBehaviour.Properties,Block>function){

        Block toregister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID,name))));
        registerBlockItem(name,toregister);
        return Registry.register(BuiltInRegistries.BLOCK,Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID,name),toregister);

    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(
                BuiltInRegistries.ITEM ,
                Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name),
                new BlockItem(block,new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID,name))))
                );
    }
    public static void registerModBlocks (){
        TutorialMod.LOGGER.info("Registering Mod Block for " + TutorialMod.MOD_ID);

    }



}

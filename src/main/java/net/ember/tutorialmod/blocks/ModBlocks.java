package net.ember.tutorialmod.blocks;

import com.mojang.datafixers.types.Func;
import net.ember.tutorialmod.TutorialMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
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

    public static final Block AETHERITE_ORE = registerBlock("aetherite_ore",properties -> new DropExperienceBlock(new UniformInt(2,5),properties
            .strength(3f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE)));

    public static final Block DEEPSLATE_AETHERITE_ORE = registerBlock("deepslate_aetherite_ore",properties -> new DropExperienceBlock(new UniformInt(3,6),properties
            .strength(4f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.DEEPSLATE)));

    public static final Block RESONANCE_ORE = registerBlock("resonance_ore",properties -> new DropExperienceBlock(new UniformInt(2,5),properties
            .strength(3f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE)));

    public static final Block DEEPSLATE_RESONANCE_ORE = registerBlock("deepslate_resonance_ore",properties -> new DropExperienceBlock(new UniformInt(3,6),properties
            .strength(4f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.DEEPSLATE)));


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

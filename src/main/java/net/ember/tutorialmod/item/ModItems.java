package net.ember.tutorialmod.item;

import net.ember.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {

    public static final Item RESONANCE_SHARD = registeritem("resonance_shard", Item::new);
    public static final Item RAW_RESONANCE_SHARD = registeritem("raw_resonance_shard", Item::new);
    public static final Item AETHERITE_INGOT = registeritem("aetherite_ingot", Item::new);
    public static final Item RAW_AETHERITE = registeritem("raw_aetherite", Item::new);
    public static final Item INFUSED_AETHERITE_CORE = registeritem("infused_aetherite_core", Item::new);






    private static Item registeritem(String name, Function<Item.Properties , Item> function){
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name)))));
    }


    public static void registerModItems(){

        TutorialMod.LOGGER.info("Registering Mod items for " + TutorialMod.MOD_ID);


        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(RESONANCE_SHARD);
            output.accept(RAW_RESONANCE_SHARD);
            output.accept(AETHERITE_INGOT);
            output.accept(RAW_AETHERITE);
            output.accept(INFUSED_AETHERITE_CORE);
        });
    }
}

package net.ember.tutorialmod.item.custom;

import net.ember.tutorialmod.item.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class ChiselItem extends Item {

    private ItemStack findResonanceShard(Player player) {
        Inventory inventory = player.getInventory();
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack stack = inventory.getItem(i);
            if (stack.is(ModItems.RESONANCE_SHARD)) {
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }
    public ChiselItem(Properties properties) {
        super(properties);
    }

    private static final Map<Block, Block> CHISEL_MAP = Map.ofEntries(
            Map.entry(Blocks.STONE, Blocks.STONE_BRICKS),
            Map.entry(Blocks.DIRT, Blocks.COARSE_DIRT),
            Map.entry(Blocks.END_STONE, Blocks.END_STONE_BRICKS),
            Map.entry(Blocks.NETHERRACK, Blocks.NETHER_BRICKS),
            Map.entry(Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS),
            Map.entry(Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE),
            Map.entry(Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN),
            Map.entry(Blocks.DIAMOND_ORE, Blocks.EMERALD_ORE),
            Map.entry(Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE_EMERALD_ORE),
            Map.entry(Blocks.IRON_BLOCK, Blocks.GOLD_BLOCK),
            Map.entry(Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE_TILES)
    );

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if (player != null && CHISEL_MAP.containsKey(clickedBlock)) {
            ItemStack shardStack = findResonanceShard(player);

            // Stop here if they don't have a shard AND aren't in Creative mode
            if (shardStack.isEmpty() && !player.getAbilities().instabuild) {
                return InteractionResult.FAIL;
            }

            if (!level.isClientSide()) {
                // 1. Transform the block
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                // 2. Consume 1 Resonance Shard (if not in Creative mode)
                if (!player.getAbilities().instabuild) {
                    shardStack.shrink(1);
                }

                // 3. Damage the chisel durability
                context.getItemInHand().hurtAndBreak(1, player, context.getHand());
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}

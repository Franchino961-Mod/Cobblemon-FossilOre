package com.fossilore;

import com.fossilore.config.ModConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all Fossil Ore blocks.
 * Each subtype passes its fossil pool via the constructor.
 *
 * Subclasses:
 * - MarineFossilOreBlock
 * - TerrestrialFossilOreBlock
 * - AncientFossilOreBlock
 */
public abstract class FossilOreBlock extends Block {

    private final String[] fossilPool;

    protected FossilOreBlock(Settings settings, String[] fossilPool) {
        super(settings);
        this.fossilPool = fossilPool;
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state,
            net.minecraft.loot.context.LootContextParameterSet.Builder builder) {

        List<ItemStack> drops = new ArrayList<>();

        // Use world random for thread-safety
        net.minecraft.util.math.random.Random random = (builder.getWorld() instanceof ServerWorld sw) ? sw.getRandom()
                : net.minecraft.util.math.random.Random.create();

        ItemStack tool = (builder.getWorld() instanceof ServerWorld)
                ? builder.getOptional(net.minecraft.loot.context.LootContextParameters.TOOL)
                : null;

        if (tool != null && !tool.isEmpty()) {
            // Silk Touch → drop the block itself
            if (hasSilkTouch(tool)) {
                drops.add(new ItemStack(this));
                return drops;
            }

            int fortuneLevel = getFortuneLevel(tool);
            int fossilCount = 1;

            if (fortuneLevel > 0) {
                double chance = ModConfig.getInstance().getFortuneChance(fortuneLevel);
                if (random.nextDouble() < chance) {
                    fossilCount = 2;
                }
            }

            for (int i = 0; i < fossilCount; i++) {
                addRandomFossil(drops, random);
            }
        } else {
            // No tool (e.g. creative, explosion)
            addRandomFossil(drops, random);
        }

        return drops;
    }

    private void addRandomFossil(List<ItemStack> drops, net.minecraft.util.math.random.Random random) {
        String fossilName = fossilPool[random.nextInt(fossilPool.length)];
        ItemStack stack = getFossilItemStack(fossilName);
        if (!stack.isEmpty()) {
            drops.add(stack);
        }
    }

    private ItemStack getFossilItemStack(String fossilName) {
        Identifier fossilId = Identifier.of("cobblemon", fossilName);
        return Registries.ITEM.getOrEmpty(fossilId)
                .map(ItemStack::new)
                .orElseGet(() -> {
                    FossilOre.LOGGER.warn("Fossil item not found in registry: cobblemon:{}", fossilName);
                    return ItemStack.EMPTY;
                });
    }

    private boolean hasSilkTouch(ItemStack tool) {
        for (RegistryEntry<Enchantment> entry : tool.getEnchantments().getEnchantments()) {
            if (entry.matchesKey(Enchantments.SILK_TOUCH))
                return true;
        }
        return false;
    }

    private int getFortuneLevel(ItemStack tool) {
        for (RegistryEntry<Enchantment> entry : tool.getEnchantments().getEnchantments()) {
            if (entry.matchesKey(Enchantments.FORTUNE)) {
                return tool.getEnchantments().getLevel(entry);
            }
        }
        return 0;
    }
}
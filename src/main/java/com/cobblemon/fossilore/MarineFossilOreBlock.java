package com.cobblemon.fossilore;

import com.cobblemon.fossilore.config.ModConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.registry.Registries;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Marine Fossil Ore - Found in ocean/river biomes on seafloor
 * Drops aquatic/marine prehistoric Pokémon fossils
 */
public class MarineFossilOreBlock extends Block {
    private static final Random RANDOM = new Random();
    
    // 5 marine/aquatic fossils
    private static final String[] MARINE_FOSSILS = {
        "dome_fossil",      // Kabuto - Trilobite
        "helix_fossil",     // Omanyte - Ammonite
        "cover_fossil",     // Tirtouga - Sea turtle
        "root_fossil",      // Lileep - Crinoid
        "fossilized_fish"   // Dracozolt - Electric fish
    };

    public MarineFossilOreBlock(Settings settings) {
        super(settings);
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, net.minecraft.loot.context.LootContextParameterSet.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();
        ItemStack tool = builder.getWorld() instanceof ServerWorld ? 
            builder.getOptional(net.minecraft.loot.context.LootContextParameters.TOOL) : null;

        if (tool != null) {
            // Check for Silk Touch
            if (hasSilkTouch(tool)) {
                drops.add(new ItemStack(this));
                return drops;
            }

            // Get Fortune level
            int fortuneLevel = getFortuneLevel(tool);
            
            // Calculate number of fossils to drop (1 base + chance for 1 extra with Fortune)
            int fossilCount = 1;
            if (fortuneLevel > 0) {
                double chance = ModConfig.getInstance().getFortuneChance(fortuneLevel);
                if (RANDOM.nextDouble() < chance) {
                    fossilCount = 2;
                }
            }
            
            // Add random marine fossils
            for (int i = 0; i < fossilCount; i++) {
                String randomFossil = MARINE_FOSSILS[RANDOM.nextInt(MARINE_FOSSILS.length)];
                ItemStack fossilStack = getFossilItemStack(randomFossil);
                if (!fossilStack.isEmpty()) {
                    drops.add(fossilStack);
                }
            }
        } else {
            // Default drop (no tool or creative mode)
            String randomFossil = MARINE_FOSSILS[RANDOM.nextInt(MARINE_FOSSILS.length)];
            ItemStack fossilStack = getFossilItemStack(randomFossil);
            if (!fossilStack.isEmpty()) {
                drops.add(fossilStack);
            }
        }

        return drops;
    }

    private ItemStack getFossilItemStack(String fossilName) {
        try {
            Identifier fossilId = Identifier.of("cobblemon", fossilName);
            var item = Registries.ITEM.get(fossilId);
            if (item != null) {
                return new ItemStack(item);
            }
        } catch (Exception e) {
            CobblemonFossilOre.LOGGER.error("Failed to get fossil item: " + fossilName, e);
        }
        return ItemStack.EMPTY;
    }

    private boolean hasSilkTouch(ItemStack tool) {
        for (RegistryEntry<Enchantment> entry : tool.getEnchantments().getEnchantments()) {
            if (entry.matchesKey(Enchantments.SILK_TOUCH)) {
                return true;
            }
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

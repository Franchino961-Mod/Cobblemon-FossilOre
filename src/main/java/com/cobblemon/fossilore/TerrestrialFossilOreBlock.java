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
 * Terrestrial Fossil Ore - Found in stone layer (Y 8-64) in non-aquatic, non-desert biomes
 * Drops terrestrial dinosaur and predator fossils
 */
public class TerrestrialFossilOreBlock extends Block {
    private static final Random RANDOM = new Random();
    
    // 5 terrestrial/ground dinosaur fossils
    private static final String[] TERRESTRIAL_FOSSILS = {
        "skull_fossil",      // Cranidos - Pachycephalosaurus
        "armor_fossil",      // Shieldon - Armored dinosaur
        "jaw_fossil",        // Tyrunt - T-Rex predator
        "sail_fossil",       // Amaura - Ice age dinosaur
        "fossilized_dino"    // Arctovish - Hybrid dinosaur
    };

    public TerrestrialFossilOreBlock(Settings settings) {
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
            
            // Add random terrestrial fossils
            for (int i = 0; i < fossilCount; i++) {
                String randomFossil = TERRESTRIAL_FOSSILS[RANDOM.nextInt(TERRESTRIAL_FOSSILS.length)];
                ItemStack fossilStack = getFossilItemStack(randomFossil);
                if (!fossilStack.isEmpty()) {
                    drops.add(fossilStack);
                }
            }
        } else {
            // Default drop (no tool or creative mode)
            String randomFossil = TERRESTRIAL_FOSSILS[RANDOM.nextInt(TERRESTRIAL_FOSSILS.length)];
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

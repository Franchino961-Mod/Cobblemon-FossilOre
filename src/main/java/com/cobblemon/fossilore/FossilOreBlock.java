package com.cobblemon.fossilore;

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

public class FossilOreBlock extends Block {
    private static final Random RANDOM = new Random();
    
    // Lista di tutti i 15 fossili di Cobblemon
    private static final String[] COBBLEMON_FOSSILS = {
        "armor_fossil",
        "claw_fossil", 
        "cover_fossil",
        "dome_fossil",
        "fossilized_bird",
        "fossilized_dino",
        "fossilized_drake",
        "fossilized_fish",
        "helix_fossil",
        "jaw_fossil",
        "old_amber",
        "plume_fossil",
        "root_fossil",
        "sail_fossil",
        "skull_fossil"
    };

    public FossilOreBlock(Settings settings) {
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
                // 50% chance per Fortune level to get 1 extra fossil (max 2 total)
                if (RANDOM.nextInt(100) < (fortuneLevel * 33)) {
                    fossilCount = 2;
                }
            }
            
            // Add random fossils
            for (int i = 0; i < fossilCount; i++) {
                String randomFossil = COBBLEMON_FOSSILS[RANDOM.nextInt(COBBLEMON_FOSSILS.length)];
                ItemStack fossilStack = getFossilItemStack(randomFossil);
                if (!fossilStack.isEmpty()) {
                    drops.add(fossilStack);
                }
            }
        } else {
            // Default drop (no tool or creative mode)
            String randomFossil = COBBLEMON_FOSSILS[RANDOM.nextInt(COBBLEMON_FOSSILS.length)];
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

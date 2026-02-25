package com.cobblemon.fossilore;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    // New thematic ore blocks
    public static final Block MARINE_FOSSIL_ORE = registerBlock("marine_fossil_ore",
            new MarineFossilOreBlock(AbstractBlock.Settings.create()
                    .strength(3.0f, 3.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block TERRESTRIAL_FOSSIL_ORE = registerBlock("terrestrial_fossil_ore",
            new TerrestrialFossilOreBlock(AbstractBlock.Settings.create()
                    .strength(3.0f, 3.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block ANCIENT_FOSSIL_ORE = registerBlock("ancient_fossil_ore",
            new AncientFossilOreBlock(AbstractBlock.Settings.create()
                    .strength(3.0f, 3.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CobblemonFossilOre.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(CobblemonFossilOre.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void register() {
        CobblemonFossilOre.LOGGER.info("Registering blocks for " + CobblemonFossilOre.MOD_ID);
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(MARINE_FOSSIL_ORE);
            entries.add(TERRESTRIAL_FOSSIL_ORE);
            entries.add(ANCIENT_FOSSIL_ORE);
        });
    }
}

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
    public static final Block FOSSIL_ORE = registerBlock("fossil_ore",
            new FossilOreBlock(AbstractBlock.Settings.create()
                    .strength(3.0f, 3.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block DEEPSLATE_FOSSIL_ORE = registerBlock("deepslate_fossil_ore",
            new FossilOreBlock(AbstractBlock.Settings.create()
                    .strength(4.5f, 3.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));

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
            entries.add(FOSSIL_ORE);
            entries.add(DEEPSLATE_FOSSIL_ORE);
        });
    }
}

package com.cobblemon.fossilore.world;

import com.cobblemon.fossilore.CobblemonFossilOre;
import com.cobblemon.fossilore.ModBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

public class ModOreGeneration {
    public static final RegistryKey<net.minecraft.world.gen.feature.ConfiguredFeature<?, ?>> FOSSIL_ORE_CONFIGURED = 
        RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, 
            Identifier.of(CobblemonFossilOre.MOD_ID, "fossil_ore"));
    
    public static final RegistryKey<net.minecraft.world.gen.feature.PlacedFeature> FOSSIL_ORE_PLACED = 
        RegistryKey.of(RegistryKeys.PLACED_FEATURE, 
            Identifier.of(CobblemonFossilOre.MOD_ID, "fossil_ore"));

    public static void register() {
        CobblemonFossilOre.LOGGER.info("Registering ore generation for " + CobblemonFossilOre.MOD_ID);
        
        // Add ore to all overworld biomes
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            FOSSIL_ORE_PLACED
        );
    }
}

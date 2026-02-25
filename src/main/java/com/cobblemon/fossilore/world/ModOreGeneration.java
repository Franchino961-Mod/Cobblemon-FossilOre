package com.cobblemon.fossilore.world;

import com.cobblemon.fossilore.CobblemonFossilOre;
import com.cobblemon.fossilore.ModBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

public class ModOreGeneration {

    // New thematic ores
    public static final RegistryKey<net.minecraft.world.gen.feature.ConfiguredFeature<?, ?>> MARINE_FOSSIL_ORE_CONFIGURED = 
        RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, 
            Identifier.of(CobblemonFossilOre.MOD_ID, "marine_fossil_ore"));
    
    public static final RegistryKey<net.minecraft.world.gen.feature.PlacedFeature> MARINE_FOSSIL_ORE_PLACED = 
        RegistryKey.of(RegistryKeys.PLACED_FEATURE, 
            Identifier.of(CobblemonFossilOre.MOD_ID, "marine_fossil_ore"));

    public static final RegistryKey<net.minecraft.world.gen.feature.ConfiguredFeature<?, ?>> TERRESTRIAL_FOSSIL_ORE_CONFIGURED = 
        RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, 
            Identifier.of(CobblemonFossilOre.MOD_ID, "terrestrial_fossil_ore"));
    
    public static final RegistryKey<net.minecraft.world.gen.feature.PlacedFeature> TERRESTRIAL_FOSSIL_ORE_PLACED = 
        RegistryKey.of(RegistryKeys.PLACED_FEATURE, 
            Identifier.of(CobblemonFossilOre.MOD_ID, "terrestrial_fossil_ore"));

    public static final RegistryKey<net.minecraft.world.gen.feature.ConfiguredFeature<?, ?>> ANCIENT_FOSSIL_ORE_CONFIGURED = 
        RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, 
            Identifier.of(CobblemonFossilOre.MOD_ID, "ancient_fossil_ore"));
    
    public static final RegistryKey<net.minecraft.world.gen.feature.PlacedFeature> ANCIENT_FOSSIL_ORE_PLACED = 
        RegistryKey.of(RegistryKeys.PLACED_FEATURE, 
            Identifier.of(CobblemonFossilOre.MOD_ID, "ancient_fossil_ore"));

    // Biome tags
    public static final TagKey<Biome> HAS_MARINE_FOSSIL_ORE = 
        TagKey.of(RegistryKeys.BIOME, Identifier.of(CobblemonFossilOre.MOD_ID, "has_marine_fossil_ore"));
    
    public static final TagKey<Biome> HAS_ANCIENT_FOSSIL_ORE = 
        TagKey.of(RegistryKeys.BIOME, Identifier.of(CobblemonFossilOre.MOD_ID, "has_ancient_fossil_ore"));

    public static void register() {
        CobblemonFossilOre.LOGGER.info("Registering ore generation for " + CobblemonFossilOre.MOD_ID);
        
        // Marine Fossil Ore - aquatic biomes (ocean, river, beach, swamp)
        BiomeModifications.addFeature(
            BiomeSelectors.tag(HAS_MARINE_FOSSIL_ORE),
            GenerationStep.Feature.UNDERGROUND_ORES,
            MARINE_FOSSIL_ORE_PLACED
        );

        // Terrestrial Fossil Ore - all overworld EXCEPT aquatic and desert biomes
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld()
                .and(BiomeSelectors.tag(HAS_MARINE_FOSSIL_ORE).negate())
                .and(BiomeSelectors.tag(HAS_ANCIENT_FOSSIL_ORE).negate()),
            GenerationStep.Feature.UNDERGROUND_ORES,
            TERRESTRIAL_FOSSIL_ORE_PLACED
        );

        // Ancient Fossil Ore - desert/badlands/savanna biomes only
        BiomeModifications.addFeature(
            BiomeSelectors.tag(HAS_ANCIENT_FOSSIL_ORE),
            GenerationStep.Feature.UNDERGROUND_ORES,
            ANCIENT_FOSSIL_ORE_PLACED
        );
    }
}

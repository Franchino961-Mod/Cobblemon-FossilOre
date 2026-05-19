package com.fossilore.config;

import com.fossilore.FossilOre;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Configuration system for Cobblemon Fossil Ore mod.
 * Allows customization of ore generation, drop rates, and Fortune mechanics.
 *
 * Config file: config/cobblemon-fossil-ore.json
 * Reload in-game with: /fossilore reload
 */
public class ModConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String CONFIG_FILE_NAME = "fossil-ore.json";
    private static ModConfig INSTANCE;

    // World Generation Settings
    public WorldGenConfig worldGeneration = new WorldGenConfig();

    // Drop Rate Settings
    public DropRateConfig dropRates = new DropRateConfig();

    // Fortune Multipliers
    public FortuneConfig fortune = new FortuneConfig();

    // Biome Overrides (currently informational; extend ModOreGeneration to use
    // these)
    public BiomeConfig biomes = new BiomeConfig();

    // -------------------------------------------------------------------------

    public static class WorldGenConfig {
        public OreConfig marineOre = new OreConfig(4, -64, 45, true, "uniform");
        public OreConfig terrestrialOre = new OreConfig(4, 8, 64, true, "trapezoid_36");
        public OreConfig ancientOre = new OreConfig(4, 8, 64, true, "trapezoid_36");
    }

    public static class OreConfig {
        /** Blocks per vein */
        public int veinSize;
        public int minY;
        public int maxY;
        public boolean enabled;
        /** uniform | triangle | trapezoid_X */
        public String distribution;

        public OreConfig(int veinSize, int minY, int maxY, boolean enabled, String distribution) {
            this.veinSize = veinSize;
            this.minY = minY;
            this.maxY = maxY;
            this.enabled = enabled;
            this.distribution = distribution;
        }
    }

    public static class DropRateConfig {
        /**
         * If false (default) every fossil in the pool has equal probability.
         * If true, the weights in the maps below are used (must sum to ~1.0).
         * NOTE: custom drop rate logic is not yet implemented in ore blocks;
         * enable this flag only after implementing weighted selection.
         */
        public boolean customDropRates = false;

        public Map<String, Double> marineFossils = createDefaultMarineDrops();
        public Map<String, Double> terrestrialFossils = createDefaultTerrestrialDrops();
        public Map<String, Double> ancientFossils = createDefaultAncientDrops();

        private static Map<String, Double> createDefaultMarineDrops() {
            Map<String, Double> d = new LinkedHashMap<>();
            d.put("dome_fossil", 0.20);
            d.put("helix_fossil", 0.20);
            d.put("cover_fossil", 0.20);
            d.put("root_fossil", 0.20);
            d.put("fossilized_fish", 0.20);
            return d;
        }

        private static Map<String, Double> createDefaultTerrestrialDrops() {
            Map<String, Double> d = new LinkedHashMap<>();
            d.put("skull_fossil", 0.20);
            d.put("armor_fossil", 0.20);
            d.put("jaw_fossil", 0.20);
            d.put("sail_fossil", 0.20); // fixed: was "claw_fossil" (belongs to ancient)
            d.put("fossilized_dino", 0.20);
            return d;
        }

        private static Map<String, Double> createDefaultAncientDrops() {
            Map<String, Double> d = new LinkedHashMap<>();
            d.put("old_amber", 0.20); // fixed: was "old_amber_fossil"
            d.put("plume_fossil", 0.20);
            d.put("fossilized_bird", 0.20);
            d.put("claw_fossil", 0.20);
            d.put("fossilized_drake", 0.20);
            return d;
        }
    }

    public static class FortuneConfig {
        /** Chance to drop a 2nd fossil with Fortune I */
        public double fortuneIChance = 0.33;
        /** Chance to drop a 2nd fossil with Fortune II */
        public double fortuneIIChance = 0.66;
        /** Chance to drop a 2nd fossil with Fortune III */
        public double fortuneIIIChance = 0.99;
        /** Maximum fossils that can drop from a single block */
        public int maxFossilsPerBlock = 2;
    }

    public static class BiomeConfig {
        /**
         * Reserved for future use: filter biomes via config instead of
         * hardcoded tags. Requires changes in ModOreGeneration.
         */
        public boolean useCustomBiomeFilters = false;
        public String[] marineOreWhitelist = new String[] {};
        public String[] terrestrialOreWhitelist = new String[] {};
        public String[] ancientOreWhitelist = new String[] {};
        public String[] marineOreBlacklist = new String[] {};
        public String[] terrestrialOreBlacklist = new String[] {};
        public String[] ancientOreBlacklist = new String[] {};
    }

    // -------------------------------------------------------------------------
    // Singleton lifecycle

    /** Load from file, or create defaults if the file doesn't exist. */
    public static ModConfig load() {
        if (INSTANCE != null)
            return INSTANCE;

        File configFile = getConfigFile();

        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                INSTANCE = GSON.fromJson(reader, ModConfig.class);
                FossilOre.LOGGER.info("Config loaded from: {}", configFile.getAbsolutePath());
                return INSTANCE;
            } catch (IOException e) {
                FossilOre.LOGGER.error("Failed to load config, using defaults.", e);
            }
        }

        INSTANCE = new ModConfig();
        INSTANCE.save();
        return INSTANCE;
    }

    /** Save current configuration to file. */
    public void save() {
        File configFile = getConfigFile();
        try (FileWriter writer = new FileWriter(configFile)) {
            GSON.toJson(this, writer);
            FossilOre.LOGGER.info("Config saved to: {}", configFile.getAbsolutePath());
        } catch (IOException e) {
            FossilOre.LOGGER.error("Failed to save config.", e);
        }
    }

    /** Get the singleton instance, loading it if necessary. */
    public static ModConfig getInstance() {
        if (INSTANCE == null)
            load();
        return INSTANCE;
    }

    /** Reset and reload from file (used by /fossilore reload). */
    public static void reload() {
        INSTANCE = null;
        load();
    }

    private static File getConfigFile() {
        return FabricLoader.getInstance().getConfigDir()
                .resolve(CONFIG_FILE_NAME).toFile();
    }

    // -------------------------------------------------------------------------
    // Helpers

    /** Returns the Fortune-bonus chance for a given enchantment level (1-3). */
    public double getFortuneChance(int level) {
        return switch (level) {
            case 1 -> fortune.fortuneIChance;
            case 2 -> fortune.fortuneIIChance;
            case 3 -> fortune.fortuneIIIChance;
            default -> 0.0;
        };
    }
}
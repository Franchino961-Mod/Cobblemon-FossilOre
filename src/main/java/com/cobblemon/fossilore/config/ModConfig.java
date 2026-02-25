package com.cobblemon.fossilore.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Configuration system for Cobblemon Fossil Ore mod
 * Allows customization of ore generation, drop rates, and Fortune mechanics
 */
public class ModConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String CONFIG_FILE_NAME = "cobblemon-fossil-ore.json";
    private static ModConfig INSTANCE;

    // World Generation Settings
    public WorldGenConfig worldGeneration = new WorldGenConfig();

    // Drop Rate Settings
    public DropRateConfig dropRates = new DropRateConfig();

    // Fortune Multipliers
    public FortuneConfig fortune = new FortuneConfig();

    // Biome Overrides
    public BiomeConfig biomes = new BiomeConfig();

    public static class WorldGenConfig {
        public OreConfig marineOre = new OreConfig(4, -64, 45, true, "uniform");
        public OreConfig terrestrialOre = new OreConfig(4, 8, 64, true, "trapezoid_36");
        public OreConfig ancientOre = new OreConfig(4, 8, 64, true, "trapezoid_36");
    }

    public static class OreConfig {
        public int veinSize;
        public int minY;
        public int maxY;
        public boolean enabled;
        public String distribution; // uniform, triangle, trapezoid_X

        public OreConfig(int veinSize, int minY, int maxY, boolean enabled, String distribution) {
            this.veinSize = veinSize;
            this.minY = minY;
            this.maxY = maxY;
            this.enabled = enabled;
            this.distribution = distribution;
        }
    }

    public static class DropRateConfig {
        public boolean customDropRates = false; // If false, all fossils have equal chance (20%)
        public Map<String, Double> marineFossils = createDefaultMarineDrops();
        public Map<String, Double> terrestrialFossils = createDefaultTerrestrialDrops();
        public Map<String, Double> ancientFossils = createDefaultAncientDrops();

        private static Map<String, Double> createDefaultMarineDrops() {
            Map<String, Double> drops = new HashMap<>();
            drops.put("dome_fossil", 0.20);
            drops.put("helix_fossil", 0.20);
            drops.put("cover_fossil", 0.20);
            drops.put("root_fossil", 0.20);
            drops.put("fossilized_fish", 0.20);
            return drops;
        }

        private static Map<String, Double> createDefaultTerrestrialDrops() {
            Map<String, Double> drops = new HashMap<>();
            drops.put("skull_fossil", 0.20);
            drops.put("armor_fossil", 0.20);
            drops.put("jaw_fossil", 0.20);
            drops.put("claw_fossil", 0.20);
            drops.put("fossilized_dino", 0.20);
            return drops;
        }

        private static Map<String, Double> createDefaultAncientDrops() {
            Map<String, Double> drops = new HashMap<>();
            drops.put("old_amber", 0.20);
            drops.put("plume_fossil", 0.20);
            drops.put("fossilized_bird", 0.20);
            drops.put("sail_fossil", 0.20);
            drops.put("fossilized_drake", 0.20);
            return drops;
        }
    }

    public static class FortuneConfig {
        public double fortuneIChance = 0.33;  // 33% chance for 2nd fossil
        public double fortuneIIChance = 0.66; // 66% chance for 2nd fossil
        public double fortuneIIIChance = 0.99; // 99% chance for 2nd fossil
        public int maxFossilsPerBlock = 2;
    }

    public static class BiomeConfig {
        public boolean useCustomBiomeFilters = false;
        public String[] marineOreWhitelist = new String[]{};
        public String[] terrestrialOreWhitelist = new String[]{};
        public String[] ancientOreWhitelist = new String[]{};
        public String[] marineOreBlacklist = new String[]{};
        public String[] terrestrialOreBlacklist = new String[]{};
        public String[] ancientOreBlacklist = new String[]{};
    }

    /**
     * Load configuration from file, or create default if not exists
     */
    public static ModConfig load() {
        if (INSTANCE != null) {
            return INSTANCE;
        }

        File configDir = FabricLoader.getInstance().getConfigDir().toFile();
        File configFile = new File(configDir, CONFIG_FILE_NAME);

        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                INSTANCE = GSON.fromJson(reader, ModConfig.class);
                System.out.println("[Cobblemon Fossil Ore] Config loaded from: " + configFile.getAbsolutePath());
                return INSTANCE;
            } catch (IOException e) {
                System.err.println("[Cobblemon Fossil Ore] Failed to load config, using defaults: " + e.getMessage());
            }
        }

        // Create default config
        INSTANCE = new ModConfig();
        INSTANCE.save();
        return INSTANCE;
    }

    /**
     * Save current configuration to file
     */
    public void save() {
        File configDir = FabricLoader.getInstance().getConfigDir().toFile();
        File configFile = new File(configDir, CONFIG_FILE_NAME);

        try (FileWriter writer = new FileWriter(configFile)) {
            GSON.toJson(this, writer);
            System.out.println("[Cobblemon Fossil Ore] Config saved to: " + configFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("[Cobblemon Fossil Ore] Failed to save config: " + e.getMessage());
        }
    }

    /**
     * Get singleton instance
     */
    public static ModConfig getInstance() {
        if (INSTANCE == null) {
            return load();
        }
        return INSTANCE;
    }

    /**
     * Reload configuration from file
     */
    public static void reload() {
        INSTANCE = null;
        load();
    }

    /**
     * Get Fortune chance based on level
     */
    public double getFortuneChance(int level) {
        return switch (level) {
            case 1 -> fortune.fortuneIChance;
            case 2 -> fortune.fortuneIIChance;
            case 3 -> fortune.fortuneIIIChance;
            default -> 0.0;
        };
    }
}

package com.cobblemon.fossilore;

import com.cobblemon.fossilore.command.ReloadCommand;
import com.cobblemon.fossilore.config.ModConfig;
import com.cobblemon.fossilore.world.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CobblemonFossilOre implements ModInitializer {
    public static final String MOD_ID = "cobblemon_fossil_ore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Cobblemon Fossil Ore");
        
        // Load configuration first
        ModConfig.load();
        LOGGER.info("Configuration loaded successfully");
        
        ModBlocks.register();
        ModItems.register();
        ModOreGeneration.register();
        
        // Register commands
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            ReloadCommand.register(dispatcher);
        });
        LOGGER.info("Commands registered successfully");
        
        LOGGER.info("Cobblemon Fossil Ore initialized successfully!");
    }
}

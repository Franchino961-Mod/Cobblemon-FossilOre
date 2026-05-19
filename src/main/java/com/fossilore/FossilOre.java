package com.fossilore;

import com.fossilore.command.ReloadCommand;
import com.fossilore.config.ModConfig;
import com.fossilore.world.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FossilOre implements ModInitializer {
    public static final String MOD_ID = "fossil_ore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Fossil Ore");
        
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
        
        LOGGER.info("Fossil Ore initialized successfully!");
    }
}

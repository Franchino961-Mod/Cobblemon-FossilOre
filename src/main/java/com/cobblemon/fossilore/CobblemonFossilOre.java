package com.cobblemon.fossilore;

import com.cobblemon.fossilore.world.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CobblemonFossilOre implements ModInitializer {
    public static final String MOD_ID = "cobblemon_fossil_ore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Cobblemon Fossil Ore");
        
        ModBlocks.register();
        ModItems.register();
        ModOreGeneration.register();
        
        LOGGER.info("Cobblemon Fossil Ore initialized successfully!");
    }
}

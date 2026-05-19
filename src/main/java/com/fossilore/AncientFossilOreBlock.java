package com.fossilore;

/**
 * Ancient Fossil Ore — spawns in desert/badlands/savanna biomes.
 * Drops flying and ancient rare creature fossils.
 */
public class AncientFossilOreBlock extends FossilOreBlock {

    private static final String[] ANCIENT_FOSSILS = {
            "old_amber", // Aerodactyl — Pterodactyl (correct Cobblemon item name)
            "plume_fossil", // Archen — Proto-bird
            "fossilized_bird", // Archeops — Prehistoric bird
            "claw_fossil", // Anorith — Ancient arthropod
            "fossilized_drake" // Dracovish — Aquatic/flying drake hybrid
    };

    public AncientFossilOreBlock(Settings settings) {
        super(settings, ANCIENT_FOSSILS);
    }
}
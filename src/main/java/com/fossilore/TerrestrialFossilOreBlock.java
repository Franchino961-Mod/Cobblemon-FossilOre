package com.fossilore;

/**
 * Terrestrial Fossil Ore — spawns in all overworld biomes
 * except aquatic and desert/badlands/savanna.
 * Drops terrestrial dinosaur fossils.
 */
public class TerrestrialFossilOreBlock extends FossilOreBlock {

    private static final String[] TERRESTRIAL_FOSSILS = {
            "skull_fossil", // Cranidos — Pachycephalosaurus
            "armor_fossil", // Shieldon — Armored dinosaur
            "jaw_fossil", // Tyrunt — T-Rex predator
            "sail_fossil", // Amaura — Ice age dinosaur
            "fossilized_dino" // Arctovish — Hybrid dinosaur
    };

    public TerrestrialFossilOreBlock(Settings settings) {
        super(settings, TERRESTRIAL_FOSSILS);
    }
}
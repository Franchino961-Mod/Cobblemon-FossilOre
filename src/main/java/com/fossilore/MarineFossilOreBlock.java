package com.fossilore;

/**
 * Marine Fossil Ore — spawns in ocean/river/beach/swamp biomes.
 * Drops aquatic/marine prehistoric Pokémon fossils.
 */
public class MarineFossilOreBlock extends FossilOreBlock {

    private static final String[] MARINE_FOSSILS = {
            "dome_fossil", // Kabuto — Trilobite
            "helix_fossil", // Omanyte — Ammonite
            "cover_fossil", // Tirtouga — Sea turtle
            "root_fossil", // Lileep — Crinoid
            "fossilized_fish" // Dracozolt — Electric fish
    };

    public MarineFossilOreBlock(Settings settings) {
        super(settings, MARINE_FOSSILS);
    }
}
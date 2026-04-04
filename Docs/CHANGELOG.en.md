# Changelog - Cobblemon Fossil Ore

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [Unreleased]

### Planned
- Animated textures and visual particles
- Integration with tech mods (Create, etc.)
- Nether/End variants for Fossil Ores

---

## [2.2.2] - 2026-02-25

### Changed
- **Marine Fossil Ore Generation**: Completely reworked worldgen system
  - Now uses `OCEAN_FLOOR_WG` heightmap placement for accurate seafloor spawning
  - Fossils now spawn **on and within the ocean floor surface** instead of randomly throughout water columns
  - Added `random_offset` with y_spread: -3 to embed fossils naturally in seafloor sediment
  - Greatly improved discoverability - fossils are now visible when diving and exploring underwater
  - Thematically accurate: marine fossils embedded in sandy/gravel seabed, not deep underground
- **Balanced Spawn Rates**: Adjusted spawn frequency for all fossil ores
  - Marine Fossil Ore: Reduced count from 30 to 10
  - Terrestrial Fossil Ore: Reduced count from 18 to 10
  - Ancient Fossil Ore: Reduced count from 18 to 10
  - All three ores now have consistent rarity, making fossils more valuable and challenging to find
  - Provides better balance for survival gameplay and multiplayer servers

### Fixed
- Marine Fossil Ore no longer spawns in deep underground caves or random water blocks
- Marine Fossil Ore spawn system now correctly targets visible seafloor locations

### Technical
- Marine placed_feature.json: Replaced `height_range` (uniform Y -5 to 15) with `heightmap` (OCEAN_FLOOR_WG) + `random_offset`
- All three placed_feature.json files: Updated count values to 10 for consistent spawn rates

**⚠️ Important**: Worldgen changes only apply to newly generated chunks. Explore new areas or create a new world to see the updated fossil generation!

---

## [2.2.1] - 2026-02-23

### Added
- **Command /fossilore reload**: Reload configuration in-game without restart (requires OP level 2)
- **JEI/REI Support**: Smelting recipes are now automatically compatible with recipe viewer mods
- **Multilingual Translations**: Added support for 4 new languages
  - Spanish (es_es)
  - French (fr_fr)
  - German (de_de)
  - Brazilian Portuguese (pt_br)

### Changed
- Optional dependency suggestions for JEI/REI in fabric.mod.json

### Technical
- New `ReloadCommand` class for in-game command handling
- Command registration via CommandRegistrationCallback
- Complete multilingual structure in assets/lang/

---

## [2.2.0] - 2026-02-22

### Added
- **Configuration System**: Full JSON-based configuration support
  - Config file: `config/cobblemon-fossil-ore.json`
  - **World Generation Settings**: Customize vein size, Y range, distribution pattern per ore type
  - **Fortune Multipliers**: Adjust chance percentages for Fortune I/II/III
  - **Drop Rate Customization**: Set individual fossil drop probabilities
  - **Biome Filtering**: Whitelist/blacklist biomes for ore generation (advanced)
- Auto-generated default config on first launch
- Config validation and error handling

### Changed
- Fortune chances now configurable (default: 33%/66%/99%)
- Ore generation parameters now read from config instead of hardcoded
- Max fossils per block configurable (default: 2)

### Technical
- New `ModConfig` class with JSON serialization/deserialization
- Config loaded during mod initialization
- Ore blocks now query config for Fortune multipliers

### For Server Admins
- Easy customization for modpack creators
- Balance tweaking without code changes
- Per-ore enable/disable switches
- **Note**: Config changes require server/game restart

---

## [2.1.0] - 2026-02-23

### Added
- **Smelting System**: Fossil Ores can now be smelted to obtain guaranteed specific fossils
  - **Marine Fossil Ore** → Dome Fossil (Kabuto)
  - **Terrestrial Fossil Ore** → Skull Fossil (Cranidos)
  - **Ancient Fossil Ore** → Old Amber (Aerodactyl)
- **Furnace Support**: Regular smelting takes 10 seconds (200 ticks) with 0.7 XP reward
- **Blast Furnace Support**: Faster smelting takes 5 seconds (100 ticks) with 0.7 XP reward
- Smelting creates strategic choice: mine for random fossils (Fortune bonus) or smelt for guaranteed specific fossil

### Design Notes
- Smelting provides consistent specific fossils vs. mining's random drops
- Trade-off: Mining can yield 2 fossils with Fortune, smelting always gives 1
- Each ore type yields its most iconic fossil when smelted

---

## [2.0.0] - 2026-02-22

### 🔥 BREAKING CHANGES
- **Complete ore system redesign**: Removed generic `Fossil Ore` and `Deepslate Fossil Ore`
- **New theor blocks**: Introduced 3 thematic ore types with biome-specific generation
- **World regeneration required**: Existing Fossil Ore blocks will disappear in loaded chunks

### Added
- **Marine Fossil Ore** - Generates in aquatic biomes (ocean, river, beach, swamp) from Y -64 to Y 45
  - Drops 5 aquatic fossils: Dome, Helix, Cover, Root, Fossilized Fish
- **Terrestrial Fossil Ore** - Generates in most overworld biomes (excluding aquatic/desert) from Y 8 to Y 64 (peak at Y 36)
  - Drops 5 terrestrial fossils: Skull, Armor, Jaw, Claw, Fossilized Dino
- **Ancient Fossil Ore** - Generates in desert, badlands, and savanna biomes from Y 8 to Y 64 (peak at Y 36)
  - Drops 5 ancient fossils: Old Amber, Plume, Fossilized Bird, Sail, Fossilized Drake
- Biome tags for precise ore distribution control
- Themed drop system: Each ore drops fossils matching its biome theme

### Changed
- Vein size increased from 3 to 4 blocks for all ores
- Ore generation now uses biome-specific filtering for strategic gameplay
- Each fossil now has 20% drop chance within its ore type (vs. 6.67% in v1.0.0)

### Removed
- Generic `Fossil Ore` (stone variant)
- `Deepslate Fossil Ore` variant
- Random drop system across all 15 fossils

### Migration Notes
- Explore new chunks to find the new ore types
- Old Fossil Ore blocks in existing chunks will be invalid and should be replaced
- Use `/fill` commands to remove old ores if necessary

---

## [1.0.0] - 2026-02-22

### Added
- **Fossil Ore** - Ore that generates in normal Overworld (stone)
- **Deepslate Fossil Ore** - Deepslate variant of the ore
- Natural generation from Y -64 to Y 100 (maximum concentration at Y 18)
- Random drops of all 15 Cobblemon fossils:
  - Armor Fossil (Shieldon)
  - Claw Fossil (Anorith)
  - Cover Fossil (Tirtouga)
  - Dome Fossil (Kabuto)
  - Fossilized Bird (Archeops)
  - Fossilized Dino (Arctovish)
  - Fossilized Drake (Dracovish)
  - Fossilized Fish (Dracozolt)
  - Helix Fossil (Omanyte)
  - Jaw Fossil (Tyrunt)
  - Old Amber (Aerodactyl)
  - Plume Fossil (Archen)
  - Root Fossil (Lileep)
  - Sail Fossil (Amaura)
  - Skull Fossil (Cranidos)
- Support for **Fortune** enchantment (up to 2 fossils per block with Fortune III)
- Support for **Silk Touch** (obtain the ore block instead of fossils)
- Custom textures for both ore blocks
- Configurable loot tables
- Compatibility with all Overworld biomes
- Full multiplayer support
- README in Italian and English
- MIT License

### Technical Features
- Veins up to 3 blocks per spawn
- Requires wood pickaxe or higher to mine
- Fabric 1.21.1 compatibility
- Full integration with Cobblemon 1.6.0+

---

## Version Format

### [Version] - Date

#### Added
New features added.

#### Changed
Changes to existing features.

#### Deprecated
Features that will be removed in future versions.

#### Removed
Removed features.

#### Fixed
Bug fixes.

#### Security
Security patches.

---

**Note**: For complete mod details and installation instructions, see [README.md](../README.md) or [README.it.md](README.it.md).

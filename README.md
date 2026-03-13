# ⛰️ Cobblemon Fossil Ore

A Cobblemon addon mod that adds fossil ores to the Minecraft world, providing a new way to obtain the fossils needed to revive prehistoric Pokémon!

[![Download on CurseForge](https://img.shields.io/badge/Download_on-CurseForge-orange?style=for-the-badge&logo=curseforge)](https://www.curseforge.com/minecraft/mc-mods/cobblemon-fossil-ore)

[![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-green.svg)](https://www.minecraft.net/)
[![Version](https://img.shields.io/badge/version-2.2.2-blue.svg)]()
[![Fabric](https://img.shields.io/badge/Fabric-0.16.9-blue.svg)](https://fabricmc.net/)
[![Cobblemon](https://img.shields.io/badge/Cobblemon-1.6.0+-red.svg)](https://cobblemon.com)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

[![en](https://img.shields.io/badge/lang-en-red.svg)](README.md)
[![it](https://img.shields.io/badge/lang-it-green.svg)](MD/README.it.md)

> 📝 **Changelog**: See [CHANGELOG.en.md](MD/CHANGELOG.en.md) for version history.

## 📋 Description

This mod adds three thematic ore blocks to the Overworld, each containing fossils from different prehistoric eras:

- **Marine Fossil Ore** - Found in aquatic biomes (oceans, rivers, beaches, swamps). Contains fossils of ancient sea creatures.
- **Terrestrial Fossil Ore** - Found in most overworld biomes. Contains fossils of land-dwelling dinosaurs and prehistoric animals.
- **Ancient Fossil Ore** - Found in desert, badlands, and savanna biomes. Contains fossils of flying creatures and the oldest specimens.

When mined, each ore drops one of 5 specific fossils matching its theme, offering a strategic way to obtain the fossils you need by exploring specific biomes!

## 📦 Requirements

- **Minecraft**: 1.21.1
- **Fabric Loader**: 0.16.9 or higher
- **Fabric API**: 0.108.0 or higher
- **Cobblemon**: 1.6.0 or higher

## 📦 Installation

1. Make sure you have Fabric Loader, Fabric API, and Cobblemon installed
2. Download the mod `.jar` file
3. Place the file in your Minecraft installation's `mods` folder
4. Launch the game!

## 🔍 How to Find Fossil Ores

**New in v2.2.2!** Marine Ore generation has been completely reworked to spawn naturally on the ocean floor, making fossils much easier to discover when diving!

### Marine Fossil Ore 🌊
- **Biomes**: Oceans, rivers, beaches, swamps, mangrove swamps
- **Generation**: Spawns **on and within the seafloor** (ocean floor surface)
- **Depth**: Automatically positions on solid blocks underwater (typically Y -5 to Y 15)
- **Targets**: Replaces stone, sand, and gravel on the seabed
- **Vein size**: up to 4 blocks per vein
- **Rarity**: Balanced spawn rate for challenging but rewarding exploration

**Best mining strategy**: Dive and explore the ocean floor surface. The fossils are embedded in the seafloor sediment, making them visible when swimming underwater. Look carefully along sandy and gravel beds!

### Terrestrial Fossil Ore 🦴
- **Biomes**: All overworld biomes EXCEPT aquatic and desert biomes
- **Height (Y Level)**: from Y 8 to Y 64
- **Optimal concentration**: around Y 36 (trapezoid distribution)
- **Vein size**: up to 4 blocks per vein
- **Rarity**: Balanced spawn rate for challenging but rewarding exploration

**Best mining strategy**: Mine in stone layers around Y 36 in forests, plains, mountains, and taiga biomes.

### Ancient Fossil Ore 🏜️
- **Biomes**: Desert, badlands, savanna (all variants)
- **Height (Y Level)**: from Y 8 to Y 64
- **Optimal concentration**: around Y 36 (trapezoid distribution)
- **Vein size**: up to 4 blocks per vein
- **Rarity**: Balanced spawn rate for challenging but rewarding exploration

**Best mining strategy**: Explore desert caves and badlands formations around Y 36.

**⚠️ Important**: The ores only generate in new chunks! If you're playing in an existing world, you'll need to explore new areas or create a new world.

## ⛏️ Mining Mechanics

### Base Drop
- **Required pickaxe**: Wood or higher
- **Drop without enchantments**: 1 random fossil

### Fortune
The Fortune enchantment increases the chance of getting extra fossils:
- **Fortune I**: ~33% chance to get 2 fossils
- **Fortune II**: ~66% chance to get 2 fossils
- **Fortune III**: ~99% chance to get 2 fossils
- **Maximum**: 2 fossils per block

Each fossil is chosen independently and randomly, so you might get two different fossils from the same block!

### Silk Touch
If you use a pickaxe with Silk Touch, you'll get the Fossil Ore block itself instead of fossils, allowing you to move or collect it.

## 🔥 Smelting System

Fossil Ores can be smelted in furnaces as an alternative method to obtain fossils!

### Regular Furnace
- **Time**: 10 seconds (200 ticks)
- **Fuel**: Any standard furnace fuel (coal, charcoal, lava bucket, etc.)
- **Experience**: 0.7 XP per ore smelted
- **Output**: 1 guaranteed specific fossil (see table below)

### Blast Furnace
- **Time**: 5 seconds (100 ticks) - twice as fast!
- **Fuel**: Any standard furnace fuel
- **Experience**: 0.7 XP per ore smelted
- **Output**: Same as regular furnace

### Smelting Results

Each ore type produces a specific iconic fossil when smelted:

| Ore Type | Smelted Fossil | Pokémon |
|----------|----------------|---------|
| **Marine Fossil Ore** | Dome Fossil | Kabuto (iconic aquatic trilobite) |
| **Terrestrial Fossil Ore** | Skull Fossil | Cranidos (classic dinosaur) |
| **Ancient Fossil Ore** | Old Amber | Aerodactyl (legendary flying fossil) |

### Strategic Choice: Mining vs. Smelting

**Mining** (breaking the ore with pickaxe):
- ✅ Get random fossil from 5 possible types
- ✅ Fortune enchantment can give 2 fossils
- ❌ Need to find and mine the ore
- ❌ Fossil type is unpredictable

**Smelting** (furnace/blast furnace):
- ✅ Get guaranteed specific fossil (always the same)
- ✅ Automatic with hopper systems
- ✅ Blast furnace is super fast (5 seconds)
- ❌ Always gives exactly 1 fossil
- ❌ Requires fuel and time

**Example**: If you specifically need a Dome Fossil for Kabuto, you can smelt Marine Fossil Ore blocks instead of hoping for a 20% drop from mining!

## 🦴 Available Fossils

Each ore type drops fossils from a specific theme, making it easier to find the ones you need!

### Marine Fossil Ore 🌊 (Aquatic biomes)
- **Dome Fossil** (Kabuto)
- **Helix Fossil** (Omanyte)
- **Cover Fossil** (Tirtouga)
- **Root Fossil** (Lileep)
- **Fossilized Fish** (Dracozolt)

### Terrestrial Fossil Ore 🦴 (Most land biomes)
- **Skull Fossil** (Cranidos)
- **Armor Fossil** (Shieldon)
- **Jaw Fossil** (Tyrunt)
- **Claw Fossil** (Anorith)
- **Fossilized Dino** (Arctovish)

### Ancient Fossil Ore 🏜️ (Desert/Savanna biomes)
- **Old Amber** (Aerodactyl)
- **Plume Fossil** (Archen)
- **Fossilized Bird** (Archeops)
- **Sail Fossil** (Amaura)
- **Fossilized Drake** (Dracovish)

Once obtained, you can use the fossils exactly as in standard Cobblemon to revive prehistoric Pokémon!

## ⚙️ Configuration

**New in v2.2.0!** The mod now supports configuration for server admins and modpack creators.

### Config File Location
After first launch, a config file will be created at:
```
config/cobblemon-fossil-ore.json
```

### Configurable Settings

#### World Generation
Customize ore generation for each ore type:
```json
"worldGeneration": {
  "marineOre": {
    "veinSize": 4,
    "minY": -64,
    "maxY": 45,
    "enabled": true,
    "distribution": "uniform"
  }
}
```
- **veinSize**: Number of ore blocks per vein (default: 4)
- **minY/maxY**: Height range for generation
- **enabled**: Enable/disable specific ore type
- **distribution**: Generation pattern (uniform, trapezoid_X)

#### Fortune Multipliers
Adjust Fortune enchantment effectiveness:
```json
"fortune": {
  "fortuneIChance": 0.33,
  "fortuneIIChance": 0.66,
  "fortuneIIIChance": 0.99,
  "maxFossilsPerBlock": 2
}
```
Values represent chance (0.0-1.0) to get a second fossil.

#### Drop Rates (Advanced)
Fine-tune individual fossil drop rates:
```json
"dropRates": {
  "customDropRates": false,
  "marineFossils": {
    "dome_fossil": 0.20,
    "helix_fossil": 0.20
  }
}
```
Set `customDropRates: true` to enable custom probabilities. All fossils must sum to 1.0 (100%).

#### Biome Filtering (Advanced)
Override default biome spawning:
```json
"biomes": {
  "useCustomBiomeFilters": false,
  "marineOreWhitelist": [],
  "marineOreBlacklist": []
}
```

### Reloading Config
**New in v2.2.1!** You can now reload the configuration without restarting:
```
/fossilore reload
```
**Requirements**: OP permission level 2 (server ops only)

## 💻 Commands

**New in v2.2.1!** Admin commands for server management:

### /fossilore reload
Reloads the mod configuration from file without restarting the server or game.
- **Permission**: Requires OP level 2
- **Usage**: `/fossilore reload`
- **Feedback**: Confirms when config is reloaded successfully

## 🎮 Compatibility

This mod is designed to integrate seamlessly with Cobblemon **without modifying** the existing fossil system. It simply adds a new method to obtain them, keeping all original methods intact.

### Recipe Viewer Mods
**New in v2.2.1!** Full compatibility with:
- **JEI (Just Enough Items)**: Smelting recipes automatically displayed
- **REI (Roughly Enough Items)**: Smelting recipes automatically displayed

No additional setup required - recipes are detected automatically!

### Supported Languages
**New in v2.2.1!** The mod now supports 6 languages:
- 🇺🇸 English (en_us)
- 🇮🇹 Italian (it_it)
- 🇪🇸 Spanish (es_es)
- 🇫🇷 French (fr_fr)
- 🇩🇪 German (de_de)
- 🇧🇷 Brazilian Portuguese (pt_br)

## ❓ FAQ

**Q: Are the fossils I get the same as normal Cobblemon ones?**  
A: Yes! They are exactly the same items and work the same way.

**Q: Can I find Fossil Ores in my existing world?**  
A: Yes, but only in chunks that haven't been generated yet. You'll need to explore new areas.

**Q: Can I use this mod with other mods besides Cobblemon?**  
A: Yes, the mod should be compatible with other Fabric mods, as long as they don't heavily modify the world generation system.

**Q: Can I modify the rarity or generation height?**  
A: Yes! In v2.2.0+, you can customize ore generation, Fortune chances, drop rates, and more via the config file at `config/cobblemon-fossil-ore.json`. See the Configuration section above for details.

**Q: Does the mod work in multiplayer?**  
A: Yes! It works in both singleplayer and multiplayer. It must be installed on the server.

## 📄 License

This mod is licensed under the [MIT License](LICENSE). Feel free to include it in your modpacks!

## 👤 Author

**Franchino961** — [GitHub](https://github.com/Franchino961-Mod)

## 🤝 Contributing

Contributions are welcome!
- Open an [Issue](../../issues) to report bugs or suggest features
- Open a [Pull Request](../../pulls) to contribute code

## 💬 Support

If you encounter issues or bugs, please report them with:
- Mod version
- Minecraft / Fabric / Cobblemon versions
- Detailed description of the problem
- Crash logs (if applicable)
- [Open an Issue](../../issues)

## 🔗 Links

- [CurseForge](https://www.curseforge.com/minecraft/mc-mods/cobblemon-fossil-ore)
- [Cobblemon Mod](https://cobblemon.com)
- [Fabric](https://fabricmc.net/)

## 📝 Changelog

See [CHANGELOG.en.md](MD/CHANGELOG.en.md) for full version history.

---

**Happy mining and good luck with your fossil Pokémon!** 🦕⛏️
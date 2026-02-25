# TODO - Cobblemon Fossil Ore

**Current Version:** v2.2.2  
**Last Updated:** February 25, 2026

List of planned features and improvements, organized by priority and category.

---

## 📊 Quick Status

- ✅ **Core System** (3 themed ores) - v2.0.0
- ✅ **Smelting System** - v2.1.0
- ✅ **Configuration System** - v2.2.0
- ✅ **Commands & Multilingual** - v2.2.1
- ✅ **Worldgen Improvements & Balance** - v2.2.2
- 🔵 **Dimension Expansion** (Nether/End) - Planned for v2.3.0
- 🔵 **Visual Polish** (particles, animations) - Planned for v2.4.0
- 🔵 **Mod Integration** (REI, Create, etc.) - Planned for v2.4.0+

---

## 🎮 Game Mechanics / Crafting

### Smelting ✅ COMPLETED (v2.1.0)
- [x] **Ability to smelt Fossil Ore in normal furnace**
  - Provides 1 guaranteed specific fossil + 0.7 XP when smelted
  - Standard smelting time (10 seconds / 200 ticks)
  - Marine → Dome Fossil, Terrestrial → Skull Fossil, Ancient → Old Amber
  
- [x] **Ability to smelt Fossil Ore in blast furnace**
  - Provides 1 guaranteed specific fossil + 0.7 XP when smelted
  - Reduced smelting time (5 seconds / 100 ticks)
  - Same output as regular furnace

### Biome-Influenced Drops
- [ ] **Biome-influenced drop rate system**
  - Aquatic fossils (Kabuto, Omanyte, Tirtouga) more common near oceans/rivers
  - Flying fossils (Archen, Aerodactyl) more common in high mountains
  - Rock/ground fossils more common in caves/desert
  - Still maintain possibility to find any fossil anywhere (just different probabilities)
  - Provides strategy without adding complexity (single ore block)

---

## ⚙️ Configuration ✅ COMPLETED (v2.2.0)

### Config File ✅ COMPLETED
- [x] **JSON-based configuration system**
  - Config file: `config/cobblemon-fossil-ore.json`
  - Auto-generated on first launch
  - World generation settings (vein size, Y range, distribution)
  - Fortune multipliers (I/II/III)
  - Drop rate customization
  - Biome whitelist/blacklist filtering
  
### Future Enhancements
- [x] In-game reload command (/fossilore reload) ✅ **COMPLETED (v2.2.1)**
- [ ] Dynamic worldgen config application (currently requires restart)
- [ ] Config GUI integration (Mod Menu compatibility)
  
---

## 🌍 World Generation

### Priority: 🔴 High (v2.3.0)

### Ore Variants
- [ ] **Add Nether variant (Netherrack Fossil Ore)**
  - Drop specific fossils for ancient fire-related Pokémon
  
- [ ] **Add End variant (End Stone Fossil Ore)**
  - Drop ultra-rare fossils
  
### Structures
- [ ] **Create small natural structures with Fossil Ore concentrations**
  - "Fossil deposits" with 5-10 grouped ores
  - Possibility to find other themed blocks (bone blocks, gravel)

---

## 🎨 Graphics and Effects

### Priority: 🟡 Medium (v2.4.0)

### Particles
- [ ] **Add visual particles to ore blocks**
  - Small amber/fossil particles emitting periodically
  - Effect similar to sculk or ender chests
  
### Textures
- [ ] **Animated texture for Fossil Ores**
  - Subtle animation to make blocks more interesting
  
### Audio
- [ ] **Custom sounds when mining a Fossil Ore**
  - Distinctive sound to differentiate it from other ores

---

## 🔧 Compatibility

### Priority: 🟡 Medium (v2.4.0-v2.5.0)

### Mod Integration
- [x] **REI (Roughly Enough Items) / JEI integration** ✅ **COMPLETED (v2.2.1)**
  - Smelting recipes automatically compatible
  - Recipe viewer mods detect vanilla JSON recipes
  
- [ ] **Create mod compatibility**
  - Support for crushers/millstones
  - Ability to process Fossil Ore with Create machines
  
- [ ] **Tech Reborn / Modern Industrialization**
  - Recipes for industrial grinder/macerator

---

## 📚 Documentation

### Priority: 🟢 Low (v2.5.0+)

### In-game Wiki
- [ ] **Integration with Patchouli or custom book**
  - In-game guide on how to find and use Fossil Ores
  
### Translations
- [x] **Add translations in multiple languages** ✅ **COMPLETED (v2.2.1)**
  - Italian ✅
  - English ✅
  - Spanish ✅
  - French ✅
  - German ✅
  - Portuguese (BR) ✅

---

## 🎁 Extra Content

### Priority: 🟢 Low (v2.5.0+)

### Items
- [ ] **Fossil Detector**
  - Tool that indicates the direction of nearby Fossil Ores
  - Similar to Recovery Compass

---

## 🐛 Bug Fix / Improvements

### Priority: 🔴 Ongoing

- [ ] **In-game testing** - Test Fortune, Silk Touch, smelting in survival
- [ ] **Config validation** - Test with custom config values
- [ ] **Biome spawn verification** - Confirm ores spawn in correct biomes only
- [ ] **Multiplayer testing** - Verify server compatibility
- [ ] **Performance profiling** - Check worldgen performance with 3 ores
- [ ] **Mod compatibility** - Test with popular Fabric mods
- [ ] **Edge cases** - Test unusual configurations and scenarios

---

## 🎯 Next Milestone: v2.3.0

**Focus:** Dimension Expansion (Nether & End)

**Target Features:**
- Nether Fossil Ore (5 fire/ancient themed fossils)
- End Fossil Ore (5 rare/legendary fossils)
- Dimension-specific worldgen
- Updated config for new ores

**Estimated Timeline:** 4-6 hours development

---

**Last updated**: February 22, 2026

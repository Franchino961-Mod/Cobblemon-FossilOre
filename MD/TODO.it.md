# TODO - Cobblemon Fossil Ore

**Versione Attuale:** v2.2.2  
**Ultimo Aggiornamento:** 25 Febbraio 2026

Elenco delle funzionalità pianificate e miglioramenti, organizzati per priorità e categoria.

---

## 📊 Status Rapido

- ✅ **Sistema Base** (3 ore tematici) - v2.0.0
- ✅ **Sistema Fusione** - v2.1.0
- ✅ **Sistema Configurazione** - v2.2.0
- ✅ **Comandi & Multilingua** - v2.2.1
- ✅ **Miglioramenti Worldgen & Bilanciamento** - v2.2.2
- 🔵 **Espansione Dimensioni** (Nether/End) - Pianificato per v2.3.0
- 🔵 **Grafica Avanzata** (particelle, animazioni) - Pianificato per v2.4.0
- 🔵 **Integrazione Mod** (REI, Create, etc.) - Pianificato per v2.4.0+

---

## 🎮 Meccaniche di Gioco / Crafting

### Smelting/Fusione ✅ COMPLETATO (v2.1.0)
- [x] **Possibilità di smeltare i Fossil Ore nella fornace normale**
  - Fornisce 1 fossile specifico garantito + 0.7 XP quando fuso
  - Tempo di fusione standard (10 secondi / 200 tick)
  - Marine → Dome Fossil, Terrestrial → Skull Fossil, Ancient → Old Amber
  
- [x] **Possibilità di smeltare i Fossil Ore nella blast furnace**
  - Fornisce 1 fossile specifico garantito + 0.7 XP quando fuso
  - Tempo di fusione ridotto (5 secondi / 100 tick)
  - Stesso output della fornace normale

### Drop Influenzati dai Biomi
- [ ] **Sistema di drop rate influenzato dai biomi**
  - Fossili acquatici (Kabuto, Omanyte, Tirtouga) più comuni vicino oceani/fiumi
  - Fossili volanti (Archen, Aerodactyl) più comuni in montagne alte
  - Fossili roccia/terra più comuni in cave/desert
  - Mantenere comunque la possibilità di trovare qualsiasi fossile ovunque (solo probabilità diverse)
  - Dà strategia senza aggiungere complessità (1 solo ore block)

---

## ⚙️ Configurazione ✅ COMPLETATO (v2.2.0)

### File Config ✅ COMPLETATO
- [x] **Sistema di configurazione basato su JSON**
  - File config: `config/cobblemon-fossil-ore.json`
  - Generato automaticamente al primo avvio
  - Impostazioni generazione mondo (dimensione vene, range Y, distribuzione)
  - Moltiplicatori Fortune (I/II/III)
  - Personalizzazione drop rate
  - Filtro whitelist/blacklist biomi
  
### Miglioramenti Futuri
- [x] Comando ricarica in-game (/fossilore reload) ✅ **COMPLETATO (v2.2.1)**
- [ ] Applicazione dinamica config worldgen (attualmente richiede riavvio)
- [ ] Integrazione GUI config (compatibilità Mod Menu)
  
---

## 🌍 Generazione Mondo

### Priorità: 🔴 Alta (v2.3.0)

### Varianti Ore
- [ ] **Aggiungere variante Nether (Netherrack Fossil Ore)**
  - Drop fossili specifici per Pokémon antichi legati al fuoco
  
- [ ] **Aggiungere variante End (End Stone Fossil Ore)**
  - Drop fossili ultra-rari
  
### Strutture
- [ ] **Creare piccole strutture naturali con concentrazioni di Fossil Ore**
  - "Fossil deposits" con 5-10 ore raggruppati
  - Possibilità di trovare anche altri blocchi tematici (bone blocks, gravel)

---

## 🎨 Grafica ed Effetti

### Priorità: 🟡 Media (v2.4.0)

### Particelle
- [ ] **Aggiungere particelle visive ai blocchi ore**
  - Piccole particelle ambrate/fossili che escono periodicamente
  - Effetto simile alle sculk o alle ender chest
  
### Texture
- [ ] **Texture animata per i Fossil Ore**
  - Animazione sottile per rendere i blocchi più interessanti
  
### Audio
- [ ] **Suoni custom quando si mina un Fossil Ore**
  - Suono distintivo per differenziarlo dagli altri ore

---

## 🔧 Compatibilità

### Priorità: 🟡 Media (v2.4.0-v2.5.0)

### Mod Integration
- [x] **REI (Roughly Enough Items) / JEI integration** ✅ **COMPLETATO (v2.2.1)**
  - Ricette di smelting automaticamente compatibili
  - I mod recipe viewer rilevano le ricette vanilla JSON
  
- [ ] **Create mod compatibility**
  - Supporto per crushers/millstones
  - Possibilità di processare i Fossil Ore con macchine di Create
  
- [ ] **Tech Reborn / Modern Industrialization**
  - Ricette per industrial grinder/macerator

---

## 📚 Documentazione

### Priorità: 🟢 Bassa (v2.5.0+)

### Wiki in-game
- [ ] **Integrazione con Patchouli o libro custom**
  - Guida in-game su come trovare e usare i Fossil Ore
  
### Traduzioni
- [x] **Aggiungere traduzioni in più lingue** ✅ **COMPLETATO (v2.2.1)**
  - Italiano ✅
  - Inglese ✅
  - Spagnolo ✅
  - Francese ✅
  - Tedesco ✅
  - Portoghese (BR) ✅

---

## 🎁 Contenuti Extra

### Priorità: 🟢 Bassa (v2.5.0+)

### Items
- [ ] **Fossil Detector**
  - Tool che indica la direzione dei Fossil Ore vicini
  - Simile al Recovery Compass

---

## 🐛 Bug Fix / Miglioramenti

### Priorità: 🔴 Continuo

- [ ] **Testing in-game** - Testare Fortune, Silk Touch, fusione in survival
- [ ] **Validazione config** - Testare con valori config personalizzati
- [ ] **Verifica spawn biomi** - Confermare spawn minerali solo in biomi corretti
- [ ] **Testing multiplayer** - Verificare compatibilità server
- [ ] **Profiling performance** - Controllare performance worldgen con 3 minerali
- [ ] **Compatibilità mod** - Testare con mod Fabric popolari
- [ ] **Casi limite** - Testare configurazioni e scenari inusuali

---

## 🎯 Prossima Milestone: v2.3.0

**Focus:** Espansione Dimensioni (Nether & End)

**Funzionalità Target:**
- Nether Fossil Ore (5 fossili tema fuoco/antico)
- End Fossil Ore (5 fossili rari/leggendari)
- Worldgen specifico per dimensione
- Config aggiornato per nuovi minerali

**Timeline Stimata:** 4-6 ore sviluppo

---

**Ultimo aggiornamento**: 22 Febbraio 2026

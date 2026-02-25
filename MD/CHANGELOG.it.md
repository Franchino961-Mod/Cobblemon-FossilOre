# Changelog

Tutte le modifiche importanti a questo progetto verranno documentate in questo file.

Il formato è basato su [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
e questo progetto segue il [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [Unreleased]

### Pianificato
- Texture animate e particelle visive
- Integrazione con mod di tech (Create, etc.)
- Varianti Nether/End per i Fossil Ore

---

## [2.2.2] - 2026-02-25

### Modificato
- **Generazione Marine Fossil Ore**: Sistema worldgen completamente rielaborato
  - Ora usa il placement `OCEAN_FLOOR_WG` heightmap per spawn accurato sul fondale marino
  - I fossili ora spawnano **sul e dentro la superficie del fondale** invece che casualmente in colonne d'acqua
  - Aggiunto `random_offset` con y_spread: -3 per incorporare naturalmente i fossili nei sedimenti del fondale
  - Scopribilità notevolmente migliorata - i fossili sono ora visibili quando ti immergi ed esplori sott'acqua
  - Tematicamente accurato: fossili marini incorporati in fondali sabbiosi/ghiaiosi, non in profondità sotterranea
- **Tasso di Spawn Bilanciato**: Regolata la frequenza di spawn per tutti i fossil ore
  - Marine Fossil Ore: Ridotto count da 30 a 10
  - Terrestrial Fossil Ore: Ridotto count da 18 a 10
  - Ancient Fossil Ore: Ridotto count da 18 a 10
  - Tutti e tre i minerali ora hanno rarità consistente, rendendo i fossili più preziosi e impegnativi da trovare
  - Fornisce miglior bilanciamento per gameplay survival e server multiplayer

### Risolto
- Marine Fossil Ore non spawna più in grotte sotterranee profonde o blocchi d'acqua casuali
- Il sistema di spawn del Marine Fossil Ore ora mira correttamente a posizioni visibili del fondale marino

### Tecnico
- Marine placed_feature.json: Sostituito `height_range` (uniforme Y -5 a 15) con `heightmap` (OCEAN_FLOOR_WG) + `random_offset`
- Tutti e tre i file placed_feature.json: Aggiornati valori count a 10 per tassi di spawn consistenti

**⚠️ Importante**: Le modifiche worldgen si applicano solo ai chunk appena generati. Esplora nuove aree o crea un nuovo mondo per vedere la generazione fossili aggiornata!

---

## [2.2.1] - 2026-02-23

### Aggiunto
- **Comando /fossilore reload**: Ricarica la configurazione in-game senza riavviare (richiede OP livello 2)
- **Supporto JEI/REI**: Le ricette di smelting sono ora automaticamente compatibili con mod di recipe viewer
- **Traduzioni Multilingua**: Aggiunto supporto per 4 nuove lingue
  - Spagnolo (es_es)
  - Francese (fr_fr)
  - Tedesco (de_de)
  - Portoghese Brasiliano (pt_br)

### Modificato
- Suggerimenti dipendenze opzionali per JEI/REI in fabric.mod.json

### Tecnico
- Nuova classe `ReloadCommand` per gestione comandi in-game
- Registrazione comando tramite CommandRegistrationCallback
- Struttura multilingua completa in assets/lang/

---

## [2.2.0] - 2026-02-22

### Aggiunto
- **Sistema di Configurazione**: Supporto completo per configurazione basata su JSON
  - File config: `config/cobblemon-fossil-ore.json`
  - **Impostazioni Generazione Mondo**: Personalizza dimensione vene, range Y, pattern distribuzione per tipo minerale
  - **Moltiplicatori Fortune**: Regola percentuali di chance per Fortune I/II/III
  - **Personalizzazione Drop Rate**: Imposta probabilità di drop individuali per fossili
  - **Filtro Biomi**: Whitelist/blacklist biomi per generazione minerali (avanzato)
- Config predefinito generato automaticamente al primo avvio
- Validazione errori e gestione config

### Modificato
- Probabilità Fortune ora configurabili (default: 33%/66%/99%)
- Parametri generazione minerali ora letti dal config invece di essere hardcoded
- Massimo fossili per blocco configurabile (default: 2)

### Tecnico
- Nuova classe `ModConfig` con serializzazione/deserializzazione JSON
- Config caricato durante inizializzazione mod
- Blocchi minerali ora interrogano config per moltiplicatori Fortune

### Per Admin Server
- Personalizzazione facile per creatori modpack
- Bilanciamento modificabile senza cambiare codice
- Interruttori attiva/disattiva per singolo minerale
- **Nota**: Modifiche config richiedono riavvio server/gioco

---

## [2.1.0] - 2026-02-23

### Aggiunto
- **Sistema di Fusione**: I Fossil Ore possono ora essere fusi per ottenere fossili specifici garantiti
  - **Marine Fossil Ore** → Dome Fossil (Kabuto)
  - **Terrestrial Fossil Ore** → Skull Fossil (Cranidos)
  - **Ancient Fossil Ore** → Old Amber (Aerodactyl)
- **Supporto Fornace**: Fusione normale richiede 10 secondi (200 tick) con ricompensa di 0.7 XP
- **Supporto Blast Furnace**: Fusione veloce richiede 5 secondi (100 tick) con ricompensa di 0.7 XP
- La fusione crea una scelta strategica: minare per fossili casuali (bonus Fortune) o fondere per fossile specifico garantito

### Note di Design
- La fusione fornisce fossili specifici consistenti vs. i drop casuali del mining
- Trade-off: Il mining può dare 2 fossili con Fortune, la fusione sempre 1
- Ogni tipo di minerale produce il suo fossile più iconico quando fuso

---

## [2.0.0] - 2026-02-22

### 🔥 MODIFICHE INCOMPATIBILI
- **Completa riprogettazione del sistema ore**: Rimossi i generici `Fossil Ore` e `Deepslate Fossil Ore`
- **Nuovi blocchi tematici**: Introdotti 3 tipi di minerale tematico con generazione specifica per bioma
- **Rigenerazione del mondo richiesta**: I blocchi Fossil Ore esistenti spariranno nei chunk caricati

### Aggiunto
- **Marine Fossil Ore** - Genera nei biomi acquatici (oceano, fiume, spiaggia, palude) da Y -64 a Y 45
  - Droppa 5 fossili acquatici: Dome, Helix, Cover, Root, Fossilized Fish
- **Terrestrial Fossil Ore** - Genera nella maggior parte dei biomi overworld (esclusi acquatici/deserti) da Y 8 a Y 64 (picco a Y 36)
  - Droppa 5 fossili terrestri: Skull, Armor, Jaw, Claw, Fossilized Dino
- **Ancient Fossil Ore** - Genera nei biomi deserto, badlands e savana da Y 8 a Y 64 (picco a Y 36)
  - Droppa 5 fossili antichi: Old Amber, Plume, Fossilized Bird, Sail, Fossilized Drake
- Tag bioma per controllo preciso della distribuzione dei minerali
- Sistema di drop tematico: Ogni minerale droppa fossili corrispondenti al suo tema

### Modificato
- Dimensione vene aumentata da 3 a 4 blocchi per tutti i minerali
- La generazione dei minerali ora usa filtri specifici per bioma per gameplay strategico
- Ogni fossile ora ha 20% di probabilità di drop nel suo tipo di minerale (vs. 6.67% in v1.0.0)

### Rimosso
- `Fossil Ore` generico (variante stone)
- Variante `Deepslate Fossil Ore`
- Sistema di drop casuale su tutti i 15 fossili

### Note di Migrazione
- Esplora nuovi chunk per trovare i nuovi tipi di minerale
- I vecchi blocchi Fossil Ore nei chunk esistenti saranno invalidi e dovrebbero essere rimpiazzati
- Usa comandi `/fill` per rimuovere i vecchi minerali se necessario

---

## [1.0.0] - 2026-02-22

### Aggiunto
- **Fossil Ore** - Minerale che genera nell'Overworld normale (stone)
- **Deepslate Fossil Ore** - Variante deepslate del minerale
- Generazione naturale da Y -64 a Y 100 (concentrazione massima a Y 18)
- Drop casuali di tutti i 15 fossili Cobblemon:
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
- Supporto per incantesimo **Fortune** (fino a 2 fossili per blocco con Fortune III)
- Supporto per **Silk Touch** (ottieni il blocco ore invece dei fossili)
- Texture custom per entrambi i blocchi ore
- Loot table configurabili
- Compatibilità con tutti i biomi Overworld
- Supporto multiplayer completo
- README in italiano e inglese
- Licenza MIT

### Caratteristiche Tecniche
- Vene fino a 3 blocchi per spawn
- Richiede piccone di legno o superiore per essere minato
- Compatibilità Fabric 1.21.1
- Integrazione completa con Cobblemon 1.6.0+

---

## Formato Versioni

### [Versione] - Data

#### Aggiunto
Nuove funzionalità aggiunte.

#### Modificato
Cambiamenti a funzionalità esistenti.

#### Deprecato
Funzionalità che verranno rimosse in versioni future.

#### Rimosso
Funzionalità rimosse.

#### Corretto
Bug fix.

#### Sicurezza
Patch di sicurezza.

---

**Note**: Per vedere i dettagli completi della mod e le istruzioni di installazione, consulta il [README.md](../README.md) o [README.it.md](README.it.md).

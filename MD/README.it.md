# Cobblemon Fossil Ore

Una mod addon per Cobblemon che aggiunge minerali di fossili al mondo di Minecraft, offrendo un nuovo modo per ottenere i fossili necessari per riportare in vita i Pokémon preistorici!

[![en](https://img.shields.io/badge/lang-en-red.svg)](../README.md)
[![it](https://img.shields.io/badge/lang-it-green.svg)](README.it.md)

> 📝 **Cronologia Versioni**: Vedi [CHANGELOG](CHANGELOG.it.md) per tutti gli aggiornamenti e modifiche.

> 📋 **TODO & Roadmap**: Controlla [TODO](TODO.it.md) per le funzionalità pianificate.

## 📋 Descrizione

Questa mod aggiunge tre blocchi minerali tematici all'Overworld, ognuno contenente fossili di diverse ere preistoriche:

- **Marine Fossil Ore** - Si trova nei biomi acquatici (oceani, fiumi, spiagge, paludi). Contiene fossili di antiche creature marine.
- **Terrestrial Fossil Ore** - Si trova nella maggior parte dei biomi overworld. Contiene fossili di dinosauri terrestri e animali preistorici.
- **Ancient Fossil Ore** - Si trova nei biomi deserto, badlands e savana. Contiene fossili di creature volanti e gli esemplari più antichi.

Quando minati, ogni minerale droppa uno di 5 fossili specifici che corrispondono al suo tema, offrendo un modo strategico per ottenere i fossili di cui hai bisogno esplorando biomi specifici!

## ⚙️ Requisiti

- **Minecraft**: 1.21.1
- **Fabric Loader**: 0.16.9 o superiore
- **Fabric API**: 0.108.0 o superiore
- **Cobblemon**: 1.6.0 o superiore

## 📦 Installazione

1. Assicurati di avere installato Fabric Loader, Fabric API e Cobblemon
2. Scarica il file `.jar` della mod
3. Posiziona il file nella cartella `mods` della tua installazione di Minecraft
4. Avvia il gioco!

## 🔍 Come Trovare i Fossil Ore

**Novità nella v2.2.2!** La generazione del Marine Ore è stata completamente rielaborata per spawnare naturalmente sul fondale oceanico, rendendo i fossili molto più facili da scoprire quando ti immergi!

### Marine Fossil Ore 🌊
- **Biomi**: Oceani, fiumi, spiagge, paludi, paludi di mangrovie
- **Generazione**: Spawna **sul e dentro il fondale** dell'oceano (superficie del fondo marino)
- **Profondità**: Si posiziona automaticamente sui blocchi solidi sott'acqua (tipicamente Y -5 a Y 15)
- **Target**: Sostituisce pietra, sabbia e ghiaia sul fondale marino
- **Dimensione vene**: fino a 4 blocchi per vena
- **Rarità**: Tasso di spawn bilanciato per un'esplorazione impegnativa ma gratificante

**Migliore strategia di mining**: Immergiti ed esplora la superficie del fondale oceanico. I fossili sono incastonati nei sedimenti del fondale, rendendoli visibili quando nuoti sott'acqua. Guarda attentamente lungo i letti di sabbia e ghiaia!

### Terrestrial Fossil Ore 🦴
- **Biomi**: Tutti i biomi overworld TRANNE biomi acquatici e deserti
- **Altezza (Y Level)**: da Y 8 a Y 64
- **Concentrazione ottimale**: circa Y 36 (distribuzione trapezoidale)
- **Dimensione vene**: fino a 4 blocchi per vena
- **Rarità**: Tasso di spawn bilanciato per un'esplorazione impegnativa ma gratificante

**Migliore strategia di mining**: Scava negli strati di pietra intorno a Y 36 in foreste, pianure, montagne e biomi taiga.

### Ancient Fossil Ore 🏜️
- **Biomi**: Deserto, badlands, savana (tutte le varianti)
- **Altezza (Y Level)**: da Y 8 a Y 64
- **Concentrazione ottimale**: circa Y 36 (distribuzione trapezoidale)
- **Dimensione vene**: fino a 4 blocchi per vena
- **Rarità**: Tasso di spawn bilanciato per un'esplorazione impegnativa ma gratificante

**Migliore strategia di mining**: Esplora le grotte del deserto e le formazioni badlands intorno a Y 36.

**⚠️ Importante**: I minerali si generano solo in chunk nuovi! Se stai giocando in un mondo esistente, dovrai esplorare nuove aree o creare un nuovo mondo.

## ⛏️ Meccaniche di Mining

### Drop Base
- **Piccone richiesto**: Legno o superiore
- **Drop senza incantesimi**: 1 fossile casuale

### Fortune (Fortuna)
L'incantesimo Fortune aumenta le possibilità di ottenere fossili extra:
- **Fortune I**: ~33% di possibilità di ottenere 2 fossili
- **Fortune II**: ~66% di possibilità di ottenere 2 fossili
- **Fortune III**: ~99% di possibilità di ottenere 2 fossili
- **Massimo**: 2 fossili per blocco

Ogni fossile è scelto indipendentemente e casualmente, quindi potresti ottenere due fossili diversi dallo stesso blocco!

### Silk Touch (Tocco di Velluto)
Se usi un piccone con Silk Touch, otterrai il blocco Fossil Ore stesso invece dei fossili, permettendoti di spostarlo o collezionarlo.

## 🔥 Sistema di Fusione

I Fossil Ore possono essere fusi nelle fornaci come metodo alternativo per ottenere fossili!

### Fornace Normale
- **Tempo**: 10 secondi (200 tick)
- **Carburante**: Qualsiasi carburante standard per fornace (carbone, legna, secchio di lava, ecc.)
- **Esperienza**: 0.7 XP per minerale fuso
- **Output**: 1 fossile specifico garantito (vedi tabella sotto)

### Blast Furnace (Altoforno)
- **Tempo**: 5 secondi (100 tick) - due volte più veloce!
- **Carburante**: Qualsiasi carburante standard per fornace
- **Esperienza**: 0.7 XP per minerale fuso
- **Output**: Uguale alla fornace normale

### Risultati della Fusione

Ogni tipo di minerale produce un fossile iconico specifico quando fuso:

| Tipo di Minerale | Fossile Prodotto | Pokémon |
|------------------|------------------|---------|
| **Marine Fossil Ore** | Dome Fossil | Kabuto (iconico trilobite acquatico) |
| **Terrestrial Fossil Ore** | Skull Fossil | Cranidos (classico dinosauro) |
| **Ancient Fossil Ore** | Old Amber | Aerodactyl (leggendario fossile volante) |

### Scelta Strategica: Mining vs. Fusione

**Mining** (rompere il minerale con il piccone):
- ✅ Ottieni fossile casuale tra 5 tipi possibili
- ✅ L'incantesimo Fortune può dare 2 fossili
- ❌ Devi trovare e minare il minerale
- ❌ Il tipo di fossile è imprevedibile

**Fusione** (fornace/altoforno):
- ✅ Ottieni fossile specifico garantito (sempre lo stesso)
- ✅ Automatizzabile con sistemi hopper
- ✅ L'altoforno è super veloce (5 secondi)
- ❌ Dà sempre esattamente 1 fossile
- ❌ Richiede carburante e tempo

**Esempio**: Se hai bisogno specificatamente di un Dome Fossil per Kabuto, puoi fondere blocchi di Marine Fossil Ore invece di sperare in un drop del 20% dal mining!

## 🦴 Fossili Disponibili

Ogni tipo di minerale droppa fossili di un tema specifico, rendendo più facile trovare quelli di cui hai bisogno!

### Marine Fossil Ore 🌊 (Biomi acquatici)
- **Dome Fossil** (Kabuto)
- **Helix Fossil** (Omanyte)
- **Cover Fossil** (Tirtouga)
- **Root Fossil** (Lileep)
- **Fossilized Fish** (Dracozolt)

### Terrestrial Fossil Ore 🦴 (Maggior parte dei biomi terrestri)
- **Skull Fossil** (Cranidos)
- **Armor Fossil** (Shieldon)
- **Jaw Fossil** (Tyrunt)
- **Claw Fossil** (Anorith)
- **Fossilized Dino** (Arctovish)

### Ancient Fossil Ore 🏜️ (Biomi deserto/savana)
- **Old Amber** (Aerodactyl)
- **Plume Fossil** (Archen)
- **Fossilized Bird** (Archeops)
- **Sail Fossil** (Amaura)
- **Fossilized Drake** (Dracovish)

Una volta ottenuti, puoi usare i fossili esattamente come nella Cobblemon standard per riportare in vita i Pokémon preistorici!

## ⚙️ Configurazione

**Novità nella v2.2.0!** La mod ora supporta la configurazione per admin di server e creatori di modpack.

### Posizione File Config
Dopo il primo avvio, verrà creato un file di configurazione in:
```
config/cobblemon-fossil-ore.json
```

### Impostazioni Configurabili

#### Generazione Mondo
Personalizza la generazione dei minerali per ogni tipo:
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
- **veinSize**: Numero di blocchi minerali per vena (default: 4)
- **minY/maxY**: Intervallo di altezza per la generazione
- **enabled**: Attiva/disattiva tipo di minerale specifico
- **distribution**: Pattern di generazione (uniform, trapezoid_X)

#### Moltiplicatori Fortune
Regola l'efficacia dell'incantesimo Fortune:
```json
"fortune": {
  "fortuneIChance": 0.33,
  "fortuneIIChance": 0.66,
  "fortuneIIIChance": 0.99,
  "maxFossilsPerBlock": 2
}
```
I valori rappresentano la probabilità (0.0-1.0) di ottenere un secondo fossile.

#### Drop Rate (Avanzato)
Regola finemente i tassi di drop dei singoli fossili:
```json
"dropRates": {
  "customDropRates": false,
  "marineFossils": {
    "dome_fossil": 0.20,
    "helix_fossil": 0.20
  }
}
```
Imposta `customDropRates: true` per abilitare probabilità personalizzate. Tutti i fossili devono sommare a 1.0 (100%).

#### Filtro Biomi (Avanzato)
Sovrascrivi lo spawning predefinito dei biomi:
```json
"biomes": {
  "useCustomBiomeFilters": false,
  "marineOreWhitelist": [],
  "marineOreBlacklist": []
}
```

### Ricarica Config
**Novità nella v2.2.1!** Ora puoi ricaricare la configurazione senza riavviare:
```
/fossilore reload
```
**Requisiti**: Permesso OP livello 2 (solo operatori server)

## 🏆 Obiettivi (Advancement)

**Novità nella v2.2.1!** La mod include obiettivi per tracciare i tuoi progressi nella caccia ai fossili:

### Paleontologo
- **Descrizione**: Trova il tuo primo Minerale Fossile
- **Ricompensa**: 50 Punti Esperienza
- **Come ottenerlo**: Mina o raccogli qualsiasi blocco Fossil Ore (Marino, Terrestre o Antico)

### Cacciatore di Fossili 🏆
- **Descrizione**: Raccogli tutti i 15 tipi di fossili
- **Tipo**: Obiettivo sfida
- **Ricompensa**: 500 Punti Esperienza
- **Come ottenerlo**: Raccogli almeno uno di ciascuno dei 15 diversi fossili di Cobblemon
- **Consiglio**: Usa l'incantesimo Fortune III e esplora biomi specifici per raccogliere tutti i fossili più velocemente!

## 💻 Comandi

**Novità nella v2.2.1!** Comandi admin per la gestione del server:

### /fossilore reload
Ricarica la configurazione della mod dal file senza riavviare il server o il gioco.
- **Permesso**: Richiede OP livello 2
- **Utilizzo**: `/fossilore reload`
- **Feedback**: Conferma quando la configurazione è stata ricaricata con successo

## 🎮 Compatibilità

Questa mod è progettata per integrarsi perfettamente con Cobblemon **senza modificare** il sistema di fossili esistente. Aggiunge semplicemente un nuovo metodo per ottenerli, mantenendo intatti tutti i metodi originali.

### Mod Visualizzatori Ricette
**Novità nella v2.2.1!** Piena compatibilità con:
- **JEI (Just Enough Items)**: Ricette di fusione visualizzate automaticamente
- **REI (Roughly Enough Items)**: Ricette di fusione visualizzate automaticamente

Nessuna configurazione aggiuntiva richiesta - le ricette vengono rilevate automaticamente!

### Lingue Supportate
**Novità nella v2.2.1!** La mod ora supporta 6 lingue:
- 🇺🇸 Inglese (en_us)
- 🇮🇹 Italiano (it_it)
- 🇪🇸 Spagnolo (es_es)
- 🇫🇷 Francese (fr_fr)
- 🇩🇪 Tedesco (de_de)
- 🇧🇷 Portoghese Brasiliano (pt_br)

## ❓ FAQ

**Q: I fossili che ottengo sono uguali a quelli normali di Cobblemon?**  
A: Sì! Sono esattamente gli stessi item e funzionano allo stesso modo.

**Q: Posso trovare i Fossil Ore nel mio mondo esistente?**  
A: Sì, ma solo in chunk che non sono ancora stati generati. Dovrai esplorare nuove aree.

**Q: Posso usare questa mod con altre mod oltre a Cobblemon?**  
A: Sì, la mod dovrebbe essere compatibile con altre mod Fabric, purché non modifichino pesantemente il sistema di generazione del mondo.

**Q: Posso modificare la rarità o l'altezza di generazione?**  
A: Sì! Dalla v2.2.0+, puoi personalizzare la generazione dei minerali, le probabilità Fortune, i drop rate e altro tramite il file di configurazione in `config/cobblemon-fossil-ore.json`. Vedi la sezione Configurazione sopra per i dettagli.

**Q: La mod funziona in multiplayer?**  
A: Sì! Funziona sia in singleplayer che in multiplayer. Deve essere installata sul server.

## 📝 Licenza

Questa mod è rilasciata sotto [licenza MIT](../LICENSE). Sentiti libero di includerla nei tuoi modpack!

## 🐛 Segnalazione Bug

Se incontri problemi o bug, per favore segnalali con:
- Versione della mod
- Versione di Minecraft/Fabric/Cobblemon
- Descrizione dettagliata del problema
- Log di crash (se applicabile)

---

**Buon mining e buona fortuna con i tuoi Pokémon fossili!** 🦕⛏️

# True Tile Clue Areas

A RuneLite plugin that highlights the **true dig/emote area** for clue scroll steps, instead of the single tile that the base clue scroll plugin highlights.
## Preview
### Map clue
![Map clue area highlight](doc/map-compressed.webp)
### Hot&Cold clue
![Hot&Cold clue area highlight](doc/h&c-compressed.webp)
### Emote clue
![Emote clue area highlight](doc/emote-compressed.webp)
## Features

- Highlights the true dig area for **map clue** steps
- Highlights the true location area for **emote clue** steps
- Highlights the true dig area for **hot/cold clue** steps
- Highlights the true dig area for **coordinate clue** steps - *Coming soon*
- Highlights the true dig area for **cryptic clue** steps - *Coming soon*
- Configurable — toggle each clue type on/off, change highlight colors

## Supported Clue Tiers

| Tier | Map Clues | Emote Clues | Hot/Cold | Coordinate | Cryptic |
|------|-----------|-------------|----------|----------|----------|
| Beginner | ✅ Verified | ✅ Verified | ✅ Verified | N/A | N/A |
| Easy | 🔲 Needs data | 🔲 Needs data | N/A | N/A | 🔲 Needs data |
| Medium | 🔲 Needs data | 🚧 In Progress | N/A | 🔲 Needs data | N/A |
| Hard | 🔲 Needs data | 🔲 Needs data | N/A | 🔲 Needs data | 🔲 Needs data |
| Elite | 🚧 In Progress | 🔲 Needs data | N/A | 🔲 Needs data | 🔲 Needs data |
| Master | N/A | 🚧 In Progress | 🚧 In Progress | 🔲 Needs data | 🔲 Needs data |
___
### [Contribute to the plugin here!](contributing.md)
___
## Changelog

#### 1.2.1
- Added support for an additional 2 Easy Emote steps, 18 Medium Emote steps, 3 Hard Emote steps, 5 Master Emote steps and modified one Master Emote step
#### 1.2.0
- Reworked the plugin's logic to use RuneLite's build in Clue Scroll Plugin for H&C, Map and Cryptic clues
- Added support for an additional 21 Easy Emote steps and 3 Master Emote steps

#### 1.1.0
- Added individual tile rendering option in config (the new option ```Individual Tiles``` is selected by default)
- Added support for 5 new clue steps: 2 Master Emote steps, 2 Medium Emote steps and 1 Elite Map step

#### 1.0.1
- Fixed overlay persisting after clue step completion

#### 1.0.0
- Initial release

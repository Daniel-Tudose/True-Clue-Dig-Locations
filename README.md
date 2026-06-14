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
- Highlights the true dig area for **coordinate clue** steps
- Highlights the true dig area for **cryptic clue** steps
- Configurable — toggle each clue type on/off, change highlight colors

## Supported Clue Tiers

| Tier | Map Clues | Emote Clues | Hot/Cold | Coordinate | Cryptic |
|------|-----------|-------------|----------|----------|----------|
| Beginner | ![](https://img.shields.io/badge/Implemented-100%25-green) | ![](https://img.shields.io/badge/Implemented-100%25-green) | ![](https://img.shields.io/badge/Implemented-100%25-green) | N/A | N/A |
| Easy | ![](https://img.shields.io/badge/Implemented-100%25-green) | ![](https://img.shields.io/badge/Implemented-29/33-orange) | N/A | N/A | 🚧 In Progress |
| Medium | ![](https://img.shields.io/badge/Implemented-100%25-green) | ![](https://img.shields.io/badge/Implemented-21/25-orange) | N/A | ![](https://img.shields.io/badge/Implemented-100%25-green) | N/A |
| Hard | ![](https://img.shields.io/badge/Implemented-100%25-green) | ![](https://img.shields.io/badge/Implemented-5/17-orange) | N/A | ![](https://img.shields.io/badge/Implemented-100%25-green) | 🚧 In Progress |
| Elite | ![](https://img.shields.io/badge/Implemented-100%25-green) | ![](https://img.shields.io/badge/Implemented-9/19-orange) | N/A | ![](https://img.shields.io/badge/Implemented-100%25-green) | 🚧 In Progress |
| Master | N/A | ![](https://img.shields.io/badge/Implemented-24/25-orange) | ![](https://img.shields.io/badge/Implemented-100%25-green) | ![](https://img.shields.io/badge/Implemented-100%25-green) | 🚧 In Progress |
___
### [Contribute to the plugin here!](contributing.md)
___
## Changelog

#### 1.3.1
- Overlay bugfixes
- "Blow a kiss outside K'ril Tsutsaroth's chamber" Master step should now display correctly
- Added support for 5 Easy Emote steps, 2 Hard Emote steps, 7 Elite Emote steps and 3 Master Emote steps
- Added support for 1 off-centered Hard Cryptic step
#### 1.3.0
- Added support for cryptic clues; also added custom areas for 7 Master Cryptic steps
- Added support for 1 Easy Emote step, 1 Medium Emote step and 11 Master Emote steps
- Added support for 2 new Elite Emote steps
- Bugfix: emote steps display their area correctly now
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

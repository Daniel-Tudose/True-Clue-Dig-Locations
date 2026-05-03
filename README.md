# True Tile Clue Areas

A RuneLite plugin that highlights the **true dig/emote area** for clue scroll steps, instead of the single tile that the base clue scroll plugin highlights.

---

## Features

- Highlights the true dig area for **map clue** steps
- Highlights the true location area for **emote clue** steps
- Highlights the true dig area for **hot/cold clue** steps
- Highlights the true dig area for **coordinate clue** steps - *Coming soon*
- Highlights the true dig area for **cryptic clue** steps - *Coming soon*
- Configurable — toggle each clue type on/off, change highlight colors

---

## Supported Clue Tiers

| Tier | Map Clues | Emote Clues | Hot/Cold | Coordinate | Cryptic |
|------|-----------|-------------|----------|----------|----------|
| Beginner | ✅ Partial (verifying) | ✅ Partial (verifying) | ✅ | N/A | N/A |
| Easy | 🔲 Needs data | 🔲 Needs data | N/A | N/A | 🔲 Needs data |
| Medium | 🔲 Needs data | 🔲 Needs data | N/A | 🔲 Needs data | N/A |
| Hard | 🔲 Needs data | 🔲 Needs data | N/A | 🔲 Needs data | 🔲 Needs data |
| Elite | 🔲 Needs data | 🔲 Needs data | N/A | 🔲 Needs data | 🔲 Needs data |
| Master | 🔲 Needs data | 🔲 Needs data | ✅ (testing needed) | 🔲 Needs data | 🔲 Needs data |

---

## Contributing — Adding Clue Area Data

This plugin's data grows through community contributions. If you have a clue step that isn't covered yet, here's how to add data:

### What You Need

- The clue scroll step you want to add
- A way to find exact tile coordinates (see tools below)
- Patience and perseverence to verify the actual dig/emote area size

### Tools for Finding Coordinates

**Radius Markers plugin (Plugin Hub)**
Install from the Plugin Hub. This lets you place a marker on the tile the player is standing on (plus some radiuses around it). The plugin also tell you the exact coordinates of that tile - this is what we are after!

**Developer Tools (RuneLite developer mode)**
If running RuneLite in developer mode, the developer tools panel has a "Location" button that shows the `WorldPoint` of your current tile.

### Finding the Correct WorldPoint

1. Get the clue step you want to add (good luck and may you roll awesome on the reward table)
2. Go to the dig/emote location indicated by the clue
3. The tile that has the clue arrow / emote indicator is roughly the center of the area
4. Stand outside the possible "active" area (see Finding the Area Size below)
5. Start performing the emote / digging towards that center, moving one tile at a time
6. Mark the tile the step completes - that will be your North/South/East/West border of the area.
7. Continue with the rest of the clue and repeat 2-6 for any other steps you get.
8. If you get the same step as before, choose another direction and do 2-7
9. When you have the 4 borders of the area you can pinpoint the center of that area (in case the tile indicator is not centered) and the height / width of the area

### Finding the Area Size
Most areas are square:
- Map clues: usually **3×3**
- Emote clues: some are **3×3** or rectangles
- Hot/cold clues: always **9×9**
- Coordinate clues: *More data needed*

### Adding Map Clue Data
- [ ] [Beginner Map Clue Steps Thread](https://github.com/Daniel-Tudose/True-Clue-Dig-Locations/issues/1#issue-4372315461)
- [ ] Easy Map Clue Steps Thread - Coming soon
- [ ] Medium Map Clue Steps Thread - Coming soon
- [ ] Hard Map Clue Steps Thread - Coming soon
- [ ] Elite Map Clue Steps Thread - Coming soon
- [ ] Master Map Clue Steps Thread - Coming soon

### Adding Emote Clue Data
- [ ] [Beginner Emote Clue Steps Thread](https://github.com/Daniel-Tudose/True-Clue-Dig-Locations/issues/3#issue-4372430299)
- [ ] Easy Emote Clue Steps Thread - Coming soon
- [ ] Medium Emote Clue Steps Thread - Coming soon
- [ ] Hard Emote Clue Steps Thread - Coming soon
- [ ] Elite Emote Clue Steps Thread - Coming soon

### Adding Coordinate Clue Data

*Future Feature*

### Adding Cryptic Clue Data

*Future Feature*

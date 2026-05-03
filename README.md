# True Tile Clue Areas

A RuneLite plugin that highlights the **true dig/emote area** for clue scroll steps, instead of the single tile that the base clue scroll plugin highlights.

---

## Features

- Highlights the true dig area for **map clue** steps
- Highlights the true location area for **emote clue** steps
- Highlights the true dig area for **hot/cold clue** steps
- Highlights the true dig area for **coordinate clue** steps - *Coming soon*
- Configurable — toggle each clue type on/off, change highlight colors

---

## Supported Clue Tiers

| Tier | Map Clues | Emote Clues | Hot/Cold | Coordinate |
|------|-----------|-------------|----------|----------|
| Beginner | ✅ Partial (verifying) | ✅ Partial (verifying) | ✅ | N/A |
| Easy | 🔲 Needs data | 🔲 Needs data | N/A | N/A |
| Medium | 🔲 Needs data | 🔲 Needs data | N/A | 🔲 Needs data |
| Hard | 🔲 Needs data | 🔲 Needs data | N/A | 🔲 Needs data |
| Elite | 🔲 Needs data | 🔲 Needs data | N/A | 🔲 Needs data |
| Master | 🔲 Needs data | 🔲 Needs data | ✅ (testing needed) | 🔲 Needs data |

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
- Emote clues: usually **7×7**, some are **3×3** or rectangles
- Hot/cold clues: always **9×9**
- Coordinate clues: *More data needed*

### Adding Map Clue Data

Open the file for the relevant tier in `src/main/java/com/example/data/map/`:

```
BeginnerMapClueAreas.java  ← beginner tier
EasyMapClueAreas.java      ← easy tier
MediumMapClueAreas.java    ← medium tier
HardMapClueAreas.java      ← hard tier
EliteMapClueAreas.java     ← elite tier
MasterMapClueAreas.java    ← master tier
```

Add an entry to the `AREAS` map. The key is the Widget ID of the clue map image. You can find this by opening your clue scroll in developer mode and using the Widget Inspector tool — look for the group ID of the map image interface.

```java
.put(WIDGET_ID_HERE,
    new DigArea(new WorldPoint(x, y, plane), size))

// For a rectangle instead of a square:
.put(WIDGET_ID_HERE,
    new DigArea(new WorldPoint(x, y, plane), width, height))
```

### Adding Emote Clue Data

Open the file for the relevant tier in `src/main/java/com/example/data/emote/`:

```
BeginnerEmoteClueAreas.java
EasyEmoteClueAreas.java
...
```

The key is the **exact clue text** as it appears when you read the clue scroll. Make sure to copy it exactly, including punctuation:

```java
.put("Blow a kiss outside the Party Room. Equip a steel medium helmet and a Kilt.",
    new DigArea(new WorldPoint(x, y, plane), size))
```

To get the exact text, open the clue scroll in-game and copy the text shown. Remove any colour tags if present.

### Submitting Your Contribution

1. Fork this repository on GitHub
2. Add your data to the relevant file
3. Test it in-game to confirm the area is correct
4. Submit a pull request with a description of what you added and how you verified it

Please include in your PR description:
- Which clue step you added
- The WorldPoint you used as the center
- The area size and how you verified it
- A screenshot if possible showing the overlay on the correct area

---

## Known Issues and Limitations

- Some beginner map clue coordinates are still being fine-tuned — if you find one that is off, please open an issue or submit a correction
- Emote clue area sizes for most tiers are unverified — the areas shown may not be accurate until community members test and submit corrections
- The plugin detects clue steps by listening to game events. If you log in mid-clue, the overlay will not appear until you re-open the clue scroll

---

## How It Works (Technical)

**Map clues** are detected via `WidgetLoaded` — when the clue map image interface opens, the plugin reads the widget group ID and looks it up in the data map.

**Emote clues** are detected via `ChatMessage` — when you read a clue scroll, the text appears as a game message. The plugin matches this against known emote clue texts.

**Hot/cold clues** use RuneLite's own `HotColdSolver` and `HotColdLocation` classes. The plugin listens for strange device temperature readings, feeds them into the solver, and draws the overlay when the solver narrows down to a configurable number of remaining locations.

The overlay clears automatically when the clue step is completed, detected by the removal of the RuneLite hint arrow that the base clue scroll plugin places on the target tile.

---

## Credits

- Clue scroll location data sourced from the [RuneLite](https://github.com/runelite/runelite) clue scroll plugin
- Hot/cold solver logic uses RuneLite's own `HotColdSolver` implementation
- Area size research by contributors — see pull request history

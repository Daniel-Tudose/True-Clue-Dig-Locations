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
If running RuneLite in developer mode, the developer tools panel has a "Location" / "Tile Location" button that shows the `WorldPoint` of your current tile.

### Finding the Correct WorldPoint

1. Get the clue step you want to add (good luck and may you roll awesome on the reward table)
2. Go to the dig/emote location indicated by the clue
3. The tile that has the clue arrow / emote indicator is roughly the center of the area
4. Stand outside the possible "active" area (see Finding the Area Size below)
5. Start performing the emote / digging towards that center, moving one tile at a time
6. 1. Mark the tile the step completes - that will be your North/South/East/West border of the area.
   2. If you are checking and Emote step, unless you click Uri to complete the step, you can hop worlds and check (step 5 & 6) the other 3 borders ;)
7. Continue with the rest of the clue and repeat 2-6 for any other steps you get.
8. If you get the same step as before, choose another direction and do 2-7
9. When you have the 4 borders of the area you can pinpoint the center of that area (in case the tile indicator is not centered) and the height / width of the area

### Finding the Area Size
Most areas are square:
- Map clues: usually **3×3**
- Emote clues: some are **5×5** or rectangles
- Hot/cold clues: always **7x7**(beginner) or **9×9**(master)
- Coordinate clues: *More data needed* (is it one tile only? all steps show the correct location then?)
- Cryptic clues: *More data needed* (is the area an actual 3x3 like map steps or is it bigger and possibly a rectangle as emote steps?)

### Adding Map Clue Data
- [x] [Beginner Map Clue Steps Thread](https://github.com/Daniel-Tudose/True-Clue-Dig-Locations/issues/1#issue-4372315461)
- [ ] [Easy Map Clue Steps Thread](https://github.com/Daniel-Tudose/True-Clue-Dig-Locations/issues/4#issue-4407753830)
- [ ] [Medium Map Clue Steps Thread](https://github.com/Daniel-Tudose/True-Clue-Dig-Locations/issues/5#issue-4407769223)
- [ ] [Hard Map Clue Steps Thread](https://github.com/Daniel-Tudose/True-Clue-Dig-Locations/issues/6#issue-4407780006)
- [ ] [Elite Map Clue Steps Thread](https://github.com/Daniel-Tudose/True-Clue-Dig-Locations/issues/7#issue-4407799473)

### Adding Emote Clue Data
- [ ] [Beginner Emote Clue Steps Thread](https://github.com/Daniel-Tudose/True-Clue-Dig-Locations/issues/3#issue-4372430299)
- [ ] [Easy Emote Clue Steps Thread](https://github.com/Daniel-Tudose/True-Clue-Dig-Locations/issues/8#issue-4407821433)
- [ ] [Medium Emote Clue Steps Thread](https://github.com/Daniel-Tudose/True-Clue-Dig-Locations/issues/9#issue-4407838694)
- [ ] [Hard Emote Clue Steps Thread](https://github.com/Daniel-Tudose/True-Clue-Dig-Locations/issues/10#issue-4407845807)
- [ ] [Elite Emote Clue Steps Thread](https://github.com/Daniel-Tudose/True-Clue-Dig-Locations/issues/11#issue-4407850976)
- [ ] [Master Emote Clue Steps Thread](https://github.com/Daniel-Tudose/True-Clue-Dig-Locations/issues/12#issue-4407856371)

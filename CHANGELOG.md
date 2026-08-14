# Changelog

#### 1.4.00 — 2026-08-14
- **[Feature]** Added a new **Misc** category in the configuration panel to allow independent toggle/color configuration for Music clues.
- **[Added]** Support for Music clue steps area highlights where you can play the song to Cecilia. Also for "Equip an abyssal whip in front of the abyssal demons of the Slayer Tower." Master Sherlock step.
- **[Added]** Custom dig areas for Hard Cryptic steps: Tear of the Soul, Mort'ton road intersection, Ket'sal fire in Kebos Swamp, Yu'biusk, Edgeville yew tree, Clan Cup trophy SW of Citharede Abbey and Elite Cryptic step "Dig near Dagannoth ladder".
- **[Added]** Support for 1 Medium Emote step ("Cry on Catherby beach") and 1 Elite Emote step ("Shrug in Shayzien war tent").
- **[Fixed]** Visual overlay flickering bug on Emote steps.
- **[Modified]** The highlighted area size for the Elite Emote step "Cheer in Shadow Dungeon" is now set to a 10x10 instead of the whole dungeon.

#### 1.3.7 — 2026-08-07
- **[Added]** Custom dig area for a Medium Map step (behind Chemist's house in Rimmington).
- **[Fixed]** Overlay transparency not respecting the user's configured alpha value in-game.
- **[Fixed]** Area coordinates for the Charcoal Burners Elite Emote step.

#### 1.3.6 — 2026-08-04
- **[Added]** Custom dig area for South of East Ardougne (DJP Fairy Ring) Medium Map step.
- **[Added]** Enhanced overlay support and interaction handling when juggling clue scrolls.
- **[Fixed]** Overlay coordinates for the emote clue step "Panic on Trollweiss mountain".

#### 1.3.5 — 2026-07-24
- **[Added]** Last 5 Hard Emote steps (Karamja banana plantation, Shilo Village bank, Rogues' general store, Jiggig, and Mess Hall) — Hard Emote clues 100% complete!
- **[Added]** Support for 1 Elite Emote step (Charcoal burners).
- **[Added]** Custom dig area highlights for Cryptic steps in Forthos Dungeon and the Champions' Guild chicken coop.
- **[Fixed]** (potential) Bug where the overlay would fail to update properly when juggling multiple clue scrolls of the same step.

#### 1.3.4 — 2026-07-12
- **[Added]** Support for 2 new Hard Emote steps: "Dance in Sophanem" and "Cheer atop the agility pyramid".
- **[Fixed]** Center coordinates for the Hard Map clue step south of the Yanille bank.
- **[Fixed]** Typo for the Exam Centre Hard Emote step.

#### 1.3.3 — 2026-06-28
- **[Added]** 1 Master Cryptic custom area (Terrorbird display).
- **[Added]** Support for 1 Easy Emote step, 1 Medium Emote step, 2 Hard Emote steps and the LAST Master Emote step.
- **[Added]** Core engine support for properly reading and parsing clue text strings containing apostrophes.

#### 1.3.2 — 2026-06-19
- **[Added]** Support for 1 Easy Emote step, 3 Hard Emote steps, and 7 Elite Emote steps.
- **[Fixed]** Area correction for Medium Map clue step (SE of lighthouse - ALP Fairy ring).
- **[Fixed]** Core bugfixes for Map and Cryptic steps.

#### 1.3.1 — 2026-06-14
- **[Added]** Support for 5 Easy Emote steps, 2 Hard Emote steps, 7 Elite Emote steps, and 3 Master Emote steps.
- **[Added]** Support for 1 off-centered Hard Cryptic step.
- **[Fixed]** General overlay stability bugfixes.
- **[Fixed]** "Blow a kiss outside K'ril Tsutsaroth's chamber" Master step emote.

#### 1.3.0 — 2026-06-06
- **[Added]** Initial support for Cryptic clues, including custom areas for 7 Master Cryptic steps.
- **[Added]** Support for 1 Easy Emote step, 1 Medium Emote step, and 11 Master Emote steps.
- **[Added]** Support for 2 new Elite Emote steps.
- **[Fixed]** Emote steps layout calculation so areas render properly in-game.

#### 1.2.1 — 2026-05-30
- **[Added]** Support for 2 Easy Emote steps, 18 Medium Emote steps, 3 Hard Emote steps, and 5 Master Emote steps.
- **[Modified]** Adjusted coordinates for 1 Master Emote step.

#### 1.2.0 — 2026-05-29
- **[Rework]** Complete architectural rewrite to hook directly into RuneLite's built-in Clue Scroll Plugin for H&C, Map, and Cryptic clues.
- **[Added]** Support for an additional 21 Easy Emote steps and 3 Master Emote steps.

#### 1.1.0 — 2026-05-19
- **[Added]** New `Individual Tiles` configuration option to allow users to toggle individual tile rendering (enabled by default).
- **[Added]** Support for 5 new clue steps: 2 Master Emote steps, 2 Medium Emote steps, and 1 Elite Map step.

#### 1.0.1 — 2026-05-15
- **[Fixed]** Overlay persisting on screen after a clue step was completed or when walking far away from the location.

#### 1.0.0 — 2026-05-08
- **[Release]** Initial release on the RuneLite Plugin Hub.
- **[Features]** True dig area highlights for baseline Beginner Map, Emote, and Hot/Cold steps.

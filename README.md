# Minecraft StoryMode+

Eine eigenständige, deutsch lokalisierte Story-Mod für **Minecraft Forge 1.20.1**.
Sie enthält den Archivführer-NPC, die dreiteilige Quest „Das flüsternde Archiv“,
ein eigenes Rezept, Story-Gegenstände und eine clientseitige Finale-Cutscene.

## Entwicklungsstart

1. Java 17 installieren.
2. In diesem Ordner `gradlew genIntellijRuns` (oder `gradle genIntellijRuns`) ausführen.
3. Die Run-Konfiguration `runClient` starten.

Im Kreativmodus: `/summon echoesofarcadia:archive_guide`.
Einen Echosplitter stellst du aus Amethystscherben und einem Diamanten her.

## Quest

1. Sprich den Archivführer an.
2. Stelle einen Echosplitter her und sprich erneut mit ihm.
3. Erlebe die finale Erinnerungscutscene.

Der Fortschritt liegt pro Spieler in persistenten Entity-Daten und bleibt somit
auch nach Tod oder Weltwechsel erhalten.

## Titelmenü

Beim Start ersetzt die Mod das Vanilla-Titelmenü durch **Minecraft StoryMode+**.
Das eingebundene Hintergrundbild liegt unter `assets/echoesofarcadia/textures/gui/`;
der gelbe Splash lautet „Made by EinfachMerliin“.

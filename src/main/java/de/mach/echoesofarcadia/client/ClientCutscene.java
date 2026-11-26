package de.mach.echoesofarcadia.client;

import net.minecraft.client.Minecraft;

public final class ClientCutscene {
    private ClientCutscene() {}

    public static void play() {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null) {
            minecraft.setScreen(new ArcadiaCutsceneScreen());
        }
    }
}

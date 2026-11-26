package de.mach.echoesofarcadia.client;

import de.mach.echoesofarcadia.EchoesOfArcadia;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

/** Lightweight cinematic overlay. It does not pause multiplayer or alter player data. */
public final class ArcadiaCutsceneScreen extends Screen {
    private static final int DURATION_TICKS = 180;
    private int age;

    public ArcadiaCutsceneScreen() {
        super(Component.translatable("cutscene." + EchoesOfArcadia.MOD_ID + ".title"));
    }

    @Override
    public void tick() {
        age++;
        if (age == 25 && Minecraft.getInstance().player != null) {
            Minecraft.getInstance().player.playSound(SoundEvents.AMETHYST_BLOCK_CHIME, 0.8F, 0.7F);
        }
        if (age >= DURATION_TICKS && Minecraft.getInstance().screen == this) {
            Minecraft.getInstance().setScreen(null);
        }
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        int alpha = fadeAlpha();
        graphics.fill(0, 0, this.width, this.height, (alpha << 24) | 0x00050A14);
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        if (age >= 18) {
            graphics.drawCenteredString(this.font, this.title, centerX, centerY - 42, 0xFFE9D5FF);
        }
        if (age >= 55) {
            graphics.drawCenteredString(this.font, Component.translatable("cutscene.echoesofarcadia.line1"), centerX, centerY - 4, 0xFFE6E6E6);
        }
        if (age >= 94) {
            graphics.drawCenteredString(this.font, Component.translatable("cutscene.echoesofarcadia.line2"), centerX, centerY + 18, 0xFFE6E6E6);
        }
        if (age >= 130) {
            graphics.drawCenteredString(this.font, Component.translatable("cutscene.echoesofarcadia.line3"), centerX, centerY + 52, 0xFFB897D6);
        }
    }

    private int fadeAlpha() {
        if (age < 20) return age * 9;
        if (age > DURATION_TICKS - 25) return Math.max(0, (DURATION_TICKS - age) * 10);
        return 180;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}

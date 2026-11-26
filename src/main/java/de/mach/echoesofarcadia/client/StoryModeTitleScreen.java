package de.mach.echoesofarcadia.client;

import de.mach.echoesofarcadia.EchoesOfArcadia;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.OptionsScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.worldselection.SelectWorldScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/** Public-facing title menu for Minecraft StoryMode+. */
public final class StoryModeTitleScreen extends Screen {
    private static final ResourceLocation BACKGROUND = new ResourceLocation(
            EchoesOfArcadia.MOD_ID, "textures/gui/storymode_title_background.jpg");

    public StoryModeTitleScreen() {
        super(Component.literal("Minecraft StoryMode+"));
    }

    @Override
    protected void init() {
        int buttonWidth = 210;
        int left = (this.width - buttonWidth) / 2;
        int top = this.height / 2 + 20;
        this.addRenderableWidget(Button.builder(Component.translatable("menu.singleplayer"),
                        button -> Minecraft.getInstance().setScreen(new SelectWorldScreen(this)))
                .bounds(left, top, buttonWidth, 20).build());
        this.addRenderableWidget(Button.builder(Component.translatable("menu.multiplayer"),
                        button -> Minecraft.getInstance().setScreen(new JoinMultiplayerScreen(this)))
                .bounds(left, top + 24, buttonWidth, 20).build());
        this.addRenderableWidget(Button.builder(Component.translatable("menu.options"),
                        button -> Minecraft.getInstance().setScreen(new OptionsScreen(this, Minecraft.getInstance().options)))
                .bounds(left, top + 48, 103, 20).build());
        this.addRenderableWidget(Button.builder(Component.translatable("menu.quit"),
                        button -> Minecraft.getInstance().stop())
                .bounds(left + 107, top + 48, 103, 20).build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        // Passing the scaled screen dimensions as the virtual texture dimensions maps the full image to any resolution.
        graphics.blit(BACKGROUND, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        graphics.fillGradient(0, 0, this.width, this.height, 0x50000000, 0xC8000000);

        graphics.pose().pushPose();
        graphics.pose().translate(this.width / 2.0F, 46.0F, 0.0F);
        graphics.pose().scale(2.25F, 2.25F, 1.0F);
        graphics.drawCenteredString(this.font, "MINECRAFT", 0, 0, 0xFFFFFFFF);
        graphics.pose().popPose();

        graphics.pose().pushPose();
        graphics.pose().translate(this.width / 2.0F, 87.0F, 0.0F);
        graphics.pose().scale(1.45F, 1.45F, 1.0F);
        graphics.drawCenteredString(this.font, "STORYMODE+", 0, 0, 0xFFFFD54A);
        graphics.pose().popPose();

        graphics.drawCenteredString(this.font, Component.literal("Made by EinfachMerliin"),
                this.width / 2, 112, 0xFFFFFF55);
        graphics.drawString(this.font, "Minecraft StoryMode+  •  Forge 1.20.1", 6, this.height - 12, 0xFFE0E0E0);
        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}

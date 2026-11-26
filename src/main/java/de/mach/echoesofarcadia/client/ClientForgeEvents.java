package de.mach.echoesofarcadia.client;

import de.mach.echoesofarcadia.EchoesOfArcadia;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** Replaces only the vanilla title screen; all in-game screens remain untouched. */
@Mod.EventBusSubscriber(modid = EchoesOfArcadia.MOD_ID, value = Dist.CLIENT)
public final class ClientForgeEvents {
    private ClientForgeEvents() {}

    @SubscribeEvent
    public static void replaceVanillaTitle(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.screen instanceof TitleScreen) {
            minecraft.setScreen(new StoryModeTitleScreen());
        }
    }
}

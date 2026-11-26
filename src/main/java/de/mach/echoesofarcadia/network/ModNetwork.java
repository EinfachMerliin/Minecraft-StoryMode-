package de.mach.echoesofarcadia.network;

import de.mach.echoesofarcadia.EchoesOfArcadia;
import de.mach.echoesofarcadia.network.packet.PlayCutscenePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public final class ModNetwork {
    private static final String PROTOCOL = "1";
    private static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(EchoesOfArcadia.MOD_ID, "main"),
            () -> PROTOCOL,
            PROTOCOL::equals,
            PROTOCOL::equals
    );
    private static boolean registered;

    private ModNetwork() {}

    public static void register() {
        if (registered) return;
        registered = true;
        CHANNEL.registerMessage(0, PlayCutscenePacket.class,
                PlayCutscenePacket::encode,
                PlayCutscenePacket::decode,
                PlayCutscenePacket::handle);
    }

    public static void playCutscene(ServerPlayer player) {
        CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), new PlayCutscenePacket());
    }
}

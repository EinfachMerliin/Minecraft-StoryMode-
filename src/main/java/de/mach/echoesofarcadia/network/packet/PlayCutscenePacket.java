package de.mach.echoesofarcadia.network.packet;

import de.mach.echoesofarcadia.client.ClientCutscene;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/** Empty marker packet: its payload is deliberately version-independent. */
public final class PlayCutscenePacket {
    public static void encode(PlayCutscenePacket packet, FriendlyByteBuf buffer) {
        // The cinematic is static; no player data crosses the network.
    }

    public static PlayCutscenePacket decode(FriendlyByteBuf buffer) {
        return new PlayCutscenePacket();
    }

    public static void handle(PlayCutscenePacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientCutscene::play));
        context.setPacketHandled(true);
    }
}

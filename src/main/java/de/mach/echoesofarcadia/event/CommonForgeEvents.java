package de.mach.echoesofarcadia.event;

import de.mach.echoesofarcadia.EchoesOfArcadia;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** Preserves the quest state when Minecraft replaces a player entity after death. */
@Mod.EventBusSubscriber(modid = EchoesOfArcadia.MOD_ID)
public final class CommonForgeEvents {
    private static final String QUEST_STAGE = "echoesofarcadia.quest_stage";

    private CommonForgeEvents() {}

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        CompoundTag oldData = event.getOriginal().getPersistentData();
        if (oldData.contains(QUEST_STAGE)) {
            event.getEntity().getPersistentData().putInt(QUEST_STAGE, oldData.getInt(QUEST_STAGE));
        }
    }
}

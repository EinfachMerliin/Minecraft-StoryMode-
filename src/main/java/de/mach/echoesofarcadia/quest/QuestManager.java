package de.mach.echoesofarcadia.quest;

import de.mach.echoesofarcadia.network.ModNetwork;
import de.mach.echoesofarcadia.registry.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;

/** Server-authoritative state machine for the main quest. */
public final class QuestManager {
    private static final String QUEST_STAGE = "echoesofarcadia.quest_stage";
    private static final int NOT_STARTED = 0;
    private static final int FIND_SHARD = 1;
    private static final int FINISHED = 2;

    private QuestManager() {}

    public static void talkToGuide(ServerPlayer player) {
        int stage = player.getPersistentData().getInt(QUEST_STAGE);
        if (stage == NOT_STARTED) {
            setStage(player, FIND_SHARD);
            tell(player, "message.echoesofarcadia.quest_started");
            player.playNotifySound(SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.NEUTRAL, 0.8F, 1.15F);
            return;
        }

        if (stage == FIND_SHARD && removeOneEchoShard(player)) {
            setStage(player, FINISHED);
            player.getInventory().add(new ItemStack(ModItems.ARCHIVE_SEAL.get()));
            player.getInventory().add(new ItemStack(ModItems.SIGNAL_DRUM.get()));
            player.containerMenu.broadcastChanges();
            player.serverLevel().sendParticles(ParticleTypes.END_ROD, player.getX(), player.getY() + 1.0D,
                    player.getZ(), 35, 0.5D, 0.8D, 0.5D, 0.035D);
            player.playNotifySound(SoundEvents.END_PORTAL_SPAWN, SoundSource.NEUTRAL, 0.35F, 1.35F);
            tell(player, "message.echoesofarcadia.quest_finale");
            ModNetwork.playCutscene(player);
            tell(player, "message.echoesofarcadia.quest_complete");
            return;
        }

        tell(player, stage == FIND_SHARD
                ? "message.echoesofarcadia.quest_need_shard"
                : "message.echoesofarcadia.quest_done");
    }

    private static boolean removeOneEchoShard(ServerPlayer player) {
        for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
            ItemStack stack = player.getInventory().getItem(slot);
            if (stack.is(ModItems.ECHO_SHARD.get())) {
                stack.shrink(1);
                player.getInventory().setChanged();
                return true;
            }
        }
        return false;
    }

    private static void setStage(ServerPlayer player, int stage) {
        player.getPersistentData().putInt(QUEST_STAGE, stage);
    }

    private static void tell(ServerPlayer player, String key) {
        player.displayClientMessage(Component.translatable(key), false);
    }
}

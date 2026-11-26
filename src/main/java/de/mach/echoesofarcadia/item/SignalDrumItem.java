package de.mach.echoesofarcadia.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/** A reusable reward item that makes a visible and audible exploration signal. */
public final class SignalDrumItem extends Item {
    public SignalDrumItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide) {
            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.NOTE_BLOCK_BASEDRUM,
                    SoundSource.PLAYERS, 1.2F, 0.85F);
            ((ServerLevel) level).sendParticles(ParticleTypes.NOTE, player.getX(), player.getY() + 1.2D, player.getZ(),
                    18, 0.65D, 0.35D, 0.65D, 1.0D);
            player.getCooldowns().addCooldown(this, 30);
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }
}

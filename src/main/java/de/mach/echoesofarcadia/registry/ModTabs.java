package de.mach.echoesofarcadia.registry;

import de.mach.echoesofarcadia.EchoesOfArcadia;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EchoesOfArcadia.MOD_ID);
    public static final RegistryObject<CreativeModeTab> MAIN = REGISTER.register("main", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.echoesofarcadia"))
            .icon(() -> new ItemStack(ModItems.ARCHIVE_SEAL.get()))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.ARCHIVE_GUIDE_SPAWN_EGG.get());
                output.accept(ModItems.ECHO_SHARD.get());
                output.accept(ModItems.ARCHIVE_SEAL.get());
                output.accept(ModItems.SIGNAL_DRUM.get());
            })
            .build());

    private ModTabs() {}
}

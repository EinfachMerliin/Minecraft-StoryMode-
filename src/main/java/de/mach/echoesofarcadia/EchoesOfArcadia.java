package de.mach.echoesofarcadia;

import de.mach.echoesofarcadia.network.ModNetwork;
import de.mach.echoesofarcadia.registry.ModEntities;
import de.mach.echoesofarcadia.registry.ModItems;
import de.mach.echoesofarcadia.registry.ModTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EchoesOfArcadia.MOD_ID)
public final class EchoesOfArcadia {
    public static final String MOD_ID = "echoesofarcadia";

    public EchoesOfArcadia() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.REGISTER.register(modBus);
        ModEntities.REGISTER.register(modBus);
        ModTabs.REGISTER.register(modBus);
        ModNetwork.register();
    }
}

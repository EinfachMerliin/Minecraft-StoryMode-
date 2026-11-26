package de.mach.echoesofarcadia.event;

import de.mach.echoesofarcadia.EchoesOfArcadia;
import de.mach.echoesofarcadia.entity.ArchiveGuideEntity;
import de.mach.echoesofarcadia.registry.ModEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EchoesOfArcadia.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEvents {
    private ModEvents() {}

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.ARCHIVE_GUIDE.get(), ArchiveGuideEntity.createAttributes().build());
    }
}

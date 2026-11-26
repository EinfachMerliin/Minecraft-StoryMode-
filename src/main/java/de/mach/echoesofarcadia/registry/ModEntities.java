package de.mach.echoesofarcadia.registry;

import de.mach.echoesofarcadia.EchoesOfArcadia;
import de.mach.echoesofarcadia.entity.ArchiveGuideEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EchoesOfArcadia.MOD_ID);
    public static final RegistryObject<EntityType<ArchiveGuideEntity>> ARCHIVE_GUIDE = REGISTER.register("archive_guide",
            () -> EntityType.Builder.of(ArchiveGuideEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.95F).clientTrackingRange(8).build("archive_guide"));
    private ModEntities() {}
}

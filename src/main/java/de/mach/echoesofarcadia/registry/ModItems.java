package de.mach.echoesofarcadia.registry;

import de.mach.echoesofarcadia.EchoesOfArcadia;
import de.mach.echoesofarcadia.item.SignalDrumItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, EchoesOfArcadia.MOD_ID);
    public static final RegistryObject<Item> ECHO_SHARD = REGISTER.register("echo_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ARCHIVE_SEAL = REGISTER.register("archive_seal", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SIGNAL_DRUM = REGISTER.register("signal_drum", () -> new SignalDrumItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ARCHIVE_GUIDE_SPAWN_EGG = REGISTER.register("archive_guide_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.ARCHIVE_GUIDE, 0x251936, 0xB783D4, new Item.Properties()));

    private ModItems() {}
}

package blockyroad.BlockyRoad.proxy;

import blockyroad.BlockyRoad.BlockyRoad;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

public interface IProxy {

/**
 * Fml life cycle event for Pre-Initialization. Historically (before registry events)
 * this was where blocks, items, etc. were registered. There are still things
 * like entities and networking which should still be registered here.
 */
    void preInit(FMLPreInitializationEvent event);

/**
 * Fml life cycle event for Initialization. This phase is good for registering event listeners, for registering things that depend on things in pre-init from other mods (like
 * recipes, advancements and such.)
 */
    void init(FMLInitializationEvent event);

/**
 * Fml life cycle event Post Initialization. This phase is useful For doing inter-mod stuff like checking which mods are loaded or if you want a complete view of things across
 * mods like having a list of all registered items to aid random item generation.
*/
    void postInit(FMLPostInitializationEvent event);

//    FML Life Cycle event. Register server commands here
    void serverStarting(FMLServerStartingEvent event);

    String localize(String unlocalized);

    String localizeAndFormat(String unlocalized, Object... args);

    default void logPhysicalSide() {
        BlockyRoad.info("Physical Side: " + getPhysicalSide());
    }

    Side getPhysicalSide();
}

package blockyroad.BlockyRoad.proxy;

import blockyroad.BlockyRoad.BlockyRoad;
import net.minecraftforge.fml.relauncher.Side;

public interface IProxy {

    void preInit();

    void init();

    void postInit();

    String localize(String unlocalized);

    String localizeAndFormat(String unlocalized, Object... args);

    default void logPhysicalSide() {
        BlockyRoad.info("Physical Side: " + getPhysicalSide());
    }

    Side getPhysicalSide();
}

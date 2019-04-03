package blockyroad.BlockyRoad.proxy;

import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ServerProxy implements IProxy{
	@Override
	public void preInit(FMLPreInitializationEvent event) {
	}

	@Override
	public void init(FMLInitializationEvent event) {

	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}

	@Override
	public void serverStarting(FMLServerStartingEvent event)
	{
		//Register server commands here
	}

	@Override
	public String localizeAndFormat(final String unlocalized, final Object... args) {
		return I18n.translateToLocalFormatted(unlocalized, args);
	}

	@Override
	public String localize(final String unlocalized) {
		return I18n.translateToLocal(unlocalized);
	}

	@Override
	public Side getPhysicalSide() {
		return Side.SERVER;
	}
}

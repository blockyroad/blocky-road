package blockyroad.BlockyRoad.proxy;

import blockyroad.BlockyRoad.BlockyRoad;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.util.MouseHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ClientProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {


	}

	@Override
	public void init(FMLInitializationEvent event) {

		//register key bindings here

	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}

	@Override
	public String localizeAndFormat(final String unlocalized, final Object... args) {
		return I18n.format(unlocalized, args);
	}

	@Override
	public String localize(final String unlocalized) {
		return this.localizeAndFormat(unlocalized, new Object[0]);
	}

	@Override
	public Side getPhysicalSide() {
		return Side.CLIENT;
	}

	@Override
	public void serverStarting(FMLServerStartingEvent event)
	{
		// This will never get called on client side
	}
	
}

package blockyroad.BlockyRoad.proxy;

import blockyroad.BlockyRoad.BlockyRoad;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;

public class ClientProxy implements IProxy {

	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(BlockyRoad.MODID + ":" + id, "inventory"));
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
	
}

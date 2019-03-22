package blockyroad.BlockyRoad.item.tools;

import blockyroad.BlockyRoad.BlockyRoad;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class EnderstoneHoe extends ItemHoe {
	protected String name;

	public EnderstoneHoe(String name, ToolMaterial material) {
		super(material);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}

	public void registerItemModel() {
		BlockyRoad.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public EnderstoneHoe setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}

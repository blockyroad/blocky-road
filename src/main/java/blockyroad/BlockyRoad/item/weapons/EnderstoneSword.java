package blockyroad.BlockyRoad.item.weapons;

import blockyroad.BlockyRoad.BlockyRoad;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class EnderstoneSword extends ItemSword {
	protected String name;

	public EnderstoneSword(String name, ToolMaterial material) {
		super(material);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}

	public void registerItemModel() {
		BlockyRoad.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public EnderstoneSword setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}

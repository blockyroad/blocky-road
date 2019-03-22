package blockyroad.BlockyRoad.item.tools;

import blockyroad.BlockyRoad.BlockyRoad;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class EnderstoneAxe extends ItemAxe {
	protected String name;
	
	public EnderstoneAxe(String name, ToolMaterial material) {
		super(material, 9, material.ordinal());
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public void registerItemModel() {
		BlockyRoad.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public EnderstoneAxe setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}

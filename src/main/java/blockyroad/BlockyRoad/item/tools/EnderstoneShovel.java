package blockyroad.BlockyRoad.item.tools;

import blockyroad.BlockyRoad.BlockyRoad;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class EnderstoneShovel extends ItemSpade {
	protected String name;
	
	public EnderstoneShovel(String name, ToolMaterial material) {
		super(material);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public void registerItemModel() {
		BlockyRoad.proxy.registerItemRenderer(this, 0, name);
	}
	
	@Override
	public EnderstoneShovel setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}

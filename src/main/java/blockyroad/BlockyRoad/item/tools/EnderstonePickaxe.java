package blockyroad.BlockyRoad.item.tools;

import blockyroad.BlockyRoad.BlockyRoad;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class EnderstonePickaxe extends ItemPickaxe {
	
	protected String name;

	public EnderstonePickaxe(String name, ToolMaterial material) {
		super(material);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public void registerItemModel() {
		BlockyRoad.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public EnderstonePickaxe setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
}

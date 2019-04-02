package blockyroad.BlockyRoad.item.tools;

import blockyroad.BlockyRoad.BlockyRoad;

import blockyroad.BlockyRoad.proxy.ClientProxy;
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
		BlockyRoad.RegistrationHandler.registerItemModel(this, 0, name);
	}
	
	@Override
	public EnderstoneShovel setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}

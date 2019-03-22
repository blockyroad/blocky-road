package com.haicha.blockyroad.item;

import com.haicha.blockyroad.BlockyRoad;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

public class ModItemArmor extends net.minecraft.item.ItemArmor {
	
	private String name;

	public ModItemArmor(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, 0, slot);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}
	
	public void registerModel() {
		BlockyRoad.proxy.registerItemRenderer(this, 0, name);
	}
	
}

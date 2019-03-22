package com.haicha.blockyroad;

import com.haicha.blockyroad.enchantments.EnchantmentDeepDigger;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;

public class ModEnchantments {
	
	public static final EnumEnchantmentType PICK = EnumHelper.addEnchantmentType("pickaxe", (item) -> (item instanceof ItemPickaxe));

	
	//------------------enchantments-----------------------
	public static EnchantmentDeepDigger deepDigger = new EnchantmentDeepDigger(PICK);
	
	public static void register(IForgeRegistry<Enchantment> registry) {
		registry.registerAll(
					deepDigger
				);
	}
}

package com.haicha.blockyroad.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class EnchantmentDeepDigger extends Enchantment {
	
	public EnchantmentDeepDigger(EnumEnchantmentType type) {
		super(Rarity.RARE, type, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
		this.setRegistryName("deep_digger");
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}
	
	@Override
	public String getName() {
		return "enchants.deep_digger.name";
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return true;
	}

	@Override
	public boolean isAllowedOnBooks() {
		return true;
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 1 + 10 * (enchantmentLevel - 1);
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + 50;
	}
}

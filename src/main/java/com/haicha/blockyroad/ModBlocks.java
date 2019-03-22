package com.haicha.blockyroad;

import com.haicha.blockyroad.block.EnderStoneOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	
	public static EnderStoneOre enderStoneOre = new EnderStoneOre(Material.ROCK, "enderstone_ore", 60f, 18000000.0f).setCreativeTab(CreativeTabs.MATERIALS);
	
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				enderStoneOre
				);
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				enderStoneOre.createItemBlock()
				);
	}
	
	public static void registerModels() {
		enderStoneOre.registerItemModel(Item.getItemFromBlock(enderStoneOre));
	}
}

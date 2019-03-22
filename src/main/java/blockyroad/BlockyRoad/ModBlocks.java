package blockyroad.BlockyRoad;

import blockyroad.BlockyRoad.block.EnderstoneOre;

import blockyroad.BlockyRoad.block.EnderstoneBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	
	public static EnderstoneOre enderStoneOre = new EnderstoneOre(Material.ROCK, "enderstone_ore", 60f, 18000000.0f).setCreativeTab(CreativeTabs.MATERIALS);
	public static EnderstoneBlock enderStoneBlock = new EnderstoneBlock(Material.ROCK);

	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				enderStoneOre,
				enderStoneBlock
				);
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				enderStoneOre.createItemBlock(),
				enderStoneBlock.createItemBlock()
				);
	}
	
	public static void registerModels() {
		enderStoneOre.registerItemModel(Item.getItemFromBlock(enderStoneOre));
		enderStoneBlock.registerItemModel((Item.getItemFromBlock((enderStoneBlock))));
	}
}

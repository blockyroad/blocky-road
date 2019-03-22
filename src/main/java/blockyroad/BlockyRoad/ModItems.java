package blockyroad.BlockyRoad;

import blockyroad.BlockyRoad.item.ItemBase;
import blockyroad.BlockyRoad.item.ModItemArmor;
import blockyroad.BlockyRoad.item.tools.EnderstoneAxe;
import blockyroad.BlockyRoad.item.tools.EnderstoneHoe;
import blockyroad.BlockyRoad.item.tools.EnderstonePickaxe;
import blockyroad.BlockyRoad.item.tools.EnderstoneShovel;
import blockyroad.BlockyRoad.item.weapons.EnderstoneSword;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	
	//enderstone material
	public static final ToolMaterial ENDERSTONE = EnumHelper.addToolMaterial("ENDERSTONE", 4, 2341, 12.0f, 4.0f, 8);
	public static final ItemArmor.ArmorMaterial ENDERSTONEARMOR = EnumHelper.addArmorMaterial("ENDERSTONE", BlockyRoad.MODID + ":enderstone", 30, new int[]{4, 9, 7, 4}, 9, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
	
	//------------------creating items--------------------
	
	//enderstone
	public static ItemBase enderStone = new ItemBase("enderstone").setCreativeTab(CreativeTabs.MATERIALS);
	
	//enderstone tools
	public static EnderstonePickaxe enderStonePickaxe = new EnderstonePickaxe("enderstone_pickaxe", ENDERSTONE).setCreativeTab(CreativeTabs.TOOLS);
	public static EnderstoneShovel enderStoneShovel = new EnderstoneShovel("enderstone_shovel", ENDERSTONE).setCreativeTab(CreativeTabs.TOOLS);
	public static EnderstoneAxe enderStoneAxe = new EnderstoneAxe("enderstone_axe", ENDERSTONE).setCreativeTab(CreativeTabs.TOOLS);
	public static EnderstoneHoe enderStoneHoe = new EnderstoneHoe("enderstone_hoe", ENDERSTONE).setCreativeTab(CreativeTabs.TOOLS);
	public static EnderstoneSword enderStoneSword = new EnderstoneSword("enderstone_sword", ENDERSTONE).setCreativeTab(CreativeTabs.COMBAT);
	
	//enderstone armor
	public static ModItemArmor enderStoneHelmet = new ModItemArmor(ENDERSTONEARMOR, EntityEquipmentSlot.HEAD, "enderstone_helmet");
	public static ModItemArmor enderStoneChestplate = new ModItemArmor(ENDERSTONEARMOR, EntityEquipmentSlot.CHEST, "enderstone_chestplate");
	public static ModItemArmor enderStoneLeggings = new ModItemArmor(ENDERSTONEARMOR, EntityEquipmentSlot.LEGS, "enderstone_leggings");
	public static ModItemArmor enderStoneBoots = new ModItemArmor(ENDERSTONEARMOR, EntityEquipmentSlot.FEET, "enderstone_boots");

	//------------------registry-------------------
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				//enderstone item and tools
				enderStone,
				enderStonePickaxe,
				enderStoneShovel,
				enderStoneAxe,
				enderStoneHoe,
				enderStoneSword,
				
				//enderstone armor
				enderStoneHelmet,
				enderStoneChestplate,
				enderStoneLeggings,
				enderStoneBoots
				);
	}
	
	public static void registerModels() {
		//enderstone item and tools
		enderStone.registerItemModel();
		enderStonePickaxe.registerItemModel();
		enderStoneShovel.registerItemModel();
		enderStoneAxe.registerItemModel();
		enderStoneHoe.registerItemModel();
		enderStoneSword.registerItemModel();
		
		//enderstone armor
		enderStoneHelmet.registerModel();
		enderStoneChestplate.registerModel();
		enderStoneLeggings.registerModel();
		enderStoneBoots.registerModel();
	}

}

package blockyroad.BlockyRoad.block;

import blockyroad.BlockyRoad.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class EnderstoneOre extends BlockBase {
	
	protected float inputHardness;
	
	public EnderstoneOre(Material material, String name, float hardness, float resistance) {
		super(material, name);
		setHardness(hardness);
		setResistance(resistance);
		this.inputHardness = hardness;
	}
	
	@Override
	public EnderstoneOre setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random r, int fortune) {
		return ModItems.enderStone;
	}
	
	@Override
	public void onBlockClicked(World world, BlockPos pos, EntityPlayer player) {
		if(!isDeepDigger(player)) {
			setHardness(999999f);
			System.out.println("no");
		} else {
			setHardness(inputHardness);
			System.out.println("yes");
		}
	}
	
	public boolean isDeepDigger(EntityPlayer player) {
		NBTTagList itemEnchantments = player.getHeldItem(EnumHand.MAIN_HAND).getEnchantmentTagList();
		if(itemEnchantments != null) {
			for(int i = 0; i < itemEnchantments.tagCount(); i++) {
				System.out.println(itemEnchantments.getCompoundTagAt(i));
				if(itemEnchantments.getCompoundTagAt(i).getShort("id") == 11) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}

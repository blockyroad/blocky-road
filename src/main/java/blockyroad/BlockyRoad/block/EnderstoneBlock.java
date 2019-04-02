package blockyroad.BlockyRoad.block;


import blockyroad.BlockyRoad.BlockyRoad;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class EnderstoneBlock extends Block {

    protected String name = "enderstone_block";
    protected Item item;
    public EnderstoneBlock(Material material) {
        super(material);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public void registerItemModel(Item itemBlock) {
        BlockyRoad.RegistrationHandler.registerItemModel(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}

package blockyroad.BlockyRoad.item.weapons.wands;

import blockyroad.BlockyRoad.BlockyRoad;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class Wand extends Item {

    protected String name;
    protected List<String> tooltip;

    int wandLevel;
    float damage;

    public Wand(String name, int wandLevel, float damage) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        this.wandLevel = wandLevel;
        this.damage = damage;
        setCreativeTab(CreativeTabs.COMBAT);
        setMaxStackSize(1);
    }

    //model registry
    public void registerItemModel() {
        BlockyRoad.proxy.registerItemRenderer(this, 0, name);
    }

    //tells minecraft to add an NBT tag to the wand containing what "spell" the wand is casting
    @Override
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int metadata, boolean bool)
    {
        if (!itemstack.hasTagCompound())
        {
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("Casting", 0);
            itemstack.setTagCompound(nbt);
        }

        switch(itemstack.getTagCompound().getInteger("Casting")) {
            case 0:
                tooltip.set(0, "Casting: Spell 1");
                break;
            case 1:
                tooltip.set(0, "Casting: Spell 2");
                break;
            case 2:
                tooltip.set(0, "Casting: Spell 3");
                break;
            case 3:
                tooltip.set(0, "Casting: Spell 4");
                break;
        }
    }

    //when the item is right clicked, the "spells" for the wand cycle, and cap depending on the level of the wand.
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(EnumHand.MAIN_HAND);

        if(itemstack.getTagCompound().getInteger("Casting") >= (wandLevel - 1)) {
            itemstack.getTagCompound().setInteger("Casting", 0);
        } else {
            itemstack.getTagCompound().setInteger("Casting", itemstack.getTagCompound().getInteger("Casting") + 1);
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }


    //empty for now, will code for shooting projectiles based on what is being casted
    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack itemstack) {

        System.out.println(itemstack.getTagCompound().getInteger("Casting"));

        return false;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        this.tooltip = tooltip;
    }


}


package blockyroad.BlockyRoad.entity.passive;

import blockyroad.BlockyRoad.BlockyRoad;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;

public class EntityGoldenSheepB extends EntityAnimal {

//    Constructors
    public EntityGoldenSheepB(World world) {
        super(world);
    }

    public EntityGoldenSheepB(World world, double x, double y, double z) {
        this(world);
        this.setPosition(x, y, z);
    }

//    Class Methods
@Nullable
protected ResourceLocation getLootTable()
{
        return new ResourceLocation(BlockyRoad.MODID, "entities/golden_sheep/gold");

}

    public EntityGoldenSheepB createChild(EntityAgeable ageable) {
        EntityGoldenSheepB entitygoldensheep = (EntityGoldenSheepB) ageable;
        EntityGoldenSheepB entitygoldensheep1 = new EntityGoldenSheepB(this.world);
//        entitysheep1.setFleeceColor(this.getDyeColorMixFromParents(this, entitysheep));
        return entitygoldensheep1;
    }
}
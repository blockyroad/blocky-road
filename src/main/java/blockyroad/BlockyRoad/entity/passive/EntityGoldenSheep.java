package blockyroad.BlockyRoad.entity.passive;


import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityGoldenSheep extends EntitySheep {

//    Constructors
    public EntityGoldenSheep(World world){
        super(world);
    }

    public EntityGoldenSheep(World world, double x, double y, double z){
        this(world);
        this.setPosition(x,y,z);
    }

//    Override Methods
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        this.setFleeceColor(EnumDyeColor.YELLOW);
        return livingdata;
    }
}

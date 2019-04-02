package blockyroad.BlockyRoad.entity.passive;

import blockyroad.BlockyRoad.BlockyRoad;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

public class EntityGoldenSheep {

//    public static final ResourceLocation SHEARED_LOOT_TABLE = new ResourceLocation(BlockyRoad.MODID, "entities/golden_sheep/sheared");
//    public static final Map<EnumDyeColor, ResourceLocation> COLORED_LOOT_TABLES;
//    public static EnumDyeColor goldEnum;
//
//    static {
//        Map<EnumDyeColor, ResourceLocation> map = new EnumMap<>(EnumDyeColor.class);
//        for (EnumDyeColor color : EnumDyeColor.values()) {
//            new ResourceLocation(BlockyRoad.MODID, "entities/golden_sheep/sheared");
//            map.put(color, new ResourceLocation(BlockyRoad.MODID,"entities/golden_sheep/gold"));
//        }
//        COLORED_LOOT_TABLES = Collections.unmodifiableMap(map);
//    }
//
//    public EntityGoldenSheep(World world) {
//        super(world);
//        setSize(0.9F, 1.3F);
//    }
//
//    public EntityGoldenSheep(World world, double x, double y, double z) {
//        this(world);
//        this.setPosition(x, y, z);
//    }
//
//    @Override
//    public ResourceLocation getLootTable() {
//        return this.getSheared() ? SHEARED_LOOT_TABLE : COLORED_LOOT_TABLES.get(this.getFleeceColor());
//    }
//
////    private static EnumDyeColor getRandomFleeceColor(Random random) {
////        return random.nextBoolean()
////                ? EnumDyeColor.BROWN
////                : EnumDyeColor.byMetadata(random.nextInt(16));
////    }
//
//    /**
//     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
//     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
//     */
//    @Override
//    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
//        livingdata = super.onInitialSpawn(difficulty, livingdata);
//        this.setFleeceColor(EnumDyeColor.GOLD);
//        return livingdata;
//    }
//
//    @Override
//    public EntitySheep createChild(EntityAgeable ageable) {
//        EntityTFBighorn otherParent = (EntityTFBighorn) ageable;
//        EntityTFBighorn babySheep = new EntityTFBighorn(world);
//        babySheep.setFleeceColor(getDyeColorMixFromParents(this, otherParent));
//        return babySheep;
//    }
}
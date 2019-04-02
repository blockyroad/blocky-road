package blockyroad.BlockyRoad.init;

import blockyroad.BlockyRoad.BlockyRoad;
import blockyroad.BlockyRoad.entity.boss.EntityEnchanter;
import blockyroad.BlockyRoad.entity.passive.EntityGoldenSheepA;
import blockyroad.BlockyRoad.entity.passive.EntityGoldenSheepB;
import blockyroad.BlockyRoad.util.handlers.RenderHandler;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Set;

@ObjectHolder(BlockyRoad.MODID)
public class ModEntities {

    public static final EntityEntry GOLDEN_SHEEP = null;

    @Mod.EventBusSubscriber(modid = BlockyRoad.MODID)
    public static class RegistrationHandler{

        static final Set<EntityEntry> ENTITY_SET = ImmutableSet.of(
//                Golden Sheep
                EntityEntryBuilder.create()
                .entity(EntityGoldenSheepA.class)
                .id(new ResourceLocation(BlockyRoad.MODID+"golden_sheep"),0)
                .name("golden_sheep")
                .tracker(80, 3, false)
                .egg(MapColor.BLUE.colorValue, MapColor.YELLOW.colorValue)
                .spawn(EnumCreatureType.CREATURE, 20, 5, 10, BiomeDictionary.getBiomes(BiomeDictionary.Type.PLAINS))
                .build(),
//                Enchanter Boss
                EntityEntryBuilder.create()
                .entity(EntityEnchanter.class)
                .id(new ResourceLocation(BlockyRoad.MODID+"enchanter"),0)
                .name("enchanter")
                .tracker(80, 3, false)
                .egg(MapColor.RED.colorValue, MapColor.YELLOW.colorValue)
                .build()
        );

        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityEntry> evt){

            final IForgeRegistry<EntityEntry> registry = evt.getRegistry();

//            DEBUG
            System.out.println("Registering entities");

            for (final EntityEntry entityEntry : ENTITY_SET){
//                DEBUG
                System.out.println("Registering entity = " + entityEntry.getEntityClass());

                registry.register(entityEntry);
            }
            RenderHandler.registerEntityRenderers();
        }
    }
}

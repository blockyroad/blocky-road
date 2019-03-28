package blockyroad.BlockyRoad.util.handlers;

import blockyroad.BlockyRoad.entity.passive.EntityGoldenSheepA;
import blockyroad.BlockyRoad.render.entity.RenderGoldenSheepA;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

    public static void registerEntityRenderers(){

//        Register each entity here
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldenSheepA.class, new IRenderFactory<EntityGoldenSheepA>(){

        @Override
        public Render<? super EntityGoldenSheepA> createRenderFor(RenderManager manager){
            return new RenderGoldenSheepA(manager);
        }
        });

//        Register more entities below..


    }
}

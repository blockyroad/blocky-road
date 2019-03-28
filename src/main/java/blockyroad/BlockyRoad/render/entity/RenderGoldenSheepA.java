package blockyroad.BlockyRoad.render.entity;

import blockyroad.BlockyRoad.BlockyRoad;
import blockyroad.BlockyRoad.entity.model.ModelGoldenSheep2;
import blockyroad.BlockyRoad.entity.passive.EntityGoldenSheepA;
import blockyroad.BlockyRoad.render.entity.layers.LayerGoldenSheepWool;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.util.ResourceLocation;

public class RenderGoldenSheepA extends RenderLiving<EntityGoldenSheepA> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(BlockyRoad.MODID + ":textures/entity/golden_sheep/golden_sheep.png");

    public RenderGoldenSheepA(RenderManager manager){

        super(manager, new ModelGoldenSheep2(), 0.7F);
        this.addLayer(new LayerGoldenSheepWool(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGoldenSheepA entity){
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityGoldenSheepA entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}

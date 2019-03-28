package blockyroad.BlockyRoad.render.entity.layers;

import blockyroad.BlockyRoad.entity.passive.EntityGoldenSheepA;
import blockyroad.BlockyRoad.render.entity.RenderGoldenSheepA;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;

public class LayerGoldenSheepWool implements LayerRenderer<EntityGoldenSheepA> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/golden_sheep/golden_sheep_fur.png");
    private final RenderGoldenSheepA sheepRenderer;
    private final ModelSheep1 sheepModel = new ModelSheep1();

    public LayerGoldenSheepWool(RenderGoldenSheepA sheepRendererIn)
    {
        this.sheepRenderer = sheepRendererIn;
    }


    @Override
    public void doRenderLayer(EntityGoldenSheepA entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

        if (!entitylivingbaseIn.getSheared() && !entitylivingbaseIn.isInvisible())
        {
            this.sheepRenderer.bindTexture(TEXTURE);}

        this.sheepModel.setModelAttributes(this.sheepRenderer.getMainModel());
        this.sheepModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
        this.sheepModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}

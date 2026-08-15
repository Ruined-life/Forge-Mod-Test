package net.RuinedLife.modtest.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.RuinedLife.modtest.entity.client.ModModelLayers;
import net.RuinedLife.modtest.entity.client.models.GokuModel;
import net.RuinedLife.modtest.entity.client.models.RhinoModel;
import net.RuinedLife.modtest.entity.custom.GokuEntity;
import net.RuinedLife.modtest.entity.custom.RhinoEntity;
import net.RuinedLife.modtest.modtest;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GokuRenderer extends MobRenderer<GokuEntity, GokuModel<GokuEntity>> {
    public GokuRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GokuModel<>(pContext.bakeLayer(ModModelLayers.GOKU_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(GokuEntity pEntity) {
        return new ResourceLocation(modtest.MOD_ID, "textures/entity/goku.png");
    }


    @Override
    public void render(GokuEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()){
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}

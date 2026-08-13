package net.RuinedLife.modtest.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.RuinedLife.modtest.entity.client.ModModelLayers;
import net.RuinedLife.modtest.entity.client.models.AquaModel;
import net.RuinedLife.modtest.entity.custom.AquaEntity;
import net.RuinedLife.modtest.modtest;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AquaRenderer extends MobRenderer<AquaEntity, AquaModel<AquaEntity>> {
    public AquaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AquaModel<>(pContext.bakeLayer(ModModelLayers.AQUA_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(AquaEntity pEntity) {
        return new ResourceLocation(modtest.MOD_ID, "textures/entity/aqua.png");
    }

    @Override
    protected void scale(AquaEntity entity, PoseStack poseStack, float partialTick) {
        // Reduces visual model size to 50% on X, Y, and Z axes:
        poseStack.scale(0.5F, 0.5F, 0.5F);

        super.scale(entity, poseStack, partialTick);
    }


    @Override
    public void render(AquaEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()){
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}

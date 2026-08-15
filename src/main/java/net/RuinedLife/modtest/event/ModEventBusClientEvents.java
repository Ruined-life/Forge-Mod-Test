package net.RuinedLife.modtest.event;


import net.RuinedLife.modtest.entity.client.ModelLayers;
import net.RuinedLife.modtest.entity.client.models.AquaModel;
import net.RuinedLife.modtest.entity.client.models.GokuModel;
import net.RuinedLife.modtest.entity.client.models.RhinoModel;
import net.RuinedLife.modtest.modtest;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = modtest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModelLayers.RHINO_LAYER, RhinoModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayers.AQUA_LAYER, AquaModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayers.GOKU_LAYER, GokuModel::createBodyLayer);
    }

}

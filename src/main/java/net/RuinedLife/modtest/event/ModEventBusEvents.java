package net.RuinedLife.modtest.event;


import net.RuinedLife.modtest.entity.custom.AquaEntity;
import net.RuinedLife.modtest.entity.custom.GokuEntity;
import net.RuinedLife.modtest.registries.ModEntities;
import net.RuinedLife.modtest.entity.custom.RhinoEntity;
import net.RuinedLife.modtest.modtest;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = modtest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.RHINO.get(), RhinoEntity.createAttributes().build());
        event.put(ModEntities.AQUA.get(), AquaEntity.createAttributes().build());
        event.put(ModEntities.GOKU.get(), GokuEntity.createAttributes().build());
    }

}

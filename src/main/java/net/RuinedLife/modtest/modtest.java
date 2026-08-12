package net.RuinedLife.modtest;

import com.mojang.logging.LogUtils;
import net.RuinedLife.modtest.registries.ModEntities;
import net.RuinedLife.modtest.entity.client.RhinoRenderer;
import net.RuinedLife.modtest.registries.ModCreativeModTabs;
import net.RuinedLife.modtest.registries.ModItems;
import net.RuinedLife.modtest.registries.ModBlocks;
import net.RuinedLife.modtest.registries.ModLootModifiers;
import net.RuinedLife.modtest.registries.ModSounds;
import net.RuinedLife.modtest.registries.ModVillagers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(net.RuinedLife.modtest.modtest.MOD_ID)
public class modtest {
    public static final String MOD_ID = "modtest";
    public static final Logger LOGGER = LogUtils.getLogger();

    public modtest(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModLootModifiers.register((modEventBus));
        ModVillagers.register(modEventBus);

        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.AQUA.getId(), ModBlocks.POTTED_AQUA);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PURPLE.getId(), ModBlocks.POTTED_PURPLE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GREEN.getId(), ModBlocks.POTTED_GREEN);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GOLD.getId(), ModBlocks.POTTED_GOLD);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.YELLOW.getId(), ModBlocks.POTTED_YELLOW);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.ORANGE.getId(), ModBlocks.POTTED_ORANGE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BLUE.getId(), ModBlocks.POTTED_BLUE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PINK.getId(), ModBlocks.POTTED_PINK);
        });

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.crystal_a);
            event.accept(ModItems.crystal_b);
            event.accept(ModItems.crystal_c);
            event.accept(ModItems.crystal_d);
            event.accept(ModItems.crystal_e);
            event.accept(ModItems.pure_crystal);

            event.accept(ModItems.kiwi_fruit);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntities.RHINO.get(), RhinoRenderer::new);

        }
    }
}
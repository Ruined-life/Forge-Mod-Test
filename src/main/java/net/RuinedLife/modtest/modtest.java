package net.RuinedLife.modtest;

import com.mojang.logging.LogUtils;
import net.RuinedLife.modtest.block.entity.BlockEntities;
import net.RuinedLife.modtest.entity.client.renderers.AquaRenderer;
import net.RuinedLife.modtest.entity.client.renderers.GokuRenderer;
import net.RuinedLife.modtest.registries.EntityRegistry;
import net.RuinedLife.modtest.entity.client.renderers.RhinoRenderer;
import net.RuinedLife.modtest.registries.CreativeModeTabsRegistry;
import net.RuinedLife.modtest.registries.ItemsRegistry;
import net.RuinedLife.modtest.registries.BlockRegistry;
import net.RuinedLife.modtest.registries.LootModifiersRegistry;
import net.RuinedLife.modtest.registries.SoundsRegistry;
import net.RuinedLife.modtest.registries.VillagersRegistry;
import net.RuinedLife.modtest.screen.GemPolishingStationScreen;
import net.RuinedLife.modtest.screen.ModMenuTypes;
import net.RuinedLife.modtest.worldgen.biome.TerraBlender;
import net.RuinedLife.modtest.worldgen.biome.surface.ModSurfaceRules;
import net.RuinedLife.modtest.worldgen.tree.FoliagePlacers;
import net.RuinedLife.modtest.worldgen.tree.TrunkPlacerTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
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
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(net.RuinedLife.modtest.modtest.MOD_ID)
public class modtest {
    public static final String MOD_ID = "modtest";
    public static final Logger LOGGER = LogUtils.getLogger();

    public modtest(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        CreativeModeTabsRegistry.register(modEventBus);
        ItemsRegistry.register(modEventBus);
        BlockRegistry.register(modEventBus);
        LootModifiersRegistry.register((modEventBus));
        VillagersRegistry.register(modEventBus);
        SoundsRegistry.register(modEventBus);
        EntityRegistry.register(modEventBus);
        BlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        TrunkPlacerTypes.register(modEventBus);
        FoliagePlacers.register(modEventBus);
        TerraBlender.registerBiomes();

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.AQUA.getId(), BlockRegistry.POTTED_AQUA);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.PURPLE.getId(), BlockRegistry.POTTED_PURPLE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.GREEN.getId(), BlockRegistry.POTTED_GREEN);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.GOLD.getId(), BlockRegistry.POTTED_GOLD);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.YELLOW.getId(), BlockRegistry.POTTED_YELLOW);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.ORANGE.getId(), BlockRegistry.POTTED_ORANGE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.BLUE.getId(), BlockRegistry.POTTED_BLUE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.PINK.getId(), BlockRegistry.POTTED_PINK);

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());
        });

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ItemsRegistry.crystal_a);
            event.accept(ItemsRegistry.crystal_b);
            event.accept(ItemsRegistry.crystal_c);
            event.accept(ItemsRegistry.crystal_d);
            event.accept(ItemsRegistry.crystal_e);
            event.accept(ItemsRegistry.pure_crystal);

            event.accept(ItemsRegistry.kiwi_fruit);
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

            EntityRenderers.register(EntityRegistry.RHINO.get(), RhinoRenderer::new);
            EntityRenderers.register(EntityRegistry.AQUA.get(), AquaRenderer::new);
            EntityRenderers.register(EntityRegistry.GOKU.get(), GokuRenderer::new);

            EntityRenderers.register(EntityRegistry.DICE_PROJECTILE.get(), ThrownItemRenderer::new);

            MenuScreens.register(ModMenuTypes.GEM_POLISHING_MENU.get(), GemPolishingStationScreen::new);


        }
    }
}
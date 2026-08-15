package net.RuinedLife.modtest.registries;

import net.RuinedLife.modtest.modtest;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, modtest.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.crystal_a.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //INGREDIENT ITEMS
                        pOutput.accept(ModItems.crystal_a.get());
                        pOutput.accept(ModItems.crystal_b.get());
                        pOutput.accept(ModItems.crystal_c.get());
                        pOutput.accept(ModItems.crystal_d.get());
                        pOutput.accept(ModItems.crystal_e.get());
                        pOutput.accept(ModItems.pure_crystal.get());


                        //TOOLS
                        pOutput.accept(ModItems.AOE_PICKAXE.get());
                        pOutput.accept(ModItems.CHEST_SCANNER.get());

                        pOutput.accept(ModItems.PINK_SWORD.get());
                        pOutput.accept(ModItems.PINK_PICKAXE.get());
                        pOutput.accept(ModItems.PINK_AXE.get());
                        pOutput.accept(ModItems.PINK_SHOVEL.get());
                        pOutput.accept(ModItems.PINK_HOE.get());


                        //ARMOR
                        pOutput.accept(ModItems.PINK_HELMET.get());
                        pOutput.accept(ModItems.PINK_CHESTPLATE.get());
                        pOutput.accept(ModItems.PINK_LEGGINGS.get());
                        pOutput.accept(ModItems.PINK_BOOTS.get());

                        //CROPS
                        pOutput.accept(ModItems.kiwi_seeds.get());

                        //FLOWERS
                        pOutput.accept(ModBlocks.AQUA.get());
                        pOutput.accept(ModBlocks.PURPLE.get());
                        pOutput.accept(ModBlocks.GREEN.get());
                        pOutput.accept(ModBlocks.GOLD.get());
                        pOutput.accept(ModBlocks.YELLOW.get());
                        pOutput.accept(ModBlocks.ORANGE.get());
                        pOutput.accept(ModBlocks.BLUE.get());
                        pOutput.accept(ModBlocks.PINK.get());

                        //FOOD ITEMS
                        pOutput.accept(ModItems.kiwi_fruit.get());

                        pOutput.accept(ModItems.PIE_NORMAL.get());
                        pOutput.accept(ModItems.PIE_GOLD.get());
                        pOutput.accept(ModItems.PIE_AQUA.get());
                        pOutput.accept(ModItems.PIE_PURPLE.get());
                        pOutput.accept(ModItems.PIE_GREEN.get());
                        pOutput.accept(ModItems.PIE_YELLOW.get());
                        pOutput.accept(ModItems.PIE_ORANGE.get());
                        pOutput.accept(ModItems.PIE_BLUE.get());
                        pOutput.accept(ModItems.PIE_PINK.get());

                        //FLOWER ITEMS
                        pOutput.accept(ModItems.TOY_KNIFE.get());
                        pOutput.accept(ModItems.RIBBON.get());

                        pOutput.accept(ModItems.BURNT_PAN.get());
                        pOutput.accept(ModItems.APRON.get());

                        pOutput.accept(ModItems.TORN_NOTEBOOK.get());
                        pOutput.accept(ModItems.CLOUDY_GLASSES.get());

                        pOutput.accept(ModItems.TOY_GUN.get());
                        pOutput.accept(ModItems.COWBOY_HAT.get());

                        pOutput.accept(ModItems.BALLET_SHOES.get());
                        pOutput.accept(ModItems.TUTU.get());

                        pOutput.accept(ModItems.TOUGH_GLOVE.get());
                        pOutput.accept(ModItems.BANDANA.get());


                        //BLOCKS
                        pOutput.accept(ModBlocks.NEW_ZEALAND_BLOCK.get());
                        pOutput.accept(ModBlocks.PINK_BLOCK.get());
                        pOutput.accept(ModBlocks.NAZI_BLOCK.get());
                        pOutput.accept(ModBlocks.DARKNESS_BLOCK.get());
                        pOutput.accept(ModBlocks.DUST_BLOCK.get());

                        pOutput.accept(ModBlocks.DARKNESS_STAIRS.get());
                        pOutput.accept(ModBlocks.DARKNESS_SLAB.get());
                        pOutput.accept(ModBlocks.DARKNESS_BUTTON.get());
                        pOutput.accept(ModBlocks.DARKNESS_PRESSURE_PLATE.get());

                        pOutput.accept(ModBlocks.DARKNESS_FENCE.get());
                        pOutput.accept(ModBlocks.DARKNESS_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.DARKNESS_WALL.get());

                        pOutput.accept(ModBlocks.DARKNESS_DOOR.get());
                        pOutput.accept(ModBlocks.DARKNESS_TRAP_DOOR.get());
                        pOutput.accept(ModBlocks.GEM_POLISHING_STATION.get());

                        //WOOD
                        pOutput.accept(ModBlocks.SCARLET_LOG.get());
                        //pOutput.accept(ModBlocks.SCARLET_WOOD.get());
                        //pOutput.accept(ModBlocks.STRIPPED_SCARLET_LOG.get());
                        //pOutput.accept(ModBlocks.STRIPPED_SCARLET_WOOD.get());


                        pOutput.accept(ModBlocks.SCARLET_PLANKS.get());
                        pOutput.accept(ModBlocks.SCARLET_LEAVES.get());

                        //BEDS
                        pOutput.accept(Items.PINK_BED);
                        pOutput.accept(Items.PURPLE_BED);

                        //CUSTOM ITEMS
                        pOutput.accept(ModItems.FRIEND.get());
                        pOutput.accept(ModItems.FEATHER.get());
                        pOutput.accept(ModItems.TELEPORTWAND.get());


                        //FUEL ITEMS
                        pOutput.accept(ModItems.SUN.get());


                        //MUSIC ITEMS
                        pOutput.accept(ModItems.TEMPORARY_MUSIC_DISC.get());
                        pOutput.accept(ModItems.BLACK_KNIFE_MUSIC_DISC.get());
                        pOutput.accept(ModItems.ERIKA_MUSIC_DISC.get());


                        //SPAWN EGGS
                        pOutput.accept(ModItems.RHINO_SPAWN_EGG.get());
                        pOutput.accept(ModItems.AQUA_SPAWN_EGG.get());
                        pOutput.accept(ModItems.GOKU_SPAWN_EGG.get());

                    })
                    .build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}

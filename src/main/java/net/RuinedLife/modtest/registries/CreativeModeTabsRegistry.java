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

public class CreativeModeTabsRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, modtest.MOD_ID);
    /*---------------------------------------------------------------------------------------------------------------------------*/
    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemsRegistry.crystal_a.get())).title(Component.translatable("creativetab.tutorial_tab")).displayItems((pParameters, pOutput) -> {
                        //INGREDIENT ITEMS
                        pOutput.accept(ItemsRegistry.crystal_a.get());
                        pOutput.accept(ItemsRegistry.crystal_b.get());
                        pOutput.accept(ItemsRegistry.crystal_c.get());
                        pOutput.accept(ItemsRegistry.crystal_d.get());
                        pOutput.accept(ItemsRegistry.crystal_e.get());
                        pOutput.accept(ItemsRegistry.pure_crystal.get());


                        pOutput.accept(ItemsRegistry.DICE_ITEM.get());

                        //TOOLS
                        pOutput.accept(ItemsRegistry.AOE_PICKAXE.get());
                        pOutput.accept(ItemsRegistry.CHEST_SCANNER.get());

                        pOutput.accept(ItemsRegistry.PINK_SWORD.get());
                        pOutput.accept(ItemsRegistry.PINK_PICKAXE.get());
                        pOutput.accept(ItemsRegistry.PINK_AXE.get());
                        pOutput.accept(ItemsRegistry.PINK_SHOVEL.get());
                        pOutput.accept(ItemsRegistry.PINK_HOE.get());


                        //ARMOR
                        pOutput.accept(ItemsRegistry.PINK_HELMET.get());
                        pOutput.accept(ItemsRegistry.PINK_CHESTPLATE.get());
                        pOutput.accept(ItemsRegistry.PINK_LEGGINGS.get());
                        pOutput.accept(ItemsRegistry.PINK_BOOTS.get());

                        //CROPS
                        pOutput.accept(ItemsRegistry.kiwi_seeds.get());

                        //FLOWERS
                        pOutput.accept(BlockRegistry.AQUA.get());
                        pOutput.accept(BlockRegistry.PURPLE.get());
                        pOutput.accept(BlockRegistry.GREEN.get());
                        pOutput.accept(BlockRegistry.GOLD.get());
                        pOutput.accept(BlockRegistry.YELLOW.get());
                        pOutput.accept(BlockRegistry.ORANGE.get());
                        pOutput.accept(BlockRegistry.BLUE.get());
                        pOutput.accept(BlockRegistry.PINK.get());

                        //FOOD ITEMS
                        pOutput.accept(ItemsRegistry.kiwi_fruit.get());

                        pOutput.accept(ItemsRegistry.PIE_NORMAL.get());
                        pOutput.accept(ItemsRegistry.PIE_GOLD.get());
                        pOutput.accept(ItemsRegistry.PIE_AQUA.get());
                        pOutput.accept(ItemsRegistry.PIE_PURPLE.get());
                        pOutput.accept(ItemsRegistry.PIE_GREEN.get());
                        pOutput.accept(ItemsRegistry.PIE_YELLOW.get());
                        pOutput.accept(ItemsRegistry.PIE_ORANGE.get());
                        pOutput.accept(ItemsRegistry.PIE_BLUE.get());
                        pOutput.accept(ItemsRegistry.PIE_PINK.get());

                        //FLOWER ITEMS
                        pOutput.accept(ItemsRegistry.TOY_KNIFE.get());
                        pOutput.accept(ItemsRegistry.RIBBON.get());

                        pOutput.accept(ItemsRegistry.BURNT_PAN.get());
                        pOutput.accept(ItemsRegistry.APRON.get());

                        pOutput.accept(ItemsRegistry.TORN_NOTEBOOK.get());
                        pOutput.accept(ItemsRegistry.CLOUDY_GLASSES.get());

                        pOutput.accept(ItemsRegistry.TOY_GUN.get());
                        pOutput.accept(ItemsRegistry.COWBOY_HAT.get());

                        pOutput.accept(ItemsRegistry.BALLET_SHOES.get());
                        pOutput.accept(ItemsRegistry.TUTU.get());

                        pOutput.accept(ItemsRegistry.TOUGH_GLOVE.get());
                        pOutput.accept(ItemsRegistry.BANDANA.get());


                        //BLOCKS
                        pOutput.accept(BlockRegistry.NEW_ZEALAND_BLOCK.get());
                        pOutput.accept(BlockRegistry.PINK_BLOCK.get());
                        pOutput.accept(BlockRegistry.DARKNESS_BLOCK.get());
                        pOutput.accept(BlockRegistry.DUST_BLOCK.get());

                        pOutput.accept(BlockRegistry.DARKNESS_STAIRS.get());
                        pOutput.accept(BlockRegistry.DARKNESS_SLAB.get());
                        pOutput.accept(BlockRegistry.DARKNESS_BUTTON.get());
                        pOutput.accept(BlockRegistry.DARKNESS_PRESSURE_PLATE.get());

                        pOutput.accept(BlockRegistry.DARKNESS_FENCE.get());
                        pOutput.accept(BlockRegistry.DARKNESS_FENCE_GATE.get());
                        pOutput.accept(BlockRegistry.DARKNESS_WALL.get());

                        pOutput.accept(BlockRegistry.DARKNESS_DOOR.get());
                        pOutput.accept(BlockRegistry.DARKNESS_TRAP_DOOR.get());
                        pOutput.accept(BlockRegistry.GEM_POLISHING_STATION.get());

                        //WOOD
                        pOutput.accept(BlockRegistry.SCARLET_LOG.get());
                        //pOutput.accept(ModBlocks.SCARLET_WOOD.get());
                        //pOutput.accept(ModBlocks.STRIPPED_SCARLET_LOG.get());
                        //pOutput.accept(ModBlocks.STRIPPED_SCARLET_WOOD.get());
                        pOutput.accept(BlockRegistry.SCARLET_PLANKS.get());
                        pOutput.accept(BlockRegistry.SCARLET_LEAVES.get());
                        pOutput.accept(BlockRegistry.SCARLET_SAPLING.get());

                        //BEDS
                        pOutput.accept(Items.PINK_BED);
                        pOutput.accept(Items.PURPLE_BED);

                        //CUSTOM ITEMS
                        pOutput.accept(ItemsRegistry.FRIEND.get());
                        pOutput.accept(ItemsRegistry.FEATHER.get());
                        pOutput.accept(ItemsRegistry.TELEPORTWAND.get());


                        //FUEL ITEMS
                        pOutput.accept(ItemsRegistry.SUN.get());


                        //MUSIC ITEMS
                        pOutput.accept(ItemsRegistry.TEMPORARY_MUSIC_DISC.get());
                        pOutput.accept(ItemsRegistry.BLACK_KNIFE_MUSIC_DISC.get());


                        //SPAWN EGGS
                        pOutput.accept(ItemsRegistry.RHINO_SPAWN_EGG.get());
                        pOutput.accept(ItemsRegistry.AQUA_SPAWN_EGG.get());
                        pOutput.accept(ItemsRegistry.GOKU_SPAWN_EGG.get());

                        //DIMENSION BLOCKS
                        pOutput.accept(BlockRegistry.PORTAL.get());

                    })
                    .build());



    /*---------------------------------------------------------------------------------------------------------------------------*/
    /*METHODS*/
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}

package net.RuinedLife.modtest.item;

import net.RuinedLife.modtest.block.ModBlocks;
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

                        //FOOD ITEMS
                        pOutput.accept(ModItems.kiwi_fruit.get());


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

                    })
                    .build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}

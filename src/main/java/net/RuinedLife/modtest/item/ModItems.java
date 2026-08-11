package net.RuinedLife.modtest.item;

import net.RuinedLife.modtest.block.ModBlocks;
import net.RuinedLife.modtest.entity.ModEntities;
import net.RuinedLife.modtest.item.custom.*;
import net.RuinedLife.modtest.modtest;
import net.RuinedLife.modtest.sound.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, modtest.MOD_ID);

    //MUSIC DISCS
    public static final RegistryObject<Item> TEMPORARY_MUSIC_DISC = ITEMS.register("temporary",
            () -> new RecordItem(6, ModSounds.TEMPORARY, new Item.Properties().stacksTo(1), 3340));
    public static final RegistryObject<Item> BLACK_KNIFE_MUSIC_DISC = ITEMS.register("black_knife",
            () -> new RecordItem(6, ModSounds.BLACK_KNIFE, new Item.Properties().stacksTo(1), 2420));
    public static final RegistryObject<Item> ERIKA_MUSIC_DISC = ITEMS.register("erika",
            () -> new RecordItem(6, ModSounds.ERIKA, new Item.Properties().stacksTo(1), 3560));


    //EXPERIMENTAL ITEMS
    public static final RegistryObject<Item> AOE_PICKAXE = ITEMS.register("aoe_pickaxe",
            () -> new AOEPickaxeItem(Tiers.WOOD, 2, 1, new Item.Properties()));
    public static final RegistryObject<Item> CHEST_SCANNER = ITEMS.register("chest_scanner",
            () -> new ChestScanner(new Item.Properties()));


    //REGULAR ITEMS
    public static final RegistryObject<Item> crystal_a = ITEMS.register("crystal_a",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> crystal_b = ITEMS.register("crystal_b",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> crystal_c = ITEMS.register("crystal_c",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> crystal_d = ITEMS.register("crystal_d",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> crystal_e = ITEMS.register("crystal_e",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> pure_crystal = ITEMS.register("pure_crystal",
            () -> new Item(new Item.Properties()));

    //FLOWER ITEMS
    public static final RegistryObject<Item> TOY_KNIFE = ITEMS.register("toy_knife",
            () -> new TooltipItem(new Item.Properties(), "tooltip.modtest.toy_knife", ChatFormatting.AQUA));
    public static final RegistryObject<Item> RIBBON = ITEMS.register("ribbon",
            () -> new TooltipItem(new Item.Properties(), "tooltip.modtest.ribbon", ChatFormatting.RED));

    public static final RegistryObject<Item> TORN_NOTEBOOK = ITEMS.register("torn_notebook",
            () -> new TooltipItem(new Item.Properties(), "tooltip.modtest.torn_notebook", ChatFormatting.LIGHT_PURPLE));
    public static final RegistryObject<Item> CLOUDY_GLASSES = ITEMS.register("cloudy_glasses",
            () -> new TooltipItem(new Item.Properties(), "tooltip.modtest.cloudy_glasses", ChatFormatting.WHITE));

    public static final RegistryObject<Item> BURNT_PAN = ITEMS.register("burnt_pan",
            () -> new TooltipItem(new Item.Properties(), "tooltip.modtest.burnt_pan", ChatFormatting.GRAY));
    public static final RegistryObject<Item> APRON = ITEMS.register("apron",
            () -> new TooltipItem(new Item.Properties(), "tooltip.modtest.apron", ChatFormatting.GREEN));

    public static final RegistryObject<Item> BALLET_SHOES = ITEMS.register("ballet_shoes",
            () -> new TooltipItem(new Item.Properties(), "tooltip.modtest.ballet_shoes", ChatFormatting.DARK_BLUE));
    public static final RegistryObject<Item> TUTU = ITEMS.register("tutu",
            () -> new TooltipItem(new Item.Properties(), "tooltip.modtest.tutu", ChatFormatting.WHITE));

    public static final RegistryObject<Item> TOY_GUN = ITEMS.register("toy_gun",
            () -> new TooltipItem(new Item.Properties(), "tooltip.modtest.toy_gun", ChatFormatting.YELLOW));
    public static final RegistryObject<Item> COWBOY_HAT = ITEMS.register("cowboy_hat",
            () -> new TooltipItem(new Item.Properties(), "tooltip.modtest.cowboy_hat", ChatFormatting.GRAY));

    public static final RegistryObject<Item> TOUGH_GLOVE = ITEMS.register("tough_glove",
            () -> new TooltipItem(new Item.Properties(), "tooltip.modtest.tough_glove", ChatFormatting.GRAY));
    public static final RegistryObject<Item> BANDANA = ITEMS.register("bandana",
            () -> new TooltipItem(new Item.Properties(), "tooltip.modtest.bandana", ChatFormatting.DARK_GRAY));




    //public static final RegistryObject<Item> DARKNESS_DOOR = ITEMS.register("darkness_door",
            //() -> new Item(new Item.Properties()));


    //CROPS
    public static final RegistryObject<Item> kiwi_seeds = ITEMS.register("kiwi_seeds",
            () -> new ItemNameBlockItem(ModBlocks.KIWI_CROP.get(), new Item.Properties()));



    //FOODS
    public static final RegistryObject<Item> kiwi_fruit = ITEMS.register("kiwi_fruit",
            () -> new Item(new Item.Properties().food(ModFoods.KIWI)));

    //PIES
    public static final RegistryObject<Item> PIE_NORMAL = ITEMS.register("pie_normal",
            () -> new Item(new Item.Properties().food(ModFoods.PIE_NORMAL)));
    public static final RegistryObject<Item> PIE_AQUA = ITEMS.register("pie_aqua",
            () -> new Item(new Item.Properties().food(ModFoods.PIE_AQUA)));
    public static final RegistryObject<Item> PIE_PURPLE = ITEMS.register("pie_purple",
            () -> new Item(new Item.Properties().food(ModFoods.PIE_PURPLE)));
    public static final RegistryObject<Item> PIE_GREEN = ITEMS.register("pie_green",
            () -> new Item(new Item.Properties().food(ModFoods.PIE_GREEN)));
    public static final RegistryObject<Item> PIE_GOLD = ITEMS.register("pie_gold",
            () -> new Item(new Item.Properties().food(ModFoods.PIE_GOLD)));
    public static final RegistryObject<Item> PIE_YELLOW = ITEMS.register("pie_yellow",
            () -> new Item(new Item.Properties().food(ModFoods.PIE_YELLOW)));
    public static final RegistryObject<Item> PIE_BLUE = ITEMS.register("pie_blue",
            () -> new Item(new Item.Properties().food(ModFoods.PIE_BLUE)));
    public static final RegistryObject<Item> PIE_ORANGE = ITEMS.register("pie_orange",
            () -> new Item(new Item.Properties().food(ModFoods.PIE_ORANGE)));
    public static final RegistryObject<Item> PIE_PINK = ITEMS.register("pie_pink",
            () -> new Item(new Item.Properties().food(ModFoods.PIE_PINK)));

    //ADVANCED ITEMS
    public static final RegistryObject<Item> FRIEND = ITEMS.register("friend_item",
            () -> new FRIENDITEM(new Item.Properties()));
    public static final RegistryObject<Item> FEATHER = ITEMS.register("feather_item",
            () -> new FeatherItem(new Item.Properties()));
    public static final RegistryObject<Item> TELEPORTWAND = ITEMS.register("teleport_wand",
            () -> new TeleportWand(new Item.Properties()));


    //TOOLS/WEAPONS
    public static final RegistryObject<Item> PINK_SWORD = ITEMS.register("pink_sword",
            () -> new SwordItem(ModToolTiers.PINK, 5, 2, new Item.Properties()));
    public static final RegistryObject<Item> PINK_PICKAXE = ITEMS.register("pink_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PINK, 2, 1, new Item.Properties()));
    public static final RegistryObject<Item> PINK_AXE = ITEMS.register("pink_axe",
            () -> new AxeItem(ModToolTiers.PINK, 10, 1, new Item.Properties()));
    public static final RegistryObject<Item> PINK_SHOVEL = ITEMS.register("pink_shovel",
            () -> new ShovelItem(ModToolTiers.PINK, 2, 2, new Item.Properties()));
    public static final RegistryObject<Item> PINK_HOE = ITEMS.register("pink_hoe",
            () -> new ShovelItem(ModToolTiers.PINK, 1, 100, new Item.Properties()));



    //ARMOR
    public static final RegistryObject<Item> PINK_HELMET = ITEMS.register("pink_helmet",
            () -> new ArmorItem(ModArmorMaterials.PINK, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> PINK_CHESTPLATE = ITEMS.register("pink_chestplate",
            () -> new ArmorItem(ModArmorMaterials.PINK, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> PINK_LEGGINGS = ITEMS.register("pink_leggings",
            () -> new ArmorItem(ModArmorMaterials.PINK, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> PINK_BOOTS = ITEMS.register("pink_boots",
            () -> new ArmorItem(ModArmorMaterials.PINK, ArmorItem.Type.BOOTS, new Item.Properties()));

    //FUEL ITEMS
    public static final RegistryObject<Item> SUN = ITEMS.register("sun_item",
            () -> new FuelItem(new Item.Properties(), 99999999));


    //SPAWN EGGS
    public static final RegistryObject<Item> RHINO_SPAWN_EGG = ITEMS.register("rhino_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RHINO, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}

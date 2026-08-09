package net.RuinedLife.modtest.item;

import net.RuinedLife.modtest.block.ModBlocks;
import net.RuinedLife.modtest.entity.ModEntities;
import net.RuinedLife.modtest.item.custom.*;
import net.RuinedLife.modtest.modtest;
import net.RuinedLife.modtest.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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


    public static final RegistryObject<Item> AOE_PICKAXE = ITEMS.register("aoe_pickaxe",
            () -> new AOEPickaxeItem(Tiers.WOOD, 2, 1, new Item.Properties()));

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

   //public static final RegistryObject<Item> DARKNESS_DOOR = ITEMS.register("darkness_door",
            //() -> new Item(new Item.Properties()));


    //CROPS
    public static final RegistryObject<Item> kiwi_seeds = ITEMS.register("kiwi_seeds",
            () -> new ItemNameBlockItem(ModBlocks.KIWI_CROP.get(), new Item.Properties()));



    //FOODS
    public static final RegistryObject<Item> kiwi_fruit = ITEMS.register("kiwi_fruit",
            () -> new Item(new Item.Properties().food(ModFoods.KIWI)));

    //ADVANCED ITEMS
    public static final RegistryObject<Item> FRIEND = ITEMS.register("friend_item",
            () -> new FRIENDITEM(new Item.Properties()));
    public static final RegistryObject<Item> FEATHER = ITEMS.register("feather_item",
            () -> new FeatherItem(new Item.Properties()));
    public static final RegistryObject<Item> TELEPORTWAND = ITEMS.register("teleport_wand",
            () -> new TeleportWand(new Item.Properties()));


    //TOOLS
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

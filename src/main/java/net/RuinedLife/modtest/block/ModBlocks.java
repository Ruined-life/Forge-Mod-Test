package net.RuinedLife.modtest.block;

import net.RuinedLife.modtest.block.custom.KiwiFruitCropBlock;
import net.RuinedLife.modtest.item.ModItems;
import net.RuinedLife.modtest.item.custom.DustBlock;
import net.RuinedLife.modtest.modtest;
import net.RuinedLife.modtest.sound.ModSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, modtest.MOD_ID);


    public static final RegistryObject<Block> NEW_ZEALAND_BLOCK = registerBlock("new_zealand_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLUE_WOOL)));

    public static final RegistryObject<Block> NAZI_BLOCK = registerBlock("nazi_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_WOOL)));

    public static final RegistryObject<Block> PINK_BLOCK = registerBlock("pink_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PINK_WOOL).sound(ModSounds.SOUND_BLOCK_SOUNDS)));


    public static final RegistryObject<Block> DUST_BLOCK = registerBlock("dust_block",
            () -> new DustBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));

    public static final RegistryObject<Block> DARKNESS_BLOCK = registerBlock("darkness_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops()));


    //STAIRS, SLABS, TRAPDOORS, FENCES, FENCE GATES
    public static final RegistryObject<Block> DARKNESS_STAIRS = registerBlock("darkness_stairs",
            () -> new StairBlock(() -> ModBlocks.DARKNESS_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARKNESS_SLAB = registerBlock("darkness_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DARKNESS_BUTTON = registerBlock("darkness_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.AMETHYST),
                    BlockSetType.IRON, 20, true));
    public static final RegistryObject<Block> DARKNESS_PRESSURE_PLATE = registerBlock("darkness_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> DARKNESS_FENCE = registerBlock("darkness_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARKNESS_FENCE_GATE = registerBlock("darkness_fence_gate",
            //LAST TWO SOUNDS ARE FOR OPENING AND CLOSING SO KEEP THAT IN MIND FOR FUTURE
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> DARKNESS_WALL = registerBlock("darkness_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DARKNESS_DOOR = BLOCKS.register("darkness_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE).noOcclusion(), BlockSetType.ACACIA));

    // Register its specific Door BlockItem manually:
    public static final RegistryObject<Item> DARKNESS_DOOR_ITEM = ModItems.ITEMS.register("darkness_door",
            () -> new DoubleHighBlockItem(DARKNESS_DOOR.get(), new Item.Properties()));


    //public static final RegistryObject<Block> DARKNESS_DOOR = registerBlock("darkness_door",
            //BLOCK SET TYPE FOR THIS DETERMINES WHETHER IT WILL BE A WOOD OR IRON DOOR
            //() -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE).noOcclusion(), BlockSetType.ACACIA));
    public static final RegistryObject<Block> DARKNESS_TRAP_DOOR = registerBlock("darkness_trap_door",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE).noOcclusion(), BlockSetType.ACACIA));



    //CROPS
    public static final RegistryObject<Block> KIWI_CROP = BLOCKS.register("kiwi_crop",
            () -> new KiwiFruitCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));



    //FLOWERS
    //AQUA
    public static final RegistryObject<Block> AQUA = registerBlock("aqua",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_AQUA = BLOCKS.register("potted_aqua",
                () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.AQUA,
                        BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    //GREEN
    public static final RegistryObject<Block> GREEN = registerBlock("green",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_GREEN = BLOCKS.register("potted_green",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GREEN,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    //PURPLE
    public static final RegistryObject<Block> PURPLE = registerBlock("purple",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_PURPLE = BLOCKS.register("potted_purple",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.PURPLE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    //GOLD
    public static final RegistryObject<Block> GOLD = registerBlock("gold",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_GOLD = BLOCKS.register("potted_gold",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.GOLD,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    //YELLOW
    public static final RegistryObject<Block> YELLOW = registerBlock("yellow",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_YELLOW = BLOCKS.register("potted_yellow",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.YELLOW,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    //ORANGE
    public static final RegistryObject<Block> ORANGE = registerBlock("orange",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_ORANGE = BLOCKS.register("potted_orange",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.ORANGE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    //BLUE
    public static final RegistryObject<Block> BLUE = registerBlock("blue",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_BLUE = BLOCKS.register("potted_blue",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.BLUE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));


    //PINK
    public static final RegistryObject<Block> PINK = registerBlock("pink",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_PINK = BLOCKS.register("potted_pink",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.PINK,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}

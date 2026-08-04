package net.RuinedLife.modtest.block;

import net.RuinedLife.modtest.item.ModItems;
import net.RuinedLife.modtest.block.custom.DustBlock;
import net.RuinedLife.modtest.modtest;
import net.RuinedLife.modtest.sound.ModSounds;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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

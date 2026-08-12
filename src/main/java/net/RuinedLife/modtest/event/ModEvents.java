package net.RuinedLife.modtest.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.RuinedLife.modtest.registries.ModBlocks;
import net.RuinedLife.modtest.registries.ModItems;
import net.RuinedLife.modtest.modtest;
import net.RuinedLife.modtest.registries.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = modtest.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //LEVEL 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    //WHAT YOU GIVE
                    new ItemStack(Items.EMERALD, 2),
                    //WHAT YOU GET
                    new ItemStack(ModBlocks.AQUA.get(), 1), 10, 8, 0.02f));

            //LEVEL 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.PINK_BLOCK.get(), 64), 10, 8, 0.02f));


        }

        if (event.getType() == VillagerProfession.LIBRARIAN) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(Enchantments.MENDING, 1));

            //LEVEL 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    enchantedBook, 2, 8, 0.02f));


        }

        if(event.getType() == ModVillagers.SOUND_MASTER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.PINK_SWORD.get()),
                    2,8, 0.02f));




        }

    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event){

        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModItems.FEATHER.get(), 1), 10, 2, 0.2f));


        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(ModItems.FRIEND.get(), 1), 10, 2, 0.2f));


    }



}

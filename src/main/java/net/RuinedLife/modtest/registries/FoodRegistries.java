package net.RuinedLife.modtest.registries;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodRegistries {
    public static final FoodProperties KIWI = new FoodProperties.Builder().nutrition(2).fast().saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200), 1f).build();

    //PIES
    public static final FoodProperties PIE_NORMAL = new FoodProperties.Builder().nutrition(20).fast().saturationMod(20f).effect(() -> new MobEffectInstance(MobEffects.HEAL, 5), 1f).build();
    public static final FoodProperties PIE_AQUA = new FoodProperties.Builder().nutrition(20).saturationMod(20f).fast().effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 100), 1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1f).effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200, 1), 1f).build();
    public static final FoodProperties PIE_GREEN = new FoodProperties.Builder().nutrition(20).saturationMod(20f).fast().effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 100), 1f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 1), 1f).build();
    public static final FoodProperties PIE_YELLOW = new FoodProperties.Builder().nutrition(20).saturationMod(20f).fast().effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 100), 1f).effect(() -> new MobEffectInstance(MobEffects.LUCK, 1200, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 1), 1f).build();
    public static final FoodProperties PIE_ORANGE = new FoodProperties.Builder().nutrition(20).saturationMod(20f).fast().effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 100), 1f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1), 1f).build();
    public static final FoodProperties PIE_BLUE = new FoodProperties.Builder().nutrition(20).saturationMod(20f).fast().effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 100), 1f).effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1f).build();
    public static final FoodProperties PIE_PURPLE = new FoodProperties.Builder().nutrition(20).saturationMod(20f).fast().effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 100), 1f).effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1f).build();
    public static final FoodProperties PIE_PINK = new FoodProperties.Builder().nutrition(20).saturationMod(20f).fast().effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 1), 1f).effect(() -> new MobEffectInstance(MobEffects.POISON, 1200, 0), 0.1f).effect(() -> new MobEffectInstance(MobEffects.BAD_OMEN, 10000, 0), 1f).build();
    public static final FoodProperties PIE_GOLD = new FoodProperties.Builder().nutrition(40).saturationMod(40f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 1200, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0), 1f)
            .build();


}

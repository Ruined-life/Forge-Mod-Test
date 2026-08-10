package net.RuinedLife.modtest.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties KIWI = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200), 1f).build();

    //PIES
    public static final FoodProperties PIE_NORMAL = new FoodProperties.Builder().nutrition(20).fast()
            .saturationMod(20f).effect(() -> new MobEffectInstance(MobEffects.HEAL, 5), 1f).build();

    public static final FoodProperties PIE_AQUA = new FoodProperties.Builder()
            .nutrition(20)
            .saturationMod(20f)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 100), 1f) // Instant Heal II
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1f) // Luck I for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200, 1), 1f) // Speed II for 1 min
            .build();

    public static final FoodProperties PIE_GREEN = new FoodProperties.Builder()
            .nutrition(20)
            .saturationMod(20f)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 100), 1f) // Instant Heal II
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 2), 1f) // Luck I for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 5), 1f) // Speed II for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1), 1f) // Speed II for 1 min
            .build();

    public static final FoodProperties PIE_YELLOW = new FoodProperties.Builder()
            .nutrition(20)
            .saturationMod(20f)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 100), 1f) // Instant Heal II
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 1200, 0), 1f) // Luck I for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 1), 1f) // Speed II for 1 min
            .build();

    public static final FoodProperties PIE_ORANGE = new FoodProperties.Builder()
            .nutrition(20)
            .saturationMod(20f)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 100), 1f) // Instant Heal II
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), 1f) // Luck I for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1), 1f) // Speed II for 1 min
            .build();

    public static final FoodProperties PIE_BLUE = new FoodProperties.Builder()
            .nutrition(20)
            .saturationMod(20f)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 100), 1f) // Instant Heal II
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200, 0), 1f) // Luck I for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1f) // Speed II for 1 min
            .build();

    public static final FoodProperties PIE_PURPLE = new FoodProperties.Builder()
            .nutrition(20)
            .saturationMod(20f)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 100), 1f) // Instant Heal II
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0), 1f) // Luck I for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1f) // Speed II for 1 min
            .build();

    public static final FoodProperties PIE_PINK = new FoodProperties.Builder()
            .nutrition(20)
            .saturationMod(20f)
            .fast()
            // Format: MobEffectInstance(Effect, Duration in Ticks, Amplifier/Level)
            // 200 ticks = 10 seconds | 1200 ticks = 1 minute | 3600 ticks = 3 minutes
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 1), 1f) // Instant Heal II
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 1200, 0), 0.1f) // Luck I for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.BAD_OMEN, 10000, 0), 1f) // Speed II for 1 min
            .build();

    public static final FoodProperties PIE_GOLD = new FoodProperties.Builder()
            .nutrition(40)
            .saturationMod(40f)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 1), 1f) // Instant Heal II
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 1200, 0), 1f) // Luck I for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1f) // Speed II for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200, 1), 1f) // Jump Boost II for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1f) // Regen II for 20 sec
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 1), 1f) // Absorption II for 2 min
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), 1f) // Strength I for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1f) // Resistance I for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0), 1f) // Invisibility for 1 min
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0), 1f) // Night Vision for 1 min
            .build();


}

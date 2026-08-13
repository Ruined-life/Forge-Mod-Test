package net.RuinedLife.modtest.registries;

import net.RuinedLife.modtest.entity.custom.AquaEntity;
import net.RuinedLife.modtest.entity.custom.GokuEntity;
import net.RuinedLife.modtest.entity.custom.RhinoEntity;
import net.RuinedLife.modtest.modtest;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, modtest.MOD_ID);

    public static final RegistryObject<EntityType<RhinoEntity>> RHINO =
            ENTITY_TYPES.register("rhino", () -> EntityType.Builder.of(RhinoEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("rhino"));

    public static final RegistryObject<EntityType<AquaEntity>> AQUA =
            ENTITY_TYPES.register("aqua", () -> EntityType.Builder.of(AquaEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.5f).build("aqua"));

    public static final RegistryObject<EntityType<GokuEntity>> GOKU =
            ENTITY_TYPES.register("goku", () -> EntityType.Builder.of(GokuEntity::new, MobCategory.CREATURE)
                    .sized(1f, 1f).build("goku"));


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}

package net.RuinedLife.modtest.entity.custom;

import net.RuinedLife.modtest.registries.EntityRegistry;
import net.RuinedLife.modtest.registries.ItemsRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class DiceProjectileEntity extends ThrowableItemProjectile {
    public DiceProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public DiceProjectileEntity(Level pLevel) {
        super(EntityRegistry.DICE_PROJECTILE.get(), pLevel);
    }

    public DiceProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(EntityRegistry.DICE_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemsRegistry.DICE_ITEM.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if(!this.level().isClientSide()){
            Entity entity = pResult.getEntity();
            BlockPos blockpos = entity.blockPosition();
            Entity entity1 = this.getOwner();

            LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(this.level());
            if (lightningbolt != null) {
                lightningbolt.moveTo(Vec3.atBottomCenterOf(blockpos));
                lightningbolt.setCause(entity1 instanceof ServerPlayer ? (ServerPlayer) entity1 : null);
                this.level().addFreshEntity(lightningbolt);
            }
        }

        super.onHitEntity(pResult);
    }
}

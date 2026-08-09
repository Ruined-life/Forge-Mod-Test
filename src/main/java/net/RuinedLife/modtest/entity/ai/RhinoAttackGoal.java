package net.RuinedLife.modtest.entity.ai;

import net.RuinedLife.modtest.entity.custom.RhinoEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class RhinoAttackGoal extends MeleeAttackGoal {
    private final RhinoEntity entity;

    // Total animation length in ticks (80 ticks = 4 seconds)
    private final int animationTicks = 80;

    // TICK WHEN THE HORN IMPACTS (e.g., 20 ticks = 1 second into animation)
    private final int damageImpactTick = 45;

    private int attackTimer = 0;
    private boolean hasDealtDamage = false;

    public RhinoAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        this.entity = (RhinoEntity) pMob;
    }

    @Override
    public void start() {
        super.start();
        this.attackTimer = 0;
        this.hasDealtDamage = false;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {

            // Start the attack cycle if off cooldown
            if (this.attackTimer <= 0) {
                this.attackTimer = animationTicks;
                this.hasDealtDamage = false;

                // Signal client to play animation
                this.entity.setAttacking(true);
                this.mob.swing(InteractionHand.MAIN_HAND);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.attackTimer > 0) {
            this.attackTimer--;

            int currentAnimTick = animationTicks - this.attackTimer;

            // Deal damage at the impact frame
            if (currentAnimTick >= damageImpactTick && !hasDealtDamage) {
                LivingEntity target = this.mob.getTarget();
                if (target != null && isEnemyWithinAttackDistance(target, this.mob.distanceToSqr(target))) {
                    this.mob.doHurtTarget(target);
                }
                hasDealtDamage = true;
            }

            // Animation timer finished -> reset state so it can happen again!
            if (this.attackTimer <= 0) {
                this.entity.setAttacking(false);
            }
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
    }

    @Override
    public void stop() {
        this.entity.setAttacking(false);
        this.attackTimer = 0;
        this.hasDealtDamage = false;
        super.stop();
    }
}
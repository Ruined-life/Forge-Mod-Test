package net.RuinedLife.modtest.entity.custom;

import net.RuinedLife.modtest.entity.ai.RhinoAttackGoal;
import net.RuinedLife.modtest.registries.ModEntities;
import net.RuinedLife.modtest.registries.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class AquaEntity extends Animal {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(AquaEntity.class, EntityDataSerializers.BOOLEAN);

    enum AquaActions {
        TALK,
        PICKUP,
        SPIN

    }
    Random random = new Random();
    Timer timer = new Timer();

    public AquaEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()){

            setupAnimationStates();

        }

    }

    private void setupAnimationStates() {
        // Idle animation handling
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        // Attack animation handling
        if (this.isAttacking()) {
            // Starts the animation IF it's not already playing
            this.attackAnimationState.startIfStopped(this.tickCount);
        } else {
            // Stops and resets the animation state so it can play fresh next time
            this.attackAnimationState.stop();
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING){
            f = Math.min(pPartialTick * 6f, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);

    }

    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

        this.entityData.define(ATTACKING, false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, true));

        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.1D));

        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));

    }

    public static AttributeSupplier.Builder createAttributes(){
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 100D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 1.5D)
                .add(Attributes.ARMOR_TOUGHNESS, 10f)
                .add(Attributes.ATTACK_KNOCKBACK, 30f)
                .add(Attributes.ATTACK_DAMAGE, 40f);
    }

//    @Override
//    public void playerTouch(Player player) {
//        super.playerTouch(player);
//
//        // If nobody is riding this entity yet and the player touches it:
//        if (!this.isVehicle() && !player.isPassenger()) {
//            player.startRiding(this, true);
//        }
//    }

    private static AquaActions DecideChoice(){
        Random rand = new Random();
        int randomEnum = rand.nextInt(AquaActions.values().length);
        System.out.println("AQUA CHOICE: " + randomEnum);
        return AquaActions.values()[randomEnum];
    }

    @Override
    public InteractionResult interactAt(Player pPlayer, Vec3 pVec, InteractionHand pHand) {
        if(level().isClientSide()){
            AquaActions result = DecideChoice();

            switch(result){
                case TALK -> {
                    pPlayer.displayClientMessage(Component.literal("Uuuu Hello hello!").withStyle(ChatFormatting.AQUA), true);
                    break;
                }
                case PICKUP -> {
                    pPlayer.displayClientMessage(Component.literal("Hehehe, let's go for a ride!").withStyle(ChatFormatting.AQUA), true);
                    pPlayer.startRiding(this, true);
                    //pPlayer.stopRiding();
                    break;
                }

                case SPIN -> {
                    //this.getX() = pPlayer.getX();
                }

            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.AQUA_AMBIENT.get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.AXOLOTL_HURT;
    }


    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.AQUA_DEATH.get();
    }
}

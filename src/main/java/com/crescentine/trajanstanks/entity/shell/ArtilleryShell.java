package com.crescentine.trajanstanks.entity.shell;

import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.TankModEntityTypes;
import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.t34.T34Entity;
import com.crescentine.trajanstanks.entity.tanks.tiger.TigerTankEntity;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

public class ArtilleryShell extends ThrowableItemProjectile {
    public ArtilleryShell(EntityType<ArtilleryShell> entityType, Level world) {
        super(entityType, world);
    }
    public ArtilleryShell(double x, double y, double z, Level world) {
        super(TankModEntityTypes.ARTILLERY_SHELL.get(), x, y, z, world);
    }
    public ArtilleryShell(LivingEntity player, Level world) {
        super(TankModEntityTypes.ARTILLERY_SHELL.get(), player, world);
    }
    @Override
    public Packet<?> getAddEntityPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    @Override
    protected Item getDefaultItem() {
        return TankModItems.ARTILLERY_SHELL_ITEM.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float) (TankModConfig.anti_tank_shell_damage.get() * 1.0f));

        if (entity instanceof Panzer2Entity) {
            entity.hurt(DamageSource.thrown(this, this.getOwner()), (float) (TankModConfig.anti_tank_shell_damage_to_tank.get() * 1.0f));
        }
        if (entity instanceof CruiserMk1Entity) {
            entity.hurt(DamageSource.thrown(this, this.getOwner()), (float) (TankModConfig.anti_tank_shell_damage_to_tank.get() * 1.0f));
        }
        if (entity instanceof TigerTankEntity) {
            entity.hurt(DamageSource.thrown(this, this.getOwner()), (float) (TankModConfig.anti_tank_shell_damage_to_tank.get() * 1.0f));
        }
        if (entity instanceof T34Entity) {
            entity.hurt(DamageSource.thrown(this, this.getOwner()), (float) (TankModConfig.anti_tank_shell_damage_to_tank.get() * 1.0f));
        }
    }
    @Override
    protected float getGravity() {
        return 0.026f;
    }

    @Override
    protected void onHit(HitResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if (!this.level.isClientSide) { // checks if the world is client
            this.level.broadcastEntityEvent(this, (byte) 3); // particle?
            if (!level.isClientSide) {
                level.explode(this, getX(), getY(), getZ(), TankModConfig.anti_tank_shell_explosion_radius.get(), TankModConfig.at_shell_makes_fire.get(), Explosion.BlockInteraction.DESTROY);
                this.kill();
            }
        }
    }
}
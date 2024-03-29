package com.example.mixin;

import com.example.ExampleMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlazeEntity.class)
public class ExampleMixin extends MobEntity {
	protected ExampleMixin(EntityType<? extends MobEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (ExampleMod.interact(this, player, hand)) {
			return ActionResult.success(this.getEntityWorld().isClient);
		}
		return super.interactMob(player, hand);
	}
}
package com.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors

	public static boolean interact(MobEntity blaze, PlayerEntity player, Hand hand) {
		ItemStack itemStack = player.getStackInHand(hand);
		if (itemStack.isOf(Items.BUCKET) && !blaze.isBaby()) {
			player.playSound(SoundEvents.ENTITY_BLAZE_HURT, 1.0f, 1.0f);
			ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, Items.LAVA_BUCKET.getDefaultStack());
			player.setStackInHand(hand, itemStack2);
			return true;
		}
		return false;
    }


	@Override
	public void onInitialize() {

	}
}
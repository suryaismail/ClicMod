package com.clic.mods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class PlayerExplode {

	static boolean hasExploded = false;

	@SubscribeEvent
	public void blowupplayer(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		ItemStack item = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
		if (!item.isItemEqual(new ItemStack(Items.CHAINMAIL_CHESTPLATE))) {
			hasExploded = false;
			return;
		}

		// We are definately wearing chainmail chestplate here
		if(hasExploded) {
			return;
		}
		player.getEntityWorld().createExplosion(null,
				player.getPosition().getX(),
				player.getPosition().getY(),
				player.getPosition().getZ(), 10, true);
		hasExploded = true;

	}
}



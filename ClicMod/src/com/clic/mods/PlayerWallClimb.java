package com.clic.mods;

import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerWallClimb {

	@SubscribeEvent
	public void climbWall(LivingUpdateEvent event) {
		if (!(event.getEntity() instanceof EntityPlayer)) {
			return;
		}

		if (!event.getEntity().isCollidedHorizontally) {
			return;
		}
		event.getEntity().motionY = 0.5;
	}

}
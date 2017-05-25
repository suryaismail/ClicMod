package com.clic.mods;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DoNotBreakStone {
	@SubscribeEvent
	public void explode(BreakEvent event)
	{
		if (event.getState().getBlock() != Blocks.STONE) {

			return;

		}	

	for (int i = 0 ; i < 5 ; i++) {
		EntityZombie zombie = new EntityZombie(event.getWorld());
		zombie.setLocationAndAngles(event.getPos().getX(),
				event.getPos().getY(),
				event.getPos().getZ(),
				0,
				0);
		if (!event.getWorld().isRemote) {
			event.getWorld().spawnEntityInWorld(zombie);
		}
	}

	}
}

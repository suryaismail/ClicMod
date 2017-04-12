package com.clic.mods;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CowReinforcements {

	@SubscribeEvent
	public void spawnReinforcements(LivingDeathEvent event){
		if (!(event.getEntity() instanceof EntityCow)) {
			return;
		}

		for (int i = 0 ; i < 3 ; i++) {
			EntityZombie zombie = new EntityZombie(event.getEntity().world);
			zombie.setLocationAndAngles(event.getEntity().posX,
					event.getEntity().posY,
					event.getEntity().posZ,
					0,
					0);
			if (!event.getEntity().world.isRemote) {
				event.getEntity().world.spawnEntity(zombie);
			}
		}
		for (int s = 0 ; s < 2 ; s++) {
			EntitySkeleton skeleton = new EntitySkeleton(event.getEntity().world);
			skeleton.setLocationAndAngles(event.getEntity().posX,
					event.getEntity().posY,
					event.getEntity().posZ,
					0,
					0);
			skeleton.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.BOW));
			skeleton.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
			skeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
			skeleton.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
			skeleton.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
			if (!event.getEntity().world.isRemote) {
				event.getEntity().world.spawnEntity(skeleton);
			}
		}
	}
}
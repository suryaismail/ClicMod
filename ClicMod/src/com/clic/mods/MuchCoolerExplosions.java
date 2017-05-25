package com.clic.mods;

import java.util.Random;

import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MuchCoolerExplosions {
	
	float power = 0.0f;
	
	@SubscribeEvent
	
	public void explode(EntityJoinWorldEvent event) {
		
		if(!(event.getEntity() instanceof EntityTNTPrimed)){
             return;
		}
		
		
		net.minecraft.entity.Entity entity = event.getEntity();
		
		event.getEntity().worldObj.createExplosion(entity,
				                entity.posX, entity.posY, entity.posZ,
				                power, true);
		
		
		Random rand = new Random();
		int  n = rand.nextInt(3);
		if (n == 0) {
			spawnZombie(event);
		} else if (n == 1) {
			spawnSkeleton(event);
		} else {
			spawnCreeper(event);
		}
	}
	
	private void spawnZombie(EntityJoinWorldEvent event)
	{
		EntityZombie zombie = new EntityZombie(event.getEntity().worldObj);
		zombie.setLocationAndAngles(event.getEntity().posX,
				event.getEntity().posY,
				event.getEntity().posZ,
				0,
				0);
		zombie.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.IRON_HOE));
		zombie.setHeldItem(EnumHand.OFF_HAND, new ItemStack(Items.SHIELD));
		zombie.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
		zombie.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
		
		if (!event.getEntity().worldObj.isRemote) {
			event.getEntity().worldObj.spawnEntityInWorld(zombie);
		}
	}
    
	private void spawnSkeleton(EntityJoinWorldEvent event)
	{
		EntitySkeleton skeleton = new EntitySkeleton(event.getEntity().worldObj);
		skeleton.setLocationAndAngles(event.getEntity().posX,
				event.getEntity().posY,
				event.getEntity().posZ,
				0,
				0);
		skeleton.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.FLINT_AND_STEEL));
		skeleton.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.LEATHER_HELMET));
		skeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
		skeleton.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
		skeleton.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.GOLDEN_BOOTS));
		if (!event.getEntity().worldObj.isRemote) {
			event.getEntity().worldObj.spawnEntityInWorld(skeleton);
		}
	}
	
	private void spawnCreeper(EntityJoinWorldEvent event)
	{
		EntityCreeper creeper = new EntityCreeper(event.getEntity().worldObj);
		creeper.setLocationAndAngles(event.getEntity().posX,
				event.getEntity().posY,
				event.getEntity().posZ,
				0,
				0);
		if (!event.getEntity().worldObj.isRemote) {
			event.getEntity().worldObj.spawnEntityInWorld(creeper);
		}
	}
}
package com.clic.mods;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	public static final String MODID = "clicvengers";
	public static final String VERSION = "1.0";

	public static EnderBlock enderBlock;

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		
		// MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
		MinecraftForge.EVENT_BUS.register(new PlayerWallClimb());
		
		// YunZhe
		MinecraftForge.EVENT_BUS.register(new MuchCoolerExplosions());

		// Xuan
		MinecraftForge.EVENT_BUS.register(new DiamondOreTrap());
		MinecraftForge.EVENT_BUS.register(new PlayerExplode());
        
		// Lewis
		MinecraftForge.EVENT_BUS.register(new ExplodingAnvil());

		// Arian
		MinecraftForge.EVENT_BUS.register(new DankSide());

		// Alimi
		MinecraftForge.EVENT_BUS.register(new CowReinforcements());
        
		registerBlocks();
	}
	
	private void registerBlocks() {
		enderBlock = new EnderBlock();
		GameRegistry.register(enderBlock, new ResourceLocation(MODID, "enderblock"));
        GameRegistry.register(new ItemBlock(enderBlock), new ResourceLocation(MODID, "enderblock"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        .register(Item.getItemFromBlock(enderBlock), 0,
        		new ModelResourceLocation(MODID + ":" + enderBlock.getUnlocalizedName().substring(5), "inventory"));
        		// getUnlocalizedName() returns "tile.unlocalizedName".
        		// The .substring(5) method cuts of the first five characters
        		// and leaves us with the unlocalized name we need.
        
	}

	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {
	  event.registerServerCommand(new FlamingPigs());

	}
	
	
}

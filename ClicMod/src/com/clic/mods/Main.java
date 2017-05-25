package com.clic.mods;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	public static final String MODID = "clicvengers";
	public static final String VERSION = "1.0";

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		
		MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
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
        
	}
	
	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {
	  event.registerServerCommand(new FlamingPigs());

	}
}
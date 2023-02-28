package com.queen;

import com.queen.utils.LootTableInjection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class LastSword implements ModInitializer {
	
	public static final String MODID = "tlsywen"; // use modid for namespaces. IDK if this is like Forge where that's required or not
	public static final Logger LOGGER = LogManager.getLogger(MODID);


	@Override
	public void onInitialize() {
		ModItems.register(); // just call the mod items register method
		LootTableInjection.registerInjections(); // adds injections to vanilla loot tables
	}
}

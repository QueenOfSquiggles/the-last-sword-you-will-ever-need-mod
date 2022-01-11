package com.queen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class LastSword implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("tlsywen");

	public static final String MODID = "tlsywen"; // use modid for namespaces. IDK if this is like Forge where that's required or not

	@Override
	public void onInitialize() {
		ModItems.register(); // just call the mod items register method
	}
}

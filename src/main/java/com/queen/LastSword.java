package com.queen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class LastSword implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("tlsywen");

	public static final String MODID = "tlsywen";

	@Override
	public void onInitialize() {
		ModItems.register();
	}
}

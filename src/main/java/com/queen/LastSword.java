package com.queen;

import java.util.Random;

import com.queen.utils.DropMetrics;
import com.queen.utils.LootTableInjection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.util.math.Vector2f;

public class LastSword implements ModInitializer {
	
	public static final String MODID = "tlsywen"; // use modid for namespaces. IDK if this is like Forge where that's required or not
	public static final Logger LOGGER = LogManager.getLogger(MODID);


	@Override
	public void onInitialize() {
		ModItems.register(); // just call the mod items register method
		LootTableInjection.registerInjections(); // adds injections to vanilla loot tables
		testDropRateAll();
	}

	private void testDropRateAll() {
		final int test_num = 1000;

		testDropRate(DropMetrics.END_DRAGON_DROP_RATE, "END_DRAGON_DROP_RATE", test_num);
		// as more metrics are added, I'll append those here for testing
	}

	private void testDropRate(DropMetrics.DropRate range, String name, int test_num){
		Random r = new Random();
		long seed = r.nextLong();
		r.setSeed(seed);
		long aggregate = 0;
		int highest = 0;
		int lowest = Integer.MAX_VALUE;
		for ( int i = 0 ; i < test_num; i++){
			int count = DropMetrics.getDrop(r, DropMetrics.END_DRAGON_DROP_RATE);
			aggregate += count;
			if (count > highest) highest = count;
			if (count < lowest) lowest = count;
		}
		int average = (int) (aggregate / test_num);
		LOGGER.info("Testing DropMetrics:getDrop for '"+name+"' --> Avg / min / max : " + average + " / " + lowest + " / " + highest + " / ");
		System.out.println("Test lines above????");
	}
}

package com.queen.utils;

import com.queen.ModItems;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
public class LootTableInjection {

    // private static final Identifier ENDER_DRAGON_LOOT = LootManager.

    
    
    /*
    I case I forget later on:
    
    Use ConstantLootNumberProvider to make a constant number of drops.
    > num = const_num
    UniformLootNumberProvider to make a random from min to max
    > num = ((max-min) * randf) + min
    BinomialLootNumberProvider to set a success rate and number of tries
    > num = 0
    for (num tries)
    if (randf > success rate) num++
    return num
    */
    
    private static final Identifier END_TOWER_CHEST_LOOT = new Identifier("minecraft", "chests/end_city_treasure");
    private static final Identifier ELDER_GUARDIAN_LOOT = new Identifier("minecraft", "entities/elder_guardian");
    private static final Identifier WITHER_LOOT = new Identifier("minecraft", "entities/wither");
    private static final Identifier END_DRAGON_LOOT = new Identifier("minecraft", "entities/ender_dragon");
    private static final Identifier ENDERMAN_LOOT = new Identifier("minecraft", "entities/enderman");
    private static final Identifier END_STONE_LOOT = Blocks.END_STONE.getLootTableId(); // blocks have this built in
    private static final Identifier PIGLIN_BARTER_LOOT = new Identifier("minecraft", "gameplay/piglin_bartering");
    private static final Identifier FISHING_TREASURE_LOOT = new Identifier("minecraft", "gameplay/fishing/treasure");

    public static void registerInjections() {
        // Guaranteed Crystals
        addLoot(END_TOWER_CHEST_LOOT, uniform(7.0f, 10.0f), ModItems.DRAGON_CRYSTAL);
        addLoot(END_TOWER_CHEST_LOOT, binomial(2, 0.01f), ModItems.DRAGON_CRYSTAL);
        addLoot(ELDER_GUARDIAN_LOOT, uniform(7.0f, 10.0f), ModItems.DRAGON_CRYSTAL);
        addLoot(WITHER_LOOT, uniform(7.0f, 10.0f), ModItems.DRAGON_CRYSTAL);
        addLoot(END_DRAGON_LOOT, uniform(2.0f, 5.0f), ModItems.DRAGON_CRYSTAL); // this is additional to the event injection which gives to all players on death. Race to grab the extra!
        
        // Chance of crystals
        addLoot(END_STONE_LOOT, binomial(1, 0.01f), ModItems.DRAGON_CRYSTAL);
        addLoot(ENDERMAN_LOOT, binomial(2, 0.025f), ModItems.DRAGON_CRYSTAL); // enderman can be farmed. Maybe should this just be removed?
        // maybe allowing enderman farms would let the player generate a near infinite amount of crystals. Which could be a cool reward 
        addLoot(PIGLIN_BARTER_LOOT, binomial(1, 0.01f), ModItems.DRAGON_CRYSTAL); // I have no clue how common/uncommon this will be. If I did this right, it should be as rare as enchanted books
        addLoot(FISHING_TREASURE_LOOT, binomial(1, 0.167f), ModItems.DRAGON_CRYSTAL); // this is effectively a novelty. This 17% chance is composited by the 5% chance of getting treasure from fishing. It would be super cool to see, but not very likely at all.
    }

    /**Helper function for UniformLootNumberProvider:create */
    private static LootNumberProvider uniform(float min, float max){
        return UniformLootNumberProvider.create(min, max);
    }

    /**Helper function for BinomialLootNumberProvider:create */
    private static LootNumberProvider binomial(int num, float chance){
        return BinomialLootNumberProvider.create(num, chance);
    }

    /**
     * A utility method for adding simple loot table additions. It can take any number of items at once but all will be generated from the same LootNumberProvider
     */
    private static void addLoot(Identifier loot_id, LootNumberProvider lnp, ItemConvertible...items){
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
            if (loot_id.equals(id)){
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(lnp);
                for (ItemConvertible ic : items){
                    poolBuilder = poolBuilder.with(ItemEntry.builder(ic));
                }
                table.pool(poolBuilder);
            }
        });
    }

}

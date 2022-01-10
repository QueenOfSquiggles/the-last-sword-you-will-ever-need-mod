package com.queen;

import com.queen.items.ItemDragonSword;
import com.queen.tool_materials.DragonToolMaterial;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //public static final ItemGroup MOD_ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("modid", "moditems")).icon(() -> new ItemStack(Items.DRAGON_EGG)).build();
    
    public static final ToolMaterial TOOL_DRAGON_LV1 = new DragonToolMaterial(800);
    public static final ToolMaterial TOOL_DRAGON_LV2 = new DragonToolMaterial(1600);
    public static final ToolMaterial TOOL_DRAGON_LV3 = new DragonToolMaterial(3200);
    public static final ToolMaterial TOOL_DRAGON_LV4 = new DragonToolMaterial(6400);
    public static final ToolMaterial TOOL_DRAGON_LV5 = new DragonToolMaterial(12800);
    public static final ToolMaterial TOOL_DRAGON_LV6 = new DragonToolMaterial(25600);
    public static final ToolMaterial TOOL_DRAGON_LV7 = new DragonToolMaterial(51200);
    public static final ToolMaterial TOOL_DRAGON_LV8 = new DragonToolMaterial(102400);
    public static final ToolMaterial TOOL_DRAGON_LV9 = new DragonToolMaterial(204800);
    public static final ToolMaterial TOOL_DRAGON_LV10 = new DragonToolMaterial(409600);
    public static final ToolMaterial TOOL_DRAGON_LVAWESOME = new DragonToolMaterial(Integer.MAX_VALUE-10); // need to reduce to prevent overflow

    public static final Item DRAGON_SWORD_LV1 = new ItemDragonSword(TOOL_DRAGON_LV1, false);
    public static final Item DRAGON_SWORD_LV2 = new ItemDragonSword(TOOL_DRAGON_LV2, false);
    public static final Item DRAGON_SWORD_LV3 = new ItemDragonSword(TOOL_DRAGON_LV3, false);
    public static final Item DRAGON_SWORD_LV4 = new ItemDragonSword(TOOL_DRAGON_LV4, false);
    public static final Item DRAGON_SWORD_LV5 = new ItemDragonSword(TOOL_DRAGON_LV5, false);
    public static final Item DRAGON_SWORD_LV6 = new ItemDragonSword(TOOL_DRAGON_LV6, false);
    public static final Item DRAGON_SWORD_LV7 = new ItemDragonSword(TOOL_DRAGON_LV7, false);
    public static final Item DRAGON_SWORD_LV8 = new ItemDragonSword(TOOL_DRAGON_LV8, false);
    public static final Item DRAGON_SWORD_LV9 = new ItemDragonSword(TOOL_DRAGON_LV9, false);
    public static final Item DRAGON_SWORD_LV10 = new ItemDragonSword(TOOL_DRAGON_LV10, false);

    public static final Item DRAGON_SWORD_LVAWESOME = new ItemDragonSword(TOOL_DRAGON_LVAWESOME,true);

    public static void register(){        
        Registry.register(Registry.ITEM, new Identifier(LastSword.MODID, "dragon_sword_lv1"), DRAGON_SWORD_LV1);
        Registry.register(Registry.ITEM, new Identifier(LastSword.MODID, "dragon_sword_lv2"), DRAGON_SWORD_LV2);
        Registry.register(Registry.ITEM, new Identifier(LastSword.MODID, "dragon_sword_lv3"), DRAGON_SWORD_LV3);
        Registry.register(Registry.ITEM, new Identifier(LastSword.MODID, "dragon_sword_lv4"), DRAGON_SWORD_LV4);
        Registry.register(Registry.ITEM, new Identifier(LastSword.MODID, "dragon_sword_lv5"), DRAGON_SWORD_LV5);
        Registry.register(Registry.ITEM, new Identifier(LastSword.MODID, "dragon_sword_lv6"), DRAGON_SWORD_LV6);
        Registry.register(Registry.ITEM, new Identifier(LastSword.MODID, "dragon_sword_lv7"), DRAGON_SWORD_LV7);
        Registry.register(Registry.ITEM, new Identifier(LastSword.MODID, "dragon_sword_lv8"), DRAGON_SWORD_LV8);
        Registry.register(Registry.ITEM, new Identifier(LastSword.MODID, "dragon_sword_lv9"), DRAGON_SWORD_LV9);
        Registry.register(Registry.ITEM, new Identifier(LastSword.MODID, "dragon_sword_lv10"), DRAGON_SWORD_LV10);
        Registry.register(Registry.ITEM, new Identifier(LastSword.MODID, "dragon_sword_lv_awesome"), DRAGON_SWORD_LVAWESOME);
    }
    
}

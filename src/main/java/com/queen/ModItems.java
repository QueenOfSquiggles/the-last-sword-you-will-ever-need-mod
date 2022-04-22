package com.queen;

import com.queen.armour.DragonArmourMaterial;
import com.queen.items.ItemDragonSword;
import com.queen.tool_materials.DragonToolMaterial;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // Tool Materials
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

    // Swords
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

    // Armour
    public static final ArmorMaterial DRAGON_ARMOUR = new DragonArmourMaterial();

    public static final Item DRAGON_ARMOUR_HELM = new ArmorItem(DRAGON_ARMOUR, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item DRAGON_ARMOUR_CHESTPLATE = new ArmorItem(DRAGON_ARMOUR, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item DRAGON_ARMOUR_LEGGINGS = new ArmorItem(DRAGON_ARMOUR, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item DRAGON_ARMOUR_BOOTS = new ArmorItem(DRAGON_ARMOUR, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));


    // Recipe Items
    public static final Item DRAGON_CRYSTAL = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item DRAGON_GEM = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));

    public static void register(){
        register_item("dragon_crystal", DRAGON_CRYSTAL);
        register_item("dragon_gem", DRAGON_GEM);

        register_item("dragon_sword_lv1", DRAGON_SWORD_LV1);
        register_item("dragon_sword_lv2", DRAGON_SWORD_LV2);
        register_item("dragon_sword_lv3", DRAGON_SWORD_LV3);
        register_item("dragon_sword_lv4", DRAGON_SWORD_LV4);
        register_item("dragon_sword_lv5", DRAGON_SWORD_LV5);
        register_item("dragon_sword_lv6", DRAGON_SWORD_LV6);
        register_item("dragon_sword_lv7", DRAGON_SWORD_LV7);
        register_item("dragon_sword_lv8", DRAGON_SWORD_LV8);
        register_item("dragon_sword_lv9", DRAGON_SWORD_LV9);
        register_item("dragon_sword_lv10", DRAGON_SWORD_LV10);
        register_item("dragon_sword_lv_awesome", DRAGON_SWORD_LVAWESOME);

        register_item("dragon_armour_helm", DRAGON_ARMOUR_HELM);
        register_item("dragon_armour_chestplate", DRAGON_ARMOUR_CHESTPLATE);
        register_item("dragon_armour_leggings", DRAGON_ARMOUR_LEGGINGS);
        register_item("dragon_armour_boots", DRAGON_ARMOUR_BOOTS);
    }

    private static void register_item(String itemID, Item item){
        // a helper method since there's a lot of repitition
        Registry.register(Registry.ITEM, new Identifier(LastSword.MODID, itemID), item);
    }
    
}

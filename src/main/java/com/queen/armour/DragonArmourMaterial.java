package com.queen.armour;

import com.queen.ModItems;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class DragonArmourMaterial implements ArmorMaterial {
    private static final String NAME = "dragon_armour";
    private static final int[] BASE_DURABILITY = new int[]{ 13, 15, 16, 11 };
    private static final int[] PROTECTION = new int[]{ 3, 6, 8, 3 };
    private static final int ENCHANTABILITY = 30;
    private static final float KNOCKBACK_RESISTENCE = 0.0f;
    
    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return ENCHANTABILITY;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public float getKnockbackResistance() {
        return KNOCKBACK_RESISTENCE;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION[slot.getEntitySlotId()];
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.DRAGON_GEM);
    }

    @Override
    public float getToughness() {
        return 0.5f;
    }
    
}

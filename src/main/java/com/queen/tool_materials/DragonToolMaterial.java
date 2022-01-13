package com.queen.tool_materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class DragonToolMaterial implements ToolMaterial {

    private final int attackDamage;

    public DragonToolMaterial(int damage){
        attackDamage = damage;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getDurability() {
        return -1;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0f;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }
    
}

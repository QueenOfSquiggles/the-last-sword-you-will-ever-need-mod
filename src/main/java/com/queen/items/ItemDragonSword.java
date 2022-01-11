package com.queen.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class ItemDragonSword extends SwordItem {

    private final boolean forceKill;
    private final int attackDamageOverride; // override the base value so I can directly control the number with tool materials
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiersOverride;

    private static final float ATTACK_SPEED = 10.0f;


    public ItemDragonSword(ToolMaterial toolMaterial, boolean forceKill) {
        super(toolMaterial, 0, ATTACK_SPEED, new Item.Settings().group(ItemGroup.COMBAT));
        
        // is forcekill too much? Would other mods have ways to make orespawn level bosses which can survive a "kill" command?
        // It's probably an inevitability, but not something for me to worry about. This mod is for fun anyway, not an arms race. :/
        this.forceKill = forceKill;
        
        attackDamageOverride = (int)toolMaterial.getAttackDamage();
        Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", (double)this.attackDamageOverride, Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", (double)ATTACK_SPEED, Operation.ADDITION));
        this.attributeModifiersOverride = builder.build();
    }

    public float getAttackDamage() {
        return this.attackDamageOverride;
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        // magic constant. I don't like it but alternative is a private static final var which doesn't look much better?  
        return 15.0f;
    }
  
    @Override
    public boolean damage(DamageSource source) {
        // prevent item from being destroyed by lava or cacti
        return false;
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // get's called after a living entity is hit with this item?
        // So this should work also if given to a zombie??? <-- that's bad news for player
        if(forceKill) target.kill(); // if this sword forces death, automatically kill the entity, regardless of health remaining
        return false;
    }

    public boolean isSuitableFor(BlockState state) {
        // force to be suitable mining tool for all possible blocks (mining level determines if it can harvest)
        return true;
     }

     public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
         // override to use my attrib modifier multimap. 
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiersOverride : super.getAttributeModifiers(slot);
     }    
    
}

package com.queen.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.world.dimension.DimensionType;

@Mixin(DimensionType.class)
public interface DimensionTypeAccess {

    @Accessor("THE_END")
    public static DimensionType getTHE_END(){
        throw new AssertionError(); // method is never actually called
    }
    
}

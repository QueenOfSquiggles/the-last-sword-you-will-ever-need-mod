package com.queen.utils;

import net.minecraft.sound.SoundEvent;

public class SoundRecord {
    public final SoundEvent sound;
    public final long time;
    public final float pitch;

    public SoundRecord(SoundEvent sound, long time, float pitch){
        this.sound = sound;
        this.time = time;
        this.pitch = pitch;
    }
}

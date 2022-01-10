package com.queen.utils;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.client.util.math.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundEvent;

/**
 * A sound utility for doing more interesting sounds than just randomized pitch.
 * Rand pitch is still made easier, but this also enables a nintendo-similar sound playing system which 
 * will increase the pitch for repeating sounds so the monotony is prevented.
 * 
 * 
 */
public class SoundUtil {

    public static final Vector2f PITCH_RANGE = new Vector2f(0.5f, 2.0f);
    public static final float PITCH_STEP = 0.125f;
    public static final float PITCH_VARIANCE = PITCH_STEP * 0.25f;
    public static final float FINAL_NOTE_VOLUME_BOOST = 1.5f;
    public static final float TIME_FRAME = 2.0f;

    private static final int SOUND_BUFFER_COUNT = 10; // limits the number of remembered sounds to preserve RAM
    private static ArrayList<SoundRecord> recent_sound_events = new ArrayList<SoundRecord>(SOUND_BUFFER_COUNT);
    private static Random random = new Random();

    /**
     * Plays a sound in the nintendo style where if the sound file was recently heard (within certain time frame) the pitch increases
     * 
     */
    public static void playSoundNintendo(Entity entity, SoundEvent sound, float volume){
        float recentPitch = getLastPitch(sound, TIME_FRAME);

        float pitch = recentPitch;
        if (pitch < 0.0f) pitch = PITCH_RANGE.getX();
        else pitch += PITCH_STEP;
        if (pitch > PITCH_RANGE.getY()){
            pitch = PITCH_RANGE.getX();
        }
        pitch += PITCH_VARIANCE * (random.nextFloat() * 2.0f - 1.0f);

        entity.playSound(sound, volume, pitch);

        registerSoundEvent(sound, pitch);
    }

    private static float getLastPitch(SoundEvent sound, float time_frame){
        long time_frame_millis = (long)(time_frame * 1000.0f);
        long now = System.currentTimeMillis();
        for ( int i = recent_sound_events.size()-1; i >= 0; i--){
            // iterate in reverse order to hit more recent sounds first
            SoundRecord sr = recent_sound_events.get(i);
            if (sr.sound.equals(sound)){
                long delta = now - sr.time;
                if (delta < time_frame_millis) return sr.pitch; // recent sound : get pitch
                else return -1.0f; // last sound outside of time frame, not recent enough
            }
        }
        return -1.0f; // no sound instance in buffer, start from default
    }

    private static void registerSoundEvent(SoundEvent sound, float pitch){
        // add record to back
        recent_sound_events.add(new SoundRecord(sound, System.currentTimeMillis(), pitch));

        while (recent_sound_events.size() > SOUND_BUFFER_COUNT){
            recent_sound_events.remove(0); // clear out front
        }
    }
    
}

package net.rk.thingamajigs.xtras;

import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.util.DeferredSoundType;

public class TSoundType{
    public static final DeferredSoundType POOP = new DeferredSoundType(1.0F,1.0F,
            TSoundEvent.POOP_BREAK,TSoundEvent.POOP_STEP,
            TSoundEvent.POOP,TSoundEvent.POOP_HIT,TSoundEvent.POOP);

    public static final DeferredSoundType CALENDAR = new DeferredSoundType(1.0f,1.0f,
            () -> SoundEvents.ITEM_FRAME_BREAK,() -> SoundEvents.BAMBOO_WOOD_STEP,
            () -> SoundEvents.ITEM_FRAME_PLACE,() -> SoundEvents.BAMBOO_WOOD_HIT,() -> SoundEvents.ITEM_FRAME_BREAK);
}

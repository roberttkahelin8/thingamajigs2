package net.rk.thingamajigs.xtras;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rk.thingamajigs.Thingamajigs;

import java.util.function.Supplier;

@SuppressWarnings("deprecated,unused")
public class TSoundEvent{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Thingamajigs.MODID);

    public static final Supplier<SoundEvent> STATIC = SOUND_EVENTS.register("static",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "static")));
    public static final Supplier<SoundEvent> HORN = SOUND_EVENTS.register("horn",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "horn")));
    public static final Supplier<SoundEvent> CODE = SOUND_EVENTS.register("code",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "code")));
    public static final Supplier<SoundEvent> BEEP = SOUND_EVENTS.register("beep",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "beep")));

    public static final Supplier<SoundEvent> ELECTRONIC = SOUND_EVENTS.register("electronic",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "electronic")));
    public static final Supplier<SoundEvent> METALLIC = SOUND_EVENTS.register("metallic",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "metallic")));
    public static final Supplier<SoundEvent> OLD = SOUND_EVENTS.register("old",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "old")));
    public static final Supplier<SoundEvent> PLUCK = SOUND_EVENTS.register("pluck",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "pluck")));

    public static final Supplier<SoundEvent> POOP = SOUND_EVENTS.register("poop",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "poop")));
    public static final Supplier<SoundEvent> AIR = SOUND_EVENTS.register("air",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "air")));
    public static final Supplier<SoundEvent> WATER_NOISE = SOUND_EVENTS.register("water_noise",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "water_noise")));

    public static final Supplier<SoundEvent> POOP_BREAK = SOUND_EVENTS.register("poop_break",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "poop_break")));
    public static final Supplier<SoundEvent> POOP_HIT = SOUND_EVENTS.register("poop_hit",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "poop_hit")));
    public static final Supplier<SoundEvent> POOP_STEP = SOUND_EVENTS.register("poop_step",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "poop_step")));

    public static final Supplier<SoundEvent> MECH_BELL_ONE = SOUND_EVENTS.register("mech_bell_one",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mech_bell_one")));
    public static final Supplier<SoundEvent> MECH_BELL_TWO = SOUND_EVENTS.register("mech_bell_two",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mech_bell_two")));
    public static final Supplier<SoundEvent> EBELL_ONE = SOUND_EVENTS.register("ebell_one",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "ebell_one")));
    public static final Supplier<SoundEvent> EBELL_TWO = SOUND_EVENTS.register("ebell_two",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "ebell_two")));

    public static final Supplier<SoundEvent> MOBILE_BEEP = SOUND_EVENTS.register("mobile_beep",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mobile_beep")));

    public static final Supplier<SoundEvent> MOBILE_ZERO = SOUND_EVENTS.register("mobile_zero",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mobile_zero")));

    public static final Supplier<SoundEvent> MOBILE_ONE = SOUND_EVENTS.register("mobile_one",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mobile_one")));
    public static final Supplier<SoundEvent> MOBILE_TWO = SOUND_EVENTS.register("mobile_two",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mobile_two")));
    public static final Supplier<SoundEvent> MOBILE_THREE = SOUND_EVENTS.register("mobile_three",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mobile_three")));
    public static final Supplier<SoundEvent> MOBILE_FOUR = SOUND_EVENTS.register("mobile_four",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mobile_four")));
    public static final Supplier<SoundEvent> MOBILE_FIVE = SOUND_EVENTS.register("mobile_five",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mobile_five")));
    public static final Supplier<SoundEvent> MOBILE_SIX = SOUND_EVENTS.register("mobile_six",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mobile_six")));
    public static final Supplier<SoundEvent> MOBILE_SEVEN = SOUND_EVENTS.register("mobile_seven",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mobile_seven")));
    public static final Supplier<SoundEvent> MOBILE_EIGHT = SOUND_EVENTS.register("mobile_eight",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mobile_eight")));
    public static final Supplier<SoundEvent> MOBILE_NINE = SOUND_EVENTS.register("mobile_nine",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mobile_nine")));
    public static final Supplier<SoundEvent> MOBILE_POUND = SOUND_EVENTS.register("mobile_pound",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mobile_pound")));
    public static final Supplier<SoundEvent> MOBILE_STAR = SOUND_EVENTS.register("mobile_star",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "mobile_star")));

    public static final Supplier<SoundEvent> POP = SOUND_EVENTS.register("pop",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "pop")));
    public static final Supplier<SoundEvent> YODELER = SOUND_EVENTS.register("yodeler",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "yodeler")));

    public static final Supplier<SoundEvent> LARGE_POOP = SOUND_EVENTS.register("large_poop",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "large_poop")));

    public static final Supplier<SoundEvent> ERROR = SOUND_EVENTS.register("error",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "error")));

    public static final Supplier<SoundEvent> SQUEAK = SOUND_EVENTS.register("squeak",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Thingamajigs.MODID, "squeak")));

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}

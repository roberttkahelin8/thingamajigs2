package net.rk.thingamajigs.blockentity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rk.thingamajigs.Thingamajigs;
import net.rk.thingamajigs.block.TBlocks;
import net.rk.thingamajigs.blockentity.custom.DJLaserLightBE;
import net.rk.thingamajigs.blockentity.custom.FridgeBE;

import java.util.function.Supplier;

public class TBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(
            BuiltInRegistries.BLOCK_ENTITY_TYPE, Thingamajigs.MODID);

    public static final Supplier<BlockEntityType<DJLaserLightBE>> DJ_LASER_LIGHT_BE = BLOCK_ENTITIES.register(
            "laser_light_be",() ->
                    BlockEntityType.Builder.of(DJLaserLightBE::new,TBlocks.DJ_LASER_LIGHT.get())
                    .build(null));

    public static final Supplier<BlockEntityType<FridgeBE>> FRIDGE_BE = BLOCK_ENTITIES.register(
            "fridge_be",() -> BlockEntityType.Builder.of(FridgeBE::new,TBlocks.FRIDGE.get())
                    .build(null));


    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}

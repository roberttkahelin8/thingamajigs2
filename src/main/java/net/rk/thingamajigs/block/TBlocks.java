package net.rk.thingamajigs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rk.thingamajigs.Thingamajigs;
import net.rk.thingamajigs.block.custom.*;
import net.rk.thingamajigs.item.TItems;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

@SuppressWarnings("deprecated")
public class TBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Thingamajigs.MODID);
    // starting from FREAKING SCRATCH AGAIN 1.21

    public static final DeferredBlock<Block> NOT_QUITE = register("not_quite",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
                    .strength(1f,5f).noOcclusion()
                    .sound(SoundType.METAL).mapColor(MapColor.COLOR_BLUE)));
    public static final DeferredBlock<Block> BASIC_BATHROOM_TILE = register("basic_bathroom_tile",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)));
    public static final DeferredBlock<Block> MINIGOLF_GRASS_BLOCK = register("minigolf_grass_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK).strength(1.1f).sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> MINIGOLF_HOLE = register("minigolf_hole",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK).strength(1.1f).sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> FAN_BLOCK_ULTRASONIC = register("fan_block_ultrasonic",
            () -> new FanBlock(BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> FAN_BLOCK_FAST = register("fan_block_fast",
            () -> new FanBlock(BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> FAN_BLOCK = register("fan_block",
            () -> new FanBlock(BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> FAN_BLOCK_OFF = register("fan_block_off",
            () -> new FanBlock(BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> TECHNO_PILLAR = register("techno_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(1.2f,24F)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)
                    .emissiveRendering(TBlocks::always)));
    public static final DeferredBlock<Block> TECHNO_CORE = register("techno_core",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f,32F).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .emissiveRendering(TBlocks::always)));
    public static final DeferredBlock<Block> NEON_BLOCK = register("neon_block",
            () -> new RedstoneLampBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL).lightLevel(customLitBlockEmission(15))));
    public static final DeferredBlock<Block> ALT_NEON_BLOCK = register("alternative_neon_block",
            () -> new RedstoneLampBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL).lightLevel(customLitBlockEmission(15))));
    public static final DeferredBlock<Block> OLD_TEAL_WOOL = register("old_teal_wool",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.5f).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> LOVE_SEAT_WOOL = register("love_seat_wool",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.5f).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> OAK_LANE = register("oak_lane",
            () -> new LaneBlock(BlockBehaviour.Properties.of().ignitedByLava()));
    public static final DeferredBlock<Block> GRATE = register("grate",
            () -> new Grate(BlockBehaviour.Properties.of().isRedstoneConductor(TBlocks::never).isSuffocating(TBlocks::never).isViewBlocking(TBlocks::never)));
    public static final DeferredBlock<Block> BRICK_SIDEWALK = register("brick_sidewalk",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> BRICK_SIDEWALK_HB = register("brick_sidewalk_hb",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> STORE_FLOORING = register("store_flooring",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    // torches
    public static final DeferredBlock<Block> GROUND_CLEAR_BULB = registerBlockWithoutItem("standing_clear_bulb",
            () -> new NoParticlesTorchBlock(ParticleTypes.FLAME,BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).lightLevel(s -> 12)){
                @Override
                public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
                    return TItems.CLEAR_BULB_ITEM.asItem().getDefaultInstance();
                }
            });
    public static final DeferredBlock<Block> WALL_CLEAR_BULB = registerBlockWithoutItem("wall_clear_bulb",
            () -> new NoParticlesWallTorchBlock(ParticleTypes.FLAME,BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).lightLevel(s -> 12))
            {
                @Override
                public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
                    return TItems.CLEAR_BULB_ITEM.asItem().getDefaultInstance();
                }
            });

    public static final DeferredBlock<Block> GROUND_FULL_BULB = registerBlockWithoutItem("standing_full_bulb",
            () -> new NoParticlesTorchBlock(ParticleTypes.FLAME,BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).lightLevel(s -> 12))
            {
                @Override
                public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
                    return TItems.FULL_BULB_ITEM.asItem().getDefaultInstance();
                }
            });
    public static final DeferredBlock<Block> WALL_FULL_BULB = registerBlockWithoutItem("wall_full_bulb",
            () -> new NoParticlesWallTorchBlock(ParticleTypes.FLAME,BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).lightLevel(s -> 12))
            {
                @Override
                public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
                    return TItems.FULL_BULB_ITEM.asItem().getDefaultInstance();
                }
            });

    public static final DeferredBlock<Block> GROUND_CLEAR_LANTERN = registerBlockWithoutItem("standing_clear_lantern",
            () -> new TorchBlock(ParticleTypes.FLAME,BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).lightLevel(s -> 12))
            {
                @Override
                public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
                    return TItems.CLEAR_LANTERN_ITEM.asItem().getDefaultInstance();
                }
            });
    public static final DeferredBlock<Block> WALL_CLEAR_LANTERN = registerBlockWithoutItem("wall_clear_lantern",
            () -> new WallTorchBlock(ParticleTypes.FLAME,BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).lightLevel(s -> 12))
            {
                @Override
                public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
                    return TItems.CLEAR_LANTERN_ITEM.asItem().getDefaultInstance();
                }
            });

    public static final DeferredBlock<Block> GROUND_FULL_LANTERN = registerBlockWithoutItem("standing_full_lantern",
            () -> new NoParticlesTorchBlock(ParticleTypes.FLAME,BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).lightLevel(s -> 12))
            {
                @Override
                public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
                    return TItems.FULL_LANTERN_ITEM.asItem().getDefaultInstance();
                }
            });
    public static final DeferredBlock<Block> WALL_FULL_LANTERN = registerBlockWithoutItem("wall_full_lantern",
            () -> new NoParticlesWallTorchBlock(ParticleTypes.FLAME,BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).lightLevel(s -> 12))
            {
                @Override
                public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
                    return TItems.FULL_LANTERN_ITEM.asItem().getDefaultInstance();
                }
            });


    public static final DeferredBlock<Block> TV = register("tv",
            () -> new TV(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .strength(2f).sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<Block> BIG_TV = register("big_tv",
            () -> new BigTV(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.LANTERN).noOcclusion()));
    public static final DeferredBlock<Block> AIR_CONDITIONER = register("air_conditioner",
            () -> new AirConditioner(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> VHS_PLAYER = register("vhs_player",
            () -> new VhsPlayer(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> DVD_PLAYER = register("dvd_player",
            () -> new DvdPlayer(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> BLUEMAN_CONSOLE = register("blueman_console",
            () -> new BluemanConsole(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> WHITE_FAN = register("white_fan",
            () -> new StandingFanBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> GRAY_FAN = register("gray_fan",
            () -> new StandingFanBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> BLACK_FAN = register("black_fan",
            () -> new StandingFanBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> THEATER_SEAT = register("theater_seat",
            () -> new TheaterSeat(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> THEATER_SEAT_CONTINUOUS = register("theater_seat_cont",
            () -> new TheaterSeat(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    // TODO finish recipes gen from this point on to end ( and loot tables )
    public static final DeferredBlock<Block> POPCORN_MACHINE = register("popcorn_machine",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).lightLevel(s -> 5)));
    public static final DeferredBlock<Block> TICKET_TELLER_WINDOW = register("ticket_teller_window",
            () -> new TicketTellerWindowBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> VELVET_ROPE_FENCE = register("velvet_rope_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .sound(SoundType.WOOL).strength(1.1F,2.5F)));

    // General Purpose Decorative Blocks
    public static final DeferredBlock<Block> REFRESHMENT_MACHINE = register("refreshment_machine",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).lightLevel(s -> 7)));
    public static final DeferredBlock<Block> BLUEYBOX = register("blueybox",
            () -> new BlueyBox(BlockBehaviour.Properties.of().sound(SoundType.NETHERITE_BLOCK).lightLevel(s -> 12)));
    public static final DeferredBlock<Block> BLUE_SODA_MACHINE = register("blue_soda_machine",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).lightLevel(s -> 12)));
    public static final DeferredBlock<Block> RED_SODA_MACHINE = register("red_soda_machine",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).lightLevel(s -> 12)));
    public static final DeferredBlock<Block> CASH_REGISTER = register("cash_register",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.NETHERITE_BLOCK).lightLevel(s -> 5)));
    public static final DeferredBlock<Block> BLUE_VENDING_MACHINE = register("blue_vending_machine",
            () -> new VendingMachine(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).lightLevel(s -> 12)));
    public static final DeferredBlock<Block> RED_VENDING_MACHINE = register("red_vending_machine",
            () -> new VendingMachine(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).lightLevel(s -> 12)));
    public static final DeferredBlock<Block> COFFEE_MACHINE = register("coffee_machine",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> PAYPHONE = register("payphone",
            () -> new Payphone(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> PAYPHONE_SEETHROUGH = register("payphone_seethrough",
            () -> new Payphone(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> GAS_PUMP = register("gas_pump",
            () -> new GasPump(BlockBehaviour.Properties.of().sound(SoundType.NETHERITE_BLOCK)));
    public static final DeferredBlock<Block> GAS_CAN = register("gas_can",
            () -> new GasCan(BlockBehaviour.Properties.of().sound(SoundType.CANDLE)));
    public static final DeferredBlock<Block> STORE_SHELF = register("store_shelf",
            () -> new StoreShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> STORE_FREEZER = register("store_freezer",
            () -> new StoreFreezer(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FRIER = register("frier",
            () -> new ToggledStateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> BLACK_TELEPHONE = register("black_telephone",
            () -> new OldTelephone(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> WHITE_TELEPHONE = register("white_telephone",
            () -> new OldTelephone(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> STORE_NUMBER_SIGN = register("store_number_sign",
            () -> new StoreNumberSign(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> FREEZER = register("freezer",
            () -> new Freezer(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> FRENCH_PRESS = register("french_press",
            () -> new FrenchPress(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> FRIDGE = register("fridge",
            () -> new Fridge(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> GRAPHICS_CARD = register("graphics_card",
            () -> new GraphicsCard(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> MOBILE_PHONE = register("mobile_phone",
            () -> new MobilePhone(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> HARD_DRIVE = register("hard_drive",
            () -> new GraphicsCard(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> DRYER = register("dryer",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> WASHER = register("washer",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> HOTTUB = register("hottub",
            () -> new Hottub(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> SATELLITE_DISH = register("satellite_dish",
            () -> new Satellite(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> ANTENNA = register("antenna",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> BLUEYTOSH_LAPTOP = register("blueytosh_laptop",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).noCollission()));
    public static final DeferredBlock<Block> BLUEYTOSH_LAPTOP_OLD = register("blueytosh_laptop_old",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).noCollission()));
    public static final DeferredBlock<Block> BLUEYDOWS_LAPTOP = register("blueydows_laptop",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).noCollission()));
    public static final DeferredBlock<Block> TOASTER = register("toaster",
            () -> new Toaster(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> MICROWAVE = register("microwave",
            () -> new Microwave(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> WHEELBARROW = register("wheelbarrow",
            () -> new Wheelbarrow(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> STOVE_HOOD = register("stove_hood",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).lightLevel(s -> 5).noCollission()));
    public static final DeferredBlock<Block> STOVE = register("stove",
            () -> new Stove(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> SOLAR_PANEL = register("solar_panel",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> STORE_STAND = register("store_stand",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> OLD_FLAT_COMPUTER = register("old_flat_computer",
            () -> new OldFlatComputer(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> SHOPPING_CART_MOVER = register("shopping_cart_mover",
            () -> new Wheelbarrow(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> SHOPPING_CART = register("shopping_cart",
            () -> new Wheelbarrow(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> MINIGOLF_FLAG = register("minigolf_flag",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).noCollission()));
    public static final DeferredBlock<Block> OVEN = register("oven",
            () -> new Oven(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> ICECREAM_MACHINE = register("icecream_machine",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> INTERNET_MODEM = register("internet_modem",
            () -> new InternetRouter(BlockBehaviour.Properties.of().lightLevel(s -> 5)));
    public static final DeferredBlock<Block> INTERNET_ROUTER = register("internet_router",
            () -> new InternetRouter(BlockBehaviour.Properties.of().lightLevel(s -> 5)));
    public static final DeferredBlock<Block> NEWER_INTERNET_ROUTER = register("internet_router_newer",
            () -> new InternetRouter(BlockBehaviour.Properties.of().lightLevel(s -> 5)));
    public static final DeferredBlock<Block> WIFI_ROUTER = register("wifi_router",
            () -> new OldFlatComputer(BlockBehaviour.Properties.of().lightLevel(s -> 5)));
    public static final DeferredBlock<Block> OPEN_SIGN = register("open_sign",
            () -> new OpenSign(BlockBehaviour.Properties.of()
                    .lightLevel(openSignLitEmission(15))));
    public static final DeferredBlock<Block> RECYCLE_BIN = register("recycle_bin",
            () -> new RecycleBin(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1F,1F)));
    public static final DeferredBlock<Block> SERVER_RACK = register("server_rack",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> MODERN_PC_MONITOR = register("pc_screen",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> OLD_PC_MONITOR = register("pc_monitor",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> OLD_PC = register("old_pc",
            () -> new OldPC(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> PAPER_TOWEL = register("paper_towel",
            () -> new HazardSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> AISLE_SIGN = register("aisle_sign",
            () -> new AisleSign(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TRAFFIC_CONTROL_BOX = register("traffic_control_box",
            () -> new TrafficControlBox(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> CELL_MICROWAVE_TRANSMITTER = register("microwave_transmitter",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> CELL_TRANSMITTER = register("cell_transmitter",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> CELL_MULTI_TRANSMITTER = register("cell_multi_transmitter",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> CELL_MULTI_ANGLED_TRANSMITTER = register("cell_multi_angled_transmitter",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> OLD_MICROWAVE_TRANSMITTER = register("old_microwave_transmitter",
            () -> new MicrowaveTransmitter(BlockBehaviour.Properties.of().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> STONE_TABLE = register("stone_table",
            () -> new ConnectedTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> GOLD_TABLE = register("gold_table",
            () -> new ConnectedTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK).sound(SoundType.METAL)));
    public static final DeferredBlock<Block> SCULK_TABLE = register("sculk_table",
            () -> new ConnectedTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.SCULK_CATALYST)));
    public static final DeferredBlock<Block> NETHER_BRICK_TABLE = register("nether_brick_table",
            () -> new ConnectedTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
    public static final DeferredBlock<Block> PRISMARINE_TABLE = register("prismarine_table",
            () -> new ConnectedTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
    public static final DeferredBlock<Block> PURPUR_TABLE = register("purpur_table",
            () -> new ConnectedTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
    public static final DeferredBlock<Block> QUARTZ_TABLE = register("quartz_table",
            () -> new ConnectedTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> DUCK_STATUE = register("duck_statue",
            () -> new Podium(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE)));
    // Bathroom/Restroom Stuff
    public static final DeferredBlock<Block> TOILET = register("toilet",
            () -> new Toilet(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> SMALL_SINK = register("small_sink",
            () -> new SmallSink(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> FANCY_SINK = register("fancy_sink",
            () -> new FancySink(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)));
    public static final DeferredBlock<Block> SHOWER_HANDLES = register("shower_handles",
            () -> new ShowerHandles(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> SHOWER_HEAD = register("shower_head",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).noCollission()));
    public static final DeferredBlock<Block> TOILET_PAPER = register("toilet_paper",
            () -> new HazardSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));

    // Misc
    public static final DeferredBlock<Block> DOG_HOUSE = register("dog_house",
            () -> new DogHouse(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LOVE_SEAT = register("love_seat",
            () -> new LoveSeat(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LOVE_COUCH = register("love_couch",
            () -> new LoveCouch(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BLUEMAN_STATUE = register("blueman_statue",
            () -> new BluemanStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> MRPUPPY = register("mrpuppy",
            () -> new MrPuppy(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> HOME_BREAKER = register("home_breaker",
            () -> new HomeBreaker(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.METAL)));
    public static final DeferredBlock<Block> PRINTER = register("printer",
            () -> new Printer(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> PROJECTOR = register("projector",
            () -> new Projector(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> MINI_FRIDGE = register("mini_fridge",
            () -> new ToggledStateBlock(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> CRIB = register("crib",
            () -> new Crib(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> THERMOMETER = register("thermometer",
            () -> new Thermometer(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> CHEMICAL_TUBE = register("chemical_tube",
            () -> new ChemicalTube(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(0.5F,1F).sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> WATER_FOUNTAIN = register("water_fountain",
            () -> new WaterFountain(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.METAL)));
    public static final DeferredBlock<Block> TOASTER_OVEN = register("toaster_oven",
            () -> new ToasterOven(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> DISHWASHER_WALL = register("dishwasher_wall",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1F,10F)));
    public static final DeferredBlock<Block> OFFICE_PHONE = register("office_phone",
            () -> new OfficePhone(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1F,2F)));
    public static final DeferredBlock<Block> PORTABLE_DISH_WASHER = register("portable_dish_washer",
            () -> new PortableDishwasher(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(0.95F,5F)));
    public static final DeferredBlock<Block> STANDING_VACUUM = register("vacuum_standing",
            () -> new StandingVacuum(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(0.5F,1F)));
    public static final DeferredBlock<Block> SHOP_VACUUM = register("shop_vac",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1F,1F)));
    public static final DeferredBlock<Block> BLENDER = register("blender",
            () -> new Blender(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1F,1F)));
    public static final DeferredBlock<Block> FOOD_PROCESSOR = register("food_processor",
            () -> new Blender(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1F,1F)));
    public static final DeferredBlock<Block> INSTANT_POT = register("instant_pot",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1.1F,2.5F)));
    public static final DeferredBlock<Block> RICE_COOKER = register("rice_cooker",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1.05F,1.5F)));
    public static final DeferredBlock<Block> SLOW_COOKER = register("slow_cooker",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1F,1.25F)));
    public static final DeferredBlock<Block> STAND_MIXER = register("stand_mixer",
            () -> new StandMixer(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> JUICER = register("juicer",
            () -> new StandMixer(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> WAFFLE_IRON = register("waffle_iron",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1F,1F).noCollission()));
    public static final DeferredBlock<Block> BREAD_MACHINE = register("bread_machine",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1F,1F)));
    public static final DeferredBlock<Block> ICE_CREAM_MAKER = register("ice_cream_maker",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1F,1F)));
    public static final DeferredBlock<Block> YOGURT_MAKER = register("yogurt_maker",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1F,1F)));
    public static final DeferredBlock<Block> COFFEE_GRINDER = register("coffee_grinder",
            () -> new Blender(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1F,1F)));
    public static final DeferredBlock<Block> PANINI_MAKER = register("panini_maker",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1F,1F)));
    public static final DeferredBlock<Block> FOOD_DEHYDRATOR = register("food_dehydrator",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1F,1F)));
    public static final DeferredBlock<Block> KITCHEN_SINK = register("kitchen_sink",
            () -> new KitchenSink(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> GARDEN_GNOME = register("garden_gnome",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.25F)));
    public static final DeferredBlock<Block> WATER_SOFTENER = register("water_softener",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1F,2F)));
    public static final DeferredBlock<Block> SALT_TANK = register("salt_tank",
            () -> new SaltTank(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1F,2F)));
    public static final DeferredBlock<Block> SEWING_MACHINE = register("sewing_machine",
            () -> new StandMixer(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> AUDIO_CONTROLLER = register("audio_controller",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(1F,2.25F)));
    public static final DeferredBlock<Block> GENERATOR = register("generator",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1.1F,5.25F)));
    public static final DeferredBlock<Block> IRONING_TABLE = register("ironing_table",
            () -> new OperationTable(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1F)));
    public static final DeferredBlock<Block> STEAM_CLEANER = register("steam_cleaner",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1F)));
    public static final DeferredBlock<Block> HUMIDIFIER = register("humidifier",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.DEEPSLATE_TILES).strength(1F)));
    public static final DeferredBlock<Block> DEHUMIDIFIER = register("dehumidifier",
            () -> new Dehumidifier(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> AIR_PURIFIER = register("air_purifier",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.DEEPSLATE_TILES).strength(1F)));
    public static final DeferredBlock<Block> SPACE_HEATER = register("space_heater",
            () -> new SpaceHeater(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE_TILES).strength(1F).lightLevel(s -> 7)));
    public static final DeferredBlock<Block> CEILING_FAN = register("ceiling_fan",
            () -> new CeilingFan(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.DEEPSLATE).strength(1F,2F)));
    public static final DeferredBlock<Block> SMOKER_GRILL = register("smoker_grill",
            () -> new SmokerGrill(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.DEEPSLATE_BRICKS).strength(1.25F,2F).lightLevel(enabledLitBlockEmission(10))));
    public static final DeferredBlock<Block> COTTON_CANDY_MAKER = register("cotton_candy_maker",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1F)));
    public static final DeferredBlock<Block> CARNIVAL_AWNING = register("carnival_awning",
            () -> new CarnivalAwning(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> PORTA_POTTY = register("porta_potty",
            () -> new PortaPotty(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> WARDEN_TROPHY = register("warden_trophy",
            () -> new WardenTrophy(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // Finale Update #1 Thingamajigs Features
    public static final DeferredBlock<Block> FOOSBALL_TABLE = register("foosball_table",
            () -> new AirConditioner(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> CLAW_MACHINE = register("claw_machine",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> GUMBALL_MACHINE = register("gumball_machine",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> HAMMER_MACHINE = register("hammer_machine",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> WACK_MACHINE = register("wack_machine",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> AIR_HOCKEY_TABLE = register("air_hockey_table",
            () -> new AirConditioner(BlockBehaviour.Properties.of().sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> BUTTER_CHURNER = register("butter_churner",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> FIRE_ESCAPE_LADDER = register("fire_escape_ladder",
            () -> new FireEscapeLadder(BlockBehaviour.Properties.of().noOcclusion()));
    public static final DeferredBlock<Block> CATWALK_CENTER = register("catwalk_center",
            () -> new CatWalkCenter(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> CATWALK = register("catwalk",
            () -> new CatWalk(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> MYSTERIOUS_ONE_COUCH = register("mysterious_couch",
            () -> new LoveCouch(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> GENERAL_DIGITAL_PHONE = register("general_digital_phone",
            () -> new OfficePhone(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
    public static final DeferredBlock<Block> ZOMBIE_PLUSHIE = register("zombie_plushie",
            () -> new ReindeerPlush(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK).sound(SoundType.WOOL)){
                public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
                    Direction direction = pState.getValue(FACING);
                    switch(direction){
                        case NORTH: return NS_ALT;
                        case SOUTH: return SS_ALT;
                        case EAST: return ES_ALT;
                        case WEST: return WS_ALT;
                        default: return Shapes.block();
                    }
                }
            });
    public static final DeferredBlock<Block> STEVE_PLUSHY = register("steve_plushy",
            () -> new ReindeerPlush(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK).sound(SoundType.WOOL)){
                public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
                    Direction direction = pState.getValue(FACING);
                    switch(direction){
                        case NORTH: return NS_ALT;
                        case SOUTH: return SS_ALT;
                        case EAST: return ES_ALT;
                        case WEST: return WS_ALT;
                        default: return Shapes.block();
                    }
                }
            });
    public static final DeferredBlock<Block> VHS_COLLECTION = register("vhs_collection",
            () -> new VHSCollection(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .strength(1F,5F)));


    public static final DeferredBlock<Block> DVD_COLLECTION = register("dvd_collection",
            () -> new VHSCollection(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(1F,5F)));
    public static final DeferredBlock<Block> SHOPPING_BASKET = register("shopping_basket",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1F)));
    public static final DeferredBlock<Block> SHOPPING_BASKET_PILE = register("shopping_basket_pile",
            () -> new DoubleTallDecorationBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.25F)));
    public static final DeferredBlock<Block> BLUEYSNAP_CONSOLE = register("blueysnap_console",
            () -> new BlueySnapBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1F)));
    public static final DeferredBlock<Block> BLUEYSNAP_BASE = register("blueysnap_base",
            () -> new BlueySnapBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1F)));
    public static final DeferredBlock<Block> BEAKER = register("beaker",
            () -> new SmallGlassStorageThing(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> FLASK = register("flask",
            () -> new SmallGlassStorageThing(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> MICROSCOPE = register("microscope",
            () -> new StandMixer(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1F)));
    public static final DeferredBlock<Block> OLD_WOODEN_PHONE = register("old_wooden_phone",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(1F,5F)));
    public static final DeferredBlock<Block> BATHTUB_NOZZLE = register("bathtub_nozzle",
            () -> new BathTubNozzle(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> GARDEN_HOSE = register("garden_hose",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.CALCITE).noCollission()));
    public static final DeferredBlock<Block> WOOD_DUCK = register("wood_duck",
            () -> new ReindeerPlush(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noCollission()){
                public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
                    Direction direction = pState.getValue(FACING);
                    switch(direction){
                        case NORTH: return NS_ALT;
                        case SOUTH: return SS_ALT;
                        case EAST: return ES_ALT;
                        case WEST: return WS_ALT;
                        default: return Shapes.block();
                    }
                }
            });
    public static final DeferredBlock<Block> WOOD_CAR = register("wood_car",
            () -> new ReindeerPlush(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noCollission()){
                public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
                    Direction direction = pState.getValue(FACING);
                    switch(direction){
                        case NORTH: return NS_ALT;
                        case SOUTH: return SS_ALT;
                        case EAST: return ES_ALT;
                        case WEST: return WS_ALT;
                        default: return Shapes.block();
                    }
                }
            });
    public static final DeferredBlock<Block> PHONE_SWITCHER = register("phone_switcher",
            () -> new PhoneSwitcher(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> HOTDOG_ROTATOR = register("hotdog_rotator",
            () -> new HotdogRotator(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> LAWN_MOWER = register("lawn_mower",
            () -> new Wheelbarrow(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> DIVING_BOARD = register("diving_board",
            () -> new DivingBoard(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> WATER_SLIDE = register("water_slide",
            () -> new WaterSlide(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> SLUSHY_MACHINE = register("slushy_machine",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1F,2F)));
    public static final DeferredBlock<Block> TOY_BOX = register("toy_box",
            () -> new AirConditioner(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> BABY_CARRIAGE = register("baby_carriage",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.CALCITE)));
    public static final DeferredBlock<Block> CONVENIENCE_SHELF = register("convenience_shelf",
            () -> new ThingamajigsDecorativeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.DEEPSLATE_BRICKS)));
    public static final DeferredBlock<Block> CREEPER_PLUSHY = register("creeper_plushy",
            () -> new ReindeerPlush(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).sound(SoundType.WOOL).noCollission()){
                public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
                    Direction direction = pState.getValue(FACING);
                    switch(direction){
                        case NORTH: return NS_ALT;
                        case SOUTH: return SS_ALT;
                        case EAST: return ES_ALT;
                        case WEST: return WS_ALT;
                        default: return Shapes.block();
                    }
                }
            });
    public static final DeferredBlock<Block> FEATURED_CORDLESS_PHONE = register("featured_cordless_phone",
            () -> new CordlessPhoneBase(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.LANTERN)));
    public static final DeferredBlock<Block> SMARTPHONE = register("smartphone",
            () -> new MobilePhone(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.CALCITE)));
    public static final DeferredBlock<Block> POOPSHELF = register("poopshelf",
            () -> new PoopBookshelf(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> FULL_POOP_BLOCK = register("full_poop_block",
            () -> new FullPoopBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK)));
    public static final DeferredBlock<Block> FIRE_DETECTOR = register("fire_detector",
            () -> new FireDetector(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> FIRE_EXTINGUISHER = register("fire_extinguisher",
            () -> new FireExtinguisher(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> HISTORIAN_BOOKSHELF = register("historian_bookshelf",
            () -> new CustomBookshelf(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> CHECKBOARD_WOOL = register("checkerboard_wool",
            () -> new CheckerboardWool(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final DeferredBlock<Block> STONE_PILLAR = register("stone_pillar",
            () -> new ConnectingVerticalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> STONE_BRICK_PILLAR = register("stone_brick_pillar",
            () -> new ConnectingVerticalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> CHISELED_STONE_BRICK_PILLAR = register("chiseled_stone_brick_pillar",
            () -> new ConnectingVerticalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> CRYSTALINE_STONE = register("crystaline_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> INDENTED_STONE = register("indented_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> PANEL_STONE = register("panel_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));
    //
    public static final DeferredBlock<Block> PANEL_STONE_BRICKS = register("panel_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> MOSSY_PANEL_STONE_BRICKS = register("mossy_panel_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> CRACKED_PANEL_STONE_BRICKS = register("cracked_panel_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> CHISELED_PANEL_STONE_BRICKS = register("chiseled_panel_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));

    public static final DeferredBlock<Block> STOP_GATE = register("stop_gate",
            () -> new StopGate(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ARROW_BOARD = register("arrow_board",
            () -> new ArrowBoard(BlockBehaviour.Properties.of().lightLevel(modeLitBlockEmission(5))));

    // HAWK Signal stuff
    public static final DeferredBlock<Block> HAWK_SIGNAL = register("hawk_signal",
            () -> new HawkSignal(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> HAWK_SIGNAL_YELLOW = registerBlockWithoutItem("hawk_signal_y",
            () -> new HawkYellow(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> HAWK_SIGNAL_FLASHING_YELLOW = registerBlockWithoutItem("hawk_signal_fy",
            () -> new HawkFlashingYellow(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> HAWK_SIGNAL_RED = registerBlockWithoutItem("hawk_signal_r",
            () -> new HawkRed(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> HAWK_SIGNAL_FLASHING_RED = registerBlockWithoutItem("hawk_signal_fr",
            () -> new HawkFlashingRed(BlockBehaviour.Properties.of()));

    // Traffic Beacons
    public static final DeferredBlock<Block> YELLOW_BEACON = register("yellow_beacon",
            () -> new TrafficBeacon(BlockBehaviour.Properties.of().lightLevel(s -> 10)));
    public static final DeferredBlock<Block> RED_BEACON = register("red_beacon",
            () -> new TrafficBeacon(BlockBehaviour.Properties.of().lightLevel(s -> 10)));
    public static final DeferredBlock<Block> ARROW_BEACON = register("arrow_beacon",
            () -> new ArrowBeacon(BlockBehaviour.Properties.of().lightLevel(s -> 10)));

    // horizontal traffic signals
    // main signal (green to red & red to green)
    public static final DeferredBlock<Block> HORIZONTAL_TRAFFIC_SIGNAL_1 = register("horizontal_traffic_signal",
            () -> new HorizontalTrafficSignal(BlockBehaviour.Properties.of().lightLevel(s -> 10)));
    // flashing red variant
    public static final DeferredBlock<Block> HORIZONTAL_TRAFFIC_SIGNAL_2 = register("horizontal_traffic_signal_fr",
            () -> new HorizontalTrafficSignal(BlockBehaviour.Properties.of().lightLevel(s -> 10)));
    // flashing yellow variant
    public static final DeferredBlock<Block> HORIZONTAL_TRAFFIC_SIGNAL_3 = register("horizontal_traffic_signal_fy",
            () -> new HorizontalTrafficSignal(BlockBehaviour.Properties.of().lightLevel(s -> 10)));

    public static final DeferredBlock<Block> FIREOUS_GLAZED_TERRACOTTA = register("fireous_glazed_terracotta",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_GLAZED_TERRACOTTA)));
    public static final DeferredBlock<Block> DARK_FIREOUS_GLAZED_TERRACOTTA = register("dark_fireous_glazed_terracotta",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_GLAZED_TERRACOTTA)));
    public static final DeferredBlock<Block> SCREEN = register("screen",
            () -> new ScreenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .sound(SoundType.SCAFFOLDING).strength(1.1F)));
    // Flowers and Pots
    public static final DeferredBlock<Block> BULBY_FLOWER = register("bulby_flower",
            () -> new FlowerBlock(MobEffects.INVISIBILITY, 5,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)
                            .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<Block> DROOPY_FLOWER = register("droopy_flower",
            () -> new DroopyFlower(MobEffects.CONFUSION,BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ORCHID)
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));

    public static final DeferredBlock<Block> POTTED_BULBY_FLOWER = registerBlockWithoutItem("potted_bulby_flower",
            () -> new FlowerPotBlock(()->(FlowerPotBlock)Blocks.FLOWER_POT,TBlocks.BULBY_FLOWER,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY).instabreak().noOcclusion()));
    public static final DeferredBlock<Block> POTTED_DROOPY_FLOWER = registerBlockWithoutItem("potted_droopy_flower",
            () -> new FlowerPotBlock(()->(FlowerPotBlock)Blocks.FLOWER_POT,TBlocks.DROOPY_FLOWER,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BLUE_ORCHID).instabreak().noOcclusion()));

    public static final DeferredBlock<Block> LIBRARY_STOOL = register("library_stool",
            () -> new LibraryStool(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> BIOHAZARD_BIN = register("biohazard_bin",
            () -> new BiohazardBin(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> RADIOACTIVE_BARREL = register("radioactive_barrel",
            () -> new RadioactiveBarrel(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> TEACHING_BOARD = register("teaching_board",
            () -> new TeachingBoard(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> LOCKER = register("locker",
            () -> new Locker(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> SCHOOL_DESK = register("school_desk",
            () -> new SchoolDesk(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> TALL_LAMP = register("tall_lamp",
            () -> new TallLamp(BlockBehaviour.Properties.of().lightLevel(onLitBlockEmission(10))));
    public static final DeferredBlock<Block> PUNCHING_BAG = register("punching_bag",
            () -> new PunchingBag(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> CLASSIC_TV = register("classic_tv",
            () -> new ClassicTV(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));


    // experimental
    public static final DeferredBlock<Block> DJ_LASER_LIGHT = register("dj_laser_light",
            () -> new DJLaserLight(BlockBehaviour.Properties.of()));

    public static final DeferredBlock<Block> LOCKABLE_DOOR = register("lockable_door",
            () -> new LockableDoor(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR)));


    private static DeferredBlock<Block> register(String name, Supplier<Block> block) {
        DeferredBlock<Block> blk = BLOCKS.register(name,block);
        DeferredItem<Item> itm = TItems.ITEMS.register(name,() -> new BlockItem(blk.get(),new Item.Properties()));
        return blk;
    }

    private static DeferredBlock<Block> registerBlockWithoutItem(String name, Supplier<Block> block){
        return BLOCKS.register(name,block);
    }

    private static boolean always(BlockState bs, BlockGetter bg, BlockPos bp){return true;}
    private static boolean never(BlockState bs, BlockGetter bg, BlockPos bp){return false;}

    private static ToIntFunction<BlockState> customLitBlockEmission(int lv) {
        return (properties) -> {
            return properties.getValue(BlockStateProperties.LIT) ? lv : 0;
        };
    }

    private static ToIntFunction<BlockState> openSignLitEmission(int lv) {
        return (properties) -> {
            return properties.getValue(OpenSign.TOGGLED) ? 0 : lv;
        };
    }

    private static ToIntFunction<BlockState> modeLitBlockEmission(int i) {
        return (properties) -> {
            return properties.getValue(ArrowBoard.MODE);
        };
    }

    /*
    private static ToIntFunction<BlockState> tricandleblkem(int lv) {
        return (properties) -> {
            return properties.getValue(TriCandleHolder.LIT) ? lv : 0;
        };
    }

     */

    private static ToIntFunction<BlockState> enabledLitBlockEmission(int i) {
        return (properties) -> {
            return properties.getValue(BlockStateProperties.ENABLED) ? i : 0;
        };
    }

    private static ToIntFunction<BlockState> onLitBlockEmission(int i) {
        return (properties) -> {
            return properties.getValue(TallLamp.ON) ? i : 0;
        };
    }

    /*
    private static ToIntFunction<BlockState> rrCrossingLightsEmission(int i) {
        return (properties) -> {
            return properties.getValue(RailroadCrossingLights.POWERED) ? i : 0;
        };
    }

    private static ToIntFunction<BlockState> rrCrossingCantileverLightEmission(int i) {
        return (properties) -> {
            return properties.getValue(RailroadCrossingCantilever.POWERED) ? i : 0;
        };
    }

     */
}

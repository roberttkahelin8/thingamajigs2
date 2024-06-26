package net.rk.thingamajigs.block.custom;

import com.mojang.serialization.MapCodec;
import io.netty.buffer.Unpooled;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.rk.thingamajigs.block.TBlockStateProperty;
import net.rk.thingamajigs.blockentity.TBlockEntity;
import net.rk.thingamajigs.blockentity.custom.DJLaserLightBE;
import net.rk.thingamajigs.menu.DJLaserLightMenu;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.logging.Logger;

public class DJLaserLight extends BaseEntityBlock{
    public static final MapCodec<DJLaserLight> DJ_LASER_LIGHT_CODEC = simpleCodec(DJLaserLight::new);

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty ON = TBlockStateProperty.ON;

    public DJLaserLight(Properties p) {
        super(p.strength(1f,5f).sound(SoundType.LANTERN).noOcclusion());
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
                .setValue(ON,true));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return DJ_LASER_LIGHT_CODEC;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new DJLaserLightBE(pPos,pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level lvl, BlockState bs, BlockEntityType<T> bet) {
        return createTickerHelper(bet, TBlockEntity.DJ_LASER_LIGHT_BE.get(),
                lvl.isClientSide ? DJLaserLightBE::clientTick : DJLaserLightBE::serverTick);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState bs, Level lvl, BlockPos bp, Player p, BlockHitResult bhr) {
        try{
            if(p instanceof ServerPlayer){
                p.openMenu(new MenuProvider(){
                    @Override
                    public Component getDisplayName() {
                        return Component.translatable("container.thingamajigs.laser_light.title")
                                .withStyle(ChatFormatting.WHITE);
                    }
                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                        return new DJLaserLightMenu(id, inventory,
                                new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(bp));
                    }
                },bp);
                return InteractionResult.sidedSuccess(lvl.isClientSide);
            }
        }
        catch (Exception e){
            Logger.getAnonymousLogger().warning("Thingamajigs DJ Laser Light Block ERR! Exception is: " + e.getMessage());
            return InteractionResult.FAIL;
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidstate) {
        return state.getValue(WATERLOGGED);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING,WATERLOGGED,ON);
    }

    @Override
    public FluidState getFluidState(BlockState bs) {
        return bs.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(bs);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER)
                .setValue(ON,true);
    }

    @Override
    public void appendHoverText(ItemStack p_49816_, Item.TooltipContext itc, List<Component> lc, TooltipFlag p_49819_) {
        lc.add(Component.translatable("block.thingamajigs.laser_light.desc").withStyle(ChatFormatting.RED));
    }
}

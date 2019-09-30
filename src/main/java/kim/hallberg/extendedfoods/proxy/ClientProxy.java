package kim.hallberg.extendedfoods.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {
    protected static Minecraft MINECRAFT = Minecraft.getInstance();

    @Override
    public void init() {
        /*
        BlockColors blockcolors = MINECRAFT.getBlockColors();
        ItemColors itemcolors = MINECRAFT.getItemColors();

        blockcolors.register((state, world, pos, tintindex) ->
                        world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.get(0.5D, 1.0D),
                [BLOCKS]);

        itemcolors.register((stack, tintindex) -> {
                    BlockState blockState = ((BlockItem)stack.getItem()).getBlock().getDefaultState();
                    return blockcolors.getColor(blockState, null, null, 1); },
                [ITEMS]);
         */
    }

    @Override
    public World getClientWorld() {
        return MINECRAFT.world;
    }

    @Override
    public PlayerEntity getClientPlayer() { return MINECRAFT.player; }
}

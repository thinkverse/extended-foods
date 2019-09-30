package kim.hallberg.extendedfoods.block;

import kim.hallberg.extendedfoods.ExtendedFoods;
import net.minecraft.block.Block;
import net.minecraftforge.registries.ObjectHolder;

import static kim.hallberg.extendedfoods.util.Injection.Null;

@ObjectHolder(ExtendedFoods.MODID)
public class BlockHolder {
    @ObjectHolder("carrot_cake")
    public static final Block CARROT_CAKE = Null();
    @ObjectHolder("chocolate_cake")
    public static final Block CHOCOLATE_CAKE = Null();
}

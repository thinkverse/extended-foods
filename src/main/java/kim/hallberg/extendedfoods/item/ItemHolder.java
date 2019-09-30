package kim.hallberg.extendedfoods.item;

import kim.hallberg.extendedfoods.ExtendedFoods;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

import static kim.hallberg.extendedfoods.util.Injection.Null;

@ObjectHolder(ExtendedFoods.MODID)
public class ItemHolder {
    @ObjectHolder("minecraft:cookie")
    public static final Item COOKIE = Null();

    @ObjectHolder("apple_pie")
    public static final Item APPLE_PIE = Null();

    @ObjectHolder("golden_cookie")
    public static final Item GOLDEN_COOKIE = Null();
    @ObjectHolder("enchanted_golden_cookie")
    public static final Item ENCHANTED_GOLDEN_COOKIE = Null();
}

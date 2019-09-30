package kim.hallberg.extendedfoods.item;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Foods {
    public static final Food APPLE_PIE = (new Food.Builder()).hunger(8).saturation(0.3F).build();
    public static final Food COOKIE = (new Food.Builder()).hunger(2).saturation(0.1F).effect(new EffectInstance(Effects.NAUSEA, 300, 0), 0.1F).build();
    public static final Food ENCHANTED_GOLDEN_COOKIE = (new Food.Builder()).hunger(5).saturation(1.2F).effect(new EffectInstance(Effects.HASTE, 800, 1), 1.0F).effect(new EffectInstance(Effects.SPEED, 900, 1), 1.0F).effect(new EffectInstance(Effects.ABSORPTION, 2400, 3), 1.0F).effect(new EffectInstance(Effects.NAUSEA, 1200, 0), 0.1F).setAlwaysEdible().build();
    public static final Food GOLDEN_COOKIE = (new Food.Builder()).hunger(5).saturation(1.2F).effect(new EffectInstance(Effects.HASTE, 500, 0), 1.0F).effect(new EffectInstance(Effects.SPEED, 600, 0), 1.0F).effect(new EffectInstance(Effects.ABSORPTION, 2400, 0), 1.0F).effect(new EffectInstance(Effects.NAUSEA, 600, 0), 0.2F).setAlwaysEdible().build();
}

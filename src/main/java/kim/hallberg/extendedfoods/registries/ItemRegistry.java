package kim.hallberg.extendedfoods.registries;

import com.google.common.base.Preconditions;
import kim.hallberg.extendedfoods.ExtendedFoods;
import kim.hallberg.extendedfoods.item.Foods;
import net.minecraft.item.EnchantedGoldenAppleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(ExtendedFoods.MODID)
public class ItemRegistry {
    @Mod.EventBusSubscriber(modid = ExtendedFoods.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register {

        @SubscribeEvent
        public static void RegisterItems(final RegistryEvent.Register<Item> event) {
            final Item[] items = {
                new Item((new Item.Properties()).group(ItemGroup.FOOD).maxStackSize(64).food(Foods.COOKIE).rarity(Rarity.COMMON)).setRegistryName("minecraft:cookie"),
                new Item(new Item.Properties().group(ExtendedFoods.GROUP).maxStackSize(64).food(Foods.APPLE_PIE).rarity(Rarity.COMMON)).setRegistryName(ExtendedFoods.location("apple_pie")),
                new Item((new Item.Properties()).group(ExtendedFoods.GROUP).maxStackSize(64).food(Foods.GOLDEN_COOKIE).rarity(Rarity.RARE)).setRegistryName(ExtendedFoods.location("golden_cookie")),
                new EnchantedGoldenAppleItem((new Item.Properties()).group(ExtendedFoods.GROUP).maxStackSize(64).food(Foods.ENCHANTED_GOLDEN_COOKIE).rarity(Rarity.EPIC)).setRegistryName(ExtendedFoods.location("enchanted_golden_cookie"))
            };

            for (final Item item: items) {
                Preconditions.checkNotNull(item.getRegistryName(), "Block: %s has a NULL registry name", item);
                event.getRegistry().register(item);
            }
        }

    }
}

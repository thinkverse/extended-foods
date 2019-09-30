package kim.hallberg.extendedfoods.registries;

import com.google.common.base.Preconditions;
import kim.hallberg.extendedfoods.ExtendedFoods;
import kim.hallberg.extendedfoods.block.BlockHolder;
import kim.hallberg.extendedfoods.block.ModCake;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class BlockRegistry {
    @Mod.EventBusSubscriber(modid = ExtendedFoods.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register {

        @SubscribeEvent
        public static void RegisterBlocks(final RegistryEvent.Register<Block> event) {
            final Block[] blocks = {
                new ModCake(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)).setRegistryName(ExtendedFoods.location("carrot_cake")),
                new ModCake(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)).setRegistryName(ExtendedFoods.location("chocolate_cake"))
            };

            for (final Block block: blocks) {
                Preconditions.checkNotNull(block.getRegistryName(), "Block: %s has a NULL registry name", block);

                event.getRegistry().register(block);
            }
        }

        @SubscribeEvent
        public static void RegisterItemBlocks(final RegistryEvent.Register<Item> event) {
            final BlockItem[] items = {
                new BlockItem(BlockHolder.CARROT_CAKE, new Item.Properties().group(ExtendedFoods.GROUP).maxStackSize(64)),
                new BlockItem(BlockHolder.CHOCOLATE_CAKE, new Item.Properties().group(ExtendedFoods.GROUP).maxStackSize(64))
            };

            for (final BlockItem item: items) {
                final Block block = item.getBlock();
                final ResourceLocation registryname = Preconditions.checkNotNull(block.getRegistryName(), "BlockItem: %s has a NULL registry name", block);

                event.getRegistry().register(item.setRegistryName(registryname));
            }
        }
    }
}

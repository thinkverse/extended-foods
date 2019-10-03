package kim.hallberg.extendedfoods;

import kim.hallberg.extendedfoods.events.LootTableEvent;
import kim.hallberg.extendedfoods.item.ItemHolder;
import kim.hallberg.extendedfoods.proxy.ClientProxy;
import kim.hallberg.extendedfoods.proxy.IProxy;
import kim.hallberg.extendedfoods.proxy.ServerProxy;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

@Mod(ExtendedFoods.MODID)
public class ExtendedFoods {
    public static final String MODID = "extendedfoods";
    public static final String VERSION = "0.0.2-beta";

    public static IProxy PROXY = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static final Logger LOGGER = LogManager.getLogger(ExtendedFoods.MODID);

    public ExtendedFoods() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::OnLoadComplete);
        MinecraftForge.EVENT_BUS.register(new LootTableEvent());
    }

    private void OnLoadComplete(final FMLLoadCompleteEvent event) {
        PROXY.init();
    }

    public static String getVersion(boolean correctInDev) {
        Optional<? extends ModContainer> o = ModList.get().getModContainerById(ExtendedFoods.MODID);
        if (o.isPresent()) {
            String str = o.get().getModInfo().getVersion().toString();
            if (correctInDev && "NONE".equals(str))
                return ExtendedFoods.VERSION;
            return str;
        }
        return "0.0.0";
    }

    public static boolean isDevBuild() {
        return "NONE".equals(getVersion(false));
    }

    public static ResourceLocation location(String name) {
        return new ResourceLocation(ExtendedFoods.MODID, name);
    }

    public static final ItemGroup GROUP = new ItemGroup(ExtendedFoods.MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemHolder.GOLDEN_COOKIE);
        }
    };
}

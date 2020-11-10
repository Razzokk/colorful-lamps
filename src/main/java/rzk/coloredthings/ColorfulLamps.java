package rzk.coloredthings;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rzk.coloredthings.proxy.ClientProxy;
import rzk.coloredthings.proxy.IProxy;
import rzk.coloredthings.proxy.ServerProxy;
import rzk.coloredthings.registry.ModBlocks;
import rzk.coloredthings.registry.ModItems;

@Mod(ColorfulLamps.MOD_ID)
public class ColorfulLamps
{
	public static final String MOD_ID = "colorfullamps";
	public static final Logger LOGGER = LogManager.getLogger();

	public static IProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

	public ColorfulLamps()
	{
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModBlocks.BLOCKS.register(eventBus);
		ModItems.ITEMS.register(eventBus);
	}
}

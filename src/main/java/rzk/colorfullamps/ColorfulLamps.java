package rzk.colorfullamps;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import rzk.colorfullamps.registry.ModBlocks;
import rzk.colorfullamps.registry.ModItems;
import rzk.colorfullamps.registry.ModRecipes;

@Mod(modid = ColorfulLamps.MOD_ID, name = ColorfulLamps.MOD_NAME, version = ColorfulLamps.MOD_VERSION)
public class ColorfulLamps
{
    public static final String MOD_ID = "colorfullamps";
    public static final String MOD_NAME = "ColorfulLamps";
    public static final String MOD_VERSION = "0.0.1";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(ModBlocks.class);
        MinecraftForge.EVENT_BUS.register(ModItems.class);
        MinecraftForge.EVENT_BUS.register(ModRecipes.class);
    }
}

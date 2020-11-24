package rzk.colorfullamps;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rzk.colorfullamps.proxy.IProxy;
import rzk.colorfullamps.registry.ModBlocks;
import rzk.colorfullamps.registry.ModItems;
import rzk.colorfullamps.registry.ModRecipes;

@Mod(modid = ColorfulLamps.MOD_ID, name = ColorfulLamps.MOD_NAME, version = ColorfulLamps.MOD_VERSION)
public class ColorfulLamps
{
    public static final String MOD_ID = "colorfullamps";
    public static final String MOD_NAME = "ColorfulLamps";
    public static final String MOD_VERSION = "1.0.2";

    @SidedProxy(modId = MOD_ID, clientSide = "rzk.colorfullamps.proxy.ClientProxy", serverSide = "rzk.colorfullamps.proxy.ServerProxy")
    public static IProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(ModBlocks.class);
        MinecraftForge.EVENT_BUS.register(ModItems.class);
        MinecraftForge.EVENT_BUS.register(ModRecipes.class);
        proxy.preInit(event);
    }
}

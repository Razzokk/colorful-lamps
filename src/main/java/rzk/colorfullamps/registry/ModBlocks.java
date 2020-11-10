package rzk.colorfullamps.registry;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import rzk.colorfullamps.ColorfulLamps;
import rzk.colorfullamps.block.BlockColoredRedstoneLamp;

public class ModBlocks
{
	public static final Block LAMP_OFF = registerBlock(new BlockColoredRedstoneLamp(false), "lamp_off");
	public static final Block LAMP_ON = registerBlock(new BlockColoredRedstoneLamp(true), "lamp_on");

	public static Block registerBlock(Block block, String name)
	{
		block.setRegistryName(new ResourceLocation(ColorfulLamps.MOD_ID, name));
		block.setUnlocalizedName(ColorfulLamps.MOD_ID + "." + name);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		IForgeRegistry<Block> registry = event.getRegistry();
		registry.registerAll(LAMP_OFF, LAMP_ON);
	}
}

package rzk.colorfullamps.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import rzk.colorfullamps.item.IItemProvider;

public class ModItems
{
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> registry = event.getRegistry();

		for (Block block : ForgeRegistries.BLOCKS)
			if (block instanceof IItemProvider)
				registry.register(((IItemProvider) block).createItem().setRegistryName(block.getRegistryName()).setUnlocalizedName(block.getUnlocalizedName()));
	}
}

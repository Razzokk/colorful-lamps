package rzk.coloredthings.registry;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rzk.coloredthings.ColorfulLamps;

public class ModItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ColorfulLamps.MOD_ID);

	public static final RegistryObject<Item> TEST_ITEM = registerItem(new Item(new Item.Properties()), "test");

	public static RegistryObject<Item> registerItem(Item item, String name)
	{
		return ITEMS.register(name, () -> item);
	}
}

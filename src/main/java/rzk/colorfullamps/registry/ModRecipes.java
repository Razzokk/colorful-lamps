package rzk.colorfullamps.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rzk.colorfullamps.ColorfulLamps;

public class ModRecipes
{
	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
	{
		for (EnumDyeColor color : EnumDyeColor.values())
		{
			GameRegistry.addShapedRecipe(new ResourceLocation(ColorfulLamps.MOD_ID, "colored_lamp_" + color.getName()),
					new ResourceLocation(ColorfulLamps.MOD_ID, "colored_lamp"),
					new ItemStack(ModBlocks.COLORED_REDSTONE_LAMP_OFF, 8, color.getMetadata()),
					"DDD", "DLD", "DDD", 'D', new ItemStack(Items.DYE, 1, color.getDyeDamage()), 'L', Blocks.REDSTONE_LAMP);
		}
	}
}

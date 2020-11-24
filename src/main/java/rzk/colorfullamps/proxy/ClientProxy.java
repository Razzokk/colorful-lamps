package rzk.colorfullamps.proxy;

import net.minecraft.block.BlockColored;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rzk.colorfullamps.registry.ModBlocks;

public class ClientProxy implements IProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		for (EnumDyeColor color : EnumDyeColor.values())
			registerBlockVariantMeta(ModBlocks.LAMP_OFF.getDefaultState().withProperty(BlockColored.COLOR, color), color.getMetadata());
	}

	private static final StateMapperBase mapper = new StateMapperBase()
	{
		@Override
		protected ModelResourceLocation getModelResourceLocation(IBlockState state)
		{
			return new ModelResourceLocation("minecraft:air");
		}
	};

	public static void registerBlockVariantMeta(IBlockState state, int meta)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(state.getBlock()), meta, new ModelResourceLocation(state.getBlock().getRegistryName(), mapper.getPropertyString(state.getProperties())));
	}
}

package rzk.coloredthings.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rzk.coloredthings.ColorfulLamps;

public class ModBlocks
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ColorfulLamps.MOD_ID);

	public static final RegistryObject<Block> TEST = registerBlock(new Block(AbstractBlock.Properties.create(Material.AIR)), "test");

	public static RegistryObject<Block> registerBlock(Block block, String name)
	{
		return BLOCKS.register(name, () -> block);
	}
}

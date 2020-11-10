package rzk.coloredthings.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import rzk.coloredthings.item.IItemProvider;

public class TestBlock extends Block implements IItemProvider
{
	public TestBlock()
	{
		super(Properties.create(Material.REDSTONE_LIGHT));
	}

	@Override
	public BlockItem createItem()
	{
		return new BlockItem(this, new Item.Properties());
	}
}

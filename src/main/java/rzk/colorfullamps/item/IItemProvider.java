package rzk.colorfullamps.item;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;

public interface IItemProvider
{
	ItemBlock NO_ITEM = new ItemBlock(Blocks.AIR);

	ItemBlock createItem();
}

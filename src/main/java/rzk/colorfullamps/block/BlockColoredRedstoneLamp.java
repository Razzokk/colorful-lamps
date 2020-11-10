package rzk.colorfullamps.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import rzk.colorfullamps.item.IItemProvider;
import rzk.colorfullamps.registry.ModBlocks;

import java.util.Random;

public class BlockColoredRedstoneLamp extends BlockColored implements IItemProvider
{
	public final boolean powered;

	public BlockColoredRedstoneLamp(boolean powered)
	{
		super(Material.REDSTONE_LIGHT);
		setCreativeTab(CreativeTabs.REDSTONE);
		setSoundType(SoundType.GLASS);
		setHardness(0.3F);
		this.powered = powered;
	}

	public void updateLampState(World world, BlockPos pos, IBlockState state)
	{
		if (!world.isRemote)
		{
			if (world.isBlockPowered(pos) && !powered)
				world.setBlockState(pos, ModBlocks.LAMP_ON.getDefaultState().withProperty(COLOR, state.getValue(COLOR)));

			else if (!world.isBlockPowered(pos) && powered)
				world.setBlockState(pos, ModBlocks.LAMP_OFF.getDefaultState().withProperty(COLOR, state.getValue(COLOR)));
		}
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		updateLampState(world, pos, state);
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos)
	{
		updateLampState(world, pos, state);
	}

	@Override
	public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		return powered ? 15 : 0;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(ModBlocks.LAMP_OFF);
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		return new ItemStack(ModBlocks.LAMP_OFF, 1, state.getValue(COLOR).getMetadata());
	}

	@Override
	public ItemBlock createItem()
	{
		if (powered)
			return NO_ITEM;

		String[] colorNames = new String[EnumDyeColor.values().length];

		for (int i = 0; i < EnumDyeColor.values().length; i++)
			colorNames[i] = EnumDyeColor.byMetadata(i).getName();

		return new ItemColored(this, true).setSubtypeNames(colorNames);
	}
}

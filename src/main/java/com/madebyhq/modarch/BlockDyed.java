package com.madebyhq.modarch;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockDyed extends Block {

	
	public static final PropertyEnum PROPERTYCOLOUR = PropertyEnum.create("colour", EnumColour.class);

	
	public BlockDyed(Material materialIn) 
	{
		super(materialIn);
		
        IBlockState blockState = this.blockState.getBaseState();
        blockState = blockState.withProperty(PROPERTYCOLOUR, EnumColour.WHITE);
        setDefaultState(blockState);
		
	}
	
	

	@Override
	public int damageDropped(IBlockState state)
	{
        return ((EnumColour)state.getValue(PROPERTYCOLOUR)).getMetadata();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		EnumColour[] allColours = EnumColour.values();
		for (EnumColour colour : allColours) {
			list.add(new ItemStack(itemIn, 1, colour.getMetadata()));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
        return this.getDefaultState().withProperty(PROPERTYCOLOUR, EnumColour.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
        return ((EnumColour)state.getValue(PROPERTYCOLOUR)).getMetadata();
	}
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] {PROPERTYCOLOUR});
	}
	
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		EnumColour colour = EnumColour.byMetadata(meta);
		return this.getDefaultState().withProperty(PROPERTYCOLOUR, colour);
	}

	
	
	public static enum EnumColour implements IStringSerializable
	{
		WHITE(0, "white"),
		ORANGE(1, "orange"),
		MAGENTA(2, "magenta"),
		LIGHTBLUE(3, "lightblue"),
		YELLOW(4, "yellow"),
		LIME(5, "lime"),
		PINK(6, "pink"),
		GRAY(7, "gray"),
		LIGHTGRAY(8, "lightgray"),
		CYAN(9, "cyan"),
		PURPLE(10, "purple"),
		BLUE(11, "blue"),
		BROWN(12, "brown"),
		GREEN(13, "green"),
		RED(14, "red"),
		BLACK(15, "black");
		

		public int getMetadata()
		{
			return this.meta;
		}

		@Override
		public String toString()
		{
			return this.name;
		}

		public static EnumColour byMetadata(int meta)
		{
			if (meta < 0 || meta >= META_LOOKUP.length)
			{
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		public String getName()
		{
			return this.name;
		}

		private final int meta;
		private final String name;
		private static final EnumColour[] META_LOOKUP = new EnumColour[values().length];

		private EnumColour(int i_meta, String i_name)
		{
			this.meta = i_meta;
			this.name = i_name;
		}

		static
		{
			for (EnumColour colour : values()) {
				META_LOOKUP[colour.getMetadata()] = colour;
			}
		}
	}


}

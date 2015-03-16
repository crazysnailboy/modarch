package com.madebyhq.modarch;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public abstract class ItemDyed extends ItemBlock {
	public ItemDyed(Block block) {
		super(block);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		System.out.println("getUnlocalizedName");
		BlockDyed.EnumColour colour = BlockDyed.EnumColour.byMetadata(stack.getMetadata());
		System.out.println(super.getUnlocalizedName() + "." + colour.toString());
		return super.getUnlocalizedName() + "." + colour.toString();
	}
}

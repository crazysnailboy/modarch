package com.madebyhq.modarch;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public abstract class ItemDyed extends ItemBlock {
	public ItemDyed(int id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damageValue) {
		return damageValue;
	}
	
	@Override
	public String getItemNameIS(ItemStack stack) {
		return getItemName() + "." + BlockDyed.colorNames[stack.getItemDamage()];
	}
}

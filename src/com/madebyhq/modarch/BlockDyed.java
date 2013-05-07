package com.madebyhq.modarch;

import java.util.List;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public abstract class BlockDyed extends Block {
	public static final String[] colorNames = { 
		"white", "orange", "magenta", "light blue",
		"yellow", "light green", "pink", "dark grey",
		"light grey", "cyan", "purple", "blue",
		"brown", "green", "red", "black"
	};
	
	public BlockDyed(int id, int texture, Material material) {
		super(id, texture, material);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
		return metadata + textureOffset();
	}
	
	protected abstract int textureOffset();
	
	@Override
	public String getTextureFile() {
		return CommonProxy.BLOCK_PNG;
	}
	
	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int unknown, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}
	
	public void registerNames() {
		for (int i = 0; i < 16; i++) {
    		ItemStack stack = new ItemStack(this, 1, i);
    		LanguageRegistry.addName(stack, ModArch.capitalize(BlockDyed.colorNames[i]) + " " + nameSuffix());
    	}
	}
	
	public void addColorRecipes() {
		ItemStack thisStack = new ItemStack(this, 1, 0);
		for (int i = 0; i < 16; i++) {
			GameRegistry.addShapelessRecipe(
				// Output
				new ItemStack(this, 8, i),
				// Input
				thisStack, thisStack, thisStack, thisStack,
				thisStack, thisStack, thisStack, thisStack,
				new ItemStack(Item.dyePowder, 1, 15 - i) 
			);
		}
	}
	
	protected abstract String nameSuffix();
}

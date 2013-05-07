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

public class BlockTruss extends Block {	
	public BlockTruss(int id, int texture, Material material) {
		super(id, texture, material);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(1.5F);
		setStepSound(Block.soundMetalFootstep);
		setBlockName("truss");
	}
	
	@Override
	public String getTextureFile() {
		return CommonProxy.BLOCK_PNG;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public void addRecipe() {
		GameRegistry.addRecipe(
			new ItemStack(this, 20),
			"x x",
			" x ",
			"x x",
			'x', new ItemStack(Item.ingotIron)
		);
	}
}

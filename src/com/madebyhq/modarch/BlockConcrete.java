package com.madebyhq.modarch;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
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
import com.madebyhq.modarch.BlockDyed;

public class BlockConcrete extends BlockDyed {	
	public BlockConcrete(int id, int texture, Material material) {
		super(id, texture, material);
		setHardness(1.5F);
		setStepSound(Block.soundStoneFootstep);
		setBlockName("concrete");
	}
	
	protected final int textureOffset() {
		return 16;
	}
	
	protected final String nameSuffix() {
		return "Concrete";
	}
	
	public void addRecipes() {
		GameRegistry.addRecipe(
			new ItemStack(this, 8, 0),
			"xxx",
			"xyx",
			"xxx",
			'x', new ItemStack(Block.cobblestone),
			'y', new ItemStack(Block.sand)
		);
		
		addColorRecipes();
	}
}

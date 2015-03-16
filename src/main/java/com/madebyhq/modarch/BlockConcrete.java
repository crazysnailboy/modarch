package com.madebyhq.modarch;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockConcrete extends BlockDyed {	
	public BlockConcrete(Material material) {
		super(material);
		setHardness(1.5F);
		setStepSound(Block.soundTypeStone);
	}
	
	public void addRecipes() {
		GameRegistry.addRecipe(
			new ItemStack(this, 8, 0),
			"xxx",
			"xyx",
			"xxx",
			'x', new ItemStack(Blocks.cobblestone),
			'y', new ItemStack(Blocks.sand)
		);
		
		addColorRecipes();
	}
	
	protected void addColorRecipes() {
		ItemStack thisStack = new ItemStack(this, 1, 0);
		for (int i = 0; i < 16; i++) {
			GameRegistry.addShapelessRecipe(
				// Output
				new ItemStack(this, 8, i),
				// Input
				thisStack, thisStack, thisStack, thisStack,
				thisStack, thisStack, thisStack, thisStack,
				new ItemStack(Items.dye, 1, 15 - i) 
			);
		}
	}
}





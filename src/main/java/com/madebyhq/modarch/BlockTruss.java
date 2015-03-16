package com.madebyhq.modarch;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTruss extends Block {	
	public BlockTruss(Material material) {
		super(material);
//		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(1.5F);
		setStepSound(Block.soundTypeMetal);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	public void addRecipe() {
		GameRegistry.addRecipe(
			new ItemStack(this, 20),
			"x x",
			" x ",
			"x x",
			'x', new ItemStack(Items.iron_ingot)
		);
	}
	
	
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }
	
}

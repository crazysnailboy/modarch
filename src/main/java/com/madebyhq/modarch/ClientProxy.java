package com.madebyhq.modarch;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders() {
		
		registerInventoryModels(ModArch.drywall, BlockDyed.EnumColour.values());
		registerInventoryModels(ModArch.concrete, BlockDyed.EnumColour.values());
		registerInventoryModel(ModArch.truss);
	}
	
	
	private static void registerInventoryModel(Block block)
	{	
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModArch.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

	public static void registerInventoryModels(Block block, Enum[] variants)
	{
		Item itemVariants = Item.getItemFromBlock(block);
	    for (int i = 0; i < variants.length ; i++) 
	    {
	    	String unLocalizedName = ModArch.MOD_ID + ":" + itemVariants.getUnlocalizedName().substring(5) + "." + variants[i]; 
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemVariants, i, new ModelResourceLocation(unLocalizedName, "inventory"));
        }		
	}
	
	
}

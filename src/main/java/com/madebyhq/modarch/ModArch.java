package com.madebyhq.modarch;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ModArch.MOD_ID, name = ModArch.MOD_NAME, version = ModArch.VERSION)
public class ModArch 
{
	public static final String MOD_ID = "hqmodarch";
	public static final String MOD_NAME = "Modern Architecture";
	public static final String VERSION = "0.0.0";
	
//	@Instance("HQModarch")
//	public static ModArch instance;
	
	public static Block drywall;
	public static Block concrete;
	public static Block truss;
	
	
	
	public static CreativeTabs modArchTab = new CreativeTabs("modArchTab")
	{
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(truss);
		}
	};
	
	
	
	@SidedProxy(clientSide="com.madebyhq.modarch.ClientProxy", serverSide="com.madebyhq.modarch.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		drywall = new BlockDrywall(Material.rock).setUnlocalizedName("drywall").setCreativeTab(modArchTab);
		concrete = new BlockConcrete(Material.rock).setUnlocalizedName("concrete").setCreativeTab(modArchTab);
		truss = new BlockTruss(Material.iron).setUnlocalizedName("truss").setCreativeTab(modArchTab);
    }
    
	@EventHandler
    public void init(FMLInitializationEvent event) {
    	
//    	GameRegistry.registerBlock(drywall, ItemDrywall.class, drywall.getUnlocalizedName().substring(5));
//    	GameRegistry.registerBlock(concrete, ItemConcrete.class, concrete.getUnlocalizedName().substring(5));
//    	GameRegistry.registerBlock(truss, truss.getUnlocalizedName().substring(5));

		registerBlock(drywall, ItemDrywall.class, BlockDyed.EnumColour.values());
		registerBlock(concrete, ItemDrywall.class, BlockDyed.EnumColour.values());
		registerBlock(truss);
		
		
    	((BlockDrywall)drywall).addRecipes();
//    	MinecraftForge.setBlockHarvestLevel(drywall, "pickaxe", 0);
    	((BlockConcrete)concrete).addRecipes();
//    	MinecraftForge.setBlockHarvestLevel(concrete, "pickaxe", 0);
    	((BlockTruss)truss).addRecipe();
//    	MinecraftForge.setBlockHarvestLevel(truss, "pickaxe", 0);
    	
    	proxy.registerRenders();
    }
	
	
	private static void registerBlock(Block block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}

	private static void registerBlock(Block block, Class<? extends ItemBlock> itemclass, Enum[] variants)
	{
		GameRegistry.registerBlock(block, itemclass, block.getUnlocalizedName().substring(5));

		Item itemVariants = Item.getItemFromBlock(block);
	    for (int i = 0; i < variants.length ; i++) 
	    {
	    	String variantName = ModArch.MOD_ID + ":" + block.getUnlocalizedName().substring(5) + "." + variants[i];
	        ModelBakery.addVariantName(itemVariants, variantName);
        }
	}
    
}

package com.madebyhq.modarch;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="HQModarch", name="Modern Architecture", version="0.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ModArch {
	@Instance("HQModarch")
	public static ModArch instance;
	
	public final static BlockDrywall drywall = new BlockDrywall(3457, 0, Material.rock);
	public final static BlockConcrete concrete = new BlockConcrete(3458, 16, Material.rock);
	public final static BlockTruss truss = new BlockTruss(3459, 32, Material.iron);
	
	@SidedProxy(clientSide="com.madebyhq.modarch.ClientProxy", serverSide="com.madebyhq.modarch.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
    public void preInit(FMLPreInitializationEvent event) {
		// This method is called before @Init. This is where reading configuration files goes.
    }
    
    @Init
    public void load(FMLInitializationEvent event) {
    	// This is where the majority of your Mod initialization will go. Block and item registry,
    	// WorldGen registry, and crafting recipes are common things found here.
    	
    	GameRegistry.registerBlock(drywall, ItemDrywall.class);
    	GameRegistry.registerBlock(concrete, ItemConcrete.class);
    	GameRegistry.registerBlock(truss, "truss");
    	
    	// Drywall
    	drywall.registerNames();
    	drywall.addRecipes();
    	MinecraftForge.setBlockHarvestLevel(drywall, "pickaxe", 0);
    	
    	// Concrete
    	concrete.registerNames();
    	concrete.addRecipes();
    	MinecraftForge.setBlockHarvestLevel(concrete, "pickaxe", 0);
    	
    	// Truss
    	LanguageRegistry.addName(truss, "Truss");
    	truss.addRecipe();
    	MinecraftForge.setBlockHarvestLevel(truss, "pickaxe", 0);
    	
    	proxy.registerRenderers();
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
    	// This is where code goes for working with other mods. For example, your initial
    	// configuration of block ids so that you can claim ids no other mod uses.
    }
    
    // Utility functions
    
    // http://stackoverflow.com/questions/1892765/capitalize-first-char-of-each-word-in-a-string-java#answer-11149580
    public static String capitalize(String str) {
      return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}

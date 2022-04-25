package com.example.examplemod.common;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.EntityElizabethTower;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeBeach;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy { 
	  public void preInit(FMLPreInitializationEvent event) {
		  EntityRegistry.registerModEntity(new ResourceLocation("examplemod:EntityElizabethTower"),EntityElizabethTower.class, "EntityElizabethTower", 0, ExampleMod.instance, 128, 3,
	                false);
	  }

	   public void init(FMLInitializationEvent event) {
	      
	   }

	   public void postInit(FMLPostInitializationEvent event) {
	      
	   }
	
}


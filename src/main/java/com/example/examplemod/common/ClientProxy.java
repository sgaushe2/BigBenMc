package com.example.examplemod.common;

import com.example.examplemod.entity.EntityElizabethTower;
import com.example.examplemod.entity.render.RenderElizabethTower;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class ClientProxy extends CommonProxy{
	  public void preInit(FMLPreInitializationEvent event) {
	      super.preInit(event);
	      RenderingRegistry.registerEntityRenderingHandler(EntityElizabethTower.class,new IRenderFactory<EntityElizabethTower>()
	        {
	            @Override
	            public Render<? super EntityElizabethTower> createRenderFor(RenderManager manager)
	            {
	                return new RenderElizabethTower(manager) ;
	            }
	        });
	  }

	   public void init(FMLInitializationEvent event) {
	      super.init(event);
	   }

	   public void postInit(FMLPostInitializationEvent event) {
	      super.postInit(event);
	   }

}

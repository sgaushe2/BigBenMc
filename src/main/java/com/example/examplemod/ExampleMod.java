package com.example.examplemod;

import net.minecraft.command.CommandLocate;
import net.minecraft.command.server.CommandSummon;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.village.Village;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.Logger;
import org.jline.builtins.Commands;

import com.example.examplemod.common.CommonProxy;
import com.example.examplemod.entity.EntityElizabethTower;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
@Mod.EventBusSubscriber(modid= ExampleMod.MODID)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String NAME = "Big Ben Project";
    public static final String VERSION = "1.0";
    private static Logger logger;
    @Mod.Instance(ExampleMod.MODID)
    public static ExampleMod instance;

    @SidedProxy(clientSide = "com.example.examplemod.common.ClientProxy", serverSide = "com.example.examplemod.common.CommonProxy")
    public static CommonProxy proxy;
    
    private static List<Village> villagesWithTower;

    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(this);
    	proxy.preInit(event);
        logger = event.getModLog();
        villagesWithTower = new ArrayList<Village>();
    }
      
    @SubscribeEvent
    public static void worldSpawn(WorldEvent.PotentialSpawns e) {
    	for (Village village : e.getWorld().villageCollection.getVillageList()) {
			if (!doesKeyExist(village)) {
				villagesWithTower.add(village);
				BlockPos centre = village.getCenter();
				Vec2f offset = new Vec2f((float)Math.floor(Math.random() * (20 - (-20) + 1) + (-20)), (float)Math.floor(Math.random() * (20 - (-20) + 1) + (-20)));
				EntityElizabethTower tower = new EntityElizabethTower(e.getWorld());
				tower.setLocationAndAngles(centre.getX() + offset.x, centre.getY(), centre.getZ() + offset.y, 0, 0);
				e.getWorld().spawnEntity(tower);
				logger.info("Spawning at: " + centre.toString());
			}
		}
    }
    
    private static boolean doesKeyExist(Village village) {
    	for (Village v : villagesWithTower) {
			if (village == v) {
				return true;
			}
		}
    	return false;
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    
    public void postinit(FMLPostInitializationEvent event) {
    	proxy.postInit(event);
    }
}

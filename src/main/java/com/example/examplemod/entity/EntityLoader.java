package com.example.examplemod.entity;


import com.example.examplemod.ExampleMod;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityLoader
{
    private static int nextID = 0;

    public EntityLoader()
    {
        registerEntity(EntityElizabethTower.class, "ElizabethTower", 20, 3, true);
    }

    private static void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange,
            int updateFrequency, boolean sendsVelocityUpdates)
    {
        EntityRegistry.registerModEntity(null, entityClass, name, nextID++, ExampleMod.MODID, trackingRange, updateFrequency,
                sendsVelocityUpdates);
    }
}
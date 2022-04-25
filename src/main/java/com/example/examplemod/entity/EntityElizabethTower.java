package com.example.examplemod.entity;

import org.apache.logging.log4j.Logger;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityElizabethTower extends EntityCreature{
    public boolean shouldDropItem = false;
    public boolean preventEntitySpawning=true;
	public static double min;
	public static double hour;
	private double v=0.0003925;
 
    protected static final DataParameter<BlockPos> ORIGIN = EntityDataManager.<BlockPos>createKey(EntityElizabethTower.class, DataSerializers.BLOCK_POS);

	public EntityElizabethTower(World worldIn) {
		super(worldIn);
		hour=worldIn.getCelestialAngle(1.0f);
		min=12*(hour%(3.14/6));
	}
	
	protected void applyEntityAttribute() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(50.0D);
	}
	
	
    @Override
    public void onLivingUpdate()
    {
		min=wobble(min,v);
		hour=wobble(hour,v/12);
    }
    private double wobble(double d,double v) {
    	d+=v;
    	return d;
    }


}

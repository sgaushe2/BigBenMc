package com.example.examplemod.entity.render;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.EntityElizabethTower;

import assets.examplemod.textures.entity.ModelElizabethTower;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderElizabethTower extends RenderLiving<EntityElizabethTower>{
    private static final ResourceLocation Elizabeth_Tower = new ResourceLocation(
            ExampleMod.MODID + ":" + "textures/entity/elizabethtower.png");

	public RenderElizabethTower(RenderManager renderManager) {
        super(renderManager, new ModelElizabethTower(), 0.5F);
	}
    protected void preRenderCallback(EntityElizabethTower entity, float partialTickTime)
    {
        GlStateManager.scale(1F, 1F, 1F);
    }

    protected ResourceLocation getEntityTexture(EntityElizabethTower entity)
    {
        return RenderElizabethTower.Elizabeth_Tower;
    }

    public void Render(EntityElizabethTower entity, double x, double y, double z, float entityYaw, float partialTicks)
    {

        
    }

}

package de.mach.echoesofarcadia.client;

import de.mach.echoesofarcadia.entity.ArchiveGuideEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

/** Uses a stable vanilla humanoid model/texture, so the mod needs no binary art asset to run. */
public final class ArchiveGuideRenderer extends MobRenderer<ArchiveGuideEntity, HumanoidModel<ArchiveGuideEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/entity/zombie/zombie.png");

    public ArchiveGuideRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.ZOMBIE)), 0.45F);
    }

    @Override
    public ResourceLocation getTextureLocation(ArchiveGuideEntity entity) {
        return TEXTURE;
    }
}

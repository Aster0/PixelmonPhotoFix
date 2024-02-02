package me.astero.pixelmonphotofix.mixin;


import com.mojang.blaze3d.vertex.PoseStack;
import com.pixelmonmod.pixelmon.client.render.layers.LayerEquippables;
import com.pixelmonmod.pixelmon.entities.pixelmon.AbstractClientEntity;
import com.pixelmonmod.pixelmon.items.SpriteItem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(LayerEquippables.class)
public class HumanoidArmorRenderMixin{


    @Inject(at = @At(value = "HEAD"), cancellable = true, remap = false, method = "Lcom/pixelmonmod/pixelmon/client/render/layers/LayerEquippables;render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/client/player/AbstractClientPlayer;FFFFFF)V", locals = LocalCapture.CAPTURE_FAILHARD)
    public void render(PoseStack matrix, MultiBufferSource buffer, int packedLight, AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci ) {


        if(player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof SpriteItem) {
            ci.cancel();
        }
    }


}

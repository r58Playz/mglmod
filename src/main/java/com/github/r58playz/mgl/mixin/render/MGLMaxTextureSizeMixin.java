package com.github.r58playz.mgl.mixin.render;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.github.r58playz.mgl.MGL;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

@Mixin(RenderSystem.class)
class MGLMaxTextureSizeMixin {
    /*
    @Inject(method = "maxSupportedTextureSize()I", at = @At("HEAD"), cancellable = true)
    public static void maxSupportedTextureSize(CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(Math.max(GlStateManager._getInteger(3379), 1024));
    } */
    @Overwrite(remap = false)
    public static int maxSupportedTextureSize(){
        MGL.LOGGER.info("mgl texture size function called");
        return Math.max(GlStateManager._getInteger(3379), 1024);
    }
}
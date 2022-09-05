package com.github.r58playz.mgl.mixin.debug;

import com.github.r58playz.mgl.MGL;
import net.minecraft.client.gl.GlProgramManager;
import net.minecraft.client.gl.GlShader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GlProgramManager.class)
public class MGLProgramLinkedMixin {
    @Inject(at = @At("TAIL"), method = "linkProgram")
    private static void maxSupportedTextureSize(GlShader shader, CallbackInfo ci){
        MGL.LOGGER.debug("mglmod: Successfuly linked shader program with VS " + shader.getVertexShader().getName() + " and FS " + shader.getFragmentShader().getName());
    }
}

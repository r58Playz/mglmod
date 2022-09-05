package com.github.r58playz.mgl.mixin.debug;

import com.github.r58playz.mgl.MGL;
import com.mojang.blaze3d.platform.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

@Mixin(GlStateManager.class)
public class MGLGlStateManagerDebugMixin {
    @Inject(at = @At("HEAD"), method = "_glBindVertexArray", remap = false)
    private static void genVertexArrays(int array, CallbackInfo ci){
        MGL.LOGGER.debug("mglmod: glBindVertexArray called, vao will be bound with id "+array);
    }
    @Inject(at = @At("HEAD"), method = "_texImage2D")
    private static void texImage2d(int target, int level, int internalFormat, int width, int height, int border, int format, int type, IntBuffer pixels, CallbackInfo ci){
        MGL.LOGGER.debug("mglmod: texImage2D called with target "+target+", level "+level+", internal format "+internalFormat+", width "+width+", height "+height+", border "+border+", format "+format+", and type "+type);
    }

    @Inject(at = @At("TAIL"), method = "_glGenVertexArrays", remap = false)
    private static void genVertexArrays(CallbackInfoReturnable<Integer> cir){
        MGL.LOGGER.debug("mglmod: glGenVertexArrays called, vao generated with id "+cir.getReturnValue());
    }
    @Inject(at = @At("HEAD"), method = "_glBindBuffer")
    private static void glBindBuffer(int target, int buffer, CallbackInfo ci){
        MGL.LOGGER.debug("mglmod: glBindBuffer called with target "+target+" and buffer id "+buffer);
    }
    @Inject(at = @At("HEAD"), method = "_enableVertexAttribArray")
    private static void enableVertexAttribArray(int index, CallbackInfo ci){
        MGL.LOGGER.debug("mglmod: glEnableVertexAttribArray called with index "+index);
    }
    @Inject(at = @At("HEAD"), method = "_vertexAttribPointer")
    private static void vertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long pointer, CallbackInfo ci){
        MGL.LOGGER.debug("mglmod: glVertexAttribPointer called with index "+index+
                         ", size "+size+
                         ", type "+type+
                         ", normalized "+normalized+
                         " and stride "+stride);
    }

    @Inject(at = @At("HEAD"), method = "_glBufferData(ILjava/nio/ByteBuffer;I)V")
    private static void bufferData1(int target, ByteBuffer data, int usage, CallbackInfo ci) {
        MGL.LOGGER.debug("mglmod: _glBufferData called with target "+target+" and usage "+usage);
    }

    @Inject(at = @At("HEAD"), method = "_glBufferData(IJI)V")
    private static void bufferData2(int target, long size, int usage, CallbackInfo ci) {
        MGL.LOGGER.debug("mglmod: _glBufferData called with target "+target+" and usage "+usage);
    }
}

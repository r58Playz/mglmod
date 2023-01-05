package ml.r58playz.mgl.mixin.render;

import ml.r58playz.mgl.MGL;
import com.mojang.blaze3d.platform.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GlStateManager.class)
public class MGLBindAttribLocationMixin {
    @Inject(method = "_glBindAttribLocation", at = @At("HEAD"), cancellable = true)
    private static void glBindAttribLocation(int program, int index, CharSequence name, CallbackInfo ci) {
        MGL.LOGGER.warn("mglmod: glBindAttribLocation call for program id "+program+", index "+index+", and name "+name+" cancelled.");
        ci.cancel();
    }
}

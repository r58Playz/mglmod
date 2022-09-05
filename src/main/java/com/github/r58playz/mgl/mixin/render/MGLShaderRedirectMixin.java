package com.github.r58playz.mgl.mixin.render;

import com.github.r58playz.mgl.MGL;
import net.minecraft.client.render.Shader;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Shader.class)
public class MGLShaderRedirectMixin {
    @ModifyVariable(method = "<init>", index = 4, ordinal = 0, at = @At("STORE"))
    private Identifier initRedirectShaderPath(Identifier x) {
        MGL.LOGGER.debug("mglmod: redirected shaders from path: " + x.getPath() + " to path: " + "mgl" + x.getPath() + " (in <init>)");
        return new Identifier("mgl" + x.getPath());
    }

    @ModifyVariable(method = "loadProgram", ordinal = 1, at = @At("STORE"))
    private static String loadProgramRedirectShaderPath(String oldPath) {
        MGL.LOGGER.debug("mglmod: redirected shaders from path: " + oldPath + " to path: " + "mgl" + oldPath + " (in loadProgram)");
        return "mgl" + oldPath;
    }
}

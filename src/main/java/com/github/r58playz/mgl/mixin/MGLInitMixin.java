package com.github.r58playz.mgl.mixin;

import com.github.r58playz.mgl.MGL;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MGLInitMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		MGL.LOGGER.info("mglmod: PARTY! MGL WORKED UNTIL INIT!");
	}
}

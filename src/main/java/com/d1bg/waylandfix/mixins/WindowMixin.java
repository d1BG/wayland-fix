package com.d1bg.waylandfix.mixins;

import com.mojang.blaze3d.platform.Window;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Window.class)
public class WindowMixin {
    @Inject(at = @At("HEAD"), method = "setIcon", cancellable = true)
    private void init(CallbackInfo info) {
        if (GLFW.glfwGetVersionString().contains("Wayland")) {
            info.cancel();
        }
    }
}


package com.d1bg.waylandfix.mixins;


import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static java.lang.Character.toLowerCase;

@Mixin(EditBox.class)
public class TextFieldWidgetMixin {
    @Inject(at = @At("HEAD"),method = "charTyped", cancellable = true)
    private void charTyped(char chr, int modifiers, CallbackInfoReturnable<Boolean> cir) {
        if (isSpecialChar(toLowerCase(chr)) && Screen.hasControlDown()) {
            cir.setReturnValue(false);
        }
    }

    @Unique
    private boolean isSpecialChar(char chr) {
        return chr == 'a' // CTRL + a (select all)
            || chr == 'v' // CTRL + v (paste)
            || chr == 'c' // CTRL + c (copy)
            || chr == 'x'; // CTRL + x (cut);
    }
}

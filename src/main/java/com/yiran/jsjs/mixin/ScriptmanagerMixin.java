package com.yiran.jsjs.mixin;

import com.yiran.jsjs.util.ScriptLoadEvent;
import dev.latvian.mods.kubejs.script.ScriptManager;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.kubejs.util.ConsoleJS;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.IModBusEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.logging.Logger;

@Mixin(ScriptManager.class)
public class ScriptmanagerMixin {
    @Shadow @Final public ScriptType scriptType;

    @Inject(at = @At(value = "RETURN"),method = "reload")
    private void jjs$reload(CallbackInfo ci){
        MinecraftForge.EVENT_BUS.post(new ScriptLoadEvent(scriptType));

        Logger.getLogger("iiiii").info("114514");
        scriptType.console.log("load");
    }
}

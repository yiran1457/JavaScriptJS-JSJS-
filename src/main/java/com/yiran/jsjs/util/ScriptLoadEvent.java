package com.yiran.jsjs.util;

import com.yiran.jsjs.JavaScriptJS;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.kubejs.util.ConsoleJS;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.IModBusEvent;

@Mod.EventBusSubscriber(modid = JavaScriptJS.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ScriptLoadEvent extends Event implements IModBusEvent {
    public ScriptType type;
    public ScriptLoadEvent(ScriptType pType) {
        type = pType;
    }

    //@SubscribeEvent
    public static void onload(ScriptLoadEvent event){
        event.type.console.log("1111111111");

    }
}

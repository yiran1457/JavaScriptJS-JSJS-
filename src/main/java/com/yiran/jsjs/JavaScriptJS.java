package com.yiran.jsjs;

import com.yiran.jsjs.util.ScriptLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(JavaScriptJS.MODID)
@SuppressWarnings("removal")
public class JavaScriptJS {
    public static final String MODID = "javascriptjs";
    public JavaScriptJS() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ScriptLoadEvent::onload);
        MinecraftForge.EVENT_BUS.addListener(ScriptLoadEvent::onload);
    }
}

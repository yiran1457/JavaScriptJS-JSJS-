package com.yiran.jsjs;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(JavaScriptJS.MODID)
@SuppressWarnings("removal")
public class JavaScriptJS {
    public static final String MODID = "javascriptjs";
    public JavaScriptJS() {
        FMLJavaModLoadingContext.get().getModEventBus();
    }
}

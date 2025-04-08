package com.yiran.jsjs.kubejs;

import com.yiran.jsjs.util.JSIO;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;

public class JavaScriptJSPlugin extends KubeJSPlugin {

    @Override
    public void registerBindings(BindingsEvent event) {
        event.add("JSIO", JSIO.INSTANCE);
    }
}

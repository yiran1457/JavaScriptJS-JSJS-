package com.yiran.jsjs.mixin;

import com.yiran.jsjs.util.IJsonIO;
import dev.latvian.mods.kubejs.util.JsonIO;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(JsonIO.class)
public class JsonIOMixin implements IJsonIO {
}

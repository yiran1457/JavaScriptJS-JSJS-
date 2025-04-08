package com.yiran.jsjs.util;


import com.google.gson.JsonObject;
import dev.latvian.mods.kubejs.util.JsonIO;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface IJsonIO {
    static void writeAndCreateDirectories(Path path, JsonObject json) throws IOException {
        Files.createDirectories(path.getParent());
        JsonIO.write(path, json);
    }

    static Path[] findJsonInDirectory(@NotNull Path path) throws IOException {
        try (Stream<Path> stream = Files.walk(path, 10, FileVisitOption.FOLLOW_LINKS)) {
            return stream
                    .filter(pPath -> pPath.toString().endsWith(".json"))
                    .toArray(Path[]::new);
        }
    }
}

package com.yiran.jsjs.util;


import com.google.gson.JsonObject;
import dev.latvian.mods.kubejs.util.JsonIO;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
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

    static void read(Path pPath, JsonReader reader) throws IOException {
        for (Path path : findJsonInDirectory(pPath)) {
            String fullFileName = path.getFileName().toString();
            String fileName = fullFileName.substring(0, fullFileName.length() - 5);
            Path pathBuffer = pPath.relativize(path).getParent();
            String pathName = "";
            if (pathBuffer != null) {
                pathName = pathBuffer.toString().replace("\\", "/");
            }
            reader.todo(pathName, fileName, JsonIO.read(path));
        }
    }

    @FunctionalInterface
    interface JsonReader {
        void todo(String path, String fileName, Map<?, ?> json);
    }
}

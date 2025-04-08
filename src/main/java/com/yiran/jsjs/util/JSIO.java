package com.yiran.jsjs.util;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JSIO {
    private static final List<String> AllowSuffixes = Arrays.asList(".js", ".ts", ".txt", ".toml");
    public static JSIO INSTANCE = new JSIO();

    public List<@NotNull String> read(Path path) throws IOException {
        if (isAllowed(path) || !exists(path)) return new ArrayList<>();
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public boolean exists(Path path) {
        return Files.exists(path);
    }

    public void write(Path path, String[] file) throws IOException {
        if (isAllowed(path)) return;
        Files.createDirectories(path.getParent());
        Files.write(path, List.of(file));
    }

    public void delete(Path path) throws IOException {
        if (isAllowed(path)) return;
        Files.deleteIfExists(path);
    }

    public boolean isAllowed(@NotNull Path path) {
        boolean allow = false;
        for (String allowSuffix : JSIO.AllowSuffixes) {
            if (path.toString().endsWith(allowSuffix)) {
                allow = true;
                break;
            }
        }
        return !allow;
    }

    public List<String> getAllowSuffix() {
        return new ArrayList<>(JSIO.AllowSuffixes);
    }

    public Path[] findJSInDirectory(@NotNull Path path) throws IOException {
        try (Stream<Path> stream = Files.walk(path, 10, FileVisitOption.FOLLOW_LINKS)) {
            return stream
                    .filter(pPath -> pPath.toString().endsWith(".js"))
                    .toArray(Path[]::new);
        }
    }
}

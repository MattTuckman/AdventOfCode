package com.tuckman.advent.of.code.commons;

import java.io.BufferedReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdventUtils {

    public static List<String> listLinesOfResource(String resourcePath) {
        return streamLinesOfResource(resourcePath).collect(Collectors.toList());
    }

    public static Stream<String> streamLinesOfResource(String resourcePath) {
        try {
            URL resourceUrl = AdventUtils.class.getClassLoader().getResource(resourcePath);

            if (Objects.isNull(resourceUrl)) {
                throw new RuntimeException("Non-existant file name provided");
            }

            Path actualPath = Paths.get(resourceUrl.toURI());
            BufferedReader br = Files.newBufferedReader(actualPath);
            return br.lines();
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }

    private AdventUtils() {}
}

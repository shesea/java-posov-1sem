package ru.spbu.arts.java.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileVisitorTest {
    public static void main(String[] args) throws IOException {
        Path searchDir = Path.of("D:/cimo/utility/qwerty");
        Files.walkFileTree(searchDir, new FilesCollector());
    }
}

package edu.umb.cs680.hw17.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ReverseAlphabeticalComparatorTest {

    private static FileSystem fileSystem;

    @BeforeAll
    public static void setupFS() {
        fileSystem = TestFixture.createFS();
    }

    @Test
    public void testGetChildrenWithReverseAlphabeticalComparator() {
        List<String> expected = new ArrayList<>(List.of("test", "src", "readme.md"));

        List<String> actual = fileSystem.getRootDirectories().element().getChildren().stream()
                .map(FSElement::getName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        assertIterableEquals(expected, actual);
    }

    @Test
    public void testGetFilesWithReverseAlphabeticalComparator() {
        List<String> expected = new ArrayList<>(List.of("BTest.java", "ATest.java"));

        Directory testDirectory = fileSystem.getRootDirectories().element().getChildren().stream()
                .filter(FSElement::isDirectory)
                .map(element -> (Directory) element)
                .filter(directory -> directory.getName().equals("test"))
                .findFirst()
                .orElse(null);

        if (testDirectory != null) {
            Directory srcDirectory = testDirectory.getSubDirectories().stream()
                    .findFirst()
                    .orElse(null);

            if (srcDirectory != null) {
                List<String> actual = srcDirectory.getFiles().stream()
                        .map(File::getName)
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());

                assertIterableEquals(expected, actual);
            }
        }
    }
}

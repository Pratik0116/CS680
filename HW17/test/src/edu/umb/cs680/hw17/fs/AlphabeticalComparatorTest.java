package edu.umb.cs680.hw17.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class AlphabeticalComparatorTest {

    private static FileSystem fileSystem;
    private static Comparator<FSElement> comparator;

    @BeforeAll
    public static void setupFS() {
        fileSystem = TestFixture.createFS();
        comparator = Comparator.comparing(FSElement::getName);
    }

    @Test
    public void testGetChildrenWithAlphabeticalComparator() {
        Directory root = fileSystem.getRootDirectories().get(0);
        ArrayList<String> expected = new ArrayList<>(List.of("readme.md", "src", "test"));

        List<String> actual = root.getChildren().stream()
                .map(FSElement::getName)
                .sorted()
                .collect(Collectors.toList());

        assertIterableEquals(expected, actual);
    }

    @Test
    public void testGetSubDirectoriesWithAlphabeticalComparator() {
        Directory root = fileSystem.getRootDirectories().get(0);
        ArrayList<String> expected = new ArrayList<>(List.of("src", "test"));

        List<String> actual = root.getSubDirectories().stream()
                .map(FSElement::getName)
                .sorted()
                .collect(Collectors.toList());

        assertIterableEquals(expected, actual);
    }

    @Test
    public void testGetFilesWithAlphabeticalComparator() {
        ArrayList<String> expected = new ArrayList<>(List.of("A.java", "B.java"));

        Directory src = fileSystem.getRootDirectories().get(0).getChildren().stream()
                .filter(element -> element.isDirectory() && element.getName().equals("src"))
                .map(element -> (Directory) element)
                .findFirst()
                .orElse(null);

        List<String> actual = src.getFiles().stream()
                .map(File::getName)
                .sorted()
                .collect(Collectors.toList());

        assertIterableEquals(expected, actual);
    }
}

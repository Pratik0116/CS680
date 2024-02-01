package edu.umb.cs680.hw17.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ElementKindComparatorTest {

    private static FileSystem fileSystem;

    @BeforeAll
    public static void setupFS() {
        fileSystem = TestFixture.createFS();
    }

    @Test
    public void testGetChildrenWithElementKindComparator() {
        Directory root = fileSystem.getRootDirectories().get(0);
        ArrayList<String> expected = new ArrayList<>(List.of("src", "test", "readme.md"));

        List<String> actual = root.getChildren().stream()
                .sorted(Comparator.comparing((FSElement fsElement) -> fsElement.isDirectory())
                        .reversed()
                        .thenComparing(fsElement -> fsElement instanceof File)
                        .thenComparing(fsElement -> fsElement instanceof Link))
                .map(FSElement::getName)
                .collect(Collectors.toList());

        assertIterableEquals(expected, actual);
    }
}

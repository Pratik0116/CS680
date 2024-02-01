package edu.umb.cs680.hw13.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<String> expected = new ArrayList<>();
        expected.add("src");
        expected.add("test");
        expected.add("readme.md");
        List<FSElement> rootSubDirs = root.getChildren();
        rootSubDirs.sort(new ElementKindComparator());
        ArrayList<String> actual = new ArrayList<>();
        for (FSElement element : rootSubDirs)
            actual.add(element.getName());
        assertIterableEquals(expected, actual);
    }
}

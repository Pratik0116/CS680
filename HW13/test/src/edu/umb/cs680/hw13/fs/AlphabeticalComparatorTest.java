package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.TestFixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class AlphabeticalComparatorTest {

    private static FileSystem fileSystem;

    @BeforeAll
    public static void setupFS() {
        fileSystem = TestFixture.createFS();
    }

    @Test
    public void testGetChildrenWithAlphabeticalComparator() {
        Directory root = fileSystem.getRootDirectories().get(0);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("readme.md");
        expected.add("src");
        expected.add("test");
        List<FSElement> rootSubDirs = root.getChildren();
        rootSubDirs.sort(new AlphabeticalComparator());
        ArrayList<String> actual = new ArrayList<>();
        for (FSElement element : rootSubDirs)
            actual.add(element.getName());
        assertIterableEquals(expected, actual);
    }

    @Test
    public void testGetSubDirectoriesWithAlphabeticalComparator(){
        Directory root = fileSystem.getRootDirectories().get(0);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("src");
        expected.add("test");
        List<Directory> rootSubDirs = root.getSubDirectories();
        rootSubDirs.sort(new AlphabeticalComparator());
        ArrayList<String> actual = new ArrayList<>();
        for (Directory directory : rootSubDirs)
            actual.add(directory.getName());
        assertIterableEquals(expected, actual);
    }

    @Test
    public void testGetFilesWithAlphabeticalComparator(){
        ArrayList<String> expected = new ArrayList<>();
        expected.add("A.java");
        expected.add("B.java");
        Directory src = null;
        for (FSElement element : fileSystem.getRootDirectories().get(0).getChildren()) {
            if (element.isDirectory() && element.getName().equals("src"))
                src = (Directory) element;
        }
        List<File> files = src.getFiles();
        files.sort(new AlphabeticalComparator());
        ArrayList<String> actual = new ArrayList<>();
        for (File file : files){
            actual.add(file.getName());
        }
        assertIterableEquals(expected,actual);
    }
}

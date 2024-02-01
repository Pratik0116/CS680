package edu.umb.cs680.hw15.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ReverseAlphabeticalComparatorTest {

    private static FileSystem fileSystem;

    @BeforeAll
    public static void setupFS() {
        fileSystem = TestFixture.createFS();
    }

    @Test

    public void testGetChildrenWithReverseAlphabeticalComparator() {
        List<String> expected = new ArrayList<>();
        expected.add("test");
        expected.add("src");
        expected.add("readme.md");
        List<FSElement> rootSubDirs = fileSystem.getRootDirectories().element().getChildren();
        rootSubDirs.sort((e1,e2)->e2.getName().compareTo(e1.getName()));
        List<String> actual = new ArrayList<>();
        for (FSElement element : rootSubDirs)
            actual.add(element.getName());
        assertIterableEquals(expected, actual);
    }

    @Test
    public void testGetFilesWithReverseAlphabeticalComparator(){
        ArrayList<String> expected = new ArrayList<>();
        expected.add("BTest.java");
        expected.add("ATest.java");
        Directory src = null;
        Directory test;
        for (FSElement element : fileSystem.getRootDirectories().get(0).getChildren()) {
            if (element.isDirectory() && element.getName().equals("test")){
                test = (Directory) element;
                for(Directory dirPack :test.getSubDirectories() ){
                    src  = (Directory) dirPack;
                }
            }
        }
        List<File> files = src.getFiles();
        files.sort((e1,e2)->e2.getName().compareTo(e1.getName()));
        ArrayList<String> actual = new ArrayList<>();
        for (File file : files){
            actual.add(file.getName());
        }
        assertIterableEquals(expected,actual);
    }
}

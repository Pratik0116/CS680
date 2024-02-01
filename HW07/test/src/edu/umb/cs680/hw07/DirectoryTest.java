package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest
{
    private static FileSystem fileSystem;

    @BeforeAll
    public static void setUpFileSystem()
    {
        fileSystem = TestFixture.createFS();
    }


    private String[] directoryToStringArray(Directory dir) {
        String parentName = null;
        Directory parent = dir.getParent();
        if (parent != null) {
            parentName = parent.getName();
        }
        String[] directory_data = {
                String.valueOf(dir.isFile()),
                dir.getName(),
                Integer.toString(dir.getSize()),
                dir.getCreationTime().toString(),
                parentName,
                String.valueOf(dir.isDirectory()),
                Integer.toString(dir.getTotalSize()),
                Integer.toString(dir.countChildren())
        };
        return directory_data;
    }


    @Test
    public void checkDirectoryForsrcEquality() {
        String[] expected = {"false","src", "0", "2023-11-05T05:05", "repo", "true", "5","2"};
        Directory src = null;
        for (FSElement element : fileSystem.getRootDirectories().get(0).getChildren())
        {
            if (element.isDirectory() && element.getName().equals("src"))
                src = (Directory) element;
        }
        assertNotNull(src);
        assertArrayEquals(expected, directoryToStringArray(src));
    }

    @Test
    public void checkDirectoryForTestEquality() {
        String[] expected = {"false", "test","0", "2023-11-05T05:05", "repo", "true","13","1"};
        Directory test = null;
        for (FSElement element : fileSystem.getRootDirectories().get(0).getChildren())
        {
            if (element.isDirectory() && element.getName().equals("test"))
                test = (Directory) element;
        }
        assertNotNull(test);
        assertArrayEquals(expected, directoryToStringArray(test));
    }

    @Test
    public void checkForAllSubDirsFiles() {
        Directory root = fileSystem.getRootDirectories().get(0);
        List<String> expectedFiles = List.of("readme.md","A.java", "B.java", "ATest.java", "BTest.java");

        List<String> actualFiles = new ArrayList<>();
        Queue<Directory> directoriesToProcess = new LinkedList<>();
        directoriesToProcess.add(root);

        while (!directoriesToProcess.isEmpty()) {
            Directory currentDir = directoriesToProcess.poll();
            List<FSElement> subElements = currentDir.getChildren();

            for (FSElement element : subElements) {
                if (element instanceof Directory) {
                    directoriesToProcess.add((Directory) element);
                } else if (element instanceof File) {
                    actualFiles.add(element.getName());
                }
            }
        }
        assertIterableEquals(expectedFiles, actualFiles);
    }


    @Test
    public void checkTotalSizeForRootDir() {
        Directory root = fileSystem.getRootDirectories().get(0);
        int expected = 26;
        assertEquals(expected, root.getTotalSize());
    }

    @Test
    public void checkForRootSubDirs() {
        Directory root = fileSystem.getRootDirectories().get(0);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("src");
        expected.add("test");

        LinkedList<Directory> rootSubDirs = root.getSubDirectories();
        ArrayList<String> actual = new ArrayList<>();
        for (Directory directory : rootSubDirs)
            actual.add(directory.getName());
        assertIterableEquals(expected, actual);
    }
}

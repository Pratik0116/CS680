package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FileTest
{
    private static FileSystem fileSystem;

    private String[] fileToStringArray(FSElement f) {
        String[] fileInfo = {
                String.valueOf(f.isFile()),
                f.getName(),
                Integer.toString(f.getSize()),
                f.getCreationTime().toString(),
                f.getParent().getName(),
                String.valueOf(f.isDirectory())
        };
        return fileInfo;
    }


    @BeforeAll
    public static void setupFS()
    {
        fileSystem = TestFixture.createFS();
    }

    @Test
    public void checkFilesInsrcDir()
    {
        String[] expected = {"false","A.java","2", "2023-11-05T05:05", "src", "false"};
        Directory src = null;
        for (FSElement element : fileSystem.getRootDirectories().get(0).getChildren()) {
            if (element.isDirectory() && element.getName().equals("src"))
                src = (Directory) element;
        }
        FSElement filesIn = null;
        for (FSElement file : src.getChildren()) {
            if (file.getName().equals("A.java"))
                filesIn = file;
        }
        assertArrayEquals(expected, fileToStringArray(filesIn));
    }

    @Test
    public void checkFilesInsrcDir2()
    {
        String[] expected = {"false","B.java","3", "2023-11-05T05:05", "src", "false"};
        Directory src = null;
        for (FSElement element : fileSystem.getRootDirectories().get(0).getChildren()) {
            if (element.isDirectory() && element.getName().equals("src"))
                src = (Directory) element;
        }
        FSElement filesIn = null;
        for (FSElement file : src.getChildren()) {
            if (file.getName().equals("B.java"))
                filesIn = file;
        }
        assertArrayEquals(expected, fileToStringArray(filesIn));
    }

    @Test
    public void checkFilesInTestSubDir()
    {
        String[] expected = {"false","ATest.java","6", "2023-11-05T05:05", "Src", "false"};
        Directory test = null;
        for (FSElement element : fileSystem.getRootDirectories().get(0).getChildren()) {
            if (element.isDirectory() && element.getName().equals("test")){
                test = (Directory) element;
                for(Directory dirPack :test.getSubDirectories() ){
                    test  = (Directory) dirPack;
                }

            }
        }
        FSElement filesIn = null;
        for (FSElement file : test.getChildren()) {
            if (file.getName().equals("ATest.java"))
                filesIn = file;
        }
        assertArrayEquals(expected, fileToStringArray(filesIn));
    }

    @Test
    public void checkFilesInTestSubDir2()
    {
        String[] expected = {"false","BTest.java","7", "2023-11-05T05:05", "Src", "false"};
        Directory test = null;
        for (FSElement element : fileSystem.getRootDirectories().get(0).getChildren()) {
            if (element.isDirectory() && element.getName().equals("test")){
                test = (Directory) element;
                for(Directory dirPack :test.getSubDirectories() ){
                    test  = (Directory) dirPack;
                }

            }
        }
        FSElement filesIn = null;
        for (FSElement file : test.getChildren()) {
            if (file.getName().equals("BTest.java"))
                filesIn = file;
        }
        assertArrayEquals(expected, fileToStringArray(filesIn));
    }
}

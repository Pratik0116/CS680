package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FileSystemTest
{
    private static FileSystem fileSystem;

    static private LocalDateTime DateTime1 = LocalDateTime.now();

    @BeforeAll
    public static void setUpFileSystem()
    {
        fileSystem = TestFixture.createFS();
    }

    @Test
    public void verifyingRootDirectoryAndAppendRootDir() {
        Directory lib = new Directory(null,"lib", 0, DateTime1);
        FileSystem fsNew = FileSystem.getFileSystem();
        fsNew.addRootDirectory(lib);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("repo");
        expected.add("lib");
        ArrayList<String> actual = new ArrayList<>();
        for (Directory dir : fsNew.getRootDirectories()){
            actual.add(dir.getName());
        }
        assertIterableEquals(expected, actual);
    }

    @Test
    public void verifyFileSystemSingleton() {
        FileSystem fsInstance1 = FileSystem.getFileSystem();
        FileSystem fsInstance2 = FileSystem.getFileSystem();
        // Check if both instances point to the same object
        assertSame(fsInstance1, fsInstance2);
    }
}

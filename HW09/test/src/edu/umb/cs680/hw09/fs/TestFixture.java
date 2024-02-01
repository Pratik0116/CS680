package edu.umb.cs680.hw09.fs;

import java.time.LocalDateTime;
import java.time.Month;

public class TestFixture
{
    static FileSystem fileSystem = null;

    public static FileSystem createFS()
    {
        LocalDateTime localDateTime = LocalDateTime.of(2023, Month.NOVEMBER, 5, 05, 05);
        if (fileSystem != null)
            return fileSystem;
        FileSystem fs = FileSystem.getFileSystem();
        Directory root = new Directory(null, "repo", 0, localDateTime);
        fs.addRootDirectory(root);
        File readme = new File(root,"readme.md", 8, localDateTime);

        Directory src = new Directory(root,"src", 1, localDateTime);
        File A = new File(src,"A.java", 2, localDateTime);
        File B = new File(src,"B.java", 3, localDateTime);

        Directory test = new Directory(root,"test", 4, localDateTime);
        Directory Src = new Directory(test,"Src",5, localDateTime);
        File ATest = new File(Src,"ATest.java", 6, localDateTime);
        File BTest = new File(Src,"BTest.java", 7, localDateTime);
        Link rm = new Link(Src,"rm.md",0,localDateTime,readme);
        fileSystem = fs;
        return fs;
    }
}
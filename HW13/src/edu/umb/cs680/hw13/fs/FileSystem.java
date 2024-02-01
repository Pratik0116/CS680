package edu.umb.cs680.hw13.fs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FileSystem {
    private LinkedList<Directory> rootDirectories = new LinkedList<Directory>();

    private FileSystem(){

    }

    private static FileSystem fileSystem ;

    public static FileSystem getFileSystem() {
        if (fileSystem == null)
            fileSystem = new FileSystem();
        return fileSystem;
    }

    public LinkedList<Directory> getRootDirectories() {
        return rootDirectories;
    }

    public void addRootDirectory(Directory dir) {
        this.rootDirectories.add(dir);
    }

}
package edu.umb.cs680.hw07;

import java.util.LinkedList;

public class FileSystem {
    private LinkedList<Directory> rootDirectories = new LinkedList<Directory>();

    private FileSystem(){

    }

    private static FileSystem fileSystem = null;

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

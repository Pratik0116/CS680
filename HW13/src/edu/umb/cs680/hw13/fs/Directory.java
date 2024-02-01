package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.FSElement;
import edu.umb.cs680.hw13.fs.FSVisitor;
import edu.umb.cs680.hw13.fs.File;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Directory extends FSElement {

    private LinkedList<FSElement> children = new LinkedList<FSElement>();
    private LinkedList<File> files = new LinkedList<File>();
    private LinkedList<Directory> subDirectory = new LinkedList<Directory>();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime , LocalDateTime modifiedTime) {
        super(parent, name, size, creationTime , modifiedTime);
    }

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }


    public void appendChild(FSElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren() {
        return this.children.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        for (FSElement element : children) {
            if (element.isDirectory()) {
                subDirectory.add((Directory) element);
            }
        }
        return subDirectory;
    }

    public LinkedList<File> getFiles() {
        for (FSElement element : children) {
            if (element.isFile()) {
                files.add((File) element);
            }
        }
        return files;
    }

    public List<FSElement> getChildren(Comparator<FSElement> comparatorChildren){
        Collections.sort(children, comparatorChildren);
        return children;
    }

    public List<Directory> getSubDirectories(Comparator<FSElement> comparatorDirectories) {
        subDirectory = (LinkedList<Directory>) getSubDirectories();
        Collections.sort(subDirectory, comparatorDirectories);
        return subDirectory;
    }

    public List<File> getFiles(Comparator<FSElement> comparatorFiles) {
        files = getFiles();
        Collections.sort(files, comparatorFiles);
        return files;
    }


    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement element : children) {
            if (element.isDirectory()) {
                totalSize += ((Directory) element).getTotalSize();
            } else {
                totalSize += element.getSize();
            }
        }
        return totalSize;
    }

    public boolean isDirectory() {
        return true;
    }

    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink() {
        return false;
    }

    public void accept(FSVisitor v) {
        v.visit(this);
        for (FSElement e : children) {
            e.accept(v);
        }
    }

}
package edu.umb.cs680.hw17.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Directory extends FSElement {

    private LinkedList<FSElement> children = new LinkedList<>();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime, LocalDateTime modifiedTime) {
        super(parent, name, size, creationTime, modifiedTime);
    }

    public List<FSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren() {
        return this.children.size();
    }

    public List<Directory> getSubDirectories() {
        return children.stream()
                .filter(FSElement::isDirectory)
                .map(element -> (Directory) element)
                .collect(Collectors.toList());
    }

    public List<File> getFiles() {
        return children.stream()
                .filter(FSElement::isFile)
                .map(element -> (File) element)
                .collect(Collectors.toList());
    }

    public List<FSElement> getChildren(Comparator<FSElement> comparatorChildren) {
        return children.stream()
                .sorted(comparatorChildren)
                .collect(Collectors.toList());
    }

    public List<Directory> getSubDirectories(Comparator<FSElement> comparatorDirectories) {
        return getSubDirectories().stream()
                .sorted(comparatorDirectories)
                .collect(Collectors.toList());
    }

    public List<File> getFiles(Comparator<FSElement> comparatorFiles) {
        return getFiles().stream()
                .sorted(comparatorFiles)
                .collect(Collectors.toList());
    }

    public int getTotalSize() {
        return children.stream()
                .mapToInt(element -> element.isDirectory() ? ((Directory) element).getTotalSize() : element.getSize())
                .sum();
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
        children.forEach(e -> e.accept(v));
    }
}

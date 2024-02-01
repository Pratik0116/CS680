package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.FSVisitor;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;

import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor {
    private LinkedList<File> files = new LinkedList<>();

    public void visit(Link link) {
        return;
    }

    public void visit(Directory dir) {
        return;
    }

    public void visit(File file) {
        files.add(file);
    }

    public LinkedList<File> getFiles() {
        return files;
    }
}

package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.FSElement;
import edu.umb.cs680.hw13.fs.FSVisitor;

import java.time.LocalDateTime;

public class File extends FSElement {

    public File(Directory parent, String name, int size, LocalDateTime Creation_Time , LocalDateTime modifiedTime) {
        super(parent, name, size, Creation_Time , modifiedTime);
    }

    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public boolean isLink() {
        return false;
    }

    public void accept(FSVisitor v) {
        v.visit(this);

    }

}
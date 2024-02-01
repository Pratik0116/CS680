package edu.umb.cs680.hw17.fs;

import java.time.LocalDateTime;

public abstract class FSElement {

    private String name;
    private int size;
    private LocalDateTime creationTime;
    private Directory parent;
    private LocalDateTime modifiedTime;


    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime , LocalDateTime modifiedTime) {
        if (parent != null) {
            parent.appendChild(this);
        } else {
            this.parent = null;
        }
        this.setName(name);
        this.setSize(size);
        this.setCreationTime(creationTime);
        this.modifiedTime = modifiedTime;
    }

    public Directory getParent() {
        return this.parent;
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public void setSize(int size) {
        if (isDirectory()) {
            this.size = 0;
        } else {
            this.size = size;
        }
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    abstract public boolean isDirectory();
    abstract public boolean isFile();

    abstract public boolean isLink();

    public abstract void accept(FSVisitor v);

}
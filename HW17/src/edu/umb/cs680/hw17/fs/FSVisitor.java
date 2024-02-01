package edu.umb.cs680.hw17.fs;

public interface FSVisitor {

    public abstract void visit(Link Link);
    public abstract void visit(Directory Directory);
    public abstract void visit(File File);

}

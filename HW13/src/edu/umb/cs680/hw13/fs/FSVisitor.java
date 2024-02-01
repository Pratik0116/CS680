package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.Link;

public interface FSVisitor {

    public abstract void visit(Link Link);
    public abstract void visit(Directory Directory);
    public abstract void visit(File File);

}

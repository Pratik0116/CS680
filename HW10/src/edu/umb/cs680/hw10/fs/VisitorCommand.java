package edu.umb.cs680.hw10.fs;

public class VisitorCommand implements FSCommand {
    private FSVisitor visitor;
    private FSElement element;

    public VisitorCommand(FSVisitor visitor, FSElement element) {
        this.visitor = visitor;
        this.element = element;
    }

    public void execute() {
        element.accept(visitor);
    }
}

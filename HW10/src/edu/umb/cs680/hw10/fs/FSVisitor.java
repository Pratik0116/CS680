package edu.umb.cs680.hw10.fs;

public interface FSVisitor
{
	void visit(Link link);
	void visit(Directory directory);
	void visit(File file);
}

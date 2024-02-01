package edu.umb.cs680.hw09.fs;

public interface FSVisitor
{
	void visit(Link link);
	void visit(Directory directory);
	void visit(File file);
}

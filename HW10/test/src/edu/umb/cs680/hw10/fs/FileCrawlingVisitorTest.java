package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.FileCrawlingVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class FileCrawlingVisitorTest
{
	private static FileSystem fileSystem;

	@BeforeAll
	public static void setUpFS()
	{
		fileSystem = TestFixture.createFS();
	}

	@Test
	public void crawlingFilesInRootDir(){

		LinkedList<String> expected = new LinkedList<>();
		expected.add("readme.md");
		expected.add("A.java");
		expected.add("B.java");
		expected.add("ATest.java");
		expected.add("BTest.java");
		FSVisitor visitor = new FileCrawlingVisitor();
		VisitorCommand command = new VisitorCommand(visitor, fileSystem.getRootDirectories().get(0));
		command.execute();
		LinkedList<String> actual = new LinkedList<>();
		for (File file : ((FileCrawlingVisitor) visitor).getFiles()) {
			actual.add(file.getName());
		}
		assertIterableEquals(expected, actual);
	}
}

package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.FileSystem;
import edu.umb.cs680.hw09.fs.TestFixture;
import edu.umb.cs680.hw09.fs.util.FileCrawlingVisitor;
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
		FileCrawlingVisitor visitor = new FileCrawlingVisitor();
		fileSystem.getRootDirectories().get(0).accept(visitor);
		LinkedList<String> actual = new LinkedList<>();
		for(File file : visitor.getFiles()){
			actual.add(file.getName());
		}
		assertIterableEquals(expected, actual);
	}
}

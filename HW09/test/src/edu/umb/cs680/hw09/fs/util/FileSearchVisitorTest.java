package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.FileSystem;
import edu.umb.cs680.hw09.fs.TestFixture;
import edu.umb.cs680.hw09.fs.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class FileSearchVisitorTest
{
	private static FileSystem fileSystem;

	@BeforeAll
	public static void setUpFS()
	{
		fileSystem = TestFixture.createFS();
	}

	@Test
	public void searchForFileATest(){
		LinkedList<String> expected = new LinkedList<>();
		expected.add("ATest.java");
		FileSearchVisitor visitor = new FileSearchVisitor("ATest.java");
		fileSystem.getRootDirectories().get(0).accept(visitor);
		LinkedList<String> actual = new LinkedList<>();
		actual.add(visitor.getFoundFiles().get(0).getName());
		assertIterableEquals(expected, actual);
	}

	@Test
	public void searchForFileBTest(){
		LinkedList<String> expected = new LinkedList<>();
		expected.add("BTest.java");
		FileSearchVisitor visitor = new FileSearchVisitor("BTest.java");
		fileSystem.getRootDirectories().get(0).accept(visitor);
		LinkedList<String> actual = new LinkedList<>();
		actual.add(visitor.getFoundFiles().get(0).getName());
		assertIterableEquals(expected, actual);
	}
}

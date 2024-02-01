package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

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
		FSVisitor visitor = new FileSearchVisitor("ATest.java");
		VisitorCommand command = new VisitorCommand(visitor, fileSystem.getRootDirectories().get(0));
		command.execute();
		LinkedList<String> actual = new LinkedList<>();
		actual.add(((FileSearchVisitor) visitor).getFoundFiles().get(0).getName());
		assertIterableEquals(expected, actual);
	}

	@Test
	public void searchForFileBTest(){
		LinkedList<String> expected = new LinkedList<>();
		expected.add("BTest.java");
		FSVisitor visitor = new FileSearchVisitor("BTest.java");
		VisitorCommand command = new VisitorCommand(visitor, fileSystem.getRootDirectories().get(0));
		command.execute();
		LinkedList<String> actual = new LinkedList<>();
		actual.add(((FileSearchVisitor) visitor).getFoundFiles().get(0).getName());
		assertIterableEquals(expected, actual);
	}
}

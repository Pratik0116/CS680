package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CountingVisitorTest
{
	private static FileSystem fileSystem;

	@BeforeAll
	public static void setUpFS()
	{
		fileSystem = TestFixture.createFS();
	}

	@Test
	public void countingAllItemsInRootDir(){
		int expected = 4;
		FSVisitor visitor = new CountingVisitor();
		VisitorCommand command = new VisitorCommand(visitor, fileSystem.getRootDirectories().get(0));
		command.execute();
		int actual = ((CountingVisitor) visitor).getDirectoryNumber();
		assertEquals(expected, actual);
	}

	@Test
	public void countingLinksInTestDir(){
		int expected = 1;
		FSVisitor visitor = new CountingVisitor();
		VisitorCommand command = new VisitorCommand(visitor, fileSystem.getRootDirectories().get(0));
		command.execute();
		int actual = ((CountingVisitor) visitor).getLinkNumber();
		assertEquals(expected, actual);
	}
}

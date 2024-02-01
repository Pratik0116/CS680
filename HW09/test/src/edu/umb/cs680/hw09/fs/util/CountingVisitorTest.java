package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.FileSystem;
import edu.umb.cs680.hw09.fs.TestFixture;
import edu.umb.cs680.hw09.fs.util.*;
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
		CountingVisitor visitor = new CountingVisitor();
		fileSystem.getRootDirectories().get(0).accept(visitor);
		int actual = visitor.getDirectoryNumber();
		assertEquals(expected, actual);
	}

	@Test
	public void countingLinksInTestDir(){
		int expected = 1;
		CountingVisitor visitor = new CountingVisitor();
		fileSystem.getRootDirectories().get(0).accept(visitor);
		int actual = visitor.getLinkNumber();
		assertEquals(expected, actual);
	}
}

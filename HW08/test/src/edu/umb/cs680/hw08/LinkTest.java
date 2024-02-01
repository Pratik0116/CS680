package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LinkTest
{
	private static FileSystem fileSystem;

	private String[] linkToStringArray(Link link) {
		String[] linkInfo = {link.getName(), String.valueOf(link.getCreationTime()),
				String.valueOf(link.getSize()), link.getParent().getName(), link.getTarget().getName(),String.valueOf(link.isDirectory())};
		return linkInfo;
	}

	@BeforeAll
	public static void setupFS() {
		fileSystem = TestFixture.createFS();
	}

	@Test
	public void verifyingLinkEquality(){
		String[] expected = {"rm.md", "2023-11-05T05:05", "0", "Src", "readme.md", "false"};
		Directory src = null;
		Link link = null;
		for (FSElement element : fileSystem.getRootDirectories().get(0).getChildren()) {
			if (element.isDirectory() && element.getName().equals("test")) {
				src = (Directory) element;
				for (FSElement subElement : src.getChildren()) {
					if (subElement.isDirectory()) {
						Directory subDir = (Directory) subElement;
						for (FSElement linkElement : subDir.getChildren()){
							if (linkElement.getName().equals("rm.md") && linkElement instanceof Link)
								link = (Link) linkElement;
						}
					}
				}
			}
		}
		assertArrayEquals(expected, linkToStringArray(link));
	}

	@Test
	public void verifyingLinkTarget(){
		String expected = "readme.md";
		Link link = null;
		Directory src = null;
		File target = null;
		for (FSElement element : fileSystem.getRootDirectories().get(0).getChildren()) {
			if (element.isDirectory() && element.getName().equals("test")) {
				src = (Directory) element;
				for (FSElement subElement : src.getChildren()) {
					if (subElement.isDirectory()) {
						Directory subDir = (Directory) subElement;
						for (FSElement linkElement : subDir.getChildren()){
							if (linkElement.getName().equals("rm.md") && linkElement instanceof Link){
								link = (Link) linkElement;
								target = (File) link.getTarget();
							}
						}
					}
				}
			}
		}
		assertEquals(expected, target.getName());
	}

}

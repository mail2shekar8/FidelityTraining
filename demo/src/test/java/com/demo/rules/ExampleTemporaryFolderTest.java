package com.demo.rules;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.ExpectedException;

public class ExampleTemporaryFolderTest {
	
	@Rule
	public TemporaryFolder folder= new TemporaryFolder();

	@Test
	public void testUsingTempFolder() throws IOException {
	   File createdFile= folder.newFile("tmpfile.txt");
	   File createdFolder= folder.newFolder("tmpfolder");
	   
	   System.out.printf("Created temp folder location is %s %n", createdFolder.getAbsolutePath());
	}
}

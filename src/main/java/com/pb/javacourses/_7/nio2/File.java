package com.pb.javacourses._7.nio2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class File {

	public static void main (String ... args) throws IOException {
		OpenOption gf;
		StandardOpenOption l;
		java.nio.file.spi.FileSystemProvider.installedProviders();
		java.nio.file.attribute.PosixFilePermission d;
//		file.AccessMode sl;
		Path p = Paths.get("path","to", "some", "file.sh");
		byte[] fileArray = Files.readAllBytes(p);
		List<String> readAllLines = Files.readAllLines(p, Charset.defaultCharset());
		
	}
	
}

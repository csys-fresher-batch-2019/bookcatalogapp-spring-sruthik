package com.sruthi.bookcatalogapp.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component

public class FileUtil {
//	private FileUtil() {
//	    throw new IllegalStateException("Utility class");
//	  }
  public static void writeToFile(String fileName,String content) throws IOException {
	  Path path = Paths.get(fileName);
	  byte[] bytes = content.getBytes();
	  //WriteFile 
	  Files.write(path, bytes);
	 
	  
	  
  }

}

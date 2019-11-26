package com.cortex.LSDScript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
	
	static int ch;
	
	public static void main(String[] args) throws IOException {
		
		FileReader fr = null;

		try {
			fr = new FileReader("HelloWorld.ls");
		} catch (FileNotFoundException fe) {System.out.println("File not found!");}
		
		while ((ch=fr.read())!=-1) 
            System.out.print((char)ch); 

		fr.close(); 
	}
}

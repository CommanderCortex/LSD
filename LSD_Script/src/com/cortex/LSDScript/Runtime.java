package com.cortex.LSDScript;

public class Runtime {
	
	static String code = null;
	
	public static void main(String[] args) {
		sysout();
	}
	
	Runtime runtime = new Runtime();
	
	private static void sysout() {
		System.out.print(code);
	}
	
	FileHandler filehandler = new FileHandler();
}

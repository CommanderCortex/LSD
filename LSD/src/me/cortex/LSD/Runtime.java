package me.cortex.LSD;

import java.util.ArrayList;

import me.cortex.LSD.Block.Block;
import me.cortex.LSD.Block.Class;
import me.cortex.LSD.Block.Method;
import me.cortex.LSD.Parser.ClassParser;
import me.cortex.LSD.Parser.MethodParser;
import me.cortex.LSD.Parser.Parser;
import me.cortex.LSD.Parser.VariableParser;
import me.cortex.LSD.Tokenizer.Tokenizer;

public class Runtime {
	
	private ArrayList<Class> classes;
	
	public Runtime() {
		this.classes = new ArrayList<Class>();
		
		String code = "class HelloWorld" + "\n" + 
				"method main requires () returns void";

		Parser<?>[] parsers = new Parser<?>[] { new ClassParser(), new MethodParser(), new VariableParser() };

		Class main;
		
		Block block = null;
		
		boolean success = false;
		
		for (String line : code.split("\n")) {
			success = false;
			line = line.trim();
			Tokenizer tokenizer = new Tokenizer(line);
				
			for (Parser<?> parser : parsers) {
				if (parser.shouldParse(line)) {
					block = parser.parse(block, tokenizer);
					
					if (block instanceof Class) {
						classes.add((Class) block);
					}
					
					success = true;
					break;
				}
			}
			
			if(!success) {
				throw new IllegalArgumentException("Invalid line" + line);
			}
		}
		
		for (Class c : classes) {
			for(Block b : c.getSubBlocks()) {
				if(b instanceof Method) {
					Method method = (Method) b;
					if(method.getName().equals("main") && method.getType().equals("void") && method.getParameters().length == 0) {
						main = c;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Runtime();
	}
}






















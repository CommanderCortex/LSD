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
		
		String code = "class Variables \n" + 
				"\n" + 
				"	method main requires () returns void\n" + 
				"		string str = getString()\n" + 
				"		printString(str)\n" + 
				"	\n" + 
				"	method printString requires (String str) returns void\n" + 
				"		print str\n" + 
				"	\n" + 
				"	method getString requires () String string\n" + 
				"		return \"Hello\"\n" + 
				"		"; 
				
		Parser<?>[] parsers = new Parser<?>[] { new ClassParser(), new MethodParser(), new VariableParser() };

		Class main = null;
		
		Block block = null;
		
		boolean success = false;
		
		for (String line : code.split("\n")) {
			success = false;
			line = line.trim();
			Tokenizer tokenizer = new Tokenizer(line);
				
			for (Parser<?> parser : parsers) {
				if (parser.shouldParse(line)) {
					Block newBlock = parser.parse(block, tokenizer);
					
					if (newBlock instanceof Class) {
						classes.add((Class) newBlock);
					}
					
					else  {
						block.addBlock(newBlock);
					}
					
					block = newBlock;
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
				//System.out.println("Found Block " + b.getClass().getSimpleName());
				if(b instanceof Method) {
					Method method = (Method) b;
					if(method.getName().equals("main") && method.getType().equals("void") && method.getParameters().length == 0) {
						main = c;
					}
				}
			}
		}
		if(main == null) {
			throw new IllegalStateException("No Main Method Found");
		}
	
		main.run();
		
		//System.out.println("Main CLass: " + main.getName());
	}
	@SuppressWarnings("unused")
	private String toString(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		new Runtime();
	}
}






















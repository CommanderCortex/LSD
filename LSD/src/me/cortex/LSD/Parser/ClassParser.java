package me.cortex.LSD.Parser;

import me.cortex.LSD.Block.Block;
import me.cortex.LSD.Block.Class;
import me.cortex.LSD.Tokenizer.Tokenizer;

public class ClassParser extends Parser<Class> {

	@Override
	public boolean shouldParse(String line) {
		return line.matches("class [a-zA-Z][a-zA-Z0-9]*");
	}

	@Override
	public Class parse(Block superBlock, Tokenizer tokenizer) {
		tokenizer.nextToken();
		
		String name = tokenizer.nextToken().getToken();
		
		return new Class(name);
	}

}

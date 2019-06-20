package me.cortex.LSD.Parser;

import me.cortex.LSD.Block.Block;
import me.cortex.LSD.Tokenizer.Tokenizer;

public abstract class Parser<T extends Block> {
	
	public abstract boolean shouldParse(String line);
	
	public abstract T parse(Block superBlock, Tokenizer tokenizer);

}

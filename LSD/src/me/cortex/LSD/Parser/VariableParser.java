package me.cortex.LSD.Parser;

import me.cortex.LSD.Block.Block;
import me.cortex.LSD.Block.VariableBlock;
import me.cortex.LSD.Tokenizer.Token;
import me.cortex.LSD.Tokenizer.TokenType;
import me.cortex.LSD.Tokenizer.Tokenizer;

public class VariableParser extends Parser<Block> {

	@Override
	public boolean shouldParse(String line) {
		return line.matches("var [a-zA-Z]+ [a-zA-Z]+ = \"?[a-zA-Z0-9]\"?");
	}
	

	@Override
	public Block parse(Block superBlock, Tokenizer tokenizer) {
		tokenizer.nextToken();
				
		String type = tokenizer.nextToken().getToken();	
			
		String name = tokenizer.nextToken().getToken();
		
		tokenizer.nextToken();
				
		Token v = tokenizer.nextToken();
		Object value = null;
		
		if(v.getType() == TokenType.INTEGER_LITERAL) {
			value = Integer.valueOf(v.getToken());
		}
		
		else if (v.getType() == TokenType.STRING_LITERAL){
			value = v.getToken();
		}
		else {
			value = superBlock.getVariable(v.getToken()); //Get Value??
		}
		
		return new VariableBlock(superBlock, type, name, value);
	}
}

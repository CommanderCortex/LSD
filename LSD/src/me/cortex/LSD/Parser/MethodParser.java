package me.cortex.LSD.Parser;

import java.util.ArrayList;

import me.cortex.LSD.Parameter;
import me.cortex.LSD.Type;
import me.cortex.LSD.Block.Block;
import me.cortex.LSD.Block.Method;
import me.cortex.LSD.Tokenizer.Token;
import me.cortex.LSD.Tokenizer.Tokenizer;

public class MethodParser extends Parser<Method>{

	@Override
	public boolean shouldParse(String line) {
		return line.matches("method [a-zA-Z][a-zA-Z0-9]* requires \\(([a-zA-Z][a-zA-Z0-9]* [a-zA-Z][a-zA-Z0-9]*)*\\) returns [a-zA-Z][a-zA-Z0-9]*");
	}

	@Override
	public Method parse(Block superBlock, Tokenizer tokenizer) {
		tokenizer.nextToken();		
		String name = tokenizer.nextToken().getToken();
		tokenizer.nextToken();
		tokenizer.nextToken();

		Token first = tokenizer.nextToken();

		ArrayList<Parameter> params = new ArrayList<>();


		if(!first.getToken().equals(")")) {
			String[] ParamData = new String[] {first.getToken(), null};

			while(tokenizer.hasNextToken()) {
				Token token = tokenizer.nextToken();
				if(token.getToken().equals(")")) {
					break;
				}

				if(ParamData[0] == null) {
					ParamData[0] = token.getToken();
				}

				else {
					ParamData[1] = token.getToken();
					params.add(new Parameter(Type.valueOf(ParamData[0].toUpperCase()), ParamData[1]));
					ParamData = new String[2];

				}
			}
		}
		
		tokenizer.nextToken();
		
		Type returnType = Type.valueOf(tokenizer.nextToken().getToken().toUpperCase());
		
		return new Method(superBlock, name, returnType, params.toArray(new Parameter[params.size()]));
	}
}





















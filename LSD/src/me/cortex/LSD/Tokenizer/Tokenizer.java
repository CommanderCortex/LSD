package me.cortex.LSD.Tokenizer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
	
	private ArrayList<TokenData> TokenDatas;	
	
	private String str;
	
	private Token lastToken;
	
	private boolean pushBack;
	
	public Tokenizer(String str) {
		this.TokenDatas = new ArrayList<TokenData>();
		this.str = str;
		
		TokenDatas.add(new TokenData(Pattern.compile("^([a-zA-z][a-zA-z0-9]*)"), TokenType.IDENTIFIER));
		TokenDatas.add(new TokenData(Pattern.compile("^((-)?[0-9]+)"), TokenType.INTEGER_LITERAL));
		TokenDatas.add(new TokenData(Pattern.compile("^(\".*\")"), TokenType.STRING_LITERAL));
		
		for(String t : new String[] { "=", "\\(", "\\)", "\\.", "\\," }) {
			TokenDatas.add(new TokenData(Pattern.compile("^(" + t + ")"), TokenType.TOKEN));
		}

	}
	public Token nextToken() {
		str = str.trim();
		
		
		if(pushBack) {
			pushBack = false;
			return lastToken;
		}
		if (str.isEmpty()) {
			return (lastToken = new Token("", TokenType.EMPTY, TokenDatas));
		}
		
		for(TokenData data : TokenDatas) {
			Matcher matcher = data.getPattern().matcher(str);
			
			if(matcher.find()) {
				String token = matcher.group().trim();
				str = matcher.replaceFirst("");
				
				if (data.getType() == TokenType.STRING_LITERAL) {
					return (lastToken = new Token(token.substring(1, token.length() - 1), TokenType.STRING_LITERAL, data));
				} else {
					return(lastToken = new Token(token, data.getType(), data));
				}
			}
		}
		
		throw new IllegalStateException("Could Not Understand" + str);

	}
	
	public boolean hasNextToken() {
		return !str.isEmpty();
	}
	
	public void pushBack() {
		if(lastToken != null) {
			this.pushBack = true;
		}
	}
}














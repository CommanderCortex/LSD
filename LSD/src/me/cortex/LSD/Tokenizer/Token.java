package me.cortex.LSD.Tokenizer;

public class Token {
	
	private String token;
	private TokenType type;
	private Object value;

	
	public Token(String token, TokenType type, Object value) {
		this.token = token;
		this.type = type;
		this.value = value;

	}
	
	public String getToken() {
		return token;
	}
	
	public Object getValue() {
		return value;
	}
	
	public TokenType getType() {
		return type;
	}
	
}

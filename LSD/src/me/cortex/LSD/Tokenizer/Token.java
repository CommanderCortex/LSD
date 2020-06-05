package me.cortex.LSD.Tokenizer;

public class Token {
	
	private String token;
	private TokenType type;
	private Object value;
	private PermmissionFunction permFunc;
	
	public Token(String token, TokenType type, Object value, PermmissionFunction perms) {
		this.token = token;
		this.type = type;
		this.value = value;
		this.setPermFunc(perms);

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

	public PermmissionFunction getPermFunc() {
		return permFunc;
	}

	public void setPermFunc(PermmissionFunction permFunc) {
		this.permFunc = permFunc;
	}
	
}

package me.cortex.LSD.Tokenizer;

public enum TokenType {
	
	//Ignore
	EMPTY,
	
	// Example ( ) =
	TOKEN,
	
	// Letter followed by, letters and or numbers.
	IDENTIFIER,
	
	
	// A Number
	INTEGER_LITERAL,
	
	// Anything Enclosed in " " : "Hello"
	STRING_LITERAL,

}

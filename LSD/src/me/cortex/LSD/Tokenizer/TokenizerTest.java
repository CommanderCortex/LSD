package me.cortex.LSD.Tokenizer;

public class TokenizerTest {
	
	public static void main(String[] args) {
		String code =
				"class HelloWorld\n" + 
				"	\n" + 
				"	method Main requires ()\n" + 
				"		print \"Hello World\""
				
				;
		
	Tokenizer tokenizer = new Tokenizer(code);
	
	while (tokenizer.hasNextToken()) {
		System.out.println(tokenizer.nextToken().getToken());
	}

	}		
	

}
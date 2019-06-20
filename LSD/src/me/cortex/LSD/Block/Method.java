package me.cortex.LSD.Block;

import me.cortex.LSD.Parameter;
import me.cortex.LSD.Type;
import me.cortex.LSD.Value;

public class Method extends Block {
	
	private String name;
	private Type type;
	private Parameter[] params;
	private Value returnValue;

	public Method(Block superBlock, String name, Type type, Parameter[] params) {
		super(superBlock);
		
		this.name = name;
		this.type = type;
		this.params = params;
	}
	
	
	@Override
	public void run() {
		invoke();
	}
	
	public void invoke(Value... values) {
		
	}

}

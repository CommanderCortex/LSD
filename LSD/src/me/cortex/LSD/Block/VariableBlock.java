package me.cortex.LSD.Block;

import me.cortex.LSD.BuiltInType;
import me.cortex.LSD.Type;
import me.cortex.LSD.Variable;

public class VariableBlock extends Block {
	
	private String type, name;
	private Object value;

	public VariableBlock(Block superBlock, String name, String type, Object value) {
		super(superBlock);
		
		this.name = name;
		this.type = type;
		this.value = value;
	}

	@Override
	public void run() {
		Type t = Type.match(type);	
		if(t == BuiltInType.VOID) {
			throw new IllegalStateException("Cannot Declare Varaible of type void");
		}
		getSuperBlock().addVariable(new Variable(getSuperBlock(), t, name, value));
	}

}

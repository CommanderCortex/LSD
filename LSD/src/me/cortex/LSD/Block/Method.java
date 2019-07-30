package me.cortex.LSD.Block;

import me.cortex.LSD.Parameter;
import me.cortex.LSD.Type;
import me.cortex.LSD.Value;
import me.cortex.LSD.Variable;

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
	
	String ParamValues = "Wrong Number Of Values For Params";
	
	public Value invoke(Value... values) {
		if(values.length != params.length) {
			throw new IllegalArgumentException(ParamValues);
		}
		for (int i = 0; i < values.length && i < params.length; i++) {
			Parameter p = params[i];
			Value v = values[i];
			
			if(p.getType() != v.getType()) {
				throw new IllegalStateException("Param: " + p.getName() + " should be " + p.getType() + ". Got " + v.getType());
			}
			addVariable(new Variable(this, p.getType(), p.getName(), v.getValue()));
		}
		
		for(Block b : getSubBlocks()) {
			b.run();
			
			if(returnValue != null) {
				break;
			}
		}
		if(returnValue == null && type != Type.VOID) {
			throw new IllegalStateException("Expected Return Value");
		}
		
		Value localReturnValue = returnValue;
		returnValue = null;
		return localReturnValue;
	}

}













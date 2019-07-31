package me.cortex.LSD;

public class Parameter {
	
	private String name;
	private BuiltInType type;
	
	public Parameter(BuiltInType type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public String getName() {
		return name;
		
	}

	public BuiltInType getType() {
		return type;
	}
}

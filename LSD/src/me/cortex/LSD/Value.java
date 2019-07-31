package me.cortex.LSD;

public class Value {
	
	private BuiltInType type;
	private Object value;
	
	public Value(BuiltInType type, Object value) {
		this.type = type;
		this.value = value;
	}
	
	public BuiltInType getType() {
		return type;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

}

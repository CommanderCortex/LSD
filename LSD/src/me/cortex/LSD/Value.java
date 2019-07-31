package me.cortex.LSD;

public class Value {
	
	private Type type;
	private Object value;
	
	public Value(Type type2, Object value) {
		this.type = type2;
		this.value = value;
	}
	
	public Type getType() {
		return type;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

}

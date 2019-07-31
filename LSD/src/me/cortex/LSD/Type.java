package me.cortex.LSD;

public interface Type {
	
	public static Type match(String str) {
		try {
			return BuiltInType.valueOf(str.toUpperCase());
		} catch (Exception e) {
			return null;
		}
	}

}

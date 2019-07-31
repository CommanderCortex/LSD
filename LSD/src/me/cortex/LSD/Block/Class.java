package me.cortex.LSD.Block;

import me.cortex.LSD.Type;

public class Class extends Block implements Type {
	
	private String name;

	public Class(String name) {
		super(null);
		
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void run() {
		
	}
	
	
}

package me.cortex.LSD.Block;

import java.util.ArrayList;

import me.cortex.LSD.Variable;

public abstract class Block {
	
	private Block superBlock;	
	private ArrayList<Block> subBlocks;
	private ArrayList<Variable> variables;
	
	public Block(Block superBlock) {
		this.superBlock = superBlock;
		this.subBlocks = new ArrayList<>();
		this.variables = new ArrayList<>();
	}
	
	public Block getSuperBlock() {
		return superBlock;
	}
	
	public void addBlock(Block block) {
		subBlocks.add(block);
	}
	
	
	public Variable getVariable(String name) {
		
		
		for(Variable v : variables) {
			if (v.getName().equals(name)){
				return v;
			}
		}
		
		return null;
	}
	
	public void addVariable(Variable v) {
		variables.add(v);
	}
	
	public abstract void run();
	
}



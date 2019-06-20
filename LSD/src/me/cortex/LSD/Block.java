package me.cortex.LSD;

import java.util.ArrayList;

public class Block {
	
	private Block superBlock;	
	private ArrayList<Block> subBlocks;
	
	public Block(Block superBlock) {
		this.superBlock = superBlock;
		this.subBlocks = new ArrayList<>();
	}
	
	public Block getSuperBlock() {
		return superBlock;
	}
	
	
}



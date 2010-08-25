package com.tictactoe;
import static com.tictactoe.Square.*; 

public class Block extends TwoInARow{

	public Position findBlockMove(Board board) {
		return findEmptyThirdPositionAfterTwoInARow(board, O);
	}

	
	
}

package com.tictactoe;
import static com.tictactoe.Square.*; 

public class Block extends Strategy{

	public Position findBlockMove(Board board) {
		Position coordinates = twoInARowDown(board, O);
		if (coordinates != null) {
			return coordinates;
		}
		coordinates = twoInARowAcross(board, O);
		if (coordinates != null) {
			return coordinates;
		}
		coordinates = twoDownDiagonal(board, O);
		if (coordinates != null){
			return coordinates;
		}
		return twoUpDiagonal(board, O);
	}
	
}

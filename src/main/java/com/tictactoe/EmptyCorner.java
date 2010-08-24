package com.tictactoe;
import static com.tictactoe.Square.*; 

public class EmptyCorner {

	public Position markEmptyCorner(Board board) {
		if(board.getBoard()[0][0] == EMPTY) {
			return new Position(0,0);
		}
		
		if(board.getBoard()[2][0] == EMPTY) {
			return new Position(2,0);
		}
		
		if(board.getBoard()[0][2] == EMPTY) {
			return new Position(0,2);
		}
		
		if(board.getBoard()[2][2] == EMPTY) {
			return new Position(2,2);
		}
		
		return null;
	}

}

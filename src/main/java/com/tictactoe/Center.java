package com.tictactoe;
import static com.tictactoe.Square.*; 

public class Center {
	
	public Position playTheCenter(Board board) {
		if(board.getBoard()[1][1] == EMPTY) {
			return new Position(1,1); 
		}
		return null;
	}
}

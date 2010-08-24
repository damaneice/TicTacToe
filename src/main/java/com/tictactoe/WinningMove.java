package com.tictactoe;
import static com.tictactoe.Square.X;

public class WinningMove extends Strategy{
	
	public Position findWinningMove(Board board) {
		Position coordinates = twoInARowDown(board, X);
		if (coordinates != null) {
			return coordinates;
		}
		coordinates = twoInARowAcross(board, X);
		if (coordinates != null) {
			return coordinates;
		}
		coordinates = twoDownDiagonal(board, X);
		if (coordinates != null){
			return coordinates;
		}
		return twoUpDiagonal(board, X);
	}
}

package com.tictactoe;
import static com.tictactoe.Square.X;

public class WinningMove extends TwoInARow{
	
	public Position findWinningMove(Board board) {
		return findEmptyThirdPositionAfterTwoInARow(board, X);
	}
}

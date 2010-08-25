package com.tictactoe;
import static com.tictactoe.Square.*; 
public class TwoInARow {
	
	protected Position findEmptyThirdPositionAfterTwoInARow(Board board,
			Square typeOfMark) {
		Position position = twoInARowDown(board, typeOfMark);
		if (position != null) {
			return position;
		}
		position = twoInARowAcross(board, typeOfMark);
		if (position != null) {
			return position;
		}
		position = twoDownDiagonal(board, typeOfMark);
		if (position != null){
			return position;
		}
		return twoUpDiagonal(board, typeOfMark);
	}
	
	private Position twoInARowDown(Board board, Square mark) {
		Position position = new Position(0,0);
		for (int x = 0; x < Board.SIZE; x++) {
			int numberOfMarks = 0;
			int numberOfSpaces = 0;

			for (int y = 0; y < Board.SIZE; y++) {
				if (board.getBoard()[x][y] == mark) {
					numberOfMarks++;
				} else if (board.getBoard()[x][y] == EMPTY) {
					numberOfSpaces++;
					position.setX(x);
					position.setY(y);
				}
			}
			if (numberOfMarks == 2 && numberOfSpaces == 1)
				return position;
		}

		return null;
	}

	private Position twoInARowAcross(Board board, Square mark) {
		Position position = new Position(0,0);
		for (int y = 0; y < Board.SIZE; y++) {
			int numberOfMarks = 0;
			int numberOfSpaces = 0;

			for (int x = 0; x < Board.SIZE; x++) {
				if (board.getBoard()[x][y] == mark) {
					numberOfMarks++;
				} else if (board.getBoard()[x][y] == EMPTY) {
					numberOfSpaces++;
					position.setX(x);
					position.setY(y);
				}
			}
			if (numberOfMarks == 2 && numberOfSpaces == 1)
				return position;
		}

		return null;
	}

	private Position twoDownDiagonal(Board board, Square mark) {
		int numberOfMarks = 0;
		int numberOfSpaces = 0;
		Position position = new Position(0,0);
		for (int x = 0, y = 0; x < Board.SIZE; x++, y++) {
			if (board.getBoard()[x][y] == mark) {
				numberOfMarks++;
			} else if (board.getBoard()[x][y] == EMPTY) {
				numberOfSpaces++;
				position.setX(x);
				position.setY(y);
			}
		}
		if (numberOfMarks == 2 && numberOfSpaces == 1)
			return position;

		return null;
	}
	
	private Position twoUpDiagonal(Board board, Square mark) {;
		int numberOfMarks = 0;
		int numberOfSpaces = 0;
		Position position = new Position(0,0);
		for (int x = 0, y = 2; x < Board.SIZE; x++, y--) {
			if (board.getBoard()[x][y] == mark) {
				numberOfMarks++;
			} else if (board.getBoard()[x][y] == EMPTY) {
				numberOfSpaces++;
				position.setX(x);
				position.setY(y);
			}
		}
		if (numberOfMarks == 2 && numberOfSpaces == 1)
			return position;
		
		return null;
	}


}

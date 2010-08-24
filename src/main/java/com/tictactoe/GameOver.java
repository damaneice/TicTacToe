package com.tictactoe;

public class GameOver {

	private Board board;
	private int numberOfMoves;

	public GameOver(Board board) {
		this.board = board;
	}

	public boolean win(Square typeOfMark) {

		return hasWinInColumn(typeOfMark) || hasWinInRow(typeOfMark)
				|| hasWinInDownDiagonal(typeOfMark)
				|| hasWinInUpDiagonal(typeOfMark);
	}

	private boolean hasWinInDownDiagonal(Square typeOfMark) {
		Square[] diagonal = board.extractDownDiagonal();
		if (isWinInSection(diagonal, typeOfMark))
			return true;

		return false;
	}

	private boolean hasWinInUpDiagonal(Square typeOfMark) {
		Square[] diagonal = board.extractUpDiagonal();
		if (isWinInSection(diagonal, typeOfMark))
			return true;

		return false;
	}

	private boolean hasWinInRow(Square typeOfMark) {
		for (int rowNumber = 0; rowNumber < board.getBoard().length; rowNumber++) {
			Square[] row = board.extractRow(rowNumber);
			if (isWinInSection(row, typeOfMark))
				return true;
		}
		return false;
	}

	private boolean hasWinInColumn(Square typeOfMark) {
		for (int columnNumber = 0; columnNumber < board.getBoard().length; columnNumber++) {
			Square[] column = board.extractColumn(columnNumber);
			if (isWinInSection(column, typeOfMark))
				return true;
		}
		return false;
	}

	private boolean isWinInSection(Square[] column, Square typeOfMark) {
		int numberOfMarks = board.countOfNumberOfMarks(column, typeOfMark);

		if (numberOfMarks == 3)
			return true;
		return false;
	}

	public void incrementNumberOfMoves() {
		numberOfMoves++;
		System.out.println("Number of moves: " + numberOfMoves);
	}
	
	public boolean isBoardFull(){
		return numberOfMoves == 9;
	}
}

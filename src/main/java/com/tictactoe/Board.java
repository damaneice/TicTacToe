package com.tictactoe;
import static com.tictactoe.Square.*; 

public class Board {
	public final static int SIZE = 3;
	private Square[][] board = new Square[SIZE][SIZE];
	
	public Board(){
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				board[x][y] = EMPTY;
			}
		}
	}
	
	public void setBoard(Square[][] board) {
		this.board = board;
	}
	
	public Square[][] getBoard() {
		return board;
	}
	
	public Square[] extractColumn(int columnNumber) {
		return getBoard()[columnNumber];
	}

	public Square[] extractRow(int rowNumber) {
		Square [] row = new Square[SIZE];
		for (int i = 0; i < SIZE; i++){
			row[i] = getBoard()[i][rowNumber];
		}
		return row;
	}
	
	public Square[] extractDownDiagonal() {
		Square [] diagonal = new Square[SIZE];
		for (int i = 0; i < SIZE; i++){
			diagonal[i] = getBoard()[i][i];
		}
		return diagonal;
	}
	
	public Square[] extractUpDiagonal() {
		Square[] diagonal = new Square[SIZE];
		for (int x = 0, y = SIZE - 1; x < SIZE; x++, y--){
			diagonal[x] = getBoard()[x][y];
		}
		return diagonal;
	}
	
	public int countOfNumberOfMarks(Square[] boardSection, Square typeOfMark) {
		int numberOfMarks = 0;
		for (Square s : boardSection) {
			if (s == typeOfMark) {
				numberOfMarks++;
			}
		}
		return numberOfMarks;
	}
}	

package com.tictactoe;
import static com.tictactoe.Square.*; 

public class Board {

	private Square[][] board = new Square[3][3];
	
	public Board(){
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
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
		Square [] row = new Square[3];
		for (int i = 0; i < getBoard().length; i++){
			row[i] = getBoard()[i][rowNumber];
		}
		return row;
	}
	
	public Square[] extractDownDiagonal() {
		Square [] diagonal = new Square[3];
		for (int i = 0; i < getBoard().length; i++){
			diagonal[i] = getBoard()[i][i];
		}
		return diagonal;
	}
	
	public Square[] extractUpDiagonal() {
		Square[] diagonal = new Square[3];
		for (int x = 0, y = 2; x < getBoard().length; x++, y--){
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
	
	public void print() {
		for (int y = 0; y < board.length; y++) {
			System.out.print(" ");
			for (int x = 0; x < board.length; x++) {
				if (board[x][y] != EMPTY) {
					System.out.print(board[x][y]);
				}
				else {
					System.out.print(" ");
				}
				if((x+1)%3 != 0) {
					System.out.print(" | ");
				}
			}
			System.out.println();
		}
	}
}	

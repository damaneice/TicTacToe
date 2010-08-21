import java.util.List;


public class Board {

	private char[][] board = new char[3][3];
	
	public void setBoard(char[][] board) {
		this.board = board;
	}
	
	public char[][] getBoard() {
		return board;
	}
	
	public char[] extractRow(int rowNumber) {
		return getBoard()[rowNumber];
	}

	public char[] extractColumn(int columnNumber) {
		char [] column = new char[3];
		for (int i = 0; i < getBoard().length; i++){
			column[i] = getBoard()[i][columnNumber];
		}
		return column;
	}
	
	public char[] extractDownDiagonal() {
		char [] diagonal = new char[3];
		for (int i = 0; i < getBoard().length; i++){
			diagonal[i] = getBoard()[i][i];
		}
		return diagonal;
	}
	
	public char[] extractUpDiagonal() {
		char [] diagonal = new char[3];
		for (int x = 0, y = 2; x < getBoard().length; x++, y--){
			diagonal[x] = getBoard()[x][y];
		}
		return diagonal;
	}
	
	public int countOfNumberOfMarks(char[] boardSection, char typeOfMark) {
		int numberOfMarks = 0;
		for (char c : boardSection) {
			if (c == typeOfMark) {
				numberOfMarks++;
			}
		}
		return numberOfMarks;
	}
}

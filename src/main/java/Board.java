

public class Board {

	private char[][] board = new char[3][3];
	
	public Board(){
	}
	
	public void setBoard(char[][] board) {
		this.board = board;
	}
	
	public char[][] getBoard() {
		return board;
	}
	
	public char[] extractColumn(int columnNumber) {
		return getBoard()[columnNumber];
	}

	public char[] extractRow(int rowNumber) {
		char [] row = new char[3];
		for (int i = 0; i < getBoard().length; i++){
			row[i] = getBoard()[i][rowNumber];
		}
		return row;
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

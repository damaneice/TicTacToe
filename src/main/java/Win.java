public class Win {

	private char[][] board = new char[3][3];
	
	public Win(char[][] board){
		this.board = board;
	}

	public boolean win(char typeOfMark) {
		
		if (checkColumnForWin(typeOfMark))
			return true;
		
		if (checkRowForWin(typeOfMark))
			return true;
		
		if (checkDownDiagonalForWin(typeOfMark))
			return true;
		
		return false;
	}

	private boolean checkDownDiagonalForWin(char typeOfMark) {
			char[] diagonal = extractDownDiagonal();
			if(isWinInSection(diagonal, typeOfMark))
				return true;
			
		return false;
	}

	private boolean checkRowForWin(char typeOfMark) {
		for(int rowNumber = 0; rowNumber < board.length; rowNumber++){
			char[] row = extractRow(rowNumber);
			if(isWinInSection(row, typeOfMark))
				return true;
		}
		return false;
	}

	private boolean checkColumnForWin(char typeOfMark) {
		for(int columnNumber = 0; columnNumber < board.length; columnNumber++){
			char[] column = extractColumn(columnNumber);
			if(isWinInSection(column, typeOfMark))
				return true;
		}
		return false;
	}

	private char[] extractRow(int rowNumber) {
		return board[rowNumber];
	}
		

	private boolean isWinInSection(char[] column, char typeOfMark) {
		int numberOfMarks = countOfNumberOfMarks(column, typeOfMark);
		
		if (numberOfMarks == 3 )
			return true;
		return false;
	}

	public char[] extractColumn(int columnNumber) {
		char [] column = new char[3];
		for (int i = 0; i < board.length; i++){
			column[i] = board[i][columnNumber];
		}
		return column;
	}
	
	public char[] extractDownDiagonal() {
		char [] diagonal = new char[3];
		for (int i = 0; i < board.length; i++){
			diagonal[i] = board[i][i];
		}
		return diagonal;
	}
	
	private int countOfNumberOfMarks(char[] boardSection, char typeOfMark) {
		int numberOfMarks = 0;
		for (char c : boardSection) {
			if (c == typeOfMark) {
				numberOfMarks++;
			}
		}
		return numberOfMarks;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public char[][] getBoard() {
		return board;
	}
	

}

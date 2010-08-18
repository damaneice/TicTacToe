public class Win {

	private char[][] board = new char[3][3];
	
	public Win(char[][] board){
		this.board = board;
	}

	public boolean win() {
		
		for(int columnNumber = 0; columnNumber < board.length; columnNumber++){
			char[] column = extractColumn(columnNumber);
			if(winInSection(column))
				return true;
		}
		
		for(int rowNumber = 0; rowNumber < board.length; rowNumber++){
			char[] row = extractRow(rowNumber);
			if(winInSection(row))
				return true;
		}
		
		return false;
	}

	private boolean canWinInCenterColumn() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean canWinInLeftColumn() {
		char[] column = extractColumn(0);
		return winInSection(column);
	}
	
	private boolean canWinInTopRow() {
		char[] row = extractRow(0);
		return winInSection(row);
	}

	private char[] extractRow(int rowNumber) {
		return board[rowNumber];
	}
		

	private boolean winInSection(char[] column) {
		int numberOfMarks = countOfNumberOfMarks(column);
		int numberOfOpenSpaces = countNumberOfSpaces(column);
		
		if (numberOfMarks == 2 && numberOfOpenSpaces == 1)
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
	
	private int countNumberOfSpaces(char[] boardSection) {
		int numberOfOpenSpaces = 0;
		for (char c : boardSection) {
			if (c == 0) {
				numberOfOpenSpaces++;
			}
		}
		return numberOfOpenSpaces;
	}

	private int countOfNumberOfMarks(char[] boardSection) {
		int numberOfMarks = 0;
		for (char c : boardSection) {
			if (c == 'X') {
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

public class Win {

	private Board board;
	
	public Win(Board board){
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
			char[] diagonal = board.extractDownDiagonal();
			if(isWinInSection(diagonal, typeOfMark))
				return true;
			
		return false;
	}

	private boolean checkRowForWin(char typeOfMark) {
		for(int rowNumber = 0; rowNumber < board.getBoard().length; rowNumber++){
			char[] row = board.extractRow(rowNumber);
			if(isWinInSection(row, typeOfMark))
				return true;
		}
		return false;
	}

	private boolean checkColumnForWin(char typeOfMark) {
		for(int columnNumber = 0; columnNumber < board.getBoard().length; columnNumber++){
			char[] column = board.extractColumn(columnNumber);
			if(isWinInSection(column, typeOfMark))
				return true;
		}
		return false;
	}

	private boolean isWinInSection(char[] column, char typeOfMark) {
		int numberOfMarks = board.countOfNumberOfMarks(column, typeOfMark);
		
		if (numberOfMarks == 3 )
			return true;
		return false;
	}
}

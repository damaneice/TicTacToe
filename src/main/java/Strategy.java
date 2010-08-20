public class Strategy {

	public Coordinates findNextMove(Board board) {
		Coordinates coordinates = findWinningMove(board);
		if (coordinates != null){
			return coordinates;
		}
		return findBlockMove(board);
	}

	private Coordinates findWinningMove(Board board) {
		char mark = 'X';
		Coordinates coordinates = twoInARowDown(board, mark);
		if (coordinates != null) {
			return coordinates;
		}
		coordinates = twoInARowAcross(board, mark);
		if (coordinates != null) {
			return coordinates;
		}
		coordinates = twoDownDiagonal(board, mark);
		if (coordinates != null){
			return coordinates;
		}
		return twoUpDiagonal(board, mark);
	}
	
	private Coordinates findBlockMove(Board board) {
		char mark = 'O';
		Coordinates coordinates = twoInARowDown(board, mark);
		if (coordinates != null) {
			return coordinates;
		}
		coordinates = twoInARowAcross(board, mark);
		if (coordinates != null) {
			return coordinates;
		}
		coordinates = twoDownDiagonal(board, mark);
		if (coordinates != null){
			return coordinates;
		}
		return twoUpDiagonal(board, mark);
	}

	private Coordinates twoInARowDown(Board board, char mark) {

		for (int x = 0; x < board.getBoard().length; x++) {
			int location = 0;
			int numberOfMarks = 0;
			int numberOfSpaces = 0;

			for (int y = 0; y < board.getBoard().length; y++) {
				if (board.getBoard()[x][y] == mark) {
					numberOfMarks++;
				} else if (board.getBoard()[x][y] == 0) {
					numberOfSpaces++;
					location = y;
				}
			}
			if (numberOfMarks == 2 && numberOfSpaces == 1)
				return new Coordinates(x, location);
		}

		return null;
	}

	private Coordinates twoInARowAcross(Board board, char mark) {

		for (int y = 0; y < board.getBoard().length; y++) {
			int location = 0;
			int numberOfMarks = 0;
			int numberOfSpaces = 0;

			for (int x = 0; x < board.getBoard().length; x++) {
				if (board.getBoard()[x][y] == mark) {
					numberOfMarks++;
				} else if (board.getBoard()[x][y] == 0) {
					numberOfSpaces++;
					location = x;
				}
			}
			if (numberOfMarks == 2 && numberOfSpaces == 1)
				return new Coordinates(location, y);
		}

		return null;
	}

	private Coordinates twoDownDiagonal(Board board, char mark) {
		int numberOfMarks = 0;
		int numberOfSpaces = 0;
		int locationX = 0;
		int locationY = 0;
		for (int x = 0, y = 0; x < board.getBoard().length; x++, y++) {
			if (board.getBoard()[x][y] == mark) {
				numberOfMarks++;
			} else if (board.getBoard()[x][y] == 0) {
				numberOfSpaces++;
				locationX = x;
				locationY = y;
			}
		}
		if (numberOfMarks == 2 && numberOfSpaces == 1)
			return new Coordinates(locationX, locationY);

		return null;
	}
	private Coordinates twoUpDiagonal(Board board, char mark) {
		int numberOfMarks = 0;
		int numberOfSpaces = 0;
		int locationX = 0;
		int locationY = 0;
		for (int x = 0, y = 2; x < board.getBoard().length; x++, y--) {
			if (board.getBoard()[x][y] == mark) {
				numberOfMarks++;
			} else if (board.getBoard()[x][y] == 0) {
				numberOfSpaces++;
				locationX = x;
				locationY = y;
			}
		}
		if (numberOfMarks == 2 && numberOfSpaces == 1)
			return new Coordinates(locationX, locationY);
		
		return null;
	}

}

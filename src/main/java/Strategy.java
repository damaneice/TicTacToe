import java.util.ArrayList;
import java.util.List;

public class Strategy {

	public Position findNextMove(Board board) {
		Position coordinates = findWinningMove(board);
		if (coordinates != null){
			return coordinates;
		} 
		return findBlockMove(board);
	}

	private Position findWinningMove(Board board) {
		char mark = 'X';
		Position coordinates = twoInARowDown(board, mark);
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
	
	private Position findBlockMove(Board board) {
		char mark = 'O';
		Position coordinates = twoInARowDown(board, mark);
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

	private Position twoInARowDown(Board board, char mark) {

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
				return new Position(x, location);
		}

		return null;
	}

	private Position twoInARowAcross(Board board, char mark) {

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
				return new Position(location, y);
		}

		return null;
	}

	private Position twoDownDiagonal(Board board, char mark) {
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
			return new Position(locationX, locationY);

		return null;
	}
	
	private Position twoUpDiagonal(Board board, char mark) {
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
			return new Position(locationX, locationY);
		
		return null;
	}
	
	public List<Position> findPotentialForkInRow(Board board, int rowNumber, char mark) {
		List<Position> positions = new ArrayList<Position>();
		int numberOfEmptyBoxes = 0;
		int numberOfMarks = 0;
		for (int x = 0; x < board.getBoard().length; x++){
			char box = board.getBoard()[x][rowNumber];
			if (box == 0){
				numberOfEmptyBoxes++;
				positions.add(new Position(x,rowNumber));
			}
			else if(box == mark){
				numberOfMarks++;
			}
		}
		if (numberOfMarks == 1 && numberOfEmptyBoxes == 2){
			return positions;
		}
		return null;
	}
	
	public List<Position> findPotentialForkInColumn(Board board, int columnNumber, char mark) {
		List<Position> positions = new ArrayList<Position>();
		int numberOfEmptyBoxes = 0;
		int numberOfMarks = 0;
		for (int y = 0; y < board.getBoard().length; y++){
			char box = board.getBoard()[columnNumber][y];
			if (box == 0){
				numberOfEmptyBoxes++;
				positions.add(new Position(columnNumber,y));
			}
			else if(box == mark){
				numberOfMarks++;
			}
		}
		if (numberOfMarks == 1 && numberOfEmptyBoxes == 2){
			return positions;
		}
		return null;
	}

	public List<Position> findPotentialForkInDownDiagonal(Board board, char mark) {
		List<Position> positions = new ArrayList<Position>();
		int numberOfEmptyBoxes = 0;
		int numberOfMarks = 0;
		for (int i = 0; i < board.getBoard().length; i++) {
			char box = board.getBoard()[i][i];
			if (box == 0) {
				numberOfEmptyBoxes++;
				positions.add(new Position(i, i));
			} else if (box == mark) {
				numberOfMarks++;
			}
		}
		if(numberOfEmptyBoxes == 2 && numberOfMarks == 1){
			return positions;
		}

		return null;
	} 

	public List<Position> findPotentialForkInUpDiagonal(Board board, char mark) {
		List<Position> positions = new ArrayList<Position>();
		int numberOfEmptyBoxes = 0;
		int numberOfMarks = 0;
		for (int x = 0, y = 2; x < board.getBoard().length; x++, y--) {
			char box = board.getBoard()[x][y];
			if (box == 0) {
				numberOfEmptyBoxes++;
				positions.add(new Position(x, y));
			} else if (box == mark) {
				numberOfMarks++;
			}
		}
		if(numberOfEmptyBoxes == 2 && numberOfMarks == 1){
			return positions;
		}
		return null;
	}

}

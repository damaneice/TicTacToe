

public class OppositeCorner {
	

	public Position playOppositeCorner(Board board) {
		Position cornerMark = findCornerMark(board);
		return findOppositeCornerMove(board, cornerMark);
	}

	private Position findOppositeCornerMove(Board board, Position cornerMark) {
		int locationX = cornerMark.getX() + 1;
		char oppositeCorner = board.getBoard()[locationX][cornerMark.getY()]; 
		if (oppositeCorner == 0){
			return new Position(locationX, cornerMark.getY());
		}
		int locationY = cornerMark.getY() + 1;
		oppositeCorner = board.getBoard()[cornerMark.getX()][locationY];
		if (oppositeCorner == 0){
			return new Position(cornerMark.getX(), locationY);
		}
		return null;
	}

	private Position findCornerMark(Board board) {
		if (board.getBoard()[0][0] == 'O'){
			return new Position(0,0);
		}
		if (board.getBoard()[2][0] == 'O'){
			return new Position(2,0);
		}
		if (board.getBoard()[0][2] == 'O'){
			return new Position(0,2);
		}
		if (board.getBoard()[2][2] == 'O'){
			return new Position(2,2);
		}
		return null;
	}

}

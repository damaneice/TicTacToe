

public class OppositeCorner {
	

	public Position playOppositeCorner(Board board) {
		Position cornerMark = findCornerMark(board);
		return findOppositeCornerMove(board, cornerMark);
	}

	private Position findOppositeCornerMove(Board board, Position cornerMark) {
		if (new Position(0,0).equals(cornerMark)) {
			return findOppositeCornerForTopLeft(board);
		}
		if (new Position(2,0).equals(cornerMark)) {
			return findOppositeCornerForTopRight(board);
		}
		if (new Position(0,2).equals(cornerMark)) {
			return findOppositeCornerForBottomLeft(board);
		}
		if (new Position(2,2).equals(cornerMark)) {
			return findOppositeCornerForBottomRight(board);
		}
		return null;
	}

	private Position findOppositeCornerForBottomRight(Board board) {
		char oppositeCorner = board.getBoard()[1][2]; 
		if (oppositeCorner == 0){
			return new Position(1, 2);
		}
		oppositeCorner = board.getBoard()[2][1];
		if (oppositeCorner == 0){
			return new Position(2, 1);
		}
		return null;
	}

	private Position findOppositeCornerForBottomLeft(Board board) {
		char oppositeCorner = board.getBoard()[2][1]; 
		if (oppositeCorner == 0){
			return new Position(2, 1);
		}
		oppositeCorner = board.getBoard()[0][1];
		if (oppositeCorner == 0){
			return new Position(0, 1);
		}
		return null;
	}

	private Position findOppositeCornerForTopRight(Board board) {
		char oppositeCorner = board.getBoard()[1][0]; 
		if (oppositeCorner == 0){
			return new Position(1, 0);
		}
		oppositeCorner = board.getBoard()[2][1];
		if (oppositeCorner == 0){
			return new Position(2, 1);
		}
		return null;
	}

	private Position findOppositeCornerForTopLeft(Board board) {
		char oppositeCorner = board.getBoard()[1][0]; 
		if (oppositeCorner == 0){
			return new Position(1, 0);
		}
		oppositeCorner = board.getBoard()[0][1];
		if (oppositeCorner == 0){
			return new Position(0, 1);
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

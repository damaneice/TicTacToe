
public class EmptySide {

	public Position markMiddleSquareOnEmptySide(Board board) {
		
		if (hasEmptyLeftSide(board)) {
			return new Position(0,1);
		}
		if (hasEmptyTopSide(board)) {
			return new Position(1,0);
		}
		if (hasEmptyBottomSide(board)) {
			return new Position(1,2);
		}
		if (hasEmptyRightSide(board)) {
			return new Position(2,1);
		}
		return null;
	}

	private boolean hasEmptyRightSide(Board board) {
		return isEmptySide(board.extractColumn(2));
	}

	private boolean hasEmptyBottomSide(Board board) {
		return isEmptySide(board.extractRow(2));
	}

	private boolean hasEmptyTopSide(Board board) {
		return isEmptySide(board.extractRow(0));
	}

	private boolean hasEmptyLeftSide(Board board) {
		return isEmptySide(board.extractColumn(0));
	}

	private Boolean isEmptySide(char[] side) {
		int numberOfEmptySqaures = 0;
		for (int i = 0; i < 3; i++) {
			if (side[i] == 0) {
				numberOfEmptySqaures++;
			}
		}
		if (numberOfEmptySqaures == 3) {
			return true;
		}
		return false;
	}
}

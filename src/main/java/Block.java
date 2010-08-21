
public class Block extends Strategy{

	public Position findBlockMove(Board board) {
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
	
}

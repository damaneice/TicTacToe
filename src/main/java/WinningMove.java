
public class WinningMove extends Strategy{
	
	public Position findWinningMove(Board board) {
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
}


public class Center {
	
	public Position playTheCenter(Board board) {
		if(board.getBoard()[1][1] == 0) {
			return new Position(1,1); 
		}
		return null;
	}
}

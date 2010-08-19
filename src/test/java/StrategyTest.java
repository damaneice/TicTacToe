import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;


public class StrategyTest {
	private char[][] board = new char[3][3];
	
	@Test
	public void shouldFindWinningMoveInRowWithTwoConsecutiveMarks() throws Exception {
		board[0][0] = 'X';
		board[0][1] = 'X';
		
		Coordinates coordinates = findWinningMove(board);
		
		
		
		assertThat(coordinates.getX(), is(0));
		assertThat(coordinates.getY(), is(2));
	}

	private Coordinates findWinningMove(char[][] board) {
		return null;
	}
	
}

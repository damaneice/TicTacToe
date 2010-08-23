import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class EmptySideTest {
	
	private Board board;
	private EmptySide emptySide;

	@Before
	public void setUp() {
		emptySide = new EmptySide();
	}
	
	@Test
	public void shouldMarkMiddleSquareOnLeftSide() throws Exception {
		board = new Board();
		board.getBoard()[2][0] = 'X';
		board.getBoard()[2][2] = 'X';
		assertThat(emptySide.markMiddleSquareOnEmptySide(board), is(new Position(0,1)));
	}
	
	@Test
	public void shouldMarkMiddleSquareOnTopSide() throws Exception {
		board = new Board();
		board.getBoard()[0][1] = 'X';
		board.getBoard()[2][2] = 'X';
		
		assertThat(emptySide.markMiddleSquareOnEmptySide(board), is(new Position(1,0)));
	}
	
	@Test
	public void shouldMarkMiddleSquareOnBottomSide() throws Exception {
		board = new Board();
		board.getBoard()[0][1] = 'X';
		board.getBoard()[1][0] = 'X';
		
		assertThat(emptySide.markMiddleSquareOnEmptySide(board), is(new Position(1,2)));
	}
	
	@Test
	public void shouldMarkMiddleSquareOnRightSide() throws Exception {
		board = new Board();
		board.getBoard()[0][0] = 'X';
		board.getBoard()[0][2] = 'X';
		
		assertThat(emptySide.markMiddleSquareOnEmptySide(board), is(new Position(2,1)));
	}

}

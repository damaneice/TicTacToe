import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class StrategyTest {
	Board board = new Board();
	Strategy strategy;

	@Test
	public void shouldFindWinningMoveDownWithTwoConsecutiveMarks() throws Exception {
		strategy = new Strategy();
		board.getBoard()[0][0] = 'X';
		board.getBoard()[0][1] = 'X';
		Coordinates coordinates = strategy.findNextMove(board);

		assertThat(coordinates.getX(), is(0));
		assertThat(coordinates.getY(), is(2));
	}

	@Test
	public void shouldFindWinningMoveAcrossWithTwoConsecutiveMarks() throws Exception {
		strategy = new Strategy();
		board.getBoard()[0][1] = 'X';
		board.getBoard()[1][1] = 'X';
		Coordinates coordinates = strategy.findNextMove(board);

		assertThat(coordinates.getX(), is(2));
		assertThat(coordinates.getY(), is(1));
	}
	
	@Test
	public void shouldFindWinningMoveDownDiagonalWithTwoConsecutiveMarks() throws Exception {
		strategy = new Strategy();
		board.getBoard()[0][0] = 'X';
		board.getBoard()[1][1] = 'X';
		Coordinates coordinates = strategy.findNextMove(board);
		
		assertThat(coordinates.getX(), is(2));
		assertThat(coordinates.getY(), is(2));
	}
	
	@Test
	public void shouldFindWinningMoveUpDiagonalWithTwoConsecutiveMarks() throws Exception {
		strategy = new Strategy();
		board.getBoard()[0][2] = 'X';
		board.getBoard()[2][0] = 'X';
		Coordinates coordinates = strategy.findNextMove(board);
		
		assertThat(coordinates.getX(), is(1));
		assertThat(coordinates.getY(), is(1));
	}
	
	@Test
	public void shouldFindBlockForDownWithTwoConsecutiveMarks() throws Exception {
		strategy = new Strategy();
		board.getBoard()[0][0] = 'O';
		board.getBoard()[0][1] = 'O';
		Coordinates coordinates = strategy.findNextMove(board);
		
		assertThat(coordinates.getX(), is(0));
		assertThat(coordinates.getY(), is(2));
	}
	
	@Test
	public void shouldFindBlockForAcrossWithTwoConsecutiveMarks() throws Exception {
		strategy = new Strategy();
		board.getBoard()[0][1] = 'O';
		board.getBoard()[1][1] = 'O';
		Coordinates coordinates = strategy.findNextMove(board);

		assertThat(coordinates.getX(), is(2));
		assertThat(coordinates.getY(), is(1));
	}
	
	@Test
	public void shouldFindBlockForDownDiagonalWithTwoConsecutiveMarks() throws Exception {
		strategy = new Strategy();
		board.getBoard()[0][0] = 'O';
		board.getBoard()[1][1] = 'O';
		Coordinates coordinates = strategy.findNextMove(board);
		
		assertThat(coordinates.getX(), is(2));
		assertThat(coordinates.getY(), is(2));
	}
	
	@Test
	public void shouldFindBlockForUpDiagonalWithTwoConsecutiveMarks() throws Exception {
		strategy = new Strategy();
		board.getBoard()[0][2] = 'O';
		board.getBoard()[2][0] = 'O';
		Coordinates coordinates = strategy.findNextMove(board);
		
		assertThat(coordinates.getX(), is(1));
		assertThat(coordinates.getY(), is(1));
	}

}

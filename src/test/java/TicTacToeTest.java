import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TicTacToeTest {
	Board board = new Board();
	TicTacToe ticTacToe;
	

	@Test
	public void shouldFindWinningMoveDownWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][0] = 'X';
		board.getBoard()[0][1] = 'X';
		ticTacToe = new TicTacToe(board);
		Position coordinates = ticTacToe.findNextMove();

		assertThat(coordinates, is(new Position(0,2)));
	}

	@Test
	public void shouldFindWinningMoveAcrossWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][1] = 'X';
		board.getBoard()[1][1] = 'X';
		ticTacToe = new TicTacToe(board);
		Position coordinates = ticTacToe.findNextMove();

		assertThat(coordinates, is(new Position(2,1)));
	}
	
	@Test
	public void shouldFindWinningMoveDownDiagonalWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][0] = 'X';
		board.getBoard()[1][1] = 'X';
		ticTacToe = new TicTacToe(board);
		Position coordinates = ticTacToe.findNextMove();
		
		assertThat(coordinates, is(new Position(2,2)));
	}
	
	@Test
	public void shouldFindWinningMoveUpDiagonalWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][2] = 'X';
		board.getBoard()[2][0] = 'X';
		ticTacToe = new TicTacToe(board);
		Position coordinates = ticTacToe.findNextMove();
		
		assertThat(coordinates, is(new Position(1,1)));
	}
	
	@Test
	public void shouldFindBlockForDownWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][0] = 'O';
		board.getBoard()[0][1] = 'O';
		ticTacToe = new TicTacToe(board);
		Position coordinates = ticTacToe.findNextMove();

		assertThat(coordinates, is(new Position(0,2)));
	}
	
	@Test
	public void shouldFindBlockForAcrossWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][1] = 'O';
		board.getBoard()[1][1] = 'O';
		ticTacToe = new TicTacToe(board);
		Position coordinates = ticTacToe.findNextMove();

		assertThat(coordinates, is(new Position(2,1)));
	}
	
	@Test
	public void shouldFindBlockForDownDiagonalWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][0] = 'O';
		board.getBoard()[1][1] = 'O';
		ticTacToe = new TicTacToe(board);
		Position coordinates = ticTacToe.findNextMove();
		
		assertThat(coordinates, is(new Position(2,2)));
	}
	
	@Test
	public void shouldFindBlockForUpDiagonalWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][2] = 'O';
		board.getBoard()[2][0] = 'O';
		ticTacToe = new TicTacToe(board);
		Position positon = ticTacToe.findNextMove();
		
		assertThat(positon, is(new Position(1,1)));
	}
}

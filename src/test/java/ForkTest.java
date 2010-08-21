import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class ForkTest {
	
	private Board board;
	private Fork fork;

	@Before
	public void setUp(){
		board = new Board();
		fork = new Fork();
	}

	@Test
	public void shouldFindPotentialForkInRow() throws Exception {
		board.getBoard()[0][2] = 'X';
		board.getBoard()[2][0] = 'X';
		List<Position> potentialForks = fork.findPotentialForkInRow(board,0,'X');
		
		assertThat(potentialForks.get(0), is(new Position(0,0)));
		assertThat(potentialForks.get(1), is(new Position(1,0)));
	}
	
	@Test
	public void shouldNotFindPotentialForkInRow() throws Exception {
		board.getBoard()[2][0] = 'O';
		board.getBoard()[0][2] = 'X';
		List<Position> potentialForks = fork.findPotentialForkInRow(board,0,'X');
	
		assertNull(potentialForks);
	}
	
	@Test
	public void shouldFindPotentialForkInColumn() throws Exception {
		board.getBoard()[0][2] = 'X';
		board.getBoard()[2][0] = 'X';
		List<Position> potentialForks = fork.findPotentialForkInColumn(board,0,'X');
		
		assertThat(potentialForks.get(0), is(new Position(0,0)));
		assertThat(potentialForks.get(1), is(new Position(0,1)));
	}
	
	@Test
	public void shouldNotFindPotentialForkInColumn() throws Exception {
		board.getBoard()[0][2] = 'O';
		board.getBoard()[2][0] = 'X';
		List<Position> potentialForks = fork.findPotentialForkInColumn(board,0,'X');
		
		assertNull(potentialForks);
	}
	
	@Test
	public void shouldFindPotentialForkInDownDiagonal() throws Exception {
		board.getBoard()[2][2] = 'X';
		List<Position> potentialForks = fork.findPotentialForkInDownDiagonal(board,'X');
		
		assertThat(potentialForks.get(0), is(new Position(0,0)));
		assertThat(potentialForks.get(1), is(new Position(1,1)));
	}
	
	@Test
	public void shouldNotFindPotentialForkInDownDiagonal() throws Exception {
		board.getBoard()[2][2] = 'O';
		List<Position> potentialForks = fork.findPotentialForkInDownDiagonal(board,'X');
		
		assertNull(potentialForks);
	}
	
	@Test
	public void shouldFindPotentialForkInUpDiagonal() throws Exception {
		board.getBoard()[0][2] = 'X';
		List<Position> potentialForks = fork.findPotentialForkInUpDiagonal(board,'X');
		
		assertThat(potentialForks.get(0), is(new Position(1,1)));
		assertThat(potentialForks.get(1), is(new Position(2,0)));
	}
	
	
	@Test
	public void shouldNotFindPotentialForkInUpDiagonal() throws Exception {
		board.getBoard()[0][2] = 'X';
		board.getBoard()[1][1] = '0';
		List<Position> potentialForks = fork.findPotentialForkInUpDiagonal(board,'X');
		
		assertNull(potentialForks);
	}
	
	@Test
	public void shouldFindMoveToCreateFork() throws Exception {
		board.getBoard()[0][2] = 'X';
		board.getBoard()[2][0] = 'X';
		Position position = fork.createFork(board);
		
		assertThat(position, is(new Position(0,0)));
	}
	
	@Test
	public void shouldFindMoveToBlockFork() throws Exception {
		board.getBoard()[0][2] = 'O';
		board.getBoard()[2][0] = 'O';
		Position position = fork.blockFork(board);
		
		assertThat(position, is(new Position(0,0)));
	}
	
}

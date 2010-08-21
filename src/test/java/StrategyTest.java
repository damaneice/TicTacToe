import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class StrategyTest {
	Board board = new Board();
	Strategy strategy;
	
	@Before
	public void setUp(){
		strategy = new Strategy();
	}

	@Test
	public void shouldFindWinningMoveDownWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][0] = 'X';
		board.getBoard()[0][1] = 'X';
		Position coordinates = strategy.findNextMove(board);

		assertThat(coordinates.getX(), is(0));
		assertThat(coordinates.getY(), is(2));
	}

	@Test
	public void shouldFindWinningMoveAcrossWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][1] = 'X';
		board.getBoard()[1][1] = 'X';
		Position coordinates = strategy.findNextMove(board);

		assertThat(coordinates.getX(), is(2));
		assertThat(coordinates.getY(), is(1));
	}
	
	@Test
	public void shouldFindWinningMoveDownDiagonalWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][0] = 'X';
		board.getBoard()[1][1] = 'X';
		Position coordinates = strategy.findNextMove(board);
		
		assertThat(coordinates.getX(), is(2));
		assertThat(coordinates.getY(), is(2));
	}
	
	@Test
	public void shouldFindWinningMoveUpDiagonalWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][2] = 'X';
		board.getBoard()[2][0] = 'X';
		Position coordinates = strategy.findNextMove(board);
		
		assertThat(coordinates.getX(), is(1));
		assertThat(coordinates.getY(), is(1));
	}
	
	@Test
	public void shouldFindBlockForDownWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][0] = 'O';
		board.getBoard()[0][1] = 'O';
		Position coordinates = strategy.findNextMove(board);
		
		assertThat(coordinates.getX(), is(0));
		assertThat(coordinates.getY(), is(2));
	}
	
	@Test
	public void shouldFindBlockForAcrossWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][1] = 'O';
		board.getBoard()[1][1] = 'O';
		Position coordinates = strategy.findNextMove(board);

		assertThat(coordinates.getX(), is(2));
		assertThat(coordinates.getY(), is(1));
	}
	
	@Test
	public void shouldFindBlockForDownDiagonalWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][0] = 'O';
		board.getBoard()[1][1] = 'O';
		Position coordinates = strategy.findNextMove(board);
		
		assertThat(coordinates.getX(), is(2));
		assertThat(coordinates.getY(), is(2));
	}
	
	@Test
	public void shouldFindBlockForUpDiagonalWithTwoConsecutiveMarks() throws Exception {
		board.getBoard()[0][2] = 'O';
		board.getBoard()[2][0] = 'O';
		Position positon = strategy.findNextMove(board);
		
		assertThat(positon.getX(), is(1));
		assertThat(positon.getY(), is(1));
	}
	
	@Test
	public void shouldFindPotentialForkInRow() throws Exception {
		board.getBoard()[0][2] = 'X';
		board.getBoard()[2][0] = 'X';
		List<Position> potentialForks = strategy.findPotentialForkInRow(board,0,'X');
		
		assertThat(potentialForks.get(0), is(new Position(0,0)));
		assertThat(potentialForks.get(1), is(new Position(1,0)));
	}
	
	@Test
	public void shouldNotFindPotentialForkInRow() throws Exception {
		board.getBoard()[2][0] = 'O';
		board.getBoard()[0][2] = 'X';
		List<Position> potentialForks = strategy.findPotentialForkInRow(board,0,'X');
	
		assertNull(potentialForks);
	}
	
	@Test
	public void shouldFindPotentialForkInColumn() throws Exception {
		board.getBoard()[0][2] = 'X';
		board.getBoard()[2][0] = 'X';
		List<Position> potentialForks = strategy.findPotentialForkInColumn(board,0,'X');
		
		assertThat(potentialForks.get(0), is(new Position(0,0)));
		assertThat(potentialForks.get(1), is(new Position(0,1)));
	}
	
	@Test
	public void shouldNotFindPotentialForkInColumn() throws Exception {
		board.getBoard()[0][2] = 'O';
		board.getBoard()[2][0] = 'X';
		List<Position> potentialForks = strategy.findPotentialForkInColumn(board,0,'X');
		
		assertNull(potentialForks);
	}
	
	@Test
	public void shouldFindPotentialForkInDownDiagonal() throws Exception {
		board.getBoard()[2][2] = 'X';
		List<Position> potentialForks = strategy.findPotentialForkInDownDiagonal(board,'X');
		
		assertThat(potentialForks.get(0), is(new Position(0,0)));
		assertThat(potentialForks.get(1), is(new Position(1,1)));
	}
	
	@Test
	public void shouldNotFindPotentialForkInDownDiagonal() throws Exception {
		board.getBoard()[2][2] = 'O';
		List<Position> potentialForks = strategy.findPotentialForkInDownDiagonal(board,'X');
		
		assertNull(potentialForks);
	}
	
	@Test
	public void shouldFindPotentialForkInUpDiagonal() throws Exception {
		board.getBoard()[0][2] = 'X';
		List<Position> potentialForks = strategy.findPotentialForkInUpDiagonal(board,'X');
		
		assertThat(potentialForks.get(0), is(new Position(1,1)));
		assertThat(potentialForks.get(1), is(new Position(2,0)));
	}
	
	
	@Test
	public void shouldNotFindPotentialForkInUpDiagonal() throws Exception {
		board.getBoard()[0][2] = 'X';
		board.getBoard()[1][1] = '0';
		List<Position> potentialForks = strategy.findPotentialForkInUpDiagonal(board,'X');
		
		assertNull(potentialForks);
	}
	
	private Position blockFork(Board board){
		List<Position> potentialForkPositionsWithDuplicates = findMoveToCreateFork(board, 'O');
		return forkPositions(potentialForkPositionsWithDuplicates).get(0);
	}
	
	private Position createFork(Board board) {
		List<Position> potentialForkPositionsWithDuplicates = findMoveToCreateFork(board, 'X');
		return forkPositions(potentialForkPositionsWithDuplicates).get(0);
	}

	private List<Position> findMoveToCreateFork(Board board, char mark) {
		List<Position> potentialForkPositionsWithDuplicates = new ArrayList<Position>();
		List<Position> findPotentialForkInRow = strategy.findPotentialForkInRow(board,0,mark);
		if(findPotentialForkInRow != null){
			potentialForkPositionsWithDuplicates.addAll(findPotentialForkInRow);
		}
		List<Position> findPotentialForkInColumn = strategy.findPotentialForkInColumn(board,0,mark);
			if(findPotentialForkInColumn != null){
		potentialForkPositionsWithDuplicates.addAll(findPotentialForkInColumn);
		}
		List<Position> findPotentialForkInDownDiagonal = strategy.findPotentialForkInDownDiagonal(board, mark);
			if(findPotentialForkInDownDiagonal != null){
		potentialForkPositionsWithDuplicates.addAll(findPotentialForkInDownDiagonal);
		}
		List<Position> findPotentialForkInUpDiagonal = strategy.findPotentialForkInUpDiagonal(board, mark);
			if(findPotentialForkInUpDiagonal != null){
		potentialForkPositionsWithDuplicates.addAll(findPotentialForkInUpDiagonal);
		}
		return potentialForkPositionsWithDuplicates;
	}

	private List<Position> forkPositions(List<Position> potentialForkPositionsWithDuplicates) {
		
		for (Position position : removeDuplicates(potentialForkPositionsWithDuplicates)) {
			potentialForkPositionsWithDuplicates.remove(position);
		}
		return potentialForkPositionsWithDuplicates;
	}

	private Set<Position> removeDuplicates(List<Position> potentialForkPositionsWithDuplicates) {
		Set<Position> potentialForkPositionsWithoutDuplicates = new HashSet<Position>();
		potentialForkPositionsWithoutDuplicates.addAll(potentialForkPositionsWithDuplicates);
		return potentialForkPositionsWithoutDuplicates;
	}

	@Test
	public void shouldFindMoveToCreateFork() throws Exception {
		board.getBoard()[0][2] = 'X';
		board.getBoard()[2][0] = 'X';
		Position position = createFork(board);
		
		assertThat(position, is(new Position(0,0)));
	}
	

//	
//	public char[] extractUpDiagonal() {
//		char [] diagonal = new char[3];
//		for (int x = 0, y = 2; x < getBoard().length; x++, y--){
//			diagonal[x] = getBoard()[x][y];
//		}
//		return diagonal;
//	}

}

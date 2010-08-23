import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class BoardTest {

	private Board board;

	@Test
	public void shouldExtractDownDiagonal() throws Exception {
		board = new Board();
		board.getBoard()[0][0] = 'X';
		board.getBoard()[2][2] = 'X';
		
		char[] diagonal = board.extractDownDiagonal();
		assertThat(diagonal, is(new char[]{'X', 0, 'X'}));
	}
	
	@Test
	public void shouldExtractUpDiagonal() throws Exception {
		board = new Board();
		board.getBoard()[0][2] = 'X';
		board.getBoard()[1][1] = 'X';
		
		char[] diagonal = board.extractUpDiagonal();
		assertThat(diagonal, is(new char[]{'X', 'X', 0}));
	}
	
	@Test
	public void shouldExtractColumn() throws Exception {
		board = new Board();
		board.getBoard()[0][1] = 'X';
		board.getBoard()[1][1] = 'X';
		
		assertThat(board.extractColumn(0), is(new char[] {0,'X',0}));
	}
	
	@Test
	public void shouldExtractRow() throws Exception {
		board = new Board();
		board.getBoard()[1][0] = 'X';
		board.getBoard()[1][1] = 'X';
		
		assertThat(board.extractRow(0), is(new char[] {0,'X',0}));
	}
}

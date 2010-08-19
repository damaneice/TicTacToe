import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class BoardTest {

	private Board board;

	@Before
	public void setUp(){
		board = new Board();
	}
	
	@Test
	public void shouldExtractDownDiagonal() throws Exception {
		board.getBoard()[0][0] = 'X';
		board.getBoard()[2][2] = 'X';
		
		char[] diagonal = board.extractDownDiagonal();
		assertThat(diagonal, is(new char[]{'X', 0, 'X'}));
	}
	
	@Test
	public void shouldExtractUpDiagonal() throws Exception {
		board.getBoard()[0][2] = 'X';
		board.getBoard()[1][1] = 'X';
		
		char[] diagonal = board.extractUpDiagonal();
		assertThat(diagonal, is(new char[]{'X', 'X', 0}));
	}
}

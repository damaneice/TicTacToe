import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GameOverTest {
	
	private Board board;
	private GameOver w;
 	
	@Before
	public void setUp(){
		board = new Board();
		w = new GameOver(board);
	}
	
	@Test
	public void shouldWinWhenThreeDown() throws Exception {
		board.getBoard()[0][0] = 'X';
		board.getBoard()[0][1] = 'X';
		board.getBoard()[0][2] = 'X';


		assertThat(w.win('X'), is(true));
	}
	
	@Test
	public void shouldExtractColumn() throws Exception {
		board.getBoard()[0][0] = 'X';
		board.getBoard()[1][0] = 'X';
		
		char[] column = board.extractColumn(0);
		
		assertThat(column, is(new char[] {'X','X',0}));
	}
	 
	@Test
	public void shouldWinWhenThreeAcross() throws Exception {
		board.getBoard()[0][0] = 'X';
		board.getBoard()[1][0] = 'X';
		board.getBoard()[2][0] = 'X';
	
		assertThat(w.win('X'), is(true));
	}
	
	@Test
	public void shouldWinWhenThreeDiagonalDown() throws Exception {
		board.getBoard()[0][0] = 'X';
		board.getBoard()[1][1] = 'X';
		board.getBoard()[2][2] = 'X';
		
		assertThat(w.win('X'), is(true));
	}
	
	@Test
	public void shouldWinWhenThreeDiagonalUp() throws Exception {
		board.getBoard()[0][2] = 'X';
		board.getBoard()[1][1] = 'X';
		board.getBoard()[2][0] = 'X';
		
		assertThat(w.win('X'), is(true));
	}
	
	

	

	
	
	
}

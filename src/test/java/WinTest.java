import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WinTest {
	
	private char board[][] = new char[3][3];
	private Win w;
 	
	@Test
	public void shouldWinWhenTwoInARowAcross() throws Exception {
		board[0][0] = 'X';
		board[0][1] = 'X';
		w = new Win(board);

		assertThat(w.win(), is(true));
	}

	@Test
	public void shouldWinWhenTwoAcrossNotInARow() throws Exception {
		board[0][0] = 'X';
		board[0][2] = 'X';
		w = new Win(board);
	
		assertThat(w.win(), is(true));
	}
	
	@Test
	public void shouldExtractColumn() throws Exception {
		board[0][0] = 'X';
		board[1][0] = 'X';
		w = new Win(board);
		
		char[] column = w.extractColumn(0);
		
		assertThat(column, is(new char[] {'X','X',0}));
	}
	 
	@Test
	public void shouldWinWhenTwoDownInFirstColumn() throws Exception {
		board[0][0] = 'X';
		board[1][0] = 'X';
		w = new Win(board);
	
		assertThat(w.win(), is(true));
	}
	
	@Test
	public void shouldWinWhenTwoDownInCenterColumn() throws Exception {
		board[0][1] = 'X';
		board[1][1] = 'X';
		w = new Win(board);
	
		assertThat(w.win(), is(true));
	}
	

	
	
	
}

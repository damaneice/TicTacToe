import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WinTest {
	
	private char board[][] = new char[3][3];
	private Win w;
 	
	@Test
	public void shouldWinWhenThreeDown() throws Exception {
		board[0][0] = 'X';
		board[0][1] = 'X';
		board[0][2] = 'X';
		w = new Win(board);

		assertThat(w.win('X'), is(true));
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
	public void shouldWinWhenThreeAcross() throws Exception {
		board[0][0] = 'X';
		board[1][0] = 'X';
		board[2][0] = 'X';
		w = new Win(board);
	
		assertThat(w.win('X'), is(true));
	}
	
	@Test
	public void shouldWinWhenThreeDiagonalDown() throws Exception {
		board[0][0] = 'X';
		board[1][1] = 'X';
		board[2][2] = 'X';
		w = new Win(board);
		
		assertThat(w.win('X'), is(true));
	}
	
	@Test
	public void shouldExtractDownDiagonal() throws Exception {
		board[0][0] = 'X';
		board[2][2] = 'X';
		w = new Win(board);
		
		char[] diagonal = w.extractDownDiagonal();
		assertThat(diagonal, is(new char[]{'X', 0, 'X'}));
	}
	
	@Test
	public void shouldExtractUpDiagonal() throws Exception {
		board[0][2] = 'X';
		board[1][1] = 'X';
		w = new Win(board);
		
		char[] diagonal = w.extractUpDiagonal();
		assertThat(diagonal, is(new char[]{'X', 'X', 0}));
	}

	

	
	
	
}

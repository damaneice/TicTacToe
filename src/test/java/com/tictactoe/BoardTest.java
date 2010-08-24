package com.tictactoe;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import com.tictactoe.Board;
import static com.tictactoe.Square.*;;



public class BoardTest {

	private Board board;

	@Test
	public void shouldExtractDownDiagonal() throws Exception {
		board = new Board();
		board.getBoard()[0][0] = X;
		board.getBoard()[2][2] = X;
		
		Square[] diagonal = board.extractDownDiagonal();
		assertThat(diagonal, is(new Square[]{X, EMPTY, X}));
	}
	
	@Test
	public void shouldExtractUpDiagonal() throws Exception {
		board = new Board();
		board.getBoard()[0][2] = X;
		board.getBoard()[1][1] = X;
		
		Square[] diagonal = board.extractUpDiagonal();
		assertThat(diagonal, is(new Square[]{X, X, EMPTY}));
	}
	
	@Test
	public void shouldExtractColumn() throws Exception {
		board = new Board();
		board.getBoard()[0][1] = X;
		board.getBoard()[1][1] = X;
		
		assertThat(board.extractColumn(0), is(new Square[] {EMPTY,X,EMPTY}));
	}
	
	@Test
	public void shouldExtractRow() throws Exception {
		board = new Board();
		board.getBoard()[1][0] = X;
		board.getBoard()[1][1] = X;
		
		assertThat(board.extractRow(0), is(new Square[] {EMPTY,X,EMPTY}));
	}
}

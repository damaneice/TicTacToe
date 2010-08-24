package com.tictactoe;
import static com.tictactoe.Square.*; 

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import com.tictactoe.Board;
import com.tictactoe.EmptyCorner;
import com.tictactoe.Position;



public class EmptyCornerTest {

	private EmptyCorner emptyCorner;

	@Before
	public void setUp(){
		emptyCorner = new EmptyCorner();
	}
	
	@Test
	public void shouldMarkTopLeftCorner() throws Exception {
		Board board = new Board();
		board.getBoard()[1][1] = X;
		board.getBoard()[2][2] = X;
		board.getBoard()[0][2] = O;
		board.getBoard()[2][0] = O;
		
		assertThat(emptyCorner.markEmptyCorner(board), is(new Position(0,0)));
	}
	
	@Test
	public void shouldMarkTopRightCorner() throws Exception {
		Board board = new Board();
		board.getBoard()[1][1] = X;
		board.getBoard()[2][2] = X;
		board.getBoard()[0][2] = O;
		board.getBoard()[0][0] = O;
		
		assertThat(emptyCorner.markEmptyCorner(board), is(new Position(2,0)));
	}
	
	@Test
	public void shouldMarkBottomLeftCorner() throws Exception {
		Board board = new Board();
		board.getBoard()[1][1] = X;
		board.getBoard()[2][2] = X;
		board.getBoard()[2][0] = O;
		board.getBoard()[0][0] = O;
		
		assertThat(emptyCorner.markEmptyCorner(board), is(new Position(0,2)));
	}
	
	@Test
	public void shouldMarkBottomRightCorner() throws Exception {
		Board board = new Board();
		board.getBoard()[1][1] = X;
		board.getBoard()[2][0] = X;
		board.getBoard()[0][2] = O;
		board.getBoard()[0][0] = O;
		
		assertThat(emptyCorner.markEmptyCorner(board), is(new Position(2,2)));
	}
}

package com.tictactoe;
import static com.tictactoe.Square.*; 

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import com.tictactoe.Board;
import com.tictactoe.GameOver;


public class GameOverTest {
	
	private Board board;
	private GameOver gameOver;
 	
	@Before
	public void setUp(){
		board = new Board();
		gameOver = new GameOver(board);
	}
	
	@Test
	public void shouldWinWhenThreeDown() throws Exception {
		board.getBoard()[0][0] = X;
		board.getBoard()[0][1] = X;
		board.getBoard()[0][2] = X;


		assertThat(gameOver.win(X), is(true));
	}
	 
	@Test
	public void shouldWinWhenThreeAcross() throws Exception {
		board.getBoard()[0][0] = X;
		board.getBoard()[1][0] = X;
		board.getBoard()[2][0] = X;
	
		assertThat(gameOver.win(X), is(true));
	}
	
	@Test
	public void shouldWinWhenThreeDiagonalDown() throws Exception {
		board.getBoard()[0][0] = X;
		board.getBoard()[1][1] = X;
		board.getBoard()[2][2] = X;
		
		assertThat(gameOver.win(X), is(true));
	}
	
	@Test
	public void shouldWinWhenThreeDiagonalUp() throws Exception {
		board.getBoard()[0][2] = X;
		board.getBoard()[1][1] = X;
		board.getBoard()[2][0] = X;
		
		 assertThat(gameOver.win(X), is(true));
	}
	
	@Test
	public void shouldEndGameAfterNineMoves() throws Exception {
		for (int i = 0; i < 9; i++) {
			gameOver.incrementNumberOfMoves();
		}
		assertThat(gameOver.isBoardFull(), is(true));
	}

	

	
	
	
}

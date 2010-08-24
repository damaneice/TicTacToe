package com.tictactoe;
import static com.tictactoe.Square.*;

import org.junit.Test;
import com.tictactoe.Board;
import com.tictactoe.Center;
import com.tictactoe.Position;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;


public class CenterTest {
	@Test
	public void shouldBeInTheCenter() throws Exception {
		Center center = new Center();
		Position expectedPosition = new Position(1,1);
		
		assertThat(center.playTheCenter(new Board()), is(expectedPosition));
	}
	
	@Test
	public void shouldNotPlayInCenter() throws Exception {
		Center center = new Center();
		Board board = new Board();
		board.getBoard()[1][1] = X; 
		assertNull(center.playTheCenter(board));
	}
}

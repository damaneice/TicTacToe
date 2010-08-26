package com.tictactoe;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class UserInputTest {

	@Test
	public void shouldReturnUserMove() throws Exception {
		IO io = mock(IO.class);
		UserInput userInput = new UserInput(io);
		
		when(io.readIn()).thenReturn("1,2");
		
		assertThat(userInput.userMove(), is(new Position(1,2)));
	}
	@Test
	public void shouldReturnTheCorrectlyFormattedMove() throws Exception {
		IO io = mock(IO.class);
		UserInput userInput = new UserInput(io);
		
		when(io.readIn()).thenReturn("1.2");
		when(io.readIn()).thenReturn("2,2");
		
		assertThat(userInput.userMove(), is(new Position(2,2)));
	}
	
}

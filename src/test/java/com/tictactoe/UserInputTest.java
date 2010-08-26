package com.tictactoe;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class UserInputTest {

	@Test
	public void shouldValidateCorrectlyFormattedInput() throws Exception {
		UserInput userInput = new UserInput();
		
		assertThat(userInput.isValidInput("1,2"), is(true));
	}
	
	@Test
	public void shouldCheckIncorrectlyFormattedInput() throws Exception {
		UserInput userInput = new UserInput();
		
		assertThat(userInput.isValidInput("1.2"), is(false));
	}
	
}

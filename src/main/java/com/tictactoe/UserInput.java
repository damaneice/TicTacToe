package com.tictactoe;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserInput {
	private IO io = new IO();

	public UserInput(IO io){
		this.io = io;
	}
	
	private String readUserInput() throws IOException{
	 String userInput = io.readIn();
	  while (!isValidInput(userInput)) {
		  userInput = io.readIn();
		  System.out.println("To move please enter the x,y coordinates in the following format 1,2 ");
	  }
	  return userInput;
	}
	
	private boolean isValidInput(String userInput){
		 Pattern p = Pattern.compile("^\\d+,\\d+");
	     Matcher m = p.matcher(userInput);
	     return m.find();
	}
	
	public Position userMove() throws IOException{
		String userText = readUserInput();
		return convertUserInputIntoPosition(userText);
	}

	private Position convertUserInputIntoPosition(String userText) {
		String[] xy = userText.split(",");
		return  new Position(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
	}
}

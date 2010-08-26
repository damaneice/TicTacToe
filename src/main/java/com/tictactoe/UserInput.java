package com.tictactoe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserInput {

	
	public String readUserInput() throws IOException{
	BufferedReader stdIn = new BufferedReader(new InputStreamReader( System.in));
	 String userInput = stdIn.readLine();
	  while (!isValidInput(userInput)) {
		  userInput = stdIn.readLine();
		  System.out.println("To move please enter the x,y coordinates in the following format 1,2 ");
	  }
	  return userInput;
	}
	
	public boolean isValidInput(String userInput){
		 Pattern p = Pattern.compile("^\\d+,\\d+");
	     Matcher m = p.matcher(userInput);
	     return m.find();
	}
	
	public Position userMove() throws IOException{
		String userText = readUserInput();

		String[] xy = userText.split(",");
		return new Position(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
	}
}

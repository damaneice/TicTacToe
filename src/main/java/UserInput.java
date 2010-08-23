import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UserInput {

	
	public String readIn() {
	BufferedReader stdIn = new BufferedReader(new InputStreamReader( System.in));
	  String userInput = "";
	  try{
		  while ((userInput = stdIn.readLine()).equals("")) {
		  }
	  }
	  catch (IOException e) {
		  	System.out.println(e.getMessage());
	  }
	  return userInput;
	}
	
	public Position userMove() {
		String userText = readIn();
		String[] xy = userText.split(",");
		return new Position(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
	}
}

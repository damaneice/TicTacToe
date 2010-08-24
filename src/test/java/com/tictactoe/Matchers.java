package com.tictactoe;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import com.tictactoe.Position;


public class Matchers {

	  public static Matcher<Position> isNotTheSame(final Position position) {
		    return new TypeSafeMatcher<Position>() {

				@Override
				public boolean matchesSafely(Position item) {
					return item.getX() == position.getX() && item.getY() == position.getY();
				}

				@Override
				public void describeTo(Description message) {
					message.appendText("Expected x= " + position.getX() + " y= " + position.getY() + "\n");
					
				}     

		    };
	  }
}

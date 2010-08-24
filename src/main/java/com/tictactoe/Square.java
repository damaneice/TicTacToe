package com.tictactoe;

public enum Square {
	X('X'), O('O'), EMPTY(0);
	
	private int mark;

	 private Square(int mark) {
	   this.mark = mark;
	 }

	 public int getMark() {
	   return mark;
	 }
}

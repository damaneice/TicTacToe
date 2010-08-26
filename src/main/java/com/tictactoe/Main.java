package com.tictactoe;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
    	TicTacToe ticTacToe = new TicTacToe(new Board());
    	ticTacToe.play();
    }
}

package com.tictactoe;

import static com.tictactoe.Board.SIZE;
import static com.tictactoe.Square.EMPTY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {

	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

	public String readIn() throws IOException {
		return stdIn.readLine();
	}

	public void print(Board board) {
		for (int y = 0; y < SIZE; y++) {
			System.out.print(" ");
			for (int x = 0; x < SIZE; x++) {
				if (board.getBoard()[x][y] != EMPTY) {
					System.out.print(board.getBoard()[x][y]);
				} else {
					System.out.print(" ");
				}
				if ((x + 1) % SIZE != 0) {
					System.out.print(" | ");
				}
			}
			System.out.println();
		}
	}

	public void printGameOverMessage() {
		System.out.println("Game Over");
	}

	public void printWinMessage() {
		System.out.println("You Win");
	}

	public void printTieMessage() {
		System.out.println("Tie");
	}
}

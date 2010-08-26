package com.tictactoe;
import static com.tictactoe.Square.O;
import static com.tictactoe.Square.X;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TicTacToe {
	private Board board = new Board();
	private WinningMove winningMove = new WinningMove();
	private Block block = new Block();
	private Fork fork = new Fork();
	private GameOver gameOver;
	private Center center = new Center();
	private OppositeCorner oppositeCorner = new OppositeCorner();
	private EmptyCorner emptyCorner = new EmptyCorner();
	private EmptySide emptySide = new EmptySide();
	private IO io = new IO();
	private UserInput userInput = new UserInput(io);
	
  
	
	public TicTacToe(Board board){
		this.board = board;
		gameOver = new GameOver(board);
	}
	
	public void play() throws IOException{
		while(true){
			computerMove();
			io.print(board);
			if (gameOver.win(X)) {
				io.printWinMessage();
				break;
			}
			if(gameOver.isBoardFull()) {
				io.printTieMessage();
				break;
			}
			playerMove();
			if (gameOver.win(O)) {
				io.printGameOverMessage();
				break;
			}
		}
	}
	
	private void playerMove() throws IOException{
		Position userMove = userInput.userMove();
		if (userMove != null) {
			playerMark(userMove);
			gameOver.incrementNumberOfMoves();
		}
	}

	private void computerMove(){
		Position move = findNextMove();
		if(move != null){
			computerMark(move);
			gameOver.incrementNumberOfMoves();
		}
	}
	
	
	private void computerMark(Position position){
		board.getBoard()[position.getX()][position.getY()] = X;
	}
	
	private void playerMark(Position position){
		board.getBoard()[position.getX()][position.getY()] = O;
	}
	
	Position findNextMove() {
		List<Position> listOfMoves = getAllPossibleMoves();
		for (Position position : listOfMoves) {
			if(position != null) {
				return position;
			}
		}
		return null;
	}
	
	private List<Position> getAllPossibleMoves(){
		List<Position> moves = new ArrayList<Position>();
		moves.add(winningMove.findWinningMove(board));
		moves.add(block.findBlockMove(board));
		moves.add(fork.createFork(board));
		moves.add(fork.blockFork(board));
		moves.add(center.playTheCenter(board));
		moves.add(oppositeCorner.playOppositeCorner(board));
		moves.add(emptyCorner.markEmptyCorner(board));
		moves.add(emptySide.markMiddleSquareOnEmptySide(board));
		return moves;
	}
}

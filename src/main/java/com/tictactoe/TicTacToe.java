package com.tictactoe;
import java.util.ArrayList;
import static com.tictactoe.Square.*; 
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
	private UserInput userInput = new UserInput();
	
  
	
	public TicTacToe(Board board){
		this.board = board;
		gameOver = new GameOver(board);
	}
	
	public void play(){
		while(!gameOver.isBoardFull()){
			computerMove();
			board.print();
			if (gameOver.win(X)) {
				System.out.println("Game Over");
				break;
			}
			if(gameOver.isBoardFull()) {
				System.out.println("Tie");
				break;
			}
			playerMove();
			if (gameOver.win(O)) {
				System.out.println("You Win");
				break;
			}
		}
	}
	
	public void playerMove() {
		Position userMove = userInput.userMove();
		if (userMove != null) {
			playerMark(userMove);
			gameOver.incrementNumberOfMoves();
		}
	}

	public void computerMove(){
		Position move = findNextMove();
		if(move != null){
			computerMark(move);
			gameOver.incrementNumberOfMoves();
		}
	}
	
	
	public void computerMark(Position position){
		board.getBoard()[position.getX()][position.getY()] = X;
	}
	
	public void playerMark(Position position){
		board.getBoard()[position.getX()][position.getY()] = O;
	}
	
	public Position findNextMove() {
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

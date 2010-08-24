
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
			if (gameOver.win('X')) {
				System.out.println("Game Over");
				break;
			}
			playerMove();
			if (gameOver.win('O')) {
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
		board.getBoard()[position.getX()][position.getY()] = 'X';
	}
	
	public void playerMark(Position position){
		board.getBoard()[position.getX()][position.getY()] = 'O';
	}
	
	public Position findNextMove() {
		Position position = winningMove.findWinningMove(board);
		if (position != null){
			return position;
		} 
		position = block.findBlockMove(board);
		if (position != null){
			return position;
		} 
		position = fork.createFork(board);
		if (position != null){
			return position;
		} 
		position = fork.blockFork(board);
		if (position != null){
			return position;
		} 
		position = center.playTheCenter(board);
		if(position != null){
			return position;
		}
		position = oppositeCorner.playOppositeCorner(board);
		if(position != null){
			return position;
		}
		position = emptyCorner.markEmptyCorner(board);
		if(position != null){
			return position;
		}
		return emptySide.markMiddleSquareOnEmptySide(board);
	}
}

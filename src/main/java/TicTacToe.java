
public class TicTacToe {
	private Board board = new Board();
	private WinningMove winningMove = new WinningMove();
	private Block block = new Block();
	private Fork fork = new Fork();
	private GameOver gameOver;
	private Center center = new Center();

	public TicTacToe(Board board){
		this.board = board;
		gameOver = new GameOver(board);
	}
	
	public void play(){
		while(!gameOver.isBoardFull() || !gameOver.win('0') || !gameOver.win('X')){
			move();
			gameOver.incrementNumberOfMoves();
		}
	}
	
	public void move(){
		Position move = findNextMove();
		if(move != null){
			computerMark(move);
		}
	}
	
	
	public void computerMark(Position position){
		board.getBoard()[position.getX()][position.getY()] = 'X';
	}
	
	public void playerMark(Position position){
		board.getBoard()[position.getX()][position.getY()] = 'O';
	}
	
	public Position findNextMove() {
		Position position = winningMove.findWinningMove(getBoard());
		if (position != null){
			return position;
		} 
		position = block.findBlockMove(getBoard());
		if (position != null){
			return position;
		} 
		position = fork.createFork(getBoard());
		if (position != null){
			return position;
		} 
		position = fork.blockFork(getBoard());
		if (position != null){
			return position;
		} 
		position = center.playTheCenter();
		if(position != null){
			return position;
		}
		return position;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}
}

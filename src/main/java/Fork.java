import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Fork {

	public List<Position> findPotentialForkInRow(Board board, int rowNumber, char mark) {
		List<Position> positions = new ArrayList<Position>();
		int numberOfEmptyBoxes = 0;
		int numberOfMarks = 0;
		for (int x = 0; x < board.getBoard().length; x++){
			char box = board.getBoard()[x][rowNumber];
			if (box == 0){
				numberOfEmptyBoxes++;
				positions.add(new Position(x,rowNumber));
			}
			else if(box == mark){
				numberOfMarks++;
			}
		}
		if (numberOfMarks == 1 && numberOfEmptyBoxes == 2){
			return positions;
		}
		return null;
	}
	
	public List<Position> findPotentialForkInColumn(Board board, int columnNumber, char mark) {
		List<Position> positions = new ArrayList<Position>();
		int numberOfEmptyBoxes = 0;
		int numberOfMarks = 0;
		for (int y = 0; y < board.getBoard().length; y++){
			char box = board.getBoard()[columnNumber][y];
			if (box == 0){
				numberOfEmptyBoxes++;
				positions.add(new Position(columnNumber,y));
			}
			else if(box == mark){
				numberOfMarks++;
			}
		}
		if (numberOfMarks == 1 && numberOfEmptyBoxes == 2){
			return positions;
		}
		return null;
	}

	public List<Position> findPotentialForkInDownDiagonal(Board board, char mark) {
		List<Position> positions = new ArrayList<Position>();
		int numberOfEmptyBoxes = 0;
		int numberOfMarks = 0;
		for (int i = 0; i < board.getBoard().length; i++) {
			char box = board.getBoard()[i][i];
			if (box == 0) {
				numberOfEmptyBoxes++;
				positions.add(new Position(i, i));
			} else if (box == mark) {
				numberOfMarks++;
			}
		}
		if(numberOfEmptyBoxes == 2 && numberOfMarks == 1){
			return positions;
		}

		return null;
	} 

	public List<Position> findPotentialForkInUpDiagonal(Board board, char mark) {
		List<Position> positions = new ArrayList<Position>();
		int numberOfEmptyBoxes = 0;
		int numberOfMarks = 0;
		for (int x = 0, y = 2; x < board.getBoard().length; x++, y--) {
			char box = board.getBoard()[x][y];
			if (box == 0) {
				numberOfEmptyBoxes++;
				positions.add(new Position(x, y));
			} else if (box == mark) {
				numberOfMarks++;
			}
		}
		if(numberOfEmptyBoxes == 2 && numberOfMarks == 1){
			return positions;
		}
		return null;
	}
	
	public Position blockFork(Board board){
		List<Position> potentialForkPositionsWithDuplicates = findMoveToCreateFork(board, 'O');
		List<Position> forkPositions = forkPositions(potentialForkPositionsWithDuplicates);
		if (!forkPositions.isEmpty()) {
			return forkPositions.get(0);
		}
		return null;
	}
	
	public Position createFork(Board board) {
		List<Position> potentialForkPositionsWithDuplicates = findMoveToCreateFork(board, 'X');
		List<Position> forkPositions = forkPositions(potentialForkPositionsWithDuplicates);
		if (!forkPositions.isEmpty()) {
			return forkPositions.get(0);
		}
		return null;
	}

	private List<Position> findMoveToCreateFork(Board board, char mark) {
		List<Position> potentialForkPositionsWithDuplicates = new ArrayList<Position>();
		List<Position> findPotentialForkInRow = findPotentialForkInRow(board,0,mark);
		if(findPotentialForkInRow != null){
			potentialForkPositionsWithDuplicates.addAll(findPotentialForkInRow);
		}
		List<Position> findPotentialForkInColumn = findPotentialForkInColumn(board,0,mark);
			if(findPotentialForkInColumn != null){
		potentialForkPositionsWithDuplicates.addAll(findPotentialForkInColumn);
		}
		List<Position> findPotentialForkInDownDiagonal = findPotentialForkInDownDiagonal(board, mark);
			if(findPotentialForkInDownDiagonal != null){
		potentialForkPositionsWithDuplicates.addAll(findPotentialForkInDownDiagonal);
		}
		List<Position> findPotentialForkInUpDiagonal = findPotentialForkInUpDiagonal(board, mark);
			if(findPotentialForkInUpDiagonal != null){
		potentialForkPositionsWithDuplicates.addAll(findPotentialForkInUpDiagonal);
		}
		return potentialForkPositionsWithDuplicates;
	}

	private List<Position> forkPositions(List<Position> potentialForkPositionsWithDuplicates) {
		
		for (Position position : removeDuplicates(potentialForkPositionsWithDuplicates)) {
			potentialForkPositionsWithDuplicates.remove(position);
		}
		return potentialForkPositionsWithDuplicates;
	}

	private Set<Position> removeDuplicates(List<Position> potentialForkPositionsWithDuplicates) {
		Set<Position> potentialForkPositionsWithoutDuplicates = new HashSet<Position>();
		potentialForkPositionsWithoutDuplicates.addAll(potentialForkPositionsWithDuplicates);
		return potentialForkPositionsWithoutDuplicates;
	}

	
}

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class OppositeCornerTest {
	private Board board;
	private OppositeCorner oppositeCorner;
	
	@Before
	public void setUp(){
		board = new Board();
		oppositeCorner = new OppositeCorner();
	}
	
	@Test
	public void shouldPlayCenterRow() throws Exception {
		board.getBoard()[1][1] = 'X';
		board.getBoard()[0][0] = 'O';
		
 		assertThat(oppositeCorner.playOppositeCorner(board), is(new Position(1,0)));
	}
	
	@Test
	public void shouldPlayCenterColumn() throws Exception {
		board.getBoard()[1][1] = 'X';
		board.getBoard()[0][0] = 'O';
		board.getBoard()[1][0] = 'X';
		
		assertThat(oppositeCorner.playOppositeCorner(board), is(new Position(0,1)));
	}
}

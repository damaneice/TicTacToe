import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CenterTest {
	@Test
	public void shouldBeInTheCenter() throws Exception {
		Center center = new Center();
		Position expectedPosition = new Position(1,1);
		
		assertThat(center.playTheCenter(), is(expectedPosition));
	}
}

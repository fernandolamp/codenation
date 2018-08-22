package challenge;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class MainTest {

	@Test
	public void test() {
		List<State> states = new Main().listThe10largestStatesInBrazil();

		assertNotNull(states);
		assertEquals(10, states.size());
	}

}

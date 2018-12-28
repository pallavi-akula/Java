import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DemoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Demo d = new Demo();
				assertTrue(d.compareString("hello", "hello"));
			}

	

		
	}




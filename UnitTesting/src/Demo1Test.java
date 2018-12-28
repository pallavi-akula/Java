import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Demo1Test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		 Demo1 demo = new Demo1();
	        assertTrue(demo.isEvenNumber(4));
	        assertFalse(demo.isEvenNumber(5));
	        
	}

}

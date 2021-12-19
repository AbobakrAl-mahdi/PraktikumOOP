package business;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FreizeitbadTest {
	private Freizeitbad fzb;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		this.fzb = new Freizeitbad("Stadtbad", "7.00", "17.00", "25", "24");
	}

	@AfterEach
	public void tearDown() throws Exception {
		this.fzb = null;
	}

	@Test
	public void test() {
		assertTrue(()-> fzb.getBeckenlaenge() == 25, "Bäckenlänge nicht auf 25 gesetzt");
	}
}

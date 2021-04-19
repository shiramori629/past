package utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TODO: write a minimum number of JUnit test cases (assertEquals) for
 * {@code MyUtil.parseDouble} that is code complete.
 * 
 * 
 *
 */
public class MyUtilTest {

	@Test
	public void test() {
		//start your code
	  assertEquals(0, MyUtil.parseDouble(null), 0.01);
      assertEquals(0, MyUtil.parseDouble("jh"), 0.01);
      assertEquals(13.234, MyUtil.parseDouble("ad13.234ao"), 0.01);
		
		
		//end your code
	}

}

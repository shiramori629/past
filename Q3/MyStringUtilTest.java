package utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TODO: write a minimum number of JUnit test cases (assertEquals) for
 * {@code MyStringUtil.isMixedCase} that is branch complete.
 */
public class MyStringUtilTest {

	@Test
	public void test() {
		//start your code
      assertFalse(MyStringUtil.isMixedCase(null));
      assertFalse(MyStringUtil.isMixedCase(""));
      assertTrue(MyStringUtil.isMixedCase("saERDS"));
      assertTrue(MyStringUtil.isMixedCase("ERDSdf"));
		
		
		//end your code
	}

}

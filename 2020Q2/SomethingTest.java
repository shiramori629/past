import org.junit.Test;

/**
 *
 * You are given a java class called Something, which has a method called
 * someMethod. Please implement a minimum number of test cases for testing `someMethod`
 * that are branch complete within `someMethod`. Write your test case(s) in test() method in
 * `SomethingTest.java`. You are not allowed to alter the signatures of the given
 * methods and the package structures of the given classes. Please upload the
 * `SomethingTest.java` file to Wattle for marking.
 *
 */
public class SomethingTest {

	@Test
	public void test() {
		// Implement your test cases
		// START YOUR CODE
    assertEquals(155, Something.someMethod(72, 36, 31, 16));
    assertEquals(0, Something.someMethod(1, 2, 3, 4));

		// END YOUR CODE
	}
}

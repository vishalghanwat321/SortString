package com.jbilling;

import java.util.Random;

import junit.extensions.ExceptionTestCase;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by rvaibhav on 08/11/17.
 */
public class GroupFruitsTest extends TestCase {


	private static final String APPLE = "apple";

	private static final String ORANGE = "orange";

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public GroupFruitsTest(String testName ) {
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite( GroupFruitsTest.class );
	}

	public void testGrouping() throws InvalidInputException {
		runTestWithLengthSpecified(6);
	}

	private void runTestWithLengthSpecified(int n) throws InvalidInputException {
		FruitsDataHelper dataHelper = new FruitsDataHelper();
		Problem problem = new Problem();
		String[] fruits = dataHelper.getFruitsArrayInputData(n);
		System.out.println("Input: " + dataHelper.printFruits(fruits));
		problem.groupFruits(fruits);
		System.out.println("Output: " + dataHelper.printFruits(fruits));
		int orangeCount = getOrangeCount(fruits);
		int i = 0;
		while(i<orangeCount) {
			assertTrue(ORANGE.equals(fruits[i]));
			i++;
		}
		while(i<fruits.length) {
			assertTrue(APPLE.equals(fruits[i]));
			i++;
		}
	}

	private int getOrangeCount(String[] fruits) {
		int count = 0;
		for(int i=0;i<fruits.length;i++) {
			if(ORANGE.equals(fruits[i])) {
				count++;
			}
		}
		return count;
	}

}

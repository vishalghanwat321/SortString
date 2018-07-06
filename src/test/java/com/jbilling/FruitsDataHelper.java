package com.jbilling;

import java.util.Random;

/**
 * Created by rvaibhav on 08/11/17.
 */
public class FruitsDataHelper {

	private static final String APPLE = "apple";

	private static final String ORANGE = "orange";

	private static final String[] FRUITS_ARRAY = new String[] { ORANGE, APPLE};

	public String[] getFruitsArrayInputData(int n) {
		Random random = new Random();
		String[] fruits = new String[n];
		int i = 0;
		while(i<n) {
			int elementIndex = random.nextInt(FRUITS_ARRAY.length);
			fruits[i++] = FRUITS_ARRAY[elementIndex];
		}
		return fruits;
	}

	public String[] getFruitsArrayInputData(int n, int expectedElementIndex) {
		String[] fruits = new String[n];
		int i = 0;
		while(i<n) {
			fruits[i++] = FRUITS_ARRAY[expectedElementIndex];
		}
		return fruits;
	}

	public String[] getFruitsArrayInputData(int n, int expectedElementIndex, int countOfExpectedElement) throws InvalidInputException {
		if(countOfExpectedElement > n) {
			throw new InvalidInputException("Input data for test case is invalid. Count of desired element cannot be greater than the total count");
		}
		Random random = new Random();
		String[] fruits = new String[n];
		int i = 0;
		int otherElementIndex = getOtherElementIndex(expectedElementIndex);
		while(i<n) {
			int elementIndex = -1;
			if(countOfExpectedElement >= n-i) {
				elementIndex = expectedElementIndex;
			} else if (countOfExpectedElement == 0){
				elementIndex = otherElementIndex;
			} else {
				elementIndex = random.nextInt(FRUITS_ARRAY.length);
			}
			countOfExpectedElement = decrementDesiredElementCount(expectedElementIndex, elementIndex, countOfExpectedElement);
			fruits[i++] = FRUITS_ARRAY[elementIndex];
		}
		return fruits;
	}

	private int decrementDesiredElementCount(int expectedElementIndex, int elementIndex, int countOfExpectedElement) {
		if(elementIndex == expectedElementIndex) {
			countOfExpectedElement--;
		}
		return countOfExpectedElement;
	}

	private int getOtherElementIndex(int expectedElementIndex) {
		int otherElementIndex = (expectedElementIndex + 1) % FRUITS_ARRAY.length;
		return otherElementIndex;
	}

	public String printFruits(String[] fruits) {
		if(fruits == null || fruits.length == 0) {
			return "";
		}
		StringBuilder outStr = new StringBuilder("[");
		for(int i=0;i <fruits.length;i++) {
			outStr.append(fruits[i]);
			if(i < (fruits.length -1)) {
				outStr.append(",");
			}
		}
		outStr.append("]");
		return outStr.toString();
	}
}

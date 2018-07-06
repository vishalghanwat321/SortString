package com.jbilling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by tarun.rathor on 9/29/17.
 */
public class Problem {

	public static final String ORANGE = "orange";

	public void groupFruits(String[] arr) throws NotImplementedException, InvalidInputException {

		if(arr.length<=0)
				throw new InvalidInputException("Empty Array");

		for(int i=0,j=arr.length-1, k=0; i<j ; k++)
		{
			if(ORANGE.equalsIgnoreCase(arr[k].trim()))
			{
				String temp = arr[k];
				arr[i++] = arr[k];
				arr[k] = temp;
			}else {
				String temp = arr[k];
				arr[j--] = arr[k];
				arr[k] = temp;
			}
		}
	}
}

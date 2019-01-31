/*
 * Name: Rishav Mitra
 *
 * Program File: FlexArrayRectangle.java
 *
 * Description: Creates a flexible array of Integers. It also incorporates many functions to change size, add or remove values, etc.
 */

public class FlexArrayPrimitive {

	// Logical mySize of the myArray
	private int mySize;

	private int[] myArray;

	// creates an array of primitives
	public FlexArrayPrimitive() {
		myArray = new int[20];
		mySize = 0;
	}

	// creates an array of primitives
	public FlexArrayPrimitive(int s) {
		myArray = new int[s];
		mySize = 0;
	}

	// Returns the logical mySize/length of the myArray
	public int getLength() {
		return mySize;
	}

	// Checks whether or not the modulable myArray is empty
	public boolean isEmpty() {
		return (mySize == 0);
	}

	// Adds an element to the myArray
	public void append(int data) {
		if (myArray[myArray.length - 1] == 0) {
			myArray[mySize] = data;
		}

		else {
			resize();
			myArray[myArray.length - 1] = data;
		}
		mySize++;
	}

	// gets rid of an integer
	public int discard(int index) {

		// }
		if (index < 0) {
			System.out.println("Index cannot be smaller than 0!");
			return -999;
		}

		else {
			int discarded_value = myArray[index];
			myArray[index] = 0;
			for (int i = index; i < myArray.length; i++) {
				if (myArray[i + 1] == 0) {
					break;

				} else {
					myArray[i] = myArray[i + 1];
				}
			}

			mySize--;
			return discarded_value;
		}

	}

	// add an integer to the array
	public void insert(int index, int data) {
		if (myArray[myArray.length - 1] == 0) {
			// makes sure index is a location in myArray
			if (index > myArray.length) {
				index = myArray.length - 1;
			}

			// loops through all numbers starting from the highest index of the
			// array and going to the value of index
			for (int i = myArray.length - 1; i > index; i--) {
				if (myArray[i - 1] != 0) {
					myArray[i] = myArray[i - 1];
				}
			}

			myArray[index] = data;
		}

		else {
			resize();
			// makes sure index is a location in myArray
			if (index > myArray.length) {
				index = myArray.length - 1;
			}

			// loops through all numbers starting from the highest index of the
			// array and going to the value of index
			for (int i = myArray.length - 1; i > index; i--) {
				if (myArray[i - 1] != 0) {
					myArray[i] = myArray[i - 1];
				}
			}
		}
		mySize++;
		myArray[index] = data;
	}

	// increase size of array by 1
	private void resize() {
		int[] modified = new int[myArray.length + 1];
		for (int i = 0; i < myArray.length; i++) {
			modified[i] = myArray[i];
		}
		myArray = modified;
		// To increase the size of my size
		mySize++;
	}

	// Returns every value inside the myArray in one line
	public String toString() {
		String output = "";
		output += "[";
		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i] != 0) {
				output += myArray[i];
				output += ", ";
			}
			if (i == myArray.length - 1) {
				output = output.trim();
				output += "]";

			}
		}
		return output;
	}

	// compares to int arrays
	public int compareTo(FlexArrayPrimitive flexy) {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < myArray.length; i++) {
			sum1 += myArray[i];

		}
		for (int i = 0; i < flexy.getLength(); i++) {
			sum2 += flexy.myArray[i];

		}
		int output = sum1 - sum2;
		return output;
	}

	// check if two int array are equal
	public boolean 
	equals(FlexArrayRectangle flexy) {
		int count1 = 0;
		int count2 = 0;
		count1 = mySize;
		count2 = flexy.getLength();
		return (count1 == count2);
	}

	// sorts using the compare to function
	public void sort() {
		for (int outer = 0; outer < getLength(); outer++) {
			for (int inner = 0; inner < getLength() - 1 - outer; inner++) {
				if (myArray[inner] > myArray[inner + 1]) {
					int temp = myArray[inner + 1];
					myArray[inner + 1] = myArray[inner];
					myArray[inner] = temp;
				}
			}
		}
	}

	// get value at certain index
	public int getValue(int loc) {
		if (loc >= mySize) {
			return -999;
		} else {
			int output = myArray[loc];
			return output;
		}
	}

	// searches for a certain int
	public int searchFor(int target) {
		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i] == target) {
				return i;
			}
		}
		return -1;
	}
}
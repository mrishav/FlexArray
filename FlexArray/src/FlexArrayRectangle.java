/*
 * Name: Rishav Mitra
 *
 * Program File: FlexArrayRectangle.java
 *
 * Description: Creates a flexible array of Rectangles. It also incorporates many functions to change size, add or remove Rectangles, etc.
 */

public class FlexArrayRectangle {
	private int mySize;
	private Rectangle[] myArray;

	// no argument constructor
	public FlexArrayRectangle() {
		myArray = new Rectangle[20];
		mySize = 0;
	}

	// creates array based on size
	public FlexArrayRectangle(int size) {
		myArray = new Rectangle[size];
		mySize = 0;
	}

	// Returns the logical mySize/length of the myArray
	public int getLength() {
		return mySize;
	}

	// Checks whether the empty or not
	public boolean isEmpty() {
		if (mySize == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Adds data to the end of the array
	public void append(Rectangle data) {
		if (myArray[mySize] == null) {
			myArray[mySize] = data;
		}

		else {
			resize();
			myArray[mySize] = data;
		}
		mySize++;
	}

	// Inserts data into the array at certain index
	public void insert(int index, Rectangle data) {
		if (myArray[myArray.length - 1] == null) {
			// makes sure index is a location in myArray
			if (index > mySize) {
				index = mySize;
			}

			// loops through all numbers starting from the highest index of the
			// array and going to the value of index
			for (int i = myArray.length - 1; i > index; i--) {
			myArray[i] = myArray[i - 1];
				
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
			myArray[i] = myArray[i - 1];
				
			}
		}
		mySize++;
		myArray[index] = data;
	}

	// Gets rid of data in the array at a certain index
	public Rectangle discard(int index) {
		if (index >= myArray.length) {
			System.out.println("Cannot discard outside of logical mySize!");
			return null;

		}
		if (index < 0) {
			System.out.println("Index cannot be smaller than 0!");
			return null;
		} else {
			Rectangle discarded_value = myArray[index];
			myArray[index] = null;
			for (int i = index; i < myArray.length-1; i++) {
					myArray[i] = myArray[i + 1];
			}
			mySize--;
			return discarded_value;
		}

	}

	// Increases the size of myArray by 1

	// Increments the size of the array by 1
	private void resize() {
		Rectangle[] modified = new Rectangle[myArray.length + 1];
		for (int i = 0; i < myArray.length; i++) {
			modified[i] = myArray[i];
		}
		myArray = modified;
		// To increase the size of my size
		mySize++;
	}

	// Returns the values inside the myArray
	// Returns the width, length, and area of the Rectangle
	public String toString() {
		String output = "[";
		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i] != null) {
				output += "Rectangle, width = " + myArray[i].getWidth() + " length = " + myArray[i].getLength()
						+ ", area = " + myArray[i].getArea() + "\n";
			}

		}
		output = output.trim();
		output += "]";
		return output;
	}

	// compares to Rectangle arrays
	public int compareTo(FlexArrayRectangle flexy) {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i] != null) {
				sum1 += myArray[i].getLength();
			}
		}
		for (int i = 0; i < flexy.getLength(); i++) {
			if (flexy.myArray[i] != null) {
				sum2 += flexy.myArray[i].getLength();
			}
		}
		int output = sum1 - sum2;
		return output;
	}

	// check if two rectangle arrays are equal
	public boolean equals(FlexArrayRectangle flexy) {
		{

			int quant1 = mySize;
			int quant2 = flexy.getLength();

			if (quant1 == quant2)
				return true;
			else
				return false;
		}
	}

	// sorts Rectangles using compareTo function
	public void sort() {
		for (int outer = 0; outer < mySize - 1; outer++) {
			for (int inner = 0; inner < mySize - outer - 1; inner++) {
				if (myArray[inner].getArea() > myArray[inner + 1].getArea()) {
					Rectangle temp = myArray[inner];
					myArray[inner] = myArray[inner + 1];
					myArray[inner + 1] = temp;
				}
			}
		}
	}

	// gets Rectangle at certain index
	public Rectangle getValue(int loc) {
		if (loc >= mySize) {
			return null;
		} else {
			Rectangle output = myArray[loc];
			return output;
		}
	}

	// searches for certain Rectangle
	public int searchFor(Rectangle target) {

		for (int i = 0; i < getLength(); i++) {
			if (myArray[i] != null && myArray[i].equals(target)) {
				return i;
			}
		}

		return -1;
	}
}

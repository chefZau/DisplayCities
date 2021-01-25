package luca_asn1;

import java.util.Arrays;

/**
 * The InnerCompressedArray class represents the array that has been compressed
 * from a matrix (2D array) into a linear array that excludes elements from the
 * diagonal and any elements above or to the right of the diagonal. Only
 * elements below or to the left of the matrix diagonal must be included in the
 * CompressedArray.
 * 
 * Created by Luca Zhou on 1/25/2021.
 */
public class CompressedArray {

    private int origArraySize;
    private Double[] array;

    /**
     * The constructor of the class. Here is what it will do: 1. Takes original
     * array, initializes and populates the attribute array into an array containing
     * the left and below the diagonal elements.
     * 
     * @param originalArray
     */
    public CompressedArray(double[][] originalArray) {

        // get the size of the lower-left triangle elements
        // note the 2D array will always be n * n, since we have n cities in both col
        // and row
        int n = originalArray.length;
        int size = (n * n - n) / 2;

        this.origArraySize = n;

        this.array = new Double[size];

        int index = 0;
        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray.length; j++) {
                if (i > j) {
                    this.array[index] = originalArray[i][j];
                    index++;
                }
            }
        }

    }

    /**
     * Returns the length of the new, compressed array
     * 
     * @return the length of the new, compressed array
     */
    public int getLength() {
        int n = this.origArraySize;
        return (n * n - n) / 2;
    }

    /**
     * Returns the element in the new, compressed array stored at the given index
     * 
     * @param num the index of the element
     * @return the element in the new, compressed array
     */
    public double getElement(int index) {
        return this.array[index];
    }

    /**
     * Checks equality between the two CompressedArray objects by checking if they
     * have the same length and that all the elements are identical in the same
     * order
     * 
     * @param obj the object we want for comparison
     * @return they are identical
     */
    public boolean equals(CompressedArray obj) {
        return Arrays.equals(this.array, obj.array);
    }

    /**
     * Builds a string that contains the CompressedArray and formats it in a
     * trianglular structure to look like the lower left corner of a matrix. Each
     * element should take up exactly 8 characters and show 2 decimal places.
     */
    public String toString() {
        String matrixFormat = "";

        int index = 0;

        for (int i = 0; i < this.origArraySize; i++) {
            for (int j = 0; j < this.origArraySize; j++) {

                if (i > j) {
                    matrixFormat += String.format("%8.2f", this.array[index]);
                    index++;
                }
            }

            matrixFormat += "\n";
        }

        return matrixFormat;
    }

}
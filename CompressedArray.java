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
     * The constructor of the class. Here is what it will do:
     * 1. Takes original array, initializes and populates the attribute array 
     *    into an array containing the left and below the diagonal elements.
     * @param originalArray
     */
    public CompressedArray(double[][] originalArray) {

        // get the size of the lower-left triangle elements
        // note the 2D array will always be n * n, since we have n cities in both col and row
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
     * 
     * @return
     */
    public int getLength() {
        int n = this.origArraySize;
        return (n * n - n) / 2;
    }

    /**
     * 
     * @param num
     * @return
     */
    public double getElement(int index) {
        return this.array[index];
    }

    /**
     * 
     * @param arr
     * @return
     */
    public boolean equals(CompressedArray arr) {
        return Arrays.equals(this.array, arr.array);
    }

    /**
     * 
     */
    public String toString() {
        String matrixFormat = "";

        int index = 0;

        for (int i = 0; i < this.origArraySize; i++) {
            for (int j = 0; j < this.origArraySize; j++) {
                
                if( i > j ) {
                    matrixFormat += String.format("%8.2f", this.array[index]);
                    index++;
                } else {
                    matrixFormat += "        ";
                }
            }
            matrixFormat += "\n";
        }

        return matrixFormat;
    }

}
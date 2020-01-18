package ics4x.selectionsort;

/**
 *  Assignment: Selection Sort
 *  Author: Ernst Mach
 *  Date: Saturday February 23th, 2019
 *  Description: A simple program that will sort 15 numbers that have been entered by
 *  the user using the selection sort method. There is a visual component that will
 *  show the user just how the selection sort works and where the sort is at currently.
 *  The user will be able to pause, start, or restart the animation at any point. The
 *  user will also have the option to sort the numbers from increasing order or
 *  decreasing order. Initially the program will sort the numbers in increasing order.
 *
 *  Model class that deals with the actual sorting of values. Compares data values and swaps data values.
 */

public class SelectionSort implements SortAlgorithm{
    public boolean increasingOrder = true;                                         //Boolean for if the program will sort the values in increasing order or decreasing order

    //Default constructor
    public SelectionSort() {}

    //Constructor used for test cases
    public SelectionSort(boolean order) {
        increasingOrder = order;
    }

    //Function that will compare all the values in a data set and return the smallest value in that set
    @Override
    public int compare(int[] compareData, int currentValueLocation) {
        int smallestValueLocation = currentValueLocation;                                                                   //Set the current index value as the location of the smallest value initially
        for (int compareLocation = currentValueLocation + 1; compareLocation < compareData.length; compareLocation++) {     //Compare with all values to the right of the current index value
            if (increasingOrder == true) {                                                                                  //If sorting in increasing order
                    if (compareData[compareLocation] < compareData[smallestValueLocation]) {
                        smallestValueLocation = compareLocation;                                                            //Find the index value of the smallest value
                    }                                                                                                       //If sorting in decreasing order
                } else if (compareData[compareLocation] > compareData[smallestValueLocation]) {
                        smallestValueLocation = compareLocation;                                                            //Find the index value of the largest value
                    }
                }
        return smallestValueLocation;                                                                                       //Return the index value of the smallest number
    }

    //Function to swap 2 values in a set of data given the data set and the index location of the 2 values being swapped
    @Override
    public void swap(int[] compareData ,int swapLocation, int smallestValueLocation) {
        int temp = compareData[swapLocation];                                                   //Store the first value temporarily
        compareData[swapLocation] = compareData[smallestValueLocation];                         //Move the second value into the first location
        compareData[smallestValueLocation] = temp;                                              //Move the stored value into the second location

    }

    //Function that combines both the compare and swap function to sort a single value into the correct position
    public void sort(int[] compareData, int currentCompareLocation){
        int newLocation = compare(compareData, currentCompareLocation);                         //Compare all the values in the data set and find the index value of the smallest number
        swap(compareData,currentCompareLocation,newLocation);                                   //Swap the index value of the smallest number with the index value that is currently being compared
    }

    @Override
    //Function used to set if the program will sort the values in increasing order or decreasing order
    public void setMode(boolean order){
        increasingOrder = order;
    }
}

package ics4x.bubblesort;

/**
 *  Assignment: Bubble Sort
 *  Author: Ernst Mach
 *  Date: Saturday February 23th, 2019
 *  Description: A simple program that will sort 15 randomized numbers. There is a
 *  visual component that will show the user just how the insertion sort works and
 *  where the sort is at currently. The user will be able to pause, start, or restart
 *  the animation at any point. The user will also have the option to sort the numbers
 *  from increasing order or decreasing order.
 *
 *  Model class that deals with the actual sorting of values. Compares data values and swaps data values.
 */

public class BubbleSort implements SortAlgorithm{
    public boolean increasingOrder = true;                                              //Boolean for if the program will sort the values in increasing order or decreasing order

    //Default constructor
    public BubbleSort() {}

    //Constructor used for test cases
    public BubbleSort(boolean order) {
        increasingOrder = order;
    }


    @Override
    //Function that will compare 2 values and see which one is either greater or less than, depending on the sorting order
    public int compare(int[] compareData, int compareLocation) {
        if(increasingOrder == true) {                                                   //If sorting in increasing order
            if (compareData[compareLocation] > compareData[compareLocation - 1]) {      //Check which value is smaller
                return (compareLocation - 1);                                           //Return smaller number
            } else {
                return compareLocation;

            }
        } else {                                                                        //If sorting in decreasing order
            if (compareData[compareLocation] < compareData[compareLocation - 1]) {      //Check which value is larger
                return (compareLocation - 1);                                           //Return larger number
            } else {
                return compareLocation;

            }
        }
    }

    @Override
    //Function to swap 2 values in a set of data given the data set and the index location of the 2 values being swapped
    public void swap(int[] compareData, int swapLocation, int sortedLocation) {
        int temp = compareData[sortedLocation];
        compareData[sortedLocation] = compareData[swapLocation];
        compareData[swapLocation] = temp;
    }

    //Function that combines both the compare and swap function to sort a single value into the correct position
    public void sort(int[] compareData, int currentCompareLocation){
        int newLocation = compare(compareData, currentCompareLocation);                 //Compare all the values in the data set and find the index value of the smallest number
        swap(compareData,currentCompareLocation,newLocation);                           //Swap the index value of the smallest number with the index value that is currently being compared
    }

    @Override
    //Function used to set if the program will sort the values in increasing order or decreasing order
    public void setMode(boolean order){
        increasingOrder = order;
    }

    //Function used to check if all the values are sorted in order
    public boolean checkSorted(int[] compareData) {
        int valuesSorted = 0;                                                           //Number of values sorted in order
        for(int i = compareData.length-1; i > 0; i--) {                                 //Check through all values in the array
            if(increasingOrder == true) {                                               //If order is in increasing order
                if(compareData[i] <= compareData[i-1]) {                                //Check if first value is less than second value
                    valuesSorted++;                                                     //Increase count on how many values are sorted
                }
            } else {                                                                    //If order is in decreasing order
                if(compareData[i] >= compareData[i-1]) {                                //Check if first value is greater than second value
                    valuesSorted++;                                                     //Increase count on how many values are sorted
                }
            }
        }

        if(valuesSorted == compareData.length -1 ) {                                    //If all the values are sorted
            return true;
        }
        return false;
    }
}

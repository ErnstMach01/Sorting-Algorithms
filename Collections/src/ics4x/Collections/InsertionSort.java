package ics4x.Collections;

/**
 *  Assignment: 5.7 Collections In Java
 *  Author: Ernst Mach
 *  Date: Monday March 25th, 2019
 *  Description: Takes pre-existing sorting program and incorporates collections into
 *  the program. A simple program that will sort 15 randomized numbers. There is a
 *  visual component that will show the user just how the insertion sort works and
 *  where the sort is at currently. The user will be able to pause, start, or restart
 *  the animation at any point. The user will also have the option to sort the numbers
 *  from increasing order or decreasing order. Program has now been changed to use
 *  collection objects to set-up, access elements, etc.
 *
 *  Model class that deals with the actual sorting of values. Compares data values and swaps data values.
 */

import java.util.ArrayList;

public class InsertionSort implements SortAlgorithm{
    public boolean increasingOrder = true;                                                      //Boolean for if the program will sort the values in increasing order or decreasing order

    //Default constructor
    public InsertionSort() {}

    //Constructor used for test cases
    public InsertionSort(boolean order) {
        increasingOrder = order;
    }

    @Override
    public int compare(ArrayList compareData, int compareLocation) {
        int sortedLocation = compareLocation;                                                   //Variable to store how many values the current value being compare is either greater than or less than
        if(increasingOrder == true) {                                                           //If sorting in increasing order
            for (int i = compareLocation; i >= 0; i--) {
                if ((int)compareData.get(i) > (int)compareData.get(compareLocation)) {          //Compare all values that are below the current index value
                    sortedLocation--;                                                           //Find how many numbers the current value is greater than
                }
            }
        } else {                                                                                //If sorting in decreasing order
            for (int i = compareLocation; i >= 0; i--) {
                if ((int)compareData.get(i) < (int)compareData.get(compareLocation)) {          //Compare all values that are below the current index value
                    sortedLocation--;                                                           //Find how many numbers the current value is less than
                }
            }
        }
        return sortedLocation;                                                                  //Return said value
    }

    @Override
    //Function that will shift the values in the array so that the value being swapped can be inserted in between the correct values
    public void swap(ArrayList compareData, int swapLocation, int sortedLocation) {
        int shiftValue = (int)compareData.get(swapLocation);                                    //Store the value that is being inserted into a temp value
        for(int i = swapLocation; i > sortedLocation; i--) {
            compareData.set(i, (int)compareData.get(i-1));
            //compareData[i] = compareData[i-1];                                                //Shift all values up by 1 position from the index location being inserted to the value that was stored
        }
        compareData.set(sortedLocation, shiftValue);                                            //Store the temp value into the new location
    }

    //Function that combines both the compare and swap function to sort a single value into the correct position
    public void sort(ArrayList compareData, int currentCompareLocation){
        int newLocation = compare(compareData, currentCompareLocation);                         //Compare all the values in the data set and find the index value of the smallest number
        swap(compareData,currentCompareLocation,newLocation);                                   //Swap the index value of the smallest number with the index value that is currently being compared
    }

    @Override
    //Function used to set if the program will sort the values in increasing order or decreasing order
    public void setMode(boolean order){
        increasingOrder = order;
    }
}



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
 *  Interface for the InsertionSort class
 */

import java.util.ArrayList;

interface SortAlgorithm {
    int compare(ArrayList compareData, int compareLocation);                    //Method for comparing values in a set of data
    void swap(ArrayList compareData, int swapLocation, int sortedLocation);     //Method for swapping the position of 2 values in a set of data
    void setMode(boolean increasing);                                           //Method for indicating if sorting in increasing or decreasing order
}


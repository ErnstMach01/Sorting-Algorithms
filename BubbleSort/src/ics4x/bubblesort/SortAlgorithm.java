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
 *  Interface for the SelectionSort class
 */

interface SortAlgorithm {
    int compare(int[] compareData, int compareLocation);                    //Method for comparing values in a set of data
    void swap(int[] compareData, int swapLocation, int sortedLocation);     //Method for swapping the position of 2 values in a set of data
    void setMode(boolean increasing);                                       //Method for indicating if sorting in increasing or decreasing order
}

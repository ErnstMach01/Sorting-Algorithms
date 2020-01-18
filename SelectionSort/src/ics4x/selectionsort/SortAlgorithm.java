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
 *  Interface for the SelectionSort class
 */

interface SortAlgorithm {
    int compare(int[] compareData, int compareLocation);                    //Method for comparing values in a set of data
    void swap(int[] compareData, int swapLocation, int sortedLocation);     //Method for swapping the position of 2 values in a set of data
    void setMode(boolean increasing);                                       //Method for indicating if sorting in increasing or decreasing order
}

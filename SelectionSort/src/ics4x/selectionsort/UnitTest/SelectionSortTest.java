package ics4x.selectionsort.UnitTest;

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
 *  Test case for SelectionSort class
 */

import ics4x.selectionsort.SelectionSort;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SelectionSortTest{                            //Test case class for the sorting algorithm

    private int[] number;
    private boolean order;

    public SelectionSortTest(int[] data, boolean direction) {
        number = data;
        order = direction;
    }

    SelectionSort Sort;                                    //Create an instance of the selection sort object used for testing

    //A list of various test case values
    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {
                {new int[] {53, 46, 46, 83, 48, 49, 43, 14, 48, 33, 93, 94, 87, 65, 59}, false},
                {new int[] {51, 79, 98, 43, 48, 26, 25, 46, 67, 16, 91, 20, 56, 20, 31}, true},
                {new int[] {42, 93, 62, 90, 85, 58, 29, 21, 52, 65, 93, 7, 46, 25, 68}, false},
                {new int[] {13, 39, 95, 93, 86, 92, 48, 16, 24, 23, 78, 13, 3, 64, 51}, true},
                {new int[] {62, 52, 61, 91, 29, 95, 58, 43, 83, 68, 84, 80, 79, 6, 41}, false},
                {new int[] {5, 57, 67, 20, 38, 55, 96, 36, 81, 11, 19, 36, 80, 92, 81}, true},
                {new int[] {69, 43, 75, 26, 28, 66, 55, 32, 9, 10, 33, 61, 67, 70, 40}, false},
                {new int[] {94, 29, 23 , 4, 15, 50, 78, 37, 52, 16, 93, 10, 72, 91, 57}, true},
                {new int[] {63, 21, 83, 74, 74, 92, 48, 5, 69, 14, 71, 86, 1, 84, 98}, false},
                {new int[] {63, 86, 45, 52, 62, 62, 55, 62, 4, 19, 71, 88, 48, 3, 49}, true}
        });
    }

    @Before
    public void initialize() {                              //Initialize the object with the test case values
        Sort = new SelectionSort(order);
    }

    @Test
    public void testCompare() throws Exception {            //Test case for compare method
        int result = Sort.compare(number, 0);
        int smallestLocation = 0;
        int smallestValue = number[0];
        if(order == true) {
            for (int i = 0; i < number.length; i++) {
                if (number[i] < smallestValue) {
                    smallestValue = number[i];
                    smallestLocation = i;
                }
            }
        } else {
            for (int i = 0; i < number.length; i++) {
                if (number[i] > smallestValue) {
                    smallestValue = number[i];
                    smallestLocation = i;
                }
            }
        }
        assertEquals(result, smallestLocation);
    }

    @Test
    public void testSwap() throws Exception {               //Test case for swap method
        for(int i = 0; i < number.length -1; i++) {
            for(int j = i+1; j < number.length; j++) {
                int firstSwapValue = number[i];
                int secondSwapValue = number[j];
                Sort.swap(number, i, j);
                if (number[i] != secondSwapValue || number[j] != firstSwapValue) {
                    assertTrue(false);
                }
                int temp = number[i];
                number[i] = number[j];
                number[j] = temp;
            }
        }
        assertTrue(true);
    }

    @Test
    public void testSort() throws Exception {               //Test case for sorting method
        for(int i = 0; i < number.length -1; i++) {
            for(int j = i+1; j < number.length; j++) {
            Sort.sort(number, i);
            }
            }
            if(order == true) {
                for (int a = 0; a < number.length - 1; a++) {
                    if (number[a] > number[a+1]) {
                        assertTrue(false);
                    }
                }
            } else if(order == false){
                for (int a = 0; a< number.length - 1; a++) {
                    if (number[a] < number[a+1]) {
                        assertTrue(false);
                    }
                }
            }
            assertTrue(true);
    }

    @Test
    public void testSetMode() throws Exception {            //Test case for setMode method
        if(order == false) {
            Sort.setMode(true);
            assertEquals(Sort.increasingOrder, !order);
        } else {
            Sort.setMode(false);
            assertEquals(Sort.increasingOrder, !order);
        }
    }
}
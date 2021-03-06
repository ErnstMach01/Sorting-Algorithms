package ics4x.Collections.UnitTest;

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
 *  Test case for InsertionSort class
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import ics4x.Collections.InsertionSort;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class InsertionSortTest{                                     //Test case class for the sorting algorithm

    private ArrayList number;
    private boolean order;

    public InsertionSortTest(ArrayList data, boolean direction) {
        number = data;
        order = direction;
    }

    InsertionSort Sort;                                             //Create an instance of the insertion sort object used for testing

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
    public void initialize() {                                      //Initialize the object with the test case values
        Sort = new InsertionSort(order);
    }

    @Test
    public void testCompare() throws Exception {                    //Test case for compare method
        int compareLocation = 13;
        int result = Sort.compare(number, compareLocation);
        int sortedLocation = compareLocation;
        if(order == true) {
            for (int i = compareLocation; i >= 0; i--) {
                if ((int)number.get(i) > (int)number.get(compareLocation)) {
                    sortedLocation--;
                }
            }
        } else {
            for (int i = compareLocation; i >= 0; i--) {
                if ((int)number.get(i) < (int)number.get(compareLocation)) {
                    sortedLocation--;
                }
            }
        }
        System.out.println("result: " + result + " sortedLocation: " + sortedLocation );
        assertEquals(result, sortedLocation);
    }

    @Test
    public void testSwap() throws Exception {                       //Test case for swap method
        for (int k = 0; k < number.size(); k++) {
            for (int l = k; l >= 0; l--) {
                int swapValue = (int)number.get(k);
                int swapLocationValue = (int)number.get(l);
                Sort.swap(number, k, l);
                if ((int)number.get(l) != swapValue && (int)number.get(l+1) != swapLocationValue) {
                    assertTrue(false);
                }
            }
        }
        for(int i = 0; i < number.size(); i++) {
            System.out.print((int)number.get(i) +", ");
        }
        assertTrue(true);
    }

    @Test
    public void testSort() throws Exception {                       //Test case for sorting method
        for (int k = 0; k < number.size(); k++) {
            for (int l = k; l >= 0; l--) {
                Sort.sort(number, k);
            }
        }

        if(order == true) {
            for (int a = 0; a < number.size() - 1; a++) {
                if ((int)number.get(a) > (int)number.get(a+1)) {
                    assertTrue(false);
                }
            }
        } else if(order == false){
            for (int a = 0; a< number.size() - 1; a++) {
                if ((int)number.get(a) < (int)number.get(a+1)) {
                    assertTrue(false);
                }
            }
        }
        for(int q = 0; q < number.size(); q++) {
            System.out.print((int)number.get(q) + ", ");
        }
        assertTrue(true);
    }

    @Test
    public void testSetMode() throws Exception {                    //Test case for setMode method
        if(order == false) {
            Sort.setMode(true);
            System.out.println("Sort: " + Sort.increasingOrder + " Order: " + !order);
            assertEquals(Sort.increasingOrder, !order);
        } else {
            Sort.setMode(false);
            System.out.println("Sort: " + Sort.increasingOrder + " Order: " + !order);
            assertEquals(Sort.increasingOrder, !order);
        }
    }
}

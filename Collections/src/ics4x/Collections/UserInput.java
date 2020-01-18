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
 *  View class: Deals with user input
 */

import java.util.*;

public class UserInput extends Thread{
    private Scanner input = new Scanner(System.in);     //Create the scanner object
    private int key;                                    //Variable to hold what key was pressed

    //Function that will constantly check for if there is a key input by the user
    public void run() {
        while(true) {
            try {
                key = input.nextInt();
            } catch(InputMismatchException e) {         //Error handling if user inputs an invalid command
                System.out.println("Incorrect command please try again.");
                input.nextLine();
            }
        }
    }

    //Function that returns the current key value
    public int value() {
        return key;
    }

    //Function used to set a specific value
    public void setKey(int value) {
        key = value;
    }
}


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
 *  View class: deals with the creating the visual interface
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Display {
    private Scanner input = new Scanner(System.in);                                             //Create the scanner object
    private int key;                                                                            //Variable to hold what key was pressed

    //Parameters: the data to be displayed, the index value that is being replaced, the index value currently being looked at
    public void displaySort(int[] sortingData, int checkLocation, int compareLocation) {
        for(int a = 0; a< 15; a++) {                                                            //Print out multiple lines so that the previous frame is pushed out
            System.out.println();
        }
        for(int i = 0; i < sortingData.length; i++) {
            System.out.format( "%3d ", sortingData[i]);                                         //Print out all the values in a row
        }
        System.out.println();
        for(int k = 0; k < sortingData.length; k++) {
            String symbol = " ";
            if (k == checkLocation || k == compareLocation) {
                symbol = "^";
            }
            System.out.format("%3s ", symbol);                                                  //Directly underneath print out a row mainly composed of
        }                                                                                       //spaces, but with 2 carets at a given position to show
        System.out.println();                                                                   //where the program currently is at in the sorting process
    }

    //Function to print out instructions to the user
    public int startScreen(int[] sortingData) {
        System.out.println("These are the 15 random numbers that are between 0-100 which will be sorted \n");
        for(int m = 0; m < sortingData.length; m++){
            System.out.format( "%3d ", sortingData[m]);                                         //Print out all the values in a row
        }
        System.out.println("\n");
        System.out.println("If you wish to sort the numbers in increasing order, simply press 3, then ENTER, and the program will begin. \n" +
                "If you wish to sort them in decreasing order, simply press 4, then ENTER, and the program will begin. \n\n" +
                "Anytime during the sort you can input a 1 to stop the program, a 2 to " +
                "resume the program, \na 3 to restart the program and sort in increasing " +
                "order, or a 4 to restart the program and sort in decreasing order. \n" +
                "The program will end when the numbers have been fully sorted.");

        while (true) {
            try {
                key = input.nextInt();
                if(key == 3 || key == 4) {                                                      //Check if user pressed either a 3 or a 4
                    break;
                } else {                                                                        //All other keys are invalid
                    System.out.println("Incorrect command please try again");
                }
            } catch (InputMismatchException e) {                                                //Error handling if user inputs an invalid command
                System.out.println("Incorrect command please try again.");
                input.nextLine();
            }
        }
        return key;
    }
}

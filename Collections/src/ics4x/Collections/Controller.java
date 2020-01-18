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
 *  Controller class: deals with sending information between the view and model classes
 */

import java.util.ArrayList;

public class Controller {

    public Controller() {
        InsertionSort Sort = new InsertionSort();           //Create instance of sort object
        Display Display = new Display();                    //Create instance of display object
        UserInput Input = new UserInput();                  //Create instance of input object

        int delayTime = 400;                                //Variable for the delay between each
        int result;                                         //Variable for which key was pressed
        boolean stop = false;                               //Boolean for when the program will pause

        ArrayList data = new ArrayList();                   //Array list to store all the data values

        for (int i = 0; i < 15; i++) {
            data.add((int) (Math.random() * 100));          //Generate random values
        }
        ArrayList sortData = new ArrayList(data);           //Create a copy of the data set

        result = Display.startScreen(sortData);             //Show the instructions to the user

        if (result == 3) {                                  //Start sorting in increasing order
            Sort.setMode(true);
        }
        if (result == 4) {
            Sort.setMode(false);                            //Start sorting in decreasing order
        }
        Input.start();                                      //Start separate thread that will check for user input
        for (int k = 0; k < sortData.size(); k++) {
            for (int l = k; l >= 0; l--) {
                Display.displaySort(sortData, k, l);        //Display the animation of the sort, a single instance
                for (int a = 0; a < delayTime; a++) {       //For loop to check if the user has pressed a key
                    try {
                        Thread.sleep(1);                    //Wait 1 ms
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    result = Input.value();                 //See if user has pressed a key if so which button
                    if (result == 1) {                      //If user has pressed 1
                        stop = true;                        //Program will stop
                    }
                    if (result == 2) {                      //If user has pressed 2
                        stop = false;                       //Program will start again
                    }
                    if (stop == true) {                     //If the program is to be stopped
                        a = 0;                              //Loop constantly and reset the for loop so the program will be in a definite loop until the value changes
                    }
                    if (result == 3 || result == 4) {       //If user has pressed 3 or 4
                        for (int i = 0; i < 15; i++) {      //Reset the data set to the original copy
                            sortData = new ArrayList(data);
                        }
                        k = 0;                              //Reset the for loop values
                        l = 0;
                        if (result == 3) {                  //If user pressed 3
                            Sort.setMode(true);             //Start sorting in increasing order
                        } else {                            //If user pressed 4
                            Sort.setMode(false);            //Start sorting in decreasing order
                        }
                        Input.setKey(0);                    //Set the key to 0 so the value when it loops back will not be 2 again
                    }
                }
                int value = Sort.compare(sortData, k);      //Find the location that the value will sort into
                if (l == (value - 1)) {                     //Break out of for loop once value has compared the values leading up to that location
                    break;
                }
            }
            Sort.sort(sortData, k);                         //Move on to the next sort
        }
        Display.displaySort(sortData, 15, 15);              //Display the final sorted order
    }
}


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
 *  Controller class: deals with sending information between the view and model classes
 */

public class Controller {

    public Controller(){
        SelectionSort Sort = new SelectionSort();           //Create instance of sort object
        Display Display = new Display();                    //Create instance of display object
        UserInput Input = new UserInput();                  //Create instance of input object

        int delayTime = 400;                                //Variable for the delay between each
        int result;                                         //Variable for which key was pressed
        boolean stop = false;                               //Boolean for when the program will pause

        int[] data = new int[15];                           //Array to store the data entered
        int[] sortData = new int[15];                       //Copy of the data stored, allows us to maintain the original copy for use later on if needed
        for(int i = 0; i< 15; i++) {
            data[i] = (int) (Math.random() * 100);
            sortData[i] = data[i];
        }

        result = Display.startScreen(sortData);             //Show the instructions to the user
        if(result == 3){                                    //Start sorting in increasing order
            Sort.setMode(true);
        }
        if(result == 4){
            Sort.setMode(false);                            //Start sorting in decreasing order
        }

        Input.start();                                      //Start separate thread that will check for user input
        for (int k = 0; k < sortData.length; k++) {
            for (int l = k + 1; l < sortData.length; l++) {
                Display.displaySort(sortData, k, l);        //Display the animation of the sort, a single instance
                for(int a = 0; a< delayTime; a++) {         //For loop to check if the user has pressed a key
                    try {
                        Thread.sleep(1);                    //Wait 1 ms
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    result = Input.value();                 //See if user has pressed a key if so which button
                    if(result == 1 ) {                      //If user has pressed 1
                        stop = true;                        //Program will stop
                    }
                    if(result == 2) {                       //If user has pressed 2
                        stop = false;                       //Program will start again
                    }

                    if(stop == true) {                      //If the program is to be stopped
                        a = 0;                              //Loop constantly and reset the for loop so the program will be in a definite loop until the value changes
                    }
                    if(result == 3 || result == 4) {        //If user has pressed 3 or 4
                        for(int i = 0; i<15; i++) {         //Reset the data set to the original copy
                            sortData[i] = data[i];
                        }
                        k=0;                                //Reset the for loop values
                        l = 0;
                        if(result == 3) {                   //If user pressed 3
                            Sort.setMode(true);             //Start sorting in increasing order
                        } else {                            //If user pressed 4
                            Sort.setMode(false);            //Start sorting in decreasing order
                        }
                        Input.setKey(0);                    //Set the key to 0 so the value when it loops back will not be 2 again
                    }
                }
            }
            Sort.sort(sortData, k);                         //Move on to the next sort
        }
        Display.displaySort(sortData, 15, 15);              //Display the final sorted order
    }
}


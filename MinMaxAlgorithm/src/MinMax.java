/**
 * Title: MinMaxAlgorithm
 * Date: November 11, 2018
 * Author: Ernst Mach
 * Description: A simple program that
 * implements a simple algorithm to find
 * the min and max values in an array of numbers.
 */
public class MinMax {
    public static void main(String[] args) {
        int[] numbers = new int[10];                        // An array to hold all the numbers
        int minValue;                                       // Variable to hold the min value
        int maxValue;                                       // Variable to hold the max value

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int )(Math.random() * 100);       // Sets all the numbers in the array to a random number from 0 to 100
        }

        minValue = numbers[0];                              // Sets the min value to the first number in the array
        maxValue = numbers[0];                              // Sets the max value to the first number in the array

        for(int i = 0; i < numbers.length; i++) {
          if(numbers[i] < minValue){                        // Compares the numbers in the array to the min value
              minValue = numbers[i];                        // Changes the min value if a number in the array is less than the current min value
          }

          if(numbers[i] > maxValue) {                       // Compares the numbers in the array to the max value
              maxValue = numbers[i];                        // Changes the max value if a number in the array is more than the current max value
          }
        }

        System.out.print("Your numbers are: ");

        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");             // Prints out what all the numbers in the array are
        }

        System.out.println();
        System.out.println("Min Value: " + minValue);       // Prints what the min and max values are
        System.out.println("Max Value: " + maxValue);
    }
}
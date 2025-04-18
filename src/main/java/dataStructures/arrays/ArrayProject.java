package dataStructures.arrays;

import java.util.Scanner;

/*
    Take the daily temperature from the user input and:
        1. calculate the average temperature and
        2. how many days are above the average temperature?
            -> this can only be done by creating an array to store the temp values.
*/
public class ArrayProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many days temperature will we track? ");

        int numberOfDays = scanner.nextInt();
        int[] temps = new int[numberOfDays];

        double sumOfTemps = 0.0;

        for (int i = 1; i <= numberOfDays; i++) {
            System.out.print("Day " + i + "'s temp: ");
            int nextTemp = scanner.nextInt();
            temps[i-1] = nextTemp;
            sumOfTemps += nextTemp;
        }

        double averageTemp = sumOfTemps / numberOfDays;
        System.out.println();
        System.out.println("Average temp: " + averageTemp);

        int daysAboveAverageTemp = 0;
        for (int temp : temps) {
            if (temp > averageTemp) {
                daysAboveAverageTemp++;
            }
        }
        System.out.println("Number of days over average temp: " + daysAboveAverageTemp);
    }

}

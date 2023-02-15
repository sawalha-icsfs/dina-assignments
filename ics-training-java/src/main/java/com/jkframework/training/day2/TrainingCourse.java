package com.jkframework.training.day2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TrainingCourse {

    public static final String TEXT_FILENAME = "..\\ics-training-java\\array.txt";

    public static void main(String args[]) throws IOException {
        day2();

    }

    public static String day2() throws IOException {

        int n = 0;
        int sum = 0;
        double avg = 0;
        int maxcount = 0;
        int maxFreqElement1 = 0;
        int maxFreqElement2 = 0;
        int maxFreqElement3 = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("number of array element in scanner: ");

        n = scanner.nextInt();
        int[] array = new int[n];
        if (n > 10000) {
            System.out.println("The elements of the array is entered Randomly ");
            for (int i = 0; i < n; i++) {
                array[i] = new Random().nextInt(1000);
            }
        } else {
            System.out.println("please enter a number greater than 10,000");

        }
        for (int c = 0; c < n; c++) {
            sum += array[c];
            avg = (double) sum / n;
            int j = 0;
            int k = 0;
            int m = 0;
            int count = 0;
            int count1 = 0;
            // int count2 = 0;

            for (j = 0; j < n; j++) {
                if (array[c] == array[j]) {
                    count++;
                }
            }
            for (k = 0; k < n; k++) {
                if (array[c] == array[k]) {

                    count1++;
                }
            }
            // for (m = 0; m < n; m++) {
            // if (array[k] == array[m]) {
            // count2++;
            // }
            // }

            if (count > maxcount) {
                maxcount = count;
                maxFreqElement1 = array[c];
            }
            if (count1 > maxcount) {
                maxcount = count1;
                maxFreqElement2 = array[j];
            }
            // if (count2 > maxcount) {
            // maxcount = count2;
            // maxFreqElement3 = array[m];
            // }

        }
        // duplicate(array);

        System.out.println("Sum is : " + sum);
        System.out.println("Average is : " + avg);
        System.out.println("max Freq Element1 is : " + maxFreqElement1);
        System.out.println("max Freq Element2 is : " + maxFreqElement2);
        System.out.println("max Freq Element3 is : " + maxFreqElement3);

        System.out.println("Array elements are in array.txt file ");
        for (int i = 0; i < n; i++) {

            FileWriter fileWriter = new FileWriter(TEXT_FILENAME);
            fileWriter.write("Array elements are: \n");
            for (int str : array) {
                fileWriter.write(str + System.lineSeparator());
            }
            fileWriter.close();
            return TEXT_FILENAME;
        }

        return null;
    }

}

package com.jkframework.training.day2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class TrainingCourse {

    public static final String TEXT_FILENAME = "..\\..\\icsfs-training-java\\array.txt";
    public static List<Integer> mostFreqNumList = new ArrayList<Integer>();
    static Scanner scanner;

    public static void main(String args[]) throws IOException {
        TrainingCourse course = new TrainingCourse();

        course.inputArray();

    }

    public String inputArray() throws IOException {
        int n = 0;
        int sum = 0;
        double avg = 0;
        int maxcount = 0;
        int maxFreqElement1 = 0;
        int maxFreqElement2 = 0;
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

            if (count > maxcount) {
                maxcount = count;
                maxFreqElement1 = array[c];
            }
            if (count1 > maxcount) {
                maxcount = count1;
                maxFreqElement2 = array[j];
            }

        }
        // duplicateNumbers(array);
        System.out.println("Sum is : " + sum);
        System.out.println("Average is : " + avg);
        System.out.println("max Freq Element1 is : " + maxFreqElement1);
        System.out.println("max Freq Element2 is : " + maxFreqElement2);

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

    public List<Integer> duplicateNumbers(int[] array) {
        int inputArray[] = array;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        int maxcount = 0;
        int maxFreqElement1 = 0;

        for (int i = 0; i < inputArray.length; i++) {
            int count = 0;

            for (int j = 0; j < inputArray.length; j++) {
                if (inputArray[i] == inputArray[j]) {
                    count++;
                }
            }
            if (count > maxcount) {
                maxcount = count;
                maxFreqElement1 = array[i];
                hashMap.put(maxFreqElement1, count);
            }

        }
        List<Integer> FreqNumList = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            FreqNumList.add(entry.getValue());
        }
        Collections.sort(FreqNumList);
        mostFreqNumList.add(findNumber(hashMap, FreqNumList.get(FreqNumList.size() - 1)));
        mostFreqNumList.add(findNumber(hashMap, FreqNumList.get(FreqNumList.size() - 2)));
        mostFreqNumList.add(findNumber(hashMap, FreqNumList.get(FreqNumList.size() - 3)));
        return mostFreqNumList;

    }

    public Integer findNumber(HashMap<Integer, Integer> map, int value) {
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == value) {
                if (mostFreqNumList.contains(entry.getKey())) {
                    continue;
                } else {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

}

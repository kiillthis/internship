package com.company;

import java.util.Random;

public class SortStringService {
    public SortStringService() {
    }

    public StringBuilder generateString(int length) {
        int leftLimit = 97;
        int rightLimit = 122;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return new StringBuilder(generatedString);
    }

    public void bubbleSortString(StringBuilder a) {
        for (int i = 0; i < a.length() - 1; i++) {
            for (int j = 0; j < a.length() - i - 1; j++) {
                if (a.charAt(j) > a.charAt(j + 1)) {
                    char tmp = a.charAt(j);
                    a.setCharAt(j, a.charAt(j + 1));
                    a.setCharAt(j + 1, tmp);
                }
            }
        }
    }
    public void insertionSortString(StringBuilder a) {
        for (int i = 0; i < a.length(); i++) {
            char current = a.charAt(i);
            int j = i - 1;

            while (j >= 0 && current < a.charAt(j)) {
                a.setCharAt(j + 1, a.charAt(i));
                j--;
            }

            a.setCharAt(j + 1,  current);
        }
    }

    public void selectionSorString(StringBuilder a) {
        for (int i = 0; i < a.length(); i++) {
            char min = a.charAt(i);
            int minId = i;

            for (int j = i + 1; j < a.length(); j++) {
                if (a.charAt(j) < min) {
                    min = a.charAt(j);
                    minId = j;
                }
            }

            char temp = a.charAt(i);
            a.setCharAt(i, min);
            a.setCharAt(minId, temp);
        }
    }

    public void quickSortString(StringBuilder array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSortString(array, begin, pivot - 1);
        quickSortString(array, pivot + 1, end);

    }

    public void mergeSortString(StringBuilder array, int low, int high) {
        if (high <= low) return;

        int mid = (low+high)/2;
        mergeSortString(array, low, mid);
        mergeSortString(array, mid+1, high);
        merge(array, low, mid, high);
    }

    private void merge(StringBuilder array, int low, int mid, int high) {

        StringBuilder left =  new StringBuilder(array.substring(low, mid));
        StringBuilder right =  new StringBuilder(array.substring(mid, high - 1));

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = low; i < high + 1; i++) {
            if (leftIndex < left.length() && rightIndex < right.length()) {
                if (left.charAt(leftIndex) < right.charAt(rightIndex)) {
                    array.setCharAt(i, left.charAt(leftIndex));
                    leftIndex++;
                } else {
                    array.setCharAt(i, right.charAt(rightIndex));
                    rightIndex++;
                }
            } else if (leftIndex < left.length()) {
                array.setCharAt(i, left.charAt(leftIndex));
                leftIndex++;
            } else if (rightIndex < right.length()) {
                array.setCharAt(i, right.charAt(rightIndex));
                rightIndex++;
            }
        }
    }

    private int partition(StringBuilder array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array.charAt(i) < array.charAt(pivot)) {
                char temp = array.charAt(counter);
                array.setCharAt(counter, array.charAt(i));
                array.setCharAt(i, temp);
                counter++;
            }
        }
        char temp = array.charAt(pivot);
        array.setCharAt(pivot, array.charAt(counter));
        array.setCharAt(counter, temp);

        return counter;
    }
}

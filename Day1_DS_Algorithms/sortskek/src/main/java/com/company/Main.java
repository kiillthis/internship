package com.company;

public class Main {

    public static void main(String[] args) {

        SortService sortingService = new SortService();
        SortStringService sortStringService = new SortStringService();

        int[] array10B = sortingService.fillArray(10);
        int[] array10I = sortingService.fillArray(10);
        int[] array10S = sortingService.fillArray(10);
        int[] array10M = sortingService.fillArray(10);
        int[] array10Q = sortingService.fillArray(10);

        int[] array50B = sortingService.fillArray(50);
        int[] array50I = sortingService.fillArray(50);
        int[] array50S = sortingService.fillArray(50);
        int[] array50M = sortingService.fillArray(50);
        int[] array50Q = sortingService.fillArray(50);

        int[] array500B = sortingService.fillArray(500);
        int[] array500I = sortingService.fillArray(500);
        int[] array500S = sortingService.fillArray(500);
        int[] array500M = sortingService.fillArray(500);
        int[] array500Q = sortingService.fillArray(500);

        int[] array1000B = sortingService.fillArray(1000);
        int[] array1000I = sortingService.fillArray(1000);
        int[] array1000S = sortingService.fillArray(1000);
        int[] array1000M = sortingService.fillArray(1000);
        int[] array1000Q = sortingService.fillArray(1000);

        StringBuilder arrayString10B = sortStringService.generateString(10);
        StringBuilder arrayString10I = sortStringService.generateString(10);
        StringBuilder arrayString10S = sortStringService.generateString(10);
        StringBuilder arrayString10M = sortStringService.generateString(10);
        StringBuilder arrayString10Q = sortStringService.generateString(10);


        StringBuilder arrayString50B = sortStringService.generateString(50);
        StringBuilder arrayString50I = sortStringService.generateString(50);
        StringBuilder arrayString50S = sortStringService.generateString(50);
        StringBuilder arrayString50M = sortStringService.generateString(50);
        StringBuilder arrayString50Q = sortStringService.generateString(50);

        StringBuilder arrayString500B = sortStringService.generateString(500);
        StringBuilder arrayString500I = sortStringService.generateString(500);
        StringBuilder arrayString500S = sortStringService.generateString(500);
        StringBuilder arrayString500M = sortStringService.generateString(500);
        StringBuilder arrayString500Q = sortStringService.generateString(500);

        StringBuilder arrayString1000B = sortStringService.generateString(1000);
        StringBuilder arrayString1000I = sortStringService.generateString(1000);
        StringBuilder arrayString1000S = sortStringService.generateString(1000);
        StringBuilder arrayString1000M = sortStringService.generateString(1000);
        StringBuilder arrayString1000Q = sortStringService.generateString(1000);


        long start = System.nanoTime();
        sortingService.bubbleSort(array10B);
        long time = System.nanoTime() - start;
        System.out.println("Bubblesort 10: " + time);

        start = System.nanoTime();
        sortingService.quickSort(array10Q, 0, array10Q.length - 1);
        time = System.nanoTime() - start;
        System.out.println("Quicksort 10: " + time);

        start = System.nanoTime();
        sortingService.insertionSort(array10I);
        time = System.nanoTime() - start;
        System.out.println("InsertionSort 10: " + time);

        start = System.nanoTime();
        sortingService.selectionSort(array10S);
        time = System.nanoTime() - start;
        System.out.println("SelectionSort 10: " + time);

        start = System.nanoTime();
        sortingService.mergeSort(array10M, 0, array10M.length - 1);
        time = System.nanoTime() - start;
        System.out.println("MergeSort 10: " + time);

        System.out.println("--------------");

        start = System.nanoTime();
        sortingService.bubbleSort(array50B);
        time = System.nanoTime() - start;
        System.out.println("Bubblesort 50: " + time);

        start = System.nanoTime();
        sortingService.quickSort(array50Q, 0, array50Q.length - 1);
        time = System.nanoTime() - start;
        System.out.println("Quicksort 50: " + time);

        start = System.nanoTime();
        sortingService.insertionSort(array50I);
        time = System.nanoTime() - start;
        System.out.println("InsertionSort 50: " + time);

        start = System.nanoTime();
        sortingService.selectionSort(array50S);
        time = System.nanoTime() - start;
        System.out.println("SelectionSort 50: " + time);

        start = System.nanoTime();
        sortingService.mergeSort(array50M, 0, array50M.length - 1);
        time = System.nanoTime() - start;
        System.out.println("MergeSort 50: " + time);

        System.out.println("--------------");

        start = System.nanoTime();
        sortingService.bubbleSort(array500B);
        time = System.nanoTime() - start;
        System.out.println("Bubblesort 500: " + time);

        start = System.nanoTime();
        sortingService.quickSort(array500Q, 0, array500Q.length - 1);
        time = System.nanoTime() - start;
        System.out.println("Quicksort 500: " + time);

        start = System.nanoTime();
        sortingService.insertionSort(array500I);
        time = System.nanoTime() - start;
        System.out.println("InsertionSort 500: " + time);

        start = System.nanoTime();
        sortingService.selectionSort(array500S);
        time = System.nanoTime() - start;
        System.out.println("SelectionSort 500: " + time);

        start = System.nanoTime();
        sortingService.mergeSort(array500M, 0, array500M.length - 1);
        time = System.nanoTime() - start;
        System.out.println("MergeSort 500: " + time);

        System.out.println("--------------");

        start = System.nanoTime();
        sortingService.bubbleSort(array1000B);
        time = System.nanoTime() - start;
        System.out.println("Bubblesort 1000: " + time);

        start = System.nanoTime();
        sortingService.quickSort(array1000Q, 0, array1000Q.length - 1);
        time = System.nanoTime() - start;
        System.out.println("Quicksort 1000: " + time);

        start = System.nanoTime();
        sortingService.insertionSort(array1000I);
        time = System.nanoTime() - start;
        System.out.println("InsertionSort 1000: " + time);

        start = System.nanoTime();
        sortingService.selectionSort(array1000S);
        time = System.nanoTime() - start;
        System.out.println("SelectionSort 1000: " + time);

        start = System.nanoTime();
        sortingService.mergeSort(array1000M, 0, array1000M.length - 1);
        time = System.nanoTime() - start;
        System.out.println("MergeSort 1000: " + time);


        System.out.println("++++++++++++++++++++");
        start = System.nanoTime();
        sortStringService.bubbleSortString(arrayString10B);
        time = System.nanoTime() - start;

        System.out.println("Bubblesort 10: " + time);

        start = System.nanoTime();
        sortStringService.quickSortString(arrayString10Q, 0, array10Q.length - 1);
        time = System.nanoTime() - start;
        System.out.println("Quicksort 10: " + time);

        start = System.nanoTime();
        sortStringService.insertionSortString(arrayString10I);
        time = System.nanoTime() - start;
        System.out.println("InsertionSort 10: " + time);

        start = System.nanoTime();
        sortStringService.selectionSorString(arrayString10S);
        time = System.nanoTime() - start;
        System.out.println("SelectionSort 10: " + time);

        start = System.nanoTime();
        sortStringService.mergeSortString(arrayString10M, 0, array10M.length - 1);
        time = System.nanoTime() - start;
        System.out.println("MergeSort 10: " + time);

        System.out.println("--------------");

        start = System.nanoTime();
        sortStringService.bubbleSortString(arrayString50B);
        time = System.nanoTime() - start;

        System.out.println("Bubblesort 50: " + time);

        start = System.nanoTime();
        sortStringService.quickSortString(arrayString50Q, 0, array50Q.length - 1);
        time = System.nanoTime() - start;
        System.out.println("Quicksort 50: " + time);

        start = System.nanoTime();
        sortStringService.insertionSortString(arrayString50I);
        time = System.nanoTime() - start;
        System.out.println("InsertionSort 50: " + time);

        start = System.nanoTime();
        sortStringService.selectionSorString(arrayString50S);
        time = System.nanoTime() - start;
        System.out.println("SelectionSort 50: " + time);

        start = System.nanoTime();
        sortStringService.mergeSortString(arrayString50M, 0, array50M.length - 1);
        time = System.nanoTime() - start;
        System.out.println("MergeSort 50: " + time);

        System.out.println("--------------");

        start = System.nanoTime();
        sortStringService.bubbleSortString(arrayString500B);
        time = System.nanoTime() - start;

        System.out.println("Bubblesort 500: " + time);

        start = System.nanoTime();
        sortStringService.quickSortString(arrayString500Q, 0, array500Q.length - 1);
        time = System.nanoTime() - start;
        System.out.println("Quicksort 500: " + time);

        start = System.nanoTime();
        sortStringService.insertionSortString(arrayString500I);
        time = System.nanoTime() - start;
        System.out.println("InsertionSort 500: " + time);

        start = System.nanoTime();
        sortStringService.selectionSorString(arrayString500S);
        time = System.nanoTime() - start;
        System.out.println("SelectionSort 500: " + time);

        start = System.nanoTime();
        sortStringService.mergeSortString(arrayString500M, 0, array500M.length - 1);
        time = System.nanoTime() - start;
        System.out.println("MergeSort 500: " + time);

        System.out.println("--------------");

        start = System.nanoTime();
        sortStringService.bubbleSortString(arrayString1000B);
        time = System.nanoTime() - start;

        System.out.println("Bubblesort 1000: " + time);

        start = System.nanoTime();
        sortStringService.quickSortString(arrayString1000Q, 0, array1000Q.length - 1);
        time = System.nanoTime() - start;
        System.out.println("Quicksort 1000: " + time);

        start = System.nanoTime();
        sortStringService.insertionSortString(arrayString1000I);
        time = System.nanoTime() - start;
        System.out.println("InsertionSort 1000: " + time);

        start = System.nanoTime();
        sortStringService.selectionSorString(arrayString1000S);
        time = System.nanoTime() - start;
        System.out.println("SelectionSort 1000: " + time);

        start = System.nanoTime();
        sortStringService.mergeSortString(arrayString1000M, 0, array1000M.length - 1);
        time = System.nanoTime() - start;
        System.out.println("MergeSort 1000: " + time);

        System.out.println("--------------");
    }
}

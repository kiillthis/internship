package com.company;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class SortServiceTest {

    SortService s = new SortService();

    SortStringService ss = new SortStringService();

    int[] array10 = s.fillArray(10);
    int[] array50 = s.fillArray(50);
    int[] array500 = s.fillArray(500);
    int[] array1000 = s.fillArray(1000);

    StringBuilder s10 = ss.generateString(10);
    StringBuilder s50 = ss.generateString(10);
    StringBuilder s500 = ss.generateString(10);
    StringBuilder s1000 = ss.generateString(10);


    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void insertionSort10() {
        s.insertionSort(array10);
    }

    @Ignore
    @Test
    @Timeout(value = 700000, unit = TimeUnit.NANOSECONDS)
    void bubbleSort10() {
        s.bubbleSort(array10);
    }

    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void selectionSort10() {
        s.selectionSort(array10);
    }

    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void quickSort10() {
        s.quickSort(array10, 0, array10.length - 1);
    }

    @Test
    @Timeout(value = 600000, unit = TimeUnit.NANOSECONDS)
    void mergeSort10() {
        s.mergeSort(array10, 0, array10.length - 1);
    }

    /* 50 */
    @Test
    @Timeout(value = 300000, unit = TimeUnit.NANOSECONDS)
    void bubbleSort50() {
        s.bubbleSort(array50);
    }

    @Test
    @Timeout(value = 400000, unit = TimeUnit.NANOSECONDS)
    void insertionSort50() {
        s.insertionSort(array50);
    }

    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void selectionSort50() {
        s.selectionSort(array50);
    }

    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void quickSort50() {
        s.quickSort(array50, 0, array50.length - 1);
    }

    @Test
    @Timeout(value = 600000, unit = TimeUnit.NANOSECONDS)
    void mergeSort50() {
        s.mergeSort(array50, 0, array50.length - 1);
    }

    /* 500 */
    @Test
    @Timeout(value = 7500000, unit = TimeUnit.NANOSECONDS)
    void bubbleSort500() {
        s.bubbleSort(array500);
    }

    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void insertionSort500() {
        s.insertionSort(array500);
    }

    @Test
    @Timeout(value = 2000000, unit = TimeUnit.NANOSECONDS)
    void selectionSort500() {
        s.selectionSort(array500);
    }

    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void quickSort500() {
        s.quickSort(array500, 0, array500.length - 1);
    }

    @Test
    @Timeout(value = 600000, unit = TimeUnit.NANOSECONDS)
    void mergeSort500() {
        s.mergeSort(array500, 0, array500.length - 1);
    }
    /* 1000 */

    @Test
    @Timeout(value = 4000000, unit = TimeUnit.NANOSECONDS)
    void bubbleSort1000() {
        s.bubbleSort(array1000);
    }

    @Test
    @Timeout(value = 400000, unit = TimeUnit.NANOSECONDS)
    void insertionSort1000() {
        s.insertionSort(array1000);
    }

    @Test
    @Timeout(value = 6000000, unit = TimeUnit.NANOSECONDS)
    void selectionSort1000() {
        s.selectionSort(array1000);
    }

    @Test
    @Timeout(value = 1000000, unit = TimeUnit.NANOSECONDS)
    void quickSort1000() {
        s.quickSort(array1000, 0, array1000.length - 1);
    }

    @Test
    @Timeout(value = 8000000, unit = TimeUnit.NANOSECONDS)
    void mergeSort1000() {
        s.mergeSort(array1000, 0, array1000.length - 1);
    }

    /* strings */

    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void insertionSort10String() {
        ss.insertionSortString(s10);
    }

    @Ignore
    @Test
    @Timeout(value = 700000, unit = TimeUnit.NANOSECONDS)
    void bubbleSort10String() {
        ss.bubbleSortString(s10);
    }

    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void selectionSort10String() {
        ss.selectionSorString(s10);
    }

    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void quickSort10String() {
        ss.quickSortString(s10, 0, s10.length() - 1);
    }

    @Test
    @Timeout(value = 600000, unit = TimeUnit.NANOSECONDS)
    void mergeSort10String() {
        ss.mergeSortString(s10, 0, s10.length() - 1);
    }

    /* 50 */
    @Test
    @Timeout(value = 300000, unit = TimeUnit.NANOSECONDS)
    void bubbleSort50String() {
        ss.bubbleSortString(s50);
    }

    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void insertionSort50String() {
        ss.insertionSortString(s50);
    }

    @Test
    @Timeout(value = 3000000, unit = TimeUnit.NANOSECONDS)
    void selectionSort50String() {
        ss.selectionSorString(s50);
    }

    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void quickSort50String() {
        ss.quickSortString(s50, 0, s50.length() - 1);
    }

    @Test
    @Timeout(value = 600000, unit = TimeUnit.NANOSECONDS)
    void mergeSort50String() {
        ss.mergeSortString(s50, 0, s50.length() - 1);
    }

    /* 500 */
    @Test
    @Timeout(value = 3500000, unit = TimeUnit.NANOSECONDS)
    void bubbleSort500String() {
        ss.bubbleSortString(s500);
    }

    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void insertionSort500String() {
        ss.insertionSortString(s500);
    }

    @Test
    @Timeout(value = 2000000, unit = TimeUnit.NANOSECONDS)
    void selectionSort500String() {
        ss.selectionSorString(s500);
    }

    @Test
    @Timeout(value = 100000, unit = TimeUnit.NANOSECONDS)
    void quickSort500String() {
        ss.quickSortString(s500, 0, s500.length() - 1);
    }

    @Test
    @Timeout(value = 600000, unit = TimeUnit.NANOSECONDS)
    void mergeSort500String() {
        ss.mergeSortString(s500, 0, s500.length() - 1);
    }
    /* 1000 */

    @Test
    @Timeout(value = 4000000, unit = TimeUnit.NANOSECONDS)
    void bubbleSort1000String() {
        ss.bubbleSortString(s1000);
    }

    @Test
    @Timeout(value = 1000000, unit = TimeUnit.NANOSECONDS)
    void insertionSort1000String() {
        ss.insertionSortString(s1000);
    }

    @Test
    @Timeout(value = 2000000, unit = TimeUnit.NANOSECONDS)
    void selectionSort1000String() {
        ss.selectionSorString(s1000);
    }

    @Test
    @Timeout(value = 700000, unit = TimeUnit.NANOSECONDS)
    void quickSort1000String() {
        ss.quickSortString(s1000, 0, s1000.length() - 1);
    }

    @Test
    @Timeout(value = 4000000, unit = TimeUnit.NANOSECONDS)
    void mergeSort1000String() {
        ss.mergeSortString(s1000, 0, s1000.length() - 1);
    }
}
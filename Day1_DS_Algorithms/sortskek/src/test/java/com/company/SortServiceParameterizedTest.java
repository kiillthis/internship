package com.company;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class SortServiceParameterizedTest {

    final SortService s = new SortService();

    private static Object[] getDifferentBitness() {
        SortService s = new SortService();
        return new Object[] {
                new Object[] {s.fillArray(10)},
                new Object[] {s.fillArray(100)},
                new Object[] {s.fillArray(1000)},
                new Object[] {s.fillArray(10000)},
                new Object[] {s.fillArray(100000)},
        };
    }

    @Test
    @Parameters(method = "getDifferentBitness")
    public void bubbleSort(int[] arrays) {
        long start = System.nanoTime();
        s.bubbleSort(arrays);
        long time = System.nanoTime() - start;
        System.out.println("BubbleSort: " + time);
    }

    @Test
    @Parameters(method = "getDifferentBitness")
    public void insertionSort(int[] arrays) {
        long start = System.nanoTime();
        s.insertionSort(arrays);
        long time = System.nanoTime() - start;
        System.out.println("InsertionSort: " + time);
    }

    @Test
    @Parameters(method = "getDifferentBitness")
    public void selectionSort(int[] arrays) {
        long start = System.nanoTime();
        s.selectionSort(arrays);
        long time = System.nanoTime() - start;
        System.out.println("SelectionSort: " + time);
    }

    @Test
    @Parameters(method = "getDifferentBitness")
    public void quickSort(int[] arrays) {
        long start = System.nanoTime();
        s.quickSort(arrays, 0, arrays.length - 1);
        long time = System.nanoTime() - start;
        System.out.println("QuickSort: " + time);
    }

    @Test
    @Parameters(method = "getDifferentBitness")
    public void mergeSort(int[] arrays) {
        long start = System.nanoTime();
        s.mergeSort(arrays, 0, arrays.length - 1);
        long time = System.nanoTime() - start;
        System.out.println("MergeSort: " + time);
    }
}
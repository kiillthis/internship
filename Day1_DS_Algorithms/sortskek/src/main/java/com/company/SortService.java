package com.company;

public class SortService {

    public SortService() {
    }

    public int[] fillArray(int size) {

        int[] a = new int[size];

        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
        }

        return a;
    }

    public void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public void insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int current = a[i];
            int j = i - 1;

            while (j >= 0 && current < a[j]) {
                a[j + 1] = a[i];
                j--;
            }

            a[j + 1] = current;
        }
    }

    public void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int minId = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minId = j;
                }
            }

            int temp = a[i];
            a[i] = min;
            a[minId] = temp;
        }
    }

    public void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);

    }

    public void mergeSort(int[] array, int low, int high) {
        if (high <= low) return;

        int mid = (low+high)/2;
        mergeSort(array, low, mid);
        mergeSort(array, mid+1, high);
        merge(array, low, mid, high);
    }



    private int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    private void merge(int[] array, int low, int mid, int high) {

        int leftArray[] = new int[mid - low + 1];
        int rightArray[] = new int[high - mid];

        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = array[low + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = low; i < high + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}

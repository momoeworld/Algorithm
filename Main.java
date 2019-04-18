package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] arr = {9, 6, 7, 6, 5, 4, 6, 2, 9};

        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort (int[] unsorted, int start, int end) {
        if (start >= end) {
            return;
        }
        int less = start;
        int more = end;
        int key = start;
        int pivot = unsorted[start];
        int temp;
        while (key <= more && key >= less) {
            if (unsorted[key] > pivot) {
                temp = unsorted[key];
                unsorted[key] = unsorted[more];
                unsorted[more] = temp;
                key = --more;
            } else if (unsorted[key] < pivot) {
                temp = unsorted[key];
                unsorted[key] = unsorted[less];
                unsorted[less] = temp;
                key = ++less;
            } else {
                if (key == more) {
                    while (key >= less && unsorted[key] == pivot) key--;
                } else {
                    while (key <= more && unsorted[key] == pivot) key++;
                }
            }
            quickSort(unsorted, start, less - 1);
            quickSort(unsorted, more + 1, end);
        }
    }
}

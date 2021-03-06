package com.interviewbit.binarysearch;

import java.util.Arrays;
import java.util.List;

/*
There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3
NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.

For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5
 */

public class MedianOfArray {

    public static void main(String[] args) {

        MedianOfArray obj = new MedianOfArray();
        List<Integer> a = Arrays.asList(0, 23);
        List<Integer> b = Arrays.asList();
        System.out.println(obj.findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        int m = a.size();
        int n = b.size();
        int min;
        int max;

        if (m == 0) {
            min = b.get(0);
            max = b.get(n - 1);
        } else if (n == 0) {
            min = a.get(0);
            max = a.get(m - 1);
        } else {
            min = Math.min(a.get(0), b.get(0));
            max = Math.max(a.get(m - 1), b.get(n - 1));
        }

        int req = (m + n) / 2;
        double first = getNumber(a, b, min, max, req);

        if ((m + n) % 2 != 0) {
            return first;
        } else {
            double second = getNumber(a, b, min, max, req - 1);
            return (first + second) / 2;
        }

    }

    private double getNumber(List<Integer> a, List<Integer> b, int min, int max, int req) {

        int m = a.size();
        int n = b.size();

        while (min <= max) {

            int mid = min + (max - min) / 2;

            int c1 = getSmallerNumberCount(a, mid);
            int c2 = getSmallerNumberCount(b, mid);

            while (c1 < m && a.get(c1) == mid) c1++;
            while (c2 < n && b.get(c2) == mid) c2++;

            int place = c1 + c2;

            if (place > req)
                max = mid - 1;
            else
                min = mid + 1;
        }

        return min;
    }

    public int getSmallerNumberCount(List<Integer> list, int item) {

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (list.get(mid) < item) {
                low = mid + 1;
            } else if (list.get(mid) > item) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}

/*
TODO Need to see how this one works.
 */

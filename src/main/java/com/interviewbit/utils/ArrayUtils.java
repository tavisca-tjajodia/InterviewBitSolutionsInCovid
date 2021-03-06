package com.interviewbit.utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for( int x : arr){
            System.out.print(x + ", ");
        }
        System.out.println("]");
    }

    public static ArrayList<Character> getCharacterListFromString(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character ch : str.toCharArray()){
            list.add(ch);
        }

        return list;
    }

    public static void printArray(long[] arr) {
        System.out.print("[ ");
        for( long x : arr){
            System.out.print(x + ", ");
        }
        System.out.println("]");
    }

    public static void printArray(int[][] arr){
        for(int i = 0 ; i < arr.length; i++){
            System.out.print("[\t");
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println("]\t");
        }
    }

    public static void printArray(boolean[][] arr){
        for(int i = 0 ; i < arr.length; i++){
            System.out.print("[\t");
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println("]\t");
        }
    }

    public static<T> void printArray(T[] t){
        for( T x : t){
            System.out.println(x);
        }
    }

    public static<T extends List> void printCollection(T t){
        t.forEach(System.out::println);
    }

    public static ArrayList<Integer> asArrayList(Integer ...args){
        ArrayList<Integer> list = new ArrayList<>();
        for(int item : args){
            list.add(item);
        }
        return list;
    }

    public static int[] asArrays(int ...args){
        return args;
    }

    public static <T> ArrayList<T> asArrayList(T ...args){
        ArrayList<T> list = new ArrayList<>();
        for(T item : args){
            list.add(item);
        }
        return list;
    }


}

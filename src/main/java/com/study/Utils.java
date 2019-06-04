package com.study;

public class Utils {
    public static int[] getIntArr(int min,int max,int length){
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            int c = (int) ((Math.random()*1000) % (max - min +1) +min);
            a[i] = c;
        }
        return a;
    }
}

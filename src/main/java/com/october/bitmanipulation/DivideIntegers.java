package com.october.bitmanipulation;

public class DivideIntegers {

    public static void main(String[] args) {

        DivideIntegers obj = new DivideIntegers();
        System.out.println(obj.divide(-2147483648,-1));
    }

    public int divide(int A, int B) {

        int sign = (A < 0) ^ (B < 0) ? -1 : 1;
        long divident = Math.abs((long)A);
        long divisor = Math.abs((long)B);

        int i = 32;
        long result = 0;

        while(i >= 0){
            if( (divisor << i) <= divident){
                result = result | ( 1L << i );
                divident = divident - (divisor << i);
            }
            i--;
        }

        return (result * sign) > Integer.MAX_VALUE
                ? Integer.MAX_VALUE : (int)(result * sign);

    }
}

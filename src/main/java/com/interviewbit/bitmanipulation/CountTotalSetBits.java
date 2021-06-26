package com.interviewbit.bitmanipulation;


/*
Problem Description

Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.

Return the count modulo 109 + 7.



Problem Constraints
1 <= A <= 109



Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.



Example Input
Input 1:

 A = 3
Input 2:

 A = 1


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 DECIMAL    BINARY  SET BIT COUNT
    1          01        1
    2          10        1
    3          11        2
 1 + 1 + 2 = 4
 Answer = 4 % 1000000007 = 4
Explanation 2:

 A = 1
  DECIMAL    BINARY  SET BIT COUNT
    1          01        1
 Answer = 1 % 1000000007 = 1
 */
// YOU MIGHT NEED TO VISIT THIS CHECKAGAIN
public class CountTotalSetBits {

    public static void main(String[] args) {
        CountTotalSetBits obj = new CountTotalSetBits();
        System.out.println(obj.solve(2147483645));
    }

    public int solve(int A) {
        if (A == 1) {
            return 1;
        }
        A++;
        int MOD = 1000000007;
        int count = 0;
        int i = 2;

        while (A / (i / 2) > 0) {
            int fullPair = A / i;
            int numOf1InEachPair = i / 2;
            count = (count + fullPair * numOf1InEachPair) % MOD;

            int remainder = A % i;
            int rem = (remainder > i / 2) ? (remainder % (i / 2)) : 0;
            count = (count + rem) % MOD;

            i = i * 2;
        }
        return (count % MOD);
    }
}

/*
        This Question is Amazing.
        Look the Copy for Explanation.

 */
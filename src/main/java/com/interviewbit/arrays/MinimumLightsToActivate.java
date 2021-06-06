package com.interviewbit.arrays;

/*
Asked in:
Directi
Problem Description

There is a corridor in a Jail which is N units long. Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.

All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].

Initially all lights are off.

Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.



Problem Constraints
1 <= N <= 1000

1 <= B <= 1000



Input Format
First argument is an integer array A where A[i] is either 0 or 1.

Second argument is an integer B.



Output Format
Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.


Example Input
Input 1:

A = [ 0, 0, 1, 1, 1, 0, 0, 1].
B = 3
Input 2:

A = [ 0, 0, 0, 1, 0].
B = 3


Example Output
Output 1:

2
Output 2:

-1


Example Explanation
Explanation 1:

In the first configuration, Turn on the lights at 3rd and 8th index.
Light at 3rd index covers from [ 1, 5] and light at 8th index covers [ 6, 8].
Explanation 2:

In the second configuration, there is no light which can light the first corridor.
 */
public class MinimumLightsToActivate {

    public static void main(String[] args) {

    }

    public int solve(int[] A, int B) {
        int n = A.length;  // Length of the Array given
        int i = Math.min(B - 1, n - 1); // i plays very crucial role here. We don't want to iterate from 0, we directly jump to B position or nth Position
        int cnt = 0;        // The idea is that if the light at Bth position is lighten then it will lighten up the corridor from 0th till Bth.


        while (i >= 0) {
            if (A[i] == 1) {  // If A[i] == 1 then we will update the count and then jump to next highest(rightest) element possible to start check if that
                cnt++;        // That can be lighten up. Being Greedy.
                A[i] = 2;     // This we will discuss in a minute. in else if part.
                i += B;       // if we lighten up i then corridor will be lighten up till (i + B - 1) so directly jumping.

                if (i >= n)   // Checking Base condition.
                    break;

                i = Math.min(n - 1, i + B - 1);  //  This is similar to the one we used in the starting line. Jumping B index from ith Index to see.
            }
            else if (A[i] == 2)  // Read Else part first. If we keep decreasing i and then at last if we come to a index where we have already lighten up the
                break;           // The light it means that the corridor cannot be lighten up and we need to return -1;
            else       //  If this particular A[i] is not 1 then we keep decreasing i. so see which rightmost light can be lighten.
                i--;
        }

        if (i < n - 1)   // If the Corridor cannot be lighten up then we are going to return -1. It comes when either or the else or else if part sends the control
            return -1;

        return cnt;  // Final Returning Part.
    }
}

/*

        Minimum Lights to Activate
    Problem Description
        There is a corridor in a Jail which is N units long.
        Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.
        All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].
        Initially all lights are off.
        Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.


    This is the hardest Answer to understand or think. Even after looking at the answer I was not able to comprehend.
    The Idea behind the Solution is to find the right most element in the array that can be light up to brighten the current
    index. If we use Greedy Algorithm from starting and then we keep moving, at the end we will end up finding the
    count require the lighten up the entire corridor.


    ==========================================
    Notes. 2.
    Why is i += B in line number 81 and not i += B - 1.
    it is because the lights will be lighted up to i += B - 1
    and not we are considering fresh start from i += Bth Index.


 */
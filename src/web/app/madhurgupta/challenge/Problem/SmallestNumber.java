package web.app.madhurgupta.challenge.Problem;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 15-06-2022 01:06
*/

/*
Find the smallest number whose digits multiply to a given number n
Input:  n = 36
Output: p = 49 
// Note that 4*9 = 36 and 49 is the smallest such number

Input:  n = 100
Output: p = 455
// Note that 4*5*5 = 100 and 455 is the smallest such number

Input: n = 1
Output:p = 11
// Note that 1*1 = 1

Input: n = 13
Output: Not Possible

https://www.geeksforgeeks.org/find-smallest-number-whose-digits-multiply-given-number-n/
*/

public class SmallestNumber {
    // Driver program
    public static void main(String[] args) {
        findSmallest(7);
        findSmallest(36);
        findSmallest(13);
        findSmallest(100);
    }

    // digits multiply to n
    static void findSmallest(int n) {
        int i, j = 0;
        int MAX = 50;
        // To store digits of result in reverse order
        int[] res = new int[MAX];

        // Case 1: If number is smaller than 10
        if (n < 10) {
            System.out.println(n + 10);
            return;
        }

        // Case 2: Start with 9 and try every possible digit
        for (i = 9; i > 1; i--) {
            // If current digit divides n, then store all
            // occurrences of current digit in res
            while (n % i == 0) {
                n = n / i;
                res[j] = i;
                j++;
            }
        }

        // If n could not be broken in form of digits (prime factors of n
        // are greater than 9)
        if (n > 10) {
            System.out.println("Not possible");
            return;
        }

        // Print the result array in reverse order
        for (i = j - 1; i >= 0; i--)
            System.out.print(res[i]);
        System.out.println();
    }
}

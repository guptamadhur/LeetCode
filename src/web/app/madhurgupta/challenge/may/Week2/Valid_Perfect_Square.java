package web.app.madhurgupta.challenge.may.Week2;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 10-05-2020 05:29
*/

public class Valid_Perfect_Square {
    public static void main(String[] args) {
        Valid_Perfect_Square ob = new Valid_Perfect_Square();
        System.out.println(ob.isPerfectSquare(16));
    }

    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;
        long start =2, end=num/2;
        while(start <=end){
            long mid = (start + (end-start)/2);
            long n = mid *mid;
            if(n == num){
                return true;
            }else if(n < num ){
                start =mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
}

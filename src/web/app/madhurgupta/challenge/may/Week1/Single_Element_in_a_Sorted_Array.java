package web.app.madhurgupta.challenge.may.Week1;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 13-05-2020 02:31
*/

public class Single_Element_in_a_Sorted_Array {
    public static void main(String[] args) {
        Single_Element_in_a_Sorted_Array ob = new Single_Element_in_a_Sorted_Array();
        int[] list = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] list1 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(ob.singleNonDuplicate(list));
        System.out.println(ob.singleNonDuplicate(list1));
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + (right - left) / 2);
            if (nums[mid - 1] == nums[mid]) {
                boolean isEven = ((right - mid) % 2 == 0);
                if (isEven) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                boolean isEven = ((right - mid + 1) % 2 == 0);
                if (isEven) {
                    right = mid - 1;
                } else {
                    left = mid + 2;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}
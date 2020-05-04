package web.app.madhurgupta.challenge.Algorithms;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 05-05-2020 02:57
*/

/*
    Input: candies = [2,3,5,1,3], extraCandies = 3
    Output: [true,true,true,false,true]
*/

import java.util.ArrayList;
import java.util.List;

public class Kids_With_the_Greatest_Number_of_Candies {
    public static void main(String[] args) {
        Kids_With_the_Greatest_Number_of_Candies ob =new Kids_With_the_Greatest_Number_of_Candies();
        int []list = {2,3,5,1,3};
        System.out.println(ob.kidsWithCandies(list,3));
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = candies[0];
        int index = 0;
        for(int i=1; i<candies.length;i++){
            if(max < candies[i]){
                max=candies[i];
                index = i;
            }
        }
        for(int i=0; i<candies.length;i++){
            int stu = candies[i] + extraCandies;
            if(stu >=max){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        return list;
    }
}

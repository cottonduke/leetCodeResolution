package com.cotton.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuke
 * @date 2019-06-08 18:56
 */
public class TwoSum {

    public static void main (String [] args){
        int [] nums={3,1,3};
        int[] ints = twoSum1(nums, 6);
        System.out.println(ints[0]+"=="+ints[1]);

    }
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {

            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("no two sum resolution");
}
}

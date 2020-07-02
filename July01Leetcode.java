/*
 
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 
 Example:
	
	Given nums = [2, 7, 11, 15], target = 9,
	
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1]
 
 */

package com.saqeeb.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class July01Leetcode {

	public static void main(String[] args) {
		Solution ob = new Solution();
		int target = -4;
//		int[] result = ob.twoSum(new int[]{1, 3, 0, 5, 6, 14}, target);
		int[] result = ob.twoSumOptimal(new int[]{-1, 1, 3, 0, 5, 6, 14, 0, 3, -1, -3}, target);
		if(result != null) {
			System.out.println("Result = "+result[0]+", "+result[1]);
		} else {
			System.out.println("Solutions does not exists for "+target);
		}
	}

}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int result[] = new int[2];
        numbers.forEach(n -> {
        		int diff = target - n;
            	if(numbers.contains(diff)) {
            		int index0 = numbers.indexOf(n);
            		int index1 = numbers.lastIndexOf(diff);
            		if(index0 != index1) {
            			result[0] = index0;
                		result[1] = index1;
            		}
            	}
        });
        return result;
    
    }
    
    public int[] twoSumOptimal(int[] nums, int target) {
    	int result[] = null;
    	Map<Integer, Integer> lookupMap = new HashMap<>();
    	for(int i=0; i<nums.length; ++i) {
    		lookupMap.put(nums[i], i);
    	}
    	
    	for(int i=0; i<nums.length; ++i) {
    		int diff = target-nums[i];
    		if(lookupMap.containsKey(diff) && lookupMap.get(diff) != i) {
    			result = new int[] {i, lookupMap.get(diff)};
    		}
    	}
    	return result;
    }
}
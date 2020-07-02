package com.saqeeb.leetcode;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement :: Given a non-empty array of integers, every element appears twice except for one. 
 * Find that single one.
 * 
 * Eg 1 
 *  Input: [2,2,1]
	Output: 1
 *
 *Eg 2
 *  Input: [4,1,2,1,2]
	Output: 4
	
 * @author saqeebs
 *
 */
public class SingleNumber {

	public static void main(String[] args) {
		int number = new Solution().singleNumber(new int[]{4,1,2,2, 4, 2});
		if(number >=0) {
			System.out.println("Result = "+number);
		} else {
			System.out.println("Not found!");
		}

	}
	
	static class Solution {
	    public int singleNumber(int[] nums) {
	        Map<Integer, Integer> countMap = new HashMap<>();
	        for(int n : nums) {
	            if(! countMap.containsKey(n)) {
	            	countMap.put(n, 1);
	            } else {
	            	countMap.put(n, countMap.get(n)+1);
	            }
	        }
	        
	        for(int k : countMap.keySet()) {
	        	
	        	if(countMap.get(k) == 1) {
	        		return k;
	        	}
	        }
	        return -1;
	    }
	}

}

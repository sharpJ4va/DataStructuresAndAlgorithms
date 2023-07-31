package com.sharp.hashandqueue.n数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode1.给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 方法 ： 创建一个哈希表，对于每一个 x，首先查询哈希表中是否存在 target - x，
 *  然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashtable = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < nums.length; i++){
            if(hashtable.containsKey(target - nums[i])){
                return new int[]{hashtable.get(target - nums[i]),i};
            }
            hashtable.put(nums[i],i);
        }
        return new int[0];
    }
}

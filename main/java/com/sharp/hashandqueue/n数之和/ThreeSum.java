package com.sharp.hashandqueue.n数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * LeetCode15
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。注意：答案中不可以包含重复的三元组。
 * 示例1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 先将数组排序来处理重复结果，然后固定一位元素
 * 由于数组是排好序的，所以用双指针来不断寻找即可求解
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // 枚举 a
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int first = 0 ; first < n ; ++first){
            // 需要和上一次枚举的数不相同
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for(int second = first + 1;second < n; ++second){
                // 需要和上一次枚举的数不相同
                if(second > first + 1 && nums[second] == nums[second-1]){
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while(second<third && nums[second] + nums[third]>target){
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if(second == third){
                    break;
                }
                if(nums[second]+nums[third] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

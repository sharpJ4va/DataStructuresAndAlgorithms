package com.sharp.array.双指针专题;

import java.util.ArrayList;
import java.util.List;

/**
 * 双指针专题
 */
public class DoublyPointer {
    /**
     * 原地移除所有数值等于 val 的元素
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * 方法 1 ： 快慢双指针
     * 定义两个指针slow和fast，初始值都是0。
     * slow之前的位置都是有效部分，fast表示当前要访问的元素。
     * 这样遍历的时候，fast不断向后移动：
     * 如果nums[fast]的值不为val，则将其移动到nums[slow++]处。
     * 如果nums[fast]的值为val，则fast继续向前移动，slow先等待
     * 前半部分是有效部分，后半部分是无效部分
     * @param nums
     * @param val
     * @return
     */
//    public int removeElement(int[] nums, int val) {
//        int slow = 0;
//        for(int fast = 0 ; fast < nums.length ; fast++){
//            if(nums[fast] != val){
//                nums[slow] = nums[fast];
//                slow++;
//            }
//        }
//        return slow;
//    }

    /**
     * 原地移除所有数值等于 val 的元素
     * 方法 2 ： 对撞双指针
     * 从右侧找不是val的值来顶替左侧是val的值
     * @param nums
     * @param val
     * @return
     */
//    public int removeElement(int[] nums, int val) {
//        int left = 0 ;
//        int right = nums.length -1 ;
//        for(;left <= right;){
//            if(nums[left] == val && nums[right] != val){
//                int temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
//            }
//            if(nums[left] != val) left++;
//            if(nums[right] == val) right--;
//        }
//        return left;
//    }

    /**
     * 原地移除所有数值等于 val 的元素
     * 方法 3 ：对撞双指针 + 覆盖
     * 当循环到 nums[left] == val 就让right往左移 1 ，继续循环判断 nums[left] 是否为 val
     * 不为val时才让left向右移 1
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0 ;
        int right = nums.length -1 ;
        for(;left <= right;){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }else{
                left++;
            }
        }
        return right + 1;
    }

    /**
     * 删除有序数组中的重复项
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素只出现一次，
     * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
     * 方法 ： 双指针
     * 一个指针负责数组遍历，一个指向有效数组的最后一个位置
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        //slow表示可以放入新元素的位置，索引为0的元素不用管
        int slow = 1;
        for(int fast = 1; fast < nums.length; fast++){
            if(nums[fast] != nums[slow-1]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 按奇偶排序数组
     * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
     * 返回满足此条件的 任一 数组 作为答案。
     * 方法 ：对撞双指针
     * ★对撞双指针解题模板
     * 从右侧找不是偶数的值来和左侧是奇数的值交换
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        int right = nums.length-1;
        int left = 0;
        while(left < right){
            if(nums[left]%2 > nums[right]%2){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if(nums[left]%2 ==0) left++;
            if(nums[right]%2 ==1) right--;
        }
        return nums;
    }

    /**
     * 轮转数组
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     * 方法 ： 两轮翻转
     * 首先对整个数组实行翻转，例如 [1,2,3,4,5,6,7] 我们先将其整体翻转成[7,6,5,4,3,2,1]。
     * 从 k 处分隔成左右两个部分，这里就是根据k将其分成两组 [7,6,5] 和[4,3,2,1]。
     * 最后将两个再次翻转就得到[5,6,7] 和[1,2,3,4]，最终结果就是[5,6,7,1,2,3,4]
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    //-----------------------------------------------

    /**
     *  数组的区间
     *  汇总区间
     *  给定一个  无重复元素 的 有序 整数数组 nums 。
     *  返回 恰好覆盖数组中所有数字 的 最小有序 区间 范围列表 。也就是说，nums 的每个元素都恰好被某个区间 范围所覆盖，
     *  并且不存在属于某个范围但不属于 nums 的数字 x 。
     *  列表中的每个 区间 范围 [a,b] 应该按如下格式输出：
     *  "a->b" ，如果 a != b
     *  "a" ，如果 a == b
     *  方法 ： 双指针
     *  慢指针指向每个区间的起始位置，快指针从慢指针位置开始向后遍历直到不满足连续递增（或快指针达到数组边界），
     *  则当前区间结束；然后将 slow指向更新为 fast + 1，作为下一个区间的开始位置，fast继续向后遍历找下一个区间的结束位置，
     *  如此循环，直到输入数组遍历完毕。
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int slow = 0;
        for(int fast = 0;fast < nums.length;fast++){
            if(fast+1 == nums.length || nums[fast]+1 != nums[fast+1]){
                StringBuilder sb = new StringBuilder();
                sb.append(nums[slow]);
                if(slow != fast){
                    sb.append("->").append(nums[fast]);
                }
                res.add(sb.toString());
                slow = fast + 1;
            }
        }
        return res;
    }

    /**
     * 字符串替换空格问题
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * 方法 ：双指针
     * 先遍历一次字符串，这样可以统计出字符串中空格的总数，由此计算出替换之后字符串的长度，
     * 每替换一个空格，长度增加2，即替换之后的字符串长度为:
     * 新串的长度=原来的长度+2*空格数目
     * 接下来从字符串的尾部开始复制和替换，用两个指针fast和slow分别指向原始字符串和新字符串的末尾，
     * 然后：slow不动，向前移动fast：
     * 若指向的不是空格，则将其复制到slow位置，然后fast和slow同时向前一步；
     * 若fast指向的是空格，则在slow位置插入一个%20，fast则只移动一步。
     * 循环执行上面两步，便可以完成替换
     * @param str
     * @return
     */
//如果长度不可变，必须新申请一个更大的空间，然后将原始数组中出现空格的位置直接替换成%20即可
//    public String replaceSpace(StringBuffer str) {
//        String res="";
//        for(int i=0;i<str.length();i++){
//            char c=str.charAt(i);
//            if(c==' ')
//                res += "%20";
//            else
//                res += c;
//        }
//        return res;
//    }

    public  String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        int numOfblank = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ')
                numOfblank++;
        }
        str.setLength(len + 2 * numOfblank);
        int fast = len - 1;
        int slow = (len + 2 * numOfblank) - 1;

        while (fast >= 0 && slow > fast) {
            char c = str.charAt(fast);
            if (c == ' ') {
                fast--;
                str.setCharAt(slow--, '0');
                str.setCharAt(slow--, '2');
                str.setCharAt(slow--, '%');
            } else {
                str.setCharAt(slow, c);
                fast--;
                slow--;
            }
        }
        return str.toString();
    }
}

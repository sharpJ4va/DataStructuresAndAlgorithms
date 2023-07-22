package com.sharp.array.数组基础;

public class ArrayBasic {
    int[] arr = new int[10];
    int[] arr1 = new int[]{0,1,2,3,5,6,8};
    int[] nums = {2,5,0,4,-10,6};

    public static  int findByElement(int[] arr, int size , int key){
        for(int i = 0 ; i < size ; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    /**
     * 增加一个元素
     * 先找位置，再将其后元素整体右移，最后插入空位上
     * @param arr
     * @param size 数组已存入元素的数量，从 1 编号
     * @param element 待插入元素
     * @return 返回插入位置下标
     */
    public static  int addByElementSequence(int[] arr,int size,int element){
        if(size >= arr.length){
            return -1;
        }
        int index = size;
        for(int i = 0 ; i < size ; i++){
            if(element < arr [i]){
                index = i;
                break;
            }
            for (int j = size ; j > index ; j--){
                arr[j] = arr[j -1];
            }
            arr[index] = element;
        }
        return index;
    }

    /**
     * 从数组中删除元素key
     * 找到要删除的位置后，其后的所有元素都往前移动，将其覆盖，并减少数组长度
     * @param arr 数组
     * @param size 数组中元素个数
     * @param key 删除的目标值
     * @return
     */
    public static int removeByElement(int[] arr,int size,int key){
        int index = -1;
        for (int i = 0 ; i < size; i++){
            if(arr[i] == key) {
                index = i;
                break;
            }
        }
        if(index != -1){
            for(int i = index + 1; i < size ; i++){
                arr[i -1] = arr[i];
            }
            size--;

        }
        return size;
    }

    /**
     * 数组是否单调
     * @param nums
     * @return
     */
//    public boolean isMonotonic(int[] nums) {
//        return isSorted(nums,true) || isSorted(nums,false);
//    }
//    public boolean isSorted(int[] nums,boolean increasing){
//        int len = nums.length;
//        for(int i = 0 ; i < len - 1 ; i++){
//            if(increasing){
//                if(nums[i] > nums[i+1]){
//                    return false;
//                }
//            }else{
//                if(nums[i] < nums[i+1]){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
    // -----------------------------------------------
    //优化后
    public  boolean isMonotonic(int[] nums){
        boolean inc = true, dec = true;
        int len = nums.length;
        for(int i = 0 ; i < len - 1 ; i++){
            if(nums[i] < nums[i+1])
                dec = false;
            if(nums[i] > nums[i+1])
                inc = false;
        }
        return dec || inc;
    }

    /**
     * 合并两个有序数组
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     * 方法 ： 每次都找最大的那个从后向前填
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int index1 = m - 1, index2 = n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] <= nums2[index2]) {
                nums1[i--] = nums2[index2--];
            } else {
                nums1[i--] = nums1[index1--];
            }
        }
        while (index1 != -1) nums1[i--] = nums1[index1--];
        while (index2 != -1) nums1[i--] = nums2[index2--];
    }
        public static void main(String[] args) {

    }






















}

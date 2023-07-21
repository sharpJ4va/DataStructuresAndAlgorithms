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
    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] arr1 = new int[]{0,1,2,3,5,6,8};
        int[] nums = {2,5,0,4,-10,6};

    }






















}

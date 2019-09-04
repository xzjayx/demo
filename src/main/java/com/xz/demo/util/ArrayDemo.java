package com.xz.demo.util;

public class ArrayDemo {
    private String[] strArray;

    //数据元数个数
    private int length = 0;       //数组元素个数

    public ArrayDemo(int max){
        strArray = new String[max];
    }

    //检测数组是否包含某个元素 如何有返回改位置，如果没有返回-1;
    public int contains(String element){
        int index = -1;
        for (int i = 0;i<length; i++){
            if(strArray[i].equals(element)){
                index = i;
                break;
            }
        }
        return index;
    }



    /**
     * 二分法查找 通过给定数的数值，查出所在的位置
     * @param target 数字
     * */
    private static int binarySearch(int target,int[] array){
          int min,mid,max;
          min = 0;
          max = array.length-1;
          if(max < 0){
              return -1;
          }
          while(true){
              mid = (min+max)/2;
              //进行二分法查找
              if(target == array[mid]){
                    return mid;
              } else if(target < array[mid]){
                  //则目标值在中间值的前半段，所以开始下标不变，开始下标向前移动一位 则 max = mid -1；
                  max = mid -1;
              }else if(target > array[mid]){
                  //则目标值在中间值的后半段，所以最大下标不变，开始下标向后移动一位 则min = mid +1;
                  min = mid +1;
              }else if(max<min){
                  return -1;
              }
          }
    }

    public static void main(String[] args) {
        int[] array = {1,42,45,76,435,75667};
        System.out.println(binarySearch(76,array));
    }


}

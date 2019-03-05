package com.gxf.test;

import com.gxf.util.ArrayUtil;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/22 5:03 PM
 **/
public class TopK {

  public static void main(String[] args){
//    int[] nums = {10, 8, 5, 12, 9};
//    int res = topMinK(nums, 5);
//    System.out.println(res);
    testTreeMap();
  }


  public static void testTreeMap() {
    TreeMap<Integer, Integer> intContainer = new TreeMap<>();
    intContainer.put(10, 10);
    intContainer.put(14, 14);
    intContainer.put(21, 21);
    intContainer.put(11, 11);
    System.out.println(intContainer.higherKey(10));
  }

  /**
   * 最小的低k个数
   * 1. 建一个大根堆
   * 2. 如果比1个元素大，和第一个元素交换，调整堆
   * 3. 返回堆顶元素，即第一个元素
   * */
  private static int topMinK(int[] nums, int k) {
    buildMaxHeap(nums, k);
    for (int i = k + 1; i <= nums.length; i++) {
      if(nums[i - 1] < nums[0]) {
        nums[0] = nums[i - 1];
        downAdjust(nums, 1, k);
      }
    }
    return nums[0];
  }

  public static void heapSort(int[] nums) {
    buildMaxHeap(nums, nums.length);
    System.out.println("after build heap:");
    ArrayUtil.printIntArray(nums);
    for (int i = nums.length; i > 1; i--) {
      int temp = nums[i - 1];
      nums[i - 1] = nums[0];
      nums[0] = temp;
      downAdjust(nums, 1, i - 1);
    }
  }

  //10 8 5 12 9
  private static void buildMaxHeap(int[] nums, int end) {
    for (int i = end; i >= 1; i--) {
      downAdjust(nums, i, end);
    }
  }
  private static void downAdjust(int[] nums, int j, int end) {
      while (j * 2 <= end) {
        int maxIndex = j;
        maxIndex = j * 2 <= end && nums[j - 1] < nums[j * 2 - 1] ? j * 2 : maxIndex;
        maxIndex = j * 2 + 1 <= end && nums[maxIndex - 1] < nums[j * 2] ? j * 2 + 1 : maxIndex;
        if (maxIndex != j) {
          int temp = nums[maxIndex - 1];
          nums[maxIndex - 1] = nums[j - 1];
          nums[j - 1] = temp;
          j = maxIndex;
        } //if
        j = j * 2;
      } //while
  }

}

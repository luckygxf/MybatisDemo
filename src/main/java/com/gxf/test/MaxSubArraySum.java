package com.gxf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/21 10:07 AM
 **/
public class MaxSubArraySum {
  private static List<int[]> allPermutation = new ArrayList<>();

  public static void main(String[] args) {
//    int[] array = {4, -4, 9, 1};
    int[] array = {1, 2, 3};
    permutation(array, 0);
    printListIntArray(allPermutation);
  }

  public static int maxSum(int[] array) {
    if(array == null || array.length == 0)
      return 0;
    if (array.length == 1)
      return array[0];
    int[] sum = new int[array.length];
    sum[0] = array[0];
    for (int i = 1; i < array.length; i++) {
      sum[i] = Math.max(array[i], array[i] + sum[i - 1]);
    }
    return sum[sum.length - 1];
  }

  private static void permutation(int[] nums, int index) {
    if (index == nums.length) {
      int[] onePermutation =Arrays.copyOf(nums, nums.length);
      allPermutation.add(onePermutation);
    } else {
      for (int i = index; i < nums.length; i++) {
        swap(nums, index, i);
        permutation(nums, index + 1);
        swap(nums, index, i);
      } //for
    } //else
  } //permutation

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private static void printListIntArray(List<int[]> arrays) {
    for (int[] nums : arrays) {
      for (int num : nums) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }
}

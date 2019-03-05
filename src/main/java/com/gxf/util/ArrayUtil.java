package com.gxf.util;

import java.util.List;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/10 1:14 PM
 **/
public class ArrayUtil {

  public static void printTwoDeminIntList(List<List<Integer>> list) {
    for (List<Integer> integerList : list) {
      for (int n : integerList) {
        System.out.print(n + " ");
      }
      System.out.println();
    }
  }

  public static void printCharArray(char[][] chars) {
    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < chars[0].length; j++) {
        System.out.print(chars[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void printTwoDeminIntArray(int[][] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[0].length; j++) {
        System.out.print(nums[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void printList(List list){
    for(int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + " ");
    }
    System.out.println();
  }

  public static void printIntArray(int[] arrray){
    for(int i = 0; i < arrray.length; i++){
      System.out.print(arrray[i] + " ");
    }
    System.out.println();
  }
}

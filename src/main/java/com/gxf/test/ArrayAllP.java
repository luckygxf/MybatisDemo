package com.gxf.test;

import com.gxf.util.ArrayUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/2/12 7:23 PM
 **/
public class ArrayAllP {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    ArrayUtil.printTwoDeminIntList(getRes(nums, 0, nums.length - 1));
  }

  public static List<List<Integer>> getRes(int[] nums, int start, int end) {
    if (start == end) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> element = new ArrayList<>();
      element.add(nums[start]);
      res.add(element);
      return res;
    } //if
    List<List<Integer>> res = new ArrayList<>();
    for (int i = start; i <= end; i++) {
      swap(nums, i, start);
      List<List<Integer>> subRes = getRes(nums, start + 1, end);
      for (List<Integer> eleList : subRes) {
        eleList.add(0, nums[start]);
      } //for
      res.addAll(subRes);
      swap(nums, i, start);
    } //for
    return res;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

package com.gxf.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/2/6 9:20 PM
 **/
public class MyCalendar {
  private List<int[]> points = new ArrayList<>();

  public MyCalendar() {

  }

  public boolean book(int start, int end) {
    for (int[] point : points) {
      if (!(end <= point[0] || start >= point[1])) {
        return false;
      }
    } //for
    points.add(new int[]{start, end});
    return true;
  }
}
